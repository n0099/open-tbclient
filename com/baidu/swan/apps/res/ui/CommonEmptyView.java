package com.baidu.swan.apps.res.ui;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public class CommonEmptyView extends RelativeLayout {
    public TextView dlS;
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
        LayoutInflater.from(context).inflate(a.g.aiapps_common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(a.c.aiapps_empty_layout_backgroud));
        this.mIcon = (ImageView) findViewById(a.f.emptyview_image);
        this.mTitle = (TextView) findViewById(a.f.emptyview_title);
        this.mSubTitle = (TextView) findViewById(a.f.emptyview_subtitle);
        this.mLinkText = (TextView) findViewById(a.f.emptyview_link);
        this.mRefreshTextBtn = (TextView) findViewById(a.f.emptyview_btn);
        this.mBottomLayout = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
        this.dlS = (TextView) findViewById(a.f.emptyview_problem_feedback);
        setPageResources();
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setTitle(int i) {
        this.mTitle.setText(i);
    }

    public void setTitleColor(int i) {
        this.mTitle.setTextColor(i);
    }

    public void setSubTitle(String str) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(str);
        this.mSubTitle.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(i);
        this.mSubTitle.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
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
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.awo().a(this, new com.baidu.swan.apps.aj.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.awo().unsubscribeNightModeChangedEvent(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.mLinkText != null) {
            this.mLinkText.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.mRefreshTextBtn != null) {
            this.mRefreshTextBtn.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.mRefreshTextBtn.setTextColor(getResources().getColorStateList(a.c.swan_app_emptyview_btn_text_color));
        }
        if (this.mSubTitle != null) {
            this.mSubTitle.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.mRefreshTextBtn.setTextColor(colorStateList);
    }
}
