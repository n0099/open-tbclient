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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a ceV;
    private b ceW = new b();
    private b ceX = new b();
    private DownloadManager ceY = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b ceZ = new com.baidu.swan.b.a.b.b(this.ceY);
    private JSONObject cfa;

    private a() {
        this.ceZ.aiN();
        this.ceZ.aiL();
        aiF();
        aiG();
        if (DEBUG) {
            this.ceY.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aiC() {
        if (ceV == null) {
            synchronized (a.class) {
                if (ceV == null) {
                    ceV = new a();
                }
            }
        }
        return ceV;
    }

    private boolean aiD() {
        return !ProcessUtils.isMainProcess();
    }

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfa = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.ceZ.nQ(str);
            Download aiI = new com.baidu.swan.b.a.b.a().nK(str).nL(str2).nM(str3).aiI();
            this.ceY.start(aiI);
            if (aiI.getId() != null) {
                this.ceW.f(String.valueOf(aiI.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download nN = this.ceZ.nN(str);
            if (nN == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.b(new c(nN));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aiK = this.ceZ.aiK();
        if (aiK == null || aiK.isEmpty()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.b(new c(aiK));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download nN = this.ceZ.nN(str);
            if (nN == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (nN.getState() == Download.DownloadState.FINISH) {
                bVar.b(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.ceW.f(String.valueOf(nN.getId()), bVar);
                this.ceY.resume(nN.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download nN = this.ceZ.nN(str);
            if (nN == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (nN.getState() != Download.DownloadState.WAITING && nN.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.ceY.pause(nN.getId().longValue());
                bVar.b(new c(nN));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (aiD()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> nP = this.ceZ.nP(str);
            if (nP == null || nP.isEmpty()) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.ceZ.f(nP);
            bVar.b(new c(nP));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (aiD()) {
            aVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download nN = this.ceZ.nN(str);
            if (nN == null) {
                aVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            } else if (nN.getCurrentbytes().longValue() < nN.getTotalbytes().longValue()) {
                aVar.b(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
                return null;
            } else {
                String realDownloadDir = nN.getRealDownloadDir();
                String fileName = nN.getFileName();
                String keyByUser = nN.getKeyByUser();
                if (DEBUG) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                    this.ceZ.nQ(str);
                    return null;
                }
                String str2 = realDownloadDir + File.separator + fileName;
                if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), keyByUser)) {
                    aVar.b(new c("apk is already installed"));
                    nJ(str2);
                    return null;
                }
                File file = new File(str2);
                if (!file.isFile() || !file.exists()) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                    this.ceZ.nQ(str);
                    return null;
                }
                aVar.setPackageName(keyByUser);
                aVar.setFilePath(str2);
                this.ceX.f(keyByUser, aVar);
                if (!com.baidu.swan.b.a.c.a.nR(str2)) {
                    e(keyByUser, aVar);
                    aVar.b(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                    this.ceZ.nQ(str);
                }
                return keyByUser;
            }
        }
    }

    public synchronized void aiE() {
        this.ceZ.aiE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(String str) {
        this.ceW.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.ceX.g(str, bVar);
    }

    public boolean nJ(String str) {
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

    private void aiF() {
        this.ceY.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, Download download) {
                if (download != null && download.getId() != null) {
                    String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cfa));
                    }
                    if (a.this.ceW.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cfb[download.getState().ordinal()]) {
                            case 1:
                                a.this.ceW.a(valueOf, new c(download));
                                a.this.nI(valueOf);
                                a.this.ceZ.aiM();
                                return;
                            case 2:
                                a.this.ceW.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.nI(valueOf);
                                return;
                            case 3:
                                a.this.ceW.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.nI(valueOf);
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
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] cfb = new int[Download.DownloadState.values().length];

        static {
            try {
                cfb[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cfb[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cfb[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aiG() {
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
                        a.this.ceX.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }
}
