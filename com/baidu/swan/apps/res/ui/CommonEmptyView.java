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
/* loaded from: classes9.dex */
public class CommonEmptyView extends RelativeLayout {
    public ImageView dvq;
    public TextView dvr;
    public TextView dvs;
    public TextView dvt;
    public FrameLayout dvu;
    public TextView dvv;
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
        this.dvq = (ImageView) findViewById(a.f.emptyview_image);
        this.mTitle = (TextView) findViewById(a.f.emptyview_title);
        this.dvr = (TextView) findViewById(a.f.emptyview_subtitle);
        this.dvs = (TextView) findViewById(a.f.emptyview_link);
        this.dvt = (TextView) findViewById(a.f.emptyview_btn);
        this.dvu = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
        this.dvv = (TextView) findViewById(a.f.emptyview_problem_feedback);
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
        this.dvr.setVisibility(0);
        this.dvr.setText(str);
        this.dvr.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.dvr.setVisibility(0);
        this.dvr.setText(i);
        this.dvr.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.dvq.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.dvq.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.dvt.setText(str);
    }

    public void setButtonText(int i) {
        this.dvt.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.dvt.setVisibility(0);
        this.dvt.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.dvs.setVisibility(0);
        this.dvs.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dvu != null && this.dvu.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dvu.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.dvu.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.axs().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.axs().O(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.dvs != null) {
            this.dvs.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.dvt != null) {
            this.dvt.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.dvt.setTextColor(getResources().getColorStateList(a.c.swan_app_emptyview_btn_text_color));
        }
        if (this.dvr != null) {
            this.dvr.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.dvt.setTextColor(colorStateList);
    }
}
