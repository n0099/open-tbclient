package b.a.p0.a.t1.b;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.k;
import b.a.p0.a.u.f.b.g.a;
import b.a.p0.a.v2.l0;
import b.a.p0.n.h.h;
import b.a.p0.n.i.m.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7927a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0372a implements a.InterfaceC0418a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.f.a f7928a;

        public C0372a(b.a.p0.a.t1.f.a aVar) {
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
            this.f7928a = aVar;
        }

        @Override // b.a.p0.a.u.f.b.g.a.InterfaceC0418a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.k(this.f7928a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.f.a f7929e;

        public b(b.a.p0.a.t1.f.a aVar) {
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
            this.f7929e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.c(this.f7929e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements b.a.p0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7930a;

        public c(String str) {
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
            this.f7930a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                b.a.p0.a.t1.d.a.a("download plugin result = " + bool);
                b.a.p0.a.t1.e.a.b(this.f7930a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-608974685, "Lb/a/p0/a/t1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-608974685, "Lb/a/p0/a/t1/b/a;");
                return;
            }
        }
        f7927a = k.f6397a;
    }

    public static void c(b.a.p0.a.t1.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            if (aVar != null && aVar.a()) {
                String str = aVar.f7982h;
                String str2 = aVar.f7980f;
                long j = aVar.f7981g;
                b.a.p0.n.b.e(new d(str, str2, j, aVar.f7983i), new b.a.p0.a.t1.a.a(str, str2, j, new c(str)));
                return;
            }
            b.a.p0.a.t1.d.a.a("plugin is invalid");
        }
    }

    public static File d(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            File t = e.t(hVar.f11076g, String.valueOf(hVar.f11078i));
            return (t == null || !t.exists()) ? e.t(hVar.f11076g, String.valueOf(l0.c(hVar.j))) : t;
        }
        return (File) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("__dynamicLib__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return false;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return false;
                }
                String substring = str.substring(indexOf);
                String i2 = b.a.p0.a.t1.g.b.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i2)) {
                    return false;
                }
                try {
                    optJSONObject = new JSONObject(i2).optJSONObject(str2);
                } catch (JSONException e2) {
                    b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
                if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME)) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        if (TextUtils.equals(substring, optJSONArray.optString(i3))) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(SwanAppConfigData swanAppConfigData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, swanAppConfigData, z) == null) {
            if (swanAppConfigData == null) {
                if (f7927a) {
                    b.a.p0.a.t1.d.a.a("parse app.json is null");
                    return;
                }
                return;
            }
            List<b.a.p0.a.t1.f.a> h2 = swanAppConfigData.h(3);
            if (h2 != null && !h2.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (b.a.p0.a.p0.f.b.m()) {
                    Iterator<b.a.p0.a.t1.f.a> it = h2.iterator();
                    while (it.hasNext()) {
                        b.a.p0.a.t1.f.a next = it.next();
                        Pair<Boolean, File> i2 = b.a.p0.a.p0.f.b.i(next.f7982h);
                        if (((Boolean) i2.first).booleanValue()) {
                            b.a.p0.a.e0.d.h("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            h(jSONObject, jSONObject2, (File) i2.second, next);
                            it.remove();
                        }
                    }
                }
                g(h2, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                b.a.p0.a.t1.g.b.c("dynamicLibPath", jSONObject3);
                b.a.p0.a.t1.g.b.c("dynamicLibConfig", jSONObject4);
                return;
            }
            b.a.p0.a.t1.g.b.c("dynamicLibPath", null);
            b.a.p0.a.t1.g.b.c("dynamicLibConfig", null);
            if (f7927a) {
                b.a.p0.a.t1.d.a.a("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void g(@NonNull List<b.a.p0.a.t1.f.a> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        b.a.p0.a.t1.f.a aVar;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        long c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) || list == null || list.size() == 0) {
            return;
        }
        List<h> u = b.a.p0.n.g.a.h().u(b.a.p0.a.t1.g.b.d(list));
        for (b.a.p0.a.t1.f.a aVar2 : list) {
            File file = null;
            try {
                aVar = (b.a.p0.a.t1.f.a) aVar2.clone();
            } catch (CloneNotSupportedException e2) {
                if (f7927a) {
                    b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
                aVar = aVar2;
            }
            boolean z2 = true;
            if (u != null) {
                boolean z3 = true;
                boolean z4 = false;
                for (h hVar : u) {
                    if (aVar2.f7982h.equals(hVar.f11076g)) {
                        b.a.p0.a.t1.d.a.a("pluginName = " + aVar2.f7982h + " latestPlugin versionCode = " + hVar.f11078i + " cur model versionCode = " + aVar2.f7981g);
                        long j = aVar2.f7981g;
                        if (j >= 0) {
                            c2 = hVar.f11078i;
                        } else {
                            c2 = l0.c(hVar.j);
                            j = l0.c(aVar2.f7980f);
                        }
                        if (c2 > j) {
                            file = d(hVar);
                            z4 = true;
                        }
                        if (z4) {
                            aVar.f7980f = hVar.j;
                            aVar.f7981g = hVar.f11078i;
                        }
                        if (!hVar.c()) {
                            b.a.p0.a.t1.d.a.a("plugin is new, not yet expired");
                            z3 = false;
                        }
                    }
                }
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                z2 = z3;
            } else {
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
            }
            h(jSONObject3, jSONObject4, file, aVar2);
            if (z2 && z) {
                l(aVar);
            }
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2, File file, b.a.p0.a.t1.f.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65544, null, jSONObject, jSONObject2, file, aVar) == null) || jSONObject == null || jSONObject2 == null || aVar == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (f7927a) {
                b.a.p0.a.t1.d.a.a("apply path in workspace, name = " + aVar.f7982h);
            }
        } else {
            str = aVar.j;
            if (f7927a) {
                b.a.p0.a.t1.d.a.a("apply path inner swan app, name = " + aVar.f7982h);
            }
        }
        try {
            jSONObject.put(aVar.f7982h, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(aVar.k)) {
                return;
            }
            File file2 = new File(str, aVar.k);
            if (file2.exists()) {
                String D = b.a.p0.t.d.D(file2);
                if (f7927a) {
                    b.a.p0.a.t1.d.a.a("pages info = " + D);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, new JSONObject(D));
                jSONObject2.put(aVar.f7982h, jSONObject3);
            }
        } catch (JSONException e2) {
            if (f7927a) {
                b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
        }
    }

    public static h i(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String[] strArr;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (j >= 0) {
                strArr = new String[]{str, String.valueOf(j)};
                str3 = "bundle_id = ?  and version_code = ? ";
            } else if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str};
                str3 = "bundle_id = ? ";
            } else {
                String[] strArr2 = {str, str2};
                str3 = "bundle_id = ?  and version_name = ? ";
                strArr = strArr2;
            }
            List<h> q = b.a.p0.n.g.a.h().q(str3, strArr);
            if (q == null || q.size() <= 0) {
                return null;
            }
            return q.get(0);
        }
        return (h) invokeCommon.objValue;
    }

    public static List<h> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.a.p0.n.g.a.h().q("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void k(b.a.p0.a.t1.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            ExecutorUtilsExt.postOnElastic(new b(aVar), "requestDynamicLib", 2);
        }
    }

    public static void l(b.a.p0.a.t1.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            b.a.p0.a.u.f.a.d().c(new b.a.p0.a.u.f.b.g.a(new C0372a(aVar)));
        }
    }
}
