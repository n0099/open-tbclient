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
    private static volatile a cIn;
    private b cIo = new b();
    private b cIp = new b();
    private DownloadManager cIq = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cIr = new com.baidu.swan.b.a.b.b(this.cIq);
    private JSONObject cIs;

    private a() {
        this.cIr.att();
        this.cIr.atr();
        atl();
        atm();
        if (DEBUG) {
            this.cIq.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a ati() {
        if (cIn == null) {
            synchronized (a.class) {
                if (cIn == null) {
                    cIn = new a();
                }
            }
        }
        return cIn;
    }

    private boolean atj() {
        return !ProcessUtils.isMainProcess();
    }

    public void bB(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cIs = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cIr.pt(str);
            Download ato = new com.baidu.swan.b.a.b.a().pn(str).po(str2).pp(str3).ato();
            this.cIq.start(ato);
            if (ato.getId() != null) {
                this.cIo.f(String.valueOf(ato.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download pq = this.cIr.pq(str);
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
        Collection<Download> atq = this.cIr.atq();
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
            Download pq = this.cIr.pq(str);
            if (pq == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (pq.getState() == Download.DownloadState.FINISH) {
                bVar.b(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cIo.f(String.valueOf(pq.getId()), bVar);
                this.cIq.resume(pq.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (atj()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download pq = this.cIr.pq(str);
            if (pq == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (pq.getState() != Download.DownloadState.WAITING && pq.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cIq.pause(pq.getId().longValue());
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
            Collection<Download> ps = this.cIr.ps(str);
            if (ps == null || ps.isEmpty()) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cIr.f(ps);
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
            Download pq = this.cIr.pq(str);
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
                    this.cIr.pt(str);
                    return null;
                }
                String str2 = realDownloadDir + File.separator + fileName;
                if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), keyByUser)) {
                    aVar.b(new c("apk is already installed"));
                    pm(str2);
                    return null;
                }
                File file = new File(str2);
                if (!file.isFile() || !file.exists()) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                    this.cIr.pt(str);
                    return null;
                }
                aVar.setPackageName(keyByUser);
                aVar.setFilePath(str2);
                this.cIp.f(keyByUser, aVar);
                if (!com.baidu.swan.b.a.c.a.pu(str2)) {
                    e(keyByUser, aVar);
                    aVar.b(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                    this.cIr.pt(str);
                }
                return keyByUser;
            }
        }
    }

    public synchronized void atk() {
        this.cIr.atk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(String str) {
        this.cIo.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cIp.g(str, bVar);
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
        this.cIq.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, Download download) {
                if (download != null && download.getId() != null) {
                    String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cIs));
                    }
                    if (a.this.cIo.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cIt[download.getState().ordinal()]) {
                            case 1:
                                a.this.cIo.a(valueOf, new c(download));
                                a.this.pl(valueOf);
                                a.this.cIr.ats();
                                return;
                            case 2:
                                a.this.cIo.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.pl(valueOf);
                                return;
                            case 3:
                                a.this.cIo.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
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
        static final /* synthetic */ int[] cIt = new int[Download.DownloadState.values().length];

        static {
            try {
                cIt[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cIt[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cIt[Download.DownloadState.FAILED.ordinal()] = 3;
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
                        a.this.cIp.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }
}
