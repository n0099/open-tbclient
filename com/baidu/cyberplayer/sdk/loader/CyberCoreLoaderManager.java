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

    /* renamed from: a  reason: collision with root package name */
    public static CyberCoreLoaderManager f4902a;

    /* renamed from: f  reason: collision with root package name */
    public Context f4907f;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4904c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4906e = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4908g = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            int i2 = message.what;
            int i3 = 0;
            if (i2 == 0) {
                synchronized (CyberCoreLoaderManager.this.f4904c) {
                    while (i3 < CyberCoreLoaderManager.this.f4903b.size()) {
                        a aVar = (a) CyberCoreLoaderManager.this.f4903b.get(i3);
                        if (aVar.f4917c != null && CyberPlayerManager.isCoreLoaded(aVar.f4916b)) {
                            aVar.f4917c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i3++;
                    }
                    CyberCoreLoaderManager.this.b(message.arg1);
                }
            } else if (i2 == 1) {
                synchronized (CyberCoreLoaderManager.this.f4904c) {
                    while (i3 < CyberCoreLoaderManager.this.f4903b.size()) {
                        a aVar2 = (a) CyberCoreLoaderManager.this.f4903b.get(i3);
                        if (aVar2.f4917c != null) {
                            aVar2.f4917c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                        }
                        i3++;
                    }
                    CyberCoreLoaderManager.this.b(message.arg1);
                }
            } else if (i2 == 2) {
                while (i3 < CyberCoreLoaderManager.this.f4903b.size()) {
                    a aVar3 = (a) CyberCoreLoaderManager.this.f4903b.get(i3);
                    if (aVar3.f4917c != null) {
                        aVar3.f4917c.onInstallProgress(message.arg1, message.arg2);
                    }
                    i3++;
                }
            } else if (i2 == 3 && (obj = message.obj) != null) {
                ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public List<a> f4903b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4905d = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public int f4916b;

        /* renamed from: c  reason: collision with root package name */
        public CyberPlayerManager.InstallListener f4917c;

        public a(int i2, CyberPlayerManager.InstallListener installListener) {
            this.f4916b = i2;
            this.f4917c = installListener;
        }
    }

    public static synchronized CyberCoreLoaderManager a() {
        CyberCoreLoaderManager cyberCoreLoaderManager;
        synchronized (CyberCoreLoaderManager.class) {
            if (f4902a == null) {
                f4902a = new CyberCoreLoaderManager();
            }
            cyberCoreLoaderManager = f4902a;
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
    public void a(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("loadcode", String.valueOf(i2));
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
        o.h();
        b.a(this.f4907f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        DpSessionDatasUploader.getInstance().a(this.f4907f);
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i2, map, new CyberPlayerManager.InstallListener() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i3, int i4, String str2) {
                CyberCoreLoaderManager.this.a(i4, str2);
                Message obtainMessage = CyberCoreLoaderManager.this.f4908g.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i3;
                obtainMessage.arg2 = i4;
                obtainMessage.obj = str2;
                CyberCoreLoaderManager.this.f4908g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i3, int i4) {
                Message obtainMessage = CyberCoreLoaderManager.this.f4908g.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i3;
                obtainMessage.arg2 = i4;
                CyberCoreLoaderManager.this.f4908g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i3, String str2) {
                CyberCoreLoaderManager.this.a(0, "");
                if (o.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberCoreLoaderManager.this.a(CyberPlayerManager.getInstallOpts()));
                }
                CyberCoreLoaderManager.this.c();
                Message obtainMessage = CyberCoreLoaderManager.this.f4908g.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i3;
                CyberCoreLoaderManager.this.f4908g.sendMessage(obtainMessage);
            }
        });
    }

    private boolean a(int i2) {
        synchronized (this.f4904c) {
            if (i2 != (this.f4906e & i2)) {
                this.f4906e = i2 | this.f4906e;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Iterator<a> it = this.f4903b.iterator();
        while (it.hasNext()) {
            if (it.next().f4916b == i2) {
                it.remove();
            }
        }
        this.f4906e = (i2 ^ Integer.MAX_VALUE) & this.f4906e;
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

    public void a(final String str, final int i2, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f4907f = CyberPlayerManager.getApplicationContext();
        synchronized (this.f4904c) {
            if (CyberPlayerManager.isCoreLoaded(i2)) {
                if (installListener != null) {
                    Message obtainMessage = this.f4908g.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i2;
                    obtainMessage.obj = installListener;
                    this.f4908g.sendMessage(obtainMessage);
                }
                return;
            }
            if (installListener != null) {
                this.f4903b.add(new a(i2, installListener));
            }
            if (a(i2)) {
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
                    a(str, i2, map);
                } else {
                    this.f4905d.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CyberCoreLoaderManager.this.a(str, i2, map);
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
