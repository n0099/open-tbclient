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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.view.LengthLimitEditText;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class InputFormView extends RelativeLayout implements View.OnClickListener, View.OnFocusChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_LENGTH = 1000;
    public static final int MIN_LINES = 1;
    public static final int NONE_ICON_RES = 0;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ab, (ViewGroup) this, true);
            this.mEditText = (LengthLimitEditText) inflate.findViewById(R.id.obfuscated_res_0x7f091b7f);
            this.mImg = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091b81);
            this.mBottomLine = inflate.findViewById(R.id.obfuscated_res_0x7f091b82);
            this.mCleanEtBtn = inflate.findViewById(R.id.obfuscated_res_0x7f091b7d);
            this.mCleanEtBtnDarkShape = inflate.findViewById(R.id.obfuscated_res_0x7f091b7e);
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
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mEditText.clearFocus();
        }
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEditText.getText().toString().trim() : (String) invokeV.objValue;
    }

    public LengthLimitEditText getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEditText : (LengthLimitEditText) invokeV.objValue;
    }

    public ImageView getImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImg : (ImageView) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091b7d) {
            this.mEditText.setText("");
            this.mCleanEtBtn.setVisibility(8);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, view2, z) == null) {
            if (z) {
                this.mCleanEtBtn.setVisibility(TextUtils.isEmpty(this.mEditText.getText().toString()) ? 8 : 0);
                return;
            }
            this.mCleanEtBtn.setVisibility(8);
        }
    }

    public void setDarkMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.isDarkMode = z;
            if (z) {
                this.mEditText.setHintTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060930));
                this.mEditText.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060934));
                this.mBottomLine.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06092e));
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mEditText.setText(str);
        }
    }

    public void updateCleanBtnStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            String obj = this.mEditText.getText().toString();
            if (z && !TextUtils.isEmpty(obj)) {
                this.mCleanEtBtn.setVisibility(0);
                this.mCleanEtBtnDarkShape.setVisibility(this.isDarkMode ? 0 : 8);
                return;
            }
            this.mCleanEtBtn.setVisibility(8);
            this.mCleanEtBtnDarkShape.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04001b, R.attr.obfuscated_res_0x7f04002a, R.attr.obfuscated_res_0x7f04002b, R.attr.obfuscated_res_0x7f04002d, R.attr.obfuscated_res_0x7f04002e, R.attr.obfuscated_res_0x7f040031, R.attr.obfuscated_res_0x7f040033}, i, 0);
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

    public void updateCleanBtnStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (TextUtils.isEmpty(this.mEditText.getText().toString())) {
                this.mCleanEtBtn.setVisibility(8);
                this.mCleanEtBtnDarkShape.setVisibility(8);
                return;
            }
            this.mCleanEtBtn.setVisibility(0);
            this.mCleanEtBtnDarkShape.setVisibility(this.isDarkMode ? 0 : 8);
        }
    }
}
