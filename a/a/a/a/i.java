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
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f1040a = new a(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static FunAdSdk.SdkInitializeCallback f1041b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f1042c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f1043d;

    /* renamed from: e  reason: collision with root package name */
    public static List<FunAdFactory> f1044e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1045f;

    /* loaded from: classes.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 200) {
                return;
            }
            i.a(false);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            a.a.a.a.v.f a2;
            a.a.a.a.x.f.d a3;
            Integer valueOf;
            JSONObject jSONObject;
            int i2;
            int i3 = message.what;
            int i4 = -1;
            int i5 = 0;
            if (i3 != 100) {
                if (i3 == 101) {
                    a.a.a.a.u.b bVar = new a.a.a.a.u.b();
                    String str = FunAdSdk.getFunAdConfig().appId;
                    String str2 = null;
                    try {
                        a.a.a.a.x.d.c("Start load config from assets.", new Object[0]);
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
                        a.a.a.a.x.d.c("Config from assets load over.", new Object[0]);
                        open.close();
                        if (!TextUtils.isEmpty(stringWriter2)) {
                            str2 = a.a.a.a.x.a.a(stringWriter2, str);
                            a.a.a.a.x.d.c("Config from assets decrypted over.", new Object[0]);
                        }
                    } catch (Exception e2) {
                        a.a.a.a.x.d.a(e2, 6, "The initialized config from assets cannot be loaded.", new Object[0]);
                    }
                    if (!bVar.a(str2)) {
                        a.a.a.a.x.d.b("Config from assets parsed failed.", new Object[0]);
                        return;
                    }
                    a.a.a.a.x.d.c("Config from assets parsed over.", new Object[0]);
                    i.f1040a.obtainMessage(200).sendToTarget();
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject2 = new JSONObject();
                a.a.a.a.x.f.c.b(jSONObject2);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
            } catch (JSONException unused) {
            }
            try {
                a2 = new a.a.a.a.v.b("https://cd.xdplt.com/v2/z", new a.a.a.a.v.e(hashMap)).a();
            } catch (IOException e3) {
                a.a.a.a.x.d.a(e3);
            }
            if (a2 != null && a2.f1352a == 200) {
                try {
                    jSONObject = new JSONObject(a2.f1353b);
                    i2 = jSONObject.getInt(Constants.KEYS.RET);
                    a.a.a.a.x.d.a("Download online ad config response ret: " + i2, new Object[0]);
                } catch (JSONException e4) {
                    a.a.a.a.x.d.a(e4);
                    a3 = a.a.a.a.x.f.d.a();
                }
                if (i2 == 200) {
                    try {
                        if (new a.a.a.a.u.b().a(a.a.a.a.x.a.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                            i.f1040a.sendEmptyMessage(200);
                        } else {
                            i5 = -3;
                        }
                    } catch (Exception e5) {
                        a.a.a.a.x.d.a(e5);
                        a3 = a.a.a.a.x.f.d.a();
                        i4 = -2;
                        valueOf = Integer.valueOf(i4);
                        a3.a("k_ppcfg", "st", valueOf);
                        a.a.a.a.x.b.f1360a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                        i.a();
                    }
                    if (i5 != 0) {
                        a3 = a.a.a.a.x.f.d.a();
                        valueOf = Integer.valueOf(i5);
                        a3.a("k_ppcfg", "st", valueOf);
                    }
                }
                a.a.a.a.x.b.f1360a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                i.a();
            }
            a.a.a.a.x.d.b("Pull ad config failed.", new Object[0]);
            a.a.a.a.x.b.f1360a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
            i.a();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public a.a.a.a.u.a f1046a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<String, s> f1047b = new HashMap<>();
    }

    static {
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        f1042c = new b(handlerThread.getLooper());
        f1043d = new c();
    }

    public static String a(String str) {
        a.a.a.a.u.a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = f1043d;
        synchronized (cVar) {
            aVar = cVar.f1046a;
        }
        if (aVar == null) {
            a.a.a.a.x.d.a("No adConfig found now.", new Object[0]);
            return null;
        }
        for (a.a.a.a.u.e eVar : aVar.f1304b) {
            if (eVar.f1331c.equals(str)) {
                return eVar.f1330b;
            }
        }
        a.a.a.a.x.d.a("No target ssp found for platform:%s", str);
        return null;
    }

    public static s b(String str) {
        s sVar;
        c cVar = f1043d;
        synchronized (cVar) {
            if (cVar.f1046a == null) {
                a.a.a.a.x.d.a("Cannot get slotId without AdConfig updated.", new Object[0]);
                sVar = null;
            } else {
                sVar = cVar.f1047b.get(str);
            }
        }
        return sVar;
    }

    public static void a() {
        if (FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            long j = 0;
            long j2 = a.a.a.a.x.b.f1360a.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = a.a.a.a.x.b.f1360a.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            a.a.a.a.x.d.c("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            f1042c.removeMessages(100);
            f1042c.sendEmptyMessageDelayed(100, max);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3 A[Catch: all -> 0x0311, TRY_LEAVE, TryCatch #0 {, blocks: (B:22:0x0066, B:24:0x006a, B:26:0x0070, B:27:0x0078, B:46:0x00d3, B:30:0x0089, B:31:0x0096, B:33:0x009c, B:34:0x00a6, B:36:0x00ac, B:38:0x00bc, B:40:0x00c6, B:49:0x00dd, B:50:0x00e5, B:52:0x00eb, B:53:0x00fe, B:54:0x0106, B:56:0x010c), top: B:115:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(boolean z) {
        a.a.a.a.u.a aVar;
        boolean z2;
        char c2;
        boolean z3;
        boolean z4;
        byte[] decode;
        a.a.a.a.x.d.c("tryInitialize", new Object[0]);
        a();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        String string = a.a.a.a.x.b.f1360a.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                aVar = new a.a.a.a.u.a(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                a.a.a.a.x.d.a(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aVar == null);
            objArr[1] = Boolean.valueOf(z);
            a.a.a.a.x.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (aVar != null) {
                if (z) {
                    f1042c.obtainMessage(101).sendToTarget();
                    return;
                }
                return;
            }
            c cVar = f1043d;
            synchronized (cVar) {
                a.a.a.a.u.a aVar2 = cVar.f1046a;
                if (aVar2 != null) {
                    if (aVar2.equals(aVar)) {
                        a.a.a.a.x.d.a("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        a.a.a.a.u.a aVar3 = cVar.f1046a;
                        if (aVar3.f1304b.size() == aVar.f1304b.size()) {
                            HashSet hashSet = new HashSet(aVar.f1304b);
                            for (a.a.a.a.u.e eVar : aVar3.f1304b) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    a.a.a.a.u.e eVar2 = (a.a.a.a.u.e) it.next();
                                    if (eVar.f1331c.equals(eVar2.f1331c) && eVar.f1330b.equals(eVar2.f1330b)) {
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
                                a.a.a.a.x.d.a("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                cVar.f1046a = aVar;
                for (a.a.a.a.u.d dVar : aVar.f1305c) {
                    cVar.f1047b.put(dVar.f1320b, new s(dVar));
                }
                for (a.a.a.a.u.c cVar2 : cVar.f1046a.f1306d) {
                    cVar.f1047b.put(cVar2.f1313b, new s(cVar2));
                }
                z2 = true;
            }
            if (!z2) {
                a.a.a.a.x.d.a("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            } else if (f1044e == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = System.currentTimeMillis();
                    Context context = funAdConfig.appContext;
                    l.b();
                    for (a.a.a.a.u.e eVar3 : aVar.f1304b) {
                        if (!TextUtils.isEmpty(eVar3.f1330b)) {
                            l.f1079d = System.currentTimeMillis();
                            l.f1083h = SystemClock.currentThreadTimeMillis();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            String str = eVar3.f1331c;
                            int hashCode = str.hashCode();
                            if (hashCode == 3407) {
                                if (str.equals(FunAdSdk.PLATFORM_JY)) {
                                    c2 = 3;
                                    if (c2 != 0) {
                                    }
                                    l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                    l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                    a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else if (hashCode == 3432) {
                                if (str.equals(FunAdSdk.PLATFORM_KS)) {
                                    c2 = 1;
                                    if (c2 != 0) {
                                    }
                                    l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                    l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                    a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else if (hashCode != 98810) {
                                if (hashCode == 102199 && str.equals(FunAdSdk.PLATFORM_GDT)) {
                                    c2 = 2;
                                    if (c2 != 0) {
                                        TTAdSdk.init(context, new TTAdConfig.Builder().appId(eVar3.f1330b).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).asyncInit(true).directDownloadNetworkType(4, 1).build());
                                        hashMap.put(eVar3.f1331c, new a.a.a.a.t.a.a.a());
                                    } else if (c2 == 1) {
                                        KsAdSDK.init(context, new SdkConfig.Builder().appId(eVar3.f1330b).appName(funAdConfig.appName).showNotification(true).debug(false).canReadICCID(true).canReadNearbyWifiList(true).canReadMacAddress(true).build());
                                        hashMap.put(eVar3.f1331c, new a.a.a.a.t.a.a.d());
                                    } else if (c2 == 2) {
                                        GDTADManager.getInstance().initWith(context, eVar3.f1330b);
                                        GlobalSetting.setChannel(3);
                                        hashMap.put(eVar3.f1331c, new a.a.a.a.t.a.a.b());
                                    } else if (c2 == 3) {
                                        PBInitialize.init(context, eVar3.f1330b);
                                        hashMap.put(eVar3.f1331c, new a.a.a.a.t.a.a.c());
                                    }
                                    l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                    l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                    a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            } else {
                                if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                                    c2 = 0;
                                    if (c2 != 0) {
                                    }
                                    l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                    l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                    a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                }
                                c2 = 65535;
                                if (c2 != 0) {
                                }
                                l.f1076a.f1092h.put(eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - l.f1079d));
                                l.f1076a.f1093i.put("T" + eVar3.f1331c, Long.valueOf(SystemClock.currentThreadTimeMillis() - l.f1083h));
                                a.a.a.a.x.d.a("Ssp:%s initialized with %dms consumed.", eVar3.f1331c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            }
                        }
                    }
                    l.f1076a.f1088d = System.currentTimeMillis() - l.f1080e;
                    l.f1076a.f1089e = SystemClock.currentThreadTimeMillis() - l.f1084i;
                    l.f1076a.a();
                    a.a.a.a.x.d.a("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new e(new o(hashMap)));
                    f1044e = arrayList;
                    f1045f = true;
                    FunAdSdk.SdkInitializeCallback sdkInitializeCallback = f1041b;
                    if (sdkInitializeCallback != null) {
                        sdkInitializeCallback.onComplete();
                    }
                    f1041b = null;
                    return;
                }
                throw new RuntimeException("Wrong thread");
            } else {
                return;
            }
        }
        aVar = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(aVar == null);
        objArr2[1] = Boolean.valueOf(z);
        a.a.a.a.x.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (aVar != null) {
        }
    }
}
