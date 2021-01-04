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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.c;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator dCB = new LinearInterpolator();
    private ImageView bUf;
    private TextView dAA;
    private RelativeLayout dAx;
    private TextView dAy;
    private TextView dAz;
    private Animation dCC;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dAx = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bUf = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.dAy = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.dAz = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.dAA = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bUf.setScaleType(ImageView.ScaleType.CENTER);
        this.bUf.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.dCC = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.dCC.setFillAfter(true);
        this.dCC.setInterpolator(dCB);
        this.dCC.setDuration(1200L);
        this.dCC.setRepeatCount(-1);
        this.dCC.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.dAA.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.dAz.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dAx != null ? this.dAx.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        aKY();
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aKF() {
        super.aKF();
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        aKY();
        this.bUf.startAnimation(this.dCC);
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.bUf.setRotation(180.0f * f);
        }
    }

    private void aKY() {
        this.bUf.clearAnimation();
        if (c.hasHoneycomb()) {
            this.bUf.setRotation(0.0f);
        }
    }
}
