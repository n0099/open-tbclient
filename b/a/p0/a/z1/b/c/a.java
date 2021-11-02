package b.a.p0.a.z1.b.c;

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

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f9235a;

    /* renamed from: b  reason: collision with root package name */
    public int f9236b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9237c;

    /* renamed from: b.a.p0.a.z1.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0478a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0478a interfaceC0478a, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0478a, viewGroup, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9235a = viewGroup;
        this.f9236b = i2;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f9235a.getContext() : (Context) invokeV.objValue;
    }

    @Nullable
    public final Container a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f9235a) {
                for (int i2 = 0; i2 < this.f9235a.getChildCount(); i2++) {
                    View childAt = this.f9235a.getChildAt(i2);
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
        Container a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f9235a) {
                a2 = a();
                if (a2 == null) {
                    a2 = new Container(getContext());
                    int height = this.f9235a.getHeight() - this.f9236b;
                    int i2 = this.f9235a instanceof LinearLayout ? -height : this.f9236b;
                    if (height <= 0) {
                        height = -1;
                        i2 = 0;
                    }
                    if (!(this.f9235a instanceof LinearLayout) && this.f9236b == 0) {
                        height = -1;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                    layoutParams.setMargins(0, i2, 0, 0);
                    a2.setLayoutParams(layoutParams);
                    this.f9235a.addView(a2);
                }
            }
            return a2;
        }
        return (Container) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9237c : invokeV.booleanValue;
    }

    @Nullable
    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Container a2 = a();
            if (a2 != null && a2.getChildCount() > 0) {
                return a2.getChildAt(0);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Container a2 = a();
            if (a2 == null) {
                return false;
            }
            int childCount = a2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = a2.getChildAt(i2);
                if (childAt != null && childAt.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g(false);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this.f9235a) {
                Container a2 = a();
                if (!z || a2 == null || a2.getChildCount() <= 0) {
                    if (a2 != null) {
                        this.f9235a.removeView(a2);
                    }
                }
            }
        }
    }

    public void h(boolean z) {
        Container a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (a2 = a()) == null) {
            return;
        }
        a2.setClickable(z);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f9237c = z;
            this.f9236b = 0;
        }
    }

    public void j(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == d()) {
            return;
        }
        f();
        b().addView(view);
    }

    public void k(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view, layoutParams) == null) || view == d()) {
            return;
        }
        f();
        b().addView(view, layoutParams);
    }
}
