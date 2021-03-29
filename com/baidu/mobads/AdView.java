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
/* loaded from: classes2.dex */
public final class AdView extends RelativeLayout {
    public static final String P_VERSION = "3.61";

    /* renamed from: a  reason: collision with root package name */
    public IOAdEventListener f8102a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f8103b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.a.a f8104c;

    /* renamed from: d  reason: collision with root package name */
    public AdViewListener f8105d;

    public AdView(Context context) {
        super(context);
        this.f8103b = new AtomicBoolean(false);
        this.f8102a = new a(this);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void destroy() {
        this.f8104c.p();
    }

    @Override // android.view.View
    @Deprecated
    public void setAlpha(float f2) {
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
        if (i <= 0) {
            i = Math.min(i3, i4);
        } else if (i > 0) {
            float f3 = 200.0f * f2;
            if (i < f3) {
                i = (int) f3;
            }
        }
        if (i2 <= 0) {
            i2 = (int) (Math.min(i3, i4) * 0.15f);
        } else if (i2 > 0) {
            float f4 = f2 * 30.0f;
            if (i2 < f4) {
                i2 = (int) f4;
            }
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        com.baidu.mobads.production.a.a aVar = this.f8104c;
        if (aVar != null && aVar.getAdRequestInfo() != null) {
            this.f8104c.getAdRequestInfo().d(layoutParams.width);
            this.f8104c.getAdRequestInfo().e(layoutParams.height);
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        this.f8105d = adViewListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f8103b.get()) {
            return;
        }
        this.f8103b.set(true);
        this.f8104c.request();
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.f8103b = new AtomicBoolean(false);
        this.f8102a = new a(this);
        XAdView xAdView = new XAdView(context);
        com.baidu.mobads.production.a.a aVar = new com.baidu.mobads.production.a.a(context, xAdView, str, z);
        this.f8104c = aVar;
        aVar.addEventListener(IXAdEvent.AD_LOADED, this.f8102a);
        this.f8104c.addEventListener(IXAdEvent.AD_ERROR, this.f8102a);
        this.f8104c.addEventListener(IXAdEvent.AD_STARTED, this.f8102a);
        this.f8104c.addEventListener("AdUserClick", this.f8102a);
        this.f8104c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f8102a);
        xAdView.setListener(new c(this));
        addView(xAdView, new ViewGroup.LayoutParams(-1, -1));
    }
}
