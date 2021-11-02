package b.a.p0.h.d0;

import b.a.p0.a.k;
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
/* loaded from: classes4.dex */
public class f extends EventTargetImpl implements b.a.x.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10353h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f10354e;

    /* renamed from: f  reason: collision with root package name */
    public c f10355f;

    /* renamed from: g  reason: collision with root package name */
    public String f10356g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1056537143, "Lb/a/p0/h/d0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1056537143, "Lb/a/p0/h/d0/f;");
                return;
            }
        }
        f10353h = k.f6397a;
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
        this.f10354e = -1;
        this.f10355f = new c();
        g.a().b().s(this);
    }

    @Override // b.a.x.c.c
    public void onError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (f10353h) {
                String str = "onError:" + i2;
            }
            w("error", new b("internal error"));
        }
    }

    @Override // b.a.x.c.c
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w("pause", this.f10355f);
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "pause";
            b.a.p0.a.j2.k.h(eVar);
        }
    }

    @Override // b.a.x.c.c
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w("resume", this.f10355f);
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "resume";
            b.a.p0.a.j2.k.h(eVar);
        }
    }

    @Override // b.a.x.c.c
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f10354e;
            w("start", i2 == -1 ? this.f10355f : new d(i2));
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = "start";
            b.a.p0.a.j2.k.h(eVar);
        }
    }

    @Override // b.a.x.c.c
    public void v(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            if (f10353h) {
                String str2 = "schemeVideoPath:" + this.f10356g;
            }
            w(IntentConfig.STOP, new e(this.f10356g));
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = IntentConfig.STOP;
            eVar.a("dura", String.valueOf(i2 / 1000.0f));
            b.a.p0.a.j2.k.h(eVar);
        }
    }

    public final void w(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            if (f10353h) {
                String str2 = "dispatchEvent:" + str;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f10354e = i2;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f10356g = str;
        }
    }
}
