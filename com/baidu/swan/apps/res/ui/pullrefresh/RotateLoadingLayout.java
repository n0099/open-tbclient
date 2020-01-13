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
/* loaded from: classes10.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator bJl = new LinearInterpolator();
    private ImageView aAm;
    private RelativeLayout bHh;
    private TextView bHi;
    private TextView bHj;
    private TextView bHk;
    private Animation bJm;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.bHh = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aAm = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.bHi = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.bHj = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.bHk = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aAm.setScaleType(ImageView.ScaleType.CENTER);
        this.aAm.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.bJm = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bJm.setFillAfter(true);
        this.bJm.setInterpolator(bJl);
        this.bJm.setDuration(1200L);
        this.bJm.setRepeatCount(-1);
        this.bJm.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.bHk.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.bHj.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bHh != null ? this.bHh.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        ZP();
        this.bHi.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bHi.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Zw() {
        super.Zw();
        this.bHi.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.bHi.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        ZP();
        this.aAm.startAnimation(this.bJm);
        this.bHi.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aAm.setRotation(180.0f * f);
        }
    }

    private void ZP() {
        this.aAm.clearAnimation();
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aAm.setRotation(0.0f);
        }
    }
}
