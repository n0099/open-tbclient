package c.a.r0.a.n0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.h2.c.h;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0475a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0475a(a aVar) {
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
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && a.a) {
                String str = "onFail: " + exc;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                boolean unused = a.a;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                boolean unused = a.a;
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431521102, "Lc/a/r0/a/n0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431521102, "Lc/a/r0/a/n0/a;");
                return;
            }
        }
        a = k.a;
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

    @NonNull
    public final ResponseCallback<JSONObject> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0475a(this) : (ResponseCallback) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.r0.q.g.a.i().c(str);
        }
    }

    public void e(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = a;
        Set<String> d2 = e.d(list);
        HashSet<String> hashSet = new HashSet(list);
        if (d2 != null) {
            hashSet.removeAll(d2);
        }
        c.a.r0.a.o2.h.d.j().g("aiapp_setting_", hashSet, false);
        c.a.r0.a.o2.h.d.j().g("aiapp_", hashSet, false);
        for (String str : hashSet) {
            if (a) {
                String str2 = "clear storage files: " + str;
            }
            String v = c.a.r0.a.o2.b.v(str);
            if (!TextUtils.isEmpty(v)) {
                c.a.r0.w.d.M(v);
            }
            String x = c.a.r0.a.o2.b.x(str);
            if (!TextUtils.isEmpty(x)) {
                c.a.r0.w.d.M(x);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c.a.r0.q.g.a.i().h(str);
            c.a.r0.q.g.a.i().e(c.a.r0.q.i.g.class, str);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void g(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = a;
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ma_ids", list);
        JSONObject jSONObject = new JSONObject();
        try {
            h a2 = c.a.r0.a.c1.a.q().a();
            jSONObject.put("accredit", new JSONObject(arrayMap));
            String v = c.a.r0.a.c1.a.o().v();
            c.a.r0.p.a b2 = c.a.r0.p.b.b();
            if (b2 == null) {
                if (!a) {
                    c.a.r0.a.e0.d.c("AbsDefaultPurger", "get network obj failed on resetAccredit");
                } else {
                    throw new RuntimeException("SwanNetworkRuntime.getSwanNetwork return null , check inject");
                }
            }
            c.a.r0.p.e.a g2 = c.a.r0.p.e.a.g();
            if (!g2.c()) {
                b2 = null;
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) g2.postFormRequest().url(v)).addParam("data", jSONObject.toString()).userAgent(b2 != null ? b2.a() : "")).cookieManager(a2)).build().executeAsyncOnUIBack(c());
        } catch (JSONException e2) {
            e2.printStackTrace();
            boolean z2 = a;
        }
    }
}
