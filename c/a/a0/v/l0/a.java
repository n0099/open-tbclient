package c.a.a0.v.l0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.d0.e;
import c.a.a0.v.d0.l;
import c.a.a0.v.f0.h;
import c.a.a0.v.g;
import c.a.a0.v.j0.i;
import c.a.a0.v.l0.b.b;
import c.a.a0.v.l0.b.c;
import c.a.a0.v.v0.d;
import c.a.a0.v.v0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a0.v.l0.b.a O;
    public b P;
    public boolean Q;
    public int R;

    /* renamed from: c.a.a0.v.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0077a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1783b;

        public RunnableC0077a(a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1783b = aVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == -2 || i == -1) {
                    this.f1783b.f0(2);
                    this.f1783b.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull h hVar, @Nullable Context context) {
        super(hVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q = false;
        this.R = 22;
    }

    @Override // c.a.a0.v.e
    @Nullable
    public i A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.A() : (i) invokeV.objValue;
    }

    @Override // c.a.a0.v.f
    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
            this.P.K(8);
            J1();
            this.O.L(true);
            this.O.M(8);
            super.B1(bdVideoSeries, true);
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R : invokeV.intValue;
    }

    @Override // c.a.a0.v.v, c.a.a0.v.e
    public void G0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            c.a.a0.v.l0.b.a aVar = new c.a.a0.v.l0.b.a();
            this.O = aVar;
            b(aVar);
            b bVar = new b();
            this.P = bVar;
            b(bVar);
            b(new c());
            v().setClickable(false);
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            d(c.a.a0.m.b.b());
            d(new c.a.a0.v.o0.b(context));
        }
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            return (bdVideoSeries == null || TextUtils.isEmpty(bdVideoSeries.getVid()) || !this.I.getVid().contains("ad")) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = 0;
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f1719b;
            if (iVar != null && iVar.getContentView() != null) {
                this.f1719b.getContentView().setVisibility(0);
            }
            if (TextUtils.isEmpty(this.a.f1809b)) {
                return;
            }
            l();
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            w1();
            if (this.f1719b != null) {
                R0().stop(w());
                q().i();
                H().j(w());
                this.f1719b.r0();
                l.a(getActivity(), false);
            }
            e eVar = this.A;
            if (eVar != null) {
                eVar.cancel();
            }
            c.a.a0.v.l0.b.a aVar = this.O;
            if (aVar != null) {
                aVar.K();
            }
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.v, c.a.a0.v.e
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.P();
        }
    }

    @Override // c.a.a0.v.e
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? k.c(m()) == 0 : invokeV.booleanValue;
    }

    @Override // c.a.a0.v.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.a();
        }
    }

    @Override // c.a.a0.v.e
    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (activity = getActivity()) == null || X()) {
            return;
        }
        activity.runOnUiThread(new RunnableC0077a(this, i));
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            w1();
            c.a.a0.v.l0.b.a aVar = this.O;
            if (aVar != null) {
                aVar.L(i == 1);
            }
            if (I1()) {
                if (W() || a0()) {
                    return;
                }
                super.f0(i);
                return;
            }
            super.f0(i);
        }
    }

    @Override // c.a.a0.v.e
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.k0();
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.l0();
        }
    }

    @Override // c.a.a0.v.f
    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.J : invokeV.intValue;
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e, c.a.a0.v.i0.e
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            z().g();
            R0().end(w());
            y().p(C(), p(), r());
            e eVar = this.A;
            if (eVar != null) {
                eVar.cancel();
            }
        }
    }

    @Override // c.a.a0.v.f, c.a.a0.v.e, c.a.a0.v.i0.e
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i, i2, obj)) == null) {
            super.onError(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // c.a.a0.v.e, c.a.a0.v.i0.e
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrepared();
            c.a.a0.v.v0.h.b("AdMiniVideoPlayer", "onPrepared position:" + this.a.f1811d);
        }
    }

    @Override // c.a.a0.v.e
    public int r() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int r = super.r();
            if (r != 0 || (o1 = o1()) == null) {
                return r;
            }
            String selectedVideoTotalLength = o1.getSelectedVideoTotalLength();
            return !TextUtils.isEmpty(selectedVideoTotalLength) ? d.c(selectedVideoTotalLength) : r;
        }
        return invokeV.intValue;
    }

    @Override // c.a.a0.v.f
    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.Q : invokeV.booleanValue;
    }
}
