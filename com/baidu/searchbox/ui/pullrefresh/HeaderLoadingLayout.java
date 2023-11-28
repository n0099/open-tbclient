package com.baidu.searchbox.ui.pullrefresh;

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
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    public static final int ROTATE_ANIM_DURATION = 120;
    public ImageView mArrowImageView;
    public RelativeLayout mHeaderContainer;
    public TextView mHeaderTimeView;
    public TextView mHeaderTimeViewTitle;
    public TextView mHintTextView;
    public ProgressBar mProgressBar;
    public Animation mRotateDownAnim;
    public Animation mRotateUpAnim;

    public HeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        int i;
        TextView textView = this.mHeaderTimeViewTitle;
        if (TextUtils.isEmpty(charSequence)) {
            i = 4;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        this.mHeaderTimeView.setText(charSequence);
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        this.mArrowImageView.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        super.onStateChanged(state, state2);
    }

    private void init(Context context) {
        this.mHeaderContainer = (RelativeLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091ea0);
        this.mArrowImageView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e9e);
        this.mHintTextView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091ea1);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091ea2);
        this.mHeaderTimeView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091ea4);
        this.mHeaderTimeViewTitle = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091ea6);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateUpAnim = rotateAnimation;
        rotateAnimation.setDuration(120L);
        this.mRotateUpAnim.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateDownAnim = rotateAnimation2;
        rotateAnimation2.setDuration(120L);
        this.mRotateDownAnim.setFillAfter(true);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0861, viewGroup, false);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.mHeaderContainer;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07078a);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateDownAnim);
        }
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11d2);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11d1);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11d3);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        this.mArrowImageView.clearAnimation();
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11d2);
    }
}
