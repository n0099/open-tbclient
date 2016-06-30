package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.u;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XiubaTbJsBridge implements com.baidu.tieba.tbadkCore.e.b {
    private static final String INTERFACE_NAME = "XiubaJSBridge";
    private static final String METHOD_CHECK_APK_INSTALL = "checkAPKInstall";
    private static final String METHOD_DOWNLOAD_APK = "downLoadAPK";
    private static final String XIUBA_PACKAGE = "com.xiu8.baidu.activity";
    private static final int XIUBA_VERSION_FIRST = 3;
    private static final int XIUBA_VERSION_SECOND = 2;
    private BaseWebView mBaseWebView;
    private final TbPageContext<?> mTbPageContext;
    private final CustomMessageListener installListener = new ab(this, CmdConfigCustom.CMD_PACKAGE_ADDED);
    private final CustomMessageListener downloadListener = new ac(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

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
        String installApkVersionName = UtilHelper.getInstallApkVersionName(TbadkCoreApplication.m9getInst(), str);
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
        return com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData);
    }

    private boolean isInstall(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("\\.")) == null || split.length == 0) {
            return false;
        }
        int g = com.baidu.adp.lib.h.b.g(split[0], 0);
        if (g > 3) {
            return true;
        }
        return split.length >= 2 && g == 3 && com.baidu.adp.lib.h.b.g(split[1], 0) >= 2;
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
            return com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(jSResultData);
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
        com.baidu.tbadk.download.b.Ba().a(XIUBA_PACKAGE, str, TbadkCoreApplication.m9getInst().getResources().getString(u.j.xiuba_apk_name), -1, -1);
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
        JSONObject jsonWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData);
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
        JSONObject jsonWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData);
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
        String[] split = dataString.split(":");
        if (split != null && split.length == 2) {
            return split[1];
        }
        return dataString;
    }

    private static String md5(String str) {
        String str2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < digest.length) {
                    int i3 = digest[i2];
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    if (i3 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i3));
                    i = i2 + 1;
                } else {
                    str2 = stringBuffer.toString();
                    return str2;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str2;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (INTERFACE_NAME.equals(str)) {
            if (METHOD_CHECK_APK_INSTALL.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString(SapiUtils.KEY_QR_LOGIN_SIGN);
                    jsPromptResult.confirm(checkAPKInstall(jSONObject.optString("apkName"), jSONObject.optLong("tk"), optString).toString());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (METHOD_DOWNLOAD_APK.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(downLoadAPK(jSONObject2.optString("url"), jSONObject2.optLong("tk"), jSONObject2.optString(SapiUtils.KEY_QR_LOGIN_SIGN)));
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
