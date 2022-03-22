package c.a.a0.v.c0;

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
    public final ArrayList<Integer> f1692b;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1692b = new ArrayList<>(13);
        e();
    }

    @Override // c.a.a0.v.c0.j
    public void c(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            super.c(pVar);
        }
    }

    public final boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.f1692b.contains(Integer.valueOf(i)) : invokeI.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1692b.add(904);
            this.f1692b.add(701);
            this.f1692b.add(702);
            this.f1692b.add(11004);
            this.f1692b.add(11005);
            this.f1692b.add(946);
            this.f1692b.add(924);
            this.f1692b.add(5000);
            this.f1692b.add(937);
            this.f1692b.add(936);
            this.f1692b.add(955);
            this.f1692b.add(956);
            this.f1692b.add(910);
            this.f1692b.add(10103);
            this.f1692b.add(12005);
            this.f1692b.add(12006);
            this.f1692b.add(10009);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            p w = g.w(PlayerEvent.ACTION_BUFFER_UPDATE);
            w.n(2, Integer.valueOf(i));
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

    public boolean h(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, obj)) == null) {
            p w = g.w(PlayerEvent.ACTION_ON_ERROR);
            w.n(1, Integer.valueOf(i));
            w.n(2, Integer.valueOf(i2));
            w.n(3, obj);
            c(w);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public boolean i(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i, i2, obj)) == null) {
            c.a.a0.v.v0.h.h("player trigger on info what:" + i);
            if (d(i)) {
                p w = g.w(PlayerEvent.ACTION_ON_INFO);
                if (i == 910) {
                    w.r(1);
                }
                w.n(1, Integer.valueOf(i));
                w.n(2, Integer.valueOf(i2));
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

    public void n(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) {
            p w = g.w(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
            w.n(5, Integer.valueOf(i));
            w.n(6, Integer.valueOf(i2));
            c(w);
        }
    }

    public void o(String str, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            p w = g.w(PlayerEvent.ACTION_SET_DATA_SOURCE);
            c.a.a0.v.m0.h hVar = new c.a.a0.v.m0.h();
            hVar.a = str;
            hVar.f1807c = z;
            hVar.f1808d = i;
            w.n(3, hVar);
            w.s(1);
            c(w);
        }
    }
}
