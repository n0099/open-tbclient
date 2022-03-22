package c.a.n0.a.d0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d0.l.b;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.f.b.a.l;
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
public class d implements c.a.n0.a.c.c, c.a.n0.a.d0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final InterfaceC0232d a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4013b;

    /* renamed from: c  reason: collision with root package name */
    public g f4014c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.d0.c f4015d;

    /* renamed from: e  reason: collision with root package name */
    public l f4016e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f4017f;

    /* renamed from: g  reason: collision with root package name */
    public CopyOnWriteArrayList<String> f4018g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.d0.h.e f4019h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s0.a.h0().c(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f4020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.C0236b f4021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f4022d;

        public b(d dVar, List list, boolean z, b.C0236b c0236b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, Boolean.valueOf(z), c0236b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4022d = dVar;
            this.a = list;
            this.f4020b = z;
            this.f4021c = c0236b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4022d.h(this.a, this.f4020b, this.f4021c);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            HashSet hashSet;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    hashSet = c.a.n0.a.p2.a1.a.a(bundle.getStringArray("key_exclude_ids"));
                    z = bundle.getBoolean("key_force_clean");
                    i = bundle.getInt("key_clean_scenes_type");
                } else {
                    hashSet = null;
                    i = 0;
                    z = false;
                }
                d d2 = f.c().d();
                c.a.n0.a.d0.l.c l = c.a.n0.a.d0.l.c.l();
                l.i(i);
                d2.t(hashSet, z, l.k());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* renamed from: c.a.n0.a.d0.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0232d extends c.a.n0.a.d0.b {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208340005, "Lc/a/n0/a/d0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208340005, "Lc/a/n0/a/d0/d;");
                return;
            }
        }
        i = c.a.n0.a.a.a;
    }

    public d(InterfaceC0232d interfaceC0232d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0232d};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4013b = ProcessUtils.getCurProcessName();
        this.a = interfaceC0232d;
        ExecutorUtilsExt.postOnElastic(new a(this), "addLoginStatusChangedListener", 2);
        this.f4017f = new AtomicInteger(0);
        this.f4018g = new CopyOnWriteArrayList<>();
        this.f4016e = c.a.n0.a.s0.b.m();
        this.f4014c = new g();
        l lVar = this.f4016e;
        if (lVar != null) {
            this.f4015d = lVar.b();
        }
        this.f4019h = new c.a.n0.a.d0.h.e();
        if (i) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // c.a.n0.a.c.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String h2 = c.a.n0.a.s0.a.h0().h(this.a.a());
            if (i) {
                Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
                Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + h2 + ")  -> " + z);
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
        this.f4018g.add(str);
    }

    public final Set<String> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HashSet hashSet = new HashSet();
            LinkedHashSet<c.a.n0.a.o1.c.f.c> q = c.a.n0.a.o1.c.f.e.k().q();
            if (q.size() < 1) {
                return hashSet;
            }
            Iterator<c.a.n0.a.o1.c.f.c> it = q.iterator();
            while (it.hasNext()) {
                c.a.n0.a.o1.c.f.c next = it.next();
                if (next.S() && (next.D() || next.P())) {
                    hashSet.add(next.getAppId());
                    if (i) {
                        Log.i("SwanAppPurger", "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
                    c.a.n0.a.o1.c.c cVar = new c.a.n0.a.o1.c.c(i2);
                    cVar.b(next.f5627b);
                    e2.h(cVar);
                }
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    public final void d(String str, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, c0236b) == null) {
            c.a.n0.a.d0.l.c.m(c0236b).b(str);
            this.f4014c.a(str);
            c.a.n0.a.d0.c cVar = this.f4015d;
            if (cVar != null) {
                cVar.a(str);
            }
            c.a.n0.a.x.m.s.a.n(str);
        }
    }

    public void e(@Nullable String str, boolean z, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), c0236b}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, c0236b);
    }

    public void f(@Nullable List<String> list, boolean z, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), c0236b}) == null) || list == null || list.isEmpty()) {
            return;
        }
        g(list, true, z, c0236b);
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), c0236b}) == null) {
            if (!ProcessUtils.isMainProcess()) {
                if (i) {
                    Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                    return;
                }
                return;
            }
            c.a.n0.a.u.d.l("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
            if (z2) {
                i(list);
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            o(list);
            ExecutorUtilsExt.postOnSerial(new b(this, list, z, c0236b), "deleteSwanApp");
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), c0236b}) == null) {
            if (list == null) {
                if (i) {
                    Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                    return;
                }
                return;
            }
            this.f4017f.incrementAndGet();
            if (z) {
                c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                this.f4014c.g(list);
                int size = list.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = c.a.n0.a.l.a.a(list.get(i2));
                }
                c.a.n0.a.z.d.a.b(strArr);
            }
            c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
            this.f4014c.e(list);
            for (String str : list) {
                if (this.f4018g.contains(str) || TextUtils.isEmpty(str)) {
                    c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                } else {
                    if (i) {
                        Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                    }
                    c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                    p(str, c0236b);
                }
            }
            if (this.f4017f.decrementAndGet() <= 0) {
                this.f4017f.set(0);
                this.f4018g.clear();
                c.a.n0.a.d0.h.b.a();
            }
            c.a.n0.a.d0.l.c.m(c0236b).j();
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
        Set<String> i3 = c.a.n0.a.z.c.b.i(AppRuntime.getAppContext().getContentResolver());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = i3.contains(next);
            boolean containsKey = hashMap.containsKey(next);
            if (!contains && !containsKey) {
                if (c.a.n0.a.a.a) {
                    Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                }
            } else {
                if (c.a.n0.a.a.a) {
                    Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
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
            c.a.n0.a.e2.h.d.j().g("aiapp_", set, true);
            String w = c.a.n0.a.e2.b.w();
            if (!TextUtils.isEmpty(w)) {
                c.a.n0.w.d.k(w);
            }
            String y = c.a.n0.a.e2.b.y();
            if (!TextUtils.isEmpty(y)) {
                c.a.n0.w.d.k(y);
            }
            String n = c.a.n0.a.q0.d.n();
            if (!TextUtils.isEmpty(n)) {
                c.a.n0.w.d.k(n);
            }
            l lVar = this.f4016e;
            if (lVar != null) {
                lVar.g();
                this.f4016e.c();
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f4017f.get() > 0 : invokeV.booleanValue;
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
            c.a.n0.a.e2.g.b a2 = h.a();
            a2.putInt("bookshelf_insert" + it.next(), 0);
        }
    }

    public final void p(String str, b.C0236b c0236b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, c0236b) == null) {
            if (c.a.n0.a.d0.h.c.a() && c.a.n0.a.q0.d.f().contains(str)) {
                c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
            } else if (c.a.n0.a.d0.h.b.c(str)) {
                c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
            } else {
                d(str, c0236b);
                c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                this.f4014c.f(str);
                c.a.n0.a.u.d.k("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                this.f4014c.d(str);
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
            c.a.n0.a.e2.h.d.j().g("aiapp_setting_", set, true);
        }
    }

    public void t(@Nullable Set<String> set, boolean z, b.C0236b c0236b) {
        c.a.n0.a.d0.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{set, Boolean.valueOf(z), c0236b}) == null) || (eVar = this.f4019h) == null) {
            return;
        }
        eVar.i(set, z, c0236b);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "Process<" + this.f4013b + "> " + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{set, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (ProcessUtils.isMainProcess()) {
                c.a.n0.a.d0.l.c l = c.a.n0.a.d0.l.c.l();
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
            c.a.n0.a.o1.b.e.c(c.class, bundle);
        }
    }
}
