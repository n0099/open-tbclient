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
    com.baidu.swan.apps.v.b.c aEm;
    private com.baidu.swan.apps.core.a.c.a aJA;
    a aJB;
    private m.a aJC;
    private Runnable aJD;
    String aJr;
    private int aJs;
    private com.baidu.a.a.b.a.a aJt;
    private String aJu;
    private Bitmap aJv;
    protected h aJw;
    private boolean aJx;
    private List<UbcFlowEvent> aJy;
    private com.baidu.swan.apps.core.a.a.a aJz;
    private String mAppId;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.ae.a.c cVar);
    }

    public f(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, @NonNull com.baidu.swan.apps.core.a.a.a aVar, String str, String str2, String str3) {
        super(str, str2, cVar.mAppId);
        this.aJx = false;
        this.aJC = new m.a() { // from class: com.baidu.swan.apps.core.a.f.1
            @Override // com.baidu.swan.apps.an.m.a
            public void e(String str4, Bitmap bitmap) {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "icon获取成功");
                }
                f.this.aJy.add(new UbcFlowEvent("na_aps_end_icon"));
                f.this.aJv = bitmap;
                if (f.this.aJw != null) {
                    f.this.aJw.Ec();
                }
            }
        };
        this.aJD = new Runnable() { // from class: com.baidu.swan.apps.core.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.DEBUG) {
                    Log.i("AiBaseDynamicCallback", "程序包和icon获取成功");
                }
                if (f.this.aJx && com.baidu.swan.apps.core.a.a.cQ(f.this.aJs)) {
                    f.this.aJy.add(new UbcFlowEvent("na_start_update_db"));
                    b.a(f.this.mContext, f.this.aJt, f.this.aEm, f.this.aJu, new b.a() { // from class: com.baidu.swan.apps.core.a.f.2.1
                        @Override // com.baidu.swan.apps.core.a.b.a
                        public void a(com.baidu.swan.apps.database.a aVar2, com.baidu.swan.apps.ae.a.c cVar2) {
                            f.this.a(aVar2, true, cVar2);
                            f.this.o("updateReady", true);
                            f.this.aJy.add(new UbcFlowEvent("na_end_update_db"));
                            f.this.cU(f.this.aEm != null ? f.this.aEm.aTl : 0);
                        }
                    });
                }
            }
        };
        this.mAppId = cVar.mAppId;
        this.mContext = context;
        this.aEm = cVar;
        this.aJr = str3;
        this.aJs = aVar.Ed();
        this.aJx = false;
        this.aJy = new ArrayList();
        this.aJy.add(new UbcFlowEvent("na_aps_start_req"));
        this.aJA = aVar.Ef();
        this.aJz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.database.a aVar, boolean z, com.baidu.swan.apps.ae.a.c cVar) {
        if (DEBUG) {
            Log.i("AiBaseDynamicCallback", "更新DB完成");
        }
        i.a(aVar, z);
        if (this.aJB != null) {
            this.aJB.a(cVar);
        }
        if (com.baidu.swan.apps.core.a.a.cR(this.aJs)) {
            b.a(this.mContext, this.aEm, aVar, this.aJr);
            if (DEBUG) {
                Log.i("AiBaseDynamicCallback", "更新DB完成，调起小程序");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i) {
        String str;
        if (!TextUtils.equals(this.aJz.Eg(), "0")) {
            str = "main_pre_download";
        } else {
            str = com.baidu.swan.apps.core.a.a.cS(this.aJs) ? "main_async_download" : "main_download";
        }
        com.baidu.swan.apps.performance.a.a.a(i, this.mAppId, str, this.aJy, this.aJz.Eg());
        this.aJy.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, boolean z) {
        if (this.aJz.Ee()) {
            if (DEBUG) {
                Log.d("AiBaseDynamicCallback", "此Aps流程为静默更新流程，不发通知，eventType = " + str);
            }
        } else if (com.baidu.swan.apps.core.a.a.cS(this.aJs)) {
            i.g(str, this.mAppId, z);
        }
    }
}
