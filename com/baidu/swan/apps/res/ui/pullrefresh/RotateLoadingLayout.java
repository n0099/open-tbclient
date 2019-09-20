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
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator aMY = new LinearInterpolator();
    private RelativeLayout aKM;
    private ImageView aKN;
    private TextView aKO;
    private TextView aKP;
    private TextView aKQ;
    private Animation aMZ;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.aKM = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.aKN = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.aKO = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.aKP = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.aKQ = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.aKN.setScaleType(ImageView.ScaleType.CENTER);
        this.aKN.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.aMZ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aMZ.setFillAfter(true);
        this.aMZ.setInterpolator(aMY);
        this.aMZ.setDuration(1200L);
        this.aMZ.setRepeatCount(-1);
        this.aMZ.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.aKQ.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.aKP.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.aKM != null ? this.aKM.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        KL();
        this.aKO.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.aKO.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Kr() {
        super.Kr();
        this.aKO.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.aKO.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        KL();
        this.aKN.startAnimation(this.aMZ);
        this.aKO.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aKN.setRotation(180.0f * f);
        }
    }

    private void KL() {
        this.aKN.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.aKN.setRotation(0.0f);
        }
    }
}
