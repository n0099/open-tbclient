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
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.view.LengthLimitEditText;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes3.dex */
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
    public InputType mInputType;
    public boolean mIsShowBottomLine;
    public int mMaxLength;
    public int mMinLines;
    public boolean mSingleLine;

    /* loaded from: classes3.dex */
    public enum InputType {
        PHONE,
        NAME,
        DETAIL
    }

    public InputFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        int i = 8;
        if (z) {
            String obj = this.mEditText.getText().toString();
            View view3 = this.mCleanEtBtn;
            if (!TextUtils.isEmpty(obj)) {
                i = 0;
            }
            view3.setVisibility(i);
        } else {
            this.mCleanEtBtn.setVisibility(8);
        }
        statInput(z);
    }

    public InputFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SapiSDKInputFormView, i, 0);
        this.mIsShowBottomLine = obtainStyledAttributes.getBoolean(5, true);
        this.mIconResId = obtainStyledAttributes.getResourceId(1, 0);
        this.mMinLines = obtainStyledAttributes.getInt(4, 1);
        this.mSingleLine = obtainStyledAttributes.getBoolean(6, false);
        this.mHintStr = obtainStyledAttributes.getString(0);
        this.mMaxLength = obtainStyledAttributes.getInt(3, 1000);
        this.mInputPhone = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        int i;
        View inflate = LayoutInflater.from(getContext()).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0569, (ViewGroup) this, true);
        this.mEditText = (LengthLimitEditText) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092046);
        this.mImg = (ImageView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092048);
        this.mBottomLine = inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092049);
        this.mCleanEtBtn = inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092044);
        this.mCleanEtBtnDarkShape = inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092045);
        this.mCleanEtBtn.setOnClickListener(this);
        this.mEditText.setOnFocusChangeListener(this);
        this.mEditText.setLengthLimit(this.mMaxLength);
        this.mEditText.setMinLines(this.mMinLines);
        this.mEditText.setSingleLine(this.mSingleLine);
        if (this.mInputPhone) {
            this.mEditText.setInputType(3);
        }
        View view2 = this.mBottomLine;
        if (this.mIsShowBottomLine) {
            i = 0;
        } else {
            i = 4;
        }
        view2.setVisibility(i);
        if (this.mIconResId == 0) {
            this.mImg.setVisibility(8);
        } else {
            this.mImg.setVisibility(0);
            this.mImg.setImageResource(this.mIconResId);
        }
        this.mEditText.setHint(this.mHintStr);
    }

    private void statInput(boolean z) {
        InputType inputType = this.mInputType;
        if (inputType == null) {
            return;
        }
        if (inputType == InputType.NAME) {
            if (z) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_BEGIN_NAME);
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_END_NAME);
            }
        } else if (inputType == InputType.PHONE) {
            if (z) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_BEGIN_PHONE);
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_END_PHONE);
            }
        } else if (inputType == InputType.DETAIL) {
            if (z) {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_BEGIN_ADDRESS);
            } else {
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_END_ADDRESS);
            }
        }
    }

    public void setDarkMode(boolean z) {
        this.isDarkMode = z;
        if (z) {
            this.mEditText.setHintTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0609b3));
            this.mEditText.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0609b7));
            this.mBottomLine.setBackgroundColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0609b1));
        }
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

    public int getLineCount() {
        LengthLimitEditText lengthLimitEditText = this.mEditText;
        if (lengthLimitEditText != null) {
            return lengthLimitEditText.getLineCount();
        }
        return 0;
    }

    public void updateCleanBtnStatus() {
        int i = 8;
        if (TextUtils.isEmpty(this.mEditText.getText().toString())) {
            this.mCleanEtBtn.setVisibility(8);
            this.mCleanEtBtnDarkShape.setVisibility(8);
            return;
        }
        this.mCleanEtBtn.setVisibility(0);
        View view2 = this.mCleanEtBtnDarkShape;
        if (this.isDarkMode) {
            i = 0;
        }
        view2.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == com.baidu.tieba.R.id.obfuscated_res_0x7f092044) {
            this.mEditText.setText("");
            this.mCleanEtBtn.setVisibility(8);
        }
    }

    public void setInputType(InputType inputType) {
        this.mInputType = inputType;
    }

    public void setText(String str) {
        this.mEditText.setText(str);
    }

    public void updateCleanBtnStatus(boolean z) {
        String obj = this.mEditText.getText().toString();
        int i = 8;
        if (z && !TextUtils.isEmpty(obj)) {
            this.mCleanEtBtn.setVisibility(0);
            View view2 = this.mCleanEtBtnDarkShape;
            if (this.isDarkMode) {
                i = 0;
            }
            view2.setVisibility(i);
            return;
        }
        this.mCleanEtBtn.setVisibility(8);
        this.mCleanEtBtnDarkShape.setVisibility(8);
    }
}
