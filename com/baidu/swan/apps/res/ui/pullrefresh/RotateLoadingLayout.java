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
import com.baidu.swan.apps.ap.c;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator cQw = new LinearInterpolator();
    private ImageView bwA;
    private RelativeLayout cOt;
    private TextView cOu;
    private TextView cOv;
    private TextView cOw;
    private Animation cQx;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.cOt = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bwA = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cOu = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.cOv = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cOw = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bwA.setScaleType(ImageView.ScaleType.CENTER);
        this.bwA.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cQx = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cQx.setFillAfter(true);
        this.cQx.setInterpolator(cQw);
        this.cQx.setDuration(1200L);
        this.cQx.setRepeatCount(-1);
        this.cQx.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.cOw.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.cOv.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cOt != null ? this.cOt.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        azL();
        this.cOu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cOu.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void azs() {
        super.azs();
        this.cOu.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cOu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        azL();
        this.bwA.startAnimation(this.cQx);
        this.cOu.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.bwA.setRotation(180.0f * f);
        }
    }

    private void azL() {
        this.bwA.clearAnimation();
        if (c.hasHoneycomb()) {
            this.bwA.setRotation(0.0f);
        }
    }
}
