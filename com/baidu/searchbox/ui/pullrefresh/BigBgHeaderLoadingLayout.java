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
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    public static final float DEFAULT_FADE_OFFSET = 0.3f;
    public static final float DEFAULT_SCALE_OFFSET = 0.8f;
    public static final int ROTATE_ANIM_DURATION = 120;
    public ImageView mArrowImageView;
    public ImageView mBigBackground;
    public RelativeLayout mHeaderContainer;
    public TextView mHeaderTimeView;
    public TextView mHeaderTimeViewTitle;
    public TextView mHintTextView;
    public ProgressBar mProgressBar;
    public Animation mRotateDownAnim;
    public Animation mRotateUpAnim;

    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        ImageView imageView = this.mBigBackground;
        if (imageView != null) {
            imageView.setBackgroundResource(i);
        }
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

    public BigBgHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
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
        this.mHeaderContainer = (RelativeLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc1);
        this.mArrowImageView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dbf);
        this.mHintTextView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc2);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc3);
        this.mHeaderTimeView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc5);
        this.mHeaderTimeViewTitle = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc7);
        this.mBigBackground = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dc0);
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
        return LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0841, viewGroup, false);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.mHeaderContainer;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07077c);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        if (ILoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateDownAnim);
        }
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11a3);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mArrowImageView.clearAnimation();
        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f11a0);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        this.mArrowImageView.clearAnimation();
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f119f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public void onPull(float f) {
        if (this.mBigBackground == null) {
            return;
        }
        float f2 = f - 0.3f;
        float f3 = 1.0f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f4 = f + 0.8f;
        if (f4 < 0.8f) {
            f3 = 0.8f;
        } else if (f4 <= 1.0f) {
            f3 = f4;
        }
        this.mBigBackground.setAlpha(f2);
        this.mBigBackground.setScaleX(f3);
        this.mBigBackground.setScaleY(f3);
        super.onPull(f);
    }
}
