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
import com.baidu.swan.apps.aq.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes11.dex */
public class RotateLoadingLayout extends LoadingLayout {
    static final Interpolator cxX = new LinearInterpolator();
    private ImageView bib;
    private RelativeLayout cvT;
    private TextView cvU;
    private TextView cvV;
    private TextView cvW;
    private Animation cxY;

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.cvT = (RelativeLayout) findViewById(a.f.pull_to_refresh_header_content);
        this.bib = (ImageView) findViewById(a.f.pull_to_refresh_header_arrow);
        this.cvU = (TextView) findViewById(a.f.pull_to_refresh_header_hint_textview);
        this.cvV = (TextView) findViewById(a.f.pull_to_refresh_header_time);
        this.cvW = (TextView) findViewById(a.f.pull_to_refresh_last_update_time_text);
        this.bib.setScaleType(ImageView.ScaleType.CENTER);
        this.bib.setImageResource(a.e.aiapps_default_ptr_rotate);
        this.cxY = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.cxY.setFillAfter(true);
        this.cxY.setInterpolator(cxX);
        this.cxY.setDuration(1200L);
        this.cxY.setRepeatCount(-1);
        this.cxY.setRepeatMode(1);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(a.g.aiapps_pull_to_refresh_header2, viewGroup, false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.a(state, state2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        aoa();
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void anH() {
        super.anH();
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_go_home);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        aoa();
        this.bib.startAnimation(this.cxY);
        this.cvU.setText(a.h.aiapps_pull_to_refresh_header_hint_loading);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f) {
        if (b.hasHoneycomb()) {
            this.bib.setRotation(180.0f * f);
        }
    }

    private void aoa() {
        this.bib.clearAnimation();
        if (b.hasHoneycomb()) {
            this.bib.setRotation(0.0f);
        }
    }
}
