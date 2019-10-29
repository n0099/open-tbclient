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
    static final Interpolator bgi = new LinearInterpolator();
    private RelativeLayout bdZ;
    private ImageView bea;
    private TextView beb;
    private TextView bec;
    private TextView bed;
    private Animation bgj;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.bdZ = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bea = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.beb = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.bec = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.bed = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bea.setScaleType(ImageView.ScaleType.CENTER);
        this.bea.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.bgj = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bgj.setFillAfter(true);
        this.bgj.setInterpolator(bgi);
        this.bgj.setDuration(1200L);
        this.bgj.setRepeatCount(-1);
        this.bgj.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.bed.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.bec.setText(charSequence);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        return this.bdZ != null ? this.bdZ.getHeight() : (int) getResources().getDimension(a.d.aiapps_picture_pull_to_refresh_height_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        PE();
        this.beb.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.beb.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void Pk() {
        super.Pk();
        this.beb.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.beb.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        PE();
        this.bea.startAnimation(this.bgj);
        this.beb.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.bea.setRotation(180.0f * f);
        }
    }

    private void PE() {
        this.bea.clearAnimation();
        if (com.baidu.swan.apps.an.a.hasHoneycomb()) {
            this.bea.setRotation(0.0f);
        }
    }
}
