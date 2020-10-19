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
    private ImageView bDd;
    private TextView daA;
    private TextView daB;
    private Animation daC;
    private Animation daD;
    private ImageView daE;
    private RelativeLayout dax;
    private TextView daz;
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
        this.dax = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bDd = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.daz = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.daA = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.daB = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.daE = (ImageView) findViewById(a.f.pull_to_refresh_header_background);
        this.daC = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.daC.setDuration(120L);
        this.daC.setFillAfter(true);
        this.daD = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.daD.setDuration(120L);
        this.daD.setFillAfter(true);
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

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.bDd.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.bDd.clearAnimation();
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.bDd.clearAnimation();
            this.bDd.startAnimation(this.daD);
        }
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bDd.clearAnimation();
        this.bDd.startAnimation(this.daC);
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.bDd.clearAnimation();
        this.bDd.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.daz.setText(a.h.aiapps_pull_to_refresh_header_updateing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        if (this.daE != null) {
            this.daE.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        float f2 = 0.8f;
        if (this.daE != null) {
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
            this.daE.setAlpha(f3);
            this.daE.setScaleX(f2);
            this.daE.setScaleY(f2);
            super.onPull(f);
        }
    }
}
