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
    private static volatile a dPv;
    private JSONObject dPA;
    private b dPw = new b();
    private b dPx = new b();
    private DownloadManager dPy = DownloadManager.getInstance(AppRuntime.getAppContext());
    private c dPz = new c(this.dPy);

    private a() {
        this.dPz.aSe();
        this.dPz.aQt();
        aRU();
        aRV();
        if (DEBUG) {
            this.dPy.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aRP() {
        if (dPv == null) {
            synchronized (a.class) {
                if (dPv == null) {
                    dPv = new a();
                }
            }
        }
        return dPv;
    }

    private boolean aRQ() {
        return !ProcessUtils.isMainProcess();
    }

    public void cl(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dPA = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31005, "apk is already installed"));
        } else {
            this.dPz.wc(str);
            Download aRX = new com.baidu.swan.gamecenter.appmanager.download.a().vV(str).vW(str2).vX(str3).aRX();
            this.dPy.start(aRX);
            if (aRX.getId() != null) {
                this.dPw.f(String.valueOf(aRX.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vY = this.dPz.vY(str);
            if (vY == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(vY));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aSb = this.dPz.aSb();
        if (aSb == null || aSb.isEmpty()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
        } else {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(aSb));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vY = this.dPz.vY(str);
            if (vY == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (vY.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31012, "download is finished"));
            } else {
                this.dPw.f(String.valueOf(vY.getId()), bVar);
                this.dPy.resume(vY.getId().longValue());
            }
        }
    }

    public void aRR() {
        Collection<Download> aSc = this.dPz.aSc();
        if (aSc != null && !aSc.isEmpty()) {
            for (Download download : aSc) {
                this.dPw.f(String.valueOf(download.getId()), new C0522a());
                com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
            }
        }
    }

    public void aRS() {
        this.dPz.aQt();
    }

    public void c(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download vY = this.dPz.vY(str);
            if (vY == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (vY.getState() != Download.DownloadState.WAITING && vY.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31013, "download is not started"));
            } else {
                this.dPy.pause(vY.getId().longValue());
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(vY));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aRQ()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Collection<Download> wb = this.dPz.wb(str);
            if (wb == null || wb.isEmpty()) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return;
            }
            this.dPz.j(wb);
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(wb));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        if (aRQ()) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
            return null;
        } else {
            Download vY = this.dPz.vY(str);
            if (vY == null) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return null;
            }
            if (vY.getCurrentbytes().longValue() < vY.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31017, "download is not finished"));
            }
            String realDownloadDir = vY.getRealDownloadDir();
            String fileName = vY.getFileName();
            final String keyByUser = vY.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31001, "database no package or file name"));
                this.dPz.wc(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), keyByUser)) {
                vU(keyByUser);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.c("apk is already installed"));
                vT(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31002, "file is not exist"));
                this.dPz.wc(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.dPx.f(keyByUser, aVar);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.wd(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31004, "apk install fail"));
                this.dPz.wc(str);
            } else {
                long length = ((file.length() / 104857600) + 1) * 1000;
                final String avr = com.baidu.swan.gamecenter.appmanager.install.a.avr();
                if (com.baidu.swan.gamecenter.appmanager.install.a.wf(avr)) {
                    d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!g.azX().isForeground()) {
                                if (a.DEBUG) {
                                    Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
                                }
                                Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
                                intent.putExtra("type", avr);
                                intent.putExtra("packageName", keyByUser);
                                intent.putExtra("ubc_params", a.this.dPA.toString());
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

    public synchronized void aRT() {
        this.dPz.aRT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(String str) {
        this.dPw.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dPx.g(str, bVar);
    }

    public boolean vT(String str) {
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

    private void aRU() {
        this.dPy.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.3
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(a.this.dPA));
                    }
                    if (a.this.dPw.hasEventListener(valueOf)) {
                        switch (AnonymousClass5.dPC[download.getState().ordinal()]) {
                            case 1:
                                a.this.dPz.aSd();
                                new com.baidu.swan.gamecenter.appmanager.install.c(download, a.this.dPA).b(new com.baidu.swan.gamecenter.appmanager.b.b() { // from class: com.baidu.swan.gamecenter.appmanager.a.3.1
                                    @Override // com.baidu.swan.gamecenter.appmanager.b.b
                                    public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.aSq()) {
                                                a.this.dPw.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.c(download));
                                            } else {
                                                a.this.dPw.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.vS(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.dPw.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(31015, "download is canceled"));
                                a.this.vS(valueOf);
                                return;
                            case 3:
                                a.this.dPw.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.vS(valueOf);
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
        static final /* synthetic */ int[] dPC = new int[Download.DownloadState.values().length];

        static {
            try {
                dPC[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dPC[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dPC[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aRV() {
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
                        a.this.vU(schemeSpecificPart);
                        a.this.dPx.a(schemeSpecificPart, new com.baidu.swan.gamecenter.appmanager.c.c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(String str) {
        if (this.dPz.wa(str)) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(str, "installApp", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0522a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public C0522a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        }
    }
}
