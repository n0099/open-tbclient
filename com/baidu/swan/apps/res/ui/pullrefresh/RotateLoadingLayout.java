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
    static final Interpolator aJY = new LinearInterpolator();
    private RelativeLayout aHM;
    private ImageView aHN;
    private TextView aHO;
    private TextView aHP;
    private TextView aHQ;
    private Animation aJZ;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.aHM = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aHN = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.aHO = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.aHP = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.aHQ = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aHN.setScaleType(ImageView.ScaleType.CENTER);
        this.aHN.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.aJZ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aJZ.setFillAfter(true);
        this.aJZ.setInterpolator(aJY);
        this.aJZ.setDuration(1200L);
        this.aJZ.setRepeatCount(-1);
        this.aJZ.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.aHQ.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.aHP.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aHM != null ? this.aHM.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        HE();
        this.aHO.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aHO.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Hk() {
        super.Hk();
        this.aHO.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.aHO.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        HE();
        this.aHN.startAnimation(this.aJZ);
        this.aHO.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aHN.setRotation(180.0f * f);
        }
    }

    private void HE() {
        this.aHN.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aHN.setRotation(0.0f);
        }
    }
}
