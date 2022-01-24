package c.a.r0.a.y1.c.f;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9879i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f9880j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, c.a.r0.a.y1.c.f.c> a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f9881b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f9882c;

    /* renamed from: d  reason: collision with root package name */
    public final Messenger f9883d;

    /* renamed from: e  reason: collision with root package name */
    public final SwanProcessCallStub f9884e;

    /* renamed from: f  reason: collision with root package name */
    public long f9885f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<c.a.r0.a.y1.c.f.a> f9886g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.a.y1.c.f.a f9887h;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.y1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: c.a.r0.a.y1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0647a implements c.a.r0.a.z2.g1.c<c.a.r0.a.y1.c.f.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9888e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.y1.c.f.c f9889f;

            public C0647a(a aVar, String str, c.a.r0.a.y1.c.f.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9888e = str;
                this.f9889f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.y1.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.a(this.f9888e, this.f9889f);
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.r0.a.y1.c.f.a
        public void a(String str, c.a.r0.a.y1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
                if (e.f9879i) {
                    String str2 = "onEvent: to=" + this.a.f9886g.size() + " event=" + str + " client=" + cVar.f9873f;
                }
                synchronized (this.a.f9886g) {
                    c.a.r0.a.z2.g1.b.a(c.a.r0.a.d2.d.L(), new C0647a(this, str, cVar), this.a.f9886g);
                }
            }
        }

        @Override // c.a.r0.a.y1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y1.c.f.a f9890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f9891f;

        public b(e eVar, c.a.r0.a.y1.c.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9891f = eVar;
            this.f9890e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f9891f.f9886g) {
                    if (this.f9891f.f9886g.contains(this.f9890e)) {
                        if (e.f9879i) {
                            String str = "timeout: callback = " + this.f9890e;
                        }
                        this.f9891f.h(this.f9890e);
                        this.f9890e.timeout();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, c.a.r0.a.y1.c.f.c cVar);
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659252759, "Lc/a/r0/a/y1/c/f/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-659252759, "Lc/a/r0/a/y1/c/f/e$d;");
                    return;
                }
            }
            a = new e(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(759089705, "Lc/a/r0/a/y1/c/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(759089705, "Lc/a/r0/a/y1/c/f/e;");
                return;
            }
        }
        f9879i = k.a;
        f9880j = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!f9879i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (e) invokeV.objValue;
    }

    public void b(c.a.r0.a.y1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            c(aVar, -1L);
        }
    }

    public void c(c.a.r0.a.y1.c.f.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, j2) == null) {
            synchronized (this.f9886g) {
                this.f9886g.add(aVar);
                if (f9879i) {
                    String str = "addCallback: after = " + this.f9886g.size();
                }
            }
            if (j2 > 0) {
                c.a.r0.a.d2.d.L().postDelayed(new b(this, aVar), j2);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f9881b) {
                t("checkRescuable ===>");
                if (this.f9885f > System.currentTimeMillis()) {
                    t(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", Long.valueOf(this.f9885f)));
                    return false;
                } else if (this.f9881b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f9881b.size()), 3));
                    return true;
                } else {
                    int size = this.f9881b.size() - 3;
                    t("after offer purgeCount=" + size);
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            t("purge: " + this.f9881b.poll());
                        }
                    }
                    t("after purge");
                    Long peek = this.f9881b.peek();
                    if (peek == null) {
                        t("allowRescue by null oldestRecord is should not happen");
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                    boolean z = currentTimeMillis > f9880j;
                    t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized c.a.r0.a.y1.c.f.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                c.a.r0.a.y1.c.f.c cVar = null;
                c.a.r0.a.y1.c.f.c cVar2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    c.a.r0.a.y1.c.f.c cVar3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar3 != null && cVar3.f9873f.isSwanAppProcess() && !cVar3.D()) {
                        if (cVar3.R()) {
                            if (f9879i) {
                                String str = "computNextAvailableProcess: firstPreloadedClient=" + cVar3;
                            }
                            return cVar3;
                        }
                        if (cVar == null && cVar3.S()) {
                            cVar = cVar3;
                        }
                        if (cVar2 == null) {
                            cVar2 = cVar3;
                        }
                    }
                }
                if (cVar != null) {
                    if (f9879i) {
                        String str2 = "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar;
                    }
                    return cVar;
                } else if (cVar2 != null) {
                    if (f9879i) {
                        String str3 = "computNextAvailableProcess: firstEmptyClient=" + cVar2;
                    }
                    return cVar2;
                } else {
                    for (c.a.r0.a.y1.c.f.c cVar4 : this.a.values()) {
                        if (cVar4 != null) {
                            if (f9879i) {
                                String str4 = "computNextAvailableProcess: lruClient=" + cVar4;
                            }
                            return cVar4;
                        }
                    }
                    boolean z = f9879i;
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (c.a.r0.a.y1.c.f.c) invokeV.objValue;
    }

    @Nullable
    public synchronized c.a.r0.a.y1.c.f.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                c.a.r0.a.y1.c.f.c cVar = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    c.a.r0.a.y1.c.f.c cVar2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar2 != null && cVar2.f9873f.isSwanAppProcess() && !cVar2.D()) {
                        if (cVar2.R()) {
                            if (f9879i) {
                                String str = "computNextPreloadProcess: return null by found empty process=" + cVar2;
                            }
                            return null;
                        } else if (cVar == null) {
                            cVar = cVar2;
                        }
                    }
                }
                if (f9879i) {
                    String str2 = "computNextPreloadProcess: firstPreloadableClient=" + cVar;
                }
                return cVar;
            }
        }
        return (c.a.r0.a.y1.c.f.c) invokeV.objValue;
    }

    public synchronized void g(String str, c.a.r0.a.y1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<c.a.r0.a.y1.c.f.c> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (c.a.r0.a.y1.c.f.c cVar2 : j2) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.D()) {
                        if (f9879i) {
                            String str2 = "deduplicateClients: protectedClient=" + cVar;
                            String str3 = "deduplicateClients: exClient=" + cVar2;
                        }
                        cVar2.d0();
                        cVar2.c0();
                        if (cVar2.S()) {
                            c.a.r0.a.y1.c.a e2 = c.a.r0.a.y1.c.a.e();
                            c.a.r0.a.y1.c.c cVar3 = new c.a.r0.a.y1.c.c(110, new Bundle());
                            cVar3.b(cVar2.f9873f);
                            e2.h(cVar3);
                        }
                    }
                }
            }
        }
    }

    public void h(c.a.r0.a.y1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            synchronized (this.f9886g) {
                this.f9886g.remove(aVar);
                if (f9879i) {
                    String str = "delCallback: after = " + this.f9886g.size();
                }
            }
        }
    }

    @Nullable
    public synchronized c.a.r0.a.y1.c.f.c i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<c.a.r0.a.y1.c.f.c> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (c.a.r0.a.y1.c.f.c) invokeL.objValue;
    }

    @NonNull
    public synchronized List<c.a.r0.a.y1.c.f.c> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (c.a.r0.a.y1.c.f.c cVar : this.a.values()) {
                        if (TextUtils.equals(cVar.getAppId(), str)) {
                            arrayList.add(cVar);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized c.a.r0.a.y1.c.f.c l(@Nullable String str) {
        InterceptResult invokeL;
        c.a.r0.a.y1.c.f.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                i2 = i(str);
                if (i2 == null) {
                    i2 = e();
                }
            }
            return i2;
        }
        return (c.a.r0.a.y1.c.f.c) invokeL.objValue;
    }

    public c.a.r0.a.y1.c.f.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f9887h : (c.a.r0.a.y1.c.f.a) invokeV.objValue;
    }

    public synchronized c.a.r0.a.y1.c.f.c n(int i2) {
        InterceptResult invokeI;
        c.a.r0.a.y1.c.f.c o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (c.a.r0.a.y1.c.f.c) invokeI.objValue;
    }

    public synchronized c.a.r0.a.y1.c.f.c o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        c.a.r0.a.y1.c.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                cVar = this.a.get(swanAppProcessInfo);
            }
            return cVar;
        }
        return (c.a.r0.a.y1.c.f.c) invokeL.objValue;
    }

    public synchronized <FILTER> c.a.r0.a.y1.c.f.c p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (c.a.r0.a.y1.c.f.c cVar2 : this.a.values()) {
                    if (cVar.a(filter, cVar2)) {
                        return cVar2;
                    }
                }
                return null;
            }
        }
        return (c.a.r0.a.y1.c.f.c) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<c.a.r0.a.y1.c.f.c> q() {
        InterceptResult invokeV;
        LinkedHashSet<c.a.r0.a.y1.c.f.c> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    @NonNull
    public synchronized c.a.r0.a.y1.c.f.c r(@Nullable String str) {
        InterceptResult invokeL;
        c.a.r0.a.y1.c.f.c l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.f9873f);
            }
            return l;
        }
        return (c.a.r0.a.y1.c.f.c) invokeL.objValue;
    }

    public void s(Message message) {
        c.a.r0.a.y1.c.f.c o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, message) == null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (indexOf.isSwanAppProcess() && (o = o(indexOf)) != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(e.class.getClassLoader());
                o.n0(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public final void t(String str) {
        Iterator<Long> it;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && f9879i) {
            String str2 = "SwanRescue:: status => " + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            while (this.f9881b.iterator().hasNext()) {
                String str3 = "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue()));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<c.a.r0.a.y1.c.f.c> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (c.a.r0.a.y1.c.f.c cVar : q) {
                sb.append("\n--> ");
                sb.append(cVar.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && f9879i) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String str2 = "\nlogStatus by " + str + ":\n" + toString();
        }
    }

    public synchronized void v(SwanAppProcessInfo swanAppProcessInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, swanAppProcessInfo) == null) {
            synchronized (this) {
                c.a.r0.a.y1.c.f.c remove = this.a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.a.put(swanAppProcessInfo, remove);
                }
                if (f9879i) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.f9881b) {
                if (d()) {
                    this.f9881b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    c.a.r0.a.y1.c.f.b.n(c.a.r0.a.c1.a.c(), bundle);
                }
            }
        }
    }

    public e() {
        SwanAppProcessInfo[] indices;
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
        this.a = new LinkedHashMap<>();
        this.f9881b = new ArrayDeque();
        this.f9882c = new SwanAppMessengerService.a();
        this.f9883d = new Messenger(this.f9882c);
        this.f9884e = new SwanProcessCallStub(this.f9882c);
        this.f9885f = 0L;
        this.f9886g = new HashSet();
        this.f9887h = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.a.put(swanAppProcessInfo, new c.a.r0.a.y1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
