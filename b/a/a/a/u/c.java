package b.a.a.a.u;

import android.content.Context;
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
import b.a.a.a.p;
import b.a.a.a.u.f;
import b.a.a.a.u.h;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.win.opensdk.PBInitialize;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f1413a;

    /* renamed from: b  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f1414b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f1415c;

    /* renamed from: d  reason: collision with root package name */
    public static final m f1416d;

    /* renamed from: e  reason: collision with root package name */
    public static List<FunAdFactory> f1417e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1418f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends Handler {
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
                c.d(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
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
            b.a.a.a.x.f.d a2;
            JSONObject jSONObject;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i3 = message.what;
                int i4 = -1;
                boolean z = false;
                if (i3 != 100) {
                    if (i3 == 101) {
                        b.a.a.a.u.b bVar = new b.a.a.a.u.b();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            b.a.a.a.x.d.g("Start load config from assets.", new Object[0]);
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
                            b.a.a.a.x.d.g("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = b.a.a.a.x.a.a(stringWriter2, str);
                                b.a.a.a.x.d.g("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e2) {
                            b.a.a.a.x.d.d(e2, 6, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (!bVar.g(str2)) {
                            b.a.a.a.x.d.f("Config from assets parsed failed.", new Object[0]);
                            return;
                        }
                        b.a.a.a.x.d.g("Config from assets parsed over.", new Object[0]);
                        c.f1413a.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    b.a.a.a.x.f.c.d(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    b.a.a.a.v.f a3 = new b.a.a.a.v.b("https://cd.xdplt.com/v2/z", new b.a.a.a.v.e(hashMap)).a();
                    if (a3.f1475a != 200) {
                        b.a.a.a.x.d.f("Pull ad config failed.", new Object[0]);
                    } else {
                        try {
                            jSONObject = new JSONObject(a3.f1476b);
                            i2 = jSONObject.getInt(Constants.KEYS.RET);
                            b.a.a.a.x.d.b("Download online ad config response ret: " + i2, new Object[0]);
                        } catch (JSONException e3) {
                            b.a.a.a.x.d.c(e3);
                            a2 = b.a.a.a.x.f.d.a();
                        }
                        if (i2 == 200) {
                            try {
                            } catch (Exception e4) {
                                b.a.a.a.x.d.c(e4);
                                a2 = b.a.a.a.x.f.d.a();
                                i4 = -2;
                            }
                            if (new b.a.a.a.u.b().g(b.a.a.a.x.a.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                                z = true;
                            } else {
                                a2 = b.a.a.a.x.f.d.a();
                                i4 = -3;
                                a2.b("k_ppcfg", "st", Integer.valueOf(i4));
                            }
                        }
                    }
                } catch (IOException e5) {
                    b.a.a.a.x.d.c(e5);
                }
                b.a.a.a.x.b.f1484b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                    c.f1413a.sendEmptyMessage(200);
                }
                c.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1708032395, "Lb/a/a/a/u/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1708032395, "Lb/a/a/a/u/c;");
                return;
            }
        }
        f1413a = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f1415c = new b(handlerThread.getLooper());
        f1416d = new m();
    }

    public static int a(String str, h.a aVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, aVar)) == null) {
            f fVar = f1416d.f1461b;
            synchronized (fVar.f1438a) {
                Deque<f.c> deque = fVar.f1438a.get(str);
                i2 = 0;
                if (deque != null) {
                    Iterator<f.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        f.c next = descendingIterator.next();
                        if (next.a().contains(aVar)) {
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

    public static String b(String str) {
        InterceptResult invokeL;
        b.a.a.a.u.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            m mVar = f1416d;
            synchronized (mVar) {
                aVar = mVar.f1460a;
            }
            if (aVar == null) {
                b.a.a.a.x.d.b("No adConfig found now.", new Object[0]);
                return null;
            }
            for (h hVar : aVar.f1404b) {
                if (hVar.f1445c.equals(str)) {
                    return hVar.f1444b;
                }
            }
            b.a.a.a.x.d.b("No target ssp found for platform:%s", str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            long j2 = 0;
            long j3 = b.a.a.a.x.b.f1484b.getLong("key_lst_config_sync_time", 0L);
            if (j3 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j3;
                if (currentTimeMillis >= 0) {
                    long j4 = b.a.a.a.x.b.f1484b.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j4) {
                        j2 = j4 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j2);
            b.a.a.a.x.d.g("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            f1415c.removeMessages(100);
            f1415c.sendEmptyMessageDelayed(100, max);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7 A[Catch: all -> 0x0322, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x006a, B:26:0x006e, B:28:0x0074, B:29:0x007c, B:48:0x00d7, B:32:0x008d, B:33:0x009a, B:35:0x00a0, B:36:0x00aa, B:38:0x00b0, B:40:0x00c0, B:42:0x00ca, B:51:0x00e1, B:55:0x00e9, B:59:0x00fb, B:58:0x00f9, B:54:0x00e7), top: B:123:0x006a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(boolean z) {
        b.a.a.a.u.a aVar;
        boolean z2;
        char c2;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) != null) {
            return;
        }
        b.a.a.a.x.d.g("tryInitialize", new Object[0]);
        c();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        String string = b.a.a.a.x.b.f1484b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                aVar = new b.a.a.a.u.a(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                b.a.a.a.x.d.c(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aVar == null);
            objArr[1] = Boolean.valueOf(z);
            b.a.a.a.x.d.g("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (aVar != null) {
                if (z) {
                    f1415c.obtainMessage(101).sendToTarget();
                    return;
                }
                return;
            }
            m mVar = f1416d;
            synchronized (mVar) {
                b.a.a.a.u.a aVar2 = mVar.f1460a;
                if (aVar2 != null) {
                    if (aVar2.equals(aVar)) {
                        b.a.a.a.x.d.b("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        b.a.a.a.u.a aVar3 = mVar.f1460a;
                        if (aVar3.f1404b.size() == aVar.f1404b.size()) {
                            HashSet hashSet = new HashSet(aVar.f1404b);
                            for (h hVar : aVar3.f1404b) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    h hVar2 = (h) it.next();
                                    if (hVar.f1445c.equals(hVar2.f1445c) && hVar.f1444b.equals(hVar2.f1444b)) {
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
                                b.a.a.a.x.d.b("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                b.a.a.a.u.a aVar4 = mVar.f1460a;
                mVar.a(aVar4 == null ? null : aVar4.f1405c, aVar.f1405c, new j(mVar));
                b.a.a.a.u.a aVar5 = mVar.f1460a;
                mVar.a(aVar5 == null ? null : aVar5.f1406d, aVar.f1406d, new l(mVar));
                mVar.f1460a = aVar;
                z2 = true;
            }
            if (!z2) {
                b.a.a.a.x.d.b("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            b.a.a.a.x.f.c.s = b.a.a.a.x.b.f1484b.getLong("key_config_v", 0L);
            if (f1417e == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = System.currentTimeMillis();
                    Context context = funAdConfig.appContext;
                    b.a.a.a.m.b();
                    for (h hVar3 : aVar.f1404b) {
                        if (!TextUtils.isEmpty(hVar3.f1444b)) {
                            if (funAdConfig.sspTypeBlacklist.contains(hVar3.f1445c)) {
                                b.a.a.a.x.d.b("Ssp:%s is not initialized for type is in blacklist", hVar3.f1445c);
                            } else {
                                b.a.a.a.m.f1134d = System.currentTimeMillis();
                                b.a.a.a.m.f1138h = SystemClock.currentThreadTimeMillis();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                String str = hVar3.f1445c;
                                int hashCode = str.hashCode();
                                if (hashCode == 3407) {
                                    if (str.equals(FunAdSdk.PLATFORM_JY)) {
                                        c2 = 3;
                                        if (c2 != 0) {
                                        }
                                        b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                        b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                        b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                    b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                    b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else if (hashCode == 3432) {
                                    if (str.equals(FunAdSdk.PLATFORM_KS)) {
                                        c2 = 1;
                                        if (c2 != 0) {
                                        }
                                        b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                        b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                        b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                    b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                    b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else if (hashCode != 98810) {
                                    if (hashCode == 102199 && str.equals(FunAdSdk.PLATFORM_GDT)) {
                                        c2 = 2;
                                        if (c2 != 0) {
                                            TTAdSdk.init(context, new TTAdConfig.Builder().appId(hVar3.f1444b).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).asyncInit(true).directDownloadNetworkType(4, 1).customController(funAdConfig.ttCustomCtr).build());
                                            hashMap.put(hVar3.f1445c, new b.a.a.a.t.a.b.a());
                                        } else if (c2 == 1) {
                                            KsAdSDK.init(context, new SdkConfig.Builder().appId(hVar3.f1444b).appName(funAdConfig.appName).showNotification(true).debug(false).canReadICCID(funAdConfig.ksCanReadICCID).canReadNearbyWifiList(funAdConfig.ksCanReadNearbyWifiList).canReadMacAddress(funAdConfig.ksCanReadMacAddress).build());
                                            hashMap.put(hVar3.f1445c, new b.a.a.a.t.a.b.d());
                                        } else if (c2 == 2) {
                                            GDTADManager.getInstance().initWith(context, hVar3.f1444b);
                                            GlobalSetting.setChannel(3);
                                            hashMap.put(hVar3.f1445c, new b.a.a.a.t.a.b.b());
                                        } else if (c2 == 3) {
                                            PBInitialize.init(context, hVar3.f1444b);
                                            hashMap.put(hVar3.f1445c, new b.a.a.a.t.a.b.c());
                                        }
                                        b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                        b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                        b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                    b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                    b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else {
                                    if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                                        c2 = 0;
                                        if (c2 != 0) {
                                        }
                                        b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                        b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                        b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    b.a.a.a.m.f1131a.f1146g.put(hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - b.a.a.a.m.f1134d));
                                    b.a.a.a.m.f1131a.f1147h.put("T" + hVar3.f1445c, Long.valueOf(SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1138h));
                                    b.a.a.a.x.d.b("Ssp:%s initialized with %dms consumed.", hVar3.f1445c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                            }
                        }
                    }
                    b.a.a.a.m.f1131a.f1142c = System.currentTimeMillis() - b.a.a.a.m.f1135e;
                    b.a.a.a.m.f1131a.f1143d = SystemClock.currentThreadTimeMillis() - b.a.a.a.m.f1139i;
                    b.a.a.a.x.d.b("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new b.a.a.a.g(new p(hashMap)));
                    f1417e = arrayList;
                    f1418f = true;
                    FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f1414b;
                    if (sdkInitializeCallback != null) {
                        sdkInitializeCallback.onComplete();
                    }
                    f1414b = null;
                    return;
                }
                throw new RuntimeException("Wrong thread");
            }
            return;
        }
        aVar = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(aVar == null);
        objArr2[1] = Boolean.valueOf(z);
        b.a.a.a.x.d.g("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (aVar != null) {
        }
    }

    public static g e(String str) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            m mVar = f1416d;
            synchronized (mVar) {
                if (mVar.f1460a == null) {
                    b.a.a.a.x.d.b("Cannot get slotId without AdConfig updated.", new Object[0]);
                    gVar = null;
                } else {
                    gVar = mVar.f1462c.get(str);
                }
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }
}
