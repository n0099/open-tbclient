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
/* loaded from: classes2.dex */
public class CommonEmptyView extends RelativeLayout {
    public TextView aIL;
    public TextView aIM;
    public TextView aIN;
    public FrameLayout aIO;
    public ImageView mIcon;
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
        this.aIL = (TextView) findViewById(a.f.emptyview_subtitle);
        this.aIM = (TextView) findViewById(a.f.emptyview_link);
        this.aIN = (TextView) findViewById(a.f.emptyview_btn);
        this.aIO = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
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
        this.aIL.setVisibility(0);
        this.aIL.setText(str);
        this.aIL.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.aIL.setVisibility(0);
        this.aIL.setText(i);
        this.aIL.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.mIcon.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.aIN.setText(str);
    }

    public void setButtonText(int i) {
        this.aIN.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.aIN.setVisibility(0);
        this.aIN.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.aIM.setVisibility(0);
        this.aIM.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aIO != null && this.aIO.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIO.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.aIO.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.EF().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.EF().H(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.aIM != null) {
            this.aIM.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.aIN != null) {
            this.aIN.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.aIN.setTextColor(getResources().getColorStateList(a.c.aiapps_emptyview_btn_text_color));
        }
        if (this.aIL != null) {
            this.aIL.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.aIN.setTextColor(colorStateList);
    }
}
