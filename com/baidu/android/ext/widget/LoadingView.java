package com.baidu.android.ext.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.common.loading.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.SmoothProgressBar;
/* loaded from: classes10.dex */
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
        LayoutInflater.from(getContext()).inflate(R.layout.novel_loading_layout, (ViewGroup) this, true);
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
    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public LoadingView getLoadingView() {
        return this;
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void show() {
        setVisibility(0);
    }

    @Override // com.baidu.android.ext.widget.LoadingViewHolder
    public void dismiss() {
        setVisibility(8);
    }

    public void setPageResources() {
        if (this.mRootView != null) {
            this.mRootView.setBackground(this.mRootView.getResources().getDrawable(R.drawable.novel_loading_bg));
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setIndeterminateDrawable(this.mProgressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
        }
        if (this.mMsg != null) {
            this.mMsg.setTextColor(this.mMsg.getResources().getColor(R.color.loading_text_color));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.android.ext.widget.LoadingView.1
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                LoadingView.this.setPageResources();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }
}
