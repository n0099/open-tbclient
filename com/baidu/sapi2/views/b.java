package com.baidu.sapi2.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.j.a.a;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes15.dex */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f5171a;

    /* renamed from: b  reason: collision with root package name */
    private ObjectAnimator f5172b;
    private View c;
    private LinearLayout d;

    public b(Context context) {
        super(context);
        this.f5171a = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.c = this.f5171a.findViewById(a.e.sweep_iv);
        this.d = (LinearLayout) this.f5171a.findViewById(a.e.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.d.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_color));
        }
    }

    @TargetApi(11)
    private void a() {
        b();
        new ObjectAnimator();
        this.f5172b = ObjectAnimator.ofFloat(this.c, "translationX", -300.0f, 300.0f);
        this.f5172b.setDuration(1000L);
        this.f5172b.setRepeatMode(1);
        this.f5172b.setRepeatCount(Integer.MAX_VALUE);
        this.f5172b.start();
    }

    @TargetApi(11)
    private void b() {
        ObjectAnimator objectAnimator = this.f5172b;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f5172b.end();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            a();
        } else {
            b();
        }
        super.setVisibility(i);
    }
}
