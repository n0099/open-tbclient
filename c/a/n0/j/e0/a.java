package c.a.n0.j.e0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.h0.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f8705e;

    /* renamed from: f  reason: collision with root package name */
    public String f8706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8707g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c.a.n0.j.e0.h.b> f8708h;
    public List<String> i;
    public List<String> j;

    /* renamed from: c.a.n0.j.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0701a implements c.a.n0.j.e0.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.o.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8709b;

        public C0701a(a aVar, c.a.n0.a.o.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8709b = aVar;
            this.a = aVar2;
        }

        @Override // c.a.n0.j.e0.h.c
        public void a(c.a.n0.j.e0.h.d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, str) == null) {
                this.f8709b.C(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.b0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8707g = false;
        this.f8708h = new ArrayList<>();
        this.i = new ArrayList(3);
        this.j = new ArrayList(3);
    }

    public final void C(c.a.n0.a.o.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            if (f.f8710d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            c.a.n0.j.n0.c.call(aVar, false, new b(str));
        }
    }

    @NonNull
    public final String D(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                c.a.n0.w.d.k(n.N(remove));
                if (f.f8710d) {
                    Log.d("GameRecorderApi", "deleteFile: " + remove);
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f.f8710d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.f8705e + "," + this.f8706f);
            }
            this.f8708h.clear();
            this.f8707g = false;
            g.a().b().t(this.f8705e, this.f8706f);
        }
    }

    public final boolean F(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dArr)) == null) {
            if (dArr == null || dArr.length < 2) {
                return false;
            }
            long j = (long) (dArr[0] * 1000.0d);
            long j2 = (long) (dArr[1] * 1000.0d);
            return j >= 0 && j2 >= 0 && j + j2 > 0;
        }
        return invokeL.booleanValue;
    }

    public final boolean G(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = g.a().b().l();
            if (f.f8710d) {
                Log.d("GameRecorderApi", "RecorderState:" + l);
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
    public final c.a.n0.a.o.b.a H(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            return F == null ? new c.a.n0.a.o.b.a() : F;
        }
        return (c.a.n0.a.o.b.a) invokeL.objValue;
    }

    public final void I(JsObject jsObject) {
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
            c.a.n0.a.o.b.a H = H(jsObject);
            String B = H.B("path");
            if (f.f8710d) {
                Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.f8707g);
            }
            if (this.f8707g) {
                return;
            }
            if (G(GameRecorderController.RecorderState.STOP)) {
                C(H, "clipVideo can only called after onStop");
            } else if (this.f8708h.isEmpty()) {
                C(H, "range is illegal");
            } else {
                new c.a.n0.j.e0.h.e(this.f8708h, n.B(B), n.N(D("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new C0701a(this, H));
                this.f8708h.clear();
                this.f8707g = true;
                c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
                eVar.f4188b = "clipVideo";
                c.a.n0.a.d2.n.h(eVar);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (f.f8710d) {
                Log.d("GameRecorderApi", "pause");
            }
            if (G(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            g.a().b().o();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            c.a.n0.a.o.b.a H = H(jsObject);
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = H.o("timeRange");
            I(jsObject);
            if (!F(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            c.a.n0.j.e0.h.b b2 = c.a.n0.j.e0.h.b.b(g.a().b().k(), o[0], o[1]);
            if (f.f8710d) {
                Log.d("GameRecorderApi", "recordClip:" + b2.toString());
            }
            this.f8708h.add(b2);
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            eVar.f4188b = "recordClip";
            c.a.n0.a.d2.n.h(eVar);
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (f.f8710d) {
                Log.d("GameRecorderApi", "resume");
            }
            if (G(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
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
            if (f.f8710d) {
                Log.d("GameRecorderApi", IntentConfig.STOP);
            }
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            g.a().b().u();
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (f.f8710d) {
                Log.d("GameRecorderApi", "start");
            }
            if (G(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
                return;
            }
            c.a.n0.a.o.b.a H = H(jsObject);
            int r = H.r("duration", 10);
            this.f8705e = r;
            if (r <= 0) {
                this.f8705e = 10;
            }
            if (this.f8705e > 120) {
                this.f8705e = 120;
            }
            if (this.i.size() == 0) {
                c.a.n0.w.d.k(n.N("bdfile://tmp/SwanVideoRecorder/"));
            }
            String D = D("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
            A(D);
            String N = n.N(D);
            this.f8706f = N;
            if (N == null) {
                if (f.f8710d) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (H.m("microphoneEnabled", false)) {
                z(2);
            }
            E();
            c.a.n0.j.f0.b.a.l();
        }
    }
}
