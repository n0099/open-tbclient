package c.g;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.g.f;
import c.g.n;
import c.g.x0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.StringWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f28642b;

    /* renamed from: c  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f28643c;

    /* renamed from: d  reason: collision with root package name */
    public static final Handler f28644d;

    /* renamed from: e  reason: collision with root package name */
    public static final z f28645e;

    /* renamed from: f  reason: collision with root package name */
    public static final x0 f28646f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f28647g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f28648h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
                h.e(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            o0 a;
            JSONObject jSONObject;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i3 = message.what;
                int i4 = -1;
                boolean z = false;
                if (i3 != 100) {
                    if (i3 == 101) {
                        g gVar = new g();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            LogPrinter.v("Start load config from assets.", new Object[0]);
                            AssetManager assets = FunAdSdk.getAppContext().getAssets();
                            InputStream open = assets.open(str + ".json");
                            StringWriter stringWriter = new StringWriter();
                            InputStreamReader inputStreamReader = new InputStreamReader(open);
                            char[] cArr = new char[4096];
                            while (true) {
                                int read = inputStreamReader.read(cArr);
                                if (-1 == read) {
                                    break;
                                }
                                stringWriter.write(cArr, 0, read);
                            }
                            String stringWriter2 = stringWriter.toString();
                            LogPrinter.v("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = x.a(stringWriter2, str);
                                LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e2) {
                            LogPrinter.e(e2, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (gVar.b(str2)) {
                            LogPrinter.v("Config from assets parsed over with succeed", new Object[0]);
                        } else {
                            LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                            if (FunAdSdk.isLogEnabled()) {
                                throw new RuntimeException("Config from assets parsed failed");
                            }
                        }
                        h.f28642b.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    m0.d(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    p0 a2 = new h0("https://cd.xdplt.com/v2/z", new n0(hashMap)).a();
                    if (a2.a != 200) {
                        LogPrinter.e("Pull ad config failed.", new Object[0]);
                    } else {
                        try {
                            jSONObject = new JSONObject(a2.f28680b);
                            i2 = jSONObject.getInt(Constants.KEYS.RET);
                            LogPrinter.d("Download online ad config response ret: " + i2, new Object[0]);
                        } catch (JSONException e3) {
                            LogPrinter.e(e3);
                            a = o0.a();
                        }
                        if (i2 == 200) {
                            try {
                            } catch (Exception e4) {
                                LogPrinter.e(e4);
                                a = o0.a();
                                i4 = -2;
                            }
                            if (new g().b(x.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                                h.a.clear();
                                z = true;
                            } else {
                                a = o0.a();
                                i4 = -3;
                                a.b("k_ppcfg", "st", Integer.valueOf(i4));
                            }
                        }
                    }
                } catch (IOException e5) {
                    LogPrinter.e(e5);
                }
                a0.f28396b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                    h.f28642b.sendEmptyMessage(200);
                }
                h.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1611611379, "Lc/g/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1611611379, "Lc/g/h;");
                return;
            }
        }
        a = new HashMap();
        f28642b = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f28644d = new b(handlerThread.getLooper());
        f28645e = new z();
        f28646f = new x0();
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            n nVar = f28645e.f28724b;
            synchronized (nVar.a) {
                Deque<n.c> deque = nVar.a.get(str);
                i2 = 0;
                if (deque != null) {
                    Iterator<n.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        n.c next = descendingIterator.next();
                        if (next.a().contains(pid)) {
                            i2 = next.b();
                            break;
                        }
                    }
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static p b(String str) {
        InterceptResult invokeL;
        p pVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            z zVar = f28645e;
            synchronized (zVar) {
                if (zVar.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    pVar = null;
                } else {
                    pVar = zVar.f28725c.get(str);
                }
            }
            return pVar;
        }
        return (p) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = a0.f28396b;
            long j2 = 0;
            long j3 = sharedPreferences.getLong("key_lst_config_sync_time", 0L);
            if (j3 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j3;
                if (currentTimeMillis >= 0) {
                    long j4 = sharedPreferences.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j4) {
                        j2 = j4 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j2);
            LogPrinter.v("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            Handler handler = f28644d;
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100, max);
        }
    }

    public static void d(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kVar) == null) {
            f28648h = true;
            x0 x0Var = f28646f;
            synchronized (x0Var.f28699b) {
                x0Var.f28702e = kVar;
                x0Var.f28701d = 1;
                while (!x0Var.f28700c.isEmpty()) {
                    x0.a pollFirst = x0Var.f28700c.pollFirst();
                    if (!x0.f28698f && pollFirst == null) {
                        throw new AssertionError();
                    }
                    x0Var.loadAd(pollFirst.a, pollFirst.f28703b, pollFirst.f28704c);
                }
            }
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f28643c;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            f28643c = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114 A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #2 {, blocks: (B:40:0x00a7, B:42:0x00ab, B:44:0x00b1, B:45:0x00b9, B:64:0x0114, B:48:0x00ca, B:49:0x00d7, B:51:0x00dd, B:52:0x00e7, B:54:0x00ed, B:56:0x00fd, B:58:0x0107, B:67:0x011e, B:71:0x0126, B:75:0x0137, B:74:0x0135, B:70:0x0124), top: B:151:0x00a7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(boolean z) {
        c cVar;
        boolean z2;
        char c2;
        String str;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(65541, null, z) != null) {
            return;
        }
        LogPrinter.v("tryInitialize", new Object[0]);
        c();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        Set<j> set = null;
        String string = a0.f28396b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                cVar = new c(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                LogPrinter.e(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(cVar == null);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (cVar != null) {
                if (z) {
                    f28644d.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                x0 x0Var = f28646f;
                synchronized (x0Var.f28699b) {
                    x0Var.f28701d = -1;
                    while (!x0Var.f28700c.isEmpty()) {
                        x0.a pollFirst = x0Var.f28700c.pollFirst();
                        if (!x0.f28698f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.f28704c.onError(pollFirst.f28703b.getSid());
                    }
                }
                return;
            }
            z zVar = f28645e;
            synchronized (zVar) {
                c cVar2 = zVar.a;
                if (cVar2 != null) {
                    if (cVar2.equals(cVar)) {
                        LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        c cVar3 = zVar.a;
                        if (cVar3.a.size() == cVar.a.size()) {
                            HashSet hashSet = new HashSet(cVar.a);
                            for (Ssp ssp : cVar3.a) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    Ssp ssp2 = (Ssp) it.next();
                                    if (ssp.type.equals(ssp2.type) && ssp.sspId.equals(ssp2.sspId)) {
                                        it.remove();
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z4) {
                                }
                            }
                            z3 = true;
                            if (!z3) {
                                LogPrinter.d("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                c cVar4 = zVar.a;
                zVar.a(cVar4 == null ? null : cVar4.f28604b, cVar.f28604b, new u(zVar));
                c cVar5 = zVar.a;
                if (cVar5 != null) {
                    set = cVar5.f28605c;
                }
                zVar.a(set, cVar.f28605c, new y(zVar));
                zVar.a = cVar;
                z2 = true;
            }
            if (!z2) {
                LogPrinter.d("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            m0.s = a0.f28396b.getLong("key_config_v", 0L);
            if (f28647g) {
                return;
            }
            f28647g = true;
            c.g.a aVar = c.g.a.a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HashMap hashMap = new HashMap();
                long currentTimeMillis = System.currentTimeMillis();
                for (Ssp ssp3 : cVar.a) {
                    if (!funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                        String str4 = ssp3.type;
                        str4.hashCode();
                        switch (str4.hashCode()) {
                            case 3407:
                                if (str4.equals(FunAdSdk.PLATFORM_JY)) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3432:
                                if (str4.equals(FunAdSdk.PLATFORM_KS)) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3477:
                                if (str4.equals(FunAdSdk.PLATFORM_MB)) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 98810:
                                if (str4.equals(FunAdSdk.PLATFORM_CSJ)) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 102199:
                                if (str4.equals(FunAdSdk.PLATFORM_GDT)) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 106042:
                                if (str4.equals(FunAdSdk.PLATFORM_KDS)) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 113873:
                                if (str4.equals(FunAdSdk.PLATFORM_SIG)) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 93498907:
                                if (str4.equals("baidu")) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.JyModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 1:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.KsModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 2:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.MbModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 3:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.CsjModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 4:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.GdtModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 5:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.KdsModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 6:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.SigModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                            case 7:
                                str = ssp3.type;
                                str2 = ssp3.sspId;
                                str3 = "com.fun.ad.sdk.channel.BaiduModule";
                                d.b(str, str3, funAdConfig, hashMap, str2);
                                break;
                        }
                    } else {
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                    }
                }
                f.a aVar2 = f.a;
                aVar2.a = System.currentTimeMillis() - 0;
                aVar2.f28631b = SystemClock.currentThreadTimeMillis() - 0;
                LogPrinter.d("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                aVar.a(new k(hashMap));
                return;
            }
            throw new RuntimeException("Wrong thread");
        }
        cVar = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(cVar == null);
        objArr2[1] = Boolean.valueOf(z);
        LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (cVar != null) {
        }
    }
}
