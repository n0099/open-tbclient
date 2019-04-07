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
    com.baidu.swan.apps.v.b.c ajB;
    String aoM;
    private int aoN;
    private com.baidu.b.a.b.a.a aoO;
    private String aoP;
    private Bitmap aoQ;
    protected h aoR;
    private boolean aoS;
    private List<UbcFlowEvent> aoT;
    private com.baidu.swan.apps.core.a.a.a aoU;
    private com.baidu.swan.apps.core.a.c.a aoV;
    a aoW;
    private l.a aoX;
    private Runnable aoY;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aoS = false;
        this.aoX = new l.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aoT.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aoQ = bitmap;
                if (f.this.aoR != null) {
                    f.this.aoR.xF();
                }
            }
        };
        this.aoY = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aoS && com.baidu.swan.apps.core.a.a.bT(f.this.aoN)) {
                    f.this.aoT.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aoO, f.this.ajB, f.this.aoP, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.aoT.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bX(f.this.ajB != null ? f.this.ajB.aya : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.ajB = cVar;
        this.aoM = str3;
        this.aoN = aVar.xG();
        this.aoS = false;
        this.aoT = new ArrayList();
        this.aoT.add(new UbcFlowEvent("na_aps_start_req"));
        this.aoV = aVar.xI();
        this.aoU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aoW != null) {
            this.aoW.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bU(this.aoN)) {
            b.a(this.mContext, this.ajB, aVar, this.aoM);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i) {
        String str;
        if (!TextUtils.equals(this.aoU.xJ(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bV(this.aoN) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aoT, this.aoU.xJ());
        this.aoT.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.aoU.xH()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bV(this.aoN)) {
            i.d(str, this.mAppId, z);
        }
    }
}
