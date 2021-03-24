package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.pass.ecommerce.view.LengthLimitEditText;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class InputFormView extends RelativeLayout implements View.OnClickListener, View.OnFocusChangeListener {
    public static final int MAX_LENGTH = 1000;
    public static final int MIN_LINES = 1;
    public static final int NONE_ICON_RES = 0;
    public boolean isDarkMode;
    public View mBottomLine;
    public View mCleanEtBtn;
    public View mCleanEtBtnDarkShape;
    public LengthLimitEditText mEditText;
    public String mHintStr;
    public int mIconResId;
    public ImageView mImg;
    public boolean mInputPhone;
    public boolean mIsShowBottomLine;
    public int mMaxLength;
    public int mMinLines;
    public boolean mSingleLine;

    public InputFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_sdk_common_input_form, (ViewGroup) this, true);
        this.mEditText = (LengthLimitEditText) inflate.findViewById(R.id.sapi_sdk_input_et);
        this.mImg = (ImageView) inflate.findViewById(R.id.sapi_sdk_input_icon);
        this.mBottomLine = inflate.findViewById(R.id.sapi_sdk_input_line);
        this.mCleanEtBtn = inflate.findViewById(R.id.sapi_sdk_input_clean_icon);
        this.mCleanEtBtnDarkShape = inflate.findViewById(R.id.sapi_sdk_input_clean_icon_dark_shape);
        this.mCleanEtBtn.setOnClickListener(this);
        this.mEditText.setOnFocusChangeListener(this);
        this.mEditText.setLengthLimit(this.mMaxLength);
        this.mEditText.setMinLines(this.mMinLines);
        this.mEditText.setSingleLine(this.mSingleLine);
        if (this.mInputPhone) {
            this.mEditText.setInputType(3);
        }
        this.mBottomLine.setVisibility(this.mIsShowBottomLine ? 0 : 4);
        if (this.mIconResId == 0) {
            this.mImg.setVisibility(8);
        } else {
            this.mImg.setVisibility(0);
            this.mImg.setImageResource(this.mIconResId);
        }
        this.mEditText.setHint(this.mHintStr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.mEditText.clearFocus();
    }

    public String getContent() {
        return this.mEditText.getText().toString().trim();
    }

    public LengthLimitEditText getEditText() {
        return this.mEditText;
    }

    public ImageView getImg() {
        return this.mImg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.sapi_sdk_input_clean_icon) {
            this.mEditText.setText("");
            this.mCleanEtBtn.setVisibility(8);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.mCleanEtBtn.setVisibility(TextUtils.isEmpty(this.mEditText.getText().toString()) ? 8 : 0);
            return;
        }
        this.mCleanEtBtn.setVisibility(8);
    }

    public void setDarkMode(boolean z) {
        this.isDarkMode = z;
        if (z) {
            this.mEditText.setHintTextColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_hint_text_dark_color));
            this.mEditText.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_text_dark_color));
            this.mBottomLine.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
        }
    }

    public void setText(String str) {
        this.mEditText.setText(str);
    }

    public void updateCleanBtnStatus(boolean z) {
        String obj = this.mEditText.getText().toString();
        if (z && !TextUtils.isEmpty(obj)) {
            this.mCleanEtBtn.setVisibility(0);
            this.mCleanEtBtnDarkShape.setVisibility(this.isDarkMode ? 0 : 8);
            return;
        }
        this.mCleanEtBtn.setVisibility(8);
        this.mCleanEtBtnDarkShape.setVisibility(8);
    }

    public InputFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SapiSDKInputFormView, i, 0);
        this.mIsShowBottomLine = obtainStyledAttributes.getBoolean(R.styleable.SapiSDKInputFormView_SapiSdkShowInputBottomLine, true);
        this.mIconResId = obtainStyledAttributes.getResourceId(R.styleable.SapiSDKInputFormView_SapiSdkInputIcon, 0);
        this.mMinLines = obtainStyledAttributes.getInt(R.styleable.SapiSDKInputFormView_SapiSdkMinLines, 1);
        this.mSingleLine = obtainStyledAttributes.getBoolean(R.styleable.SapiSDKInputFormView_SapiSdkSingleLine, false);
        this.mHintStr = obtainStyledAttributes.getString(R.styleable.SapiSDKInputFormView_SapiSdkHint);
        this.mMaxLength = obtainStyledAttributes.getInt(R.styleable.SapiSDKInputFormView_SapiSdkMaxLength, 1000);
        this.mInputPhone = obtainStyledAttributes.getBoolean(R.styleable.SapiSDKInputFormView_SapiSdkInputPhone, false);
        obtainStyledAttributes.recycle();
        init();
    }

    public void updateCleanBtnStatus() {
        if (TextUtils.isEmpty(this.mEditText.getText().toString())) {
            this.mCleanEtBtn.setVisibility(8);
            this.mCleanEtBtnDarkShape.setVisibility(8);
            return;
        }
        this.mCleanEtBtn.setVisibility(0);
        this.mCleanEtBtnDarkShape.setVisibility(this.isDarkMode ? 0 : 8);
    }
}
