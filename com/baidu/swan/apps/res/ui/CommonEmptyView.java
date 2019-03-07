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
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class CommonEmptyView extends RelativeLayout {
    public TextView aGf;
    public TextView aGg;
    public TextView aGh;
    public FrameLayout aGi;
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
        LayoutInflater.from(context).inflate(b.g.aiapps_common_empty_view, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(b.c.aiapps_empty_layout_backgroud));
        this.mIcon = (ImageView) findViewById(b.f.emptyview_image);
        this.mTitle = (TextView) findViewById(b.f.emptyview_title);
        this.aGf = (TextView) findViewById(b.f.emptyview_subtitle);
        this.aGg = (TextView) findViewById(b.f.emptyview_link);
        this.aGh = (TextView) findViewById(b.f.emptyview_btn);
        this.aGi = (FrameLayout) findViewById(b.f.emptyview_bottom_layout);
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
        this.aGf.setVisibility(0);
        this.aGf.setText(str);
        this.aGf.setTextColor(getContext().getResources().getColor(b.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.aGf.setVisibility(0);
        this.aGf.setText(i);
        this.aGf.setTextColor(getContext().getResources().getColor(b.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.mIcon.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.aGh.setText(str);
    }

    public void setButtonText(int i) {
        this.aGh.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.aGh.setVisibility(0);
        this.aGh.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.aGg.setVisibility(0);
        this.aGg.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aGi != null && this.aGi.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGi.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(b.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(b.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.aGi.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.u.a.CT().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.u.a.CT().H(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(b.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(b.c.aiapps_emptyview_title_text_color));
        }
        if (this.aGg != null) {
            this.aGg.setTextColor(getResources().getColor(b.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.aGh != null) {
            this.aGh.setBackground(getResources().getDrawable(b.e.aiapps_emptyview_btn_bg));
            this.aGh.setTextColor(getResources().getColorStateList(b.c.aiapps_emptyview_btn_text_color));
        }
        if (this.aGf != null) {
            this.aGf.setTextColor(getContext().getResources().getColor(b.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.aGh.setTextColor(colorStateList);
    }
}
