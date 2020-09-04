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
/* loaded from: classes8.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator cOw = new LinearInterpolator();
    private ImageView btj;
    private RelativeLayout cMt;
    private TextView cMu;
    private TextView cMv;
    private TextView cMw;
    private Animation cOx;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.cMt = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.btj = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cMu = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.cMv = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cMw = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.btj.setScaleType(ImageView.ScaleType.CENTER);
        this.btj.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cOx = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cOx.setFillAfter(true);
        this.cOx.setInterpolator(cOw);
        this.cOx.setDuration(1200L);
        this.cOx.setRepeatCount(-1);
        this.cOx.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.cMw.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.cMv.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cMt != null ? this.cMt.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        azc();
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void ayJ() {
        super.ayJ();
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        azc();
        this.btj.startAnimation(this.cOx);
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.btj.setRotation(180.0f * f);
        }
    }

    private void azc() {
        this.btj.clearAnimation();
        if (c.hasHoneycomb()) {
            this.btj.setRotation(0.0f);
        }
    }
}
