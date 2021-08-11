package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TitleBarView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public TextView leftBtn;
    public TextView rightBtn;
    public TextView titleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_address_title_bar, (ViewGroup) this, true);
            this.leftBtn = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_left_btn);
            this.titleTv = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_title_tv);
            this.rightBtn = (TextView) inflate.findViewById(R.id.sapi_sdk_titlebar_right_btn);
        }
    }

    public void setDarkMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isDarkMode = true;
            setBackgroundResource(R.drawable.sapi_sdk_title_bar_dark_bg);
            this.leftBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_left_text_dark_color));
            this.titleTv.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_text_dark_color));
            this.rightBtn.setTextColor(getResources().getColor(R.color.sapi_sdk_addr_list_title_bar_right_text_dark_color));
        }
    }

    public void setLeft(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, onClickListener) == null) {
            this.leftBtn.setText(str);
            if (onClickListener != null) {
                this.leftBtn.setOnClickListener(onClickListener);
            }
        }
    }

    public void setRight(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.rightBtn.setText(str);
            if (onClickListener != null) {
                this.rightBtn.setOnClickListener(onClickListener);
            }
        }
    }

    public void setRightBtnEnable(boolean z) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
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
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.titleTv.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }
}
