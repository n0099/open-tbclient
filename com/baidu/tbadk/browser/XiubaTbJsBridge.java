package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.d;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XiubaTbJsBridge implements com.baidu.tieba.tbadkCore.e.b {
    private static final String INTERFACE_NAME = "XiubaJSBridge";
    private static final String METHOD_CHECK_APK_INSTALL = "checkAPKInstall";
    private static final String METHOD_DOWNLOAD_APK = "downLoadAPK";
    private static final String METHOD_TOUCH_CLOSE = "touch_close";
    private static final String METHOD_TOUCH_OPEN = "touch_open";
    private static final String XIUBA_PACKAGE = "com.xiu8.baidu.activity";
    private static final int XIUBA_VERSION_FIRST = 3;
    private static final int XIUBA_VERSION_SECOND = 2;
    private BaseWebView mBaseWebView;
    private final TbPageContext<?> mTbPageContext;
    private final CustomMessageListener installListener = new CustomMessageListener(2002501) { // from class: com.baidu.tbadk.browser.XiubaTbJsBridge.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null && (data instanceof Intent) && XiubaTbJsBridge.XIUBA_PACKAGE.equals(XiubaTbJsBridge.getPackageName((Intent) data))) {
                XiubaTbJsBridge.this.callInstallListener();
            }
        }
    };
    private final CustomMessageListener downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tbadk.browser.XiubaTbJsBridge.2
        private boolean buz;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof DownloadMessage) {
                DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
                if (downloadMessage.getData() != null && downloadMessage.getData().size() > 0) {
                    for (DownloadData downloadData : downloadMessage.getData()) {
                        if (downloadData != null && XiubaTbJsBridge.XIUBA_PACKAGE.equals(downloadData.getId())) {
                            if (downloadData.getStatus() == 5) {
                                if (!this.buz) {
                                    this.buz = true;
                                    XiubaTbJsBridge.this.callDownloadListener(1);
                                }
                            } else if (downloadData.getStatus() == 0 || downloadData.getStatus() == 3) {
                                XiubaTbJsBridge.this.callDownloadListener(2);
                                this.buz = false;
                            } else if (downloadData.getStatus() == 2 || downloadData.getStatus() == 4) {
                                XiubaTbJsBridge.this.callDownloadListener(0);
                                this.buz = false;
                            }
                        }
                    }
                }
            }
        }
    };

    public XiubaTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.registerListener(this.downloadListener);
        this.mTbPageContext.registerListener(this.installListener);
    }

    public void setBaseWebView(BaseWebView baseWebView) {
        this.mBaseWebView = baseWebView;
    }

    private JSONObject checkAPKInstall(String str, long j, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
        JSResultData jSResultData = new JSResultData();
        if (TextUtils.isEmpty(str2) || !str2.equals(substring)) {
            return null;
        }
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        JSResultData.Result result = new JSResultData.Result();
        jSResultData.setResult(result);
        String installApkVersionName = UtilHelper.getInstallApkVersionName(TbadkCoreApplication.getInst(), str);
        if (installApkVersionName != null) {
            if (isInstall(installApkVersionName)) {
                result.setIsInstall(1);
                result.setApkVersion(installApkVersionName);
            } else {
                result.setIsInstall(0);
                result.setApkVersion("");
            }
        } else {
            result.setIsInstall(0);
            result.setApkVersion("");
        }
        return OrmObject.jsonWithObject(jSResultData);
    }

    private boolean isInstall(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("\\.")) == null || split.length == 0) {
            return false;
        }
        int l = com.baidu.adp.lib.g.b.l(split[0], 0);
        if (l > 3) {
            return true;
        }
        return split.length >= 2 && l == 3 && com.baidu.adp.lib.g.b.l(split[1], 0) >= 2;
    }

    private String downLoadAPK(String str, long j, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
        JSResultData jSResultData = new JSResultData();
        if (!TextUtils.isEmpty(str2) && str2.equals(substring) && validateGameUrl(str)) {
            startDownload(str);
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            return OrmObject.jsonStrWithObject(jSResultData);
        }
        return null;
    }

    private boolean validateGameUrl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            String authority = url.getAuthority();
            if (StringUtils.isNull(protocol) || StringUtils.isNULL(authority) || !protocol.equals("https")) {
                return false;
            }
            return authority.endsWith("bdstatic.com");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void startDownload(String str) {
        com.baidu.tbadk.download.b.alH().a(XIUBA_PACKAGE, str, TbadkCoreApplication.getInst().getResources().getString(d.j.xiuba_apk_name), -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDownloadListener(int i) {
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        JSResultData.Result result = new JSResultData.Result();
        jSResultData.setResult(result);
        result.setDownload(i);
        JSONObject jsonWithObject = OrmObject.jsonWithObject(jSResultData);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
            ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('download'," + jsonWithObject + ")");
        } else if (this.mBaseWebView != null) {
            this.mBaseWebView.loadUrl("javascript:addEventLisener('download'," + jsonWithObject + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callInstallListener() {
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        JSResultData.Result result = new JSResultData.Result();
        jSResultData.setResult(result);
        result.setInstall(1);
        JSONObject jsonWithObject = OrmObject.jsonWithObject(jSResultData);
        if (this.mTbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
            ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('install'," + jsonWithObject + ")");
        } else if (this.mBaseWebView != null) {
            this.mBaseWebView.loadUrl("javascript:addEventLisener('install'," + jsonWithObject + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPackageName(Intent intent) {
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return null;
        }
        String[] split = dataString.split(Config.TRACE_TODAY_VISIT_SPLIT);
        if (split != null && split.length == 2) {
            return split[1];
        }
        return dataString;
    }

    private static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < digest.length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String isEnableWebViewTouch(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002503, bool));
        return "";
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (INTERFACE_NAME.equals(str)) {
            if (METHOD_CHECK_APK_INSTALL.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString("sign");
                    jsPromptResult.confirm(checkAPKInstall(jSONObject.optString("apkName"), jSONObject.optLong("tk"), optString).toString());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (METHOD_DOWNLOAD_APK.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(downLoadAPK(jSONObject2.optString("url"), jSONObject2.optLong("tk"), jSONObject2.optString("sign")));
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (METHOD_TOUCH_CLOSE.equals(str2)) {
                try {
                    jsPromptResult.confirm(isEnableWebViewTouch(false));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if (METHOD_TOUCH_OPEN.equals(str2)) {
                try {
                    jsPromptResult.confirm(isEnableWebViewTouch(true));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return false;
    }
}
