package c.a.o0.r.x.b;

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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f11114b;

    /* renamed from: c  reason: collision with root package name */
    public int f11115c;

    /* renamed from: d  reason: collision with root package name */
    public int f11116d;

    /* renamed from: e  reason: collision with root package name */
    public int f11117e;

    /* renamed from: f  reason: collision with root package name */
    public int f11118f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11114b : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11115c : invokeV.intValue;
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f11114b = i;
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f11117e = i;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f11118f = i;
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f11115c = i;
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f11116d = i;
        }
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, indicatorView) == null) || indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i = this.f11116d;
        if (i > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i));
        }
        int i2 = this.f11114b;
        if (i2 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i2));
        }
        int i3 = this.f11115c;
        if (i3 > 0) {
            indicatorView.setSelector(resources.getDrawable(i3));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.a;
            int i4 = this.f11117e;
            if (i4 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i4);
            }
            int i5 = this.f11118f;
            if (i5 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i5);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
