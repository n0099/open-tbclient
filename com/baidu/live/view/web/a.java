package com.baidu.live.view.web;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
/* loaded from: classes3.dex */
public abstract class a {
    protected h bcc;
    protected Handler mHandler;

    public abstract void fc(String str);

    public abstract String getName();

    public void e(String str, String str2, boolean z) {
    }

    @JavascriptInterface
    public void scheme(final String str) {
        Log.d("AbstractJsInterface", "@@ bridge scheme params = " + str);
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.live.view.web.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bcc != null) {
                    a.this.bcc.fj(str);
                } else {
                    a.this.fc(str);
                }
            }
        });
    }

    @JavascriptInterface
    public void hasInstalled(final String str, final String str2, final boolean z) {
        Log.d("AbstractJsInterface", "@@ bridge hasInstalled scheme = " + str + ", method = " + str2 + ", needOpen = " + z);
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.live.view.web.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.e(str, str2, z);
            }
        });
    }

    public void a(h hVar) {
        this.bcc = hVar;
    }
}
