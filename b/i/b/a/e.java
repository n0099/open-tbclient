package b.i.b.a;

import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes6.dex */
public final class e implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.h0.h f32264a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32265b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32266c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32267d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32268e;

    /* renamed from: f  reason: collision with root package name */
    public final PriorityTaskManager f32269f;

    /* renamed from: g  reason: collision with root package name */
    public int f32270g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32271h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(new b.i.b.a.h0.h(true, 65536));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((b.i.b.a.h0.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.m
    public void a(r[] rVarArr, b.i.b.a.d0.t tVar, b.i.b.a.f0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rVarArr, tVar, gVar) == null) {
            this.f32270g = 0;
            for (int i2 = 0; i2 < rVarArr.length; i2++) {
                if (gVar.a(i2) != null) {
                    this.f32270g += b.i.b.a.i0.v.p(rVarArr[i2].e());
                }
            }
            this.f32264a.h(this.f32270g);
        }
    }

    @Override // b.i.b.a.m
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(true);
        }
    }

    @Override // b.i.b.a.m
    public boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int g2 = g(j);
            boolean z = true;
            boolean z2 = this.f32264a.f() >= this.f32270g;
            boolean z3 = this.f32271h;
            if (g2 != 2 && (g2 != 1 || !z3 || z2)) {
                z = false;
            }
            this.f32271h = z;
            PriorityTaskManager priorityTaskManager = this.f32269f;
            if (priorityTaskManager != null && z != z3) {
                if (z) {
                    priorityTaskManager.a(0);
                } else {
                    priorityTaskManager.b(0);
                }
            }
            return this.f32271h;
        }
        return invokeJ.booleanValue;
    }

    @Override // b.i.b.a.m
    public boolean d(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            long j2 = z ? this.f32268e : this.f32267d;
            return j2 <= 0 || j >= j2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // b.i.b.a.m
    public b.i.b.a.h0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32264a : (b.i.b.a.h0.b) invokeV.objValue;
    }

    @Override // b.i.b.a.m
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(true);
        }
    }

    public final int g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j > this.f32266c) {
                return 0;
            }
            return j < this.f32265b ? 2 : 1;
        }
        return invokeJ.intValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f32270g = 0;
            PriorityTaskManager priorityTaskManager = this.f32269f;
            if (priorityTaskManager != null && this.f32271h) {
                priorityTaskManager.b(0);
            }
            this.f32271h = false;
            if (z) {
                this.f32264a.g();
            }
        }
    }

    @Override // b.i.b.a.m
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(b.i.b.a.h0.h hVar) {
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
                this((b.i.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(b.i.b.a.h0.h hVar, int i2, int i3, long j, long j2) {
        this(hVar, i2, i3, j, j2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.i.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (PriorityTaskManager) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(b.i.b.a.h0.h hVar, int i2, int i3, long j, long j2, PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), priorityTaskManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f32264a = hVar;
        this.f32265b = i2 * 1000;
        this.f32266c = i3 * 1000;
        this.f32267d = j * 1000;
        this.f32268e = j2 * 1000;
        this.f32269f = priorityTaskManager;
    }
}
