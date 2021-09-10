package c.a.t0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f29916b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b0 f29917c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f29918a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1071614336, "Lc/a/t0/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1071614336, "Lc/a/t0/b0;");
                return;
            }
        }
        f29916b = AppConfig.isDebug();
    }

    public b0() {
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
        this.f29918a = c.a.h0.b.a.a.g();
    }

    public static b0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f29917c == null) {
                synchronized (b0.class) {
                    if (f29917c == null) {
                        f29917c = new b0();
                    }
                }
            }
            return f29917c;
        }
        return (b0) invokeV.objValue;
    }

    public void b(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) || !this.f29918a || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("dbOverNum", i2);
            jSONObject.put("tableName", str2);
            c("logDiscard", "database", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            e0 e0Var = (e0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (f29916b) {
                String str3 = "Quality event: type=" + str + ", value=" + str2 + ",ext=" + (jSONObject != null ? jSONObject.toString() : "");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("type", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("value", str2);
                }
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                e0Var.onEvent("1876", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) || !this.f29918a || TextUtils.isEmpty(str) || i2 == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("fileNum", i2);
            c("logDiscard", "fileNum", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048579, this, str, i2, i3, i4) == null) && this.f29918a && !TextUtils.isEmpty(str)) {
            if (i2 == 0 && i3 == 0 && i4 == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                if (i2 != 0) {
                    jSONObject.put("flowExpired", i2);
                }
                if (i3 != 0) {
                    jSONObject.put("eventExpired", i3);
                }
                if (i4 != 0) {
                    jSONObject.put("flowInterrupt", i4);
                }
                c("logDiscard", "timeExpired", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.f29918a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                c("logDiscard", "realLog", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) || !this.f29918a || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("size", str2);
            jSONObject.put("logId", str3);
            c("logSize", "single", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.f29918a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                c("sqlError", null, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) && this.f29918a) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("msg", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("exception", str2);
                }
                c("sendFail", "requestError", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.f29918a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                c("sendFail", "bodyError", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && this.f29918a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", i2);
                c("sendFail", "backend", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) || !this.f29918a || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str2);
            jSONObject.put("size", str3);
            c("logSize", str, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void m(boolean z, long j2) {
        int p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            if (z) {
                p = g.n().q();
            } else {
                p = g.n().p();
            }
            String str = z ? "uploadReal" : "uploadNonReal";
            if (j2 > p) {
                l(str, String.valueOf(p), String.valueOf(j2));
            }
        }
    }
}
