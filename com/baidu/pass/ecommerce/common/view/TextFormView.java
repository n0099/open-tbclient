package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes3.dex */
public class TextFormView extends FrameLayout {
    public View mBottomLine;
    public boolean mIsShowBottomLine;
    public String mTextStr;
    public TextView mTextView;

    public TextFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SapiSdkTextFormView, i, 0);
        this.mTextStr = obtainStyledAttributes.getString(0);
        this.mIsShowBottomLine = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        int i;
        View inflate = LayoutInflater.from(getContext()).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d055d, (ViewGroup) this, true);
        this.mTextView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f71);
        this.mBottomLine = inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091f6c);
        this.mTextView.setText(this.mTextStr);
        View view2 = this.mBottomLine;
        if (this.mIsShowBottomLine) {
            i = 0;
        } else {
            i = 4;
        }
        view2.setVisibility(i);
    }

    public void setDarkMode() {
        this.mTextView.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0609ae));
        this.mBottomLine.setBackgroundColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0609a8));
    }
}
