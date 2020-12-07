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
/* loaded from: classes16.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dUL;
    private b dUM = new b();
    private b dUN = new b();
    private DownloadManager dUO = DownloadManager.getInstance(AppRuntime.getAppContext());
    private c dUP = new c(this.dUO);
    private JSONObject dUQ;

    private a() {
        this.dUP.aUB();
        this.dUP.aSQ();
        aUr();
        aUs();
        if (DEBUG) {
            this.dUO.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aUm() {
        if (dUL == null) {
            synchronized (a.class) {
                if (dUL == null) {
                    dUL = new a();
                }
            }
        }
        return dUL;
    }

    private boolean aUn() {
        return !ProcessUtils.isMainProcess();
    }

    public void ch(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dUQ = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31005, "apk is already installed"));
        } else {
            this.dUP.wE(str);
            Download aUu = new com.baidu.swan.gamecenter.appmanager.download.a().wx(str).wy(str2).wz(str3).aUu();
            this.dUO.start(aUu);
            if (aUu.getId() != null) {
                this.dUM.f(String.valueOf(aUu.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download wA = this.dUP.wA(str);
            if (wA == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(wA));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aUy = this.dUP.aUy();
        if (aUy == null || aUy.isEmpty()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
        } else {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(aUy));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download wA = this.dUP.wA(str);
            if (wA == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (wA.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31012, "download is finished"));
            } else {
                this.dUM.f(String.valueOf(wA.getId()), bVar);
                this.dUO.resume(wA.getId().longValue());
            }
        }
    }

    public void aUo() {
        Collection<Download> aUz = this.dUP.aUz();
        if (aUz != null && !aUz.isEmpty()) {
            for (Download download : aUz) {
                this.dUM.f(String.valueOf(download.getId()), new C0532a());
                com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dUQ));
            }
        }
    }

    public void aUp() {
        this.dUP.aSQ();
    }

    public void c(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download wA = this.dUP.wA(str);
            if (wA == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (wA.getState() != Download.DownloadState.WAITING && wA.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31013, "download is not started"));
            } else {
                this.dUO.pause(wA.getId().longValue());
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(wA));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aUn()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Collection<Download> wD = this.dUP.wD(str);
            if (wD == null || wD.isEmpty()) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return;
            }
            this.dUP.j(wD);
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(wD));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        if (aUn()) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
            return null;
        } else {
            Download wA = this.dUP.wA(str);
            if (wA == null) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return null;
            }
            if (wA.getCurrentbytes().longValue() < wA.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31017, "download is not finished"));
            }
            String realDownloadDir = wA.getRealDownloadDir();
            String fileName = wA.getFileName();
            final String keyByUser = wA.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31001, "database no package or file name"));
                this.dUP.wE(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.gamecenter.appmanager.install.a.am(AppRuntime.getAppContext(), keyByUser)) {
                ww(keyByUser);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.c("apk is already installed"));
                wv(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31002, "file is not exist"));
                this.dUP.wE(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.dUN.f(keyByUser, aVar);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.wF(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31004, "apk install fail"));
                this.dUP.wE(str);
            } else {
                long length = ((file.length() / 104857600) + 1) * 1000;
                final String axR = com.baidu.swan.gamecenter.appmanager.install.a.axR();
                if (com.baidu.swan.gamecenter.appmanager.install.a.wH(axR)) {
                    d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!g.aCy().isForeground()) {
                                if (a.DEBUG) {
                                    Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
                                }
                                Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
                                intent.putExtra("type", axR);
                                intent.putExtra("packageName", keyByUser);
                                intent.putExtra("ubc_params", a.this.dUQ.toString());
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

    public synchronized void aUq() {
        this.dUP.aUq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(String str) {
        this.dUM.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dUN.g(str, bVar);
    }

    public boolean wv(String str) {
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

    private void aUr() {
        this.dUO.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.3
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(a.this.dUQ));
                    }
                    if (a.this.dUM.hasEventListener(valueOf)) {
                        switch (AnonymousClass5.dUS[download.getState().ordinal()]) {
                            case 1:
                                a.this.dUP.aUA();
                                new com.baidu.swan.gamecenter.appmanager.install.c(download, a.this.dUQ).b(new com.baidu.swan.gamecenter.appmanager.b.b() { // from class: com.baidu.swan.gamecenter.appmanager.a.3.1
                                    @Override // com.baidu.swan.gamecenter.appmanager.b.b
                                    public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.aUN()) {
                                                a.this.dUM.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.c(download));
                                            } else {
                                                a.this.dUM.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.wu(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.dUM.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(31015, "download is canceled"));
                                a.this.wu(valueOf);
                                return;
                            case 3:
                                a.this.dUM.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.wu(valueOf);
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
    /* loaded from: classes16.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] dUS = new int[Download.DownloadState.values().length];

        static {
            try {
                dUS[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dUS[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dUS[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aUs() {
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
                        a.this.ww(schemeSpecificPart);
                        a.this.dUN.a(schemeSpecificPart, new com.baidu.swan.gamecenter.appmanager.c.c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww(String str) {
        if (this.dUP.wC(str)) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(str, "installApp", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dUQ));
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0532a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public C0532a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        }
    }
}
