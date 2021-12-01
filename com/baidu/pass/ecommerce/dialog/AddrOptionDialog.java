package com.baidu.pass.ecommerce.dialog;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AddrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IS_DEFAULT_ADDR = "key_is_default_addr";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView copyView;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView setDefaultView;
    public View setDefaultViewBottomLine;

    /* loaded from: classes8.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_COPY_TYPE = 1003;
        public static final int OPTION_DEL_TYPE = 1002;
        public static final int OPTION_SET_DEFAULT_TYPE = 1001;

        void onOptionClick(int i2);
    }

    @SuppressLint({"ValidFragment"})
    public AddrOptionDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment
    public int getLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.layout_sapi_sdk_address_option_dialog : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.optionOnClickListener != null) {
                int id = view.getId();
                if (id == R.id.sapi_sdk_addr_set_default) {
                    this.optionOnClickListener.onOptionClick(1001);
                } else if (id == R.id.sapi_sdk_addr_copy) {
                    this.optionOnClickListener.onOptionClick(1003);
                } else if (id == R.id.sapi_sdk_addr_del) {
                    this.optionOnClickListener.onOptionClick(1002);
                }
            }
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.setDefaultView = (TextView) view.findViewById(R.id.sapi_sdk_addr_set_default);
            this.setDefaultViewBottomLine = view.findViewById(R.id.sapi_sdk_addr_set_default_bottom_line);
            this.copyView = (TextView) view.findViewById(R.id.sapi_sdk_addr_copy);
            this.setDefaultView.setOnClickListener(this);
            this.copyView.setOnClickListener(this);
            TextView textView = (TextView) view.findViewById(R.id.sapi_sdk_addr_del);
            TextView textView2 = (TextView) view.findViewById(R.id.sapi_sdk_addr_option_cancel);
            textView.setOnClickListener(this);
            textView2.setOnClickListener(this);
            if (this.isDarkMode) {
                Resources resources = getResources();
                this.setDefaultView.setBackgroundResource(R.drawable.sapi_sdk_option_top_round_bg_selector_dark);
                this.setDefaultView.setTextColor(resources.getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
                this.setDefaultViewBottomLine.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
                this.copyView.setBackgroundResource(R.drawable.sapi_sdk_option_common_bg_selector_dark);
                this.copyView.setTextColor(resources.getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
                view.findViewById(R.id.sapi_sdk_addr_copy_bottom_line).setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
                textView.setBackgroundResource(R.drawable.sapi_sdk_option_common_bg_selector_dark);
                textView.setTextColor(resources.getColor(R.color.sapi_sdk_common_del_item_text_dark_color));
                view.findViewById(R.id.sapi_sdk_addr_del_bottom_line).setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
                textView2.setBackgroundResource(R.drawable.sapi_sdk_option_common_bg_selector_dark);
                textView2.setTextColor(resources.getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
            }
            Bundle arguments = getArguments();
            if (arguments != null ? arguments.getBoolean(KEY_IS_DEFAULT_ADDR, false) : false) {
                this.setDefaultView.setText("取消默认");
            } else {
                this.setDefaultView.setText("设为默认地址");
            }
        }
    }

    public void setOptionOnClickListener(OptionOnClickListener optionOnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, optionOnClickListener) == null) {
            this.optionOnClickListener = optionOnClickListener;
        }
    }
}
