package com.baidu.searchbox.ui.bubble.views;

import android.view.View;
import android.widget.ImageView;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleJumpArrowView extends BubbleTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mJumpArrow;

    public BubbleJumpArrowView() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.bubble_tip_d20 : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (super.initViewIfNeed()) {
                this.mJumpArrow = (ImageView) this.mBubbleView.findViewById(R.id.bubble_jump_arrow);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onShowArrow() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.mJumpArrow) == null) {
            return;
        }
        imageView.setBackground(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.bubble_jump_arrow_selector));
        this.mJumpArrow.setVisibility(0);
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.resetAll();
            this.mJumpArrow = null;
        }
    }

    public void setJumpArrowBgColor(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (imageView = this.mJumpArrow) == null) {
            return;
        }
        imageView.setBackground(AppRuntime.getAppContext().getResources().getDrawable(i2));
        this.mJumpArrow.setVisibility(0);
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) || (imageView = this.mJumpArrow) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setJumpArrowVisible(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.mJumpArrow) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }
}
