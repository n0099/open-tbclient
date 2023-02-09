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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TextFormView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mBottomLine;
    public boolean mIsShowBottomLine;
    public String mTextStr;
    public TextView mTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextFormView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFormView(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SapiSdkTextFormView, i, 0);
        this.mTextStr = obtainStyledAttributes.getString(0);
        this.mIsShowBottomLine = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d050d, (ViewGroup) this, true);
            this.mTextView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e58);
            this.mBottomLine = inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091e53);
            this.mTextView.setText(this.mTextStr);
            View view2 = this.mBottomLine;
            if (this.mIsShowBottomLine) {
                i = 0;
            } else {
                i = 4;
            }
            view2.setVisibility(i);
        }
    }

    public void setDarkMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTextView.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060985));
            this.mBottomLine.setBackgroundColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06097f));
        }
    }
}
