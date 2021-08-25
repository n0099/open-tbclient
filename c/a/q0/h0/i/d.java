package c.a.q0.h0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.f;
import c.a.p0.b1.n;
import c.a.q0.h0.e;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static d f18482f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f18483a;

    /* renamed from: b  reason: collision with root package name */
    public Object f18484b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.q0.h0.i.a> f18485c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.h0.i.a f18486d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18487e;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements n<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f18488a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f18489e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f18490f;

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
                this.f18490f = bVar;
                this.f18489e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f18489e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.q0.h0.i.a a2 = c.a.q0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f18467e, a2);
                            }
                        }
                    }
                    synchronized (this.f18490f.f18488a.f18484b) {
                        if (this.f18490f.f18488a.f18485c == null) {
                            this.f18490f.f18488a.f18485c = new ConcurrentHashMap();
                        }
                        this.f18490f.f18488a.f18485c.clear();
                        this.f18490f.f18488a.f18485c.putAll(hashMap);
                    }
                    this.f18490f.f18488a.f18487e = true;
                    this.f18490f.f18488a.s();
                    ArrayList<c.a.q0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f18490f.f18488a.f18485c.entrySet()) {
                        if (this.f18490f.f18488a.f18486d != entry.getValue() && System.currentTimeMillis() - ((c.a.q0.h0.i.a) entry.getValue()).f18465c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.q0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.q0.h0.i.a aVar : arrayList) {
                        this.f18490f.f18488a.f18485c.remove(aVar.f18467e);
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
            this.f18488a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeHistroyDataReqIdl) == null) {
                e.i().o(new a(this, writeHistroyDataReqIdl));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18491e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18492f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f18493g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f18494h;

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
            this.f18494h = dVar;
            this.f18491e = str;
            this.f18492f = z;
            this.f18493g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18494h.f18486d != null) {
                    c.a.q0.h0.i.b bVar = this.f18494h.f18486d.f18463a.get(this.f18491e);
                    if (bVar == null) {
                        bVar = new c.a.q0.h0.i.b();
                        bVar.f18468a = this.f18491e;
                        this.f18494h.f18486d.f18463a.put(this.f18491e, bVar);
                    }
                    bVar.a(this.f18492f ? 1 : 0);
                    synchronized (this.f18494h.f18484b) {
                        hashMap = new HashMap(this.f18494h.f18485c);
                    }
                    c.a.q0.h0.i.c.h().j(hashMap);
                }
                if (this.f18493g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18491e);
                    intent.putExtra("result", this.f18492f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.q0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0889d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18496f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18497g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f18498h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f18499i;

        public RunnableC0889d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f18499i = dVar;
            this.f18495e = str;
            this.f18496f = z;
            this.f18497g = i2;
            this.f18498h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18499i.f18486d == null) {
                    String b2 = c.a.q0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.q0.h0.i.a aVar = new c.a.q0.h0.i.a();
                        aVar.f18467e = b2;
                        this.f18499i.f18486d = aVar;
                        this.f18499i.f18485c.put(b2, aVar);
                    }
                }
                if (this.f18499i.f18486d != null) {
                    c.a.q0.h0.i.b bVar = this.f18499i.f18486d.f18463a.get(this.f18495e);
                    if (bVar == null) {
                        bVar = new c.a.q0.h0.i.b();
                        bVar.f18468a = this.f18495e;
                        this.f18499i.f18486d.f18463a.put(this.f18495e, bVar);
                    }
                    bVar.a(this.f18496f ? 1 : 0);
                    if (this.f18496f) {
                        c.a.q0.h0.i.b bVar2 = this.f18499i.f18486d.f18464b.get(this.f18495e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.q0.h0.i.b();
                            bVar2.f18468a = this.f18495e;
                            this.f18499i.f18486d.f18464b.put(this.f18495e, bVar2);
                        }
                        bVar2.a(this.f18497g);
                    }
                    synchronized (this.f18499i.f18484b) {
                        hashMap = new HashMap(this.f18499i.f18485c);
                    }
                    c.a.q0.h0.i.c.h().j(hashMap);
                }
                if (this.f18498h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18495e);
                    intent.putExtra("result", this.f18496f);
                    intent.putExtra("speed", this.f18497g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1777228710, "Lc/a/q0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1777228710, "Lc/a/q0/h0/i/d;");
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
        this.f18483a = new a(this);
        this.f18484b = new Object();
        this.f18485c = null;
        this.f18486d = null;
        this.f18487e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f18482f == null) {
                synchronized (d.class) {
                    if (f18482f == null) {
                        f18482f = new d();
                    }
                }
            }
            return f18482f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f18483a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.q0.h0.i.a aVar;
        c.a.q0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f18487e || (aVar = this.f18486d) == null || (bVar = aVar.f18463a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f18470c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.q0.h0.i.a aVar;
        c.a.q0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f18487e || (aVar = this.f18486d) == null || (bVar = aVar.f18464b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f18470c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18487e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0889d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18487e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18487e) {
            String b2 = c.a.q0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f18485c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.q0.h0.i.a aVar = this.f18485c.get(b2);
            this.f18486d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.q0.h0.i.a aVar2 = this.f18486d;
            if (currentTimeMillis - aVar2.f18466d <= 3600000 || currentTimeMillis - aVar2.f18465c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18483a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18483a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18483a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18483a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f18487e) {
                return;
            }
            c.a.q0.h0.i.c.h().i(new b(this));
        }
    }
}
