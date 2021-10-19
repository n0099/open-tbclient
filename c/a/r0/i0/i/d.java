package c.a.r0.i0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.f;
import c.a.q0.d1.q;
import c.a.r0.i0.e;
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
    public static d f19072f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f19073a;

    /* renamed from: b  reason: collision with root package name */
    public Object f19074b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.r0.i0.i.a> f19075c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.i0.i.a f19076d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19077e;

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
    public class b implements q<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f19078a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f19079e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f19080f;

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
                this.f19080f = bVar;
                this.f19079e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f19079e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.r0.i0.i.a a2 = c.a.r0.i0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f19057e, a2);
                            }
                        }
                    }
                    synchronized (this.f19080f.f19078a.f19074b) {
                        if (this.f19080f.f19078a.f19075c == null) {
                            this.f19080f.f19078a.f19075c = new ConcurrentHashMap();
                        }
                        this.f19080f.f19078a.f19075c.clear();
                        this.f19080f.f19078a.f19075c.putAll(hashMap);
                    }
                    this.f19080f.f19078a.f19077e = true;
                    this.f19080f.f19078a.s();
                    ArrayList<c.a.r0.i0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f19080f.f19078a.f19075c.entrySet()) {
                        if (this.f19080f.f19078a.f19076d != entry.getValue() && System.currentTimeMillis() - ((c.a.r0.i0.i.a) entry.getValue()).f19055c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.r0.i0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.r0.i0.i.a aVar : arrayList) {
                        this.f19080f.f19078a.f19075c.remove(aVar.f19057e);
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
            this.f19078a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
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
        public final /* synthetic */ String f19081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19083g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f19084h;

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
            this.f19084h = dVar;
            this.f19081e = str;
            this.f19082f = z;
            this.f19083g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19084h.f19076d != null) {
                    c.a.r0.i0.i.b bVar = this.f19084h.f19076d.f19053a.get(this.f19081e);
                    if (bVar == null) {
                        bVar = new c.a.r0.i0.i.b();
                        bVar.f19058a = this.f19081e;
                        this.f19084h.f19076d.f19053a.put(this.f19081e, bVar);
                    }
                    bVar.a(this.f19082f ? 1 : 0);
                    synchronized (this.f19084h.f19074b) {
                        hashMap = new HashMap(this.f19084h.f19075c);
                    }
                    c.a.r0.i0.i.c.h().j(hashMap);
                }
                if (this.f19083g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19081e);
                    intent.putExtra("result", this.f19082f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.r0.i0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0922d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f19088h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f19089i;

        public RunnableC0922d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f19089i = dVar;
            this.f19085e = str;
            this.f19086f = z;
            this.f19087g = i2;
            this.f19088h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19089i.f19076d == null) {
                    String b2 = c.a.r0.i0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.r0.i0.i.a aVar = new c.a.r0.i0.i.a();
                        aVar.f19057e = b2;
                        this.f19089i.f19076d = aVar;
                        this.f19089i.f19075c.put(b2, aVar);
                    }
                }
                if (this.f19089i.f19076d != null) {
                    c.a.r0.i0.i.b bVar = this.f19089i.f19076d.f19053a.get(this.f19085e);
                    if (bVar == null) {
                        bVar = new c.a.r0.i0.i.b();
                        bVar.f19058a = this.f19085e;
                        this.f19089i.f19076d.f19053a.put(this.f19085e, bVar);
                    }
                    bVar.a(this.f19086f ? 1 : 0);
                    if (this.f19086f) {
                        c.a.r0.i0.i.b bVar2 = this.f19089i.f19076d.f19054b.get(this.f19085e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.r0.i0.i.b();
                            bVar2.f19058a = this.f19085e;
                            this.f19089i.f19076d.f19054b.put(this.f19085e, bVar2);
                        }
                        bVar2.a(this.f19087g);
                    }
                    synchronized (this.f19089i.f19074b) {
                        hashMap = new HashMap(this.f19089i.f19075c);
                    }
                    c.a.r0.i0.i.c.h().j(hashMap);
                }
                if (this.f19088h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f19085e);
                    intent.putExtra("result", this.f19086f);
                    intent.putExtra("speed", this.f19087g);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1086238534, "Lc/a/r0/i0/i/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1086238534, "Lc/a/r0/i0/i/d;");
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
        this.f19073a = new a(this);
        this.f19074b = new Object();
        this.f19075c = null;
        this.f19076d = null;
        this.f19077e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f19072f == null) {
                synchronized (d.class) {
                    if (f19072f == null) {
                        f19072f = new d();
                    }
                }
            }
            return f19072f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f19073a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.i0.i.a aVar;
        c.a.r0.i0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f19077e || (aVar = this.f19076d) == null || (bVar = aVar.f19053a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f19060c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.i0.i.a aVar;
        c.a.r0.i0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f19077e || (aVar = this.f19076d) == null || (bVar = aVar.f19054b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f19060c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19077e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0922d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f19077e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f19077e) {
            String b2 = c.a.r0.i0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f19075c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.r0.i0.i.a aVar = this.f19075c.get(b2);
            this.f19076d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.r0.i0.i.a aVar2 = this.f19076d;
            if (currentTimeMillis - aVar2.f19056d <= 3600000 || currentTimeMillis - aVar2.f19055c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f19073a);
                TbadkCoreApplication.getInst().registerReceiver(this.f19073a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f19073a);
                TbadkCoreApplication.getInst().registerReceiver(this.f19073a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f19077e) {
                return;
            }
            c.a.r0.i0.i.c.h().i(new b(this));
        }
    }
}
