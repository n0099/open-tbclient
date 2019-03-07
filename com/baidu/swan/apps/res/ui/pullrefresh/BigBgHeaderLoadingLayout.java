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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    private RelativeLayout aHI;
    private ImageView aHJ;
    private TextView aHK;
    private TextView aHL;
    private TextView aHM;
    private Animation aHN;
    private Animation aHO;
    private ImageView aHP;
    private ProgressBar mProgressBar;

    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public BigBgHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.aHI = (RelativeLayout) findViewById(b.f.pull_to_refresh_header_content);
        this.aHJ = (ImageView) findViewById(b.f.pull_to_refresh_header_arrow);
        this.aHK = (TextView) findViewById(b.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(b.f.pull_to_refresh_header_progressbar);
        this.aHL = (TextView) findViewById(b.f.pull_to_refresh_header_time);
        this.aHM = (TextView) findViewById(b.f.pull_to_refresh_last_update_time_text);
        this.aHP = (ImageView) findViewById(b.f.pull_to_refresh_header_background);
        this.aHN = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.aHN.setDuration(120L);
        this.aHN.setFillAfter(true);
        this.aHO = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.aHO.setDuration(120L);
        this.aHO.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.aHM.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.aHL.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aHI != null ? this.aHI.getHeight() : (int) getResources().getDimension(b.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(b.g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.aHJ.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.aHJ.clearAnimation();
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.aHJ.clearAnimation();
            this.aHJ.startAnimation(this.aHO);
        }
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aHJ.clearAnimation();
        this.aHJ.startAnimation(this.aHN);
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.aHJ.clearAnimation();
        this.aHJ.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_updateing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        if (this.aHP != null) {
            this.aHP.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        float f2 = 0.8f;
        if (this.aHP != null) {
            float f3 = f - 0.3f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            } else if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            float f4 = f + 0.8f;
            if (f4 >= 0.8f) {
                f2 = f4 > 1.0f ? 1.0f : f4;
            }
            this.aHP.setAlpha(f3);
            this.aHP.setScaleX(f2);
            this.aHP.setScaleY(f2);
            super.onPull(f);
        }
    }
}
