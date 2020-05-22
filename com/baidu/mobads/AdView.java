package com.baidu.mobads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class AdView extends RelativeLayout {
    private AtomicBoolean bsf;
    IOAdEventListener bsg;
    private com.baidu.mobads.production.a.a bsh;
    private AdViewListener bsi;

    public AdView(Context context) {
        super(context);
        this.bsf = new AtomicBoolean(false);
        this.bsg = new a(this);
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.bsf = new AtomicBoolean(false);
        this.bsg = new a(this);
        XAdView xAdView = new XAdView(context);
        this.bsh = new com.baidu.mobads.production.a.a(context, xAdView, str, z);
        this.bsh.addEventListener(IXAdEvent.AD_LOADED, this.bsg);
        this.bsh.addEventListener(IXAdEvent.AD_ERROR, this.bsg);
        this.bsh.addEventListener(IXAdEvent.AD_STARTED, this.bsg);
        this.bsh.addEventListener("AdUserClick", this.bsg);
        this.bsh.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bsg);
        xAdView.setListener(new c(this));
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!this.bsf.get()) {
            this.bsf.set(true);
            this.bsh.request();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int i;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams", Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f));
        if (i2 <= 0) {
            i2 = Math.min(i4, i5);
        } else if (i2 > 0 && i2 < 200.0f * f) {
            i2 = (int) (200.0f * f);
        }
        if (i3 <= 0) {
            i = (int) (Math.min(i4, i5) * 0.15f);
        } else {
            i = (i3 <= 0 || ((float) i3) >= 30.0f * f) ? i3 : (int) (30.0f * f);
        }
        layoutParams.width = i2;
        layoutParams.height = i;
        if (this.bsh != null && this.bsh.getAdRequestInfo() != null) {
            this.bsh.getAdRequestInfo().d(layoutParams.width);
            this.bsh.getAdRequestInfo().e(layoutParams.height);
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        this.bsi = adViewListener;
    }

    @Override // android.view.View
    @Deprecated
    public void setAlpha(float f) {
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundColor(int i) {
    }

    public void destroy() {
        this.bsh.p();
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }
}
