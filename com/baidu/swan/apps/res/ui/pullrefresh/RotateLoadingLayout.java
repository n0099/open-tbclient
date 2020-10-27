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
    static final Interpolator dld = new LinearInterpolator();
    private ImageView bFZ;
    private RelativeLayout dja;
    private TextView djb;
    private TextView djc;
    private TextView djd;
    private Animation dle;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.dja = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bFZ = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.djb = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.djc = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.djd = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bFZ.setScaleType(ImageView.ScaleType.CENTER);
        this.bFZ.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.dle = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.dle.setFillAfter(true);
        this.dle.setInterpolator(dld);
        this.dle.setDuration(1200L);
        this.dle.setRepeatCount(-1);
        this.dle.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.djd.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.djc.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.dja != null ? this.dja.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        aEo();
        this.djb.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.djb.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void aDV() {
        super.aDV();
        this.djb.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.djb.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        aEo();
        this.bFZ.startAnimation(this.dle);
        this.djb.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (c.hasHoneycomb()) {
            this.bFZ.setRotation(180.0f * f);
        }
    }

    private void aEo() {
        this.bFZ.clearAnimation();
        if (c.hasHoneycomb()) {
            this.bFZ.setRotation(0.0f);
        }
    }
}
