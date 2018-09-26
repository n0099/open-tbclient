package cn.jpush.android.e.a;

import android.webkit.WebView;
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = "HostJsScope";
    private static f mWebViewHelper;

    public static void click(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.click(str, str2, str3);
    }

    public static void close(WebView webView) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.close();
    }

    public static void createShortcut(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.createShortcut(str, str2, str3);
    }

    public static void download(WebView webView, String str) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.download(str);
    }

    public static void download(WebView webView, String str, String str2) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.download(str, str2);
    }

    public static void download(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.download(str, str2, str3);
    }

    public static void executeMsgMessage(WebView webView, String str) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.executeMsgMessage(str);
    }

    public static void setWebViewHelper(f fVar) {
        if (fVar == null) {
            return;
        }
        mWebViewHelper = fVar;
    }

    public static void showTitleBar(WebView webView) {
        if (mWebViewHelper != null) {
            mWebViewHelper.showTitleBar();
        }
    }

    public static void showToast(WebView webView, String str) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.showToast(str);
    }

    public static void startActivityByIntent(WebView webView, String str, String str2) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.startActivityByIntent(str, str2);
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.startActivityByName(str, str2);
    }

    public static void startActivityByNameWithSystemAlert(WebView webView, String str, String str2) {
        if (cn.jpush.android.api.e.a == null) {
            return;
        }
        cn.jpush.android.api.e.a.a(str, str2);
    }

    public static void startMainActivity(WebView webView, String str) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.startMainActivity(str);
    }

    public static void startPushActivity(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.startPushActivity(str);
        }
    }

    public static void triggerNativeAction(WebView webView, String str) {
        if (mWebViewHelper == null) {
            return;
        }
        mWebViewHelper.triggerNativeAction(str);
    }
}
