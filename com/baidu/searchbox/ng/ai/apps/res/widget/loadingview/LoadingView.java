package com.baidu.searchbox.ng.ai.apps.res.widget.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.SmoothProgressBar;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
/* loaded from: classes2.dex */
public class LoadingView extends FrameLayout implements LoadingViewHolder<LoadingView> {
    private TextView mMsg;
    private SmoothProgressBar mProgressBar;
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
        LayoutInflater.from(getContext()).inflate(R.layout.aiapps_loading_layout, (ViewGroup) this, true);
        this.mRootView = findViewById(R.id.root_container);
        this.mProgressBar = (SmoothProgressBar) findViewById(R.id.loading_bar);
        this.mMsg = (TextView) findViewById(R.id.message);
        setPageResources();
    }

    public void setMsg(int i) {
        this.mMsg.setText(i);
    }

    public void setMsg(String str) {
        this.mMsg.setText(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public LoadingView getLoadingView() {
        return this;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public void show() {
        setVisibility(0);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHolder
    public void dismiss() {
        setVisibility(8);
    }

    public void setPageResources() {
        if (this.mRootView != null) {
            this.mRootView.setBackground(this.mRootView.getResources().getDrawable(R.drawable.aiapps_loading_bg));
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setIndeterminateDrawable(this.mProgressBar.getResources().getDrawable(R.drawable.aiapps_loading_progress_animation));
        }
        if (this.mMsg != null) {
            this.mMsg.setTextColor(this.mMsg.getResources().getColor(R.color.aiapps_loading_text_color));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AiAppNightModeHelper.subscribeNightModeChangeEvent(this, new AiAppNightModeChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingView.1
            @Override // com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener
            public void onNightModeChanged(boolean z) {
                LoadingView.this.setPageResources();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AiAppNightModeHelper.unsubscribeNightModeChangedEvent(this);
    }
}
