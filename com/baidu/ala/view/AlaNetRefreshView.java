package com.baidu.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ch5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaNetRefreshView extends ch5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mNetFailTipView;
    public TextView mNetRefreshBtn;
    public LinearLayout mNetRefreshContainer;
    public ImageView mNetRefreshImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNetRefreshView(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0100, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNetRefreshImg = (ImageView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f090209);
        this.mNetFailTipView = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09020a);
        this.mNetRefreshBtn = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f090207);
        this.mNetRefreshContainer = (LinearLayout) this.attachedView.findViewById(R.id.obfuscated_res_0x7f090208);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.mNetFailTipView;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            }
            LinearLayout linearLayout = this.mNetRefreshContainer;
            if (linearLayout != null) {
                SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0201);
            }
            TextView textView2 = this.mNetRefreshBtn;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0106);
                SkinManager.setBackgroundResource(this.mNetRefreshBtn, R.drawable.obfuscated_res_0x7f0801e2);
            }
            ImageView imageView = this.mNetRefreshImg;
            if (imageView != null) {
                imageView.setAlpha(1.0f);
            }
        }
    }

    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setImageResource(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (imageView = this.mNetRefreshImg) != null) {
            imageView.setImageResource(i);
        }
    }

    public void setIsShowRefreshButton(boolean z) {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (textView = this.mNetRefreshBtn) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void setNetFailTipText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (textView = this.mNetFailTipView) != null) {
            textView.setText(str);
        }
    }

    public void setOnRefreshClickListener(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) && (textView = this.mNetRefreshBtn) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }
}
