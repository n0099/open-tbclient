package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.util.HostResourceManager;
/* loaded from: classes6.dex */
public class CommonEmptyView extends FrameLayout {
    private LinearLayout mContentView;
    private ImageView mImgView;
    private TextView mRefreshButton;
    private TextView mSubTitleView;
    private TextView mTitleView;

    /* loaded from: classes6.dex */
    public enum ImgType {
        NO_IMG,
        NO_NET,
        SERVER_ERROR,
        NO_DATA,
        NO_RANK_LIST,
        NO_FOLLOW,
        NO_FAN
    }

    /* loaded from: classes6.dex */
    public enum StyleType {
        LIGHT,
        DARK
    }

    public CommonEmptyView(Context context) {
        super(context);
        init();
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_common_empty_view, this);
        this.mContentView = (LinearLayout) findViewById(a.g.sdk_cev_content);
        this.mImgView = (ImageView) findViewById(a.g.sdk_cev_img);
        this.mTitleView = (TextView) findViewById(a.g.sdk_cev_title);
        this.mSubTitleView = (TextView) findViewById(a.g.sdk_cev_sub_title);
        this.mRefreshButton = (TextView) findViewById(a.g.sdk_cev_refresh_btn);
        reset();
    }

    public CommonEmptyView setup(ImgType imgType, StyleType styleType) {
        setImg(imgType, styleType);
        setCommonStyle(styleType);
        return this;
    }

    public CommonEmptyView setTitle(int i) {
        this.mTitleView.setText(i);
        this.mTitleView.setVisibility(0);
        return this;
    }

    public CommonEmptyView setTitle(String str) {
        this.mTitleView.setText(str);
        this.mTitleView.setVisibility(0);
        return this;
    }

    public CommonEmptyView setSubTitle(int i) {
        this.mSubTitleView.setText(i);
        this.mSubTitleView.setVisibility(0);
        return this;
    }

    public CommonEmptyView setSubTitle(String str) {
        this.mSubTitleView.setText(str);
        this.mSubTitleView.setVisibility(0);
        return this;
    }

    public CommonEmptyView setRefreshButton(int i, View.OnClickListener onClickListener) {
        this.mRefreshButton.setText(i);
        this.mRefreshButton.setVisibility(0);
        this.mRefreshButton.setOnClickListener(onClickListener);
        return this;
    }

    public CommonEmptyView setRefreshButton(String str, View.OnClickListener onClickListener) {
        this.mRefreshButton.setText(str);
        this.mRefreshButton.setVisibility(0);
        this.mRefreshButton.setOnClickListener(onClickListener);
        return this;
    }

    public void addToParent(RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            relativeLayout.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void addToParent(FrameLayout frameLayout) {
        if (frameLayout != null) {
            frameLayout.addView(this, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void reset() {
        this.mImgView.setVisibility(8);
        this.mTitleView.setVisibility(8);
        this.mSubTitleView.setVisibility(8);
        this.mRefreshButton.setVisibility(8);
    }

    private void setImg(ImgType imgType, StyleType styleType) {
        Drawable emotionDrawable = HostResourceManager.getInstance().getEmotionDrawable(imgType, styleType);
        if (emotionDrawable != null) {
            this.mImgView.setVisibility(0);
            this.mImgView.setImageDrawable(emotionDrawable);
        }
    }

    private void setCommonStyle(StyleType styleType) {
        if (styleType == StyleType.DARK) {
            this.mTitleView.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_title_text_dark));
            this.mSubTitleView.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_sub_title_text_dark));
            this.mRefreshButton.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_btn_text_dark_selector));
            this.mRefreshButton.setBackgroundResource(a.f.sdk_cev_btn_bg_dark_selector);
            return;
        }
        this.mTitleView.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_title_text_light));
        this.mSubTitleView.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_sub_title_text_light));
        this.mRefreshButton.setTextColor(getContext().getResources().getColor(a.d.sdk_cev_btn_text_light_selector));
        this.mRefreshButton.setBackgroundResource(a.f.sdk_cev_btn_bg_light_selector);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() == 1) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = (i3 - i) - getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = paddingLeft + (((paddingRight - paddingLeft) - measuredWidth) / 2);
                int i6 = ((int) (((((i4 - i2) - paddingTop) - paddingBottom) - measuredHeight) * 0.38f)) + paddingTop;
                childAt.layout(i5, i6, measuredWidth + i5, i6 + measuredHeight);
                return;
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }
}
