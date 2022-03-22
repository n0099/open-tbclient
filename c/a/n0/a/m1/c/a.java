package c.a.n0.a.m1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k.f.b.g.a;
import c.a.n0.a.p2.l0;
import c.a.n0.a.q0.d;
import c.a.n0.q.h.i;
import c.a.n0.q.i.m.a;
import c.a.n0.q.i.m.e;
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

    /* renamed from: c.a.n0.a.m1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0373a implements a.InterfaceC0357a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.m1.g.c a;

        public C0373a(c.a.n0.a.m1.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.n0.a.k.f.b.g.a.InterfaceC0357a
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
        public final /* synthetic */ c.a.n0.a.m1.g.c a;

        public b(c.a.n0.a.m1.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.c(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.a.n0.a.x.j.b<Boolean> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.x.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c.a.n0.a.m1.e.a.b("download plugin result = " + bool);
                c.a.n0.a.m1.f.a.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999764316, "Lc/a/n0/a/m1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999764316, "Lc/a/n0/a/m1/c/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void c(c.a.n0.a.m1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            if (cVar != null && cVar.a()) {
                String str = cVar.a;
                String str2 = cVar.f5475b;
                long j = cVar.f5476c;
                c.a.n0.q.b.g(new e(str, str2, j, cVar.f5477d), new c.a.n0.a.m1.b.a(str, str2, j, new c(str)));
                return;
            }
            c.a.n0.a.m1.e.a.b("plugin is invalid");
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
                String i = c.a.n0.a.m1.h.b.i("dependenciesPath", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    String optString = new JSONObject(i).optString(str2);
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    return new File(optString, substring + ".json");
                } catch (JSONException e2) {
                    c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static List<c.a.n0.q.h.a> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<c.a.n0.a.m1.g.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = c.a.n0.a.v0.c.a.b(d.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.n0.a.m1.g.a aVar : b2.k.a) {
                c.a.n0.q.h.a aVar2 = new c.a.n0.q.h.a();
                aVar2.a = aVar.a;
                aVar2.f9131b = aVar.f5473g;
                aVar2.f9132c = aVar.f5476c;
                aVar2.f9134e = aVar.i;
                aVar2.f9133d = aVar.f5474h;
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
                String i = c.a.n0.a.m1.h.b.i("dependenciesConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e2) {
                    c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
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
            File t = d.t(iVar.f9145g, String.valueOf(iVar.i));
            return (t == null || !t.exists()) ? d.t(iVar.f9145g, String.valueOf(l0.c(iVar.j))) : t;
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
                String i = c.a.n0.a.m1.h.b.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e2) {
                    c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
                }
                if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME)) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (TextUtils.equals(substring, optJSONArray.optString(i2))) {
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

    public static Set<a.C0756a> i(PMSAppInfo pMSAppInfo) {
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

    public static Set<a.C0756a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<c.a.n0.q.h.a> l = c.a.n0.q.c.b().l(str, j);
            if (l == null || l.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (c.a.n0.q.h.a aVar : l) {
                if (!aVar.f9131b && c.a.n0.q.o.e.b(aVar.a, aVar.f9133d, aVar.f9134e, arrayList) == null) {
                    a.C0756a c0756a = new a.C0756a(aVar.a);
                    c0756a.f(aVar.f9133d, aVar.f9134e);
                    hashSet.add(c0756a);
                }
            }
            if (!arrayList.isEmpty()) {
                c.a.n0.q.f.a.i().g(arrayList);
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
                for (int i = 0; i < length; i++) {
                    if (TextUtils.equals(str, jSONArray.optString(i))) {
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
                    c.a.n0.a.m1.e.a.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<c.a.n0.a.m1.g.c> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (c.a.n0.a.f0.f.c.m()) {
                    Iterator<c.a.n0.a.m1.g.c> it = i.iterator();
                    while (it.hasNext()) {
                        c.a.n0.a.m1.g.c next = it.next();
                        Pair<Boolean, File> i2 = c.a.n0.a.f0.f.c.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            c.a.n0.a.u.d.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                c.a.n0.a.m1.h.b.c("dynamicLibPath", jSONObject3);
                c.a.n0.a.m1.h.b.c("dynamicLibConfig", jSONObject4);
                return;
            }
            c.a.n0.a.m1.h.b.c("dynamicLibPath", null);
            c.a.n0.a.m1.h.b.c("dynamicLibConfig", null);
            if (a) {
                c.a.n0.a.m1.e.a.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<c.a.n0.a.m1.g.c> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        c.a.n0.a.m1.g.c cVar;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) || list == null || list.size() == 0) {
            return;
        }
        List<i> w = c.a.n0.q.f.a.i().w(c.a.n0.a.m1.h.b.d(list));
        for (c.a.n0.a.m1.g.c cVar2 : list) {
            File file2 = null;
            try {
                cVar = (c.a.n0.a.m1.g.c) cVar2.clone();
            } catch (CloneNotSupportedException e2) {
                if (a) {
                    c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
                }
                cVar = cVar2;
            }
            long j3 = 0;
            if (w != null) {
                j = 0;
                boolean z4 = false;
                z3 = true;
                boolean z5 = false;
                for (i iVar : w) {
                    if (cVar2.a.equals(iVar.f9145g)) {
                        c.a.n0.a.m1.e.a.b("pluginName = " + cVar2.a + " latestPlugin versionCode = " + iVar.i + " cur model versionCode = " + cVar2.f5476c);
                        long j4 = cVar2.f5476c;
                        if (j4 >= j3) {
                            c2 = iVar.i;
                        } else {
                            c2 = l0.c(iVar.j);
                            j4 = l0.c(cVar2.f5475b);
                        }
                        if (c2 > j4) {
                            file2 = g(iVar);
                            z5 = true;
                        }
                        if (z5) {
                            cVar.f5475b = iVar.j;
                            cVar.f5476c = iVar.i;
                        }
                        if (!iVar.c()) {
                            c.a.n0.a.m1.e.a.b("plugin is new, not yet expired");
                            z3 = false;
                        }
                        j = Math.max(c2, j4);
                        j3 = 0;
                        z4 = true;
                    }
                }
                file = file2;
                z2 = z4;
            } else {
                file = null;
                z2 = false;
                z3 = true;
                j = 0;
            }
            if (z2) {
                j2 = j;
            } else {
                long j5 = cVar2.f5476c;
                if (j5 < 0) {
                    j5 = l0.c(cVar2.f5475b);
                }
                j2 = j5;
            }
            o(jSONObject, jSONObject2, file, cVar2, j2);
            if (z3 && z) {
                s(cVar);
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, c.a.n0.a.m1.g.c cVar, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, cVar, Long.valueOf(j)}) == null) || jSONObject == null || jSONObject2 == null || cVar == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (a) {
                c.a.n0.a.m1.e.a.b("apply path in workspace, name = " + cVar.a);
            }
        } else {
            str = cVar.f5478e;
            if (a) {
                c.a.n0.a.m1.e.a.b("apply path inner swan app, name = " + cVar.a);
            }
        }
        try {
            jSONObject.put(cVar.a, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(cVar.f5479f)) {
                return;
            }
            File file2 = new File(str, cVar.f5479f);
            if (file2.exists()) {
                String E = c.a.n0.w.d.E(file2);
                if (a) {
                    c.a.n0.a.m1.e.a.b("pages info = " + E);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, new JSONObject(E));
                jSONObject3.put(PushManager.APP_VERSION_CODE, j);
                jSONObject2.put(cVar.a, jSONObject3);
            }
        } catch (JSONException e2) {
            if (a) {
                c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
            }
        }
    }

    public static i p(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String[] strArr;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
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
            List<i> r = c.a.n0.q.f.a.i().r(str3, strArr);
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
            return c.a.n0.q.f.a.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(c.a.n0.a.m1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, cVar) == null) {
            ExecutorUtilsExt.postOnElastic(new b(cVar), "requestDynamicLib", 2);
        }
    }

    public static void s(c.a.n0.a.m1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cVar) == null) {
            c.a.n0.a.k.f.a.d().c(new c.a.n0.a.k.f.b.g.a(new C0373a(cVar)));
        }
    }
}
