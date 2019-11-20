package com.baidu.swan.apps.res.widget.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.SmoothProgressBar;
/* loaded from: classes2.dex */
public class LoadingView extends FrameLayout implements b<LoadingView> {
    private SmoothProgressBar biC;
    private TextView biD;
    private View mRootView;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_loading_layout, (ViewGroup) this, true);
        this.mRootView = findViewById(a.f.root_container);
        this.biC = (SmoothProgressBar) findViewById(a.f.loading_bar);
        this.biD = (TextView) findViewById(a.f.message);
        setPageResources();
    }

    public void setMsg(int i) {
        this.biD.setText(i);
    }

    public void setMsg(String str) {
        this.biD.setText(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.widget.loadingview.b
    public LoadingView getLoadingView() {
        return this;
    }

    public void setPageResources() {
        if (this.mRootView != null) {
            this.mRootView.setBackground(this.mRootView.getResources().getDrawable(a.e.aiapps_loading_bg));
        }
        if (this.biC != null) {
            this.biC.setIndeterminateDrawable(this.biC.getResources().getDrawable(a.e.aiapps_loading_progress_animation));
        }
        if (this.biD != null) {
            this.biD.setTextColor(this.biD.getResources().getColor(a.c.aiapps_loading_text_color));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.JE().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.widget.loadingview.LoadingView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.JE().F(this);
    }
}
