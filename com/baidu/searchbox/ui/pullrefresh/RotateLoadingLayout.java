package com.baidu.searchbox.ui.pullrefresh;

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
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    public static final int ROTATION_ANIMATION_DURATION = 1200;
    public ImageView mArrowImageView;
    public RelativeLayout mHeaderContainer;
    public TextView mHeaderTimeView;
    public TextView mHeaderTimeViewTitle;
    public TextView mHintTextView;
    public Animation mRotateAnimation;

    private void resetRotation() {
        this.mArrowImageView.clearAnimation();
        if (DeviceUtil.OSInfo.hasHoneycomb()) {
            this.mArrowImageView.setRotation(0.0f);
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.mHeaderContainer;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070776);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1179);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        resetRotation();
        this.mArrowImageView.startAnimation(this.mRotateAnimation);
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1178);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        super.onReleaseToLongRefresh();
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1177);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f117a);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        resetRotation();
        this.mHintTextView.setText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1179);
    }

    public RotateLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public void onPull(float f) {
        if (DeviceUtil.OSInfo.hasHoneycomb()) {
            this.mArrowImageView.setRotation(f * 180.0f);
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

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.onStateChanged(state, state2);
    }

    private void init(Context context) {
        this.mHeaderContainer = (RelativeLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091da5);
        this.mArrowImageView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091da3);
        this.mHintTextView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091da6);
        this.mHeaderTimeView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091da9);
        this.mHeaderTimeViewTitle = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091dab);
        this.mArrowImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.mArrowImageView.setImageResource(com.baidu.tieba.R.drawable.default_ptr_rotate);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        rotateAnimation.setFillAfter(true);
        this.mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        this.mRotateAnimation.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0828, viewGroup, false);
    }
}
