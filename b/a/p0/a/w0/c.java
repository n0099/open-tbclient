package b.a.p0.a.w0;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.n0.l.b;
import b.a.p0.a.n1.f;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements b.a.p0.a.m.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8710e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements b.a.p0.a.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8711a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8711a = str;
        }

        @Override // b.a.p0.a.w0.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                b.a.p0.a.j0.c.b.s(AppRuntime.getAppContext().getContentResolver(), this.f8711a, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.w0.a f8712a;

        public b(b.a.p0.a.w0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8712a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            b.a.p0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (aVar = this.f8712a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (c.f8710e) {
                    String str = "上报数据 onSuccess: response=" + jSONObject;
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.f8712a.onResult(true);
                    return;
                } else {
                    this.f8712a.onResult(false);
                    return;
                }
            }
            aVar.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            b.a.p0.a.w0.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (aVar = this.f8712a) == null) {
                return;
            }
            aVar.onResult(false);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1338418488, "Lb/a/p0/a/w0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1338418488, "Lb/a/p0/a/w0/c;");
                return;
            }
        }
        f8710e = k.f6397a;
    }

    @WorkerThread
    public static void c(e eVar, b.C0310b c0310b) {
        b.a K;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, eVar, c0310b) == null) || eVar == null || (K = eVar.K()) == null || TextUtils.equals("1", K.b0())) {
            return;
        }
        String G = K.G();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", G) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", G) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", G)) {
            return;
        }
        if (f8710e) {
            String str = "addHistory: " + K.J() + " / " + G;
        }
        b.a.p0.a.w0.b a2 = b.a.p0.a.w0.b.a(K);
        boolean c2 = b.a.p0.a.j0.c.b.c(AppRuntime.getAppContext().getContentResolver(), a2, c0310b);
        a aVar = new a(G);
        if (c2) {
            e("ADD", a2.f8701a, a2.f8705e, a2.f8702b, a2.f8707g, a2.j, aVar);
        }
        boolean z = f8710e;
    }

    public static String d(String str, String str2, long j, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", str);
                if (TextUtils.isEmpty(str3)) {
                    jSONObject2.put("bundle_id", str2);
                } else {
                    jSONObject2.put("appkey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("pkg_type", Integer.parseInt(str4));
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("version_code", Integer.parseInt(str5));
                }
                jSONObject2.put("time", j);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (f8710e) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void e(String str, String str2, long j, String str3, String str4, String str5, b.a.p0.a.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, aVar}) == null) {
            String c2 = b.a.p0.a.c1.a.n().c();
            String d2 = d(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            if (f8710e) {
                String str6 = "reportHistoryDataToServer: 上行参数" + d2;
            }
            b bVar = new b(aVar);
            b.a.p0.m.d.a aVar2 = new b.a.p0.m.d.a();
            aVar2.f11034b = "POST";
            aVar2.f11033a = c2;
            aVar2.f11038f = true;
            aVar2.f11039g = true;
            aVar2.f11036d = RequestBody.create(f.f6891a, d2);
            aVar2.f11037e = bVar;
            b.a.p0.m.e.a.g().e(aVar2);
        }
    }
}
