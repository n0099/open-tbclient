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
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.v.g;
import com.baidu.swan.gamecenter.appmanager.download.c;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import java.io.File;
import java.util.Collection;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dJD;
    private b dJE = new b();
    private b dJF = new b();
    private DownloadManager dJG = DownloadManager.getInstance(AppRuntime.getAppContext());
    private c dJH = new c(this.dJG);
    private JSONObject dJI;

    private a() {
        this.dJH.aPE();
        this.dJH.aNT();
        aPu();
        aPv();
        if (DEBUG) {
            this.dJG.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aPp() {
        if (dJD == null) {
            synchronized (a.class) {
                if (dJD == null) {
                    dJD = new a();
                }
            }
        }
        return dJD;
    }

    private boolean aPq() {
        return !ProcessUtils.isMainProcess();
    }

    public void cf(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dJI = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31005, "apk is already installed"));
        } else {
            this.dJH.vO(str);
            Download aPx = new com.baidu.swan.gamecenter.appmanager.download.a().vH(str).vI(str2).vJ(str3).aPx();
            this.dJG.start(aPx);
            if (aPx.getId() != null) {
                this.dJE.f(String.valueOf(aPx.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vK = this.dJH.vK(str);
            if (vK == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(vK));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aPB = this.dJH.aPB();
        if (aPB == null || aPB.isEmpty()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
        } else {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(aPB));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vK = this.dJH.vK(str);
            if (vK == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (vK.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31012, "download is finished"));
            } else {
                this.dJE.f(String.valueOf(vK.getId()), bVar);
                this.dJG.resume(vK.getId().longValue());
            }
        }
    }

    public void aPr() {
        Collection<Download> aPC = this.dJH.aPC();
        if (aPC != null && !aPC.isEmpty()) {
            for (Download download : aPC) {
                this.dJE.f(String.valueOf(download.getId()), new C0510a());
                com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
            }
        }
    }

    public void aPs() {
        this.dJH.aNT();
    }

    public void c(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vK = this.dJH.vK(str);
            if (vK == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (vK.getState() != Download.DownloadState.WAITING && vK.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31013, "download is not started"));
            } else {
                this.dJG.pause(vK.getId().longValue());
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(vK));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aPq()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Collection<Download> vN = this.dJH.vN(str);
            if (vN == null || vN.isEmpty()) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return;
            }
            this.dJH.j(vN);
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(vN));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        if (aPq()) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
            return null;
        } else {
            Download vK = this.dJH.vK(str);
            if (vK == null) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return null;
            }
            if (vK.getCurrentbytes().longValue() < vK.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31017, "download is not finished"));
            }
            String realDownloadDir = vK.getRealDownloadDir();
            String fileName = vK.getFileName();
            final String keyByUser = vK.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31001, "database no package or file name"));
                this.dJH.vO(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), keyByUser)) {
                vG(keyByUser);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.c("apk is already installed"));
                vF(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31002, "file is not exist"));
                this.dJH.vO(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.dJF.f(keyByUser, aVar);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.vP(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31004, "apk install fail"));
                this.dJH.vO(str);
            } else {
                long length = ((file.length() / 104857600) + 1) * 1000;
                final String asR = com.baidu.swan.gamecenter.appmanager.install.a.asR();
                if (com.baidu.swan.gamecenter.appmanager.install.a.vR(asR)) {
                    d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!g.axx().isForeground()) {
                                if (a.DEBUG) {
                                    Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
                                }
                                Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
                                intent.putExtra("type", asR);
                                intent.putExtra("packageName", keyByUser);
                                intent.putExtra("ubc_params", a.this.dJI.toString());
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

    public synchronized void aPt() {
        this.dJH.aPt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE(String str) {
        this.dJE.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dJF.g(str, bVar);
    }

    public boolean vF(String str) {
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

    private void aPu() {
        this.dJG.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.3
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(a.this.dJI));
                    }
                    if (a.this.dJE.hasEventListener(valueOf)) {
                        switch (AnonymousClass5.dJK[download.getState().ordinal()]) {
                            case 1:
                                a.this.dJH.aPD();
                                new com.baidu.swan.gamecenter.appmanager.install.c(download, a.this.dJI).b(new com.baidu.swan.gamecenter.appmanager.b.b() { // from class: com.baidu.swan.gamecenter.appmanager.a.3.1
                                    @Override // com.baidu.swan.gamecenter.appmanager.b.b
                                    public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.aPQ()) {
                                                a.this.dJE.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.c(download));
                                            } else {
                                                a.this.dJE.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.vE(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.dJE.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(31015, "download is canceled"));
                                a.this.vE(valueOf);
                                return;
                            case 3:
                                a.this.dJE.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.vE(valueOf);
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
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] dJK = new int[Download.DownloadState.values().length];

        static {
            try {
                dJK[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dJK[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dJK[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aPv() {
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
                        a.this.vG(schemeSpecificPart);
                        a.this.dJF.a(schemeSpecificPart, new com.baidu.swan.gamecenter.appmanager.c.c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vG(String str) {
        if (this.dJH.vM(str)) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(str, "installApp", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0510a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public C0510a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        }
    }
}
