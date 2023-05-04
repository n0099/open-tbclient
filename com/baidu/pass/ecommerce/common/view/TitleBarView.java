package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class TitleBarView extends RelativeLayout {
    public boolean isDarkMode;
    public TextView leftBtn;
    public ImageView leftImageBtn;
    public TextView rightBtn;
    public TextView titleTv;

    public TitleBarView(Context context) {
        super(context);
        init();
    }

    public void setRightBtnEnable(boolean z) {
        int color;
        this.rightBtn.setEnabled(z);
        if (this.isDarkMode) {
            TextView textView = this.rightBtn;
            if (z) {
                color = getResources().getColor(R.color.obfuscated_res_0x7f060861);
            } else {
                color = getResources().getColor(R.color.obfuscated_res_0x7f060860);
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

    public void setLeft(String str, View.OnClickListener onClickListener) {
        this.leftBtn.setText(str);
        if (onClickListener != null) {
            this.leftBtn.setOnClickListener(onClickListener);
        }
    }

    public void setLeftBtn(Drawable drawable, View.OnClickListener onClickListener) {
        this.leftImageBtn.setVisibility(0);
        this.leftImageBtn.setImageDrawable(drawable);
        if (onClickListener != null) {
            this.leftImageBtn.setOnClickListener(onClickListener);
        }
    }

    public void setRight(String str, View.OnClickListener onClickListener) {
        this.rightBtn.setText(str);
        if (onClickListener != null) {
            this.rightBtn.setOnClickListener(onClickListener);
        }
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0515, (ViewGroup) this, true);
        this.leftBtn = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f4e);
        this.leftImageBtn = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091f4d);
        this.titleTv = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f50);
        this.rightBtn = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f4f);
    }

    public void setDarkMode() {
        this.isDarkMode = true;
        setBackgroundResource(R.drawable.obfuscated_res_0x7f08115c);
        this.leftBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06085d));
        this.titleTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060863));
        this.rightBtn.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060860));
    }
}
