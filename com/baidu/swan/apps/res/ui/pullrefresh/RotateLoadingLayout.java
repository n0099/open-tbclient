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
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.v2.d;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static final Interpolator o = new LinearInterpolator();

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f11216i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Animation n;

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
        if (d.c()) {
            this.j.setRotation(f2 * 180.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.f11216i;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(d.a.l0.a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        o();
        this.j.startAnimation(this.n);
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        super.i();
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        o();
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f11216i = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
        this.j = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
        this.k = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
        this.l = (TextView) findViewById(f.pull_to_refresh_header_time);
        this.m = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
        this.j.setScaleType(ImageView.ScaleType.CENTER);
        this.j.setImageResource(e.aiapps_default_ptr_rotate);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.n = rotateAnimation;
        rotateAnimation.setFillAfter(true);
        this.n.setInterpolator(o);
        this.n.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.n.setRepeatCount(-1);
        this.n.setRepeatMode(1);
    }

    public final void o() {
        this.j.clearAnimation();
        if (d.c()) {
            this.j.setRotation(0.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.m.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.l.setText(charSequence);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }
}
