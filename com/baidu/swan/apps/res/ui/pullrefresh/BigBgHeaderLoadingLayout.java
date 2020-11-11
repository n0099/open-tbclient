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
/* loaded from: classes10.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    private ImageView bLE;
    private RelativeLayout doV;
    private TextView doW;
    private TextView doX;
    private TextView doY;
    private Animation doZ;
    private Animation dpa;
    private ImageView dpb;
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
        this.doV = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bLE = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.doW = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.doX = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.doY = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.dpb = (ImageView) findViewById(a.f.pull_to_refresh_header_background);
        this.doZ = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.doZ.setDuration(120L);
        this.doZ.setFillAfter(true);
        this.dpa = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.dpa.setDuration(120L);
        this.dpa.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.doY.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.doX.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.doV != null ? this.doV.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.bLE.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.bLE.clearAnimation();
        this.doW.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.bLE.clearAnimation();
            this.bLE.startAnimation(this.dpa);
        }
        this.doW.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bLE.clearAnimation();
        this.bLE.startAnimation(this.doZ);
        this.doW.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.bLE.clearAnimation();
        this.bLE.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.doW.setText(a.h.aiapps_pull_to_refresh_header_updateing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        if (this.dpb != null) {
            this.dpb.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        float f2 = 0.8f;
        if (this.dpb != null) {
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
            this.dpb.setAlpha(f3);
            this.dpb.setScaleX(f2);
            this.dpb.setScaleY(f2);
            super.onPull(f);
        }
    }
}
