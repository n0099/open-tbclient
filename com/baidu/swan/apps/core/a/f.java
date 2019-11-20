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
public abstract class f extends com.baidu.a.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    com.baidu.swan.apps.v.b.c aDU;
    String aIZ;
    private int aJa;
    private com.baidu.a.a.b.a.a aJb;
    private String aJc;
    private Bitmap aJd;
    protected h aJe;
    private boolean aJf;
    private List<UbcFlowEvent> aJg;
    private com.baidu.swan.apps.core.a.a.a aJh;
    private com.baidu.swan.apps.core.a.c.a aJi;
    a aJj;
    private m.a aJk;
    private Runnable aJl;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aJf = false;
        this.aJk = new m.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.m.a
            public void e(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aJg.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aJd = bitmap;
                if (f.this.aJe != null) {
                    f.this.aJe.Ed();
                }
            }
        };
        this.aJl = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aJf && com.baidu.swan.apps.core.a.a.cQ(f.this.aJa)) {
                    f.this.aJg.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aJb, f.this.aDU, f.this.aJc, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.o("updateReady", true);
                            f.this.aJg.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.cU(f.this.aDU != null ? f.this.aDU.aST : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.aDU = cVar;
        this.aIZ = str3;
        this.aJa = aVar.Ee();
        this.aJf = false;
        this.aJg = new ArrayList();
        this.aJg.add(new UbcFlowEvent("na_aps_start_req"));
        this.aJi = aVar.Eg();
        this.aJh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aJj != null) {
            this.aJj.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.cR(this.aJa)) {
            b.a(this.mContext, this.aDU, aVar, this.aIZ);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i) {
        String str;
        if (!TextUtils.equals(this.aJh.Eh(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.cS(this.aJa) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aJg, this.aJh.Eh());
        this.aJg.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, boolean z) {
        if (this.aJh.Ef()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.cS(this.aJa)) {
            i.g(str, this.mAppId, z);
        }
    }
}
