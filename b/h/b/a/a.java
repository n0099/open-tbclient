package b.h.b.a;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class a implements r, s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f32193e;

    /* renamed from: f  reason: collision with root package name */
    public t f32194f;

    /* renamed from: g  reason: collision with root package name */
    public int f32195g;

    /* renamed from: h  reason: collision with root package name */
    public int f32196h;

    /* renamed from: i  reason: collision with root package name */
    public b.h.b.a.d0.o f32197i;
    public long j;
    public boolean k;
    public boolean l;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32193e = i2;
        this.k = true;
    }

    public static boolean E(@Nullable b.h.b.a.z.a<?> aVar, @Nullable DrmInitData drmInitData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, drmInitData)) == null) {
            if (drmInitData == null) {
                return true;
            }
            if (aVar == null) {
                return false;
            }
            return aVar.b(drmInitData);
        }
        return invokeLL.booleanValue;
    }

    public void A() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void B(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, formatArr, j) == null) {
        }
    }

    public final int C(l lVar, b.h.b.a.y.e eVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, eVar, z)) == null) {
            int f2 = this.f32197i.f(lVar, eVar, z);
            if (f2 == -4) {
                if (eVar.j()) {
                    this.k = true;
                    return this.l ? -4 : -3;
                }
                eVar.f33760h += this.j;
            } else if (f2 == -5) {
                Format format = lVar.f33599a;
                long j = format.subsampleOffsetUs;
                if (j != Long.MAX_VALUE) {
                    lVar.f33599a = format.copyWithSubsampleOffsetUs(j + this.j);
                }
            }
            return f2;
        }
        return invokeLLZ.intValue;
    }

    public int D(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f32197i.j(j - this.j) : invokeJ.intValue;
    }

    @Override // b.h.b.a.r, b.h.b.a.s
    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32193e : invokeV.intValue;
    }

    @Override // b.h.b.a.r
    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // b.h.b.a.r
    public final void g(t tVar, Format[] formatArr, b.h.b.a.d0.o oVar, long j, boolean z, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tVar, formatArr, oVar, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            b.h.b.a.i0.a.f(this.f32196h == 0);
            this.f32194f = tVar;
            this.f32196h = 1;
            x(z);
            s(formatArr, oVar, j2);
            y(j, z);
        }
    }

    @Override // b.h.b.a.r
    public final int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32196h : invokeV.intValue;
    }

    @Override // b.h.b.a.r
    public final b.h.b.a.d0.o getStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32197i : (b.h.b.a.d0.o) invokeV.objValue;
    }

    @Override // b.h.b.a.g.a
    public void h(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, obj) == null) {
        }
    }

    @Override // b.h.b.a.r
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.h.b.a.i0.a.f(this.f32196h == 1);
            this.f32196h = 0;
            this.f32197i = null;
            this.l = false;
            w();
        }
    }

    @Override // b.h.b.a.r
    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // b.h.b.a.r
    public final void l(long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.l = false;
            this.k = false;
            y(j, false);
        }
    }

    @Override // b.h.b.a.r
    public b.h.b.a.i0.h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (b.h.b.a.i0.h) invokeV.objValue;
    }

    @Override // b.h.b.a.r
    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.l = true;
        }
    }

    @Override // b.h.b.a.r
    public final void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f32197i.a();
        }
    }

    @Override // b.h.b.a.r
    public final s p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (s) invokeV.objValue;
    }

    @Override // b.h.b.a.s
    public int r() throws ExoPlaybackException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.h.b.a.r
    public final void s(Format[] formatArr, b.h.b.a.d0.o oVar, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{formatArr, oVar, Long.valueOf(j)}) == null) {
            b.h.b.a.i0.a.f(!this.l);
            this.f32197i = oVar;
            this.k = false;
            this.j = j;
            B(formatArr, j);
        }
    }

    @Override // b.h.b.a.r
    public final void setIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f32195g = i2;
        }
    }

    @Override // b.h.b.a.r
    public final void start() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.h.b.a.i0.a.f(this.f32196h == 1);
            this.f32196h = 2;
            z();
        }
    }

    @Override // b.h.b.a.r
    public final void stop() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            b.h.b.a.i0.a.f(this.f32196h == 2);
            this.f32196h = 1;
            A();
        }
    }

    public final t t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f32194f : (t) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f32195g : invokeV.intValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k ? this.l : this.f32197i.isReady() : invokeV.booleanValue;
    }

    public abstract void w();

    public void x(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    public abstract void y(long j, boolean z) throws ExoPlaybackException;

    public void z() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }
}
