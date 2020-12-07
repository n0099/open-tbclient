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
/* loaded from: classes25.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    private ImageView bPb;
    private RelativeLayout duo;
    private TextView dup;
    private TextView duq;
    private TextView dur;
    private Animation dus;
    private Animation dut;
    private ImageView duu;
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
        this.duo = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bPb = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.dup = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(a.f.pull_to_refresh_header_progressbar);
        this.duq = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.dur = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.duu = (ImageView) findViewById(a.f.pull_to_refresh_header_background);
        this.dus = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.dus.setDuration(120L);
        this.dus.setFillAfter(true);
        this.dut = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.dut.setDuration(120L);
        this.dut.setFillAfter(true);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.dur.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.duq.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.duo != null ? this.duo.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.bPb.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.bPb.clearAnimation();
        this.dup.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.bPb.clearAnimation();
            this.bPb.startAnimation(this.dut);
        }
        this.dup.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.bPb.clearAnimation();
        this.bPb.startAnimation(this.dus);
        this.dup.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.bPb.clearAnimation();
        this.bPb.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.dup.setText(a.h.aiapps_pull_to_refresh_header_updateing);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        if (this.duu != null) {
            this.duu.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        float f2 = 0.8f;
        if (this.duu != null) {
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
            this.duu.setAlpha(f3);
            this.duu.setScaleX(f2);
            this.duu.setScaleY(f2);
            super.onPull(f);
        }
    }
}
