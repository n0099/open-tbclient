package b.a.p0.a.y1.c.f;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public static final boolean f9503i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<SwanAppProcessInfo, b.a.p0.a.y1.c.f.c> f9504a;

    /* renamed from: b  reason: collision with root package name */
    public final Deque<Long> f9505b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f9506c;

    /* renamed from: d  reason: collision with root package name */
    public final Messenger f9507d;

    /* renamed from: e  reason: collision with root package name */
    public final SwanProcessCallStub f9508e;

    /* renamed from: f  reason: collision with root package name */
    public long f9509f;

    /* renamed from: g  reason: collision with root package name */
    public final Set<b.a.p0.a.y1.c.f.a> f9510g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.p0.a.y1.c.f.a f9511h;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.y1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f9512a;

        /* renamed from: b.a.p0.a.y1.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0489a implements b.a.p0.a.z2.g1.c<b.a.p0.a.y1.c.f.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f9513e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.y1.c.f.c f9514f;

            public C0489a(a aVar, String str, b.a.p0.a.y1.c.f.c cVar) {
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
                this.f9513e = str;
                this.f9514f = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(b.a.p0.a.y1.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.a(this.f9513e, this.f9514f);
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
            this.f9512a = eVar;
        }

        @Override // b.a.p0.a.y1.c.f.a
        public void a(String str, b.a.p0.a.y1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
                if (e.f9503i) {
                    String str2 = "onEvent: to=" + this.f9512a.f9510g.size() + " event=" + str + " client=" + cVar.f9497f;
                }
                synchronized (this.f9512a.f9510g) {
                    b.a.p0.a.z2.g1.b.a(b.a.p0.a.d2.d.L(), new C0489a(this, str, cVar), this.f9512a.f9510g);
                }
            }
        }

        @Override // b.a.p0.a.y1.c.f.a
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
        public final /* synthetic */ b.a.p0.a.y1.c.f.a f9515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f9516f;

        public b(e eVar, b.a.p0.a.y1.c.f.a aVar) {
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
            this.f9516f = eVar;
            this.f9515e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f9516f.f9510g) {
                    if (this.f9516f.f9510g.contains(this.f9515e)) {
                        if (e.f9503i) {
                            String str = "timeout: callback = " + this.f9515e;
                        }
                        this.f9516f.h(this.f9515e);
                        this.f9515e.timeout();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, b.a.p0.a.y1.c.f.c cVar);
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f9517a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(770639820, "Lb/a/p0/a/y1/c/f/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(770639820, "Lb/a/p0/a/y1/c/f/e$d;");
                    return;
                }
            }
            f9517a = new e(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1527687988, "Lb/a/p0/a/y1/c/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1527687988, "Lb/a/p0/a/y1/c/f/e;");
                return;
            }
        }
        f9503i = k.f6863a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!f9503i || ProcessUtils.isMainProcess()) {
                return d.f9517a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (e) invokeV.objValue;
    }

    public void b(b.a.p0.a.y1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            c(aVar, -1L);
        }
    }

    public void c(b.a.p0.a.y1.c.f.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, j2) == null) {
            synchronized (this.f9510g) {
                this.f9510g.add(aVar);
                if (f9503i) {
                    String str = "addCallback: after = " + this.f9510g.size();
                }
            }
            if (j2 > 0) {
                b.a.p0.a.d2.d.L().postDelayed(new b(this, aVar), j2);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f9505b) {
                t("checkRescuable ===>");
                if (this.f9509f > System.currentTimeMillis()) {
                    t(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", Long.valueOf(this.f9509f)));
                    return false;
                } else if (this.f9505b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.f9505b.size()), 3));
                    return true;
                } else {
                    int size = this.f9505b.size() - 3;
                    t("after offer purgeCount=" + size);
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            t("purge: " + this.f9505b.poll());
                        }
                    }
                    t("after purge");
                    Long peek = this.f9505b.peek();
                    if (peek == null) {
                        t("allowRescue by null oldestRecord is should not happen");
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                    boolean z = currentTimeMillis > j;
                    t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized b.a.p0.a.y1.c.f.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                b.a.p0.a.y1.c.f.c cVar = null;
                b.a.p0.a.y1.c.f.c cVar2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    b.a.p0.a.y1.c.f.c cVar3 = this.f9504a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar3 != null && cVar3.f9497f.isSwanAppProcess() && !cVar3.D()) {
                        if (cVar3.R()) {
                            if (f9503i) {
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
                    if (f9503i) {
                        String str2 = "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar;
                    }
                    return cVar;
                } else if (cVar2 != null) {
                    if (f9503i) {
                        String str3 = "computNextAvailableProcess: firstEmptyClient=" + cVar2;
                    }
                    return cVar2;
                } else {
                    for (b.a.p0.a.y1.c.f.c cVar4 : this.f9504a.values()) {
                        if (cVar4 != null) {
                            if (f9503i) {
                                String str4 = "computNextAvailableProcess: lruClient=" + cVar4;
                            }
                            return cVar4;
                        }
                    }
                    boolean z = f9503i;
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (b.a.p0.a.y1.c.f.c) invokeV.objValue;
    }

    @Nullable
    public synchronized b.a.p0.a.y1.c.f.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                b.a.p0.a.y1.c.f.c cVar = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    b.a.p0.a.y1.c.f.c cVar2 = this.f9504a.get(SwanAppProcessInfo.indexOf(i2));
                    if (cVar2 != null && cVar2.f9497f.isSwanAppProcess() && !cVar2.D()) {
                        if (cVar2.R()) {
                            if (f9503i) {
                                String str = "computNextPreloadProcess: return null by found empty process=" + cVar2;
                            }
                            return null;
                        } else if (cVar == null) {
                            cVar = cVar2;
                        }
                    }
                }
                if (f9503i) {
                    String str2 = "computNextPreloadProcess: firstPreloadableClient=" + cVar;
                }
                return cVar;
            }
        }
        return (b.a.p0.a.y1.c.f.c) invokeV.objValue;
    }

    public synchronized void g(String str, b.a.p0.a.y1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<b.a.p0.a.y1.c.f.c> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (b.a.p0.a.y1.c.f.c cVar2 : j2) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.D()) {
                        if (f9503i) {
                            String str2 = "deduplicateClients: protectedClient=" + cVar;
                            String str3 = "deduplicateClients: exClient=" + cVar2;
                        }
                        cVar2.d0();
                        cVar2.c0();
                        if (cVar2.S()) {
                            b.a.p0.a.y1.c.a e2 = b.a.p0.a.y1.c.a.e();
                            b.a.p0.a.y1.c.c cVar3 = new b.a.p0.a.y1.c.c(110, new Bundle());
                            cVar3.b(cVar2.f9497f);
                            e2.h(cVar3);
                        }
                    }
                }
            }
        }
    }

    public void h(b.a.p0.a.y1.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            synchronized (this.f9510g) {
                this.f9510g.remove(aVar);
                if (f9503i) {
                    String str = "delCallback: after = " + this.f9510g.size();
                }
            }
        }
    }

    @Nullable
    public synchronized b.a.p0.a.y1.c.f.c i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<b.a.p0.a.y1.c.f.c> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (b.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    @NonNull
    public synchronized List<b.a.p0.a.y1.c.f.c> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (b.a.p0.a.y1.c.f.c cVar : this.f9504a.values()) {
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

    public synchronized b.a.p0.a.y1.c.f.c l(@Nullable String str) {
        InterceptResult invokeL;
        b.a.p0.a.y1.c.f.c i2;
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
        return (b.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    public b.a.p0.a.y1.c.f.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f9511h : (b.a.p0.a.y1.c.f.a) invokeV.objValue;
    }

    public synchronized b.a.p0.a.y1.c.f.c n(int i2) {
        InterceptResult invokeI;
        b.a.p0.a.y1.c.f.c o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (b.a.p0.a.y1.c.f.c) invokeI.objValue;
    }

    public synchronized b.a.p0.a.y1.c.f.c o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        b.a.p0.a.y1.c.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                cVar = this.f9504a.get(swanAppProcessInfo);
            }
            return cVar;
        }
        return (b.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    public synchronized <FILTER> b.a.p0.a.y1.c.f.c p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (b.a.p0.a.y1.c.f.c cVar2 : this.f9504a.values()) {
                    if (cVar.a(filter, cVar2)) {
                        return cVar2;
                    }
                }
                return null;
            }
        }
        return (b.a.p0.a.y1.c.f.c) invokeLL.objValue;
    }

    public synchronized LinkedHashSet<b.a.p0.a.y1.c.f.c> q() {
        InterceptResult invokeV;
        LinkedHashSet<b.a.p0.a.y1.c.f.c> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.f9504a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    @NonNull
    public synchronized b.a.p0.a.y1.c.f.c r(@Nullable String str) {
        InterceptResult invokeL;
        b.a.p0.a.y1.c.f.c l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.f9497f);
            }
            return l;
        }
        return (b.a.p0.a.y1.c.f.c) invokeL.objValue;
    }

    public void s(Message message) {
        b.a.p0.a.y1.c.f.c o;
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
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && f9503i) {
            String str2 = "SwanRescue:: status => " + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            while (this.f9505b.iterator().hasNext()) {
                String str3 = "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue()));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<b.a.p0.a.y1.c.f.c> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (b.a.p0.a.y1.c.f.c cVar : q) {
                sb.append("\n--> ");
                sb.append(cVar.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && f9503i) {
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
                b.a.p0.a.y1.c.f.c remove = this.f9504a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.f9504a.put(swanAppProcessInfo, remove);
                }
                if (f9503i) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.f9505b) {
                if (d()) {
                    this.f9505b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    b.a.p0.a.y1.c.f.b.n(b.a.p0.a.c1.a.c(), bundle);
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
        this.f9504a = new LinkedHashMap<>();
        this.f9505b = new ArrayDeque();
        this.f9506c = new SwanAppMessengerService.a();
        this.f9507d = new Messenger(this.f9506c);
        this.f9508e = new SwanProcessCallStub(this.f9506c);
        this.f9509f = 0L;
        this.f9510g = new HashSet();
        this.f9511h = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.f9504a.put(swanAppProcessInfo, new b.a.p0.a.y1.c.f.c(swanAppProcessInfo));
            }
        }
    }
}
