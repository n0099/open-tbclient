package com.baidu.live.view.web;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
/* loaded from: classes4.dex */
public abstract class a {
    protected h bNm;
    protected Handler mHandler;

    public abstract String getName();

    public abstract void iO(String str);

    public void h(String str, String str2, boolean z) {
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
                if (a.this.bNm != null) {
                    a.this.bNm.iT(str);
                } else {
                    a.this.iO(str);
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
                a.this.h(str, str2, z);
            }
        });
    }

    public void a(h hVar) {
        this.bNm = hVar;
    }
}
