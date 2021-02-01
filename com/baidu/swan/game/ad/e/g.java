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
    private SwanAdDownloadState cDO = SwanAdDownloadState.NOT_START;
    AdElementInfo dXp;
    String dZt;
    com.baidu.swan.game.ad.a.b eav;
    a eaw;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dXp = adElementInfo;
        this.eav = bVar;
    }

    public void qD(String str) {
        this.dZt = str;
        vy("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.gdt_ad_start_download).aIu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dZt = this.dZt;
        bVar.dZJ = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dXp, this.eav);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void eP(boolean z) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void a(SwanAdDownloadState swanAdDownloadState, int i) {
        if (this.cDO != swanAdDownloadState) {
            if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                vy("2");
                aQy();
            }
            this.cDO = swanAdDownloadState;
        }
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void b(SwanAdDownloadState swanAdDownloadState, int i) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void kc(String str) {
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void ajs() {
        aQy();
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public String ajt() {
        return null;
    }

    private void aQy() {
        if (this.eaw == null) {
            this.eaw = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.eaw, intentFilter);
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
                if (TextUtils.equals(g.this.dXp.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.vy("3");
                }
            }
        }
    }

    public void release() {
        if (this.eaw != null) {
            this.mContext.unregisterReceiver(this.eaw);
            this.eaw = null;
        }
    }
}
