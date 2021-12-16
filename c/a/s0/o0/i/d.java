package c.a.s0.o0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.f;
import c.a.r0.d1.s;
import c.a.s0.o0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f20599f;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: b  reason: collision with root package name */
    public Object f20600b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.s0.o0.i.a> f20601c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.o0.i.a f20602d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20603e;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d this$0;

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
            this.this$0 = dVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("ip");
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            int intExtra = intent.getIntExtra("speed", -1);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (intExtra == -1) {
                this.this$0.q(stringExtra, booleanExtra, false);
            } else {
                this.this$0.o(stringExtra, intExtra, booleanExtra, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements s<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f20604e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f20605f;

            public a(b bVar, WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, writeHistroyDataReqIdl};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20605f = bVar;
                this.f20604e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f20604e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.s0.o0.i.a a = c.a.s0.o0.i.a.a(connectPointData);
                            if (a != null) {
                                hashMap.put(a.f20589e, a);
                            }
                        }
                    }
                    synchronized (this.f20605f.a.f20600b) {
                        if (this.f20605f.a.f20601c == null) {
                            this.f20605f.a.f20601c = new ConcurrentHashMap();
                        }
                        this.f20605f.a.f20601c.clear();
                        this.f20605f.a.f20601c.putAll(hashMap);
                    }
                    this.f20605f.a.f20603e = true;
                    this.f20605f.a.s();
                    ArrayList<c.a.s0.o0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f20605f.a.f20601c.entrySet()) {
                        if (this.f20605f.a.f20602d != entry.getValue() && System.currentTimeMillis() - ((c.a.s0.o0.i.a) entry.getValue()).f20587c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.s0.o0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.s0.o0.i.a aVar : arrayList) {
                        this.f20605f.a.f20601c.remove(aVar.f20589e);
                    }
                }
            }
        }

        public b(d dVar) {
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f20607f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f20608g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f20609h;

        public c(d dVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20609h = dVar;
            this.f20606e = str;
            this.f20607f = z;
            this.f20608g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20609h.f20602d != null) {
                    c.a.s0.o0.i.b bVar = this.f20609h.f20602d.a.get(this.f20606e);
                    if (bVar == null) {
                        bVar = new c.a.s0.o0.i.b();
                        bVar.a = this.f20606e;
                        this.f20609h.f20602d.a.put(this.f20606e, bVar);
                    }
                    bVar.a(this.f20607f ? 1 : 0);
                    synchronized (this.f20609h.f20600b) {
                        hashMap = new HashMap(this.f20609h.f20601c);
                    }
                    c.a.s0.o0.i.c.h().j(hashMap);
                }
                if (this.f20608g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f20606e);
                    intent.putExtra("result", this.f20607f);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.s0.o0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1245d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20610e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f20611f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f20612g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f20613h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f20614i;

        public RunnableC1245d(d dVar, String str, boolean z, int i2, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20614i = dVar;
            this.f20610e = str;
            this.f20611f = z;
            this.f20612g = i2;
            this.f20613h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20614i.f20602d == null) {
                    String b2 = c.a.s0.o0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.s0.o0.i.a aVar = new c.a.s0.o0.i.a();
                        aVar.f20589e = b2;
                        this.f20614i.f20602d = aVar;
                        this.f20614i.f20601c.put(b2, aVar);
                    }
                }
                if (this.f20614i.f20602d != null) {
                    c.a.s0.o0.i.b bVar = this.f20614i.f20602d.a.get(this.f20610e);
                    if (bVar == null) {
                        bVar = new c.a.s0.o0.i.b();
                        bVar.a = this.f20610e;
                        this.f20614i.f20602d.a.put(this.f20610e, bVar);
                    }
                    bVar.a(this.f20611f ? 1 : 0);
                    if (this.f20611f) {
                        c.a.s0.o0.i.b bVar2 = this.f20614i.f20602d.f20586b.get(this.f20610e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.s0.o0.i.b();
                            bVar2.a = this.f20610e;
                            this.f20614i.f20602d.f20586b.put(this.f20610e, bVar2);
                        }
                        bVar2.a(this.f20612g);
                    }
                    synchronized (this.f20614i.f20600b) {
                        hashMap = new HashMap(this.f20614i.f20601c);
                    }
                    c.a.s0.o0.i.c.h().j(hashMap);
                }
                if (this.f20613h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f20610e);
                    intent.putExtra("result", this.f20611f);
                    intent.putExtra("speed", this.f20612g);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-252697249, "Lc/a/s0/o0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-252697249, "Lc/a/s0/o0/i/d;");
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
        this.a = new a(this);
        this.f20600b = new Object();
        this.f20601c = null;
        this.f20602d = null;
        this.f20603e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f20599f == null) {
                synchronized (d.class) {
                    if (f20599f == null) {
                        f20599f = new d();
                    }
                }
            }
            return f20599f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.s0.o0.i.a aVar;
        c.a.s0.o0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f20603e || (aVar = this.f20602d) == null || (bVar = aVar.a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f20591c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.s0.o0.i.a aVar;
        c.a.s0.o0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f20603e || (aVar = this.f20602d) == null || (bVar = aVar.f20586b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f20591c;
        }
        return invokeLL.floatValue;
    }

    public void n(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            o(str, i2, z, true);
        }
    }

    public final void o(String str, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f20603e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1245d(this, str, z, i2, z2));
        }
    }

    public void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            q(str, z, true);
        }
    }

    public final void q(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f20603e && !TextUtils.isEmpty(str)) {
            e.i().o(new c(this, str, z, z2));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f20603e) {
            String b2 = c.a.s0.o0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f20601c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.s0.o0.i.a aVar = this.f20601c.get(b2);
            this.f20602d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.s0.o0.i.a aVar2 = this.f20602d;
            if (currentTimeMillis - aVar2.f20588d <= 3600000 || currentTimeMillis - aVar2.f20587c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.a);
                TbadkCoreApplication.getInst().registerReceiver(this.a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.a);
                TbadkCoreApplication.getInst().registerReceiver(this.a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f20603e) {
                return;
            }
            c.a.s0.o0.i.c.h().i(new b(this));
        }
    }
}
