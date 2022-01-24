package c.a.r0.a.n0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.n0.l.b;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.p.b.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d implements c.a.r0.a.m.c, c.a.r0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterfaceC0476d f7890e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7891f;

    /* renamed from: g  reason: collision with root package name */
    public g f7892g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a.n0.c f7893h;

    /* renamed from: i  reason: collision with root package name */
    public l f7894i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicInteger f7895j;
    public CopyOnWriteArrayList<String> k;
    public c.a.r0.a.n0.h.e l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f7896e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7896e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c1.a.h0().c(this.f7896e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f7897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f7898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.C0480b f7899g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f7900h;

        public b(d dVar, List list, boolean z, b.C0480b c0480b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, Boolean.valueOf(z), c0480b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7900h = dVar;
            this.f7897e = list;
            this.f7898f = z;
            this.f7899g = c0480b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7900h.h(this.f7897e, this.f7898f, this.f7899g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            HashSet hashSet;
            int i2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    hashSet = c.a.r0.a.z2.a1.a.a(bundle.getStringArray("key_exclude_ids"));
                    z = bundle.getBoolean("key_force_clean");
                    i2 = bundle.getInt("key_clean_scenes_type");
                } else {
                    hashSet = null;
                    i2 = 0;
                    z = false;
                }
                d d2 = f.c().d();
                c.a.r0.a.n0.l.c l = c.a.r0.a.n0.l.c.l();
                l.i(i2);
                d2.t(hashSet, z, l.k());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* renamed from: c.a.r0.a.n0.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0476d extends c.a.r0.a.n0.b {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431521195, "Lc/a/r0/a/n0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431521195, "Lc/a/r0/a/n0/d;");
                return;
            }
        }
        m = k.a;
    }

    public d(InterfaceC0476d interfaceC0476d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0476d};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7891f = ProcessUtils.getCurProcessName();
        this.f7890e = interfaceC0476d;
        ExecutorUtilsExt.postOnElastic(new a(this), "addLoginStatusChangedListener", 2);
        this.f7895j = new AtomicInteger(0);
        this.k = new CopyOnWriteArrayList<>();
        this.f7894i = c.a.r0.a.c1.b.m();
        this.f7892g = new g();
        l lVar = this.f7894i;
        if (lVar != null) {
            this.f7893h = lVar.b();
        }
        this.l = new c.a.r0.a.n0.h.e();
        if (m) {
            String str = "create : " + toString();
        }
    }

    @Override // c.a.r0.a.m.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String h2 = c.a.r0.a.c1.a.h0().h(this.f7890e.a());
            if (m) {
                String str = "onLoginStatusChanged : " + toString();
                String str2 = "onLoginStatusChanged : uid(" + h2 + ")  -> " + z;
            }
            if (z) {
                q();
            } else {
                j();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.k.add(str);
    }

    public final Set<String> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HashSet hashSet = new HashSet();
            LinkedHashSet<c.a.r0.a.y1.c.f.c> q = c.a.r0.a.y1.c.f.e.k().q();
            if (q.size() < 1) {
                return hashSet;
            }
            Iterator<c.a.r0.a.y1.c.f.c> it = q.iterator();
            while (it.hasNext()) {
                c.a.r0.a.y1.c.f.c next = it.next();
                if (next.S() && (next.D() || next.P())) {
                    hashSet.add(next.getAppId());
                    if (m) {
                        String str = "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    c.a.r0.a.y1.c.a e2 = c.a.r0.a.y1.c.a.e();
                    c.a.r0.a.y1.c.c cVar = new c.a.r0.a.y1.c.c(i2);
                    cVar.b(next.f9873f);
                    e2.h(cVar);
                }
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    public final void d(String str, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, c0480b) == null) {
            c.a.r0.a.n0.l.c.m(c0480b).b(str);
            this.f7892g.a(str);
            c.a.r0.a.n0.c cVar = this.f7893h;
            if (cVar != null) {
                cVar.a(str);
            }
            c.a.r0.a.h0.m.s.a.n(str);
        }
    }

    public void e(@Nullable String str, boolean z, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), c0480b}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, c0480b);
    }

    public void f(@Nullable List<String> list, boolean z, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), c0480b}) == null) || list == null || list.isEmpty()) {
            return;
        }
        g(list, true, z, c0480b);
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), c0480b}) == null) {
            if (!ProcessUtils.isMainProcess()) {
                boolean z3 = m;
                return;
            }
            c.a.r0.a.e0.d.l("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
            if (z2) {
                i(list);
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            o(list);
            ExecutorUtilsExt.postOnSerial(new b(this, list, z, c0480b), "deleteSwanApp");
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), c0480b}) == null) {
            if (list == null) {
                boolean z2 = m;
                return;
            }
            this.f7895j.incrementAndGet();
            if (z) {
                c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                this.f7892g.g(list);
                int size = list.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = c.a.r0.a.v.a.a(list.get(i2));
                }
                c.a.r0.a.j0.d.a.b(strArr);
            }
            c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
            this.f7892g.e(list);
            for (String str : list) {
                if (this.k.contains(str) || TextUtils.isEmpty(str)) {
                    c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                } else {
                    if (m) {
                        String str2 = "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str;
                    }
                    c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                    p(str, c0480b);
                }
            }
            if (this.f7895j.decrementAndGet() <= 0) {
                this.f7895j.set(0);
                this.k.clear();
                c.a.r0.a.n0.h.b.a();
            }
            c.a.r0.a.n0.l.c.m(c0480b).j();
        }
    }

    public final void i(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
        HashMap hashMap = new HashMap();
        for (SwanFavorItemData swanFavorItemData : i2) {
            hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
        }
        Set<String> i3 = c.a.r0.a.j0.c.b.i(AppRuntime.getAppContext().getContentResolver());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = i3.contains(next);
            boolean containsKey = hashMap.containsKey(next);
            if (!contains && !containsKey) {
                if (k.a) {
                    String str = "清理过滤-不过滤： " + next;
                }
            } else {
                if (k.a) {
                    String str2 = "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey;
                }
                it.remove();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(k());
        }
    }

    public final Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c(100) : (Set) invokeV.objValue;
    }

    public final void l(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, set) == null) {
            c.a.r0.a.o2.h.d.j().g("aiapp_", set, true);
            String w = c.a.r0.a.o2.b.w();
            if (!TextUtils.isEmpty(w)) {
                c.a.r0.w.d.k(w);
            }
            String y = c.a.r0.a.o2.b.y();
            if (!TextUtils.isEmpty(y)) {
                c.a.r0.w.d.k(y);
            }
            String n = c.a.r0.a.a1.d.n();
            if (!TextUtils.isEmpty(n)) {
                c.a.r0.w.d.k(n);
            }
            l lVar = this.f7894i;
            if (lVar != null) {
                lVar.g();
                this.f7894i.c();
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7895j.get() > 0 : invokeV.booleanValue;
    }

    public boolean n(Map<String, PMSAppInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, map)) == null) {
            if (map == null || map.size() <= 0) {
                return false;
            }
            return (map.size() == 1 && map.containsKey("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void o(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            c.a.r0.a.o2.g.b a2 = h.a();
            a2.putInt("bookshelf_insert" + it.next(), 0);
        }
    }

    public final void p(String str, b.C0480b c0480b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, c0480b) == null) {
            if (c.a.r0.a.n0.h.c.a() && c.a.r0.a.a1.d.f().contains(str)) {
                c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
            } else if (c.a.r0.a.n0.h.b.c(str)) {
                c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
            } else {
                d(str, c0480b);
                c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                this.f7892g.f(str);
                c.a.r0.a.e0.d.k("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                this.f7892g.d(str);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            s(r());
        }
    }

    public final Set<String> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c(103) : (Set) invokeV.objValue;
    }

    public final void s(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            c.a.r0.a.o2.h.d.j().g("aiapp_setting_", set, true);
        }
    }

    public void t(@Nullable Set<String> set, boolean z, b.C0480b c0480b) {
        c.a.r0.a.n0.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{set, Boolean.valueOf(z), c0480b}) == null) || (eVar = this.l) == null) {
            return;
        }
        eVar.i(set, z, c0480b);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "Process<" + this.f7891f + "> " + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{set, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (ProcessUtils.isMainProcess()) {
                c.a.r0.a.n0.l.c l = c.a.r0.a.n0.l.c.l();
                l.i(i2);
                t(set, z, l.k());
                return;
            }
            Bundle bundle = new Bundle();
            if (set != null && set.size() > 0) {
                bundle.putStringArray("key_exclude_ids", (String[]) set.toArray(new String[0]));
            }
            bundle.putBoolean("key_force_clean", z);
            bundle.putInt("key_clean_scenes_type", i2);
            c.a.r0.a.y1.b.e.c(c.class, bundle);
        }
    }
}
