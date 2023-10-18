package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
/* loaded from: classes3.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<ViewPager2.OnPageChangeCallback> a;

    public CompositeOnPageChangeCallback(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList(i);
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, concurrentModificationException) == null) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
        }
    }

    public void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onPageChangeCallback) == null) {
            this.a.remove(onPageChangeCallback);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                    onPageChangeCallback.onPageScrollStateChanged(i);
                }
            } catch (ConcurrentModificationException e) {
                a(e);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                    onPageChangeCallback.onPageSelected(i);
                }
            } catch (ConcurrentModificationException e) {
                a(e);
            }
        }
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onPageChangeCallback) == null) {
            this.a.add(onPageChangeCallback);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.a) {
                    onPageChangeCallback.onPageScrolled(i, f, i2);
                }
            } catch (ConcurrentModificationException e) {
                a(e);
            }
        }
    }
}
