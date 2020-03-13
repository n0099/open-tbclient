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
/* loaded from: classes11.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator bNs = new LinearInterpolator();
    private ImageView aEE;
    private RelativeLayout bLo;
    private TextView bLp;
    private TextView bLq;
    private TextView bLr;
    private Animation bNt;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.bLo = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aEE = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.bLp = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.bLq = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.bLr = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aEE.setScaleType(ImageView.ScaleType.CENTER);
        this.aEE.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.bNt = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bNt.setFillAfter(true);
        this.bNt.setInterpolator(bNs);
        this.bNt.setDuration(1200L);
        this.bNt.setRepeatCount(-1);
        this.bNt.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.bLr.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.bLq.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bLo != null ? this.bLo.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        acf();
        this.bLp.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bLp.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void abM() {
        super.abM();
        this.bLp.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.bLp.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        acf();
        this.aEE.startAnimation(this.bNt);
        this.bLp.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aEE.setRotation(180.0f * f);
        }
    }

    private void acf() {
        this.aEE.clearAnimation();
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aEE.setRotation(0.0f);
        }
    }
}
