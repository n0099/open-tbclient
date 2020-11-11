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
    private SwanAdDownloadState cwg = SwanAdDownloadState.NOT_START;
    AdElementInfo dLG;
    com.baidu.swan.game.ad.a.b dON;
    a dOO;
    String mClickId;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dLG = adElementInfo;
        this.dON = bVar;
    }

    public void rc(String str) {
        this.mClickId = str;
        vP("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.mClickId = this.mClickId;
        bVar.dOc = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dLG, this.dON);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eq(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cwg != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                vP("2");
                aPg();
            }
            this.cwg = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void kB(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void ajd() {
        aPg();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String aje() {
        return null;
    }

    private void aPg() {
        if (this.dOO == null) {
            this.dOO = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dOO, intentFilter);
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
                if (TextUtils.equals(g.this.dLG.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.vP("3");
                }
            }
        }
    }

    public void release() {
        if (this.dOO != null) {
            this.mContext.unregisterReceiver(this.dOO);
            this.dOO = null;
        }
    }
}
