package c.a.r0.o0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.f;
import c.a.q0.c1.s;
import c.a.r0.o0.e;
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
    public static d f19630f;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: b  reason: collision with root package name */
    public Object f19631b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.r0.o0.i.a> f19632c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.o0.i.a f19633d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19634e;

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

    /* loaded from: classes2.dex */
    public class b implements s<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f19635e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f19636f;

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
                this.f19636f = bVar;
                this.f19635e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f19635e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.r0.o0.i.a a = c.a.r0.o0.i.a.a(connectPointData);
                            if (a != null) {
                                hashMap.put(a.f19620e, a);
                            }
                        }
                    }
                    synchronized (this.f19636f.a.f19631b) {
                        if (this.f19636f.a.f19632c == null) {
                            this.f19636f.a.f19632c = new ConcurrentHashMap();
                        }
                        this.f19636f.a.f19632c.clear();
                        this.f19636f.a.f19632c.putAll(hashMap);
                    }
                    this.f19636f.a.f19634e = true;
                    this.f19636f.a.s();
                    ArrayList<c.a.r0.o0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f19636f.a.f19632c.entrySet()) {
                        if (this.f19636f.a.f19633d != entry.getValue() && System.currentTimeMillis() - ((c.a.r0.o0.i.a) entry.getValue()).f19618c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.r0.o0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.r0.o0.i.a aVar : arrayList) {
                        this.f19636f.a.f19632c.remove(aVar.f19620e);
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
        @Override // c.a.q0.c1.s
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19638f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19639g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f19640h;

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
            this.f19640h = dVar;
            this.f19637e = str;
            this.f19638f = z;
            this.f19639g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19640h.f19633d != null) {
                    c.a.r0.o0.i.b bVar = this.f19640h.f19633d.a.get(this.f19637e);
                    if (bVar == null) {
                        bVar = new c.a.r0.o0.i.b();
                        bVar.a = this.f19637e;
                        this.f19640h.f19633d.a.put(this.f19637e, bVar);
                    }
                    bVar.a(this.f19638f ? 1 : 0);
                    synchronized (this.f19640h.f19631b) {
                        hashMap = new HashMap(this.f19640h.f19632c);
                    }
                    c.a.r0.o0.i.c.h().j(hashMap);
                }
                if (this.f19639g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19637e);
                    intent.putExtra("result", this.f19638f);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.r0.o0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1232d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19642f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19643g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f19644h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f19645i;

        public RunnableC1232d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f19645i = dVar;
            this.f19641e = str;
            this.f19642f = z;
            this.f19643g = i2;
            this.f19644h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19645i.f19633d == null) {
                    String b2 = c.a.r0.o0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.r0.o0.i.a aVar = new c.a.r0.o0.i.a();
                        aVar.f19620e = b2;
                        this.f19645i.f19633d = aVar;
                        this.f19645i.f19632c.put(b2, aVar);
                    }
                }
                if (this.f19645i.f19633d != null) {
                    c.a.r0.o0.i.b bVar = this.f19645i.f19633d.a.get(this.f19641e);
                    if (bVar == null) {
                        bVar = new c.a.r0.o0.i.b();
                        bVar.a = this.f19641e;
                        this.f19645i.f19633d.a.put(this.f19641e, bVar);
                    }
                    bVar.a(this.f19642f ? 1 : 0);
                    if (this.f19642f) {
                        c.a.r0.o0.i.b bVar2 = this.f19645i.f19633d.f19617b.get(this.f19641e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.r0.o0.i.b();
                            bVar2.a = this.f19641e;
                            this.f19645i.f19633d.f19617b.put(this.f19641e, bVar2);
                        }
                        bVar2.a(this.f19643g);
                    }
                    synchronized (this.f19645i.f19631b) {
                        hashMap = new HashMap(this.f19645i.f19632c);
                    }
                    c.a.r0.o0.i.c.h().j(hashMap);
                }
                if (this.f19644h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19641e);
                    intent.putExtra("result", this.f19642f);
                    intent.putExtra("speed", this.f19643g);
                    f.a(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56183744, "Lc/a/r0/o0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56183744, "Lc/a/r0/o0/i/d;");
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
        this.f19631b = new Object();
        this.f19632c = null;
        this.f19633d = null;
        this.f19634e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f19630f == null) {
                synchronized (d.class) {
                    if (f19630f == null) {
                        f19630f = new d();
                    }
                }
            }
            return f19630f;
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
        c.a.r0.o0.i.a aVar;
        c.a.r0.o0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f19634e || (aVar = this.f19633d) == null || (bVar = aVar.a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f19622c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.o0.i.a aVar;
        c.a.r0.o0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f19634e || (aVar = this.f19633d) == null || (bVar = aVar.f19617b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f19622c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19634e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC1232d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19634e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f19634e) {
            String b2 = c.a.r0.o0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f19632c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.r0.o0.i.a aVar = this.f19632c.get(b2);
            this.f19633d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.r0.o0.i.a aVar2 = this.f19633d;
            if (currentTimeMillis - aVar2.f19619d <= 3600000 || currentTimeMillis - aVar2.f19618c >= 3600000) {
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
            if (this.f19634e) {
                return;
            }
            c.a.r0.o0.i.c.h().i(new b(this));
        }
    }
}
