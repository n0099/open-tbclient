package c.a.o0.a.n0;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.e2.c.h;
import c.a.o0.a.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7431a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0308a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0308a(a aVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean unused = a.f7431a;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                boolean unused = a.f7431a;
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

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) && a.f7431a) {
                String str = "onFail: " + exc;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1021061617, "Lc/a/o0/a/n0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1021061617, "Lc/a/o0/a/n0/a;");
                return;
            }
        }
        f7431a = k.f7049a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0308a(this) : (ResponseCallback) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.o0.n.g.a.h().c(str);
        }
    }

    public void e(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = f7431a;
        Set<String> d2 = e.d(list);
        HashSet<String> hashSet = new HashSet(list);
        if (d2 != null) {
            hashSet.removeAll(d2);
        }
        c.a.o0.a.k2.h.d.j().g("aiapp_setting_", hashSet, false);
        c.a.o0.a.k2.h.d.j().g("aiapp_", hashSet, false);
        for (String str : hashSet) {
            if (f7431a) {
                String str2 = "clear storage files: " + str;
            }
            String v = c.a.o0.a.k2.b.v(str);
            if (!TextUtils.isEmpty(v)) {
                c.a.o0.t.d.L(v);
            }
            String x = c.a.o0.a.k2.b.x(str);
            if (!TextUtils.isEmpty(x)) {
                c.a.o0.t.d.L(x);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c.a.o0.n.g.a.h().g(str);
            c.a.o0.n.g.a.h().e(c.a.o0.n.h.f.class, str);
        }
    }

    public void g(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = f7431a;
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("ma_ids", list);
        JSONObject jSONObject = new JSONObject();
        try {
            h a2 = c.a.o0.a.c1.a.p().a();
            jSONObject.put("accredit", new JSONObject(arrayMap));
            String t = c.a.o0.a.c1.a.n().t();
            c.a.o0.m.a b2 = c.a.o0.m.b.b();
            if (b2 == null) {
                if (!f7431a) {
                    c.a.o0.a.e0.d.b("AbsDefaultPurger", "get network obj failed on resetAccredit");
                } else {
                    throw new RuntimeException("SwanNetworkRuntime.getSwanNetwork return null , check inject");
                }
            }
            c.a.o0.m.e.a g2 = c.a.o0.m.e.a.g();
            if (!g2.c()) {
                b2 = null;
            }
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) g2.postFormRequest().url(t)).addParam("data", jSONObject.toString()).userAgent(b2 != null ? b2.a() : "")).cookieManager(a2)).build().executeAsyncOnUIBack(c());
        } catch (JSONException e2) {
            e2.printStackTrace();
            boolean z2 = f7431a;
        }
    }
}
