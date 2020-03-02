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
    private static volatile a cja;
    private b cjb = new b();
    private b cjc = new b();
    private DownloadManager cjd = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cje = new com.baidu.swan.b.a.b.b(this.cjd);
    private JSONObject cjf;

    private a() {
        this.cje.ald();
        this.cje.alb();
        akV();
        akW();
        if (DEBUG) {
            this.cjd.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a akS() {
        if (cja == null) {
            synchronized (a.class) {
                if (cja == null) {
                    cja = new a();
                }
            }
        }
        return cja;
    }

    private boolean akT() {
        return !ProcessUtils.isMainProcess();
    }

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cjf = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cje.og(str);
            Download akY = new com.baidu.swan.b.a.b.a().nZ(str).oa(str2).ob(str3).akY();
            this.cjd.start(akY);
            if (akY.getId() != null) {
                this.cjb.f(String.valueOf(akY.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download oc = this.cje.oc(str);
            if (oc == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.b(new c(oc));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> ala = this.cje.ala();
        if (ala == null || ala.isEmpty()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.b(new c(ala));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download oc = this.cje.oc(str);
            if (oc == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (oc.getState() == Download.DownloadState.FINISH) {
                bVar.b(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cjb.f(String.valueOf(oc.getId()), bVar);
                this.cjd.resume(oc.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download oc = this.cje.oc(str);
            if (oc == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (oc.getState() != Download.DownloadState.WAITING && oc.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cjd.pause(oc.getId().longValue());
                bVar.b(new c(oc));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akT()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> oe = this.cje.oe(str);
            if (oe == null || oe.isEmpty()) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cje.f(oe);
            bVar.b(new c(oe));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (akT()) {
            aVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download oc = this.cje.oc(str);
            if (oc == null) {
                aVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            } else if (oc.getCurrentbytes().longValue() < oc.getTotalbytes().longValue()) {
                aVar.b(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
                return null;
            } else {
                String realDownloadDir = oc.getRealDownloadDir();
                String fileName = oc.getFileName();
                String keyByUser = oc.getKeyByUser();
                if (DEBUG) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                    this.cje.og(str);
                    return null;
                }
                String str2 = realDownloadDir + File.separator + fileName;
                if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), keyByUser)) {
                    aVar.b(new c("apk is already installed"));
                    nY(str2);
                    return null;
                }
                File file = new File(str2);
                if (!file.isFile() || !file.exists()) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                    this.cje.og(str);
                    return null;
                }
                aVar.setPackageName(keyByUser);
                aVar.setFilePath(str2);
                this.cjc.f(keyByUser, aVar);
                if (!com.baidu.swan.b.a.c.a.oh(str2)) {
                    e(keyByUser, aVar);
                    aVar.b(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                    this.cje.og(str);
                }
                return keyByUser;
            }
        }
    }

    public synchronized void akU() {
        this.cje.akU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nX(String str) {
        this.cjb.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cjc.g(str, bVar);
    }

    public boolean nY(String str) {
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

    private void akV() {
        this.cjd.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, Download download) {
                if (download != null && download.getId() != null) {
                    String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cjf));
                    }
                    if (a.this.cjb.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cjg[download.getState().ordinal()]) {
                            case 1:
                                a.this.cjb.a(valueOf, new c(download));
                                a.this.nX(valueOf);
                                a.this.cje.alc();
                                return;
                            case 2:
                                a.this.cjb.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.nX(valueOf);
                                return;
                            case 3:
                                a.this.cjb.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.nX(valueOf);
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
        static final /* synthetic */ int[] cjg = new int[Download.DownloadState.values().length];

        static {
            try {
                cjg[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cjg[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cjg[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void akW() {
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
                        a.this.cjc.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }
}
