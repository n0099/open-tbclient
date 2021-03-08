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
    public ImageView dwR;
    public TextView dwS;
    public TextView dwT;
    public TextView dwU;
    public FrameLayout dwV;
    public TextView dwW;
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
        this.dwR = (ImageView) findViewById(a.f.emptyview_image);
        this.mTitle = (TextView) findViewById(a.f.emptyview_title);
        this.dwS = (TextView) findViewById(a.f.emptyview_subtitle);
        this.dwT = (TextView) findViewById(a.f.emptyview_link);
        this.dwU = (TextView) findViewById(a.f.emptyview_btn);
        this.dwV = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
        this.dwW = (TextView) findViewById(a.f.emptyview_problem_feedback);
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
        this.dwS.setVisibility(0);
        this.dwS.setText(str);
        this.dwS.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.dwS.setVisibility(0);
        this.dwS.setText(i);
        this.dwS.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.dwR.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.dwR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.dwU.setText(str);
    }

    public void setButtonText(int i) {
        this.dwU.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.dwU.setVisibility(0);
        this.dwU.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.dwT.setVisibility(0);
        this.dwT.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dwV != null && this.dwV.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwV.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.dwV.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.axv().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.axv().Q(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.dwT != null) {
            this.dwT.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.dwU != null) {
            this.dwU.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.dwU.setTextColor(getResources().getColorStateList(a.c.swan_app_emptyview_btn_text_color));
        }
        if (this.dwS != null) {
            this.dwS.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.dwU.setTextColor(colorStateList);
    }
}
