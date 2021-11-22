package b.a.r0.i0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.f;
import b.a.q0.c1.q;
import b.a.r0.i0.e;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f19321f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f19322a;

    /* renamed from: b  reason: collision with root package name */
    public Object f19323b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b.a.r0.i0.i.a> f19324c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.i0.i.a f19325d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19326e;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements q<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f19327a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f19328e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f19329f;

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
                this.f19329f = bVar;
                this.f19328e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f19328e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            b.a.r0.i0.i.a a2 = b.a.r0.i0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f19306e, a2);
                            }
                        }
                    }
                    synchronized (this.f19329f.f19327a.f19323b) {
                        if (this.f19329f.f19327a.f19324c == null) {
                            this.f19329f.f19327a.f19324c = new ConcurrentHashMap();
                        }
                        this.f19329f.f19327a.f19324c.clear();
                        this.f19329f.f19327a.f19324c.putAll(hashMap);
                    }
                    this.f19329f.f19327a.f19326e = true;
                    this.f19329f.f19327a.s();
                    ArrayList<b.a.r0.i0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f19329f.f19327a.f19324c.entrySet()) {
                        if (this.f19329f.f19327a.f19325d != entry.getValue() && System.currentTimeMillis() - ((b.a.r0.i0.i.a) entry.getValue()).f19304c > 604800000) {
                            arrayList.add(entry.getValue());
                            b.a.r0.i0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (b.a.r0.i0.i.a aVar : arrayList) {
                        this.f19329f.f19327a.f19324c.remove(aVar.f19306e);
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
            this.f19327a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19331f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f19333h;

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
            this.f19333h = dVar;
            this.f19330e = str;
            this.f19331f = z;
            this.f19332g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19333h.f19325d != null) {
                    b.a.r0.i0.i.b bVar = this.f19333h.f19325d.f19302a.get(this.f19330e);
                    if (bVar == null) {
                        bVar = new b.a.r0.i0.i.b();
                        bVar.f19307a = this.f19330e;
                        this.f19333h.f19325d.f19302a.put(this.f19330e, bVar);
                    }
                    bVar.a(this.f19331f ? 1 : 0);
                    synchronized (this.f19333h.f19323b) {
                        hashMap = new HashMap(this.f19333h.f19324c);
                    }
                    b.a.r0.i0.i.c.h().j(hashMap);
                }
                if (this.f19332g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19330e);
                    intent.putExtra("result", this.f19331f);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: b.a.r0.i0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0977d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19334e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19335f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19336g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f19337h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f19338i;

        public RunnableC0977d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f19338i = dVar;
            this.f19334e = str;
            this.f19335f = z;
            this.f19336g = i2;
            this.f19337h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19338i.f19325d == null) {
                    String b2 = b.a.r0.i0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        b.a.r0.i0.i.a aVar = new b.a.r0.i0.i.a();
                        aVar.f19306e = b2;
                        this.f19338i.f19325d = aVar;
                        this.f19338i.f19324c.put(b2, aVar);
                    }
                }
                if (this.f19338i.f19325d != null) {
                    b.a.r0.i0.i.b bVar = this.f19338i.f19325d.f19302a.get(this.f19334e);
                    if (bVar == null) {
                        bVar = new b.a.r0.i0.i.b();
                        bVar.f19307a = this.f19334e;
                        this.f19338i.f19325d.f19302a.put(this.f19334e, bVar);
                    }
                    bVar.a(this.f19335f ? 1 : 0);
                    if (this.f19335f) {
                        b.a.r0.i0.i.b bVar2 = this.f19338i.f19325d.f19303b.get(this.f19334e);
                        if (bVar2 == null) {
                            bVar2 = new b.a.r0.i0.i.b();
                            bVar2.f19307a = this.f19334e;
                            this.f19338i.f19325d.f19303b.put(this.f19334e, bVar2);
                        }
                        bVar2.a(this.f19336g);
                    }
                    synchronized (this.f19338i.f19323b) {
                        hashMap = new HashMap(this.f19338i.f19324c);
                    }
                    b.a.r0.i0.i.c.h().j(hashMap);
                }
                if (this.f19337h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19334e);
                    intent.putExtra("result", this.f19335f);
                    intent.putExtra("speed", this.f19336g);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-580679909, "Lb/a/r0/i0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-580679909, "Lb/a/r0/i0/i/d;");
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
        this.f19322a = new a(this);
        this.f19323b = new Object();
        this.f19324c = null;
        this.f19325d = null;
        this.f19326e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f19321f == null) {
                synchronized (d.class) {
                    if (f19321f == null) {
                        f19321f = new d();
                    }
                }
            }
            return f19321f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f19322a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        b.a.r0.i0.i.a aVar;
        b.a.r0.i0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f19326e || (aVar = this.f19325d) == null || (bVar = aVar.f19302a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f19309c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        b.a.r0.i0.i.a aVar;
        b.a.r0.i0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f19326e || (aVar = this.f19325d) == null || (bVar = aVar.f19303b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f19309c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19326e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0977d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19326e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f19326e) {
            String b2 = b.a.r0.i0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f19324c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            b.a.r0.i0.i.a aVar = this.f19324c.get(b2);
            this.f19325d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b.a.r0.i0.i.a aVar2 = this.f19325d;
            if (currentTimeMillis - aVar2.f19305d <= 3600000 || currentTimeMillis - aVar2.f19304c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f19322a);
                TbadkCoreApplication.getInst().registerReceiver(this.f19322a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f19322a);
                TbadkCoreApplication.getInst().registerReceiver(this.f19322a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f19326e) {
                return;
            }
            b.a.r0.i0.i.c.h().i(new b(this));
        }
    }
}
