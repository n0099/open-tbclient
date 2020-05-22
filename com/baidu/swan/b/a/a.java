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
    private static volatile a cSx;
    private JSONObject cSC;
    private b cSy = new b();
    private b cSz = new b();
    private DownloadManager cSA = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cSB = new com.baidu.swan.b.a.b.b(this.cSA);

    private a() {
        this.cSB.axa();
        this.cSB.awY();
        awS();
        awT();
        if (DEBUG) {
            this.cSA.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a awP() {
        if (cSx == null) {
            synchronized (a.class) {
                if (cSx == null) {
                    cSx = new a();
                }
            }
        }
        return cSx;
    }

    private boolean awQ() {
        return !ProcessUtils.isMainProcess();
    }

    public void bA(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cSC = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cSB.qT(str);
            Download awV = new com.baidu.swan.b.a.b.a().qM(str).qN(str2).qO(str3).awV();
            this.cSA.start(awV);
            if (awV.getId() != null) {
                this.cSy.f(String.valueOf(awV.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qP = this.cSB.qP(str);
            if (qP == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.a(new c(qP));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> awX = this.cSB.awX();
        if (awX == null || awX.isEmpty()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.a(new c(awX));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qP = this.cSB.qP(str);
            if (qP == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (qP.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cSy.f(String.valueOf(qP.getId()), bVar);
                this.cSA.resume(qP.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qP = this.cSB.qP(str);
            if (qP == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (qP.getState() != Download.DownloadState.WAITING && qP.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cSA.pause(qP.getId().longValue());
                bVar.a(new c(qP));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (awQ()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> qS = this.cSB.qS(str);
            if (qS == null || qS.isEmpty()) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cSB.h(qS);
            bVar.a(new c(qS));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (awQ()) {
            aVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download qP = this.cSB.qP(str);
            if (qP == null) {
                aVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            }
            if (qP.getCurrentbytes().longValue() < qP.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
            }
            String realDownloadDir = qP.getRealDownloadDir();
            String fileName = qP.getFileName();
            String keyByUser = qP.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                this.cSB.qT(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), keyByUser)) {
                qL(keyByUser);
                aVar.a(new c("apk is already installed"));
                qK(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                this.cSB.qT(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.cSz.f(keyByUser, aVar);
            if (!com.baidu.swan.b.a.c.a.qU(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                this.cSB.qT(str);
            }
            return keyByUser;
        }
    }

    public synchronized void awR() {
        this.cSB.awR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ(String str) {
        this.cSy.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cSz.g(str, bVar);
    }

    public boolean qK(String str) {
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

    private void awS() {
        this.cSA.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cSC));
                    }
                    if (a.this.cSy.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cSE[download.getState().ordinal()]) {
                            case 1:
                                a.this.cSB.awZ();
                                new com.baidu.swan.b.a.c.c(download, a.this.cSC).b(new com.baidu.swan.b.a.d.b() { // from class: com.baidu.swan.b.a.a.2.1
                                    @Override // com.baidu.swan.b.a.d.b
                                    public void a(com.baidu.swan.b.a.e.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.axc()) {
                                                a.this.cSy.a(valueOf, new c(download));
                                            } else {
                                                a.this.cSy.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.qJ(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.cSy.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.qJ(valueOf);
                                return;
                            case 3:
                                a.this.cSy.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.qJ(valueOf);
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
        static final /* synthetic */ int[] cSE = new int[Download.DownloadState.values().length];

        static {
            try {
                cSE[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cSE[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cSE[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void awT() {
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
                        a.this.qL(schemeSpecificPart);
                        a.this.cSz.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL(String str) {
        if (this.cSB.qR(str)) {
            com.baidu.swan.b.a.f.c.a(str, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cSC));
        }
    }
}
