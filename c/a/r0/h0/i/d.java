package c.a.r0.h0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.f;
import c.a.q0.d1.r;
import c.a.r0.h0.e;
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
    public static d f18901f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f18902a;

    /* renamed from: b  reason: collision with root package name */
    public Object f18903b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.r0.h0.i.a> f18904c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h0.i.a f18905d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18906e;

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
    public class b implements r<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f18907a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f18908e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f18909f;

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
                this.f18909f = bVar;
                this.f18908e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f18908e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.r0.h0.i.a a2 = c.a.r0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f18886e, a2);
                            }
                        }
                    }
                    synchronized (this.f18909f.f18907a.f18903b) {
                        if (this.f18909f.f18907a.f18904c == null) {
                            this.f18909f.f18907a.f18904c = new ConcurrentHashMap();
                        }
                        this.f18909f.f18907a.f18904c.clear();
                        this.f18909f.f18907a.f18904c.putAll(hashMap);
                    }
                    this.f18909f.f18907a.f18906e = true;
                    this.f18909f.f18907a.s();
                    ArrayList<c.a.r0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f18909f.f18907a.f18904c.entrySet()) {
                        if (this.f18909f.f18907a.f18905d != entry.getValue() && System.currentTimeMillis() - ((c.a.r0.h0.i.a) entry.getValue()).f18884c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.r0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.r0.h0.i.a aVar : arrayList) {
                        this.f18909f.f18907a.f18904c.remove(aVar.f18886e);
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
            this.f18907a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.r
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
        public final /* synthetic */ String f18910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f18912g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f18913h;

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
            this.f18913h = dVar;
            this.f18910e = str;
            this.f18911f = z;
            this.f18912g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18913h.f18905d != null) {
                    c.a.r0.h0.i.b bVar = this.f18913h.f18905d.f18882a.get(this.f18910e);
                    if (bVar == null) {
                        bVar = new c.a.r0.h0.i.b();
                        bVar.f18887a = this.f18910e;
                        this.f18913h.f18905d.f18882a.put(this.f18910e, bVar);
                    }
                    bVar.a(this.f18911f ? 1 : 0);
                    synchronized (this.f18913h.f18903b) {
                        hashMap = new HashMap(this.f18913h.f18904c);
                    }
                    c.a.r0.h0.i.c.h().j(hashMap);
                }
                if (this.f18912g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18910e);
                    intent.putExtra("result", this.f18911f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.r0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0913d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18916g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f18917h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f18918i;

        public RunnableC0913d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f18918i = dVar;
            this.f18914e = str;
            this.f18915f = z;
            this.f18916g = i2;
            this.f18917h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18918i.f18905d == null) {
                    String b2 = c.a.r0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.r0.h0.i.a aVar = new c.a.r0.h0.i.a();
                        aVar.f18886e = b2;
                        this.f18918i.f18905d = aVar;
                        this.f18918i.f18904c.put(b2, aVar);
                    }
                }
                if (this.f18918i.f18905d != null) {
                    c.a.r0.h0.i.b bVar = this.f18918i.f18905d.f18882a.get(this.f18914e);
                    if (bVar == null) {
                        bVar = new c.a.r0.h0.i.b();
                        bVar.f18887a = this.f18914e;
                        this.f18918i.f18905d.f18882a.put(this.f18914e, bVar);
                    }
                    bVar.a(this.f18915f ? 1 : 0);
                    if (this.f18915f) {
                        c.a.r0.h0.i.b bVar2 = this.f18918i.f18905d.f18883b.get(this.f18914e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.r0.h0.i.b();
                            bVar2.f18887a = this.f18914e;
                            this.f18918i.f18905d.f18883b.put(this.f18914e, bVar2);
                        }
                        bVar2.a(this.f18916g);
                    }
                    synchronized (this.f18918i.f18903b) {
                        hashMap = new HashMap(this.f18918i.f18904c);
                    }
                    c.a.r0.h0.i.c.h().j(hashMap);
                }
                if (this.f18917h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18914e);
                    intent.putExtra("result", this.f18915f);
                    intent.putExtra("speed", this.f18916g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1973742215, "Lc/a/r0/h0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1973742215, "Lc/a/r0/h0/i/d;");
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
        this.f18902a = new a(this);
        this.f18903b = new Object();
        this.f18904c = null;
        this.f18905d = null;
        this.f18906e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f18901f == null) {
                synchronized (d.class) {
                    if (f18901f == null) {
                        f18901f = new d();
                    }
                }
            }
            return f18901f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f18902a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.h0.i.a aVar;
        c.a.r0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f18906e || (aVar = this.f18905d) == null || (bVar = aVar.f18882a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f18889c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.h0.i.a aVar;
        c.a.r0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f18906e || (aVar = this.f18905d) == null || (bVar = aVar.f18883b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f18889c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18906e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0913d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18906e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18906e) {
            String b2 = c.a.r0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f18904c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.r0.h0.i.a aVar = this.f18904c.get(b2);
            this.f18905d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.r0.h0.i.a aVar2 = this.f18905d;
            if (currentTimeMillis - aVar2.f18885d <= 3600000 || currentTimeMillis - aVar2.f18884c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18902a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18902a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18902a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18902a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f18906e) {
                return;
            }
            c.a.r0.h0.i.c.h().i(new b(this));
        }
    }
}
