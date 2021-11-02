package b.a.p0.a.l0.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.j2.l;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.l0.a f6513a;

    /* renamed from: b  reason: collision with root package name */
    public String f6514b;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f6515d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f6516a;

        /* renamed from: b  reason: collision with root package name */
        public String f6517b;

        /* renamed from: c  reason: collision with root package name */
        public String f6518c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1019493644, "Lb/a/p0/a/l0/k/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1019493644, "Lb/a/p0/a/l0/k/c$a;");
                    return;
                }
            }
            f6515d = k.f6397a;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f6516a = new JSEvent("error");
        }

        public JSEvent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message", this.f6517b);
                    jSONObject.put("stack", this.f6518c);
                } catch (JSONException e2) {
                    if (f6515d) {
                        Log.getStackTraceString(e2);
                    }
                }
                if (jSONObject.length() > 0) {
                    this.f6516a.data = jSONObject;
                }
                return this.f6516a;
            }
            return (JSEvent) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f6517b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f6518c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(852569489, "Lb/a/p0/a/l0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(852569489, "Lb/a/p0/a/l0/k/c;");
                return;
            }
        }
        boolean z = k.f6397a;
    }

    public c(b.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6514b = "";
        this.f6513a = aVar;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || this.f6513a.n() == null) {
            return;
        }
        EventTarget n = this.f6513a.n();
        a aVar = new a();
        aVar.b(str + StringUtils.LF + str2);
        aVar.c("");
        n.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8ExceptionInfo) == null) || v8ExceptionInfo == null) {
            return;
        }
        String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
        String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
        String str3 = this.f6513a.m0() + "msg: " + str + " ,stack: " + str2;
        this.f6513a.y().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f6514b.equals(str)) {
            return;
        }
        this.f6514b = str;
        a(str, str2);
        b.a.p0.a.c1.b.j().e(str + ";" + str2);
        l.b(v8ExceptionInfo);
        b.a.p0.a.c1.b.i().s(v8ExceptionInfo);
    }
}
