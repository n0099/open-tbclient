package c.a.p0.q0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.f;
import c.a.o0.c1.s;
import c.a.p0.q0.e;
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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f17107f;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: b  reason: collision with root package name */
    public Object f17108b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.p0.q0.i.a> f17109c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q0.i.a f17110d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17111e;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class b implements s<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteHistroyDataReqIdl a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f17112b;

            public a(b bVar, WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, writeHistroyDataReqIdl};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17112b = bVar;
                this.a = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.a;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.p0.q0.i.a a = c.a.p0.q0.i.a.a(connectPointData);
                            if (a != null) {
                                hashMap.put(a.f17098e, a);
                            }
                        }
                    }
                    synchronized (this.f17112b.a.f17108b) {
                        if (this.f17112b.a.f17109c == null) {
                            this.f17112b.a.f17109c = new ConcurrentHashMap();
                        }
                        this.f17112b.a.f17109c.clear();
                        this.f17112b.a.f17109c.putAll(hashMap);
                    }
                    this.f17112b.a.f17111e = true;
                    this.f17112b.a.s();
                    ArrayList<c.a.p0.q0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f17112b.a.f17109c.entrySet()) {
                        if (this.f17112b.a.f17110d != entry.getValue() && System.currentTimeMillis() - ((c.a.p0.q0.i.a) entry.getValue()).f17096c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.p0.q0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.p0.q0.i.a aVar : arrayList) {
                        this.f17112b.a.f17109c.remove(aVar.f17098e);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f17114c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f17115d;

        public c(d dVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17115d = dVar;
            this.a = str;
            this.f17113b = z;
            this.f17114c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17115d.f17110d != null) {
                    c.a.p0.q0.i.b bVar = this.f17115d.f17110d.a.get(this.a);
                    if (bVar == null) {
                        bVar = new c.a.p0.q0.i.b();
                        bVar.a = this.a;
                        this.f17115d.f17110d.a.put(this.a, bVar);
                    }
                    bVar.a(this.f17113b ? 1 : 0);
                    synchronized (this.f17115d.f17108b) {
                        hashMap = new HashMap(this.f17115d.f17109c);
                    }
                    c.a.p0.q0.i.c.h().j(hashMap);
                }
                if (this.f17114c) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.a);
                    intent.putExtra("result", this.f17113b);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.p0.q0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1286d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17116b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17117c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f17118d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17119e;

        public RunnableC1286d(d dVar, String str, boolean z, int i, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17119e = dVar;
            this.a = str;
            this.f17116b = z;
            this.f17117c = i;
            this.f17118d = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17119e.f17110d == null) {
                    String b2 = c.a.p0.q0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.p0.q0.i.a aVar = new c.a.p0.q0.i.a();
                        aVar.f17098e = b2;
                        this.f17119e.f17110d = aVar;
                        this.f17119e.f17109c.put(b2, aVar);
                    }
                }
                if (this.f17119e.f17110d != null) {
                    c.a.p0.q0.i.b bVar = this.f17119e.f17110d.a.get(this.a);
                    if (bVar == null) {
                        bVar = new c.a.p0.q0.i.b();
                        bVar.a = this.a;
                        this.f17119e.f17110d.a.put(this.a, bVar);
                    }
                    bVar.a(this.f17116b ? 1 : 0);
                    if (this.f17116b) {
                        c.a.p0.q0.i.b bVar2 = this.f17119e.f17110d.f17095b.get(this.a);
                        if (bVar2 == null) {
                            bVar2 = new c.a.p0.q0.i.b();
                            bVar2.a = this.a;
                            this.f17119e.f17110d.f17095b.put(this.a, bVar2);
                        }
                        bVar2.a(this.f17117c);
                    }
                    synchronized (this.f17119e.f17108b) {
                        hashMap = new HashMap(this.f17119e.f17109c);
                    }
                    c.a.p0.q0.i.c.h().j(hashMap);
                }
                if (this.f17118d) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.a);
                    intent.putExtra("result", this.f17116b);
                    intent.putExtra("speed", this.f17117c);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2111850628, "Lc/a/p0/q0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2111850628, "Lc/a/p0/q0/i/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.f17108b = new Object();
        this.f17109c = null;
        this.f17110d = null;
        this.f17111e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f17107f == null) {
                synchronized (d.class) {
                    if (f17107f == null) {
                        f17107f = new d();
                    }
                }
            }
            return f17107f;
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
        c.a.p0.q0.i.a aVar;
        c.a.p0.q0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f17111e || (aVar = this.f17110d) == null || (bVar = aVar.a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f17100c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.p0.q0.i.a aVar;
        c.a.p0.q0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f17111e || (aVar = this.f17110d) == null || (bVar = aVar.f17095b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f17100c;
        }
        return invokeLL.floatValue;
    }

    public void n(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            o(str, i, z, true);
        }
    }

    public final void o(String str, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f17111e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1286d(this, str, z, i, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f17111e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f17111e) {
            String b2 = c.a.p0.q0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f17109c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.p0.q0.i.a aVar = this.f17109c.get(b2);
            this.f17110d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.q0.i.a aVar2 = this.f17110d;
            if (currentTimeMillis - aVar2.f17097d <= 3600000 || currentTimeMillis - aVar2.f17096c >= 3600000) {
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
            if (this.f17111e) {
                return;
            }
            c.a.p0.q0.i.c.h().i(new b(this));
        }
    }
}
