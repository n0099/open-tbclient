package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XiubaTbJsBridge implements d.b.j0.d3.l0.b {
    public static final String INTERFACE_NAME = "XiubaJSBridge";
    public static final String METHOD_CHECK_APK_INSTALL = "checkAPKInstall";
    public static final String METHOD_DOWNLOAD_APK = "downLoadAPK";
    public static final String METHOD_TOUCH_CLOSE = "touch_close";
    public static final String METHOD_TOUCH_OPEN = "touch_open";
    public static final String XIUBA_PACKAGE = "com.xiu8.baidu.activity";
    public static final int XIUBA_VERSION_FIRST = 3;
    public static final int XIUBA_VERSION_SECOND = 2;
    public final CustomMessageListener downloadListener;
    public final CustomMessageListener installListener = new a(2002501);
    public BaseWebView mBaseWebView;
    public final TbPageContext<?> mTbPageContext;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null && (data instanceof Intent) && "com.xiu8.baidu.activity".equals(XiubaTbJsBridge.getPackageName((Intent) data))) {
                XiubaTbJsBridge.this.callInstallListener();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12798a;

        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof DownloadMessage) {
                DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
                if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0) {
                    return;
                }
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null && "com.xiu8.baidu.activity".equals(downloadData.getId())) {
                        if (downloadData.getStatus() == 5) {
                            if (!this.f12798a) {
                                this.f12798a = true;
                                XiubaTbJsBridge.this.callDownloadListener(1);
                            }
                        } else if (downloadData.getStatus() == 0 || downloadData.getStatus() == 3) {
                            XiubaTbJsBridge.this.callDownloadListener(2);
                            this.f12798a = false;
                        } else if (downloadData.getStatus() == 2 || downloadData.getStatus() == 4) {
                            XiubaTbJsBridge.this.callDownloadListener(0);
                            this.f12798a = false;
                        }
                    }
                }
            }
        }
    }

    public XiubaTbJsBridge(TbPageContext<?> tbPageContext) {
        b bVar = new b(2001118);
        this.downloadListener = bVar;
        this.mTbPageContext = tbPageContext;
        tbPageContext.registerListener(bVar);
        this.mTbPageContext.registerListener(this.installListener);
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
            ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            return;
        }
        BaseWebView baseWebView = this.mBaseWebView;
        if (baseWebView != null) {
            baseWebView.loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
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
            ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            return;
        }
        BaseWebView baseWebView = this.mBaseWebView;
        if (baseWebView != null) {
            baseWebView.loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private JSONObject checkAPKInstall(String str, long j, String str2) {
        if (str != null && str2 != null) {
            String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
            JSResultData jSResultData = new JSResultData();
            if (!TextUtils.isEmpty(str2) && str2.equals(substring)) {
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
        }
        return null;
    }

    private String downLoadAPK(String str, long j, String str2) {
        if (str != null && str2 != null) {
            String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
            JSResultData jSResultData = new JSResultData();
            if (!TextUtils.isEmpty(str2) && str2.equals(substring) && validateGameUrl(str)) {
                startDownload(str);
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                return OrmObject.jsonStrWithObject(jSResultData);
            }
        }
        return null;
    }

    public static String getPackageName(Intent intent) {
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return null;
        }
        String[] split = dataString.split(":");
        return (split == null || split.length != 2) ? dataString : split[1];
    }

    private String isEnableWebViewTouch(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002503, bool));
        return "";
    }

    private boolean isInstall(String str) {
        String[] split;
        if (!StringUtils.isNull(str) && (split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) != null && split.length != 0) {
            int d2 = d.b.c.e.m.b.d(split[0], 0);
            if (d2 > 3) {
                return true;
            }
            if (split.length >= 2 && d2 == 3 && d.b.c.e.m.b.d(split[1], 0) >= 2) {
                return true;
            }
        }
        return false;
    }

    public static String md5(String str) {
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
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void startDownload(String str) {
        d.b.i0.v.b.l().r("com.xiu8.baidu.activity", str, TbadkCoreApplication.getInst().getResources().getString(R.string.xiuba_apk_name), -1, -1);
    }

    private boolean validateGameUrl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            String authority = url.getAuthority();
            if (!StringUtils.isNull(protocol) && !StringUtils.isNULL(authority) && protocol.equals("https")) {
                if (authority.endsWith("bdstatic.com")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.b.j0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("XiubaJSBridge".equals(str)) {
            if ("checkAPKInstall".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString("sign");
                    jsPromptResult.confirm(checkAPKInstall(jSONObject.optString("apkName"), jSONObject.optLong("tk"), optString).toString());
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            } else if ("downLoadAPK".equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(downLoadAPK(jSONObject2.optString("url"), jSONObject2.optLong("tk"), jSONObject2.optString("sign")));
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return false;
                }
            } else if ("touch_close".equals(str2)) {
                try {
                    jsPromptResult.confirm(isEnableWebViewTouch(Boolean.FALSE));
                    return false;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return false;
                }
            } else if ("touch_open".equals(str2)) {
                try {
                    jsPromptResult.confirm(isEnableWebViewTouch(Boolean.TRUE));
                    return false;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public void setBaseWebView(BaseWebView baseWebView) {
        this.mBaseWebView = baseWebView;
    }
}
