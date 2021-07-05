package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
/* loaded from: classes.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    public CompositeOnPageChangeCallback(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCallbacks = new ArrayList(i2);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, concurrentModificationException) == null) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
        }
    }

    public void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onPageChangeCallback) == null) {
            this.mCallbacks.add(onPageChangeCallback);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.mCallbacks) {
                    onPageChangeCallback.onPageScrollStateChanged(i2);
                }
            } catch (ConcurrentModificationException e2) {
                throwCallbackListModifiedWhileInUse(e2);
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i2, float f2, @Px int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.mCallbacks) {
                    onPageChangeCallback.onPageScrolled(i2, f2, i3);
                }
            } catch (ConcurrentModificationException e2) {
                throwCallbackListModifiedWhileInUse(e2);
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            try {
                for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.mCallbacks) {
                    onPageChangeCallback.onPageSelected(i2);
                }
            } catch (ConcurrentModificationException e2) {
                throwCallbackListModifiedWhileInUse(e2);
            }
        }
    }

    public void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onPageChangeCallback) == null) {
            this.mCallbacks.remove(onPageChangeCallback);
        }
    }
}
