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
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator bfQ = new LinearInterpolator();
    private RelativeLayout bdH;
    private ImageView bdI;
    private TextView bdJ;
    private TextView bdK;
    private TextView bdL;
    private Animation bfR;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.bdH = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bdI = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.bdJ = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.bdK = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.bdL = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bdI.setScaleType(ImageView.ScaleType.CENTER);
        this.bdI.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.bfR = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bfR.setFillAfter(true);
        this.bfR.setInterpolator(bfQ);
        this.bfR.setDuration(1200L);
        this.bfR.setRepeatCount(-1);
        this.bfR.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.bdL.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.bdK.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bdH != null ? this.bdH.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        PF();
        this.bdJ.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bdJ.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Pl() {
        super.Pl();
        this.bdJ.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.bdJ.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        PF();
        this.bdI.startAnimation(this.bfR);
        this.bdJ.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.bdI.setRotation(180.0f * f);
        }
    }

    private void PF() {
        this.bdI.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.bdI.setRotation(0.0f);
        }
    }
}
