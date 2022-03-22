package c.a.a0.v.z;

import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.c0.p;
import c.a.a0.v.j0.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public b f1875b;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (701 == i) {
                e();
            } else if (702 == i) {
                d();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            char c2 = 4;
            if (pVar.getType() == 4 || pVar.getType() == 2) {
                String c3 = pVar.c();
                switch (c3.hashCode()) {
                    case -1502879971:
                        if (c3.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1244137507:
                        break;
                    case -525235558:
                        if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -461848373:
                        if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 154871702:
                        if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 720027695:
                        if (c3.equals(ControlEvent.ACTION_PAUSE)) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 723345051:
                        if (c3.equals(ControlEvent.ACTION_START)) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 906917140:
                        if (c3.equals(ControlEvent.ACTION_RESUME)) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1370689931:
                        if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1547354793:
                        if (c3.equals(ControlEvent.ACTION_STOP)) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        int g2 = pVar.g(1);
                        h(g2, pVar.g(2), pVar.f(3));
                        a(g2);
                        return;
                    case 1:
                        g(pVar.g(1), pVar.g(2), pVar.f(3));
                        return;
                    case 2:
                        l();
                        return;
                    case 3:
                        f(307);
                        return;
                    case 4:
                        n();
                        return;
                    case 5:
                        q(pVar.g(5), pVar.g(6));
                        return;
                    case 6:
                        o();
                        return;
                    case 7:
                        m();
                        return;
                    case '\b':
                        k();
                        return;
                    case '\t':
                        f(0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (h) invokeV.objValue;
    }

    public void d() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onBufferEnd();
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onBufferStart();
    }

    public void f(int i) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onEnd(i);
    }

    public void g(int i, int i2, Object obj) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onError(i, i2, obj != null ? obj.toString() : "");
    }

    public void h(int i, int i2, Object obj) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onInfo(i, i2);
    }

    public void i(o oVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar) == null) || (bVar = this.f1875b) == null) {
            return;
        }
        bVar.a(oVar);
    }

    public void j(o oVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, oVar) == null) || (bVar = this.f1875b) == null) {
            return;
        }
        bVar.b(oVar);
    }

    public void k() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onPause();
    }

    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onPrepared();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onResume();
    }

    public void n() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onSeekEnd();
    }

    public void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onStart();
    }

    public void p(int i, int i2, int i3) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onUpdateProgress(i, i2, i3);
    }

    public void q(int i, int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.onVideoSizeChanged(i, i2);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a = null;
            this.f1875b = null;
        }
    }

    public void s(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hVar) == null) {
            this.a = hVar;
        }
    }
}
