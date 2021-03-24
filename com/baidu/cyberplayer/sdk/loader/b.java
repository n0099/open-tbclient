package com.baidu.cyberplayer.sdk.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.cyberplayer.sdk.remote.g;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.logsystem.basic.LokiService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f4984a;

    /* renamed from: f  reason: collision with root package name */
    public Context f4989f;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4986c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4988e = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4990g = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            int i = message.what;
            int i2 = 0;
            if (i == 0) {
                synchronized (b.this.f4986c) {
                    while (i2 < b.this.f4985b.size()) {
                        a aVar = (a) b.this.f4985b.get(i2);
                        if (aVar.f4999c != null && CyberPlayerManager.isCoreLoaded(aVar.f4998b)) {
                            aVar.f4999c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i2++;
                    }
                    b.this.b(message.arg1);
                }
            } else if (i == 1) {
                synchronized (b.this.f4986c) {
                    while (i2 < b.this.f4985b.size()) {
                        a aVar2 = (a) b.this.f4985b.get(i2);
                        if (aVar2.f4999c != null) {
                            aVar2.f4999c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                        }
                        i2++;
                    }
                    b.this.b(message.arg1);
                }
            } else if (i == 2) {
                while (i2 < b.this.f4985b.size()) {
                    a aVar3 = (a) b.this.f4985b.get(i2);
                    if (aVar3.f4999c != null) {
                        aVar3.f4999c.onInstallProgress(message.arg1, message.arg2);
                    }
                    i2++;
                }
            } else if (i == 3 && (obj = message.obj) != null) {
                ((CyberPlayerManager.InstallListener) obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public List<a> f4985b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4987d = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public int f4998b;

        /* renamed from: c  reason: collision with root package name */
        public CyberPlayerManager.InstallListener f4999c;

        public a(int i, CyberPlayerManager.InstallListener installListener) {
            this.f4998b = i;
            this.f4999c = installListener;
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f4984a == null) {
                f4984a = new b();
            }
            bVar = f4984a;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.cyberplayer.sdk.statistics.b.a(this.f4989f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, (HashMap) obj);
        n.h();
        CyberLog.d("CyberCoreLoaderManager", "onLoad session:" + obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i, map, new CyberPlayerManager.InstallListener() { // from class: com.baidu.cyberplayer.sdk.loader.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(i3));
                hashMap.put("detail", str2);
                hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, n.l());
                b.this.a(hashMap);
                Message obtainMessage = b.this.f4990g.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                b.this.f4990g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Message obtainMessage = b.this.f4990g.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                b.this.f4990g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(0));
                hashMap.put("corever", CyberPlayerManager.getCoreVersion());
                hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, n.l());
                b.this.a(hashMap);
                if (n.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberPlayerManager.getInstallOpts());
                }
                Message obtainMessage = b.this.f4990g.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i2;
                b.this.f4990g.sendMessage(obtainMessage);
            }
        });
    }

    private boolean a(int i) {
        synchronized (this.f4986c) {
            if (i != (this.f4988e & i)) {
                this.f4988e = i | this.f4988e;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Iterator<a> it = this.f4985b.iterator();
        while (it.hasNext()) {
            if (it.next().f4998b == i) {
                it.remove();
            }
        }
        this.f4988e = (i ^ Integer.MAX_VALUE) & this.f4988e;
    }

    public void a(final String str, final int i, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f4989f = CyberPlayerManager.getApplicationContext();
        synchronized (this.f4986c) {
            if (CyberPlayerManager.isCoreLoaded(i)) {
                if (installListener != null) {
                    Message obtainMessage = this.f4990g.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = installListener;
                    this.f4990g.sendMessage(obtainMessage);
                }
                return;
            }
            if (installListener != null) {
                this.f4985b.add(new a(i, installListener));
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
                    this.f4987d.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(str, i, map);
                        }
                    });
                }
            }
        }
    }
}
