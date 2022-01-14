package c.a.r0.a.a3;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import c.a.r0.a.h;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.BearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import java.util.LinkedHashMap;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5183d;
    public transient /* synthetic */ FieldHolder $fh;
    public BearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f5184b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppBearInfo f5185c;

    /* renamed from: c.a.r0.a.a3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0264a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BearLayout.d a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5186b;

        public C0264a(a aVar, BearLayout.d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f5186b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || this.a == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                if (optInt == 0) {
                    if (this.f5186b) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                this.a.a(true);
                            }
                            this.a.a(false);
                        }
                    } else {
                        this.a.a(true);
                    }
                } else if (800200 == optInt) {
                    String optString = jSONObject.optString("errmsg");
                    BearLayout.d dVar = this.a;
                    dVar.b("errNo:" + optInt + ",errMsg:" + optString);
                } else {
                    BearLayout.d dVar2 = this.a;
                    dVar2.b("errNo:" + optInt);
                }
            } catch (JSONException e2) {
                if (a.f5183d) {
                    e2.printStackTrace();
                    this.a.b(e2.getMessage());
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && a.f5183d) {
                exc.printStackTrace();
                this.a.b(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) ? (response == null || response.body() == null) ? "" : response.body().string() : (String) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(419604702, "Lc/a/r0/a/a3/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(419604702, "Lc/a/r0/a/a3/a;");
                return;
            }
        }
        f5183d = k.a;
    }

    public a(Activity activity, View view, @NonNull SwanAppBearInfo swanAppBearInfo, @IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, view, swanAppBearInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5184b = activity;
        this.f5185c = swanAppBearInfo;
        BearLayout bearLayout = (BearLayout) view.findViewById(i2);
        this.a = bearLayout;
        bearLayout.setVisibility(0);
        this.a.init(activity, swanAppBearInfo, this);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (SwanAppNetworkUtils.i(this.f5184b)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("type", VodClient.PATH_MEDIA);
                linkedHashMap.put("sfrom", "searchpaws");
                linkedHashMap.put("store", "uid_cuid");
                linkedHashMap.put("source", "dusite_na_subbar");
                linkedHashMap.put("third_id", this.f5185c.bearId);
                linkedHashMap.put("op_type", "add");
                String b2 = c.a.r0.a.b0.b.b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                c.a.r0.p.e.a.g().getRequest().url(b2).addUrlParams(linkedHashMap).cookieManager(c.a.r0.a.c1.a.q().a()).build().executeAsyncOnUIBack(new C0264a(this, this.a.getCallback(), false));
                return;
            }
            c.a.r0.a.c2.b.f.e.f(this.f5184b, h.aiapps_net_error).G();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && SwanAppNetworkUtils.i(this.f5184b)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("type", VodClient.PATH_MEDIA);
            linkedHashMap.put("sfrom", "searchpaws");
            linkedHashMap.put("store", "uid_cuid");
            linkedHashMap.put("source", "dusite_na_subbar");
            linkedHashMap.put("third_id", this.f5185c.bearId);
            String B = c.a.r0.a.c1.a.o().B();
            if (TextUtils.isEmpty(B)) {
                return;
            }
            c.a.r0.p.e.a.g().getRequest().url(B).connectionTimeout(3000).addUrlParams(linkedHashMap).cookieManager(c.a.r0.a.c1.a.q().a()).build().executeAsyncOnUIBack(new C0264a(this, this.a.getCallback(), true));
        }
    }
}
