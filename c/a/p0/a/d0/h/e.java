package c.a.p0.a.d0.h;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c.a.p0.a.d0.l.b;
import c.a.p0.a.e2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4739b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4740c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f4741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f4742f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.q.j.i.a f4743g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f4744h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.C0248b f4745i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f4746j;

        public a(e eVar, Set set, boolean z, c.a.p0.q.j.i.a aVar, long j2, b.C0248b c0248b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, set, Boolean.valueOf(z), aVar, Long.valueOf(j2), c0248b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4746j = eVar;
            this.f4741e = set;
            this.f4742f = z;
            this.f4743g = aVar;
            this.f4744h = j2;
            this.f4745i = c0248b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashSet hashSet = new HashSet();
                Set set = this.f4741e;
                if (set != null) {
                    hashSet.addAll(set);
                }
                Set<String> f2 = c.a.p0.a.q0.d.f();
                hashSet.addAll(f2);
                c.a.p0.a.u.d.k("SwanAppDiskCleaner", "排除正在活动的小程：" + f2);
                Set<String> b2 = c.a.p0.a.d0.h.b.b();
                hashSet.addAll(b2);
                c.a.p0.a.u.d.k("SwanAppDiskCleaner", "排除正在下载中的小程：" + b2);
                Map<String, PMSAppInfo> v = c.a.p0.q.f.a.i().v();
                if (c.a.p0.a.d0.f.c().d().n(v)) {
                    boolean unused = e.a;
                    c.a.p0.a.q0.d.d(hashSet, v);
                    Map m = this.f4746j.m(86400000L, v);
                    if (m.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList(m.keySet());
                    e.k(hashSet, arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    e.l(arrayList, arrayList2, arrayList3);
                    ArrayList arrayList4 = new ArrayList();
                    int max = Math.max(10, this.f4742f ? e.f4739b : this.f4743g.f11064d);
                    e.r(arrayList3, max, arrayList4);
                    long j2 = this.f4743g.f11065e;
                    e.q(arrayList3, j2 * 3600000, arrayList4, m);
                    int max2 = Math.max(40, this.f4742f ? e.f4740c : this.f4743g.f11062b);
                    e.r(arrayList2, max2, arrayList4);
                    long j3 = this.f4743g.f11063c;
                    e.q(arrayList2, 3600000 * j3, arrayList4, m);
                    c.a.p0.a.u.d.k("SwanAppDiskCleaner", "clean_internal_hour=" + this.f4744h + " pre_hold_count=" + max + " pre_force_clean_hour=" + j2 + " used_hold_count=" + max2 + " used_force_clean_hour=" + j3 + "\n appIdList(" + arrayList.size() + ")=" + arrayList + "\n historyList(" + arrayList2.size() + ")=" + arrayList2 + "\n preloadList(" + arrayList3.size() + ")=" + arrayList3 + "\n cleanList(" + arrayList4.size() + ")=" + arrayList4 + StringUtils.LF);
                    c.a.p0.a.d0.f.c().d().g(arrayList4, false, false, this.f4745i);
                    c.a.p0.a.x.m.u.a.c();
                    return;
                }
                c.a.p0.a.u.d.k("SwanAppDiskCleaner", "PMS数据库没有文件，不需要清理");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Comparator<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pMSAppInfo, pMSAppInfo2)) == null) ? Long.compare(pMSAppInfo2.createTime, pMSAppInfo.createTime) : invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1831851145, "Lc/a/p0/a/d0/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1831851145, "Lc/a/p0/a/d0/h/e;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        c.a.p0.a.s0.a.g0().getSwitch("swan_disk_level_pkg_hold_used", 0);
        f4739b = 0;
        c.a.p0.a.s0.a.g0().getSwitch("swan_disk_level_pkg_hold_predownload", 0);
        f4740c = 0;
    }

    public e() {
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

    public static void k(Set<String> set, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, set, list) == null) {
            if (set != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (set.contains(it.next())) {
                        it.remove();
                    }
                }
            }
            list.remove("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        }
    }

    public static void l(@NonNull List<String> list, @NonNull List<String> list2, @NonNull List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, list, list2, list3) == null) {
            Set<String> i2 = c.a.p0.a.z.c.b.i(AppRuntime.getAppContext().getContentResolver());
            List<SwanFavorItemData> i3 = SwanFavorDataManager.h().i();
            HashSet hashSet = new HashSet();
            for (SwanFavorItemData swanFavorItemData : i3) {
                hashSet.add(swanFavorItemData.getAppKey());
            }
            for (String str : list) {
                if (!i2.contains(str) && !hashSet.contains(str)) {
                    list3.add(str);
                } else {
                    list2.add(str);
                }
            }
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? h.a().getBoolean("key_disk_force_clean", false) : invokeV.booleanValue;
    }

    public static boolean o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j2)) == null) ? System.currentTimeMillis() - h.a().getLong("clean_disk_check_time", 0L) < j2 : invokeJ.booleanValue;
    }

    public static void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            h.a().putBoolean("key_disk_force_clean", z);
        }
    }

    public static void q(List<String> list, long j2, List<String> list2, Map<String, Long> map) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{list, Long.valueOf(j2), list2, map}) == null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (l = map.get(next)) != null && j2 < System.currentTimeMillis() - l.longValue()) {
                    list2.add(next);
                    it.remove();
                }
            }
        }
    }

    public static void r(List<String> list, int i2, List<String> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65552, null, list, i2, list2) == null) || list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
            return;
        }
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                int i4 = i3 + 1;
                if (i3 >= i2) {
                    list2.add(next);
                    it.remove();
                }
                i3 = i4;
            }
        }
    }

    @AnyThread
    public synchronized void i(@Nullable Set<String> set, boolean z, b.C0248b c0248b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{set, Boolean.valueOf(z), c0248b}) == null) {
            synchronized (this) {
                j(set, z, c0248b);
            }
        }
    }

    @AnyThread
    public synchronized void j(@Nullable Set<String> set, boolean z, b.C0248b c0248b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{set, Boolean.valueOf(z), c0248b}) == null) {
            synchronized (this) {
                if (!ProcessUtils.isMainProcess()) {
                    boolean z2 = a;
                    return;
                }
                c.a.p0.a.u.d.k("SwanAppDiskCleaner", "是否为强制自动清理：" + z);
                c.a.p0.q.j.i.a a2 = c.a.p0.q.j.i.b.b().a();
                boolean z3 = z && c.a();
                long j2 = a2.a;
                if (z3 || !o(3600000 * j2)) {
                    h.a().putLong("clean_disk_check_time", System.currentTimeMillis());
                    ExecutorUtilsExt.postOnSerial(new a(this, set, z, a2, j2, c0248b), "cleanDiskSpaceOptimized");
                }
            }
        }
    }

    @NonNull
    @WorkerThread
    public final Map<String, Long> m(long j2, Map<String, PMSAppInfo> map) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, map)) == null) {
            if (map != null && !map.isEmpty()) {
                ArrayList<PMSAppInfo> arrayList = new ArrayList(map.values());
                Collections.sort(arrayList, new b(null));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (PMSAppInfo pMSAppInfo : arrayList) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = pMSAppInfo.createTime;
                    if (currentTimeMillis - j3 > j2) {
                        linkedHashMap.put(pMSAppInfo.appId, Long.valueOf(j3));
                    }
                }
                return linkedHashMap;
            }
            return Collections.emptyMap();
        }
        return (Map) invokeJL.objValue;
    }
}
