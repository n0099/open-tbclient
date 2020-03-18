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
    private static volatile a cjm;
    private b cjn = new b();
    private b cjo = new b();
    private DownloadManager cjp = DownloadManager.getInstance(AppRuntime.getAppContext());
    private com.baidu.swan.b.a.b.b cjq = new com.baidu.swan.b.a.b.b(this.cjp);
    private JSONObject cjr;

    private a() {
        this.cjq.alg();
        this.cjq.ale();
        akY();
        akZ();
        if (DEBUG) {
            this.cjp.registerOnProgressChangeListener(new DownloadManager.OnProgressChangeListener() { // from class: com.baidu.swan.b.a.a.1
                @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
                public void onProgressChanged(long j, int i, long j2) {
                    Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
            });
        }
    }

    public static a akV() {
        if (cjm == null) {
            synchronized (a.class) {
                if (cjm == null) {
                    cjm = new a();
                }
            }
        }
        return cjm;
    }

    private boolean akW() {
        return !ProcessUtils.isMainProcess();
    }

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cjr = jSONObject;
        }
    }

    public void a(String str, String str2, String str3, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), str2)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31005, "apk is already installed"));
        } else {
            this.cjq.oe(str);
            Download alb = new com.baidu.swan.b.a.b.a().nY(str).nZ(str2).oa(str3).alb();
            this.cjp.start(alb);
            if (alb.getId() != null) {
                this.cjn.f(String.valueOf(alb.getId()), bVar);
            }
        }
    }

    public void a(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download ob = this.cjq.ob(str);
            if (ob == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else {
                bVar.b(new c(ob));
            }
        }
    }

    public void a(@NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return;
        }
        Collection<Download> ald = this.cjq.ald();
        if (ald == null || ald.isEmpty()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
        } else {
            bVar.b(new c(ald));
        }
    }

    public void b(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (!SwanAppNetworkUtils.isNetworkConnected(null)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31014, "network is not connected"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download ob = this.cjq.ob(str);
            if (ob == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (ob.getState() == Download.DownloadState.FINISH) {
                bVar.b(new com.baidu.swan.b.a.e.a(31012, "download is finished"));
            } else {
                this.cjn.f(String.valueOf(ob.getId()), bVar);
                this.cjp.resume(ob.getId().longValue());
            }
        }
    }

    public void c(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Download ob = this.cjq.ob(str);
            if (ob == null) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
            } else if (ob.getState() != Download.DownloadState.WAITING && ob.getState() != Download.DownloadState.DOWNLOADING) {
                bVar.b(new com.baidu.swan.b.a.e.a(31013, "download is not started"));
            } else {
                this.cjp.pause(ob.getId().longValue());
                bVar.b(new c(ob));
            }
        }
    }

    public void d(String str, @NonNull com.baidu.swan.b.a.d.b bVar) {
        if (akW()) {
            bVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
        } else if (TextUtils.isEmpty(str)) {
            bVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
        } else {
            Collection<Download> od = this.cjq.od(str);
            if (od == null || od.isEmpty()) {
                bVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return;
            }
            this.cjq.f(od);
            bVar.b(new c(od));
        }
    }

    public String a(String str, @NonNull com.baidu.swan.b.a.d.a aVar) {
        if (akW()) {
            aVar.b(new com.baidu.swan.b.a.e.a(31006, "is not in main process"));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            aVar.b(new com.baidu.swan.b.a.e.a(31007, "invalid params"));
            return null;
        } else {
            Download ob = this.cjq.ob(str);
            if (ob == null) {
                aVar.b(new com.baidu.swan.b.a.e.a(31008, "download is not exist"));
                return null;
            } else if (ob.getCurrentbytes().longValue() < ob.getTotalbytes().longValue()) {
                aVar.b(new com.baidu.swan.b.a.e.a(31017, "download is not finished"));
                return null;
            } else {
                String realDownloadDir = ob.getRealDownloadDir();
                String fileName = ob.getFileName();
                String keyByUser = ob.getKeyByUser();
                if (DEBUG) {
                    Log.d("GameCenterAppManager", "installApp packageName:" + keyByUser + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(keyByUser) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31001, "database no package or file name"));
                    this.cjq.oe(str);
                    return null;
                }
                String str2 = realDownloadDir + File.separator + fileName;
                if (com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), keyByUser)) {
                    aVar.b(new c("apk is already installed"));
                    nX(str2);
                    return null;
                }
                File file = new File(str2);
                if (!file.isFile() || !file.exists()) {
                    aVar.b(new com.baidu.swan.b.a.e.a(31002, "file is not exist"));
                    this.cjq.oe(str);
                    return null;
                }
                aVar.setPackageName(keyByUser);
                aVar.setFilePath(str2);
                this.cjo.f(keyByUser, aVar);
                if (!com.baidu.swan.b.a.c.a.og(str2)) {
                    e(keyByUser, aVar);
                    aVar.b(new com.baidu.swan.b.a.e.a(31004, "apk install fail"));
                    this.cjq.oe(str);
                }
                return keyByUser;
            }
        }
    }

    public synchronized void akX() {
        this.cjq.akX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(String str) {
        this.cjn.removeEventListener(str);
    }

    public void e(String str, com.baidu.swan.b.a.d.b bVar) {
        this.cjo.g(str, bVar);
    }

    public boolean nX(String str) {
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

    private void akY() {
        this.cjp.registerOnStateChangeListener(new DownloadManager.OnStateChangeListener() { // from class: com.baidu.swan.b.a.a.2
            @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
            public void onStateChanged(long j, Download download) {
                if (download != null && download.getId() != null) {
                    String valueOf = String.valueOf(download.getId());
                    if (a.DEBUG) {
                        Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
                    }
                    if (download.getState() == Download.DownloadState.FINISH) {
                        com.baidu.swan.b.a.f.c.a(download.getKeyByUser(), "startDownload", "success", null, new com.baidu.swan.b.a.f.a(a.this.cjr));
                    }
                    if (a.this.cjn.hasEventListener(valueOf)) {
                        switch (AnonymousClass4.cjs[download.getState().ordinal()]) {
                            case 1:
                                a.this.cjn.a(valueOf, new c(download));
                                a.this.nW(valueOf);
                                a.this.cjq.alf();
                                return;
                            case 2:
                                a.this.cjn.a(valueOf, new com.baidu.swan.b.a.e.a(31015, "download is canceled"));
                                a.this.nW(valueOf);
                                return;
                            case 3:
                                a.this.cjn.a(valueOf, new com.baidu.swan.b.a.e.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                                a.this.nW(valueOf);
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
        static final /* synthetic */ int[] cjs = new int[Download.DownloadState.values().length];

        static {
            try {
                cjs[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cjs[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cjs[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private synchronized void akZ() {
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
                        a.this.cjo.a(schemeSpecificPart, new c((String) null));
                        a.this.e(schemeSpecificPart, null);
                    }
                }
            }
        }, intentFilter);
    }
}
