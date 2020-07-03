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
    private static volatile a cXh;
    private b cXi = new b();
    private b cXj = new b();
    private DownloadManager cXk = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cXl = new com.baidu.swan.b.a.b.b(this.cXk);
    private JSONObject cXm;

    private a() {
        this.cXl.ayg();
        this.cXl.aye();
        axY();
        axZ();
        if (DEBUG) {
            this.cXk.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a axV() {
        if (cXh == null) {
            synchronized (a.class) {
                if (cXh == null) {
                    cXh = new a();
                }
            }
        }
        return cXh;
    }

    private boolean axW() {
        return !ProcessUtils.isMainProcess();
    }

    public void bH(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cXm = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), str2)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cXl.rb(str);
            Download ayb = new com.baidu.swan.b.a.b.a().qU(str).qV(str2).qW(str3).ayb();
            this.cXk.start(ayb);
            if (ayb.getId() != null) {
                this.cXi.f(String.valueOf(ayb.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qX = this.cXl.qX(str);
            if (qX == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.a(new c(qX));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> ayd = this.cXl.ayd();
        if (ayd == null || ayd.isEmpty()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.a(new c(ayd));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qX = this.cXl.qX(str);
            if (qX == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (qX.getState() == Download.DownloadState.FINISH) {
                bVar.a(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cXi.f(String.valueOf(qX.getId()), bVar);
                this.cXk.resume(qX.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download qX = this.cXl.qX(str);
            if (qX == null) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (qX.getState() != Download.DownloadState.WAITING && qX.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.a(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cXk.pause(qX.getId().longValue());
                bVar.a(new c(qX));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (axW()) {
            bVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> ra = this.cXl.ra(str);
            if (ra == null || ra.isEmpty()) {
                bVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cXl.h(ra);
            bVar.a(new c(ra));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (axW()) {
            aVar.a(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.a(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download qX = this.cXl.qX(str);
            if (qX == null) {
                aVar.a(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            }
            if (qX.getCurrentbytes().longValue() < qX.getTotalbytes().longValue()) {
                aVar.a(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
            }
            String realDownloadDir = qX.getRealDownloadDir();
            String fileName = qX.getFileName();
            String keyByUser = qX.getKeyByUser();
            if (DEBUG) {
                Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
            }
            if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                aVar.a(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                this.cXl.rb(str);
            }
            String str2 = realDownloadDir + File.separator + fileName;
            if (com.baidu.swan.b.a.c.a.ab(AppRuntime.getAppContext(), keyByUser)) {
                qT(keyByUser);
                aVar.a(new c("apk is already installed"));
                qS(str2);
                return null;
            }
            File file = new File(str2);
            if (!file.isFile() || !file.exists()) {
                aVar.a(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                this.cXl.rb(str);
                return null;
            }
            aVar.setPackageName(keyByUser);
            aVar.setFilePath(str2);
            this.cXj.f(keyByUser, aVar);
            if (!com.baidu.swan.b.a.c.a.rc(str2)) {
                e(keyByUser, aVar);
                aVar.a(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                this.cXl.rb(str);
            }
            return keyByUser;
        }
    }

    public synchronized void axX() {
        this.cXl.axX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR(String str) {
        this.cXi.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cXj.g(str, bVar);
    }

    public boolean qS(String str) {
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

    private void axY() {
        this.cXk.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, final Download download) {
                if (download != null && download.getId() != null) {
                    final String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cXm));
                    }
                    if (a.this.cXi.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cXo[download.getState().ordinal()]) {
                            case 1:
                                a.this.cXl.ayf();
                                new com.baidu.swan.b.a.c.c(download, a.this.cXm).b(new com.baidu.swan.b.a.d.b() { // from class: com.baidu.swan.b.a.a.2.1
                                    @Override // com.baidu.swan.b.a.d.b
                                    public void a(com.baidu.swan.b.a.e.b bVar) {
                                        if (bVar != null) {
                                            if (bVar.ayi()) {
                                                a.this.cXi.a(valueOf, new c(download));
                                            } else {
                                                a.this.cXi.a(valueOf, bVar);
                                            }
                                        }
                                        a.this.qR(valueOf);
                                    }
                                });
                                return;
                            case 2:
                                a.this.cXi.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.qR(valueOf);
                                return;
                            case 3:
                                a.this.cXi.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.qR(valueOf);
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
        static final /* synthetic */ int[] cXo = new int[Download.DownloadState.values().length];

        static {
            try {
                cXo[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cXo[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cXo[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void axZ() {
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
                        a.this.qT(schemeSpecificPart);
                        a.this.cXj.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(String str) {
        if (this.cXl.qZ(str)) {
            com.baidu.swan.b.a.f.c.a(str, "installApp", "success", null, new com.baidu.swan.b.a.f.a(this.cXm));
        }
    }
}
