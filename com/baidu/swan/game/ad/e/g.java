package com.baidu.swan.game.ad.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState cGe = SwanAdDownloadState.NOT_START;
    AdElementInfo dZT;
    String ebZ;
    com.baidu.swan.game.ad.a.b eda;
    a edb;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dZT = adElementInfo;
        this.eda = bVar;
    }

    public void rw(String str) {
        this.ebZ = str;
        wq("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.gdt_ad_start_download).aLU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.ebZ = this.ebZ;
        bVar.ecp = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dZT, this.eda);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eR(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cGe != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                wq("2");
                aTY();
            }
            this.cGe = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void kV(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void amN() {
        aTY();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String amO() {
        return null;
    }

    private void aTY() {
        if (this.edb == null) {
            this.edb = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.edb, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.dZT.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.wq("3");
                }
            }
        }
    }

    public void release() {
        if (this.edb != null) {
            this.mContext.unregisterReceiver(this.edb);
            this.edb = null;
        }
    }
}
