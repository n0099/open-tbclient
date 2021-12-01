package c.a.p0.a.r;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0432a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.z2.g1.c a;

        public C0432a(c.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.onCallback(null);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                a.i(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.z2.g1.c a;

        public b(c.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.onCallback(null);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                a.g(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358755282, "Lc/a/p0/a/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358755282, "Lc/a/p0/a/r/a;");
                return;
            }
        }
        a = k.a;
    }

    @Nullable
    public static Request c(c.a.p0.a.d2.e eVar, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, eVar, jSONObject, unitedSchemeEntity)) == null) {
            if (jSONObject == null) {
                q(unitedSchemeEntity, 202, "illegal entity");
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("fileMap");
            String optString = jSONObject.optString("service");
            String optString2 = jSONObject.optString(RetrieveTaskManager.KEY);
            if (eVar != null && optJSONObject != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    type.addFormDataPart(next, optJSONObject.optString(next));
                }
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String M = c.a.p0.a.o2.b.M(optJSONObject2.optString(next2), c.a.p0.a.d2.e.f0());
                        if (!TextUtils.isEmpty(M)) {
                            File file = new File(M);
                            if (!file.exists()) {
                                q(unitedSchemeEntity, 1001, "upload file not exist");
                                return null;
                            } else if (file.length() > 10485760) {
                                q(unitedSchemeEntity, 1001, "upload file too large");
                                return null;
                            } else {
                                type.addFormDataPart(next2, file.getName(), new h(file));
                            }
                        }
                    }
                }
                String N = eVar.N();
                long a2 = c.a.p0.a.c1.a.l().a(AppRuntime.getAppContext());
                String r = r(optJSONObject, N, a2, c.a.p0.a.c1.a.h0().f(AppRuntime.getAppContext()));
                if (r == null) {
                    q(unitedSchemeEntity, 1001, "sign error");
                    return null;
                }
                HttpUrl parse = HttpUrl.parse(c.a.p0.a.c1.a.m().processUrl(c.a.p0.a.c1.a.o().O() + "/" + optString + optString2));
                if (parse == null) {
                    q(unitedSchemeEntity, 1001, "request url error");
                    return null;
                }
                HttpUrl.Builder newBuilder = parse.newBuilder();
                newBuilder.addQueryParameter("ai_sign", r);
                newBuilder.addQueryParameter(Constants.API_KEY, N);
                newBuilder.addQueryParameter("timestamp", String.valueOf(a2));
                newBuilder.addQueryParameter("host_app", c.a.p0.q.c.b().c());
                newBuilder.addQueryParameter("host_app_ver", c.a.p0.q.c.b().h());
                newBuilder.addQueryParameter("sdk_ver", c.a.p0.q.c.b().b());
                newBuilder.addQueryParameter("host_os", c.a.p0.w.a.f());
                newBuilder.addQueryParameter("host_os_ver", c.a.p0.w.a.g());
                Request.Builder post = new Request.Builder().url(newBuilder.build()).post(type.build());
                String d2 = c.a.p0.a.c1.a.h0().d(AppRuntime.getAppContext());
                String str = "BDUSS=" + d2;
                if (!TextUtils.isEmpty(d2)) {
                    post.addHeader("Cookie", str);
                }
                return post.build();
            }
            q(unitedSchemeEntity, 202, "illegal request");
            return null;
        }
        return (Request) invokeLLL.objValue;
    }

    public static void d(String str, c.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, cVar) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("cloud")) {
                URI create = URI.create(str);
                String host = create.getHost();
                if (TextUtils.isEmpty(create.toString()) && TextUtils.isEmpty(host)) {
                    cVar.onCallback(null);
                    return;
                }
                Request c2 = c(c.a.p0.a.d2.e.L(), h(str), null);
                if (c.a.p0.a.d2.e.L() == null) {
                    cVar.onCallback(null);
                    return;
                } else {
                    p(c2.url().toString(), c2.body(), new C0432a(cVar));
                    return;
                }
            }
            cVar.onCallback(null);
        }
    }

    public static void e(JSONArray jSONArray, c.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jSONArray, cVar) == null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                Request c2 = c(c.a.p0.a.d2.e.L(), f(jSONArray.toString()), null);
                if (c.a.p0.a.d2.e.L() == null) {
                    cVar.onCallback(null);
                    return;
                } else {
                    p(c2.url().toString(), c2.body(), new b(cVar));
                    return;
                }
            }
            cVar.onCallback(null);
        }
    }

    public static JSONObject f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? l(str, null) : (JSONObject) invokeL.objValue;
    }

    public static void g(Response response, c.a.p0.a.z2.g1.c<String> cVar) {
        String header;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, response, cVar) == null) && (header = response.header("Content-Type", "")) != null && header.contains("application/json")) {
            JSONObject jSONObject = new JSONObject();
            if (response.body() != null) {
                try {
                    jSONObject = new JSONObject(response.body().string());
                } catch (IOException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    cVar.onCallback(null);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                    cVar.onCallback(null);
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("fileList");
            if (optJSONArray == null) {
                cVar.onCallback(null);
            } else {
                cVar.onCallback(optJSONArray.toString());
            }
        }
    }

    public static JSONObject h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? l(null, str) : (JSONObject) invokeL.objValue;
    }

    public static void i(Response response, c.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, response, cVar) == null) {
            try {
                String header = response.header("Content-Type", "");
                if (header == null || !header.contains("application/json")) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (response.body() != null) {
                    jSONObject = new JSONObject(response.body().string());
                }
                String optString = jSONObject.optString("DownloadUrl");
                if (!TextUtils.isEmpty(optString)) {
                    cVar.onCallback(optString);
                } else {
                    cVar.onCallback(null);
                }
            } catch (Exception unused) {
                cVar.onCallback(null);
            }
        }
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 1001;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeL.intValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? TextUtils.isEmpty(str) ? "请求失败" : str : (String) invokeL.objValue;
    }

    public static JSONObject l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("fileID", str2);
                    jSONObject.put(RetrieveTaskManager.KEY, "/v1/workspace/storage/request-download");
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(RetrieveTaskManager.KEY, "/v1/workspace/storage/batch-download");
                    jSONObject2.put("fileList", str);
                }
                jSONObject.put("service", "cloud");
                jSONObject.put("stringMap", jSONObject2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject m(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, response)) == null) {
            try {
                return new JSONObject(response.body() != null ? response.body().string() : null);
            } catch (IOException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            } catch (JSONException e3) {
                if (a) {
                    e3.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errMsg", str3);
                jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, 200);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("fileID", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("tempFilePath", str2);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? j(str) != 0 : invokeL.booleanValue;
    }

    public static void p(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, str, requestBody, responseCallback) == null) {
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(str, requestBody, responseCallback);
            aVar.f10674f = true;
            aVar.f10675g = true;
            aVar.f10676h = true;
            c.a.p0.p.e.a.g().e(aVar);
        }
    }

    public static void q(UnitedSchemeEntity unitedSchemeEntity, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65553, null, unitedSchemeEntity, i2, str) == null) || unitedSchemeEntity == null) {
            return;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2, str);
    }

    public static String r(JSONObject jSONObject, String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{jSONObject, str, Long.valueOf(j2), str2})) == null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                ArrayList<String> arrayList = new ArrayList();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
                Collections.sort(arrayList);
                StringBuilder sb = new StringBuilder();
                for (String str3 : arrayList) {
                    String optString = jSONObject.optString(str3);
                    sb.append(URLEncoder.encode(str3));
                    sb.append("=");
                    sb.append(URLEncoder.encode(optString));
                    sb.append("&");
                }
                String sb2 = sb.toString();
                if (sb2.endsWith("&")) {
                    sb2 = sb2.substring(0, sb2.length() - 1);
                }
                String d2 = c.a.p0.w.f.d(sb2.getBytes(), false);
                byte[] copyOf = Arrays.copyOf(Base64.decode(c.a.p0.w.f.d(str.getBytes(), false), 0), 24);
                byte[] copyOf2 = Arrays.copyOf(Base64.decode(c.a.p0.w.f.d(String.format("%s%d", str2, Long.valueOf(j2)).getBytes(), false).getBytes(), 0), 16);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, new SecretKeySpec(copyOf, "AES"), new IvParameterSpec(copyOf2));
                String str4 = new String(Base64.encode(cipher.doFinal(d2.getBytes()), 0), StandardCharsets.UTF_8);
                return str4.endsWith(StringUtils.LF) ? str4.substring(0, str4.length() - 1) : str4;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }
}
