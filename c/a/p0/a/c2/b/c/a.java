package c.a.p0.a.c2.b.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.floatlayer.Container;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public int f4496b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4497c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4498d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4499e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4500f;

    /* renamed from: c.a.p0.a.c2.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0192a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0192a interfaceC0192a, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0192a, viewGroup, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4499e = false;
        this.f4500f = true;
        this.a = viewGroup;
        this.f4496b = i2;
        this.f4497c = i2;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Nullable
    public final Container a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.a) {
                for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                    View childAt = this.a.getChildAt(i2);
                    if (childAt instanceof Container) {
                        return (Container) childAt;
                    }
                }
                return null;
            }
        }
        return (Container) invokeV.objValue;
    }

    @NonNull
    public final Container b() {
        InterceptResult invokeV;
        Container a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.a) {
                a = a();
                if (a == null) {
                    a = new Container(getContext());
                    int height = this.a.getHeight() - this.f4496b;
                    int i2 = this.a instanceof LinearLayout ? -height : this.f4496b;
                    if (height <= 0) {
                        height = -1;
                        i2 = 0;
                    }
                    if (!(this.a instanceof LinearLayout) && this.f4496b == 0) {
                        height = -1;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                    layoutParams.setMargins(0, i2, 0, 0);
                    a.setLayoutParams(layoutParams);
                    this.a.addView(a);
                }
            }
            return a;
        }
        return (Container) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4498d : invokeV.booleanValue;
    }

    @Nullable
    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Container a = a();
            if (a != null && a.getChildCount() > 0) {
                return a.getChildAt(0);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4499e : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Container a = a();
            if (a == null) {
                return false;
            }
            int childCount = a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = a.getChildAt(i2);
                if (childAt != null && childAt.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h(false);
            i();
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            synchronized (this.a) {
                Container a = a();
                if (!z || a == null || a.getChildCount() <= 0) {
                    if (a != null) {
                        this.a.removeView(a);
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4500f = true;
            this.f4499e = false;
            this.f4496b = this.f4497c;
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4500f : invokeV.booleanValue;
    }

    public void k(boolean z) {
        Container a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (a = a()) == null) {
            return;
        }
        a.setClickable(z);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f4500f = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f4498d = z;
            this.f4496b = 0;
        }
    }

    public void n(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || view == d()) {
            return;
        }
        h(false);
        b().addView(view);
    }

    public void o(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, view, layoutParams) == null) || view == d()) {
            return;
        }
        h(false);
        b().addView(view, layoutParams);
    }
}
