package c.a.q0.a.w1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.k;
import c.a.q0.a.u.f.b.g.a;
import c.a.q0.a.z2.l0;
import c.a.q0.q.i.i;
import c.a.q0.q.j.m.a;
import c.a.q0.q.j.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.a.w1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0549a implements a.InterfaceC0533a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.w1.g.c a;

        public C0549a(c.a.q0.a.w1.g.c cVar) {
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

        @Override // c.a.q0.a.u.f.b.g.a.InterfaceC0533a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.r(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.w1.g.c f8984e;

        public b(c.a.q0.a.w1.g.c cVar) {
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
            this.f8984e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.c(this.f8984e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.q0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

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
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c.a.q0.a.w1.e.a.b("download plugin result = " + bool);
                c.a.q0.a.w1.f.a.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1672114691, "Lc/a/q0/a/w1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1672114691, "Lc/a/q0/a/w1/c/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void c(c.a.q0.a.w1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            if (cVar != null && cVar.a()) {
                String str = cVar.f9022e;
                String str2 = cVar.f9023f;
                long j2 = cVar.f9024g;
                c.a.q0.q.b.g(new e(str, str2, j2, cVar.f9025h), new c.a.q0.a.w1.b.a(str, str2, j2, new c(str)));
                return;
            }
            c.a.q0.a.w1.e.a.b("plugin is invalid");
        }
    }

    public static File d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.startsWith("__dep__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i2 = c.a.q0.a.w1.h.b.i("dependenciesPath", null);
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                try {
                    String optString = new JSONObject(i2).optString(str2);
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    return new File(optString, substring + ".json");
                } catch (JSONException e2) {
                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static List<c.a.q0.q.i.a> e(String str, long j2) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<c.a.q0.a.w1.g.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j2)) == null) {
            SwanAppConfigData b2 = c.a.q0.a.f1.c.a.b(d.v(str, String.valueOf(j2), false, null, null));
            if (b2 == null || (dVar = b2.f40556k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.q0.a.w1.g.a aVar : b2.f40556k.a) {
                c.a.q0.q.i.a aVar2 = new c.a.q0.q.i.a();
                aVar2.a = aVar.f9022e;
                aVar2.f11012b = aVar.f9021k;
                aVar2.f11013c = aVar.f9024g;
                aVar2.f11015e = aVar.m;
                aVar2.f11014d = aVar.l;
                arrayList.add(aVar2);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static String f(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.startsWith("__dep__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i2 = c.a.q0.a.w1.h.b.i("dependenciesConfig", null);
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i2).optJSONObject(str2);
                } catch (JSONException e2) {
                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                }
                if (optJSONObject == null) {
                    return null;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (l(substring, optJSONArray)) {
                    return str;
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("module");
                if (optJSONObject3 == null || (optJSONObject2 = optJSONObject3.optJSONObject("paths")) == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject2.keys();
                String str3 = null;
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        if (substring.startsWith(next)) {
                            if (str3 != null && next.length() <= str3.length()) {
                            }
                            str3 = next;
                        }
                    }
                }
                if (str3 == null) {
                    return null;
                }
                String replaceFirst = substring.replaceFirst(str3, optJSONObject2.optString(str3));
                if (l(replaceFirst, optJSONArray)) {
                    return str.replace(substring, replaceFirst);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static File g(@Nullable i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            File t = d.t(iVar.f11026g, String.valueOf(iVar.f11028i));
            return (t == null || !t.exists()) ? d.t(iVar.f11026g, String.valueOf(l0.c(iVar.f11029j))) : t;
        }
        return (File) invokeL.objValue;
    }

    public static String h(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str.startsWith("__dynamicLib__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i2 = c.a.q0.a.w1.h.b.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i2).optJSONObject(str2);
                } catch (JSONException e2) {
                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                }
                if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME)) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        if (TextUtils.equals(substring, optJSONArray.optString(i3))) {
                            return str;
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static Set<a.C0737a> i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return null;
            }
            return j(pMSAppInfo.appId, pMSAppInfo.versionCode);
        }
        return (Set) invokeL.objValue;
    }

    public static Set<a.C0737a> j(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j2)) == null) {
            List<c.a.q0.q.i.a> l = c.a.q0.q.c.b().l(str, j2);
            if (l == null || l.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (c.a.q0.q.i.a aVar : l) {
                if (!aVar.f11012b && c.a.q0.q.p.e.b(aVar.a, aVar.f11014d, aVar.f11015e, arrayList) == null) {
                    a.C0737a c0737a = new a.C0737a(aVar.a);
                    c0737a.f(aVar.f11014d, aVar.f11015e);
                    hashSet.add(c0737a);
                }
            }
            if (!arrayList.isEmpty()) {
                c.a.q0.q.g.a.i().g(arrayList);
            }
            return hashSet;
        }
        return (Set) invokeLJ.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return (TextUtils.isEmpty(h(str)) && TextUtils.isEmpty(f(str))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean l(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.equals(str, jSONArray.optString(i2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(SwanAppConfigData swanAppConfigData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, swanAppConfigData, z) == null) {
            if (swanAppConfigData == null) {
                if (a) {
                    c.a.q0.a.w1.e.a.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<c.a.q0.a.w1.g.c> i2 = swanAppConfigData.i(3);
            if (i2 != null && !i2.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (c.a.q0.a.p0.f.c.m()) {
                    Iterator<c.a.q0.a.w1.g.c> it = i2.iterator();
                    while (it.hasNext()) {
                        c.a.q0.a.w1.g.c next = it.next();
                        Pair<Boolean, File> i3 = c.a.q0.a.p0.f.c.i(next.f9022e);
                        if (((Boolean) i3.first).booleanValue()) {
                            c.a.q0.a.e0.d.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i3.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i3.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i2, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                c.a.q0.a.w1.h.b.c("dynamicLibPath", jSONObject3);
                c.a.q0.a.w1.h.b.c("dynamicLibConfig", jSONObject4);
                return;
            }
            c.a.q0.a.w1.h.b.c("dynamicLibPath", null);
            c.a.q0.a.w1.h.b.c("dynamicLibConfig", null);
            if (a) {
                c.a.q0.a.w1.e.a.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<c.a.q0.a.w1.g.c> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        c.a.q0.a.w1.g.c cVar;
        File file;
        boolean z2;
        boolean z3;
        long j2;
        long j3;
        long c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) || list == null || list.size() == 0) {
            return;
        }
        List<i> w = c.a.q0.q.g.a.i().w(c.a.q0.a.w1.h.b.d(list));
        for (c.a.q0.a.w1.g.c cVar2 : list) {
            File file2 = null;
            try {
                cVar = (c.a.q0.a.w1.g.c) cVar2.clone();
            } catch (CloneNotSupportedException e2) {
                if (a) {
                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                }
                cVar = cVar2;
            }
            long j4 = 0;
            if (w != null) {
                j2 = 0;
                boolean z4 = false;
                z3 = true;
                boolean z5 = false;
                for (i iVar : w) {
                    if (cVar2.f9022e.equals(iVar.f11026g)) {
                        c.a.q0.a.w1.e.a.b("pluginName = " + cVar2.f9022e + " latestPlugin versionCode = " + iVar.f11028i + " cur model versionCode = " + cVar2.f9024g);
                        long j5 = cVar2.f9024g;
                        if (j5 >= j4) {
                            c2 = iVar.f11028i;
                        } else {
                            c2 = l0.c(iVar.f11029j);
                            j5 = l0.c(cVar2.f9023f);
                        }
                        if (c2 > j5) {
                            file2 = g(iVar);
                            z5 = true;
                        }
                        if (z5) {
                            cVar.f9023f = iVar.f11029j;
                            cVar.f9024g = iVar.f11028i;
                        }
                        if (!iVar.c()) {
                            c.a.q0.a.w1.e.a.b("plugin is new, not yet expired");
                            z3 = false;
                        }
                        j2 = Math.max(c2, j5);
                        j4 = 0;
                        z4 = true;
                    }
                }
                file = file2;
                z2 = z4;
            } else {
                file = null;
                z2 = false;
                z3 = true;
                j2 = 0;
            }
            if (z2) {
                j3 = j2;
            } else {
                long j6 = cVar2.f9024g;
                if (j6 < 0) {
                    j6 = l0.c(cVar2.f9023f);
                }
                j3 = j6;
            }
            o(jSONObject, jSONObject2, file, cVar2, j3);
            if (z3 && z) {
                s(cVar);
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, c.a.q0.a.w1.g.c cVar, long j2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, cVar, Long.valueOf(j2)}) == null) || jSONObject == null || jSONObject2 == null || cVar == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (a) {
                c.a.q0.a.w1.e.a.b("apply path in workspace, name = " + cVar.f9022e);
            }
        } else {
            str = cVar.f9026i;
            if (a) {
                c.a.q0.a.w1.e.a.b("apply path inner swan app, name = " + cVar.f9022e);
            }
        }
        try {
            jSONObject.put(cVar.f9022e, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(cVar.f9027j)) {
                return;
            }
            File file2 = new File(str, cVar.f9027j);
            if (file2.exists()) {
                String E = c.a.q0.w.d.E(file2);
                if (a) {
                    c.a.q0.a.w1.e.a.b("pages info = " + E);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, new JSONObject(E));
                jSONObject3.put(PushManager.APP_VERSION_CODE, j2);
                jSONObject2.put(cVar.f9022e, jSONObject3);
            }
        } catch (JSONException e2) {
            if (a) {
                c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
            }
        }
    }

    public static i p(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        String[] strArr;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, Long.valueOf(j2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (j2 >= 0) {
                strArr = new String[]{str, String.valueOf(j2)};
                str3 = "bundle_id = ?  and version_code = ? ";
            } else if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str};
                str3 = "bundle_id = ? ";
            } else {
                String[] strArr2 = {str, str2};
                str3 = "bundle_id = ?  and version_name = ? ";
                strArr = strArr2;
            }
            List<i> r = c.a.q0.q.g.a.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (i) invokeCommon.objValue;
    }

    public static List<i> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a.q0.q.g.a.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(c.a.q0.a.w1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, cVar) == null) {
            ExecutorUtilsExt.postOnElastic(new b(cVar), "requestDynamicLib", 2);
        }
    }

    public static void s(c.a.q0.a.w1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cVar) == null) {
            c.a.q0.a.u.f.a.d().c(new c.a.q0.a.u.f.b.g.a(new C0549a(cVar)));
        }
    }
}
