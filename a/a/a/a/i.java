package a.a.a.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.AdView;
import com.baidu.mobads.MobadsPermissionSettings;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f964a = new a(Looper.getMainLooper());
    public static final Handler c;
    public static List<FunAdFactory> e;
    public static boolean f;
    public static FunAdSdk.SdkInitializeCallback zD;
    public static final c zE;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 100) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject();
                    a.a.a.a.v.f.c.b(jSONObject);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.get(next));
                    }
                } catch (JSONException e) {
                }
                try {
                    a.a.a.a.b.f hv = new a.a.a.a.b.b("https://cd.xdplt.com/v2/z", new a.a.a.a.b.e(hashMap)).hv();
                    if (hv != null && hv.f958a == 200) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(hv.b);
                            int i2 = jSONObject2.getInt(Constants.KEYS.RET);
                            a.a.a.a.v.d.a("Download online ad config response ret: " + i2, new Object[0]);
                            if (i2 == 200) {
                                try {
                                    if (new a.a.a.a.a.b().a(a.a.a.a.v.a.a(jSONObject2.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                                        i.f964a.sendEmptyMessage(200);
                                    }
                                } catch (Exception e2) {
                                    a.a.a.a.v.d.a(e2);
                                }
                            }
                        } catch (JSONException e3) {
                            a.a.a.a.v.d.a(e3);
                        }
                    } else {
                        a.a.a.a.v.d.b("Pull ad config failed.", new Object[0]);
                    }
                } catch (IOException e4) {
                    a.a.a.a.v.d.a(e4);
                }
                a.a.a.a.v.b.f1006a.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                i.a();
            } else if (i == 101) {
                a.a.a.a.a.b bVar = new a.a.a.a.a.b();
                String str = FunAdSdk.getFunAdConfig().appId;
                String str2 = null;
                try {
                    a.a.a.a.v.d.c("Start load config from assets.", new Object[0]);
                    InputStream open = FunAdSdk.getAppContext().getAssets().open(str + ".json");
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
                } catch (Exception e5) {
                    a.a.a.a.v.d.a(e5, 6, "The initialized config from assets cannot be loaded.", new Object[0]);
                }
                if (bVar.a(str2)) {
                    a.a.a.a.v.d.c("Config from assets parsed over.", new Object[0]);
                    i.f964a.obtainMessage(200).sendToTarget();
                    return;
                }
                a.a.a.a.v.d.b("Config from assets parsed failed.", new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public final HashMap<String, r> b = new HashMap<>();
        public a.a.a.a.a.a zF;
    }

    static {
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        c = new b(handlerThread.getLooper());
        zE = new c();
    }

    public static r ba(String str) {
        r rVar;
        c cVar = zE;
        synchronized (cVar) {
            if (cVar.zF == null) {
                a.a.a.a.v.d.a("Cannot get slotId without AdConfig updated.", new Object[0]);
                rVar = null;
            } else {
                rVar = cVar.b.get(str);
            }
        }
        return rVar;
    }

    public static String a(String str) {
        a.a.a.a.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = zE;
        synchronized (cVar) {
            aVar = cVar.zF;
        }
        if (aVar == null) {
            a.a.a.a.v.d.a("No adConfig found now.", new Object[0]);
            return null;
        }
        for (a.a.a.a.a.e eVar : aVar.b) {
            if (eVar.c.equals(str)) {
                return eVar.b;
            }
        }
        a.a.a.a.v.d.a("No target ssp found for platform:%s", str);
        return null;
    }

    public static void a() {
        long j = 0;
        if (FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            long j2 = a.a.a.a.v.b.f1006a.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = a.a.a.a.v.b.f1006a.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            a.a.a.a.v.d.c("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            c.removeMessages(100);
            c.sendEmptyMessageDelayed(100, max);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [13=4] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[Catch: all -> 0x011b, TryCatch #1 {, blocks: (B:22:0x0070, B:24:0x0074, B:26:0x007a, B:33:0x0093, B:37:0x00a6, B:38:0x00b1, B:39:0x00be, B:41:0x00c4, B:42:0x00d1, B:44:0x00d7, B:46:0x00e7, B:48:0x00f1, B:52:0x00fa, B:53:0x0102, B:55:0x0108, B:60:0x011e, B:61:0x0126, B:63:0x012c), top: B:125:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(boolean z) {
        a.a.a.a.a.a aVar;
        boolean z2;
        ActivityManager activityManager;
        String str;
        boolean z3;
        boolean z4;
        c cVar;
        byte[] decode;
        a.a.a.a.v.d.c("tryInitialize", new Object[0]);
        a();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        String string = a.a.a.a.v.b.f1006a.getString("key_adcfg", null);
        if (string == null || (decode = Base64.decode(string, 0)) == null) {
            aVar = null;
        } else {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                aVar = new a.a.a.a.a.a(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                a.a.a.a.v.d.a(e2);
                aVar = null;
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(aVar != null);
        objArr[1] = Boolean.valueOf(z);
        a.a.a.a.v.d.c("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
        if (aVar == null) {
            if (z) {
                c.obtainMessage(101).sendToTarget();
                return;
            }
            return;
        }
        c cVar2 = zE;
        synchronized (cVar2) {
            a.a.a.a.a.a aVar2 = cVar2.zF;
            if (aVar2 != null) {
                if (aVar2.equals(aVar)) {
                    a.a.a.a.v.d.a("New AdConfig equals old one, give up updating it", new Object[0]);
                    cVar = cVar2;
                } else {
                    a.a.a.a.a.a aVar3 = cVar2.zF;
                    if (aVar3.b.size() == aVar.b.size()) {
                        HashSet hashSet = new HashSet(aVar.b);
                        for (a.a.a.a.a.e eVar : aVar3.b) {
                            Iterator it = hashSet.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                                a.a.a.a.a.e eVar2 = (a.a.a.a.a.e) it.next();
                                if (eVar.c.equals(eVar2.c) && eVar.b.equals(eVar2.b)) {
                                    z4 = true;
                                    it.remove();
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
                            cVar = cVar2;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                }
                z2 = false;
            }
            cVar2.zF = aVar;
            for (a.a.a.a.a.d dVar : aVar.c) {
                cVar2.b.put(dVar.b, new r(dVar));
            }
            for (a.a.a.a.a.c cVar3 : cVar2.zF.d) {
                cVar2.b.put(cVar3.b, new r(cVar3));
            }
            z2 = true;
        }
        if (!z2) {
            a.a.a.a.v.d.a("Do not need to reset FunAdFactory.", new Object[0]);
        } else if (e == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            Context context = funAdConfig.appContext;
            k.b();
            for (a.a.a.a.a.e eVar3 : aVar.b) {
                if (!TextUtils.isEmpty(eVar3.b)) {
                    k.d = System.currentTimeMillis();
                    k.h = SystemClock.currentThreadTimeMillis();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str2 = eVar3.c;
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case 3407:
                            if (str2.equals(FunAdSdk.PLATFORM_JY)) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 3432:
                            if (str2.equals(FunAdSdk.PLATFORM_KS)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 98810:
                            if (str2.equals(FunAdSdk.PLATFORM_CSJ)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 102199:
                            if (str2.equals(FunAdSdk.PLATFORM_GDT)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str2.equals(FunAdSdk.PLATFORM_BAIDU)) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            TTAdSdk.init(context, new TTAdConfig.Builder().appId(eVar3.b).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(false).asyncInit(true).directDownloadNetworkType(4, 1).build());
                            hashMap.put(eVar3.c, new a.a.a.a.r.a.b.b());
                            break;
                        case 1:
                            KsAdSDK.init(context, new SdkConfig.Builder().appId(eVar3.b).appName(funAdConfig.appName).showNotification(true).debug(false).canReadICCID(true).canReadNearbyWifiList(true).canReadMacAddress(true).build());
                            hashMap.put(eVar3.c, new a.a.a.a.r.a.b.e());
                            break;
                        case 2:
                            GDTADManager.getInstance().initWith(context, eVar3.b);
                            GlobalSetting.setChannel(3);
                            hashMap.put(eVar3.c, new a.a.a.a.r.a.b.c());
                            break;
                        case 3:
                            AdView.setAppSid(context, eVar3.b);
                            MobadsPermissionSettings.setPermissionReadDeviceID(true);
                            MobadsPermissionSettings.setPermissionAppList(true);
                            MobadsPermissionSettings.setPermissionLocation(true);
                            MobadsPermissionSettings.setPermissionStorage(true);
                            if (Build.VERSION.SDK_INT >= 28) {
                                if (context != null && (activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) != null) {
                                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                        if (runningAppProcessInfo.pid == Process.myPid()) {
                                            str = runningAppProcessInfo.processName;
                                            if (!context.getPackageName().equals(str)) {
                                                WebView.setDataDirectorySuffix(str);
                                            }
                                        }
                                    }
                                }
                                str = null;
                                if (!context.getPackageName().equals(str)) {
                                }
                            }
                            hashMap.put(eVar3.c, new a.a.a.a.r.a.b.a());
                            break;
                        case 4:
                            PBInitialize.init(context, eVar3.b);
                            hashMap.put(eVar3.c, new a.a.a.a.r.a.b.d());
                            break;
                    }
                    k.zO.h.put(eVar3.c, Long.valueOf(System.currentTimeMillis() - k.d));
                    k.zO.i.put(ExifInterface.GPS_DIRECTION_TRUE + eVar3.c, Long.valueOf(SystemClock.currentThreadTimeMillis() - k.h));
                    a.a.a.a.v.d.a("Ssp:%s initialized with %dms consumed.", eVar3.c, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                }
            }
            k.zO.d = System.currentTimeMillis() - k.e;
            k.zO.e = SystemClock.currentThreadTimeMillis() - k.i;
            k.zO.a();
            a.a.a.a.v.d.a("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new e(new n(hashMap)));
            e = arrayList;
            f = true;
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = zD;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            zD = null;
        }
    }
}
