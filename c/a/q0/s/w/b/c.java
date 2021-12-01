package c.a.q0.s.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13235b;

    /* renamed from: c  reason: collision with root package name */
    public int f13236c;

    /* renamed from: d  reason: collision with root package name */
    public int f13237d;

    /* renamed from: e  reason: collision with root package name */
    public int f13238e;

    /* renamed from: f  reason: collision with root package name */
    public int f13239f;

    public c() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13235b : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13236c : invokeV.intValue;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f13235b = i2;
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a = i2;
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13238e = i2;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f13239f = i2;
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f13236c = i2;
        }
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13237d = i2;
        }
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, indicatorView) == null) || indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i2 = this.f13237d;
        if (i2 > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i2));
        }
        int i3 = this.f13235b;
        if (i3 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i3));
        }
        int i4 = this.f13236c;
        if (i4 > 0) {
            indicatorView.setSelector(resources.getDrawable(i4));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.a;
            int i5 = this.f13238e;
            if (i5 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i5);
            }
            int i6 = this.f13239f;
            if (i6 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i6);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
