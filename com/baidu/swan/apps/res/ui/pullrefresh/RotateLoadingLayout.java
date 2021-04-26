package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import d.a.h0.a.d;
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.c;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static final Interpolator n = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f12125h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f12126i;
    public TextView j;
    public TextView k;
    public TextView l;
    public Animation m;

    public RotateLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f2) {
        if (c.c()) {
            this.f12126i.setRotation(f2 * 180.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.f12125h;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        o();
        this.f12126i.startAnimation(this.m);
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        super.i();
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        o();
        this.j.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f12125h = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
        this.f12126i = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
        this.j = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
        this.k = (TextView) findViewById(f.pull_to_refresh_header_time);
        this.l = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
        this.f12126i.setScaleType(ImageView.ScaleType.CENTER);
        this.f12126i.setImageResource(e.aiapps_default_ptr_rotate);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setFillAfter(true);
        this.m.setInterpolator(n);
        this.m.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.m.setRepeatCount(-1);
        this.m.setRepeatMode(1);
    }

    public final void o() {
        this.f12126i.clearAnimation();
        if (c.c()) {
            this.f12126i.setRotation(0.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.l.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.k.setText(charSequence);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }
}
