package com.baidu.sapi2.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.l.a.a;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes6.dex */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f3584a;
    private ObjectAnimator b;
    private View c;
    private LinearLayout d;

    public b(Context context) {
        super(context);
        this.f3584a = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.c = this.f3584a.findViewById(a.e.sweep_iv);
        this.d = (LinearLayout) this.f3584a.findViewById(a.e.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.d.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_color));
        }
    }

    @TargetApi(11)
    private void a() {
        b();
        new ObjectAnimator();
        this.b = ObjectAnimator.ofFloat(this.c, "translationX", -300.0f, 300.0f);
        this.b.setDuration(1000L);
        this.b.setRepeatMode(1);
        this.b.setRepeatCount(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.b.start();
    }

    @TargetApi(11)
    private void b() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.b.end();
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
