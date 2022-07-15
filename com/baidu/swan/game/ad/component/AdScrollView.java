package com.baidu.swan.game.ad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
    }

    private int getLimitHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = getContext().getResources().getDisplayMetrics().heightPixels;
            if (2 == getContext().getResources().getConfiguration().orientation) {
                i = getContext().getResources().getDisplayMetrics().widthPixels;
            }
            return ((i - (getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07065e) * 2)) - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070660)) - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07065c);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i);
            int i3 = this.a;
            if (i3 > 0) {
                size = Math.min(size, i3);
            }
            measureChildren(i, i2);
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            if (measuredHeight > 0) {
                size = Math.min(measuredHeight, size);
            }
            if (measuredWidth > 0) {
                size2 = Math.min(measuredWidth, size2);
            }
            if (getLimitHeight() < size) {
                size = getLimitHeight();
            }
            setMeasuredDimension(size2, size);
        }
    }

    public void setMaxHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = -1;
    }
}
