package c.a.n0.a.b2.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.a.k2.g.h;
import c.a.n0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4353a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4355f;

        public a(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4354e = dVar;
            this.f4355f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "async read webDomains");
                c.o(this.f4354e, this.f4355f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4358g;

        public b(d dVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4356e = dVar;
            this.f4357f = str;
            this.f4358g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "async read serverDomains");
                c.p(this.f4356e, this.f4357f, this.f4358g);
            }
        }
    }

    /* renamed from: c.a.n0.a.b2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0111c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4360f;

        public RunnableC0111c(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4359e = dVar;
            this.f4360f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "async read webActions");
                c.o(this.f4359e, this.f4360f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4361a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f4362b;

        /* renamed from: c  reason: collision with root package name */
        public long f4363c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4362b = new CopyOnWriteArrayList();
        }

        @NonNull
        public static List<String> d(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f4361a = jSONObject.optString("token");
            this.f4362b.addAll(d(jSONObject.optJSONArray("data")));
        }

        public void b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.f4362b.addAll(d(optJSONObject.optJSONArray(str)));
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f4362b.clear();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "WebSafeData{token='" + this.f4361a + ExtendedMessageFormat.QUOTE + ", data=" + this.f4362b + ", lastModifiedTime=" + this.f4363c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144271952, "Lc/a/n0/a/b2/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-144271952, "Lc/a/n0/a/b2/a/c;");
                return;
            }
        }
        f4353a = k.f6803a;
    }

    @NonNull
    public static String c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            String path = AppRuntime.getAppContext().getFilesDir().getPath();
            if (TextUtils.isEmpty(str)) {
                return path + File.separator + str2 + File.separator + str3;
            }
            return path + File.separator + str2 + File.separator + str + "_" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("swanAPI/installApp4Ad");
            arrayList.add("swanAPI/openApp4Ad");
            arrayList.add("swanAPI/checkAppInstalled");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/cloud_config";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static c.a.n0.t.b f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return h.b(str + "_domain_config");
        }
        return (c.a.n0.t.b) invokeL.objValue;
    }

    @Nullable
    public static Set<String> g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? f(str).getStringSet("prelink", null) : (Set) invokeL.objValue;
    }

    public static void h(boolean z, String str, String str2, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, dVar}) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z2 = f4353a;
            } else if (dVar == null) {
                if (f4353a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
            } else {
                String i2 = i(str);
                if (z) {
                    ExecutorUtilsExt.postOnElastic(new b(dVar, i2, str2), "load-ServerDomains", 2);
                } else {
                    p(dVar, i2, str2);
                }
            }
        }
    }

    @NonNull
    public static String i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? c(str, "aiapps_folder/cloud_config", "server_domains.json") : (String) invokeL.objValue;
    }

    @NonNull
    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c("", "aiapps_folder/cloud_config", "global_web_actions.json") : (String) invokeV.objValue;
    }

    public static void k(boolean z, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, null, z, dVar) == null) {
            if (dVar == null) {
                if (f4353a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
                return;
            }
            String j2 = j();
            if (z) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0111c(dVar, j2), "load-WebActions", 2);
            } else {
                o(dVar, j2);
            }
        }
    }

    public static void l(boolean z, String str, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z2 = f4353a;
            } else if (dVar == null) {
                if (f4353a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
            } else {
                String m = m(str);
                if (z) {
                    ExecutorUtilsExt.postOnElastic(new a(dVar, m), "load-WebDomains", 2);
                } else {
                    o(dVar, m);
                }
            }
        }
    }

    @NonNull
    public static String m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? c(str, "aiapps_folder/cloud_config", "web_domains.json") : (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? new File(m(str)).exists() : invokeL.booleanValue;
    }

    public static void o(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, dVar, str) == null) {
            if (dVar == null) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "webSafeData == null");
                return;
            }
            c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
            try {
                dVar.a(new JSONObject(q(str)));
                v(dVar, str);
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
            } catch (Exception e2) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
        }
    }

    public static void p(d dVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, dVar, str, str2) == null) {
            if (dVar == null) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "webSafeData == null");
                return;
            }
            c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
            try {
                dVar.b(new JSONObject(q(str)), str2);
                v(dVar, str);
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
            } catch (Exception e2) {
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
        }
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "read data from: " + str);
            return c.a.n0.a.b1.a.a(str);
        }
        return (String) invokeL.objValue;
    }

    public static void r(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            JSONArray optJSONArray = w.d(str2).optJSONArray("prelink");
            if (optJSONArray != null) {
                ArraySet arraySet = new ArraySet();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arraySet.add(optString);
                    }
                }
                w(str, arraySet);
            }
            if (f4353a) {
                String str3 = "saveDomainConfig appId=" + str + ", domainConfig=" + str2;
            }
        }
    }

    public static boolean s(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, jSONObject)) == null) {
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("data", jSONObject);
                    String i2 = i(str);
                    boolean b2 = c.a.n0.a.b1.a.b(i2, jSONObject2.toString(), false);
                    c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "save serverDomains: result=" + b2 + " filePath=" + i2 + " appId= " + str + " data=" + jSONObject);
                    return b2;
                } catch (JSONException e2) {
                    if (f4353a) {
                        Log.getStackTraceString(e2);
                    }
                    return false;
                }
            }
            boolean z = f4353a;
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean t(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, jSONArray)) == null) {
            if (jSONArray == null) {
                boolean z = f4353a;
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("token", str);
                }
                jSONObject.put("data", jSONArray);
                String j2 = j();
                boolean b2 = c.a.n0.a.b1.a.b(j2, jSONObject.toString(), false);
                c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "save webActions: result=" + b2 + " filePath=" + j2 + " token=" + str + " data=" + jSONArray);
                return b2;
            } catch (JSONException e2) {
                if (f4353a) {
                    Log.getStackTraceString(e2);
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean u(String str, String str2, JSONArray jSONArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, str, str2, jSONArray)) == null) {
            if (!TextUtils.isEmpty(str) && jSONArray != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("token", str2);
                    }
                    jSONObject.put("data", jSONArray);
                    String m = m(str);
                    boolean b2 = c.a.n0.a.b1.a.b(m, jSONObject.toString(), false);
                    c.a.n0.a.e0.d.h("WebSafeWhiteListMgr", "save WebDomains: result=" + b2 + " filePath=" + m + " appId= " + str + " token=" + str2 + " data=" + jSONArray);
                    return b2;
                } catch (JSONException e2) {
                    if (f4353a) {
                        Log.getStackTraceString(e2);
                    }
                    return false;
                }
            }
            boolean z = f4353a;
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void v(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, dVar, str) == null) {
            File file = new File(str);
            if (file.exists()) {
                dVar.f4363c = file.lastModified();
            }
        }
    }

    public static void w(@NonNull String str, @Nullable Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, set) == null) {
            if (set != null) {
                ArrayList arrayList = new ArrayList(set.size());
                ArraySet arraySet = new ArraySet(set.size());
                for (String str2 : set) {
                    String e2 = c.a.n0.a.u.e.j.h.e(str2);
                    if (e2 != null && !arrayList.contains(e2)) {
                        arraySet.add(str2);
                        arrayList.add(e2);
                    }
                }
                set = arraySet;
            }
            f(str).putStringSet("prelink", set);
        }
    }
}
