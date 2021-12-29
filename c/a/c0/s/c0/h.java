package c.a.c0.s.c0;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Integer> f2356b;

    public h() {
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
        this.f2356b = new ArrayList<>(13);
        e();
    }

    @Override // c.a.c0.s.c0.j
    public void c(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            super.c(pVar);
        }
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f2356b.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2356b.add(904);
            this.f2356b.add(701);
            this.f2356b.add(702);
            this.f2356b.add(11004);
            this.f2356b.add(11005);
            this.f2356b.add(946);
            this.f2356b.add(924);
            this.f2356b.add(5000);
            this.f2356b.add(937);
            this.f2356b.add(936);
            this.f2356b.add(955);
            this.f2356b.add(956);
            this.f2356b.add(910);
            this.f2356b.add(10103);
            this.f2356b.add(12005);
            this.f2356b.add(12006);
            this.f2356b.add(10009);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            p w = g.w(PlayerEvent.ACTION_BUFFER_UPDATE);
            w.n(2, Integer.valueOf(i2));
            w.r(1);
            c(w);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(g.w(PlayerEvent.ACTION_ON_COMPLETE));
        }
    }

    public boolean h(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, obj)) == null) {
            p w = g.w(PlayerEvent.ACTION_ON_ERROR);
            w.n(1, Integer.valueOf(i2));
            w.n(2, Integer.valueOf(i3));
            w.n(3, obj);
            c(w);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public boolean i(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, obj)) == null) {
            c.a.c0.s.v0.h.h("player trigger on info what:" + i2);
            if (d(i2)) {
                p w = g.w(PlayerEvent.ACTION_ON_INFO);
                if (i2 == 910) {
                    w.r(1);
                }
                w.n(1, Integer.valueOf(i2));
                w.n(2, Integer.valueOf(i3));
                w.n(3, obj);
                c(w);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c(g.w(PlayerEvent.ACTION_PLAYER_ATTACH));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c(g.w(PlayerEvent.ACTION_PLAYER_DETACH));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c(g.w(PlayerEvent.ACTION_ON_PREPARED));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c(g.w(PlayerEvent.ACTION_SEEK_COMPLETE));
        }
    }

    public void n(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
            p w = g.w(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
            w.n(5, Integer.valueOf(i2));
            w.n(6, Integer.valueOf(i3));
            c(w);
        }
    }

    public void o(String str, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            p w = g.w(PlayerEvent.ACTION_SET_DATA_SOURCE);
            c.a.c0.s.m0.h hVar = new c.a.c0.s.m0.h();
            hVar.a = str;
            hVar.f2483c = z;
            hVar.f2484d = i2;
            w.n(3, hVar);
            w.s(1);
            c(w);
        }
    }
}
