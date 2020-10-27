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
    private SwanAdDownloadState cqi = SwanAdDownloadState.NOT_START;
    AdElementInfo dFO;
    com.baidu.swan.game.ad.a.b dIV;
    a dIW;
    String mClickId;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dFO = adElementInfo;
        this.dIV = bVar;
    }

    public void qO(String str) {
        this.mClickId = str;
        vB("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.mClickId = this.mClickId;
        bVar.dIk = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dFO, this.dIV);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eh(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cqi != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                vB("2");
                aMG();
            }
            this.cqi = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void km(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void agD() {
        aMG();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String agE() {
        return null;
    }

    private void aMG() {
        if (this.dIW == null) {
            this.dIW = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dIW, intentFilter);
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
                if (TextUtils.equals(g.this.dFO.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.vB("3");
                }
            }
        }
    }

    public void release() {
        if (this.dIW != null) {
            this.mContext.unregisterReceiver(this.dIW);
            this.dIW = null;
        }
    }
}
