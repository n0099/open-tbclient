package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.SilentDownloaderManager;
import com.baidu.cyberplayer.sdk.f;
import com.baidu.cyberplayer.sdk.q;
import com.baidu.cyberplayer.sdk.remote.h;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.b;
import com.baidu.cyberplayer.sdk.statistics.i;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class CyberCoreLoaderManager {
    public static Map<Integer, Object> a = new ConcurrentHashMap();
    public static volatile CyberCoreLoaderManager b = null;
    public Context g;
    public final Object d = new Object();
    public volatile int f = 0;
    public long h = -1;
    public long i = -1;
    public Handler j = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            int i2 = 0;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                for (int i3 = 0; i3 < CyberCoreLoaderManager.this.c.size(); i3++) {
                                    a aVar = (a) CyberCoreLoaderManager.this.c.get(i3);
                                    if (aVar.c != null && (aVar.c instanceof CyberPlayerManager.InstallListener2)) {
                                        ((CyberPlayerManager.InstallListener2) aVar.c).onInstallInfo(message.arg1, 0, message.obj);
                                    }
                                }
                            }
                        } else {
                            Object obj = message.obj;
                            if (obj != null) {
                                ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                            }
                        }
                    } else {
                        while (i2 < CyberCoreLoaderManager.this.c.size()) {
                            a aVar2 = (a) CyberCoreLoaderManager.this.c.get(i2);
                            if (aVar2.c != null) {
                                aVar2.c.onInstallProgress(message.arg1, message.arg2);
                                if (aVar2.c instanceof CyberPlayerManager.InstallListener2) {
                                    ((CyberPlayerManager.InstallListener2) aVar2.c).onInstallInfo(103, message.arg2, null);
                                }
                            }
                            i2++;
                        }
                    }
                } else {
                    synchronized (CyberCoreLoaderManager.this.d) {
                        while (i2 < CyberCoreLoaderManager.this.c.size()) {
                            a aVar3 = (a) CyberCoreLoaderManager.this.c.get(i2);
                            if (aVar3.c != null) {
                                aVar3.c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                            }
                            i2++;
                        }
                        CyberCoreLoaderManager.this.c(message.arg1);
                    }
                }
            } else {
                synchronized (CyberCoreLoaderManager.this.d) {
                    while (i2 < CyberCoreLoaderManager.this.c.size()) {
                        a aVar4 = (a) CyberCoreLoaderManager.this.c.get(i2);
                        if (aVar4.c != null && CyberPlayerManager.isCoreLoaded(aVar4.b)) {
                            aVar4.c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i2++;
                    }
                    CyberCoreLoaderManager.this.c(message.arg1);
                }
            }
            super.handleMessage(message);
        }
    };
    public List<a> c = new ArrayList();
    public ExecutorService e = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public class a {
        public int b;
        public CyberPlayerManager.InstallListener c;

        public a(int i, CyberPlayerManager.InstallListener installListener) {
            this.b = i;
            this.c = installListener;
        }
    }

    public static CyberCoreLoaderManager a() {
        if (b == null) {
            synchronized (CyberCoreLoaderManager.class) {
                if (b == null) {
                    b = new CyberCoreLoaderManager();
                }
            }
        }
        return b;
    }

    public static Object a(int i) {
        if (a.isEmpty()) {
            CyberLog.i("CyberCoreLoaderManager", "getLibPath failed: mLibPathMap is empty");
            return "";
        }
        return a.get(Integer.valueOf(i));
    }

    @Keep
    public static String getLatestLoadedVersion(String str) {
        CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
        return cyberCfgManager.getPrefStr("latest_success_loaded_" + str, "");
    }

    private boolean b(int i) {
        synchronized (this.d) {
            if (i != (this.f & i)) {
                this.f = i | this.f;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().b == i) {
                it.remove();
            }
        }
        this.f = (i ^ Integer.MAX_VALUE) & this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        if (q.o() && map != null) {
            map.put("cyber-media-dex", f.a());
            Map<String, String> a2 = f.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (a2 != null) {
                map.putAll(a2);
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        Object obj;
        Object obj2;
        HashMap hashMap = new HashMap();
        hashMap.put("loadcode", String.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("detail", str);
        }
        hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, q.n());
        Map<String, String> a2 = f.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
        if (a2 != null) {
            hashMap.putAll(a2);
        }
        String prefStr = CyberCfgManager.getInstance().getPrefStr("update_type_black", "");
        String prefStr2 = CyberCfgManager.getInstance().getPrefStr("update_version_black", "");
        if (!TextUtils.isEmpty(prefStr) && !TextUtils.isEmpty(prefStr2)) {
            hashMap.put("isallowupdate", "0");
            hashMap.put("updatetype", prefStr);
            hashMap.put("updateversion", prefStr2);
        }
        if (com.baidu.cyberplayer.sdk.loader.a.a().b()) {
            if (!com.baidu.cyberplayer.sdk.loader.a.a().b()) {
                obj2 = "0";
            } else {
                obj2 = "1";
            }
            hashMap.put("isdowngradled", obj2);
        }
        int e = com.baidu.cyberplayer.sdk.loader.a.a().e();
        if (e > 0) {
            hashMap.put("download_count", String.valueOf(e));
            boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("enable_download_zip_xcdn", true);
            if (!cfgBoolValue) {
                obj = "0";
            } else {
                obj = "1";
            }
            hashMap.put("cdn_type", obj);
            if (cfgBoolValue) {
                if (com.baidu.cyberplayer.sdk.loader.a.a().d()) {
                    hashMap.put("xcdn_degrade", "0");
                } else {
                    hashMap.put("xcdn_degrade", "1");
                    String c = com.baidu.cyberplayer.sdk.loader.a.a().c();
                    if (!TextUtils.isEmpty(c)) {
                        hashMap.put("xcdn_degrade_info", c);
                    }
                }
            }
        }
        if (i == 0) {
            long a3 = com.baidu.cyberplayer.sdk.loader.a.a().a(0);
            long a4 = com.baidu.cyberplayer.sdk.loader.a.a().a(1);
            long a5 = com.baidu.cyberplayer.sdk.loader.a.a().a(2);
            if (this.h > 0) {
                hashMap.put("install_t_ms", String.valueOf(System.currentTimeMillis() - this.h));
            }
            long j = this.i;
            if (j >= 0) {
                hashMap.put("init_dp_t_ms", String.valueOf(j));
            }
            if (a5 >= 0) {
                hashMap.put("init_cfg_t_ms", String.valueOf(a5));
            }
            if (a3 >= 0) {
                hashMap.put("loadcore_t_ms", String.valueOf(a3));
            }
            if (a4 >= 0) {
                hashMap.put("loadlibs_t_ms", String.valueOf(a4));
            }
            hashMap.put(HiAnalyticsConstant.BI_KEY_INSTALL_TYPE, String.valueOf(CyberPlayerManager.getInstallType()));
        }
        this.h = -1L;
        q.h();
        b.a(this.g, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DpSessionDatasUploader.getInstance().a(this.g);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        this.i = System.currentTimeMillis() - currentTimeMillis;
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i, map, new CyberPlayerManager.InstallListener2() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                CyberCoreLoaderManager.this.a(i3, str2);
                Message obtainMessage = CyberCoreLoaderManager.this.j.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                CyberCoreLoaderManager.this.j.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i2, int i3, Object obj) {
                Message obtainMessage = CyberCoreLoaderManager.this.j.obtainMessage();
                switch (i2) {
                    case 100:
                    case 101:
                    case 102:
                        obtainMessage.what = 4;
                        obtainMessage.arg1 = i2;
                        obtainMessage.arg2 = i3;
                        obtainMessage.obj = obj;
                        CyberCoreLoaderManager.a.put(Integer.valueOf(i2), obtainMessage.obj);
                        CyberCoreLoaderManager.this.j.sendMessage(obtainMessage);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Message obtainMessage = CyberCoreLoaderManager.this.j.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                CyberCoreLoaderManager.this.j.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                CyberCoreLoaderManager.this.a(0, "");
                if (q.o() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    h.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberCoreLoaderManager.this.a(CyberPlayerManager.getInstallOpts()), CyberPlayerManager.getPcdnType());
                }
                CyberCoreLoaderManager.this.e();
                Message obtainMessage = CyberCoreLoaderManager.this.j.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i2;
                CyberCoreLoaderManager.this.j.sendMessage(obtainMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (q.o()) {
            CyberCfgManager.getInstance().removePref("latest_success_loaded_cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("latest_success_loaded_cyber-media-dex", f.a());
            Map<String, String> a2 = f.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
            Map<String, String> a3 = f.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (a2 != null && a3 != null) {
                for (Map.Entry<String, String> entry : a2.entrySet()) {
                    CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
                    cyberCfgManager.removePref("latest_success_loaded_" + entry.getKey());
                    if (!TextUtils.isEmpty(a3.get(entry.getKey()))) {
                        CyberCfgManager cyberCfgManager2 = CyberCfgManager.getInstance();
                        cyberCfgManager2.setPrefStr("latest_success_loaded_" + entry.getKey(), a3.get(entry.getKey()));
                    }
                }
            }
        }
    }

    public String c() {
        CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
        String str = SDKVersion.VERSION;
        String cfgValue = cyberCfgManager.getCfgValue("update_core_ver", SDKVersion.VERSION);
        if (SilentDownloaderManager.getInstance().a(cfgValue)) {
            String latestLoadedVersion = getLatestLoadedVersion("cyber-media-dex");
            if (CyberCfgManager.compareVersion(latestLoadedVersion, SDKVersion.VERSION) == 1) {
                str = latestLoadedVersion;
            }
            CyberLog.i("CyberCoreLoaderManager", "need silent download, last success loaded:" + latestLoadedVersion + " loadableVersion:" + str);
            cfgValue = str;
        }
        String cfgValue2 = CyberCfgManager.getInstance().getCfgValue("core_external_path", "");
        if (!TextUtils.isEmpty(cfgValue2) && new File(cfgValue2).exists()) {
            String b2 = com.baidu.cyberplayer.sdk.utils.a.b(cfgValue2, q.b());
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
            return cfgValue;
        }
        return cfgValue;
    }

    public void a(final String str, final int i, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        if (this.h == -1) {
            this.h = System.currentTimeMillis();
            if (q.o()) {
                i.a().a(System.currentTimeMillis());
            }
        }
        this.g = CyberPlayerManager.getApplicationContext();
        synchronized (this.d) {
            if (CyberPlayerManager.isCoreLoaded(i)) {
                if (installListener != null) {
                    Message obtainMessage = this.j.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = installListener;
                    this.j.sendMessage(obtainMessage);
                }
                if (installListener != null) {
                    b();
                }
                return;
            }
            if (installListener != null) {
                this.c.add(new a(i, installListener));
            }
            if (b(i)) {
                this.e.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CyberCoreLoaderManager.this.a(str, i, map);
                        SilentDownloaderManager.getInstance().a();
                    }
                });
            }
        }
    }

    public void b() {
        try {
            for (Map.Entry<Integer, Object> entry : a.entrySet()) {
                Message obtainMessage = this.j.obtainMessage();
                obtainMessage.what = 4;
                obtainMessage.arg1 = entry.getKey().intValue();
                obtainMessage.obj = entry.getValue();
                this.j.sendMessage(obtainMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
