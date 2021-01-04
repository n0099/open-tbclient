package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes9.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    private ImageView bUf;
    private TextView dAA;
    private Animation dAB;
    private Animation dAC;
    private RelativeLayout dAx;
    private TextView dAy;
    private TextView dAz;
    private ProgressBar mProgressBar;

    public HeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dAx = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bUf = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.dAy = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.dAz = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.dAA = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.dAB = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.dAB.setDuration(120L);
        this.dAB.setFillAfter(true);
        this.dAC = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.dAC.setDuration(120L);
        this.dAC.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.dAA.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.dAz.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dAx != null ? this.dAx.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.bUf.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.bUf.clearAnimation();
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.bUf.clearAnimation();
            this.bUf.startAnimation(this.dAC);
        }
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bUf.clearAnimation();
        this.bUf.startAnimation(this.dAB);
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.bUf.clearAnimation();
        this.bUf.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.dAy.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }
}
