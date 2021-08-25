package c.a.o0.a.p.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.p.d.u0;
import c.a.o0.a.s0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c0 implements u0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7817a;

    /* renamed from: b  reason: collision with root package name */
    public static int f7818b;

    /* renamed from: c  reason: collision with root package name */
    public static int f7819c;

    /* renamed from: d  reason: collision with root package name */
    public static int f7820d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.x1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.j f7821a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f7822b;

        public a(c0 c0Var, a.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7822b = c0Var;
            this.f7821a = jVar;
        }

        @Override // c.a.o0.a.x1.a
        public void a(JSONObject jSONObject) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    if (jSONObject.optInt("errno") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            this.f7821a.a(optJSONObject.optString("tip"), this.f7822b.i(optJSONObject.optJSONArray("list")), false);
                            return;
                        }
                    } else {
                        str = jSONObject.optString("tipmsg");
                        this.f7821a.a(str, null, false);
                    }
                }
                str = null;
                this.f7821a.a(str, null, false);
            }
        }

        @Override // c.a.o0.a.x1.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f7821a.a(str, null, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final c.a.o0.a.x1.a f7823a;

        public b(@Nullable c.a.o0.a.x1.a aVar) {
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
            this.f7823a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            c.a.o0.a.x1.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) || (aVar = this.f7823a) == null) {
                return;
            }
            if (jSONObject == null) {
                aVar.onFail("request fail");
            } else {
                aVar.a(jSONObject);
            }
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
                if (c0.f7817a) {
                    String str = "statusCode:" + i2 + ", response=" + string;
                }
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean unused = c0.f7817a;
                c.a.o0.a.x1.a aVar = this.f7823a;
                if (aVar != null) {
                    aVar.onFail(exc.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514345107, "Lc/a/o0/a/p/c/c0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-514345107, "Lc/a/o0/a/p/c/c0;");
                return;
            }
        }
        f7817a = c.a.o0.a.k.f7049a;
        f7818b = 0;
        f7819c = 1;
        f7820d = 2;
    }

    public c0() {
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

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.o0.a.d0.c.w(String.format("%s/ma/formid/multi_action", c.a.o0.a.d0.c.f5112a), true) : (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c.a.o0.a.d0.c.w(String.format("%s/ma/formid/new", c.a.o0.a.d0.c.f5112a), true) : (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? c.a.o0.a.d0.c.w(String.format("%s/ma/component/sub/create", c.a.o0.a.d0.c.f5112a), true) : (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a.o0.a.d0.c.w(String.format("%s/ma/component/msgtpl", c.a.o0.a.d0.c.f5112a), true) : (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.o0.a.d0.c.w(String.format("%s/ma/payid/new", c.a.o0.a.d0.c.f5112a), true) : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.d.u0
    public void a(@NonNull String str, @NonNull Set<String> set, @NonNull a.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, set, jVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_key", str);
                JSONArray jSONArray = new JSONArray();
                if (set != null && set.size() > 0) {
                    for (String str2 : set) {
                        jSONArray.put(str2);
                    }
                }
                jSONObject.put("template_ids", jSONArray);
            } catch (JSONException e2) {
                if (f7817a) {
                    e2.printStackTrace();
                }
            }
            c.a.o0.m.d.a aVar = new c.a.o0.m.d.a(m(), new b(new a(this, jVar)));
            aVar.a(c.a.o0.a.n1.f.f7552a, jSONObject.toString());
            if (c.a.o0.m.e.a.g().c()) {
                aVar.f11817f = true;
            }
            aVar.f11818g = true;
            c.a.o0.m.e.a.g().e(aVar);
        }
    }

    @Override // c.a.o0.a.p.d.u0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            Uri.Builder buildUpon = Uri.parse(j()).buildUpon();
            buildUpon.appendQueryParameter("timestamp", String.valueOf(seconds)).appendQueryParameter("rasign", c.a.o0.a.d0.b.b().c(seconds)).appendQueryParameter("delta", "smartapp_formid");
            return buildUpon.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.d.u0
    public void c(@NonNull String str, c.a.o0.a.s0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            String h2 = h(f7818b);
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) c.a.o0.m.e.a.g().postFormRequest().url(h2)).cookieManager(c.a.o0.a.c1.a.p().a())).addParam("appkey", str).build().executeAsyncOnUIBack(new b(bVar));
        }
    }

    @Override // c.a.o0.a.p.d.u0
    public void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, c.a.o0.a.s0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, list, str2, Boolean.valueOf(z), bVar}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_key", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sub_id", str2);
                if (z) {
                    jSONObject2.put("template_id", list.get(0));
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject2.put("template_ids", jSONArray);
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject2);
                jSONObject.put("detail", jSONArray2);
            } catch (JSONException e2) {
                if (f7817a) {
                    e2.printStackTrace();
                }
            }
            c.a.o0.m.d.a aVar = new c.a.o0.m.d.a(h(f7820d), new b(bVar));
            aVar.a(c.a.o0.a.n1.f.f7552a, jSONObject.toString());
            aVar.f11817f = true;
            aVar.f11818g = true;
            c.a.o0.m.e.a.g().e(aVar);
        }
    }

    @Override // c.a.o0.a.p.d.u0
    public void e(String str, c.a.o0.a.q1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, aVar) == null) {
            o(h(f7819c), str, aVar);
        }
    }

    public final String h(int i2) {
        InterceptResult invokeI;
        long seconds;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            String str2 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            String str3 = "delta=smartapp_formid";
            if (i2 == f7818b) {
                sb = new StringBuilder(k());
                str = "rasign=" + c.a.o0.a.d0.b.b().c(seconds);
            } else if (i2 == f7820d) {
                sb = new StringBuilder(l());
                str = "rasign=" + c.a.o0.a.d0.b.b().c(seconds);
            } else {
                sb = new StringBuilder(n());
                str = "rasign=" + c.a.o0.a.d0.b.b().d(seconds);
                str3 = "delta=payid";
            }
            sb.append("&");
            sb.append(str2);
            sb.append("&");
            sb.append(str);
            sb.append("&");
            sb.append(str3);
            return c.a.o0.a.d0.c.v(sb.toString());
        }
        return (String) invokeI.objValue;
    }

    public final List<c.a.o0.a.s0.d> i(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("template_id");
                    String optString2 = optJSONObject.optString("template_title");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        arrayList.add(new c.a.o0.a.s0.d(optString, optString2));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void o(String str, String str2, c.a.o0.a.x1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, aVar) == null) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) c.a.o0.m.e.a.g().postFormRequest().url(str)).cookieManager(c.a.o0.a.c1.a.p().a())).userAgent(c.a.o0.m.b.b().a())).addParam("appkey", str2).build().executeAsyncOnUIBack(new b(aVar));
        }
    }
}
