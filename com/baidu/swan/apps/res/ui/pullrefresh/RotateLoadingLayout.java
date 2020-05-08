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
    static final Interpolator cmu = new LinearInterpolator();
    private ImageView baE;
    private RelativeLayout ckp;
    private TextView ckq;
    private TextView ckr;
    private TextView cks;
    private Animation cmv;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.ckp = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.baE = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.ckq = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.ckr = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cks = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.baE.setScaleType(ImageView.ScaleType.CENTER);
        this.baE.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cmv = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cmv.setFillAfter(true);
        this.cmv.setInterpolator(cmu);
        this.cmv.setDuration(1200L);
        this.cmv.setRepeatCount(-1);
        this.cmv.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.cks.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.ckr.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.ckp != null ? this.ckp.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        akm();
        this.ckq.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.ckq.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void ajT() {
        super.ajT();
        this.ckq.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.ckq.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        akm();
        this.baE.startAnimation(this.cmv);
        this.ckq.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.baE.setRotation(180.0f * f);
        }
    }

    private void akm() {
        this.baE.clearAnimation();
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.baE.setRotation(0.0f);
        }
    }
}
