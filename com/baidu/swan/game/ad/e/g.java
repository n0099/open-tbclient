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
/* loaded from: classes14.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState cBs = SwanAdDownloadState.NOT_START;
    AdElementInfo dVh;
    String dXn;
    com.baidu.swan.game.ad.a.b dYo;
    a dYp;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dVh = adElementInfo;
        this.dYo = bVar;
    }

    public void ql(String str) {
        this.dXn = str;
        vf("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.gdt_ad_start_download).aIb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dXn = this.dXn;
        bVar.dXD = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dVh, this.dYo);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eN(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cBs != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                vf("2");
                aQf();
            }
            this.cBs = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void jK(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void aiU() {
        aQf();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String aiV() {
        return null;
    }

    private void aQf() {
        if (this.dYp == null) {
            this.dYp = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dYp, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.dVh.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.vf("3");
                }
            }
        }
    }

    public void release() {
        if (this.dYp != null) {
            this.mContext.unregisterReceiver(this.dYp);
            this.dYp = null;
        }
    }
}
