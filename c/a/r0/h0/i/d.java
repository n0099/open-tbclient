package c.a.r0.h0.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.f;
import c.a.q0.d1.o;
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
    public static d f18892f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f18893a;

    /* renamed from: b  reason: collision with root package name */
    public Object f18894b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.a.r0.h0.i.a> f18895c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h0.i.a f18896d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18897e;

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
    public class b implements o<WriteHistroyDataReqIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f18898a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WriteHistroyDataReqIdl f18899e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f18900f;

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
                this.f18900f = bVar;
                this.f18899e = writeHistroyDataReqIdl;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    WriteHistroyDataReqIdl writeHistroyDataReqIdl = this.f18899e;
                    if (writeHistroyDataReqIdl != null) {
                        for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                            c.a.r0.h0.i.a a2 = c.a.r0.h0.i.a.a(connectPointData);
                            if (a2 != null) {
                                hashMap.put(a2.f18877e, a2);
                            }
                        }
                    }
                    synchronized (this.f18900f.f18898a.f18894b) {
                        if (this.f18900f.f18898a.f18895c == null) {
                            this.f18900f.f18898a.f18895c = new ConcurrentHashMap();
                        }
                        this.f18900f.f18898a.f18895c.clear();
                        this.f18900f.f18898a.f18895c.putAll(hashMap);
                    }
                    this.f18900f.f18898a.f18897e = true;
                    this.f18900f.f18898a.s();
                    ArrayList<c.a.r0.h0.i.a> arrayList = new ArrayList();
                    for (Map.Entry entry : this.f18900f.f18898a.f18895c.entrySet()) {
                        if (this.f18900f.f18898a.f18896d != entry.getValue() && System.currentTimeMillis() - ((c.a.r0.h0.i.a) entry.getValue()).f18875c > 604800000) {
                            arrayList.add(entry.getValue());
                            c.a.r0.h0.d.c().b("conpoint_remove", "out_time", (String) entry.getKey());
                        }
                    }
                    for (c.a.r0.h0.i.a aVar : arrayList) {
                        this.f18900f.f18898a.f18895c.remove(aVar.f18877e);
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
            this.f18898a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.o
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
        public final /* synthetic */ String f18901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18902f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f18903g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f18904h;

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
            this.f18904h = dVar;
            this.f18901e = str;
            this.f18902f = z;
            this.f18903g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18904h.f18896d != null) {
                    c.a.r0.h0.i.b bVar = this.f18904h.f18896d.f18873a.get(this.f18901e);
                    if (bVar == null) {
                        bVar = new c.a.r0.h0.i.b();
                        bVar.f18878a = this.f18901e;
                        this.f18904h.f18896d.f18873a.put(this.f18901e, bVar);
                    }
                    bVar.a(this.f18902f ? 1 : 0);
                    synchronized (this.f18904h.f18894b) {
                        hashMap = new HashMap(this.f18904h.f18895c);
                    }
                    c.a.r0.h0.i.c.h().j(hashMap);
                }
                if (this.f18903g) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18901e);
                    intent.putExtra("result", this.f18902f);
                    f.b(TbadkCoreApplication.getInst().getContext(), intent);
                }
            }
        }
    }

    /* renamed from: c.a.r0.h0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0915d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f18906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18907g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f18908h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f18909i;

        public RunnableC0915d(d dVar, String str, boolean z, int i2, boolean z2) {
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
            this.f18909i = dVar;
            this.f18905e = str;
            this.f18906f = z;
            this.f18907g = i2;
            this.f18908h = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18909i.f18896d == null) {
                    String b2 = c.a.r0.h0.i.a.b();
                    if (!TextUtils.isEmpty(b2)) {
                        c.a.r0.h0.i.a aVar = new c.a.r0.h0.i.a();
                        aVar.f18877e = b2;
                        this.f18909i.f18896d = aVar;
                        this.f18909i.f18895c.put(b2, aVar);
                    }
                }
                if (this.f18909i.f18896d != null) {
                    c.a.r0.h0.i.b bVar = this.f18909i.f18896d.f18873a.get(this.f18905e);
                    if (bVar == null) {
                        bVar = new c.a.r0.h0.i.b();
                        bVar.f18878a = this.f18905e;
                        this.f18909i.f18896d.f18873a.put(this.f18905e, bVar);
                    }
                    bVar.a(this.f18906f ? 1 : 0);
                    if (this.f18906f) {
                        c.a.r0.h0.i.b bVar2 = this.f18909i.f18896d.f18874b.get(this.f18905e);
                        if (bVar2 == null) {
                            bVar2 = new c.a.r0.h0.i.b();
                            bVar2.f18878a = this.f18905e;
                            this.f18909i.f18896d.f18874b.put(this.f18905e, bVar2);
                        }
                        bVar2.a(this.f18907g);
                    }
                    synchronized (this.f18909i.f18894b) {
                        hashMap = new HashMap(this.f18909i.f18895c);
                    }
                    c.a.r0.h0.i.c.h().j(hashMap);
                }
                if (this.f18908h) {
                    Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                    intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                    intent.putExtra("ip", this.f18905e);
                    intent.putExtra("result", this.f18906f);
                    intent.putExtra("speed", this.f18907g);
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
        this.f18893a = new a(this);
        this.f18894b = new Object();
        this.f18895c = null;
        this.f18896d = null;
        this.f18897e = false;
    }

    public static final d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f18892f == null) {
                synchronized (d.class) {
                    if (f18892f == null) {
                        f18892f = new d();
                    }
                }
            }
            return f18892f;
        }
        return (d) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.f18893a);
        }
    }

    public float k(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.h0.i.a aVar;
        c.a.r0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!this.f18897e || (aVar = this.f18896d) == null || (bVar = aVar.f18873a.get(str2)) == null) {
                return 0.0f;
            }
            return bVar.f18880c;
        }
        return invokeLL.floatValue;
    }

    public float l(String str, String str2) {
        InterceptResult invokeLL;
        c.a.r0.h0.i.a aVar;
        c.a.r0.h0.i.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!this.f18897e || (aVar = this.f18896d) == null || (bVar = aVar.f18874b.get(str2)) == null) {
                return 10000.0f;
            }
            return bVar.f18880c;
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
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18897e && !TextUtils.isEmpty(str)) {
            e.i().o(new RunnableC0915d(this, str, z, i2, z2));
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
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f18897e && !TextUtils.isEmpty(str)) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18897e) {
            String b2 = c.a.r0.h0.i.a.b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (!this.f18895c.containsKey(b2)) {
                e.i().g(false);
                return;
            }
            c.a.r0.h0.i.a aVar = this.f18895c.get(b2);
            this.f18896d = aVar;
            if (aVar == null) {
                e.i().g(false);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.r0.h0.i.a aVar2 = this.f18896d;
            if (currentTimeMillis - aVar2.f18876d <= 3600000 || currentTimeMillis - aVar2.f18875c >= 3600000) {
                return;
            }
            e.i().g(false);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18893a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18893a, new IntentFilter("action_sub_process_ip_data_change"));
            } else {
                TbadkCoreApplication.getInst().unregisterReceiver(this.f18893a);
                TbadkCoreApplication.getInst().registerReceiver(this.f18893a, new IntentFilter("action_main_process_ip_data_change"));
            }
            if (this.f18897e) {
                return;
            }
            c.a.r0.h0.i.c.h().i(new b(this));
        }
    }
}
