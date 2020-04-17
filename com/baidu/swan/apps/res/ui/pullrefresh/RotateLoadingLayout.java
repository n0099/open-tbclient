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
    static final Interpolator cmo = new LinearInterpolator();
    private ImageView baz;
    private RelativeLayout ckj;
    private TextView ckk;
    private TextView ckl;
    private TextView ckm;
    private Animation cmp;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.ckj = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.baz = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.ckk = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.ckl = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.ckm = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.baz.setScaleType(ImageView.ScaleType.CENTER);
        this.baz.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cmp = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cmp.setFillAfter(true);
        this.cmp.setInterpolator(cmo);
        this.cmp.setDuration(1200L);
        this.cmp.setRepeatCount(-1);
        this.cmp.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.ckm.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.ckl.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.ckj != null ? this.ckj.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        akn();
        this.ckk.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.ckk.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void ajU() {
        super.ajU();
        this.ckk.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.ckk.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        akn();
        this.baz.startAnimation(this.cmp);
        this.ckk.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.baz.setRotation(180.0f * f);
        }
    }

    private void akn() {
        this.baz.clearAnimation();
        if (com.baidu.swan.apps.as.a.hasHoneycomb()) {
            this.baz.setRotation(0.0f);
        }
    }
}
