package b.a.p0.a.b0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.n1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.apps.commonsync.CommonSyncServerData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4013a;

    /* renamed from: b  reason: collision with root package name */
    public static int f4014b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0115a extends ResponseCallback<CommonSyncServerData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.b0.c.a f4015a;

        public C0115a(b.a.p0.a.b0.c.a aVar) {
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
            this.f4015a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(CommonSyncServerData commonSyncServerData, int i2) {
            b.a.p0.a.b0.c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, commonSyncServerData, i2) == null) || (aVar = this.f4015a) == null) {
                return;
            }
            aVar.a(commonSyncServerData);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public CommonSyncServerData parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == a.f4014b && optJSONObject != null) {
                        return (CommonSyncServerData) new Gson().fromJson(optJSONObject.toString(), (Class<Object>) CommonSyncServerData.class);
                    }
                }
                return null;
            }
            return (CommonSyncServerData) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            b.a.p0.a.b0.c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (aVar = this.f4015a) == null) {
                return;
            }
            aVar.onFail();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1319024485, "Lb/a/p0/a/b0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1319024485, "Lb/a/p0/a/b0/a;");
                return;
            }
        }
        f4013a = k.f6397a;
        f4014b = 0;
    }

    public static void b(b.a.p0.a.b0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            if (!SwanAppNetworkUtils.h()) {
                if (aVar != null) {
                    aVar.onFail();
                    return;
                }
                return;
            }
            b.a.p0.m.e.a.g().getRequest().cookieManager(b.a.p0.a.c1.a.p().a()).url(b.a.p0.a.c1.a.l().processUrl(b.a())).build().executeAsync(new C0115a(aVar));
        }
    }

    public static RequestBody c(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e2) {
                        if (f4013a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return RequestBody.create(f.f6891a, jSONObject.toString());
        }
        return (RequestBody) invokeL.objValue;
    }

    public static void d(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map) == null) && SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) b.a.p0.m.e.a.g().postRequest().cookieManager(b.a.p0.a.c1.a.p().a())).url(b.a.p0.a.c1.a.l().processUrl(b.b()))).requestBody(c(map)).build().executeAsync(null);
        }
    }

    public static void e(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map) == null) && SwanAppNetworkUtils.h()) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) b.a.p0.m.e.a.g().postRequest().cookieManager(b.a.p0.a.c1.a.p().a())).url(b.a.p0.a.c1.a.l().processUrl(b.c()))).requestBody(c(map)).build().executeAsync(null);
        }
    }
}
