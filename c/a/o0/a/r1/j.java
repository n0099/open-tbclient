package c.a.o0.a.r1;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8328e;

    /* renamed from: f  reason: collision with root package name */
    public static j f8329f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, JSONArray> f8330a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f8331b;

    /* renamed from: c  reason: collision with root package name */
    public String f8332c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f8333d;

    /* loaded from: classes.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public final void b(int i2) {
            Application b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (b2 = c.a.o0.a.c1.a.b()) == null) {
                return;
            }
            c(b2.getString(i2));
        }

        public abstract void c(String str);
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f8334a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8335b;

        /* renamed from: c  reason: collision with root package name */
        public int f8336c;

        /* renamed from: d  reason: collision with root package name */
        public a f8337d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f8338e;

        public b(j jVar, int i2, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8338e = jVar;
            this.f8334a = new AtomicInteger(0);
            this.f8336c = i2;
            this.f8337d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || this.f8335b || this.f8334a.incrementAndGet() < this.f8336c || (aVar = this.f8337d) == null) {
                return;
            }
            aVar.b(c.a.o0.a.h.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
                this.f8335b = true;
                this.f8338e.f8330a = new ArrayMap();
                a aVar = this.f8337d;
                if (aVar != null) {
                    aVar.b(c.a.o0.a.h.aiapps_debug_report_success);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    try {
                        return response.body().string();
                    } catch (IOException unused) {
                        boolean unused2 = j.f8328e;
                    }
                }
                return null;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1024785771, "Lc/a/o0/a/r1/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1024785771, "Lc/a/o0/a/r1/j;");
                return;
            }
        }
        f8328e = k.f7049a;
    }

    public j() {
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
        this.f8330a = new ArrayMap();
        this.f8332c = "";
        this.f8333d = new HashMap();
    }

    public static j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8329f == null) {
                synchronized (j.class) {
                    if (f8329f == null) {
                        f8329f = new j();
                    }
                }
            }
            return f8329f;
        }
        return (j) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || this.f8330a == null || jSONObject == null) {
            return;
        }
        String U = c.a.o0.a.g1.f.V().U();
        JSONArray jSONArray = this.f8330a.get(U);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.f8330a.put(U, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (!f() || i2 >= this.f8331b.length) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(this.f8331b[i2]);
            sb.append(":");
            sb.append(this.f8332c);
            sb.append("/uploadTraceData");
            sb.append("?");
            for (Map.Entry<String, String> entry : this.f8333d.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String[] strArr = this.f8331b;
            return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f8332c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (!f()) {
                c.a.o0.a.z1.b.f.e.f(c.a.o0.a.a2.d.g().x(), c.a.o0.a.h.aiapps_debug_report_invalid_params).F();
                return;
            }
            Map<String, JSONArray> map = this.f8330a;
            if (map != null && map.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (Map.Entry<String, JSONArray> entry : this.f8330a.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("path", entry.getKey());
                        jSONObject.putOpt("data", entry.getValue().toString());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException unused) {
                    boolean z = f8328e;
                }
                c.a.o0.m.c.f postRequest = c.a.o0.m.e.a.g().postRequest();
                postRequest.requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONArray.toString()));
                postRequest.connectionTimeout(3000);
                int min = Math.min(this.f8331b.length, 4);
                b bVar = new b(this, min, aVar);
                for (int i2 = 0; i2 < min; i2++) {
                    postRequest.url(d(i2));
                    postRequest.build().executeAsync(bVar);
                }
                return;
            }
            SwanAppAlertDialog.a aVar2 = new SwanAppAlertDialog.a(c.a.o0.a.a2.d.g().x());
            aVar2.U(c.a.o0.a.h.aiapps_debug_report_performance);
            aVar2.v(c.a.o0.a.h.aiapps_debug_report_no_data);
            aVar2.n(new c.a.o0.a.w2.h.a());
            aVar2.O(c.a.o0.a.h.aiapps_confirm, null);
            aVar2.X();
        }
    }

    public void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) || bundle == null) {
            return;
        }
        String string = bundle.getString("tool_ip");
        String string2 = bundle.getString("tool_port");
        String string3 = bundle.getString("projectId");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            if (f8328e) {
                String str = "IP : " + string;
                String str2 = "Port : " + string2;
                String str3 = "Project ID : " + string3;
            }
            this.f8331b = string.split("_");
            this.f8332c = string2;
            this.f8333d.put("projectId", string3);
            return;
        }
        boolean z = f8328e;
    }
}
