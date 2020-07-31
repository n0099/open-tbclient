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
/* loaded from: classes9.dex */
public class g implements com.baidu.swan.apps.adlanding.download.a.a {
    private SwanAdDownloadState bNR = SwanAdDownloadState.NOT_START;
    AdElementInfo dbV;
    com.baidu.swan.game.ad.a.b dcd;
    a dce;
    String mClickId;
    Context mContext;

    public g(Context context, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        this.mContext = context;
        this.dbV = adElementInfo;
        this.dcd = bVar;
    }

    public void rJ(String str) {
        this.mClickId = str;
        rK("1");
        if (this.mContext != null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.gdt_ad_start_download).showToastBottom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.mClickId = this.mClickId;
        bVar.dbq = str;
        com.baidu.swan.game.ad.c.d.a(bVar, this.dbV, this.dcd);
    }

    @Override // com.baidu.swan.apps.adlanding.download.a.a
    public void Vj() {
        aAY();
    }

    private void aAY() {
        if (this.dce == null) {
            this.dce = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.registerReceiver(this.dce, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        private long time;

        private a() {
            this.time = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getData() != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                if (TextUtils.equals(g.this.dbV.getPackageName(), intent.getData().getSchemeSpecificPart()) && System.currentTimeMillis() - this.time >= TimeUnit.SECONDS.toMillis(10L)) {
                    this.time = System.currentTimeMillis();
                    g.this.rK("3");
                }
            }
        }
    }

    public void release() {
        if (this.dce != null) {
            this.mContext.unregisterReceiver(this.dce);
            this.dce = null;
        }
    }
}
