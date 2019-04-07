package com.baidu.swan.apps.core.pms;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class e extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.v.b.c ajB;
    private String aoM;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.ajB = cVar;
        this.aoM = str;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void zB() {
        super.zB();
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void a(com.baidu.swan.pms.model.b bVar) {
        super.a(bVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + bVar.toString());
        }
        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(10L).M(bVar.errorNo).hw(bVar.errorMsg);
        if (bVar.errorNo == 1013 && com.baidu.swan.pms.e.Ru().D(this.mAppId, bVar.errorNo)) {
            com.baidu.swan.apps.v.b.Dv().Dx();
        } else {
            com.baidu.swan.apps.v.d.a(this.mContext, this.ajB, hw, this.aoM);
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public void zy() {
        super.zy();
        if (this.ask != null) {
            zI();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajB, new com.baidu.swan.apps.ak.a().L(10L).M(2901L).hw("同步获取-> Server无包"), this.aoM);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zz() {
        this.aoT.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zH = zH();
        this.aoT.add(new UbcFlowEvent("na_end_update_db"));
        if (zH == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.asi != null) {
                this.ajB.atu = com.baidu.swan.apps.swancore.b.dJ(0);
                this.ajB.cD(1);
            }
            if (this.asj != null) {
                this.ajB.atv = com.baidu.swan.apps.extcore.a.Bh().As();
                this.ajB.cD(2);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.ajB, this.ask, this.aoM);
            ae("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajB, zH, this.aoM);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a hw;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            hw = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            hw = new com.baidu.swan.apps.ak.a().L(10L).M(2900L).hw("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajB, hw, this.aoM);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zA() {
        return PMSDownloadType.SYNC;
    }
}
