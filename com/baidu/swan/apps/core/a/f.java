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
    com.baidu.swan.apps.v.b.c akQ;
    String aqb;
    private int aqc;
    private com.baidu.b.a.b.a.a aqd;
    private String aqe;
    private Bitmap aqf;
    protected h aqg;
    private boolean aqh;
    private List<UbcFlowEvent> aqi;
    private com.baidu.swan.apps.core.a.a.a aqj;
    private com.baidu.swan.apps.core.a.c.a aqk;
    a aql;
    private m.a aqm;
    private Runnable aqn;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aqh = false;
        this.aqm = new m.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.m.a
            public void d(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aqi.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aqf = bitmap;
                if (f.this.aqg != null) {
                    f.this.aqg.zh();
                }
            }
        };
        this.aqn = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aqh && com.baidu.swan.apps.core.a.a.bU(f.this.aqc)) {
                    f.this.aqi.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aqd, f.this.akQ, f.this.aqe, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.l("updateReady", true);
                            f.this.aqi.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.bY(f.this.akQ != null ? f.this.akQ.azX : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.akQ = cVar;
        this.aqb = str3;
        this.aqc = aVar.zi();
        this.aqh = false;
        this.aqi = new ArrayList();
        this.aqi.add(new UbcFlowEvent("na_aps_start_req"));
        this.aqk = aVar.zk();
        this.aqj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aql != null) {
            this.aql.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.bV(this.aqc)) {
            b.a(this.mContext, this.akQ, aVar, this.aqb);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i) {
        String str;
        if (!TextUtils.equals(this.aqj.zl(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.bW(this.aqc) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aqi, this.aqj.zl());
        this.aqi.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z) {
        if (this.aqj.zj()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.bW(this.aqc)) {
            i.d(str, this.mAppId, z);
        }
    }
}
