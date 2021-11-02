package b.a.p0.h.l0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f10515a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f10516b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f10517c;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b d(b.a.p0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            b bVar = new b();
            JsFunction u = aVar.u("onCheckForUpdate");
            bVar.f10515a = u;
            if (u != null) {
                u.setReleaseMode(false);
            }
            JsFunction u2 = aVar.u("onUpdateReady");
            bVar.f10516b = u2;
            if (u2 != null) {
                u2.setReleaseMode(false);
            }
            JsFunction u3 = aVar.u("onUpdateFailed");
            bVar.f10517c = u3;
            if (u3 != null) {
                u3.setReleaseMode(false);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void a(c cVar) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (jsFunction = this.f10515a) == null) {
            return;
        }
        jsFunction.call(cVar);
    }

    public void b() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jsFunction = this.f10517c) == null) {
            return;
        }
        jsFunction.call();
    }

    public void c() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jsFunction = this.f10516b) == null) {
            return;
        }
        jsFunction.call();
    }
}
