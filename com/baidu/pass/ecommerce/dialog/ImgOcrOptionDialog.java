package com.baidu.pass.ecommerce.dialog;

import android.annotation.SuppressLint;
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
/* loaded from: classes2.dex */
public class ImgOcrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView cancelTv;
    public TextView chooseImgTv;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView takePhotoTv;

    /* loaded from: classes2.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_CHOOSE_IMG_TYPE = 1002;
        public static final int OPTION_TAKE_PHOTO_TYPE = 1001;

        void onOptionClick(int i);
    }

    @SuppressLint({"ValidFragment"})
    public ImgOcrOptionDialog(boolean z) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d04dd : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (this.optionOnClickListener != null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091c4d) {
                    this.optionOnClickListener.onOptionClick(1001);
                } else if (id == R.id.obfuscated_res_0x7f091bd9) {
                    this.optionOnClickListener.onOptionClick(1002);
                }
            }
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.takePhotoTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c4d);
            this.chooseImgTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bd9);
            this.cancelTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c37);
            if (this.isDarkMode) {
                this.takePhotoTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081001);
                this.takePhotoTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a2));
                view2.findViewById(R.id.obfuscated_res_0x7f091c4e).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060923));
                this.chooseImgTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fff);
                this.chooseImgTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a2));
                view2.findViewById(R.id.obfuscated_res_0x7f091bda).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06094d));
                this.cancelTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fff);
                this.cancelTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609a2));
            }
            this.takePhotoTv.setOnClickListener(this);
            this.chooseImgTv.setOnClickListener(this);
            this.cancelTv.setOnClickListener(this);
        }
    }

    public void setOptionOnClickListener(OptionOnClickListener optionOnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, optionOnClickListener) == null) {
            this.optionOnClickListener = optionOnClickListener;
        }
    }
}
