package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.l0.a.d;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.h;
/* loaded from: classes3.dex */
public class HeaderLoadingLayout extends LoadingLayout {

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f11144i;
    public ImageView j;
    public ProgressBar k;
    public TextView l;
    public TextView m;
    public TextView n;
    public Animation o;
    public Animation p;

    public HeaderLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(g.aiapps_pull_to_refresh_header, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
            this.j.clearAnimation();
            this.j.startAnimation(this.p);
        }
        this.l.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.f11144i;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.j.clearAnimation();
        this.j.setVisibility(4);
        this.k.setVisibility(0);
        this.l.setText(h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.j.clearAnimation();
        this.j.startAnimation(this.o);
        this.l.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.j.clearAnimation();
        this.l.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.j.setVisibility(0);
        this.k.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f11144i = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
        this.j = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
        this.l = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
        this.k = (ProgressBar) findViewById(f.pull_to_refresh_header_progressbar);
        this.m = (TextView) findViewById(f.pull_to_refresh_header_time);
        this.n = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.o = rotateAnimation;
        rotateAnimation.setDuration(120L);
        this.o.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.p = rotateAnimation2;
        rotateAnimation2.setDuration(120L);
        this.p.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.n.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.m.setText(charSequence);
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }
}
