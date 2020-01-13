package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
/* loaded from: classes12.dex */
public class CommonEmptyView extends RelativeLayout {
    public FrameLayout mBottomLayout;
    public ImageView mIcon;
    public TextView mLinkText;
    public TextView mRefreshTextBtn;
    public TextView mSubTitle;
    public TextView mTitle;

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(com.baidu.android.common.ui.R.color.empty_layout_backgroud));
        this.mIcon = (ImageView) findViewById(com.baidu.android.common.ui.R.id.emptyview_image);
        this.mTitle = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_title);
        this.mSubTitle = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_subtitle);
        this.mLinkText = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_link);
        this.mRefreshTextBtn = (TextView) findViewById(com.baidu.android.common.ui.R.id.emptyview_btn);
        this.mBottomLayout = (FrameLayout) findViewById(com.baidu.android.common.ui.R.id.emptyview_bottom_layout);
        setPageResources();
    }

    public void resetIconWidthAndHeight() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIcon.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.empty_view_icon_size) / 2;
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        this.mIcon.setLayoutParams(layoutParams);
    }

    public void setTitle(int i) {
        this.mTitle.setText(i);
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleColor(int i) {
        this.mTitle.setTextColor(i);
    }

    public void setSubTitle(String str) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(str);
        this.mSubTitle.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.R.color.emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(i);
        this.mSubTitle.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.R.color.emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.mIcon.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.mRefreshTextBtn.setText(str);
    }

    public void setButtonText(int i) {
        this.mRefreshTextBtn.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.mRefreshTextBtn.setVisibility(0);
        this.mRefreshTextBtn.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.mLinkText.setVisibility(0);
        this.mLinkText.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mBottomLayout != null && this.mBottomLayout.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.android.common.ui.R.dimen.empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.android.common.ui.R.dimen.empty_view_bottom_margin_landscape);
            }
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.CommonEmptyView.1
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                CommonEmptyView.this.setPageResources();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.R.color.white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.emptyview_title_text_color));
        }
        if (this.mLinkText != null) {
            this.mLinkText.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.emptyview_subtitle_text_color));
        }
        if (this.mRefreshTextBtn != null) {
            this.mRefreshTextBtn.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.emptyview_btn_bg));
            this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(com.baidu.android.common.ui.R.color.emptyview_btn_text_color));
        }
        if (this.mSubTitle != null) {
            this.mSubTitle.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.R.color.emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.mRefreshTextBtn.setTextColor(colorStateList);
    }
}
