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
    com.baidu.swan.apps.v.b.c aks;
    String apD;
    private int apE;
    private com.baidu.b.a.b.a.a apF;
    private String apG;
    private Bitmap apH;
    protected h apI;
    private boolean apJ;
    private List<UbcFlowEvent> apK;
    private com.baidu.swan.apps.core.a.a.a apL;
    private com.baidu.swan.apps.core.a.c.a apM;
    a apN;
    private m.a apO;
    private Runnable apP;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.apJ = false;
        this.apO = new m.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.apK.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.apH = bitmap;
                if (f.this.apI != null) {
                    f.this.apI.zd();
                }
            }
        };
        this.apP = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.apJ && com.baidu.swan.apps.core.a.a.bT(f.this.apE)) {
                    f.this.apK.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.apF, f.this.aks, f.this.apG, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.apK.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bX(f.this.aks != null ? f.this.aks.azz : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.aks = cVar;
        this.apD = str3;
        this.apE = aVar.ze();
        this.apJ = false;
        this.apK = new ArrayList();
        this.apK.add(new UbcFlowEvent("na_aps_start_req"));
        this.apM = aVar.zg();
        this.apL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.apN != null) {
            this.apN.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bU(this.apE)) {
            b.a(this.mContext, this.aks, aVar, this.apD);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i) {
        String str;
        if (!TextUtils.equals(this.apL.zh(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bV(this.apE) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.apK, this.apL.zh());
        this.apK.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.apL.zf()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bV(this.apE)) {
            i.d(str, this.mAppId, z);
        }
    }
}
