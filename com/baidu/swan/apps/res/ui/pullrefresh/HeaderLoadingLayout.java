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
/* loaded from: classes2.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    private RelativeLayout aHN;
    private ImageView aHO;
    private TextView aHP;
    private TextView aHQ;
    private TextView aHR;
    private Animation aHS;
    private Animation aHT;
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
        this.aHN = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aHO = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.aHP = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.aHQ = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.aHR = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aHS = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.aHS.setDuration(120L);
        this.aHS.setFillAfter(true);
        this.aHT = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aHT.setDuration(120L);
        this.aHT.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.aHR.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.aHQ.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aHN != null ? this.aHN.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.aHO.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.aHO.clearAnimation();
        this.aHP.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.aHO.clearAnimation();
            this.aHO.startAnimation(this.aHT);
        }
        this.aHP.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aHO.clearAnimation();
        this.aHO.startAnimation(this.aHS);
        this.aHP.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.aHO.clearAnimation();
        this.aHO.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.aHP.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }
}
