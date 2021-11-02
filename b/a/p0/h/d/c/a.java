package b.a.p0.h.d.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JsFunction f10345a;

    /* renamed from: b  reason: collision with root package name */
    public JsFunction f10346b;

    /* renamed from: c  reason: collision with root package name */
    public JsFunction f10347c;

    public a() {
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

    public static a e(b.a.p0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.f10345a = aVar.u("success");
            aVar2.f10346b = aVar.u(com.baidu.pass.biometrics.face.liveness.b.a.g0);
            aVar2.f10347c = aVar.u(XAdRemoteEvent.COMPLETE);
            return aVar2;
        }
        return (a) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JsFunction jsFunction = this.f10346b;
            if (jsFunction != null) {
                jsFunction.call();
            }
            JsFunction jsFunction2 = this.f10347c;
            if (jsFunction2 != null) {
                jsFunction2.call();
            }
            f(this.f10345a);
        }
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            JsFunction jsFunction = this.f10346b;
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            JsFunction jsFunction2 = this.f10347c;
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            f(this.f10345a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            JsFunction jsFunction = this.f10345a;
            if (jsFunction != null) {
                jsFunction.call();
            }
            JsFunction jsFunction2 = this.f10347c;
            if (jsFunction2 != null) {
                jsFunction2.call();
            }
            f(this.f10346b);
        }
    }

    public void d(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            JsFunction jsFunction = this.f10345a;
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            JsFunction jsFunction2 = this.f10347c;
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            f(this.f10346b);
        }
    }

    public final void f(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsFunction) == null) || jsFunction == null) {
            return;
        }
        jsFunction.release();
    }
}
