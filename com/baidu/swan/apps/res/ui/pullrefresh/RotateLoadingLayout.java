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
    static final Interpolator aLS = new LinearInterpolator();
    private RelativeLayout aJG;
    private ImageView aJH;
    private TextView aJI;
    private TextView aJJ;
    private TextView aJK;
    private Animation aLT;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.aJG = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aJH = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.aJI = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.aJJ = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.aJK = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aJH.setScaleType(ImageView.ScaleType.CENTER);
        this.aJH.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.aLT = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aLT.setFillAfter(true);
        this.aLT.setInterpolator(aLS);
        this.aLT.setDuration(1200L);
        this.aLT.setRepeatCount(-1);
        this.aLT.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.aJK.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.aJJ.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aJG != null ? this.aJG.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        JU();
        this.aJI.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aJI.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void JA() {
        super.JA();
        this.aJI.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.aJI.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        JU();
        this.aJH.startAnimation(this.aLT);
        this.aJI.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aJH.setRotation(180.0f * f);
        }
    }

    private void JU() {
        this.aJH.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aJH.setRotation(0.0f);
        }
    }
}
