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
    public ImageView dxS;
    public TextView dxT;
    public TextView dxU;
    public TextView dxV;
    public FrameLayout dxW;
    public TextView dxX;
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
        this.dxS = (ImageView) findViewById(a.f.emptyview_image);
        this.mTitle = (TextView) findViewById(a.f.emptyview_title);
        this.dxT = (TextView) findViewById(a.f.emptyview_subtitle);
        this.dxU = (TextView) findViewById(a.f.emptyview_link);
        this.dxV = (TextView) findViewById(a.f.emptyview_btn);
        this.dxW = (FrameLayout) findViewById(a.f.emptyview_bottom_layout);
        this.dxX = (TextView) findViewById(a.f.emptyview_problem_feedback);
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
        this.dxT.setVisibility(0);
        this.dxT.setText(str);
        this.dxT.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setSubTitle(int i) {
        this.dxT.setVisibility(0);
        this.dxT.setText(i);
        this.dxT.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
    }

    public void setIcon(Drawable drawable) {
        this.dxS.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.dxS.setImageDrawable(getResources().getDrawable(i));
    }

    public void setButtonText(String str) {
        this.dxV.setText(str);
    }

    public void setButtonText(int i) {
        this.dxV.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.dxV.setVisibility(0);
        this.dxV.setOnClickListener(onClickListener);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.dxU.setVisibility(0);
        this.dxU.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dxW != null && this.dxW.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dxW.getLayoutParams();
            if (configuration.orientation == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_portrait);
            } else if (configuration.orientation == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(a.d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.dxW.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.swan.apps.t.a.aAO().a(this, new com.baidu.swan.apps.ai.a() { // from class: com.baidu.swan.apps.res.ui.CommonEmptyView.1
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.swan.apps.t.a.aAO().O(this);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(a.c.aiapps_white));
        if (this.mTitle != null) {
            this.mTitle.setTextColor(getResources().getColor(a.c.aiapps_emptyview_title_text_color));
        }
        if (this.dxU != null) {
            this.dxU.setTextColor(getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
        if (this.dxV != null) {
            this.dxV.setBackground(getResources().getDrawable(a.e.aiapps_emptyview_btn_bg));
            this.dxV.setTextColor(getResources().getColorStateList(a.c.swan_app_emptyview_btn_text_color));
        }
        if (this.dxT != null) {
            this.dxT.setTextColor(getContext().getResources().getColor(a.c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.dxV.setTextColor(colorStateList);
    }
}
