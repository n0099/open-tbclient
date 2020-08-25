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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dmV;
    private b dmW = new b();
    private b dmX = new b();
    private DownloadManager dmY = DownloadManager.getInstance(AppRuntime.getAppContext());
    private c dmZ = new c(this.dmY);
    private JSONObject dna;

    private a() {
        this.dmZ.aKq();
        this.dmZ.aIF();
        aKg();
        aKh();
        if (DEBUG) {
            this.dmY.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a aKb() {
        if (dmV == null) {
            synchronized (a.class) {
                if (dmV == null) {
                    dmV = new a();
                }
            }
        }
        return dmV;
    }

    private boolean aKc() {
        return !ProcessUtils.isMainProcess();
    }

    public void bS(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dna = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else if (com.baidu.swan.gamecenter.appmanager.install.a.af(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31005, "apk is already installed"));
        } else {
            this.dmZ.up(str);
            Download aKj = new com.baidu.swan.gamecenter.appmanager.download.a().ui(str).uj(str2).uk(str3).aKj();
            this.dmY.start(aKj);
            if (aKj.getId() != null) {
                this.dmW.f(String.valueOf(aKj.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download ul = this.dmZ.ul(str);
            if (ul == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(ul));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> aKn = this.dmZ.aKn();
        if (aKn == null || aKn.isEmpty()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
        } else {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(aKn));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download ul = this.dmZ.ul(str);
            if (ul == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (ul.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31012, "download is finished"));
            } else {
                this.dmW.f(String.valueOf(ul.getId()), bVar);
                this.dmY.resume(ul.getId().longValue());
            }
        }
    }

    public void aKd() {
        Collection<Download> aKo = this.dmZ.aKo();
        if (aKo != null && !aKo.isEmpty()) {
            for (Download download : aKo) {
                this.dmW.f(String.valueOf(download.getId()), new C0484a());
                com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dna));
            }
        }
    }

    public void aKe() {
        this.dmZ.aIF();
    }

    public void c(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Download ul = this.dmZ.ul(str);
            if (ul == null) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
            } else if (ul.getState() != Download.DownloadState.WAITING && ul.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31013, "download is not started"));
            } else {
                this.dmY.pause(ul.getId().longValue());
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(ul));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        if (aKc()) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
        } else {
            Collection<Download> uo = this.dmZ.uo(str);
            if (uo == null || uo.isEmpty()) {
                bVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return;
            }
            this.dmZ.j(uo);
            bVar.a(new com.baidu.swan.gamecenter.appmanager.c.c(uo));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
        if (aKc()) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31007, "invalid params"));
            return null;
        } else {
            Download ul = this.dmZ.ul(str);
            if (ul == null) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31008, "download is not exist"));
                return null;
            }
            if (ul.getCurrentbytes().longValue() < ul.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31017, "download is not finished"));
            }
            String realDownloadDir = ul.getRealDownloadDir();
            String fileName = ul.getFileName();
            final String keyByUser = ul.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31001, "database no package or file name"));
                this.dmZ.up(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.gamecenter.appmanager.install.a.af(AppRuntime.getAppContext(), keyByUser)) {
                uh(keyByUser);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.c("apk is already installed"));
                ug(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31002, "file is not exist"));
                this.dmZ.up(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.dmX.f(keyByUser, aVar);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.uq(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.gamecenter.appmanager.c.a(31004, "apk install fail"));
                this.dmZ.up(str);
            } else {
                long length = ((file.length() / 104857600) + 1) * 1000;
                final String anA = com.baidu.swan.gamecenter.appmanager.install.a.anA();
                if (com.baidu.swan.gamecenter.appmanager.install.a.us(anA)) {
                    d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!g.ash().isForeground()) {
                                if (a.DEBUG) {
                                    Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
                                }
                                Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
                                intent.putExtra("type", anA);
                                intent.putExtra("packageName", keyByUser);
                                intent.putExtra("ubc_params", a.this.dna.toString());
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

    public synchronized void aKf() {
        this.dmZ.aKf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(String str) {
        this.dmW.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dmX.g(str, bVar);
    }

    public boolean ug(String str) {
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

    private void aKg() {
        this.dmY.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.gamecenter.appmanager.a.3
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.gamecenter.appmanager.d.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(a.this.dna));
                    }
                    if (a.this.dmW.hasEventListener(valueOf)) {
                        switch (AnonymousClass5.dnc[download.getState().ordinal()]) {
                            case 1:
                                a.this.dmZ.aKp();
                                new com.baidu.swan.gamecenter.appmanager.install.c(download, a.this.dna).b(new com.baidu.swan.gamecenter.appmanager.b.b() { // from class: com.baidu.swan.gamecenter.appmanager.a.3.1
                                    @Override // com.baidu.swan.gamecenter.appmanager.b.b
                                    public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.aKC()) {
                                                a.this.dmW.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.c(download));
                                            } else {
                                                a.this.dmW.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.uf(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.dmW.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(31015, "download is canceled"));
                                a.this.uf(valueOf);
                                return;
                            case 3:
                                a.this.dmW.a(valueOf, new com.baidu.swan.gamecenter.appmanager.c.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.uf(valueOf);
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
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] dnc = new int[Download.DownloadState.values().length];

        static {
            try {
                dnc[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dnc[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dnc[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void aKh() {
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
                        a.this.uh(schemeSpecificPart);
                        a.this.dmX.a(schemeSpecificPart, new com.baidu.swan.gamecenter.appmanager.c.c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        if (this.dmZ.un(str)) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(str, "installApp", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dna));
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0484a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public C0484a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        }
    }
}
