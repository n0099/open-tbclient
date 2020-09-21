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
/* loaded from: classes10.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState bVt = SwanAdDownloadState.NOT_START;
    AdElementInfo dll;
    com.baidu.swan.game.ad.a.b dou;
    a dov;
    String mClickId;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dll = adElementInfo;
        this.dou = bVar;
    }

    public void pJ(String str) {
        this.mClickId = str;
        uw("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.mClickId = this.mClickId;
        bVar.dnI = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dll, this.dou);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void dy(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.bVt != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                uw("2");
                aId();
            }
            this.bVt = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void jh(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void abX() {
        aId();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String abY() {
        return null;
    }

    private void aId() {
        if (this.dov == null) {
            this.dov = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dov, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.dll.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.uw("3");
                }
            }
        }
    }

    public void release() {
        if (this.dov != null) {
            this.mContext.unregisterReceiver(this.dov);
            this.dov = null;
        }
    }
}
