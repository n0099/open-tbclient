package com.baidu.swan.game.ad;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class RewardWebView extends WebView {
    private Handler mHandler;
    private boolean mIsDestroy;

    public RewardWebView(Context context) {
        super(context);
        this.mIsDestroy = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        aIV();
        setClickable(true);
        setBackgroundColor(0);
        setFocusable(true);
        setScrollBarStyle(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(path);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        settings.setAppCacheMaxSize(ImageUploadStrategy.FILE_SIZE_5M);
        aIU();
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception e) {
        }
        if (Build.VERSION.SDK_INT >= 14) {
            setLayerType(1, null);
        }
    }

    private void aIU() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(com.baidu.swan.apps.an.a.sI(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str) {
        try {
            if (!this.mIsDestroy) {
                runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.RewardWebView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RewardWebView.super.loadUrl(str);
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (!this.mIsDestroy) {
            runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.RewardWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    RewardWebView.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (!this.mIsDestroy) {
            runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.RewardWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    RewardWebView.super.evaluateJavascript(str, valueCallback);
                }
            });
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (!this.mIsDestroy) {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                super.destroy();
                this.mIsDestroy = true;
            }
        } catch (Exception e) {
        }
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    private void aIV() {
        try {
            if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 17) {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", String.class);
                declaredMethod.invoke(this, "searchBoxJavaBridge_");
                declaredMethod.invoke(this, "accessibility");
                declaredMethod.invoke(this, "accessibilityTraversal");
            }
        } catch (Exception e) {
        }
    }
}
