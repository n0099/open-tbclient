package c.a.p0.h0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.f;
import c.a.o0.b1.n;
import c.a.p0.h0.e;
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
    public static d f18149f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f18150a;

    /* renamed from: b  reason: collision with root package name */
    public Object f18151b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.p0.h0.i.a> f18152c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h0.i.a f18153d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18154e;

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
        public final /* synthetic */ d f18155a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f18156e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f18157f;

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
                this.f18157f = bVar;
                this.f18156e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f18156e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.p0.h0.i.a a2 = c.a.p0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f18134e, a2);
                            }
                        }
                    }
                    synchronized (this.f18157f.f18155a.f18151b) {
                        if (this.f18157f.f18155a.f18152c == null) {
                            this.f18157f.f18155a.f18152c = new ConcurrentHashMap();
                        }
                        this.f18157f.f18155a.f18152c.clear();
                        this.f18157f.f18155a.f18152c.putAll(hashMap);
                    }
                    this.f18157f.f18155a.f18154e = true;
                    this.f18157f.f18155a.s();
                    ArrayList<c.a.p0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f18157f.f18155a.f18152c.entrySet()) {
                        if (this.f18157f.f18155a.f18153d != entry.getValue() && System.currentTimeMillis() - ((c.a.p0.h0.i.a) entry.getValue()).f18132c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.p0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.p0.h0.i.a aVar : arrayList) {
                        this.f18157f.f18155a.f18152c.remove(aVar.f18134e);
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
            this.f18155a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.n
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
        public final /* synthetic */ String f18158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18159f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f18160g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f18161h;

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
            this.f18161h = dVar;
            this.f18158e = str;
            this.f18159f = z;
            this.f18160g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18161h.f18153d != null) {
                    c.a.p0.h0.i.b bVar = this.f18161h.f18153d.f18130a.get(this.f18158e);
                    if (bVar == null) {
                        bVar = new c.a.p0.h0.i.b();
                        bVar.f18135a = this.f18158e;
                        this.f18161h.f18153d.f18130a.put(this.f18158e, bVar);
                    }
                    bVar.a(this.f18159f ? 1 : 0);
                    synchronized (this.f18161h.f18151b) {
                        hashMap = new HashMap(this.f18161h.f18152c);
                    }
                    c.a.p0.h0.i.c.h().j(hashMap);
                }
                if (this.f18160g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18158e);
                    intent.putExtra("result", this.f18159f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.p0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0878d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18163f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18164g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f18165h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f18166i;

        public RunnableC0878d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f18166i = dVar;
            this.f18162e = str;
            this.f18163f = z;
            this.f18164g = i2;
            this.f18165h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18166i.f18153d == null) {
                    String b2 = c.a.p0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.p0.h0.i.a aVar = new c.a.p0.h0.i.a();
                        aVar.f18134e = b2;
                        this.f18166i.f18153d = aVar;
                        this.f18166i.f18152c.put(b2, aVar);
                    }
                }
                if (this.f18166i.f18153d != null) {
                    c.a.p0.h0.i.b bVar = this.f18166i.f18153d.f18130a.get(this.f18162e);
                    if (bVar == null) {
                        bVar = new c.a.p0.h0.i.b();
                        bVar.f18135a = this.f18162e;
                        this.f18166i.f18153d.f18130a.put(this.f18162e, bVar);
                    }
                    bVar.a(this.f18163f ? 1 : 0);
                    if (this.f18163f) {
                        c.a.p0.h0.i.b bVar2 = this.f18166i.f18153d.f18131b.get(this.f18162e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.p0.h0.i.b();
                            bVar2.f18135a = this.f18162e;
                            this.f18166i.f18153d.f18131b.put(this.f18162e, bVar2);
                        }
                        bVar2.a(this.f18164g);
                    }
                    synchronized (this.f18166i.f18151b) {
                        hashMap = new HashMap(this.f18166i.f18152c);
                    }
                    c.a.p0.h0.i.c.h().j(hashMap);
                }
                if (this.f18165h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18162e);
                    intent.putExtra("result", this.f18163f);
                    intent.putExtra("speed", this.f18164g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1580715205, "Lc/a/p0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1580715205, "Lc/a/p0/h0/i/d;");
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
        this.f18150a = new a(this);
        this.f18151b = new Object();
        this.f18152c = null;
        this.f18153d = null;
        this.f18154e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f18149f == null) {
                synchronized (d.class) {
                    if (f18149f == null) {
                        f18149f = new d();
                    }
                }
            }
            return f18149f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f18150a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.p0.h0.i.a aVar;
        c.a.p0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f18154e || (aVar = this.f18153d) == null || (bVar = aVar.f18130a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f18137c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.p0.h0.i.a aVar;
        c.a.p0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f18154e || (aVar = this.f18153d) == null || (bVar = aVar.f18131b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f18137c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18154e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0878d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18154e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18154e) {
            String b2 = c.a.p0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f18152c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.p0.h0.i.a aVar = this.f18152c.get(b2);
            this.f18153d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.h0.i.a aVar2 = this.f18153d;
            if (currentTimeMillis - aVar2.f18133d <= 3600000 || currentTimeMillis - aVar2.f18132c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18150a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18150a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18150a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18150a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f18154e) {
                return;
            }
            c.a.p0.h0.i.c.h().i(new b(this));
        }
    }
}
