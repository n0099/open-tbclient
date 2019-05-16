package com.baidu.swan.apps.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.core.a.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class f extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    com.baidu.swan.apps.v.b.c ajQ;
    String aoZ;
    private int apa;
    private com.baidu.b.a.b.a.a apb;
    private String apc;
    private Bitmap apd;
    protected h ape;
    private boolean apf;
    private List<UbcFlowEvent> apg;
    private com.baidu.swan.apps.core.a.a.a aph;
    private com.baidu.swan.apps.core.a.c.a api;
    a apj;
    private m.a apk;
    private Runnable apl;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.apf = false;
        this.apk = new m.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.apg.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.apd = bitmap;
                if (f.this.ape != null) {
                    f.this.ape.yx();
                }
            }
        };
        this.apl = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.apf && com.baidu.swan.apps.core.a.a.bT(f.this.apa)) {
                    f.this.apg.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.apb, f.this.ajQ, f.this.apc, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.apg.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bX(f.this.ajQ != null ? f.this.ajQ.ayS : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.ajQ = cVar;
        this.aoZ = str3;
        this.apa = aVar.yy();
        this.apf = false;
        this.apg = new ArrayList();
        this.apg.add(new UbcFlowEvent("na_aps_start_req"));
        this.api = aVar.yA();
        this.aph = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.apj != null) {
            this.apj.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bU(this.apa)) {
            b.a(this.mContext, this.ajQ, aVar, this.aoZ);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i) {
        String str;
        if (!TextUtils.equals(this.aph.yB(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bV(this.apa) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.apg, this.aph.yB());
        this.apg.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.aph.yz()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bV(this.apa)) {
            i.d(str, this.mAppId, z);
        }
    }
}
