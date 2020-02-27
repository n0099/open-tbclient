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
    static final Interpolator bNq = new LinearInterpolator();
    private ImageView aEC;
    private RelativeLayout bLm;
    private TextView bLn;
    private TextView bLo;
    private TextView bLp;
    private Animation bNr;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.bLm = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aEC = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.bLn = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.bLo = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.bLp = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aEC.setScaleType(ImageView.ScaleType.CENTER);
        this.aEC.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.bNr = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bNr.setFillAfter(true);
        this.bNr.setInterpolator(bNq);
        this.bNr.setDuration(1200L);
        this.bNr.setRepeatCount(-1);
        this.bNr.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.bLp.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.bLo.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bLm != null ? this.bLm.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        acd();
        this.bLn.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bLn.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void abK() {
        super.abK();
        this.bLn.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.bLn.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        acd();
        this.aEC.startAnimation(this.bNr);
        this.bLn.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aEC.setRotation(180.0f * f);
        }
    }

    private void acd() {
        this.aEC.clearAnimation();
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.aEC.setRotation(0.0f);
        }
    }
}
