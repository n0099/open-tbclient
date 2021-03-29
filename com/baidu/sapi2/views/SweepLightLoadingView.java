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
import d.b.a0.a.a;
import d.b.a0.a.b;
import d.b.a0.a.d;
import d.b.a0.a.e;
import d.b.a0.a.f;
/* loaded from: classes2.dex */
public class SweepLightLoadingView extends FrameLayout implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public View f11580a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f11581b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f11582c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f11583d;

    public SweepLightLoadingView(Context context) {
        super(context);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.f11580a = inflate;
        this.f11581b = (ImageView) inflate.findViewById(e.sapi_sdk_loading_logo);
        this.f11582c = (ImageView) this.f11580a.findViewById(e.sapi_sdk_sweep_iv);
        this.f11583d = (LinearLayout) this.f11580a.findViewById(e.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f11583d.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_na_activity_color));
            this.f11581b.setImageResource(d.sapi_sdk_sweep_light_logo_dark);
            this.f11582c.setImageResource(d.sapi_sdk_sweep_light_dark);
            this.f11580a.findViewById(e.sapi_sdk_sweep_bg_view).setBackgroundColor(getResources().getColor(b.sapi_sdk_sweep_loading_bg_dark));
        }
    }

    private void b() {
        this.f11582c.startAnimation(AnimationUtils.loadAnimation(getContext(), a.sapi_sdk_sweep_light_trans));
    }

    @TargetApi(11)
    private void c() {
        ImageView imageView = this.f11582c;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            b();
        } else {
            c();
        }
        super.setVisibility(i);
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
