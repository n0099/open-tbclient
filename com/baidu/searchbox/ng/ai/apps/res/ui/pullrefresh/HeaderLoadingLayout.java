package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

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
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    private static final int ROTATE_ANIM_DURATION = 120;
    private ImageView mArrowImageView;
    private RelativeLayout mHeaderContainer;
    private TextView mHeaderTimeView;
    private TextView mHeaderTimeViewTitle;
    private TextView mHintTextView;
    private ProgressBar mProgressBar;
    private Animation mRotateDownAnim;
    private Animation mRotateUpAnim;

    public HeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mHeaderContainer = (RelativeLayout) findViewById(R.id.pull_to_refresh_header_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.pull_to_refresh_header_arrow);
        this.mHintTextView = (TextView) findViewById(R.id.pull_to_refresh_header_hint_textview);
        this.mProgressBar = (ProgressBar) findViewById(R.id.pull_to_refresh_header_progressbar);
        this.mHeaderTimeView = (TextView) findViewById(R.id.pull_to_refresh_header_time);
        this.mHeaderTimeViewTitle = (TextView) findViewById(R.id.pull_to_refresh_last_update_time_text);
        this.mRotateUpAnim = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim.setDuration(120L);
        this.mRotateUpAnim.setFillAfter(true);
        this.mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim.setDuration(120L);
        this.mRotateDownAnim.setFillAfter(true);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.mHeaderTimeViewTitle.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
        this.mHeaderTimeView.setText(charSequence);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        return this.mHeaderContainer != null ? this.mHeaderContainer.getHeight() : (int) getResources().getDimension(R.dimen.aiapps_picture_pull_to_refresh_height_height);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(R.layout.aiapps_pull_to_refresh_header, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.mArrowImageView.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.mArrowImageView.clearAnimation();
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateDownAnim);
        }
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_normal);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_ready);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.mHintTextView.setText(R.string.aiapps_pull_to_refresh_header_hint_loading);
    }
}
