package c.i.b.a;

import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes4.dex */
public final class e implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.h0.h f33418a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33419b;

    /* renamed from: c  reason: collision with root package name */
    public final long f33420c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33421d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33422e;

    /* renamed from: f  reason: collision with root package name */
    public final PriorityTaskManager f33423f;

    /* renamed from: g  reason: collision with root package name */
    public int f33424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33425h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(new c.i.b.a.h0.h(true, 65536));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c.i.b.a.h0.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.m
    public void a(r[] rVarArr, c.i.b.a.d0.t tVar, c.i.b.a.f0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rVarArr, tVar, gVar) == null) {
            this.f33424g = 0;
            for (int i2 = 0; i2 < rVarArr.length; i2++) {
                if (gVar.a(i2) != null) {
                    this.f33424g += c.i.b.a.i0.v.p(rVarArr[i2].e());
                }
            }
            this.f33418a.h(this.f33424g);
        }
    }

    @Override // c.i.b.a.m
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(true);
        }
    }

    @Override // c.i.b.a.m
    public boolean c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            int g2 = g(j2);
            boolean z = true;
            boolean z2 = this.f33418a.f() >= this.f33424g;
            boolean z3 = this.f33425h;
            if (g2 != 2 && (g2 != 1 || !z3 || z2)) {
                z = false;
            }
            this.f33425h = z;
            PriorityTaskManager priorityTaskManager = this.f33423f;
            if (priorityTaskManager != null && z != z3) {
                if (z) {
                    priorityTaskManager.a(0);
                } else {
                    priorityTaskManager.b(0);
                }
            }
            return this.f33425h;
        }
        return invokeJ.booleanValue;
    }

    @Override // c.i.b.a.m
    public boolean d(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            long j3 = z ? this.f33422e : this.f33421d;
            return j3 <= 0 || j2 >= j3;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.m
    public c.i.b.a.h0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33418a : (c.i.b.a.h0.b) invokeV.objValue;
    }

    @Override // c.i.b.a.m
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(true);
        }
    }

    public final int g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            if (j2 > this.f33420c) {
                return 0;
            }
            return j2 < this.f33419b ? 2 : 1;
        }
        return invokeJ.intValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f33424g = 0;
            PriorityTaskManager priorityTaskManager = this.f33423f;
            if (priorityTaskManager != null && this.f33425h) {
                priorityTaskManager.b(0);
            }
            this.f33425h = false;
            if (z) {
                this.f33418a.g();
            }
        }
    }

    @Override // c.i.b.a.m
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(c.i.b.a.h0.h hVar) {
        this(hVar, 15000, 30000, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, 5000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.i.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(c.i.b.a.h0.h hVar, int i2, int i3, long j2, long j3) {
        this(hVar, i2, i3, j2, j3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.i.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (PriorityTaskManager) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(c.i.b.a.h0.h hVar, int i2, int i3, long j2, long j3, PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), priorityTaskManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f33418a = hVar;
        this.f33419b = i2 * 1000;
        this.f33420c = i3 * 1000;
        this.f33421d = j2 * 1000;
        this.f33422e = j3 * 1000;
        this.f33423f = priorityTaskManager;
    }
}
