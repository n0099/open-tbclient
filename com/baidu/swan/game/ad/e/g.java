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
    private SwanAdDownloadState cBo = SwanAdDownloadState.NOT_START;
    AdElementInfo dQW;
    String dTc;
    com.baidu.swan.game.ad.a.b dUd;
    a dUe;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dQW = adElementInfo;
        this.dUd = bVar;
    }

    public void rD(String str) {
        this.dTc = str;
        wr("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dTc = this.dTc;
        bVar.dTs = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dQW, this.dUd);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eI(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cBo != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                wr("2");
                aRD();
            }
            this.cBo = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void lc(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void alD() {
        aRD();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String alE() {
        return null;
    }

    private void aRD() {
        if (this.dUe == null) {
            this.dUe = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dUe, intentFilter);
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
                if (TextUtils.equals(g.this.dQW.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.wr("3");
                }
            }
        }
    }

    public void release() {
        if (this.dUe != null) {
            this.mContext.unregisterReceiver(this.dUe);
            this.dUe = null;
        }
    }
}
