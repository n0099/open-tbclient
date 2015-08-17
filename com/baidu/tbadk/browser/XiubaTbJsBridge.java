package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.i;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XiubaTbJsBridge {
    private static final String XIUBA_PACKAGE = "com.xiu8.baidu.activity";
    private final TbPageContext<?> mTbPageContext;
    private final CustomMessageListener installListener = new r(this, CmdConfigCustom.CMD_PACKAGE_ADDED);
    private final CustomMessageListener downloadListener = new s(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public XiubaTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.registerListener(this.downloadListener);
        this.mTbPageContext.registerListener(this.installListener);
    }

    public JSONObject checkAPKInstall(String str, long j, String str2) {
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
        String installApkVersionName = UtilHelper.getInstallApkVersionName(TbadkCoreApplication.m411getInst(), str);
        if (installApkVersionName != null) {
            result.setIsInstall(1);
            result.setApkVersion(installApkVersionName);
        } else {
            result.setIsInstall(0);
            result.setApkVersion("");
        }
        return com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData);
    }

    public String downLoadAPK(String str, long j, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
        JSResultData jSResultData = new JSResultData();
        if (TextUtils.isEmpty(str2) || !str2.equals(substring) || TextUtils.isEmpty(str)) {
            return null;
        }
        startDownload(str);
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(jSResultData);
    }

    private void startDownload(String str) {
        com.baidu.tbadk.download.b.Ap().a(XIUBA_PACKAGE, str, TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.xiuba_apk_name), -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDownloadListener(int i) {
        if (this.mTbPageContext.getOrignalPage() instanceof TbWebViewActivity) {
            TbWebViewActivity tbWebViewActivity = (TbWebViewActivity) this.mTbPageContext.getOrignalPage();
            if (tbWebViewActivity.getWebView() instanceof BaseWebView) {
                JSResultData jSResultData = new JSResultData();
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                JSResultData.Result result = new JSResultData.Result();
                jSResultData.setResult(result);
                result.setDownload(i);
                ((BaseWebView) tbWebViewActivity.getWebView()).loadUrl("javascript:addEventLisener('download'," + com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData) + ")");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callInstallListener() {
        if (this.mTbPageContext.getOrignalPage() instanceof TbWebViewActivity) {
            TbWebViewActivity tbWebViewActivity = (TbWebViewActivity) this.mTbPageContext.getOrignalPage();
            if (tbWebViewActivity.getWebView() instanceof BaseWebView) {
                JSResultData jSResultData = new JSResultData();
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                JSResultData.Result result = new JSResultData.Result();
                jSResultData.setResult(result);
                result.setInstall(1);
                ((BaseWebView) tbWebViewActivity.getWebView()).loadUrl("javascript:addEventLisener('install'," + com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(jSResultData) + ")");
            }
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

    public static String md5(String str) {
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
}
