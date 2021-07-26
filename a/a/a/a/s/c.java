package a.a.a.a.s;

import a.a.a.a.o;
import a.a.a.a.s.f;
import a.a.a.a.s.h;
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
    public static final Handler f1326a;

    /* renamed from: b  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f1327b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f1328c;

    /* renamed from: d  reason: collision with root package name */
    public static final m f1329d;

    /* renamed from: e  reason: collision with root package name */
    public static List<FunAdFactory> f1330e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1331f;
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
                c.a(false);
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
            a.a.a.a.v.g.d a2;
            JSONObject jSONObject;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i3 = message.what;
                int i4 = -1;
                boolean z = false;
                if (i3 != 100) {
                    if (i3 == 101) {
                        a.a.a.a.s.b bVar = new a.a.a.a.s.b();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            a.a.a.a.v.d.c("Start load config from assets.", new Object[0]);
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
                            a.a.a.a.v.d.c("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = a.a.a.a.v.a.a(stringWriter2, str);
                                a.a.a.a.v.d.c("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e2) {
                            a.a.a.a.v.d.a(e2, 6, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (!bVar.a(str2)) {
                            a.a.a.a.v.d.b("Config from assets parsed failed.", new Object[0]);
                            return;
                        }
                        a.a.a.a.v.d.c("Config from assets parsed over.", new Object[0]);
                        c.f1326a.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    a.a.a.a.v.g.c.b(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    a.a.a.a.t.f a3 = new a.a.a.a.t.b("https://cd.xdplt.com/v2/z", new a.a.a.a.t.e(hashMap)).a();
                    if (a3.f1387a != 200) {
                        a.a.a.a.v.d.b("Pull ad config failed.", new Object[0]);
                    } else {
                        try {
                            jSONObject = new JSONObject(a3.f1388b);
                            i2 = jSONObject.getInt(Constants.KEYS.RET);
                            a.a.a.a.v.d.a("Download online ad config response ret: " + i2, new Object[0]);
                        } catch (JSONException e3) {
                            a.a.a.a.v.d.a(e3);
                            a2 = a.a.a.a.v.g.d.a();
                        }
                        if (i2 == 200) {
                            try {
                            } catch (Exception e4) {
                                a.a.a.a.v.d.a(e4);
                                a2 = a.a.a.a.v.g.d.a();
                                i4 = -2;
                            }
                            if (new a.a.a.a.s.b().a(a.a.a.a.v.a.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                                z = true;
                            } else {
                                a2 = a.a.a.a.v.g.d.a();
                                i4 = -3;
                                a2.a("k_ppcfg", "st", Integer.valueOf(i4));
                            }
                        }
                    }
                } catch (IOException e5) {
                    a.a.a.a.v.d.a(e5);
                }
                a.a.a.a.v.b.f1396b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                    c.f1326a.sendEmptyMessage(200);
                }
                c.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1837174696, "La/a/a/a/s/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1837174696, "La/a/a/a/s/c;");
                return;
            }
        }
        f1326a = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f1328c = new b(handlerThread.getLooper());
        f1329d = new m();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        a.a.a.a.s.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            m mVar = f1329d;
            synchronized (mVar) {
                aVar = mVar.f1372a;
            }
            if (aVar == null) {
                a.a.a.a.v.d.a("No adConfig found now.", new Object[0]);
                return null;
            }
            for (h hVar : aVar.f1317b) {
                if (hVar.f1358c.equals(str)) {
                    return hVar.f1357b;
                }
            }
            a.a.a.a.v.d.a("No target ssp found for platform:%s", str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static g b(String str) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            m mVar = f1329d;
            synchronized (mVar) {
                if (mVar.f1372a == null) {
                    a.a.a.a.v.d.a("Cannot get slotId without AdConfig updated.", new Object[0]);
                    gVar = null;
                } else {
                    gVar = mVar.f1374c.get(str);
                }
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static int a(String str, h.a aVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, aVar)) == null) {
            f fVar = f1329d.f1373b;
            synchronized (fVar.f1351a) {
                Deque<f.c> deque = fVar.f1351a.get(str);
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

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            long j = 0;
            long j2 = a.a.a.a.v.b.f1396b.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = a.a.a.a.v.b.f1396b.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            a.a.a.a.v.d.c("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            f1328c.removeMessages(100);
            f1328c.sendEmptyMessageDelayed(100, max);
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
    public static void a(boolean z) {
        a.a.a.a.s.a aVar;
        boolean z2;
        char c2;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) != null) {
            return;
        }
        a.a.a.a.v.d.c("tryInitialize", new Object[0]);
        a();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        String string = a.a.a.a.v.b.f1396b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                aVar = new a.a.a.a.s.a(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                a.a.a.a.v.d.a(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aVar == null);
            objArr[1] = Boolean.valueOf(z);
            a.a.a.a.v.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (aVar != null) {
                if (z) {
                    f1328c.obtainMessage(101).sendToTarget();
                    return;
                }
                return;
            }
            m mVar = f1329d;
            synchronized (mVar) {
                a.a.a.a.s.a aVar2 = mVar.f1372a;
                if (aVar2 != null) {
                    if (aVar2.equals(aVar)) {
                        a.a.a.a.v.d.a("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        a.a.a.a.s.a aVar3 = mVar.f1372a;
                        if (aVar3.f1317b.size() == aVar.f1317b.size()) {
                            HashSet hashSet = new HashSet(aVar.f1317b);
                            for (h hVar : aVar3.f1317b) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    h hVar2 = (h) it.next();
                                    if (hVar.f1358c.equals(hVar2.f1358c) && hVar.f1357b.equals(hVar2.f1357b)) {
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
                                a.a.a.a.v.d.a("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                a.a.a.a.s.a aVar4 = mVar.f1372a;
                mVar.a(aVar4 == null ? null : aVar4.f1318c, aVar.f1318c, new j(mVar));
                a.a.a.a.s.a aVar5 = mVar.f1372a;
                mVar.a(aVar5 == null ? null : aVar5.f1319d, aVar.f1319d, new l(mVar));
                mVar.f1372a = aVar;
                z2 = true;
            }
            if (!z2) {
                a.a.a.a.v.d.a("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            a.a.a.a.v.g.c.s = a.a.a.a.v.b.f1396b.getLong("key_config_v", 0L);
            if (f1330e == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = System.currentTimeMillis();
                    Context context = funAdConfig.appContext;
                    a.a.a.a.l.b();
                    for (h hVar3 : aVar.f1317b) {
                        if (!TextUtils.isEmpty(hVar3.f1357b)) {
                            if (funAdConfig.sspTypeBlacklist.contains(hVar3.f1358c)) {
                                a.a.a.a.v.d.a("Ssp:%s is not initialized for type is in blacklist", hVar3.f1358c);
                            } else {
                                a.a.a.a.l.f1078d = System.currentTimeMillis();
                                a.a.a.a.l.f1082h = SystemClock.currentThreadTimeMillis();
                                long currentTimeMillis2 = System.currentTimeMillis();
                                String str = hVar3.f1358c;
                                int hashCode = str.hashCode();
                                if (hashCode == 3407) {
                                    if (str.equals(FunAdSdk.PLATFORM_JY)) {
                                        c2 = 3;
                                        if (c2 != 0) {
                                        }
                                        a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                        a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                        a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                    a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                    a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else if (hashCode == 3432) {
                                    if (str.equals(FunAdSdk.PLATFORM_KS)) {
                                        c2 = 1;
                                        if (c2 != 0) {
                                        }
                                        a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                        a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                        a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                    a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                    a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else if (hashCode != 98810) {
                                    if (hashCode == 102199 && str.equals(FunAdSdk.PLATFORM_GDT)) {
                                        c2 = 2;
                                        if (c2 != 0) {
                                            TTAdSdk.init(context, new TTAdConfig.Builder().appId(hVar3.f1357b).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).asyncInit(true).directDownloadNetworkType(4, 1).customController(funAdConfig.ttCustomCtr).build());
                                            hashMap.put(hVar3.f1358c, new a.a.a.a.r.a.a.a());
                                        } else if (c2 == 1) {
                                            KsAdSDK.init(context, new SdkConfig.Builder().appId(hVar3.f1357b).appName(funAdConfig.appName).showNotification(true).debug(false).canReadICCID(funAdConfig.ksCanReadICCID).canReadNearbyWifiList(funAdConfig.ksCanReadNearbyWifiList).canReadMacAddress(funAdConfig.ksCanReadMacAddress).build());
                                            hashMap.put(hVar3.f1358c, new a.a.a.a.r.a.a.d());
                                        } else if (c2 == 2) {
                                            GDTADManager.getInstance().initWith(context, hVar3.f1357b);
                                            GlobalSetting.setChannel(3);
                                            hashMap.put(hVar3.f1358c, new a.a.a.a.r.a.a.b());
                                        } else if (c2 == 3) {
                                            PBInitialize.init(context, hVar3.f1357b);
                                            hashMap.put(hVar3.f1358c, new a.a.a.a.r.a.a.c());
                                        }
                                        a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                        a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                        a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                    a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                    a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else {
                                    if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                                        c2 = 0;
                                        if (c2 != 0) {
                                        }
                                        a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                        a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                        a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    }
                                    c2 = 65535;
                                    if (c2 != 0) {
                                    }
                                    a.a.a.a.l.f1075a.f1090g.put(hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - a.a.a.a.l.f1078d));
                                    a.a.a.a.l.f1075a.f1091h.put("T" + hVar3.f1358c, Long.valueOf(SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1082h));
                                    a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", hVar3.f1358c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                            }
                        }
                    }
                    a.a.a.a.l.f1075a.f1086c = System.currentTimeMillis() - a.a.a.a.l.f1079e;
                    a.a.a.a.l.f1075a.f1087d = SystemClock.currentThreadTimeMillis() - a.a.a.a.l.f1083i;
                    a.a.a.a.v.d.a("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new a.a.a.a.f(new o(hashMap)));
                    f1330e = arrayList;
                    f1331f = true;
                    FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f1327b;
                    if (sdkInitializeCallback != null) {
                        sdkInitializeCallback.onComplete();
                    }
                    f1327b = null;
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
        a.a.a.a.v.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (aVar != null) {
        }
    }
}
