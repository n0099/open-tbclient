package c.a.o0.h.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.p.b.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.o0.a.w2.c> f11384a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f11385b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11386c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11387d;

    public c(@NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11384a = new ArrayList<>();
        this.f11387d = false;
        this.f11385b = frameLayout;
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean a(View view, c.a.o0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (d(view)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.i(), aVar.f());
                layoutParams.leftMargin = aVar.g();
                layoutParams.topMargin = aVar.h();
                this.f11385b.updateViewLayout(view, layoutParams);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11386c : invokeV.booleanValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean c(View view, c.a.o0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (view == null || aVar == null) {
                return false;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.i(), aVar.f());
            layoutParams.leftMargin = aVar.g();
            layoutParams.topMargin = aVar.h();
            this.f11385b.addView(view, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            if (view == null) {
                return false;
            }
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = this.f11385b;
            return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public synchronized void e(c.a.o0.a.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return;
                }
                if (!this.f11384a.contains(cVar)) {
                    this.f11384a.add(cVar);
                }
            }
        }
    }

    @Override // c.a.o0.a.p.b.a.n
    public synchronized void f(c.a.o0.a.w2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            synchronized (this) {
                if (cVar == null) {
                    return;
                }
                this.f11384a.remove(cVar);
            }
        }
    }

    @Override // c.a.o0.a.p.b.a.n
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f11387d = z;
        }
    }

    @Override // c.a.o0.a.p.b.a.n
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f11385b.getContext() : (Context) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11385b : (FrameLayout) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11387d : invokeV.booleanValue;
    }

    public final synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f11384a.clear();
            }
        }
    }

    public final synchronized c.a.o0.a.w2.c[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.f11384a.isEmpty()) {
                    return null;
                }
                c.a.o0.a.w2.c[] cVarArr = new c.a.o0.a.w2.c[this.f11384a.size()];
                this.f11384a.toArray(cVarArr);
                return cVarArr;
            }
        }
        return (c.a.o0.a.w2.c[]) invokeV.objValue;
    }

    public void k() {
        c.a.o0.a.w2.c[] j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (j2 = j()) == null) {
            return;
        }
        for (c.a.o0.a.w2.c cVar : j2) {
            cVar.onViewBackground();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.o0.a.w2.c[] j2 = j();
            if (j2 != null) {
                for (c.a.o0.a.w2.c cVar : j2) {
                    cVar.b();
                }
            }
            i();
        }
    }

    public void m() {
        c.a.o0.a.w2.c[] j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (j2 = j()) == null) {
            return;
        }
        for (c.a.o0.a.w2.c cVar : j2) {
            cVar.m();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f11386c = z;
        }
    }

    @Override // c.a.o0.a.p.b.a.n
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (d(view)) {
                this.f11385b.removeView(view);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
