package c.a.t0.o0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import com.baidu.tieba.dnsproxy.DnsProxyStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static e m;
    public static final Random n;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f20059b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f20060c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<DnsProxyResponseData.DnsProxyIpData>> f20061d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f20062e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f20063f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f20064g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f20065h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f20066i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f20067j;
    public long k;
    public c.a.t0.o0.c l;

    /* loaded from: classes8.dex */
    public class a implements Comparator<DnsProxyResponseData.DnsProxyIpData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20068e;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20068e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dnsProxyIpData, dnsProxyIpData2)) == null) {
                if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                    return 0;
                }
                if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                    if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                        return c.a.t0.o0.i.d.m().l(this.f20068e, dnsProxyIpData.getIp()) - c.a.t0.o0.i.d.m().l(this.f20068e, dnsProxyIpData2.getIp()) >= 0.0f ? 1 : -1;
                    }
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Comparator<DnsProxyResponseData.DnsProxyIpData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20069e;

        public b(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20069e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dnsProxyIpData, dnsProxyIpData2)) == null) {
                if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                    return 0;
                }
                if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                    if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                        return c.a.t0.o0.i.d.m().k(this.f20069e, dnsProxyIpData.getIp()) - c.a.t0.o0.i.d.m().k(this.f20069e, dnsProxyIpData2.getIp()) >= 0.0f ? -1 : 1;
                    }
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public c(e eVar) {
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
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "com.baidu.tieba.dnsproxy.dnsproxydata".equals(intent.getAction())) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        return;
                    }
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (String str : extras.keySet()) {
                        JSONArray jSONArray = new JSONArray(extras.getString(str));
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < length; i2++) {
                            DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = (DnsProxyResponseData.DnsProxyIpData) OrmObject.objectWithJson(jSONArray.getJSONObject(i2), DnsProxyResponseData.DnsProxyIpData.class);
                            if (dnsProxyIpData != null) {
                                arrayList.add(dnsProxyIpData);
                            }
                        }
                        concurrentHashMap.put(str, arrayList);
                    }
                    if (concurrentHashMap.size() > 0) {
                        this.this$0.f20060c.clear();
                        this.this$0.f20060c.putAll(concurrentHashMap);
                        this.this$0.l(true);
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    c.a.t0.o0.d.c().a("dpm_broadcast", th.getMessage());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.z()) {
                c.a.t0.o0.i.d.m().r();
                this.a.k();
            }
        }
    }

    /* renamed from: c.a.t0.o0.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1260e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1260e(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.f20067j);
                    DnsProxyStatic.h();
                    DnsProxyStatic.g();
                    c.a.t0.o0.i.c.h().k();
                    return;
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f20070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f20071f;

        public f(e eVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20071f = eVar;
            this.f20070e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20071f.o(this.f20070e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20072e;

        public g(e eVar) {
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
            this.f20072e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20072e.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends c.a.t0.o0.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public h(e eVar) {
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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                super.onPostExecute(hashMap);
                this.a.f20061d.clear();
                if (hashMap != null) {
                    this.a.f20061d.putAll(hashMap);
                    this.a.l(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f20074f;

        public i(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20074f = eVar;
            this.f20073e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20074f.g(this.f20073e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends c.a.t0.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f20075b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(e eVar, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20075b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
                super.onPostExecute(hashMap);
                this.f20075b.l = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>... hashMapArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMapArr) == null) {
                super.onProgressUpdate(hashMapArr);
                if (hashMapArr != null && hashMapArr.length > 0) {
                    if (hashMapArr[0] != null) {
                        e(hashMapArr[0]);
                    } else if (this.a) {
                        this.f20075b.l = null;
                        this.f20075b.g(false);
                    }
                } else if (this.a) {
                    this.f20075b.l = null;
                    this.f20075b.g(false);
                }
            }
        }

        public final void e(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                this.f20075b.f20060c.clear();
                if (hashMap != null) {
                    this.f20075b.f20060c.putAll(hashMap);
                    this.f20075b.l(true);
                    if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                        Intent intent = new Intent();
                        intent.setAction("com.baidu.tieba.dnsproxy.dnsproxydata");
                        for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry : hashMap.entrySet()) {
                            JSONArray jSONArray = new JSONArray();
                            for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : entry.getValue()) {
                                try {
                                    jSONArray.put(OrmObject.jsonWithObject(dnsProxyIpData));
                                } catch (Throwable th) {
                                    BdLog.detailException(th);
                                }
                            }
                            intent.putExtra(entry.getKey(), jSONArray.toString());
                        }
                        intent.setPackage(TbadkCoreApplication.getInst().getContext().getPackageName());
                        c.a.d.f.m.f.a(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f20076e;

        public k(e eVar) {
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
            this.f20076e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20076e.k();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(982771575, "Lc/a/t0/o0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(982771575, "Lc/a/t0/o0/e;");
                return;
            }
        }
        n = new Random();
    }

    public e() {
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
        this.a = new HashSet<>();
        this.f20059b = new ConcurrentHashMap();
        this.f20060c = new ConcurrentHashMap();
        this.f20061d = new ConcurrentHashMap();
        this.f20062e = new c(this);
        this.f20063f = new d(this, 2000994);
        this.f20064g = new C1260e(this, 2001011);
        this.f20065h = null;
        this.f20066i = new HandlerThread(e.class.getName());
        this.f20067j = new g(this);
        this.k = 0L;
        this.l = null;
        this.f20066i.start();
    }

    public static final e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (m == null) {
                synchronized (e.class) {
                    if (m == null) {
                        m = new e();
                    }
                }
            }
            return m;
        }
        return (e) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            c.a.t0.o0.i.d.m().j();
            c.a.d.f.m.e.a().removeCallbacks(this.f20067j);
            MessageManager.getInstance().unRegisterListener(this.f20063f);
            MessageManager.getInstance().unRegisterListener(this.f20064g);
            TbadkCoreApplication.getInst().unregisterReceiver(this.f20062e);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
                if (!n.B()) {
                    c.a.d.f.m.e.a().post(new i(this, z));
                } else if (this.l == null && System.currentTimeMillis() - this.k >= 5000) {
                    if (!z) {
                        this.k = System.currentTimeMillis();
                    }
                    j jVar = new j(this, z);
                    this.l = jVar;
                    jVar.execute(new HashSet(this.a));
                }
            }
        }
    }

    public String h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (!TextUtils.isEmpty(str) && this.a.contains(str)) {
                String m2 = m(str, this.f20059b, z);
                return !TextUtils.isEmpty(m2) ? m2 : m(str, this.f20060c, z);
            }
            return null;
        }
        return (String) invokeLZ.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new h(this).execute(new HashSet(this.a));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j();
            c.a.d.f.m.e.a().removeCallbacks(this.f20067j);
            c.a.d.f.m.e.a().postDelayed(this.f20067j, 300000L);
        }
    }

    public final void l(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                map = this.f20060c;
                map2 = this.f20061d;
            } else {
                map = this.f20061d;
                map2 = this.f20060c;
            }
            for (String str : map.keySet()) {
                List<DnsProxyResponseData.DnsProxyIpData> list = map.get(str);
                List<DnsProxyResponseData.DnsProxyIpData> list2 = map2.get(str);
                HashSet<String> hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                if (list != null) {
                    for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                        if (dnsProxyIpData != null && c.a.t0.o0.h.a(dnsProxyIpData.getIp())) {
                            hashSet2.add(dnsProxyIpData.getIp());
                        }
                    }
                }
                if (list2 != null) {
                    for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                        if (dnsProxyIpData2 != null && c.a.t0.o0.h.a(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
                            hashSet.add(dnsProxyIpData2.getIp());
                        }
                    }
                }
                ArrayList arrayList = new ArrayList(hashSet.size());
                for (String str2 : hashSet) {
                    DnsProxyResponseData.DnsProxyIpData dnsProxyIpData3 = new DnsProxyResponseData.DnsProxyIpData();
                    dnsProxyIpData3.setIp(str2);
                    arrayList.add(dnsProxyIpData3);
                }
                this.f20059b.put(str, arrayList);
            }
        }
    }

    public final String m(String str, Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map, boolean z) {
        InterceptResult invokeLLZ;
        List<DnsProxyResponseData.DnsProxyIpData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, str, map, z)) == null) {
            if (!TextUtils.isEmpty(str) && map != null && (list = map.get(str)) != null && list.size() > 0) {
                if (list.size() == 1) {
                    String ip = list.get(0).getIp();
                    if (n.nextFloat() < c.a.t0.o0.i.d.m().k("c.tieba.baidu.com", ip)) {
                        return ip;
                    }
                } else {
                    if (z) {
                        Collections.sort(list, new a(this, str));
                    } else {
                        Collections.sort(list, new b(this, str));
                    }
                    for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                        if (dnsProxyIpData != null && c.a.t0.o0.h.a(dnsProxyIpData.getIp())) {
                            String ip2 = dnsProxyIpData.getIp();
                            if (n.nextFloat() < c.a.t0.o0.i.d.m().k("c.tieba.baidu.com", ip2)) {
                                return ip2;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return (String) invokeLLZ.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.add("c.tieba.baidu.com");
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().unRegisterListener(this.f20063f);
                MessageManager.getInstance().registerListener(this.f20063f);
            }
            MessageManager.getInstance().unRegisterListener(this.f20064g);
            MessageManager.getInstance().registerListener(this.f20064g);
            c.a.t0.o0.i.d.m().t();
            c.a.d.f.m.e.a().post(new k(this));
            g(true);
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                return;
            }
            TbadkCoreApplication.getInst().unregisterReceiver(this.f20062e);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
            TbadkCoreApplication.getInst().registerReceiver(this.f20062e, intentFilter);
        }
    }

    public void o(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) || runnable == null) {
            return;
        }
        Handler handler = this.f20065h;
        if (handler == null) {
            if (this.f20066i.getLooper() != null) {
                Handler handler2 = new Handler(this.f20066i.getLooper());
                this.f20065h = handler2;
                handler2.post(runnable);
            }
            c.a.d.f.m.e.a().postDelayed(new f(this, runnable), 100L);
            return;
        }
        handler.post(runnable);
    }
}
