package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e bYh;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.bYh = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Xw() {
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("aps_start_req"));
        super.Xw();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aU(String str, String str2) {
        super.aU(str, str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 53647:
                    if (str.equals("670")) {
                        c = 0;
                        break;
                    }
                    break;
                case 54608:
                    if (str.equals("770")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.bXI != null) {
                        this.bXI.add(new UbcFlowEvent(str2));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                try {
                    try {
                        Log.i("SwanAppPkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString(4));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.i("SwanAppPkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString());
                    }
                } catch (Throwable th) {
                    Log.i("SwanAppPkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + ((String) null));
                    throw th;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long optLong = jSONObject.optLong("dnsEndTime", currentTimeMillis);
            long optLong2 = jSONObject.optLong("dnsStartTime", currentTimeMillis);
            long optLong3 = jSONObject.optLong("connectedTime", currentTimeMillis);
            long optLong4 = jSONObject.optLong("startTime", currentTimeMillis);
            com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("pms_network_start").bg(optLong4)).f(new UbcFlowEvent("pms_network_conn").bg(optLong3)).f(new UbcFlowEvent("pms_dns_start").bg(optLong2)).f(new UbcFlowEvent("pms_dns_end").bg(optLong)).f(new UbcFlowEvent("pms_network_response").bg(jSONObject.optLong("responseTime", currentTimeMillis))).f(new UbcFlowEvent("pms_send_header").bg(jSONObject.optLong("sendHeaderTime", currentTimeMillis))).f(new UbcFlowEvent("pms_receive_header").bg(jSONObject.optLong("receiveHeaderTime", currentTimeMillis)));
            long j = optLong - optLong2;
            long j2 = optLong3 - optLong4;
            int alO = com.baidu.swan.apps.performance.e.a.alO();
            if (alO > 0 && j > alO) {
                if (DEBUG) {
                    Log.e("SwanAppPkgSyncDownloadCallback", "pms dns too slow:" + j);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bw(10L).bx(2910L).pr("pms dns too slow"));
            }
            int alP = com.baidu.swan.apps.performance.e.a.alP();
            if (alP > 0 && j2 > alP) {
                if (DEBUG) {
                    Log.e("SwanAppPkgSyncDownloadCallback", "pms connect too slow:" + j2);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bw(10L).bx(2911L).pr("pms connect too slow"));
            }
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "pms dns=" + j + "  conn=" + j2 + "  " + jSONObject.toString());
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.swan.apps.an.a aVar) {
        if (this.bYh != null && aVar != null) {
            com.baidu.swan.apps.statistic.a.d oD = new com.baidu.swan.apps.statistic.a.d().f(aVar).a(this.bYh.QJ()).oC(com.baidu.swan.apps.statistic.h.gU(this.bYh.Qz())).oD(this.mAppId);
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put("NetworkStatRecord", jSONObject);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            jSONObject2.put(IIntercepter.TYPE_RESPONSE, str);
            oD.bt(jSONObject2);
            JSONObject jSONObject3 = oD.toJSONObject();
            com.baidu.swan.apps.statistic.h.b(oD);
            com.baidu.swan.apps.al.a.aqT().u(aVar.asJ(), jSONObject3);
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "event=" + jSONObject3.toString());
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.bYh.aoJ().ahd());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.an.a ps = new com.baidu.swan.apps.an.a().bw(10L).bx(aVar.errorNo).pr(aVar.errorMsg).ps(aVar.dlF);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.u.a.afx().a(this.mAppId, ps)) {
            a(ps, false);
            a(this.bYh.aoJ(), ps);
        } else if (aVar.errorNo == 1020) {
            a(ps, false);
            a(this.bYh.aoJ(), ps);
        } else {
            a(ps, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        if (this.bXH != null) {
            aab();
        }
        a(new com.baidu.swan.apps.an.a().bw(10L).bx(2901L).pr("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void ZR() {
        super.ZR();
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        this.bXI.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a aaa = aaa();
        this.bXI.add(new UbcFlowEvent("na_end_update_db"));
        if (aaa == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.v.b.b aad = aad();
            if (this.bXF != null && this.bXF.category == 0) {
                aad.b(com.baidu.swan.apps.swancore.b.hd(0));
                aad.fF(1);
            }
            if (this.bXF != null && this.bXF.category == 1) {
                aad.b(com.baidu.swan.apps.swancore.b.hd(1));
                aad.fF(1);
            }
            if (this.bXG != null && this.bXG.category == 0) {
                aad.c(com.baidu.swan.apps.extcore.b.fg(0));
                aad.fF(2);
            }
            if (this.bXG != null && this.bXG.category == 1) {
                aad.c(com.baidu.swan.apps.extcore.b.fg(1));
                aad.fF(2);
            }
            if (this.bXK != null) {
                aad.eb(this.bXK.dlI);
                aad.lg(this.bXK.pkgName);
            }
            b(this.bXH);
            ba("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aaa, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        com.baidu.swan.apps.an.a pr;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            pr = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            pr = new com.baidu.swan.apps.an.a().bw(10L).bx(2900L).pr("包下载过程未知错误");
        }
        a(pr, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ZS() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int Xx() {
        return 200;
    }

    public com.baidu.swan.apps.v.b.b aad() {
        return this.bYh.aoJ();
    }

    private void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.agK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.v("status", "1");
            if (aVar != null) {
                fVar.v("errcode", String.valueOf(aVar.asM()));
                fVar.v("msg", aVar.asL().toString());
            }
            fVar.oG(bVar.agQ().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
        }
    }
}
