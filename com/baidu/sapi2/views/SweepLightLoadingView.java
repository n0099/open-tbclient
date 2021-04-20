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
import d.b.x.a.a;
import d.b.x.a.b;
import d.b.x.a.d;
import d.b.x.a.e;
import d.b.x.a.f;
/* loaded from: classes2.dex */
public class SweepLightLoadingView extends FrameLayout implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public View f11164a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f11165b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f11166c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f11167d;

    public SweepLightLoadingView(Context context) {
        super(context);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.f11164a = inflate;
        this.f11165b = (ImageView) inflate.findViewById(e.sapi_sdk_loading_logo);
        this.f11166c = (ImageView) this.f11164a.findViewById(e.sapi_sdk_sweep_iv);
        this.f11167d = (LinearLayout) this.f11164a.findViewById(e.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f11167d.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_na_activity_color));
            this.f11165b.setImageResource(d.sapi_sdk_sweep_light_logo_dark);
            this.f11166c.setImageResource(d.sapi_sdk_sweep_light_dark);
            this.f11164a.findViewById(e.sapi_sdk_sweep_bg_view).setBackgroundColor(getResources().getColor(b.sapi_sdk_sweep_loading_bg_dark));
        }
    }

    private void b() {
        this.f11166c.startAnimation(AnimationUtils.loadAnimation(getContext(), a.sapi_sdk_sweep_light_trans));
    }

    @TargetApi(11)
    private void c() {
        ImageView imageView = this.f11166c;
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
