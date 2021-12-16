package c.a.q0.j.e0;

import c.a.q0.a.k;
import c.a.q0.a.n2.n;
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
public class f extends EventTargetImpl implements c.a.y.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10467h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f10468e;

    /* renamed from: f  reason: collision with root package name */
    public c f10469f;

    /* renamed from: g  reason: collision with root package name */
    public String f10470g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(17321610, "Lc/a/q0/j/e0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(17321610, "Lc/a/q0/j/e0/f;");
                return;
            }
        }
        f10467h = k.a;
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
        this.f10468e = -1;
        this.f10469f = new c();
        g.a().b().s(this);
    }

    @Override // c.a.y.c.c
    public void onError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (f10467h) {
                String str = "onError:" + i2;
            }
            x("error", new b("internal error"));
        }
    }

    @Override // c.a.y.c.c
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x("pause", this.f10469f);
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7422b = "pause";
            n.h(eVar);
        }
    }

    @Override // c.a.y.c.c
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x("resume", this.f10469f);
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7422b = "resume";
            n.h(eVar);
        }
    }

    @Override // c.a.y.c.c
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f10468e;
            x("start", i2 == -1 ? this.f10469f : new d(i2));
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7422b = "start";
            n.h(eVar);
        }
    }

    @Override // c.a.y.c.c
    public void w(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            if (f10467h) {
                String str2 = "schemeVideoPath:" + this.f10470g;
            }
            x(IntentConfig.STOP, new e(this.f10470g));
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7422b = IntentConfig.STOP;
            eVar.a("dura", String.valueOf(i2 / 1000.0f));
            n.h(eVar);
        }
    }

    public final void x(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            if (f10467h) {
                String str2 = "dispatchEvent:" + str;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f10468e = i2;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f10470g = str;
        }
    }
}
