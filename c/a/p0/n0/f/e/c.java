package c.a.p0.n0.f.e;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class c extends c.a.p0.n0.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.n0.a f16490e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.n0.f.a context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.p0.n0.f.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // c.b.a.a.f
    public void c(c.b.a.a.c engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // c.a.p0.n0.f.c.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final c.a.p0.n0.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16490e : (c.a.p0.n0.a) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.n0.a aVar = this.f16490e;
            if (aVar != null) {
                c.a.p0.n0.a c2 = i().c();
                if (c2.j() != aVar.j() || c2.g() != aVar.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c2.j() + " to " + aVar.j());
                    aVar.G();
                    aVar.I();
                    aVar.F();
                    aVar.C();
                }
                if (!(c2.v() == aVar.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c2.v() + " to " + aVar.v());
                    aVar.I();
                    aVar.F();
                    aVar.G();
                    aVar.C();
                }
                if (c2.w() != aVar.w()) {
                    aVar.J();
                }
                if (!(c2.u() == aVar.u()) || c2.e() != aVar.e()) {
                    aVar.F();
                    aVar.J();
                    aVar.I();
                }
                if (c2.n().size() != aVar.n().size() || c2.l() != aVar.l()) {
                    aVar.D();
                }
                i().h(aVar);
            }
            this.f16490e = null;
        }
    }

    public final void m(c.a.p0.n0.a danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.f16490e = danmakuConfig;
        }
    }

    @Override // c.b.a.a.f
    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            l();
        }
    }
}
