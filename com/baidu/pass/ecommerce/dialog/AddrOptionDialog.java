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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AddrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IS_DEFAULT_ADDR = "key_is_default_addr";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView copyView;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView setDefaultView;
    public View setDefaultViewBottomLine;

    /* loaded from: classes4.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_COPY_TYPE = 1003;
        public static final int OPTION_DEL_TYPE = 1002;
        public static final int OPTION_SET_DEFAULT_TYPE = 1001;

        void onOptionClick(int i);
    }

    @SuppressLint({"ValidFragment"})
    public AddrOptionDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d04c6 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.optionOnClickListener != null) {
                int id = view.getId();
                if (id == R.id.obfuscated_res_0x7f091b6a) {
                    this.optionOnClickListener.onOptionClick(1001);
                } else if (id == R.id.obfuscated_res_0x7f091b3d) {
                    this.optionOnClickListener.onOptionClick(1003);
                } else if (id == R.id.obfuscated_res_0x7f091b48) {
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
            this.setDefaultView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091b6a);
            this.setDefaultViewBottomLine = view.findViewById(R.id.obfuscated_res_0x7f091b6b);
            this.copyView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091b3d);
            this.setDefaultView.setOnClickListener(this);
            this.copyView.setOnClickListener(this);
            TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091b48);
            TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091b62);
            textView.setOnClickListener(this);
            textView2.setOnClickListener(this);
            if (this.isDarkMode) {
                Resources resources = getResources();
                this.setDefaultView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081056);
                this.setDefaultView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06099e));
                this.setDefaultViewBottomLine.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060918));
                this.copyView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081054);
                this.copyView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06099e));
                view.findViewById(R.id.obfuscated_res_0x7f091b3e).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060918));
                textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081054);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06098d));
                view.findViewById(R.id.obfuscated_res_0x7f091b4a).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060918));
                textView2.setBackgroundResource(R.drawable.obfuscated_res_0x7f081054);
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06099e));
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
