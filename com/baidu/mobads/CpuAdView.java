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
/* loaded from: classes5.dex */
public final class CpuAdView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.cpu.c f3277a;

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener) {
        this(context, str, str2, urlListener, null);
    }

    public CpuAdView(Context context, String str, String str2, CpuInfoManager.UrlListener urlListener, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        XAdView xAdView = new XAdView(context);
        this.f3277a = new com.baidu.mobads.production.cpu.c(context, xAdView, str, str2, cPUWebAdRequestParam);
        this.f3277a.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i) {
        this(context, str, i, (CPUWebAdRequestParam) null);
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        XAdView xAdView = new XAdView(context);
        this.f3277a = new com.baidu.mobads.production.cpu.c(context, xAdView, str, i, cPUWebAdRequestParam);
        this.f3277a.request();
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        try {
            View adView = this.f3277a.h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).onResume();
            }
        } catch (Throwable th) {
        }
    }

    public void onPause() {
        try {
            View adView = this.f3277a.h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).onPause();
            }
        } catch (Throwable th) {
        }
    }

    public void onDestroy() {
        try {
            View adView = this.f3277a.h.getAdView();
            if (adView instanceof WebView) {
                ((WebView) adView).destroy();
            }
        } catch (Throwable th) {
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    protected boolean canGoBack() {
        try {
            return ((WebView) this.f3277a.h.getAdView()).canGoBack();
        } catch (Throwable th) {
            return false;
        }
    }

    protected void goBack() {
        try {
            ((WebView) this.f3277a.h.getAdView()).goBack();
        } catch (Throwable th) {
        }
    }
}
