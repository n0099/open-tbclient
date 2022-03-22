package c.a.n0.a.s1.b.c;

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
    public int f6263b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6264c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6265d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6266e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6267f;

    /* renamed from: c.a.n0.a.s1.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0451a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0451a interfaceC0451a, @NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0451a, viewGroup, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6266e = false;
        this.f6267f = true;
        this.a = viewGroup;
        this.f6263b = i;
        this.f6264c = i;
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
                for (int i = 0; i < this.a.getChildCount(); i++) {
                    View childAt = this.a.getChildAt(i);
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
                    int height = this.a.getHeight() - this.f6263b;
                    int i = this.a instanceof LinearLayout ? -height : this.f6263b;
                    if (height <= 0) {
                        height = -1;
                        i = 0;
                    }
                    if (!(this.a instanceof LinearLayout) && this.f6263b == 0) {
                        height = -1;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                    layoutParams.setMargins(0, i, 0, 0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6265d : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6266e : invokeV.booleanValue;
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
            for (int i = 0; i < childCount; i++) {
                View childAt = a.getChildAt(i);
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
            this.f6267f = true;
            this.f6266e = false;
            this.f6263b = this.f6264c;
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6267f : invokeV.booleanValue;
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
            this.f6267f = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f6265d = z;
            this.f6263b = 0;
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
