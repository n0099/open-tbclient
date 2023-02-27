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
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.downloader.SilentDownloaderManager;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.cyberplayer.sdk.remote.g;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.b;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class CyberCoreLoaderManager {
    public static CyberCoreLoaderManager a;
    public Context f;
    public final Object c = new Object();
    public volatile int e = 0;
    public long g = -1;
    public long h = -1;
    public Handler i = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            int i2 = 0;
            if (i == 0) {
                synchronized (CyberCoreLoaderManager.this.c) {
                    while (i2 < CyberCoreLoaderManager.this.b.size()) {
                        a aVar = (a) CyberCoreLoaderManager.this.b.get(i2);
                        if (aVar.c != null && CyberPlayerManager.isCoreLoaded(aVar.b)) {
                            aVar.c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i2++;
                    }
                    CyberCoreLoaderManager.this.b(message.arg1);
                }
            } else if (i == 1) {
                synchronized (CyberCoreLoaderManager.this.c) {
                    while (i2 < CyberCoreLoaderManager.this.b.size()) {
                        a aVar2 = (a) CyberCoreLoaderManager.this.b.get(i2);
                        if (aVar2.c != null) {
                            aVar2.c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                        }
                        i2++;
                    }
                    CyberCoreLoaderManager.this.b(message.arg1);
                }
            } else if (i == 2) {
                while (i2 < CyberCoreLoaderManager.this.b.size()) {
                    a aVar3 = (a) CyberCoreLoaderManager.this.b.get(i2);
                    if (aVar3.c != null) {
                        aVar3.c.onInstallProgress(message.arg1, message.arg2);
                        if (aVar3.c instanceof CyberPlayerManager.InstallListener2) {
                            ((CyberPlayerManager.InstallListener2) aVar3.c).onInstallInfo(103, message.arg2, null);
                        }
                    }
                    i2++;
                }
            } else if (i == 3) {
                Object obj = message.obj;
                if (obj != null) {
                    ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                }
            } else if (i == 4) {
                for (int i3 = 0; i3 < CyberCoreLoaderManager.this.b.size(); i3++) {
                    a aVar4 = (a) CyberCoreLoaderManager.this.b.get(i3);
                    if (aVar4.c != null && (aVar4.c instanceof CyberPlayerManager.InstallListener2)) {
                        ((CyberPlayerManager.InstallListener2) aVar4.c).onInstallInfo(message.arg1, 0, message.obj);
                    }
                }
            }
            super.handleMessage(message);
        }
    };
    public List<a> b = new ArrayList();
    public ExecutorService d = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public class a {
        public int b;
        public CyberPlayerManager.InstallListener c;

        public a(int i, CyberPlayerManager.InstallListener installListener) {
            this.b = i;
            this.c = installListener;
        }
    }

    public static synchronized CyberCoreLoaderManager a() {
        CyberCoreLoaderManager cyberCoreLoaderManager;
        synchronized (CyberCoreLoaderManager.class) {
            if (a == null) {
                a = new CyberCoreLoaderManager();
            }
            cyberCoreLoaderManager = a;
        }
        return cyberCoreLoaderManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(Map<String, String> map) {
        if (o.m() && map != null) {
            map.put("cyber-media-dex", d.a());
            Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (a2 != null) {
                map.putAll(a2);
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("loadcode", String.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("detail", str);
        }
        hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, o.l());
        Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
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
            hashMap.put("isdowngradled", com.baidu.cyberplayer.sdk.loader.a.a().b() ? "1" : "0");
        }
        if (i == 0) {
            long a3 = com.baidu.cyberplayer.sdk.loader.a.a().a(0);
            long a4 = com.baidu.cyberplayer.sdk.loader.a.a().a(1);
            long a5 = com.baidu.cyberplayer.sdk.loader.a.a().a(2);
            if (this.g > 0) {
                hashMap.put("install_t_ms", String.valueOf(System.currentTimeMillis() - this.g));
            }
            long j = this.h;
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
        this.g = -1L;
        o.h();
        b.a(this.f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DpSessionDatasUploader.getInstance().a(this.f);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        this.h = System.currentTimeMillis() - currentTimeMillis;
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i, map, new CyberPlayerManager.InstallListener2() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                CyberCoreLoaderManager.this.a(i3, str2);
                Message obtainMessage = CyberCoreLoaderManager.this.i.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                CyberCoreLoaderManager.this.i.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
            public void onInstallInfo(int i2, int i3, Object obj) {
                Message obtainMessage = CyberCoreLoaderManager.this.i.obtainMessage();
                switch (i2) {
                    case 100:
                    case 101:
                    case 102:
                        obtainMessage.what = 4;
                        obtainMessage.arg1 = i2;
                        obtainMessage.arg2 = i3;
                        obtainMessage.obj = obj;
                        CyberCoreLoaderManager.this.i.sendMessage(obtainMessage);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Message obtainMessage = CyberCoreLoaderManager.this.i.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                CyberCoreLoaderManager.this.i.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                CyberCoreLoaderManager.this.a(0, "");
                if (o.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberCoreLoaderManager.this.a(CyberPlayerManager.getInstallOpts()));
                }
                CyberCoreLoaderManager.this.c();
                Message obtainMessage = CyberCoreLoaderManager.this.i.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i2;
                CyberCoreLoaderManager.this.i.sendMessage(obtainMessage);
            }
        });
    }

    private boolean a(int i) {
        synchronized (this.c) {
            if (i != (this.e & i)) {
                this.e = i | this.e;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().b == i) {
                it.remove();
            }
        }
        this.e = (i ^ Integer.MAX_VALUE) & this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (o.m()) {
            CyberCfgManager.getInstance().removePref("latest_success_loaded_cyber-media-dex");
            CyberCfgManager.getInstance().setPrefStr("latest_success_loaded_cyber-media-dex", d.a());
            Map<String, String> a2 = d.a(CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION);
            Map<String, String> a3 = d.a(CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION);
            if (a2 == null || a3 == null) {
                return;
            }
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

    @Keep
    public static String getLatestLoadedVersion(String str) {
        CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
        return cyberCfgManager.getPrefStr("latest_success_loaded_" + str, "");
    }

    public void a(final String str, final int i, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        if (this.g == -1) {
            this.g = System.currentTimeMillis();
        }
        this.f = CyberPlayerManager.getApplicationContext();
        synchronized (this.c) {
            if (CyberPlayerManager.isCoreLoaded(i)) {
                if (installListener != null) {
                    Message obtainMessage = this.i.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = installListener;
                    this.i.sendMessage(obtainMessage);
                }
                return;
            }
            if (installListener != null) {
                this.b.add(new a(i, installListener));
            }
            if (a(i)) {
                boolean z = false;
                if (map != null) {
                    String str2 = map.get("enable_sync_install");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            if (Integer.parseInt(str2) == 1) {
                                z = true;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                if (z) {
                    a(str, i, map);
                } else {
                    this.d.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberCoreLoaderManager.this.a(str, i, map);
                            SilentDownloaderManager.getInstance().a();
                        }
                    });
                }
            }
        }
    }

    public String b() {
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
        if (TextUtils.isEmpty(cfgValue2) || !new File(cfgValue2).exists()) {
            return cfgValue;
        }
        String a2 = com.baidu.cyberplayer.sdk.downloader.a.a(cfgValue2, o.b());
        return !TextUtils.isEmpty(a2) ? a2 : cfgValue;
    }
}
