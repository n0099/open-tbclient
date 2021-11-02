package b.a.p0.h.d0;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.j2.k;
import b.a.p0.a.r0.n;
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
/* loaded from: classes4.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f10350i;
    public String j;
    public boolean k;
    public ArrayList<b.a.p0.h.d0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: b.a.p0.h.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0560a implements b.a.p0.h.d0.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10351a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10352b;

        public C0560a(a aVar, b.a.p0.a.y.b.a aVar2) {
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
            this.f10352b = aVar;
            this.f10351a = aVar2;
        }

        @Override // b.a.p0.h.d0.h.c
        public void a(b.a.p0.h.d0.h.d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, str) == null) {
                this.f10352b.A(this.f10351a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.l0.c cVar) {
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
        this.k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void A(b.a.p0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            if (f.f10353h) {
                String str2 = "callFailureCallback: errMsg=" + str;
            }
            b.a.p0.h.m0.c.call(aVar, false, new b(str));
        }
    }

    @NonNull
    public final String B(String str, @NonNull List<String> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i2)) == null) {
            if (list.size() >= i2) {
                String remove = list.remove(0);
                b.a.p0.t.d.j(n.K(remove));
                if (f.f10353h) {
                    String str2 = "deleteFile: " + remove;
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f.f10353h) {
                String str = "doStartRecorder:" + this.f10350i + "," + this.j;
            }
            this.l.clear();
            this.k = false;
            g.a().b().t(this.f10350i, this.j);
        }
    }

    public final boolean D(double[] dArr) {
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

    public final boolean E(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = g.a().b().l();
            if (f.f10353h) {
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
    public final b.a.p0.a.y.b.a F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            return F == null ? new b.a.p0.a.y.b.a() : F;
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }

    public final void G(JsObject jsObject) {
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
            b.a.p0.a.y.b.a F = F(jsObject);
            String B = F.B("path");
            if (f.f10353h) {
                String str = "clipPath:" + B + "，hasExecutedClip：" + this.k;
            }
            if (this.k) {
                return;
            }
            if (E(GameRecorderController.RecorderState.STOP)) {
                A(F, "clipVideo can only called after onStop");
            } else if (this.l.isEmpty()) {
                A(F, "range is illegal");
            } else {
                new b.a.p0.h.d0.h.e(this.l, n.y(B), n.K(B("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C0560a(this, F));
                this.l.clear();
                this.k = true;
                b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
                eVar.f6384b = "clipVideo";
                k.h(eVar);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = f.f10353h;
            if (E(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            g.a().b().o();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            b.a.p0.a.y.b.a F = F(jsObject);
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = F.o("timeRange");
            G(jsObject);
            if (!D(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            b.a.p0.h.d0.h.b b2 = b.a.p0.h.d0.h.b.b(g.a().b().k(), o[0], o[1]);
            if (f.f10353h) {
                String str = "recordClip:" + b2.toString();
            }
            this.l.add(b2);
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "recordClip";
            k.h(eVar);
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = f.f10353h;
            if (E(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
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
            boolean z = f.f10353h;
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            g.a().b().u();
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            boolean z = f.f10353h;
            if (E(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
                return;
            }
            b.a.p0.a.y.b.a F = F(jsObject);
            int r = F.r("duration", 10);
            this.f10350i = r;
            if (r <= 0) {
                this.f10350i = 10;
            }
            if (this.f10350i > 120) {
                this.f10350i = 120;
            }
            if (this.m.size() == 0) {
                b.a.p0.t.d.j(n.K("bdfile://tmp/SwanVideoRecorder/"));
            }
            String B = B("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
            y(B);
            String K = n.K(B);
            this.j = K;
            if (K == null) {
                boolean z2 = f.f10353h;
                return;
            }
            if (F.m("microphoneEnabled", false)) {
                x(2);
            }
            C();
            b.a.p0.h.e0.b.a.l();
        }
    }
}
