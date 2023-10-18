package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayoutManager a;
    public ViewPager2.PageTransformer b;

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayoutManager;
    }

    public void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageTransformer) == null) {
            this.b = pageTransformer;
        }
    }

    public ViewPager2.PageTransformer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ViewPager2.PageTransformer) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            View childAt = this.a.getChildAt(i3);
            if (childAt != null) {
                this.b.transformPage(childAt, (this.a.getPosition(childAt) - i) + f2);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.a.getChildCount())));
            }
        }
    }
}
