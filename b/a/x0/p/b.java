package b.a.x0.p;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.p.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.x0.p.e.b f30637a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Object obj);
    }

    /* renamed from: b.a.x0.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1471b {
        boolean a();

        int b();

        void c(int i2, int i3, int i4, int i5);

        void d(byte[] bArr);

        String e();

        boolean f();

        void g(int i2, int i3, int i4, boolean z);

        void h(boolean z);

        void i(boolean z);

        void j(boolean z);

        boolean k(SurfaceTexture surfaceTexture, f fVar);

        void l(int i2);

        void m(boolean z);

        void n();

        boolean o();

        boolean p();

        void q();

        int r();

        void release();

        void s(a aVar);

        void t(int i2, int i3, int i4, int i5);

        void u(int i2);

        int v();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onBeautyEnableChanged(b.a.a0.a.f.a aVar);

        void onChangeGender(boolean z);

        void onLuaMessage(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes6.dex */
    public interface e extends a.b {
        void a(ICaptureResult iCaptureResult);

        void c();

        void d(int i2);

        void e();

        void f();

        void g(int i2, int i3);

        void h(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(byte[] bArr, int i2);
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30637a = new b.a.x0.p.e.b(context);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30637a.a0() : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30637a.c0() : invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30637a.X();
        }
    }

    public void D(int i2) {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.r(i2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30637a.onDestroy();
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30637a.q0() : (String) invokeV.objValue;
    }

    public void c(InterfaceC1471b interfaceC1471b, int i2, int i3, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{interfaceC1471b, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str}) == null) {
            this.f30637a.A(interfaceC1471b, i2, i3, z, str);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.x0.p.e.b bVar = this.f30637a;
            if (bVar != null) {
                return bVar.p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f30637a.B(cVar);
            this.f30637a.e0();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f30637a.onPause();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f30637a.onResume();
        }
    }

    public void h() {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.k0();
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.f30637a.s(i2, i3);
        }
    }

    public void j() {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.c();
    }

    public void k(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, duMixCallback) == null) {
            this.f30637a.x(duMixCallback);
        }
    }

    public void l(Filter filter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, filter) == null) {
            this.f30637a.y(filter);
        }
    }

    public void m(GLSurfaceView gLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gLSurfaceView) == null) {
            this.f30637a.w(gLSurfaceView);
        }
    }

    public void n() {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.d();
    }

    public void o(boolean z) {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.f0(z);
    }

    public void p(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onFrameAvailableListener) == null) {
            this.f30637a.u(onFrameAvailableListener);
        }
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.f30637a.C(dVar);
        }
    }

    public void r(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            this.f30637a.D(eVar);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void t(boolean z) {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.G(z);
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f30637a.T(z);
        }
    }

    public void w(boolean z) {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.Y(z);
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.f30637a.setSpeed(f2);
        }
    }

    public boolean y(Sticker sticker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, sticker, str)) == null) ? this.f30637a.H(sticker, str) : invokeLL.booleanValue;
    }

    public void z(float f2) {
        b.a.x0.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048605, this, f2) == null) || (bVar = this.f30637a) == null) {
            return;
        }
        bVar.q(f2);
    }
}
