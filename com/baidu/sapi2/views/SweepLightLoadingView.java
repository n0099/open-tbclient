package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import d.a.y.a.b;
import d.a.y.a.d;
import d.a.y.a.e;
import d.a.y.a.f;
/* loaded from: classes2.dex */
public class SweepLightLoadingView extends FrameLayout implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public View f10960a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f10961b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f10962c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f10963d;

    public SweepLightLoadingView(Context context) {
        super(context);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.f10960a = inflate;
        this.f10961b = (ImageView) inflate.findViewById(e.sapi_sdk_loading_logo);
        this.f10962c = (ImageView) this.f10960a.findViewById(e.sapi_sdk_sweep_iv);
        this.f10963d = (LinearLayout) this.f10960a.findViewById(e.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f10963d.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_na_activity_color));
            this.f10961b.setImageResource(d.sapi_sdk_sweep_light_logo_dark);
            this.f10962c.setImageResource(d.sapi_sdk_sweep_light_dark);
            this.f10960a.findViewById(e.sapi_sdk_sweep_bg_view).setBackgroundColor(getResources().getColor(b.sapi_sdk_sweep_loading_bg_dark));
        }
    }

    private void b() {
        this.f10962c.startAnimation(AnimationUtils.loadAnimation(getContext(), d.a.y.a.a.sapi_sdk_sweep_light_trans));
    }

    @TargetApi(11)
    private void c() {
        ImageView imageView = this.f10962c;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 == 0) {
            b();
        } else {
            c();
        }
        super.setVisibility(i2);
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
