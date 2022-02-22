package c.a.s0.j.e0;

import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f extends EventTargetImpl implements c.a.z.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11195h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f11196e;

    /* renamed from: f  reason: collision with root package name */
    public c f11197f;

    /* renamed from: g  reason: collision with root package name */
    public String f11198g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-375705400, "Lc/a/s0/j/e0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-375705400, "Lc/a/s0/j/e0/f;");
                return;
            }
        }
        f11195h = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11196e = -1;
        this.f11197f = new c();
        g.a().b().s(this);
    }

    @Override // c.a.z.c.c
    public void onError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (f11195h) {
                String str = "onError:" + i2;
            }
            x("error", new b("internal error"));
        }
    }

    @Override // c.a.z.c.c
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x("pause", this.f11197f);
            c.a.s0.a.n2.s.e eVar = new c.a.s0.a.n2.s.e();
            eVar.f8219b = "pause";
            n.h(eVar);
        }
    }

    @Override // c.a.z.c.c
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x("resume", this.f11197f);
            c.a.s0.a.n2.s.e eVar = new c.a.s0.a.n2.s.e();
            eVar.f8219b = "resume";
            n.h(eVar);
        }
    }

    @Override // c.a.z.c.c
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f11196e;
            x("start", i2 == -1 ? this.f11197f : new d(i2));
            c.a.s0.a.n2.s.e eVar = new c.a.s0.a.n2.s.e();
            eVar.f8219b = "start";
            n.h(eVar);
        }
    }

    @Override // c.a.z.c.c
    public void w(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            if (f11195h) {
                String str2 = "schemeVideoPath:" + this.f11198g;
            }
            x(IntentConfig.STOP, new e(this.f11198g));
            c.a.s0.a.n2.s.e eVar = new c.a.s0.a.n2.s.e();
            eVar.f8219b = IntentConfig.STOP;
            eVar.a("dura", String.valueOf(i2 / 1000.0f));
            n.h(eVar);
        }
    }

    public final void x(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            if (f11195h) {
                String str2 = "dispatchEvent:" + str;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f11196e = i2;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f11198g = str;
        }
    }
}
