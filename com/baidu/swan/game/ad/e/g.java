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
/* loaded from: classes5.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState cFo = SwanAdDownloadState.NOT_START;
    AdElementInfo dYQ;
    String eaV;
    com.baidu.swan.game.ad.a.b ebW;
    a ebX;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dYQ = adElementInfo;
        this.ebW = bVar;
    }

    public void qK(String str) {
        this.eaV = str;
        vF("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.gdt_ad_start_download).aIx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.eaV = this.eaV;
        bVar.ebl = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dYQ, this.ebW);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eP(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cFo != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                vF("2");
                aQB();
            }
            this.cFo = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void kj(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void ajv() {
        aQB();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String ajw() {
        return null;
    }

    private void aQB() {
        if (this.ebX == null) {
            this.ebX = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.ebX, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.dYQ.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.vF("3");
                }
            }
        }
    }

    public void release() {
        if (this.ebX != null) {
            this.mContext.unregisterReceiver(this.ebX);
            this.ebX = null;
        }
    }
}
