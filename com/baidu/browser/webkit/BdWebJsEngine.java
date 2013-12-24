package com.baidu.browser.webkit;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.zeus.NotificationProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class BdWebJsEngine implements BdNoProGuard {
    private static final boolean DEBUG = false;
    private static final String FILE_SCRIPT_FLYFLOW = "webkit/javascript/flyflow_webkit_js.js";
    public static final String FILE_SCRIPT_WEBJSCLIENT = "webkit/javascript/browser_webjsclient.js";
    private static final String LOG_TAG = "BdWebJsEngine";
    public static final int MSG_ONCLICK = 4;
    public static final int MSG_ONGO = 3;
    public static final int MSG_ONGOBACK = 1;
    public static final int MSG_ONGOFORWARD = 2;
    public static final int MSG_ONRELOAD = 5;
    public static final int MSG_ONWEBJSCLIENTFINISHED = 6;
    private static String sFlyflowWebJsScript;
    private static String sWebJsClientScript;
    private BdWebJsClient mWebJsClient;
    private BdWebView mWebView;

    public BdWebJsEngine(BdWebView bdWebView) {
        this.mWebView = bdWebView;
    }

    public void setWebJsClient(BdWebJsClient bdWebJsClient) {
        this.mWebJsClient = bdWebJsClient;
        if (this.mWebJsClient != null) {
            if (sFlyflowWebJsScript == null) {
                sFlyflowWebJsScript = "javascript:" + loadWebJsClientJavaScript(this.mWebView.getContext(), FILE_SCRIPT_FLYFLOW);
            }
            if (sWebJsClientScript == null) {
                sWebJsClientScript = "javascript:(" + loadWebJsClientJavaScript(this.mWebView.getContext(), FILE_SCRIPT_WEBJSCLIENT) + ")()";
            }
        }
    }

    public BdWebJsClient getWebJsClient() {
        return this.mWebJsClient;
    }

    public void runJavaScript(String str) {
        this.mWebView.loadUrl("javascript:(" + str + ")()");
    }

    public void runWebJsClientJavaScript() {
        if (Build.VERSION.SDK_INT >= 11) {
            ((WebView) this.mWebView.getWebView()).removeJavascriptInterface("searchBoxJavaBridge_");
        }
        this.mWebView.loadUrl(sFlyflowWebJsScript);
        this.mWebView.loadUrl(sWebJsClientScript);
    }

    private String loadWebJsClientJavaScript(Context context, String str) {
        try {
            return convertStreamToString(context.getAssets().open(str));
        } catch (IOException e) {
            return "";
        }
    }

    private String convertStreamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
            } finally {
                byteArrayOutputStream.close();
            }
        }
        return byteArrayOutputStream.toString();
    }
}
