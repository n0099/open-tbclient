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
    private final com.baidu.swan.apps.runtime.e ccW;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.ccW = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void YC() {
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("aps_start_req"));
        super.YC();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void aaV() {
        super.aaV();
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("aps_end_req"));
        if (DEBUG) {
            Log.d("SwanAppPkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aW(String str, String str2) {
        super.aW(str, str2);
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
                    com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.ccx != null) {
                        this.ccx.add(new UbcFlowEvent(str2));
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
            com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("pms_network_start").bg(optLong4)).f(new UbcFlowEvent("pms_network_conn").bg(optLong3)).f(new UbcFlowEvent("pms_dns_start").bg(optLong2)).f(new UbcFlowEvent("pms_dns_end").bg(optLong)).f(new UbcFlowEvent("pms_network_response").bg(jSONObject.optLong("responseTime", currentTimeMillis))).f(new UbcFlowEvent("pms_send_header").bg(jSONObject.optLong("sendHeaderTime", currentTimeMillis))).f(new UbcFlowEvent("pms_receive_header").bg(jSONObject.optLong("receiveHeaderTime", currentTimeMillis)));
            long j = optLong - optLong2;
            long j2 = optLong3 - optLong4;
            int amU = com.baidu.swan.apps.performance.e.a.amU();
            if (amU > 0 && j > amU) {
                if (DEBUG) {
                    Log.e("SwanAppPkgSyncDownloadCallback", "pms dns too slow:" + j);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bw(10L).bx(2910L).pz("pms dns too slow"));
            }
            int amV = com.baidu.swan.apps.performance.e.a.amV();
            if (amV > 0 && j2 > amV) {
                if (DEBUG) {
                    Log.e("SwanAppPkgSyncDownloadCallback", "pms connect too slow:" + j2);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bw(10L).bx(2911L).pz("pms connect too slow"));
            }
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "pms dns=" + j + "  conn=" + j2 + "  " + jSONObject.toString());
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.swan.apps.an.a aVar) {
        if (this.ccW != null && aVar != null) {
            com.baidu.swan.apps.statistic.a.d oL = new com.baidu.swan.apps.statistic.a.d().f(aVar).a(this.ccW.RP()).oK(com.baidu.swan.apps.statistic.h.hf(this.ccW.RF())).oL(this.mAppId);
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
            oL.bA(jSONObject2);
            JSONObject jSONObject3 = oL.toJSONObject();
            com.baidu.swan.apps.statistic.h.b(oL);
            com.baidu.swan.apps.al.a.arZ().u(aVar.atP(), jSONObject3);
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
            a.putString("launch_id", this.ccW.apQ().aij());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.an.a pA = new com.baidu.swan.apps.an.a().bw(10L).bx(aVar.errorNo).pz(aVar.errorMsg).pA(aVar.dqq);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.u.a.agD().a(this.mAppId, pA)) {
            a(pA, false);
            a(this.ccW.apQ(), pA);
        } else if (aVar.errorNo == 1020) {
            a(pA, false);
            a(this.ccW.apQ(), pA);
        } else {
            a(pA, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        if (this.ccw != null) {
            abh();
        }
        a(new com.baidu.swan.apps.an.a().bw(10L).bx(2901L).pz("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aaX() {
        super.aaX();
        if (DEBUG) {
            Log.i("SwanAppPkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        this.ccx.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a abg = abg();
        this.ccx.add(new UbcFlowEvent("na_end_update_db"));
        if (abg == null) {
            if (DEBUG) {
                Log.d("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.v.b.b abj = abj();
            if (this.ccu != null && this.ccu.category == 0) {
                abj.b(com.baidu.swan.apps.swancore.b.ho(0));
                abj.fQ(1);
            }
            if (this.ccu != null && this.ccu.category == 1) {
                abj.b(com.baidu.swan.apps.swancore.b.ho(1));
                abj.fQ(1);
            }
            if (this.ccv != null && this.ccv.category == 0) {
                abj.c(com.baidu.swan.apps.extcore.b.fr(0));
                abj.fQ(2);
            }
            if (this.ccv != null && this.ccv.category == 1) {
                abj.c(com.baidu.swan.apps.extcore.b.fr(1));
                abj.fQ(2);
            }
            if (this.ccz != null) {
                abj.eg(this.ccz.dqt);
                abj.lo(this.ccz.pkgName);
            }
            b(this.ccw);
            bc("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("SwanAppPkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(abg, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        com.baidu.swan.apps.an.a pz;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            pz = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("SwanAppPkgSyncDownloadCallback", "未知错误");
            }
            pz = new com.baidu.swan.apps.an.a().bw(10L).bx(2900L).pz("包下载过程未知错误");
        }
        a(pz, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aaY() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int YD() {
        return 200;
    }

    public com.baidu.swan.apps.v.b.b abj() {
        return this.ccW.apQ();
    }

    private void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ahQ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.v("status", "1");
            if (aVar != null) {
                fVar.v("errcode", String.valueOf(aVar.atS()));
                fVar.v("msg", aVar.atR().toString());
            }
            fVar.oO(bVar.ahW().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
        }
    }
}
