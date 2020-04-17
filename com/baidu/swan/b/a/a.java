package com.baidu.swan.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.b.a.e.c;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cIh;
    private b cIi = new b();
    private b cIj = new b();
    private DownloadManager cIk = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cIl = new com.baidu.swan.b.a.b.b(this.cIk);
    private JSONObject cIm;

    private a() {
        this.cIl.att();
        this.cIl.atr();
        atl();
        atm();
        if (DEBUG) {
            this.cIk.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a ati() {
        if (cIh == null) {
            synchronized (a.class) {
                if (cIh == null) {
                    cIh = new a();
                }
            }
        }
        return cIh;
    }

    private boolean atj() {
        return !ProcessUtils.isMainProcess();
    }

    public void bB(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cIm = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.an(AppRuntime.getAppContext(), str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cIl.pt(str);
            Download ato = new com.baidu.swan.b.a.b.a().pn(str).po(str2).pp(str3).ato();
            this.cIk.start(ato);
            if (ato.getId() != null) {
                this.cIi.f(String.valueOf(ato.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download pq = this.cIl.pq(str);
            if (pq == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.b(new c(pq));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> atq = this.cIl.atq();
        if (atq == null || atq.isEmpty()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.b(new c(atq));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download pq = this.cIl.pq(str);
            if (pq == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (pq.getState() == Download.DownloadState.FINISH) {
                bVar.b(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cIi.f(String.valueOf(pq.getId()), bVar);
                this.cIk.resume(pq.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download pq = this.cIl.pq(str);
            if (pq == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (pq.getState() != Download.DownloadState.WAITING && pq.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cIk.pause(pq.getId().longValue());
                bVar.b(new c(pq));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> ps = this.cIl.ps(str);
            if (ps == null || ps.isEmpty()) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cIl.f(ps);
            bVar.b(new c(ps));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (atj()) {
            aVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download pq = this.cIl.pq(str);
            if (pq == null) {
                aVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            } else if (pq.getCurrentbytes().longValue() < pq.getTotalbytes().longValue()) {
                aVar.b(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
                return null;
            } else {
                String realDownloadDir = pq.getRealDownloadDir();
                String fileName = pq.getFileName();
                String keyByUser = pq.getKeyByUser();
                if (DEBUG) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                    this.cIl.pt(str);
                    return null;
                }
                String str2 = realDownloadDir + File.separator + fileName;
                if (com.baidu.swan.b.a.c.a.an(AppRuntime.getAppContext(), keyByUser)) {
                    aVar.b(new c("apk is already installed"));
                    pm(str2);
                    return null;
                }
                File file = new File(str2);
                if (!file.isFile() || !file.exists()) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                    this.cIl.pt(str);
                    return null;
                }
                aVar.setPackageName(keyByUser);
                aVar.setFilePath(str2);
                this.cIj.f(keyByUser, aVar);
                if (!com.baidu.swan.b.a.c.a.pu(str2)) {
                    e(keyByUser, aVar);
                    aVar.b(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                    this.cIl.pt(str);
                }
                return keyByUser;
            }
        }
    }

    public synchronized void atk() {
        this.cIl.atk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(String str) {
        this.cIi.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cIj.g(str, bVar);
    }

    public boolean pm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                return file.delete();
            } catch (SecurityException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private void atl() {
        this.cIk.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, Download download) {
                if (download != null && download.getId() != null) {
                    String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cIm));
                    }
                    if (a.this.cIi.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cIn[download.getState().ordinal()]) {
                            case 1:
                                a.this.cIi.a(valueOf, new c(download));
                                a.this.pl(valueOf);
                                a.this.cIl.ats();
                                return;
                            case 2:
                                a.this.cIi.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.pl(valueOf);
                                return;
                            case 3:
                                a.this.cIi.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.pl(valueOf);
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        });
    }

    /* renamed from: com.baidu.swan.b.a.a$4  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] cIn = new int[Download.DownloadState.values().length];

        static {
            try {
                cIn[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cIn[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cIn[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void atm() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        AppRuntime.getAppContext().registerReceiver(new BroadcastReceiver() { // from class: com.baidu.swan.b.a.a.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getData() != null) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart)) {
                        if (a.DEBUG) {
                            Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                        }
                        a.this.cIj.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }
}
