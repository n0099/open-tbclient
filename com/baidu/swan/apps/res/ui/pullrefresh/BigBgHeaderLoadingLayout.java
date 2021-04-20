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
import d.b.g0.a.d;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.h;
/* loaded from: classes3.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f12180h;
    public ImageView i;
    public ProgressBar j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Animation n;
    public Animation o;
    public ImageView p;

    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f2) {
        if (this.p == null) {
            return;
        }
        float f3 = f2 - 0.3f;
        float f4 = 1.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        float f5 = f2 + 0.8f;
        if (f5 < 0.8f) {
            f4 = 0.8f;
        } else if (f5 <= 1.0f) {
            f4 = f5;
        }
        this.p.setAlpha(f3);
        this.p.setScaleX(f4);
        this.p.setScaleY(f4);
        super.d(f2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
            this.i.clearAnimation();
            this.i.startAnimation(this.o);
        }
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.f12180h;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.i.clearAnimation();
        this.i.setVisibility(4);
        this.j.setVisibility(0);
        this.k.setText(h.aiapps_pull_to_refresh_header_updateing);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.i.clearAnimation();
        this.i.startAnimation(this.n);
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.i.clearAnimation();
        this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.i.setVisibility(0);
        this.j.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    public final void n(Context context) {
        this.f12180h = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
        this.i = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
        this.k = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
        this.j = (ProgressBar) findViewById(f.pull_to_refresh_header_progressbar);
        this.l = (TextView) findViewById(f.pull_to_refresh_header_time);
        this.m = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
        this.p = (ImageView) findViewById(f.pull_to_refresh_header_background);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.n = rotateAnimation;
        rotateAnimation.setDuration(120L);
        this.n.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.o = rotateAnimation2;
        rotateAnimation2.setDuration(120L);
        this.o.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.m.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.l.setText(charSequence);
    }

    public BigBgHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }
}
