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
    public static b f4901a;

    /* renamed from: f  reason: collision with root package name */
    public Context f4906f;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4903c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4905e = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4907g = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.loader.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            int i2 = message.what;
            int i3 = 0;
            if (i2 == 0) {
                synchronized (b.this.f4903c) {
                    while (i3 < b.this.f4902b.size()) {
                        a aVar = (a) b.this.f4902b.get(i3);
                        if (aVar.f4916c != null && CyberPlayerManager.isCoreLoaded(aVar.f4915b)) {
                            aVar.f4916c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        }
                        i3++;
                    }
                    b.this.b(message.arg1);
                }
            } else if (i2 == 1) {
                synchronized (b.this.f4903c) {
                    while (i3 < b.this.f4902b.size()) {
                        a aVar2 = (a) b.this.f4902b.get(i3);
                        if (aVar2.f4916c != null) {
                            aVar2.f4916c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                        }
                        i3++;
                    }
                    b.this.b(message.arg1);
                }
            } else if (i2 == 2) {
                while (i3 < b.this.f4902b.size()) {
                    a aVar3 = (a) b.this.f4902b.get(i3);
                    if (aVar3.f4916c != null) {
                        aVar3.f4916c.onInstallProgress(message.arg1, message.arg2);
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
    public List<a> f4902b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4904d = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public int f4915b;

        /* renamed from: c  reason: collision with root package name */
        public CyberPlayerManager.InstallListener f4916c;

        public a(int i2, CyberPlayerManager.InstallListener installListener) {
            this.f4915b = i2;
            this.f4916c = installListener;
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f4901a == null) {
                f4901a = new b();
            }
            bVar = f4901a;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.cyberplayer.sdk.statistics.b.a(this.f4906f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, (HashMap) obj);
        n.h();
        CyberLog.d("CyberCoreLoaderManager", "onLoad session:" + obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        com.baidu.cyberplayer.sdk.loader.a.a().a(str, i2, map, new CyberPlayerManager.InstallListener() { // from class: com.baidu.cyberplayer.sdk.loader.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i3, int i4, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(i4));
                hashMap.put("detail", str2);
                hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, n.l());
                b.this.a(hashMap);
                Message obtainMessage = b.this.f4907g.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i3;
                obtainMessage.arg2 = i4;
                obtainMessage.obj = str2;
                b.this.f4907g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i3, int i4) {
                Message obtainMessage = b.this.f4907g.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i3;
                obtainMessage.arg2 = i4;
                b.this.f4907g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i3, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(0));
                hashMap.put("corever", CyberPlayerManager.getCoreVersion());
                hashMap.put(LokiService.Constant.LOG_PROCESS_NAME, n.l());
                b.this.a(hashMap);
                if (n.m() && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    g.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberPlayerManager.getInstallOpts());
                }
                Message obtainMessage = b.this.f4907g.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i3;
                b.this.f4907g.sendMessage(obtainMessage);
            }
        });
    }

    private boolean a(int i2) {
        synchronized (this.f4903c) {
            if (i2 != (this.f4905e & i2)) {
                this.f4905e = i2 | this.f4905e;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Iterator<a> it = this.f4902b.iterator();
        while (it.hasNext()) {
            if (it.next().f4915b == i2) {
                it.remove();
            }
        }
        this.f4905e = (i2 ^ Integer.MAX_VALUE) & this.f4905e;
    }

    public void a(final String str, final int i2, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        this.f4906f = CyberPlayerManager.getApplicationContext();
        synchronized (this.f4903c) {
            if (CyberPlayerManager.isCoreLoaded(i2)) {
                if (installListener != null) {
                    Message obtainMessage = this.f4907g.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i2;
                    obtainMessage.obj = installListener;
                    this.f4907g.sendMessage(obtainMessage);
                }
                return;
            }
            if (installListener != null) {
                this.f4902b.add(new a(i2, installListener));
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
                    this.f4904d.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.loader.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(str, i2, map);
                        }
                    });
                }
            }
        }
    }
}
