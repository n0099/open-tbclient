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
/* loaded from: classes10.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator dcC = new LinearInterpolator();
    private ImageView bDd;
    private TextView daA;
    private TextView daB;
    private RelativeLayout dax;
    private TextView daz;
    private Animation dcD;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dax = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bDd = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.daz = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.daA = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.daB = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bDd.setScaleType(ImageView.ScaleType.CENTER);
        this.bDd.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.dcD = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.dcD.setFillAfter(true);
        this.dcD.setInterpolator(dcC);
        this.dcD.setDuration(1200L);
        this.dcD.setRepeatCount(-1);
        this.dcD.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.daB.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.daA.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dax != null ? this.dax.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        aCu();
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aCb() {
        super.aCb();
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        aCu();
        this.bDd.startAnimation(this.dcD);
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.bDd.setRotation(180.0f * f);
        }
    }

    private void aCu() {
        this.bDd.clearAnimation();
        if (c.hasHoneycomb()) {
            this.bDd.setRotation(0.0f);
        }
    }
}
