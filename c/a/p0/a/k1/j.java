package c.a.p0.a.k1;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
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
    public static final boolean f6319e;

    /* renamed from: f  reason: collision with root package name */
    public static j f6320f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, JSONArray> a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f6321b;

    /* renamed from: c  reason: collision with root package name */
    public String f6322c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f6323d;

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
            Application c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (c2 = c.a.p0.a.s0.a.c()) == null) {
                return;
            }
            c(c2.getString(i2));
        }

        public abstract void c(String str);
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AtomicInteger a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6324b;

        /* renamed from: c  reason: collision with root package name */
        public int f6325c;

        /* renamed from: d  reason: collision with root package name */
        public a f6326d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f6327e;

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
            this.f6327e = jVar;
            this.a = new AtomicInteger(0);
            this.f6325c = i2;
            this.f6326d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || this.f6324b || this.a.incrementAndGet() < this.f6325c || (aVar = this.f6326d) == null) {
                return;
            }
            aVar.b(R.string.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
                this.f6324b = true;
                this.f6327e.a = new ArrayMap();
                a aVar = this.f6326d;
                if (aVar != null) {
                    aVar.b(R.string.aiapps_debug_report_success);
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
                        boolean unused2 = j.f6319e;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(821807619, "Lc/a/p0/a/k1/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(821807619, "Lc/a/p0/a/k1/j;");
                return;
            }
        }
        f6319e = c.a.p0.a.a.a;
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
        this.a = new ArrayMap();
        this.f6322c = "";
        this.f6323d = new HashMap();
    }

    public static j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6320f == null) {
                synchronized (j.class) {
                    if (f6320f == null) {
                        f6320f = new j();
                    }
                }
            }
            return f6320f;
        }
        return (j) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || this.a == null || jSONObject == null) {
            return;
        }
        String T = c.a.p0.a.w0.f.U().T();
        JSONArray jSONArray = this.a.get(T);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.a.put(T, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (!f() || i2 >= this.f6321b.length) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(this.f6321b[i2]);
            sb.append(":");
            sb.append(this.f6322c);
            sb.append("/uploadTraceData");
            sb.append("?");
            for (Map.Entry<String, String> entry : this.f6323d.entrySet()) {
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
            String[] strArr = this.f6321b;
            return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f6322c)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (!f()) {
                c.a.p0.a.s1.b.f.e.f(c.a.p0.a.t1.d.J().x(), R.string.aiapps_debug_report_invalid_params).G();
                return;
            }
            Map<String, JSONArray> map = this.a;
            if (map != null && map.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (Map.Entry<String, JSONArray> entry : this.a.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("path", entry.getKey());
                        jSONObject.putOpt("data", entry.getValue().toString());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException unused) {
                    boolean z = f6319e;
                }
                c.a.p0.p.c.f postRequest = c.a.p0.p.e.a.g().postRequest();
                postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
                postRequest.connectionTimeout(3000);
                int min = Math.min(this.f6321b.length, 4);
                b bVar = new b(this, min, aVar);
                for (int i2 = 0; i2 < min; i2++) {
                    postRequest.url(d(i2));
                    postRequest.build().executeAsync(bVar);
                }
                return;
            }
            SwanAppAlertDialog.a aVar2 = new SwanAppAlertDialog.a(c.a.p0.a.t1.d.J().x());
            aVar2.U(R.string.aiapps_debug_report_performance);
            aVar2.v(R.string.aiapps_debug_report_no_data);
            aVar2.n(new c.a.p0.a.q2.h.a());
            aVar2.O(R.string.aiapps_confirm, null);
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
            if (f6319e) {
                String str = "IP : " + string;
                String str2 = "Port : " + string2;
                String str3 = "Project ID : " + string3;
            }
            this.f6321b = string.split("_");
            this.f6322c = string2;
            this.f6323d.put("projectId", string3);
            return;
        }
        boolean z = f6319e;
    }
}
