package c.a.p0.e.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d0.c;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import c.a.p0.a.u2.a;
import c.a.p0.a.v2.o0;
import c.a.p0.t.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements c.a.p0.a.u2.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10482a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.e.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0521a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0425a f10483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10484b;

        public C0521a(a aVar, a.InterfaceC0425a interfaceC0425a, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, interfaceC0425a, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10483a = interfaceC0425a;
            this.f10484b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            a.InterfaceC0425a interfaceC0425a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (interfaceC0425a = this.f10483a) == null) {
                return;
            }
            interfaceC0425a.c(jSONObject, this.f10484b);
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
                String string = response.body().string();
                a.f(response, System.currentTimeMillis());
                return new JSONObject(string);
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a.InterfaceC0425a interfaceC0425a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0425a = this.f10483a) == null) {
                return;
            }
            interfaceC0425a.c(null, null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1244238678, "Lc/a/p0/e/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1244238678, "Lc/a/p0/e/r/a;");
                return;
            }
        }
        f10482a = k.f7077a;
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
            }
        }
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return f.d((str + System.currentTimeMillis() + str2).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return context.getExternalCacheDir() + File.separator + "favor_screenshot" + File.separator;
        }
        return (String) invokeL.objValue;
    }

    public static RequestBody e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oname_list", jSONArray);
                return RequestBody.create(c.a.p0.a.n1.f.f7580a, jSONObject.toString());
            } catch (JSONException e2) {
                if (f10482a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (RequestBody) invokeL.objValue;
    }

    public static void f(Response response, long j2) {
        Date parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, response, j2) == null) {
            String header = response.header("Date");
            if (TextUtils.isEmpty(header) || (parse = HttpDate.parse(header)) == null) {
                return;
            }
            long time = parse.getTime();
            if (time >= 1) {
                long j3 = j2 - time;
                h.a().putLong("server_time_delta", j3);
                if (f10482a) {
                    String str = "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j3;
                }
            }
        }
    }

    @Override // c.a.p0.a.u2.a
    public boolean a(String str, c.a.p0.a.j1.d.a aVar) {
        InterceptResult invokeLL;
        PutObjectResponse putObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, aVar)) == null) {
            if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.f6959a) && !TextUtils.isEmpty(aVar.f6960b) && !TextUtils.isEmpty(aVar.f6961c) && !TextUtils.isEmpty(aVar.f6964f)) {
                try {
                    BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                    bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(aVar.f6959a, aVar.f6960b, aVar.f6961c));
                    bosClientConfiguration.setEndpoint("bj.bcebos.com");
                    BosClient bosClient = new BosClient(bosClientConfiguration);
                    File file = new File(str);
                    if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(aVar.f6962d, aVar.f6964f, file))) != null) {
                        if (!TextUtils.isEmpty(putObject.getETag())) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (f10482a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.a.u2.a
    public void b(Context context, String str, a.InterfaceC0425a interfaceC0425a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, interfaceC0425a) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String v = c.v(c.a.p0.a.c1.a.n().e());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : c.a.p0.a.d0.b.b().f5139d.entrySet()) {
            v = o0.a(v, entry.getKey(), entry.getValue());
        }
        String c2 = c(d(context), str.substring(str.lastIndexOf(".")));
        RequestBody e2 = e(c2);
        if (e2 == null) {
            return;
        }
        c.a.p0.m.d.a aVar = new c.a.p0.m.d.a(v, e2, new C0521a(this, interfaceC0425a, c2));
        if (c.a.p0.m.e.a.g().c()) {
            aVar.f11845f = true;
        }
        aVar.f11846g = false;
        aVar.f11842c = hashMap;
        c.a.p0.m.e.a.g().e(aVar);
    }
}
