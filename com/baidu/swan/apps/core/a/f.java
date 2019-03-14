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
    com.baidu.swan.apps.v.b.c ajx;
    String aoI;
    private int aoJ;
    private com.baidu.b.a.b.a.a aoK;
    private String aoL;
    private Bitmap aoM;
    protected h aoN;
    private boolean aoO;
    private List<UbcFlowEvent> aoP;
    private com.baidu.swan.apps.core.a.a.a aoQ;
    private com.baidu.swan.apps.core.a.c.a aoR;
    a aoS;
    private l.a aoT;
    private Runnable aoU;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aoO = false;
        this.aoT = new l.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.l.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aoP.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aoM = bitmap;
                if (f.this.aoN != null) {
                    f.this.aoN.xG();
                }
            }
        };
        this.aoU = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aoO && com.baidu.swan.apps.core.a.a.bU(f.this.aoJ)) {
                    f.this.aoP.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aoK, f.this.ajx, f.this.aoL, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.aoP.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bY(f.this.ajx != null ? f.this.ajx.axX : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.ajx = cVar;
        this.aoI = str3;
        this.aoJ = aVar.xH();
        this.aoO = false;
        this.aoP = new ArrayList();
        this.aoP.add(new UbcFlowEvent("na_aps_start_req"));
        this.aoR = aVar.xJ();
        this.aoQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aoS != null) {
            this.aoS.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bV(this.aoJ)) {
            b.a(this.mContext, this.ajx, aVar, this.aoI);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i) {
        String str;
        if (!TextUtils.equals(this.aoQ.xK(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bW(this.aoJ) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aoP, this.aoQ.xK());
        this.aoP.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.aoQ.xI()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bW(this.aoJ)) {
            i.d(str, this.mAppId, z);
        }
    }
}
