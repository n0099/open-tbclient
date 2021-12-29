package c.a.c0.s.j0;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.b0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class l<T extends ViewGroup, S extends c.a.c0.s.b0.a> extends b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public T f2422i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<S> f2423j;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2423j = new ArrayList<>();
    }

    @Override // c.a.c0.s.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            O();
            Q();
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                S next = it.next();
                next.m(this);
                next.f();
                if (next.a()) {
                    K(next);
                }
            }
            P(this.f2422i);
        }
    }

    @Override // c.a.c0.s.j0.b
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
    }

    public void J(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s) == null) || this.f2423j.contains(s)) {
            return;
        }
        c.a.c0.u.a.b(this.f2423j, s);
    }

    public void K(@NonNull S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s) == null) {
            c.a.c0.s.v0.j.k(s.getContentView());
            if (L(s.c())) {
                this.f2422i.addView(s.getContentView(), s.c());
            } else {
                this.f2422i.addView(s.getContentView());
            }
        }
    }

    public boolean L(@Nullable ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutParams)) == null) {
            if (getContentView() instanceof FrameLayout) {
                return layoutParams instanceof FrameLayout.LayoutParams;
            }
            if (getContentView() instanceof LinearLayout) {
                return layoutParams instanceof LinearLayout.LayoutParams;
            }
            if (getContentView() instanceof RelativeLayout) {
                return layoutParams instanceof RelativeLayout.LayoutParams;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void M(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().h(pVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.c0.s.j0.o
    @NonNull
    /* renamed from: N */
    public T getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2422i : (T) invokeV.objValue;
    }

    public abstract void O();

    public void P(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
        }
    }

    public abstract void Q();

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            super.d(pVar);
            M(pVar);
        }
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new int[]{4, 5, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().k(playerStatus, playerStatus2);
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void j(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            super.j(pVar);
            M(pVar);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void k(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            super.k(pVar);
            M(pVar);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void n(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
            super.n(pVar);
            M(pVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.j0.o
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onContainerDetach();
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().g();
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pVar) == null) {
            super.q(pVar);
            M(pVar);
        }
    }

    @Override // c.a.c0.s.j0.b
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            super.z(message);
            Iterator<S> it = this.f2423j.iterator();
            while (it.hasNext()) {
                it.next().e(message);
            }
        }
    }
}
