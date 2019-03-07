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
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator aJU = new LinearInterpolator();
    private RelativeLayout aHI;
    private ImageView aHJ;
    private TextView aHK;
    private TextView aHL;
    private TextView aHM;
    private Animation aJV;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.aHI = (RelativeLayout) findViewById(b.f.pull_to_refresh_header_content);
        this.aHJ = (ImageView) findViewById(b.f.pull_to_refresh_header_arrow);
        this.aHK = (TextView) findViewById(b.f.pull_to_refresh_header_hint_textview);
        this.aHL = (TextView) findViewById(b.f.pull_to_refresh_header_time);
        this.aHM = (TextView) findViewById(b.f.pull_to_refresh_last_update_time_text);
        this.aHJ.setScaleType(ImageView.ScaleType.CENTER);
        this.aHJ.setImageResource(b.e.aiapps_default_ptr_rotate);
        this.aJV = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aJV.setFillAfter(true);
        this.aJV.setInterpolator(aJU);
        this.aJV.setDuration(1200L);
        this.aJV.setRepeatCount(-1);
        this.aJV.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(b.g.aiapps_pull_to_refresh_header2, viewGroup, false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        HG();
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Hm() {
        super.Hm();
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        HG();
        this.aHJ.startAnimation(this.aJV);
        this.aHK.setText(b.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aHJ.setRotation(180.0f * f);
        }
    }

    private void HG() {
        this.aHJ.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aHJ.setRotation(0.0f);
        }
    }
}
