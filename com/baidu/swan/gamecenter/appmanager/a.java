package com.baidu.swan.gamecenter.appmanager;

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
import com.baidu.swan.apps.aq.e;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.v.g;
import com.baidu.swan.gamecenter.appmanager.download.c;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dcM;
    private b dcN = new b();
    private b dcO = new b();
    private DownloadManager dcP = DownloadManager.getInstance(AppRuntime.getAppContext());
    private c dcQ = new c(this.dcP);
    private JSONObject dcR;

    private a() {
        this.dcQ.aBB();
        this.dcQ.aBy();
        aBq();
        aBr();
        if (DEBUG) {
            this.dcP.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aBl() {
        if (dcM == null) {
            synchronized (a.class) {
                if (dcM == null) {
                    dcM = new a();
                }
            }
        }
        return dcM;
    }

    private boolean aBm() {
        return !ProcessUtils.isMainProcess();
    }

    public void bM(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dcR = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else if (com.baidu.swan.gamecenter.appmanager.install.a.ac(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31005, "apk is already installed"));
        } else {
            this.dcQ.rX(str);
            Download aBt = new com.baidu.swan.gamecenter.appmanager.download.a().rQ(str).rR(str2).rS(str3).aBt();
            this.dcP.start(aBt);
            if (aBt.getId() != null) {
                this.dcN.f(String.valueOf(aBt.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download rT = this.dcQ.rT(str);
            if (rT == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(rT));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aBx = this.dcQ.aBx();
        if (aBx == null || aBx.isEmpty()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
        } else {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(aBx));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download rT = this.dcQ.rT(str);
            if (rT == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (rT.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31012, "download is finished"));
            } else {
                this.dcN.f(String.valueOf(rT.getId()), bVar);
                this.dcP.resume(rT.getId().longValue());
            }
        }
    }

    public void aBn() {
        Collection<Download> aBz = this.dcQ.aBz();
        if (aBz != null && !aBz.isEmpty()) {
            for (Download download : aBz) {
                this.dcN.f(String.valueOf(download.getId()), new C0436a());
                com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
            }
        }
    }

    public void aBo() {
        this.dcQ.aBy();
    }

    public void c(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download rT = this.dcQ.rT(str);
            if (rT == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (rT.getState() != Download.DownloadState.WAITING && rT.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31013, "download is not started"));
            } else {
                this.dcP.pause(rT.getId().longValue());
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(rT));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aBm()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Collection<Download> rW = this.dcQ.rW(str);
            if (rW == null || rW.isEmpty()) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return;
            }
            this.dcQ.h(rW);
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(rW));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        if (aBm()) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
            return null;
        } else {
            Download rT = this.dcQ.rT(str);
            if (rT == null) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return null;
            }
            if (rT.getCurrentbytes().longValue() < rT.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31017, "download is not finished"));
            }
            String realDownloadDir = rT.getRealDownloadDir();
            String fileName = rT.getFileName();
            final String keyByUser = rT.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31001, "database no package or file name"));
                this.dcQ.rX(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.gamecenter.appmanager.install.a.ac(AppRuntime.getAppContext(), keyByUser)) {
                rP(keyByUser);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.c("apk is already installed"));
                rO(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31002, "file is not exist"));
                this.dcQ.rX(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.dcO.f(keyByUser, aVar);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.rY(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31004, "apk install fail"));
                this.dcQ.rX(str);
            } else {
                long length = ((file.length() / 104857600) + 1) * 1000;
                final String ags = com.baidu.swan.gamecenter.appmanager.install.a.ags();
                if (com.baidu.swan.gamecenter.appmanager.install.a.sa(ags)) {
                    d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!g.akA().isForeground()) {
                                if (a.DEBUG) {
                                    Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
                                }
                                Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
                                intent.putExtra("type", ags);
                                intent.putExtra("packageName", keyByUser);
                                intent.putExtra("ubc_params", a.this.dcR.toString());
                                intent.setFlags(276824064);
                                e.startActivitySafely(AppRuntime.getAppContext(), intent);
                            }
                        }
                    }, length);
                }
            }
            return keyByUser;
        }
    }

    public synchronized void aBp() {
        this.dcQ.aBp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(String str) {
        this.dcN.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dcO.g(str, bVar);
    }

    public boolean rO(String str) {
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

    private void aBq() {
        this.dcP.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.3
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(a.this.dcR));
                    }
                    if (a.this.dcN.hasEventListener(valueOf)) {
                        switch (AnonymousClass5.dcT[download.getState().ordinal()]) {
                            case 1:
                                a.this.dcQ.aBA();
                                new com.baidu.swan.gamecenter.appmanager.install.c(download, a.this.dcR).b(new com.baidu.swan.gamecenter.appmanager.b.b() { // from class: com.baidu.swan.gamecenter.appmanager.a.3.1
                                    @Override // com.baidu.swan.gamecenter.appmanager.b.b
                                    public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.aBN()) {
                                                a.this.dcN.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.c(download));
                                            } else {
                                                a.this.dcN.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.rN(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.dcN.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(31015, "download is canceled"));
                                a.this.rN(valueOf);
                                return;
                            case 3:
                                a.this.dcN.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.rN(valueOf);
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        });
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$5  reason: invalid class name */
    /* loaded from: classes20.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] dcT = new int[Download.DownloadState.values().length];

        static {
            try {
                dcT[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dcT[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dcT[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aBr() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        AppRuntime.getAppContext().registerReceiver(new BroadcastReceiver() { // from class: com.baidu.swan.gamecenter.appmanager.a.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getData() != null) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart)) {
                        if (a.DEBUG) {
                            Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
                        }
                        a.this.rP(schemeSpecificPart);
                        a.this.dcO.a(schemeSpecificPart, new com.baidu.swan.gamecenter.appmanager.c.c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(String str) {
        if (this.dcQ.rV(str)) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(str, "installApp", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0436a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public C0436a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        }
    }
}
