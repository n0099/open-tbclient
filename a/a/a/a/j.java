package a.a.a.a;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f1047a;

    /* renamed from: b  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f1048b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f1049c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f1050d;

    /* renamed from: e  reason: collision with root package name */
    public static List<FunAdFactory> f1051e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1052f;
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
                j.a(false);
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
            a.a.a.a.w.f a2;
            a.a.a.a.y.f.d a3;
            Integer valueOf;
            JSONObject jSONObject;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i3 = message.what;
                int i4 = -1;
                int i5 = 0;
                if (i3 != 100) {
                    if (i3 == 101) {
                        a.a.a.a.v.b bVar = new a.a.a.a.v.b();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            a.a.a.a.y.d.c("Start load config from assets.", new Object[0]);
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
                            a.a.a.a.y.d.c("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = a.a.a.a.y.a.a(stringWriter2, str);
                                a.a.a.a.y.d.c("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e2) {
                            a.a.a.a.y.d.a(e2, 6, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (!bVar.a(str2)) {
                            a.a.a.a.y.d.b("Config from assets parsed failed.", new Object[0]);
                            return;
                        }
                        a.a.a.a.y.d.c("Config from assets parsed over.", new Object[0]);
                        j.f1047a.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    a.a.a.a.y.f.c.b(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    a2 = new a.a.a.a.w.b("https://cd.xdplt.com/v2/z", new a.a.a.a.w.e(hashMap)).a();
                } catch (IOException e3) {
                    a.a.a.a.y.d.a(e3);
                }
                if (a2 != null && a2.f1363a == 200) {
                    try {
                        jSONObject = new JSONObject(a2.f1364b);
                        i2 = jSONObject.getInt(Constants.KEYS.RET);
                        a.a.a.a.y.d.a("Download online ad config response ret: " + i2, new Object[0]);
                    } catch (JSONException e4) {
                        a.a.a.a.y.d.a(e4);
                        a3 = a.a.a.a.y.f.d.a();
                    }
                    if (i2 == 200) {
                        try {
                            if (new a.a.a.a.v.b().a(a.a.a.a.y.a.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                                j.f1047a.sendEmptyMessage(200);
                            } else {
                                i5 = -3;
                            }
                        } catch (Exception e5) {
                            a.a.a.a.y.d.a(e5);
                            a3 = a.a.a.a.y.f.d.a();
                            i4 = -2;
                            valueOf = Integer.valueOf(i4);
                            a3.a("k_ppcfg", "st", valueOf);
                            a.a.a.a.y.b.f1371a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                            j.a();
                        }
                        if (i5 != 0) {
                            a3 = a.a.a.a.y.f.d.a();
                            valueOf = Integer.valueOf(i5);
                            a3.a("k_ppcfg", "st", valueOf);
                        }
                    }
                    a.a.a.a.y.b.f1371a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                    j.a();
                }
                a.a.a.a.y.d.b("Pull ad config failed.", new Object[0]);
                a.a.a.a.y.b.f1371a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                j.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.a.a.a.v.a f1053a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, t> f1054b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1054b = new HashMap<>();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222022379, "La/a/a/a/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1222022379, "La/a/a/a/j;");
                return;
            }
        }
        f1047a = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f1049c = new b(handlerThread.getLooper());
        f1050d = new c();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        a.a.a.a.v.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar = f1050d;
            synchronized (cVar) {
                aVar = cVar.f1053a;
            }
            if (aVar == null) {
                a.a.a.a.y.d.a("No adConfig found now.", new Object[0]);
                return null;
            }
            for (a.a.a.a.v.e eVar : aVar.f1315b) {
                if (eVar.f1342c.equals(str)) {
                    return eVar.f1341b;
                }
            }
            a.a.a.a.y.d.a("No target ssp found for platform:%s", str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static t b(String str) {
        InterceptResult invokeL;
        t tVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            c cVar = f1050d;
            synchronized (cVar) {
                if (cVar.f1053a == null) {
                    a.a.a.a.y.d.a("Cannot get slotId without AdConfig updated.", new Object[0]);
                    tVar = null;
                } else {
                    tVar = cVar.f1054b.get(str);
                }
            }
            return tVar;
        }
        return (t) invokeL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            long j = 0;
            long j2 = a.a.a.a.y.b.f1371a.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = a.a.a.a.y.b.f1371a.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            a.a.a.a.y.d.c("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            f1049c.removeMessages(100);
            f1049c.sendEmptyMessageDelayed(100, max);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7 A[Catch: all -> 0x0328, TRY_LEAVE, TryCatch #1 {, blocks: (B:24:0x006a, B:26:0x006e, B:28:0x0074, B:29:0x007c, B:48:0x00d7, B:32:0x008d, B:33:0x009a, B:35:0x00a0, B:36:0x00aa, B:38:0x00b0, B:40:0x00c0, B:42:0x00ca, B:51:0x00e1, B:52:0x00e9, B:54:0x00ef, B:55:0x0102, B:56:0x010a, B:58:0x0110), top: B:122:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(boolean z) {
        a.a.a.a.v.a aVar;
        boolean z2;
        char c2;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(65539, null, z) != null) {
            return;
        }
        a.a.a.a.y.d.c("tryInitialize", new Object[0]);
        a();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        String string = a.a.a.a.y.b.f1371a.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                aVar = new a.a.a.a.v.a(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                a.a.a.a.y.d.a(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aVar == null);
            objArr[1] = Boolean.valueOf(z);
            a.a.a.a.y.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (aVar != null) {
                if (z) {
                    f1049c.obtainMessage(101).sendToTarget();
                    return;
                }
                return;
            }
            c cVar = f1050d;
            synchronized (cVar) {
                a.a.a.a.v.a aVar2 = cVar.f1053a;
                if (aVar2 != null) {
                    if (aVar2.equals(aVar)) {
                        a.a.a.a.y.d.a("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        a.a.a.a.v.a aVar3 = cVar.f1053a;
                        if (aVar3.f1315b.size() == aVar.f1315b.size()) {
                            HashSet hashSet = new HashSet(aVar.f1315b);
                            for (a.a.a.a.v.e eVar : aVar3.f1315b) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    a.a.a.a.v.e eVar2 = (a.a.a.a.v.e) it.next();
                                    if (eVar.f1342c.equals(eVar2.f1342c) && eVar.f1341b.equals(eVar2.f1341b)) {
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
                                a.a.a.a.y.d.a("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                cVar.f1053a = aVar;
                for (a.a.a.a.v.d dVar : aVar.f1316c) {
                    cVar.f1054b.put(dVar.f1331b, new t(dVar));
                }
                for (a.a.a.a.v.c cVar2 : cVar.f1053a.f1317d) {
                    cVar.f1054b.put(cVar2.f1324b, new t(cVar2));
                }
                z2 = true;
            }
            if (!z2) {
                a.a.a.a.y.d.a("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            a.a.a.a.y.f.c.t = a.a.a.a.y.b.f1371a.getLong("key_config_v", 0L);
            if (f1051e == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = System.currentTimeMillis();
                    Context context = funAdConfig.appContext;
                    m.b();
                    for (a.a.a.a.v.e eVar3 : aVar.f1315b) {
                        if (!TextUtils.isEmpty(eVar3.f1341b)) {
                            m.f1086d = System.currentTimeMillis();
                            m.f1090h = SystemClock.currentThreadTimeMillis();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            String str = eVar3.f1342c;
                            int hashCode = str.hashCode();
                            if (hashCode == 3407) {
                                if (str.equals(FunAdSdk.PLATFORM_JY)) {
                                    c2 = 3;
                                    if (c2 != 0) {
                                    }
                                    m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                    m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                    a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else if (hashCode == 3432) {
                                if (str.equals(FunAdSdk.PLATFORM_KS)) {
                                    c2 = 1;
                                    if (c2 != 0) {
                                    }
                                    m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                    m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                    a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else if (hashCode != 98810) {
                                if (hashCode == 102199 && str.equals(FunAdSdk.PLATFORM_GDT)) {
                                    c2 = 2;
                                    if (c2 != 0) {
                                        TTAdSdk.init(context, new TTAdConfig.Builder().appId(eVar3.f1341b).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).asyncInit(true).directDownloadNetworkType(4, 1).customController(funAdConfig.ttCustomCtr).build());
                                        hashMap.put(eVar3.f1342c, new a.a.a.a.u.a.a.a());
                                    } else if (c2 == 1) {
                                        KsAdSDK.init(context, new SdkConfig.Builder().appId(eVar3.f1341b).appName(funAdConfig.appName).showNotification(true).debug(false).canReadICCID(funAdConfig.ksCanReadICCID).canReadNearbyWifiList(funAdConfig.ksCanReadNearbyWifiList).canReadMacAddress(funAdConfig.ksCanReadMacAddress).build());
                                        hashMap.put(eVar3.f1342c, new a.a.a.a.u.a.a.d());
                                    } else if (c2 == 2) {
                                        GDTADManager.getInstance().initWith(context, eVar3.f1341b);
                                        GlobalSetting.setChannel(3);
                                        hashMap.put(eVar3.f1342c, new a.a.a.a.u.a.a.b());
                                    } else if (c2 == 3) {
                                        PBInitialize.init(context, eVar3.f1341b);
                                        hashMap.put(eVar3.f1342c, new a.a.a.a.u.a.a.c());
                                    }
                                    m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                    m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                    a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else {
                                if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                                    c2 = 0;
                                    if (c2 != 0) {
                                    }
                                    m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                    m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                    a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                m.f1083a.f1098g.put(eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - m.f1086d));
                                m.f1083a.f1099h.put("T" + eVar3.f1342c, Long.valueOf(SystemClock.currentThreadTimeMillis() - m.f1090h));
                                a.a.a.a.y.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1342c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            }
                        }
                    }
                    m.f1083a.f1094c = System.currentTimeMillis() - m.f1087e;
                    m.f1083a.f1095d = SystemClock.currentThreadTimeMillis() - m.f1091i;
                    a.a.a.a.y.d.a("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new f(new p(hashMap)));
                    f1051e = arrayList;
                    f1052f = true;
                    FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f1048b;
                    if (sdkInitializeCallback != null) {
                        sdkInitializeCallback.onComplete();
                    }
                    f1048b = null;
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
        a.a.a.a.y.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (aVar != null) {
        }
    }
}
