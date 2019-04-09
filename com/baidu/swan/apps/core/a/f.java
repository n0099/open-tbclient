package com.baidu.swan.apps.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.core.a.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class f extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    com.baidu.swan.apps.v.b.c ajC;
    String aoN;
    private int aoO;
    private com.baidu.b.a.b.a.a aoP;
    private String aoQ;
    private Bitmap aoR;
    protected h aoS;
    private boolean aoT;
    private List<UbcFlowEvent> aoU;
    private com.baidu.swan.apps.core.a.a.a aoV;
    private com.baidu.swan.apps.core.a.c.a aoW;
    a aoX;
    private l.a aoY;
    private Runnable aoZ;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aoT = false;
        this.aoY = new l.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aoU.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aoR = bitmap;
                if (f.this.aoS != null) {
                    f.this.aoS.xF();
                }
            }
        };
        this.aoZ = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aoT && com.baidu.swan.apps.core.a.a.bT(f.this.aoO)) {
                    f.this.aoU.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aoP, f.this.ajC, f.this.aoQ, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.aoU.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bX(f.this.ajC != null ? f.this.ajC.ayb : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.ajC = cVar;
        this.aoN = str3;
        this.aoO = aVar.xG();
        this.aoT = false;
        this.aoU = new ArrayList();
        this.aoU.add(new UbcFlowEvent("na_aps_start_req"));
        this.aoW = aVar.xI();
        this.aoV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aoX != null) {
            this.aoX.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bU(this.aoO)) {
            b.a(this.mContext, this.ajC, aVar, this.aoN);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i) {
        String str;
        if (!TextUtils.equals(this.aoV.xJ(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bV(this.aoO) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aoU, this.aoV.xJ());
        this.aoU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.aoV.xH()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bV(this.aoO)) {
            i.d(str, this.mAppId, z);
        }
    }
}
