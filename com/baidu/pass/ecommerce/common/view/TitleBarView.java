package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class TitleBarView extends RelativeLayout {
    public boolean isDarkMode;
    public TextView leftBtn;
    public TextView rightBtn;
    public TextView titleTv;

    public TitleBarView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_address_title_bar, (ViewGroup) this, true);
        this.leftBtn = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_left_btn);
        this.titleTv = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_title_tv);
        this.rightBtn = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_right_btn);
    }

    public void setDarkMode() {
        this.isDarkMode = true;
        setBackgroundResource(R.drawable.sapi_sdk_title_bar_dark_bg);
        this.leftBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_left_text_dark_color));
        this.titleTv.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_text_dark_color));
        this.rightBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_right_text_dark_color));
    }

    public void setLeft(String str, View.OnClickListener onClickListener) {
        this.leftBtn.setText(str);
        if (onClickListener != null) {
            this.leftBtn.setOnClickListener(onClickListener);
        }
    }

    public void setRight(String str, View.OnClickListener onClickListener) {
        this.rightBtn.setText(str);
        if (onClickListener != null) {
            this.rightBtn.setOnClickListener(onClickListener);
        }
    }

    public void setRightBtnEnable(boolean z) {
        int color;
        this.rightBtn.setEnabled(z);
        if (this.isDarkMode) {
            TextView textView = this.rightBtn;
            if (z) {
                color = getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_right_text_dark_color_enable);
            } else {
                color = getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_right_text_dark_color);
            }
            textView.setTextColor(color);
        }
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
