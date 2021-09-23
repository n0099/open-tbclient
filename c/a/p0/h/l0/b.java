package c.a.p0.h.l0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f11320a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f11321b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f11322c;

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

    public static b d(c.a.p0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            b bVar = new b();
            JsFunction v = aVar.v("onCheckForUpdate");
            bVar.f11320a = v;
            if (v != null) {
                v.setReleaseMode(false);
            }
            JsFunction v2 = aVar.v("onUpdateReady");
            bVar.f11321b = v2;
            if (v2 != null) {
                v2.setReleaseMode(false);
            }
            JsFunction v3 = aVar.v("onUpdateFailed");
            bVar.f11322c = v3;
            if (v3 != null) {
                v3.setReleaseMode(false);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void a(c cVar) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (jsFunction = this.f11320a) == null) {
            return;
        }
        jsFunction.call(cVar);
    }

    public void b() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jsFunction = this.f11322c) == null) {
            return;
        }
        jsFunction.call();
    }

    public void c() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jsFunction = this.f11321b) == null) {
            return;
        }
        jsFunction.call();
    }
}
