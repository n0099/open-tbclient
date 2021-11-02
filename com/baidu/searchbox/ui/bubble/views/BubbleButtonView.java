package com.baidu.searchbox.ui.bubble.views;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleButtonView extends BubbleTextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BubbleButtonView";
    public transient /* synthetic */ FieldHolder $fh;
    public CharSequence mBtnText;
    public float mBtnTextSize;
    public int mBtnTextUnit;
    public TextView mBubbleBtn;

    public BubbleButtonView() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBtnTextUnit = -1;
        this.mBtnTextSize = -1.0f;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.bubble_tip : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (super.initViewIfNeed()) {
                this.mBubbleBtn = (TextView) this.mBubbleView.findViewById(R.id.bubble_btn);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.resetAll();
            this.mBubbleBtn = null;
            this.mBtnText = null;
        }
    }

    public void setBtnClick(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (textView = this.mBubbleBtn) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void setBtnFontSizew(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mBtnTextUnit = i2;
            this.mBtnTextSize = f2;
        }
    }

    public void setBtnText(CharSequence charSequence, int i2, int i3, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) || (textView = this.mBubbleBtn) == null) {
            return;
        }
        if (i3 >= 0 && f2 > 0.0f) {
            textView.setTextSize(i3, f2);
        }
        this.mBubbleBtn.setTextColor(i2);
        this.mBubbleBtn.setText(charSequence);
        this.mBubbleBtn.setBackground(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.customs_bubble_tip_btn_bg));
        this.mBubbleBtn.setVisibility(0);
    }
}
