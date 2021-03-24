package com.baidu.mobads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.CpuInfoManager;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.production.cpu.CPUWebAdRequestParam;
/* loaded from: classes2.dex */
public final class CpuAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.production.cpu.c f8135a;

    public CpuAdView(Context context) {
        super(context);
    }

    public boolean canGoBack() {
        try {
            return ((WebView) this.f8135a.f8440h.getAdView()).canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void goBack() {
        try {
            ((WebView) this.f8135a.f8440h.getAdView()).goBack();
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        try {
            View adView = this.f8135a.f8440h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).destroy();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    public void onPause() {
        try {
            View adView = this.f8135a.f8440h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).onPause();
            }
        } catch (Throwable unused) {
        }
    }

    public void onResume() {
        try {
            View adView = this.f8135a.f8440h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).onResume();
            }
        } catch (Throwable unused) {
        }
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener) {
        this(context, str, str2, urlListener, null);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        XAdView xAdView = new XAdView(context);
        com.baidu.mobads.production.cpu.c cVar = new com.baidu.mobads.production.cpu.c(context, xAdView, str, str2, cPUWebAdRequestParam);
        this.f8135a = cVar;
        cVar.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i) {
        this(context, str, i, (CPUWebAdRequestParam) null);
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        XAdView xAdView = new XAdView(context);
        com.baidu.mobads.production.cpu.c cVar = new com.baidu.mobads.production.cpu.c(context, xAdView, str, i, cPUWebAdRequestParam);
        this.f8135a = cVar;
        cVar.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }
}
