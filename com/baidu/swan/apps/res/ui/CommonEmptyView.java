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
/* loaded from: classes8.dex */
public class CommonEmptyView extends RelativeLayout {
    public ImageView dtf;
    public TextView dtg;
    public TextView dth;
    public TextView dti;
    public FrameLayout dtj;
    public TextView dtk;
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
        this.dtf = (ImageView) findViewById(a.f.emptyview_image);
        this.mTitle = (TextView) findViewById(a.f.emptyview_title);
        this.dtg = (TextView) findViewById(a.f.emptyview_subtitle);
        this.dth = (TextView) findViewById(a.f.emptyview_link);
        this.dti = (TextView) findViewById(a.f.emptyview_btn);
        this.dtj = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
        this.dtk = (TextView) findViewById(a.f.emptyview_problem_feedback);
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
        this.dtg.setVisibility(0);
        this.dtg.setText(str);
        this.dtg.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.dtg.setVisibility(0);
        this.dtg.setText(i);
        this.dtg.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.dtf.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.dtf.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.dti.setText(str);
    }

    public void setButtonText(int i) {
        this.dti.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.dti.setVisibility(0);
        this.dti.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.dth.setVisibility(0);
        this.dth.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dtj != null && this.dtj.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dtj.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.dtj.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.awU().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.awU().O(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.dth != null) {
            this.dth.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.dti != null) {
            this.dti.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.dti.setTextColor(getResources().getColorStateList(a.c.swan_app_emptyview_btn_text_color));
        }
        if (this.dtg != null) {
            this.dtg.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.dti.setTextColor(colorStateList);
    }
}
