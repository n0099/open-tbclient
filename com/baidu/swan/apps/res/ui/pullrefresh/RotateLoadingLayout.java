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
import com.baidu.swan.apps.aq.c;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator cFu = new LinearInterpolator();
    private ImageView bnD;
    private RelativeLayout cDr;
    private TextView cDs;
    private TextView cDt;
    private TextView cDu;
    private Animation cFv;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.cDr = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bnD = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cDs = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.cDt = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cDu = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bnD.setScaleType(ImageView.ScaleType.CENTER);
        this.bnD.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cFv = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cFv.setFillAfter(true);
        this.cFv.setInterpolator(cFu);
        this.cFv.setDuration(1200L);
        this.cFv.setRepeatCount(-1);
        this.cFv.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.cDu.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.cDt.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.cDr != null ? this.cDr.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        aqQ();
        this.cDs.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cDs.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aqx() {
        super.aqx();
        this.cDs.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cDs.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        aqQ();
        this.bnD.startAnimation(this.cFv);
        this.cDs.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.bnD.setRotation(180.0f * f);
        }
    }

    private void aqQ() {
        this.bnD.clearAnimation();
        if (c.hasHoneycomb()) {
            this.bnD.setRotation(0.0f);
        }
    }
}
