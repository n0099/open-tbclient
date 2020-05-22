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
/* loaded from: classes11.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    private ImageView bib;
    private RelativeLayout cvT;
    private TextView cvU;
    private TextView cvV;
    private TextView cvW;
    private Animation cvX;
    private Animation cvY;
    private ImageView cvZ;
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
        this.cvT = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bib = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cvU = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.cvV = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cvW = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.cvZ = (ImageView) findViewById(a.f.pull_to_refresh_header_background);
        this.cvX = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.cvX.setDuration(120L);
        this.cvX.setFillAfter(true);
        this.cvY = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cvY.setDuration(120L);
        this.cvY.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.cvW.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.cvV.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cvT != null ? this.cvT.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.bib.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.bib.clearAnimation();
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.bib.clearAnimation();
            this.bib.startAnimation(this.cvY);
        }
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bib.clearAnimation();
        this.bib.startAnimation(this.cvX);
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.bib.clearAnimation();
        this.bib.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_updateing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        if (this.cvZ != null) {
            this.cvZ.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        float f2 = 0.8f;
        if (this.cvZ != null) {
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
            this.cvZ.setAlpha(f3);
            this.cvZ.setScaleX(f2);
            this.cvZ.setScaleY(f2);
            super.onPull(f);
        }
    }
}
