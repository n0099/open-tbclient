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
/* loaded from: classes19.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState bTp = SwanAdDownloadState.NOT_START;
    AdElementInfo djf;
    com.baidu.swan.game.ad.a.b dmn;
    a dmo;
    String mClickId;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.djf = adElementInfo;
        this.dmn = bVar;
    }

    public void pp(String str) {
        this.mClickId = str;
        uc("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.mClickId = this.mClickId;
        bVar.dlC = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.djf, this.dmn);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void dz(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.bTp != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                uc("2");
                aHt();
            }
            this.bTp = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void iN(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void abo() {
        aHt();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String abp() {
        return null;
    }

    private void aHt() {
        if (this.dmo == null) {
            this.dmo = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dmo, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.djf.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.uc("3");
                }
            }
        }
    }

    public void release() {
        if (this.dmo != null) {
            this.mContext.unregisterReceiver(this.dmo);
            this.dmo = null;
        }
    }
}
