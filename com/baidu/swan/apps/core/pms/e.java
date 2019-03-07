package com.baidu.swan.apps.core.pms;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class e extends d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private com.baidu.swan.apps.v.b.c ajw;
    private String aoH;
    private Context mContext;

    public e(Context context, com.baidu.swan.apps.v.b.c cVar, String str) {
        super(cVar.mAppId);
        this.mContext = context;
        this.ajw = cVar;
        this.aoH = str;
    }

    @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
    public void zC() {
        super.zC();
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
        com.baidu.swan.apps.ak.a hv = new com.baidu.swan.apps.ak.a().L(10L).M(bVar.errorNo).hv(bVar.errorMsg);
        if (bVar.errorNo == 1013 && com.baidu.swan.pms.e.Rw().D(this.mAppId, bVar.errorNo)) {
            com.baidu.swan.apps.v.b.Dx().Dz();
        } else {
            com.baidu.swan.apps.v.d.a(this.mContext, this.ajw, hv, this.aoH);
        }
    }

    @Override // com.baidu.swan.pms.a.e
    public void zz() {
        super.zz();
        if (this.asf != null) {
            zJ();
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajw, new com.baidu.swan.apps.ak.a().L(10L).M(2901L).hv("同步获取-> Server无包"), this.aoH);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void zA() {
        this.aoO.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.ak.a zI = zI();
        this.aoO.add(new UbcFlowEvent("na_end_update_db"));
        if (zI == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            if (this.asd != null) {
                this.ajw.atp = com.baidu.swan.apps.swancore.b.dK(0);
                this.ajw.cE(1);
            }
            if (this.ase != null) {
                this.ajw.atq = com.baidu.swan.apps.extcore.a.Bj().At();
                this.ajw.cE(2);
            }
            com.baidu.swan.apps.v.d.a(this.mContext, this.ajw, this.asf, this.aoH);
            ae("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajw, zI, this.aoH);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected void k(Throwable th) {
        com.baidu.swan.apps.ak.a hv;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            hv = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            hv = new com.baidu.swan.apps.ak.a().L(10L).M(2900L).hv("包下载过程未知错误");
        }
        com.baidu.swan.apps.v.d.a(this.mContext, this.ajw, hv, this.aoH);
    }

    @Override // com.baidu.swan.apps.core.pms.d
    protected PMSDownloadType zB() {
        return PMSDownloadType.SYNC;
    }
}
