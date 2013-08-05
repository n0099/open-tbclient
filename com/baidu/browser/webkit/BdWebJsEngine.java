package com.baidu.browser.webkit;

import android.content.Context;
import com.baidu.browser.core.BdNoProGuard;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class BdWebJsEngine implements BdNoProGuard {
    private static final boolean DEBUG = false;
    public static final String FILE_SCRIPT_WEBJSCLIENT = "webkit/javascript/browser_webjsclient.js";
    public static final String JAVASCRIPT_INTERFACE_WEBKIT = "flyflow_webkit_js";
    private static final String LOG_TAG = "BdWebJsEngine";
    public static final int MSG_ONCLICK = 4;
    public static final int MSG_ONGO = 3;
    public static final int MSG_ONGOBACK = 1;
    public static final int MSG_ONGOFORWARD = 2;
    public static final int MSG_ONRELOAD = 5;
    public static final int MSG_ONWEBJSCLIENTFINISHED = 6;
    private static String sWebJsClientScript;
    private BdWebJsClient mWebJsClient;
    private BdWebView mWebView;

    public BdWebJsEngine(BdWebView bdWebView) {
        this.mWebView = bdWebView;
    }

    public void setWebJsClient(BdWebJsClient bdWebJsClient) {
        this.mWebJsClient = bdWebJsClient;
        if (this.mWebJsClient != null) {
            if (sWebJsClientScript == null) {
                sWebJsClientScript = "javascript:(" + loadWebJsClientJavaScript(this.mWebView.getContext(), FILE_SCRIPT_WEBJSCLIENT) + ")()";
            }
            this.mWebView.addJavascriptInterface(this, JAVASCRIPT_INTERFACE_WEBKIT);
        }
    }

    public void runJavaScript(String str) {
        this.mWebView.loadUrl("javascript:(" + str + ")()");
    }

    public void runWebJsClientJavaScript() {
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
        byte[] bArr = new byte[1024];
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

    public void onGoBack() {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onGoBack(this.mWebView);
        }
    }

    public void onGoForward() {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onGoForward(this.mWebView);
        }
    }

    public void onGo(int i) {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onGo(this.mWebView, i);
        }
    }

    public void onClick(String str) {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onClick(this.mWebView, str);
        }
    }

    public void onReload() {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onReload(this.mWebView);
        }
    }

    public void onWebJsClientFinished() {
        if (this.mWebJsClient != null) {
            this.mWebJsClient.onWebJsClientFinished(this.mWebView);
        }
    }
}
