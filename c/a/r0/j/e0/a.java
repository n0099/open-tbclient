package c.a.r0.j.e0;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.r0.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f11198i;

    /* renamed from: j  reason: collision with root package name */
    public String f11199j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11200k;
    public ArrayList<c.a.r0.j.e0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: c.a.r0.j.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0733a implements c.a.r0.j.e0.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.y.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11201b;

        public C0733a(a aVar, c.a.r0.a.y.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11201b = aVar;
            this.a = aVar2;
        }

        @Override // c.a.r0.j.e0.h.c
        public void a(c.a.r0.j.e0.h.d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, str) == null) {
                this.f11201b.B(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11200k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void B(c.a.r0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            if (f.f11202h) {
                String str2 = "callFailureCallback: errMsg=" + str;
            }
            c.a.r0.j.n0.c.call(aVar, false, new b(str));
        }
    }

    @NonNull
    public final String C(String str, @NonNull List<String> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i2)) == null) {
            if (list.size() >= i2) {
                String remove = list.remove(0);
                c.a.r0.w.d.k(n.N(remove));
                if (f.f11202h) {
                    String str2 = "deleteFile: " + remove;
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f.f11202h) {
                String str = "doStartRecorder:" + this.f11198i + "," + this.f11199j;
            }
            this.l.clear();
            this.f11200k = false;
            g.a().b().t(this.f11198i, this.f11199j);
        }
    }

    public final boolean E(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dArr)) == null) {
            if (dArr == null || dArr.length < 2) {
                return false;
            }
            long j2 = (long) (dArr[0] * 1000.0d);
            long j3 = (long) (dArr[1] * 1000.0d);
            return j2 >= 0 && j3 >= 0 && j2 + j3 > 0;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = g.a().b().l();
            if (f.f11202h) {
                String str = "RecorderState:" + l;
            }
            if (recorderStateArr == null) {
                return true;
            }
            for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
                if (l == recorderState) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final c.a.r0.a.y.b.a G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            return F == null ? new c.a.r0.a.y.b.a() : F;
        }
        return (c.a.r0.a.y.b.a) invokeL.objValue;
    }

    public final void H(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            c.a.r0.a.y.b.a G = G(jsObject);
            String B = G.B("path");
            if (f.f11202h) {
                String str = "clipPath:" + B + "，hasExecutedClip：" + this.f11200k;
            }
            if (this.f11200k) {
                return;
            }
            if (F(GameRecorderController.RecorderState.STOP)) {
                B(G, "clipVideo can only called after onStop");
            } else if (this.l.isEmpty()) {
                B(G, "range is illegal");
            } else {
                new c.a.r0.j.e0.h.e(this.l, n.B(B), n.N(C("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C0733a(this, G));
                this.l.clear();
                this.f11200k = true;
                c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
                eVar.f8157b = "clipVideo";
                c.a.r0.a.n2.n.h(eVar);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = f.f11202h;
            if (F(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            g.a().b().o();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            c.a.r0.a.y.b.a G = G(jsObject);
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = G.o("timeRange");
            H(jsObject);
            if (!E(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            c.a.r0.j.e0.h.b b2 = c.a.r0.j.e0.h.b.b(g.a().b().k(), o[0], o[1]);
            if (f.f11202h) {
                String str = "recordClip:" + b2.toString();
            }
            this.l.add(b2);
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.f8157b = "recordClip";
            c.a.r0.a.n2.n.h(eVar);
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = f.f11202h;
            if (F(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
                return;
            }
            g.a().b().q();
        }
    }

    @JavascriptInterface
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            start(null);
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = f.f11202h;
            if (F(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            g.a().b().u();
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            boolean z = f.f11202h;
            if (F(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
                return;
            }
            c.a.r0.a.y.b.a G = G(jsObject);
            int r = G.r("duration", 10);
            this.f11198i = r;
            if (r <= 0) {
                this.f11198i = 10;
            }
            if (this.f11198i > 120) {
                this.f11198i = 120;
            }
            if (this.m.size() == 0) {
                c.a.r0.w.d.k(n.N("bdfile://tmp/SwanVideoRecorder/"));
            }
            String C = C("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
            z(C);
            String N = n.N(C);
            this.f11199j = N;
            if (N == null) {
                boolean z2 = f.f11202h;
                return;
            }
            if (G.m("microphoneEnabled", false)) {
                y(2);
            }
            D();
            c.a.r0.j.f0.b.a.l();
        }
    }
}
