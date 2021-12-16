package c.a.q0.a.f2.f.f0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.g1.f;
import c.a.q0.a.h0.g.e;
import c.a.q0.a.h0.g.g;
import c.a.q0.a.k;
import c.a.q0.a.n2.i;
import c.a.q0.a.o2.g.h;
import c.a.q0.a.z2.o0;
import c.a.q0.a.z2.q0;
import c.a.q0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f5317d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<JSONObject> f5318b;

    /* renamed from: c  reason: collision with root package name */
    public String f5319c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5321f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f5322g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.m1.b f5323h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f5324i;

        public a(d dVar, g gVar, String str, e eVar, c.a.q0.a.m1.b bVar, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar, str, eVar, bVar, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5320e = gVar;
            this.f5321f = str;
            this.f5322g = eVar;
            this.f5323h = bVar;
            this.f5324i = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b i2 = this.f5320e.i(this.f5321f);
                i2.n(g.f5805g, g.f5807i);
                i2.j(this.f5322g);
                i2.b();
                i.j(this.f5323h, this.f5324i.errCode);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1416655158, "Lc/a/q0/a/f2/f/f0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1416655158, "Lc/a/q0/a/f2/f/f0/d$b;");
                    return;
                }
            }
            a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(843217672, "Lc/a/q0/a/f2/f/f0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(843217672, "Lc/a/q0/a/f2/f/f0/d;");
                return;
            }
        }
        f5317d = k.a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (d) invokeV.objValue;
    }

    public boolean a(c.a.q0.a.m1.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar != null && c.a.q0.a.v.a.e(c.a.q0.a.d2.d.J().r().X())) {
                if (!this.a) {
                    j();
                }
                List<JSONObject> list = this.f5318b;
                if (list == null || list.isEmpty()) {
                    return false;
                }
                boolean z = f5317d;
                return g(bVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return str + "_forbidden_ban_page";
        }
        return (String) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5319c : (String) invokeV.objValue;
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return str + "_forbidden_tips";
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(String[] strArr, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, strArr, list)) == null) {
            if (list == null || list.isEmpty() || strArr == null || strArr.length == 0) {
                return false;
            }
            List asList = Arrays.asList(strArr);
            if (asList.isEmpty()) {
                return false;
            }
            for (String str : list) {
                if (!asList.contains(str)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(c.a.q0.a.m1.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            String str = bVar.f7108e;
            String str2 = bVar.f7111h;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                List<JSONObject> list = this.f5318b;
                if (list == null) {
                    return false;
                }
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null && !jSONObject.isNull("type") && !jSONObject.isNull("path")) {
                        int optInt = jSONObject.optInt("type");
                        String optString = jSONObject.optString("path");
                        if (TextUtils.equals(str, optString) || TextUtils.equals(str2, optString)) {
                            if (optInt == 1) {
                                return true;
                            }
                            if (optInt != 2) {
                                if (optInt == 3 && !jSONObject.isNull("query")) {
                                    String optString2 = jSONObject.optString("query");
                                    if (TextUtils.isEmpty(bVar.f7109f)) {
                                        return false;
                                    }
                                    List<String> c2 = o0.c(optString2);
                                    String[] split = bVar.f7109f.split("&");
                                    if (split == null || split.length == 0 || c2 == null || c2.isEmpty()) {
                                        return false;
                                    }
                                    if (f(split, c2)) {
                                        return true;
                                    }
                                }
                            } else if (jSONObject.isNull("query")) {
                                continue;
                            } else {
                                String optString3 = jSONObject.optString("query");
                                if (TextUtils.isEmpty(bVar.f7109f)) {
                                    return false;
                                }
                                List<String> c3 = o0.c(optString3);
                                String[] split2 = bVar.f7109f.split("&");
                                if (split2 == null || split2.length == 0 || c3 == null || c3.isEmpty() || split2.length != c3.size()) {
                                    return false;
                                }
                                if (f(split2, c3)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean h(c.a.q0.a.m1.b bVar) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            String str = bVar.f7111h;
            if (TextUtils.isEmpty(str) || (list = this.f5318b) == null) {
                return false;
            }
            for (JSONObject jSONObject : list) {
                if (jSONObject != null && TextUtils.equals(str, jSONObject.optString("path"))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(String str, c.a.q0.a.m1.b bVar) {
        g V;
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, bVar) == null) || bVar == null || (V = f.U().V()) == null || (V.m() instanceof e)) {
            return;
        }
        if (h(bVar)) {
            b2 = c.a.q0.a.m1.b.c(bVar);
        } else {
            b2 = c.a.q0.a.m1.b.b(bVar);
        }
        if (f5317d) {
            String str2 = "jump from " + str + " ; path = " + b2;
        }
        c.a.q0.a.d2.e r = c.a.q0.a.d2.d.J().r();
        b.a V2 = r.V();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = r.getAppId();
        forbiddenInfo.appKey = r.N();
        forbiddenInfo.appTitle = V2.K();
        forbiddenInfo.forbiddenReason = d();
        forbiddenInfo.forbiddenInformation = this.f5319c;
        forbiddenInfo.launchSource = V2.T();
        forbiddenInfo.launchPath = b2;
        forbiddenInfo.enableSlidingFlag = 0;
        l(forbiddenInfo);
        q0.e0(new a(this, V, str, e.g3(String.valueOf(forbiddenInfo.errCode.a()), SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, "", -1, forbiddenInfo, 0, 0), bVar, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.a.o2.g.b a2 = h.a();
            String N = c.a.q0.a.d2.d.J().r().N();
            if (a2 == null) {
                return;
            }
            String string = a2.getString(c(N), null);
            if (f5317d) {
                String str = "readData, appKey = " + N + " ; tips = " + this.f5319c + " ; page = " + string;
            }
            if (TextUtils.isEmpty(string)) {
                this.f5318b = null;
            } else {
                JSONArray e2 = w.e(string);
                if (e2 == null) {
                    return;
                }
                int length = e2.length();
                this.f5318b = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = e2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.f5318b.add(optJSONObject);
                    }
                }
                this.f5319c = a2.getString(e(N), null);
            }
            this.a = true;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = f5317d;
            this.a = false;
            this.f5319c = null;
            List<JSONObject> list = this.f5318b;
            if (list != null) {
                list.clear();
                this.f5318b = null;
            }
        }
    }

    public final void l(ForbiddenInfo forbiddenInfo) {
        c.a.q0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, forbiddenInfo) == null) || (a0 = c.a.q0.a.d2.e.a0()) == null) {
            return;
        }
        a0.r();
        SwanAppActivity x = a0.x();
        if (x == null) {
            return;
        }
        String i2 = c.a.q0.a.q2.b.i(f.U().M(), a0.X().G());
        c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
        aVar.k(5L);
        aVar.i(48L);
        aVar.d("page forbidden");
        forbiddenInfo.errCode = aVar;
        forbiddenInfo.forbiddenDetail = x.getString(c.a.q0.a.h.aiapps_open_failed_detail_format, q0.D(), i2, String.valueOf(aVar.a()));
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_key", str);
            c.a.q0.a.y1.c.a e2 = c.a.q0.a.y1.c.a.e();
            c.a.q0.a.y1.c.c cVar = new c.a.q0.a.y1.c.c(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, bundle);
            cVar.d();
            e2.h(cVar);
        }
    }

    public void n(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, jSONArray, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String c2 = c(str2);
        String e2 = e(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            String jSONArray2 = jSONArray.toString();
            if (optJSONObject != null) {
                h.a().edit().putString(c2, jSONArray2).putString(e2, str).apply();
                if (f5317d) {
                    String str3 = "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str;
                }
                m(str2);
                return;
            }
            return;
        }
        h.a().edit().remove(c2).remove(e2).apply();
        if (f5317d) {
            String str4 = "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str;
        }
    }

    public d() {
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
        this.a = false;
    }
}
