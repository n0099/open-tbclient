package com.baidu.ala.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.g0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AlaNetRefreshView extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mNetFailTipView;
    public TextView mNetRefreshBtn;
    public LinearLayout mNetRefreshContainer;
    public ImageView mNetRefreshImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNetRefreshView(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.ala_live_net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNetRefreshImg = (ImageView) this.attachedView.findViewById(R.id.ala_net_refresh_img);
        this.mNetFailTipView = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_text);
        this.mNetRefreshBtn = (TextView) this.attachedView.findViewById(R.id.ala_net_refresh_btn);
        this.mNetRefreshContainer = (LinearLayout) this.attachedView.findViewById(R.id.ala_net_refresh_container);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.mNetFailTipView;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            }
            LinearLayout linearLayout = this.mNetRefreshContainer;
            if (linearLayout != null) {
                SkinManager.setBackgroundResource(linearLayout, R.color.CAM_X0201);
            }
            TextView textView2 = this.mNetRefreshBtn;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0106);
                SkinManager.setBackgroundResource(this.mNetRefreshBtn, R.drawable.ala_net_refresh_btn_bg);
            }
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            ImageView imageView = this.mNetRefreshImg;
            if (imageView != null) {
                if (z) {
                    imageView.setAlpha(0.4f);
                } else {
                    imageView.setAlpha(1.0f);
                }
            }
        }
    }

    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.attachedView.setBackgroundColor(i2);
        }
    }

    public void setContainerBackgroundColor(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (linearLayout = this.mNetRefreshContainer) == null) {
            return;
        }
        linearLayout.setBackgroundColor(i2);
    }

    public void setImageResource(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (imageView = this.mNetRefreshImg) == null) {
            return;
        }
        imageView.setImageResource(i2);
    }

    public void setIsShowRefreshButton(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (textView = this.mNetRefreshBtn) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public void setNetFailTipText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (textView = this.mNetFailTipView) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setNetRefreshBtnBackgroundResource(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (textView = this.mNetRefreshBtn) == null) {
            return;
        }
        textView.setBackgroundResource(i2);
    }

    public void setNetRefreshBtnText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (textView = this.mNetRefreshBtn) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setNetRefreshBtnTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (textView = this.mNetRefreshBtn) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setNetRefreshImgAlpha(float f2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (imageView = this.mNetRefreshImg) == null) {
            return;
        }
        imageView.setAlpha(f2);
    }

    public void setNetRefreshTipTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (textView = this.mNetFailTipView) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setOnRefreshClickListener(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (textView = this.mNetRefreshBtn) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }
}
