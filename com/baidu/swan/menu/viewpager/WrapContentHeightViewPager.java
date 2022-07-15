package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WrapContentHeightViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentHeightViewPager(Context context) {
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
    }

    public final int b(int i, View view2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, view2)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return size;
            }
            int measuredHeight = view2 != null ? view2.getMeasuredHeight() : 0;
            return mode == Integer.MIN_VALUE ? Math.min(measuredHeight, size) : measuredHeight;
        }
        return invokeIL.intValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (getChildCount() > 0) {
                int childCount = getChildCount();
                View view2 = null;
                int i3 = -1;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt != null) {
                        childAt.measure(i, i2);
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (measuredHeight > i3) {
                            view2 = childAt;
                            i3 = measuredHeight;
                        }
                    }
                }
                if (view2 == null) {
                    view2 = getChildAt(0);
                }
                if (view2 != null) {
                    view2.measure(i, i2);
                }
                setMeasuredDimension(getMeasuredWidth(), b(i2, view2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
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
    }
}
