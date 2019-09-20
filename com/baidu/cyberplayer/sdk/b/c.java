package com.baidu.cyberplayer.sdk.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.f;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class c {
    private static c a;
    private volatile int e;
    private Context f;
    private final Object c = new Object();
    private Handler g = new Handler(Looper.getMainLooper()) { // from class: com.baidu.cyberplayer.sdk.b.c.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = 0;
            switch (message.what) {
                case 0:
                    synchronized (c.this.c) {
                        for (int i2 = 0; i2 < c.this.b.size(); i2++) {
                            a aVar = (a) c.this.b.get(i2);
                            if (aVar.c != null && CyberPlayerManager.isCoreLoaded(aVar.b)) {
                                aVar.c.onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                            }
                        }
                        c.this.b(message.arg1);
                    }
                    break;
                case 1:
                    synchronized (c.this.c) {
                        for (int i3 = 0; i3 < c.this.b.size(); i3++) {
                            a aVar2 = (a) c.this.b.get(i3);
                            if (aVar2.c != null) {
                                aVar2.c.onInstallError(message.arg1, message.arg2, (String) message.obj);
                            }
                        }
                        c.this.b(message.arg1);
                    }
                    break;
                case 2:
                    while (true) {
                        int i4 = i;
                        if (i4 >= c.this.b.size()) {
                            break;
                        } else {
                            a aVar3 = (a) c.this.b.get(i4);
                            if (aVar3.c != null) {
                                aVar3.c.onInstallProgress(message.arg1, message.arg2);
                            }
                            i = i4 + 1;
                        }
                    }
                case 3:
                    if (message.obj != null) {
                        ((CyberPlayerManager.InstallListener) message.obj).onInstallSuccess(message.arg1, CyberPlayerManager.getCoreVersion());
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    };
    private List<a> b = new ArrayList();
    private ExecutorService d = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private int b;
        private CyberPlayerManager.InstallListener c;

        public a(int i, CyberPlayerManager.InstallListener installListener) {
            this.b = i;
            this.c = installListener;
        }
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.cyberplayer.sdk.statistics.b.a(this.f, (int) DpStatConstants.ACTION_LIB_LOAD_RESULT, (HashMap) obj);
        Utils.g();
        d.a().a(this.f);
        CyberLog.d("CyberCoreLoaderManager", "onLoad session:" + obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, Map<String, String> map) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        com.baidu.cyberplayer.sdk.statistics.a.a().b();
        b.a().a(str, i, map, new CyberPlayerManager.InstallListener() { // from class: com.baidu.cyberplayer.sdk.b.c.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallError(int i2, int i3, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(i3));
                hashMap.put(DpStatConstants.KEY_DETAIL, str2);
                hashMap.put("processname", Utils.b(CyberPlayerManager.getApplicationContext()));
                c.this.a(hashMap);
                Message obtainMessage = c.this.g.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                obtainMessage.obj = str2;
                c.this.g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallProgress(int i2, int i3) {
                Message obtainMessage = c.this.g.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = i3;
                c.this.g.sendMessage(obtainMessage);
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
            public void onInstallSuccess(int i2, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("loadcode", Integer.toString(0));
                hashMap.put("corever", CyberPlayerManager.getCoreVersion());
                hashMap.put("processname", Utils.b(CyberPlayerManager.getApplicationContext()));
                c.this.a(hashMap);
                if (Utils.a(CyberPlayerManager.getApplicationContext()) && CyberPlayerManager.getRemoteServiceClass() != null && !CyberCfgManager.getInstance().getCfgBoolValue("remote_forbidden", false)) {
                    f.a().a(CyberPlayerManager.getRemoteServiceClass(), CyberPlayerManager.getClientID(), CyberPlayerManager.getInstallType(), CyberPlayerManager.getInstallOpts());
                }
                Message obtainMessage = c.this.g.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.arg1 = i2;
                c.this.g.sendMessage(obtainMessage);
            }
        });
    }

    private boolean a(int i) {
        synchronized (this.c) {
            if (i != (this.e & i)) {
                this.e |= i;
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
        this.e &= Integer.MAX_VALUE ^ i;
    }

    public void a(final String str, final int i, final Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        boolean z = false;
        this.f = CyberPlayerManager.getApplicationContext();
        synchronized (this.c) {
            if (CyberPlayerManager.isCoreLoaded(i)) {
                if (installListener != null) {
                    Message obtainMessage = this.g.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = installListener;
                    this.g.sendMessage(obtainMessage);
                }
                return;
            }
            if (installListener != null) {
                this.b.add(new a(i, installListener));
            }
            if (a(i)) {
                if (map != null) {
                    String str2 = map.get("enable_sync_install");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            z = Integer.parseInt(str2) == 1;
                        } catch (Exception e) {
                        }
                    }
                }
                if (z) {
                    a(str, i, map);
                } else {
                    this.d.submit(new Runnable() { // from class: com.baidu.cyberplayer.sdk.b.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(str, i, map);
                        }
                    });
                }
            }
        }
    }
}
