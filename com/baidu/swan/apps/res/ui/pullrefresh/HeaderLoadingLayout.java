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
/* loaded from: classes8.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    private ImageView btj;
    private RelativeLayout cMt;
    private TextView cMu;
    private TextView cMv;
    private TextView cMw;
    private Animation cMx;
    private Animation cMy;
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
        this.cMt = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.btj = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cMu = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.cMv = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cMw = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.cMx = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.cMx.setDuration(120L);
        this.cMx.setFillAfter(true);
        this.cMy = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cMy.setDuration(120L);
        this.cMy.setFillAfter(true);
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

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.btj.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.btj.clearAnimation();
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.btj.clearAnimation();
            this.btj.startAnimation(this.cMy);
        }
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.btj.clearAnimation();
        this.btj.startAnimation(this.cMx);
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.btj.clearAnimation();
        this.btj.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.cMu.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }
}
