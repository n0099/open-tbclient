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
/* loaded from: classes2.dex */
public class TextFormView extends FrameLayout {
    public View mBottomLine;
    public boolean mIsShowBottomLine;
    public String mTextStr;
    public TextView mTextView;

    public TextFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_sdk_common_text_form, (ViewGroup) this, true);
        this.mTextView = (TextView) inflate.findViewById(R.id.sapi_sdk_common_title_tv);
        this.mBottomLine = inflate.findViewById(R.id.sapi_sdk_common_bottom_line);
        this.mTextView.setText(this.mTextStr);
        this.mBottomLine.setVisibility(this.mIsShowBottomLine ? 0 : 4);
    }

    public void setDarkMode() {
        this.mTextView.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_text_dark_color));
        this.mBottomLine.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
    }

    public TextFormView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SapiSdkTextFormView, i2, 0);
        this.mTextStr = obtainStyledAttributes.getString(R.styleable.SapiSdkTextFormView_SapiSdkActionText);
        this.mIsShowBottomLine = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkTextFormView_SapiSdkShowTextBottomLine, true);
        obtainStyledAttributes.recycle();
        init();
    }
}
