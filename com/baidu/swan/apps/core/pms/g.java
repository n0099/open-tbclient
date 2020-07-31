package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.e cez;
    private long mStartTime;

    public g(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar.id);
        this.mStartTime = 0L;
        this.cez = eVar;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int abW() {
        return 1;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void Zu() {
        this.mStartTime = System.currentTimeMillis();
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("aps_start_req"));
        super.Zu();
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("aps_end_req"));
        if (this.mStartTime > 0 && System.currentTimeMillis() - this.mStartTime > 3000) {
            com.baidu.swan.apps.core.d.log("PMS获取包接口返回超过3秒，检查弱网");
            com.baidu.swan.apps.core.d.YX();
        }
        if (DEBUG) {
            Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.f fVar) {
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("aps_start_download"));
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
    public void aY(String str, String str2) {
        super.aY(str, str2);
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
                    com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent(str2));
                    return;
                case 1:
                    if (this.ceb != null) {
                        this.ceb.add(new UbcFlowEvent(str2));
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
                String str3 = null;
                try {
                    try {
                        str3 = "PkgSyncDownloadCallback";
                        Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString(4));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str3 = "PkgSyncDownloadCallback";
                        Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + jSONObject.toString());
                    }
                } catch (Throwable th) {
                    Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                    throw th;
                }
            }
            long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
            long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
            long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
            long optLong4 = jSONObject.optLong("connectedTime", optLong);
            long optLong5 = jSONObject.optLong("startTime", optLong);
            com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("pms_network_start").bm(optLong5)).f(new UbcFlowEvent("pms_network_conn").bm(optLong4)).f(new UbcFlowEvent("pms_dns_start").bm(optLong3)).f(new UbcFlowEvent("pms_dns_end").bm(optLong2)).f(new UbcFlowEvent("pms_network_response").bm(jSONObject.optLong("responseTime", optLong))).f(new UbcFlowEvent("pms_send_header").bm(jSONObject.optLong("sendHeaderTime", optLong))).f(new UbcFlowEvent("pms_receive_header").bm(jSONObject.optLong("receiveHeaderTime", optLong)));
            long j = optLong2 - optLong3;
            long j2 = optLong4 - optLong5;
            int aoC = com.baidu.swan.apps.performance.f.a.aoC();
            if (aoC > 0 && j > aoC) {
                if (DEBUG) {
                    Log.e("PkgSyncDownloadCallback", "pms dns too slow:" + j);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bJ(10L).bK(2910L).qk("pms dns too slow"));
            }
            int aoD = com.baidu.swan.apps.performance.f.a.aoD();
            if (aoD > 0 && j2 > aoD) {
                if (DEBUG) {
                    Log.e("PkgSyncDownloadCallback", "pms connect too slow:" + j2);
                }
                a(str2, jSONObject, new com.baidu.swan.apps.an.a().bJ(10L).bK(2911L).qk("pms connect too slow"));
            }
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "pms dns=" + j + "  conn=" + j2 + "  " + jSONObject.toString());
            }
        }
    }

    private void a(String str, JSONObject jSONObject, com.baidu.swan.apps.an.a aVar) {
        if (this.cez != null && aVar != null) {
            com.baidu.swan.apps.statistic.a.d pv = new com.baidu.swan.apps.statistic.a.d().f(aVar).a(this.cez.Se()).pu(com.baidu.swan.apps.statistic.h.ho(this.cez.RU())).pv(this.mAppId);
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
            pv.bF(jSONObject2);
            JSONObject jSONObject3 = pv.toJSONObject();
            com.baidu.swan.apps.statistic.h.b(pv);
            com.baidu.swan.apps.al.a.atW().u(aVar.avQ(), jSONObject3);
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "event=" + jSONObject3.toString());
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.e
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("get_launch_id")) {
            a.putString("launch_id", this.cez.arz().ajz());
        }
        return a;
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        com.baidu.swan.apps.an.a ql = new com.baidu.swan.apps.an.a().bJ(10L).bK(aVar.errorNo).qk(aVar.errorMsg).ql(aVar.dwi);
        if (aVar.errorNo == 1013 && com.baidu.swan.apps.t.a.ahQ().a(com.baidu.swan.apps.t.a.ahj(), this.mAppId, ql)) {
            a(ql, false);
            a(this.cez.arz(), ql);
        } else if (aVar.errorNo == 1020) {
            a(ql, false);
            a(this.cez.arz(), ql);
        } else {
            a(ql, true);
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        if (this.cea != null) {
            acj();
        }
        a(new com.baidu.swan.apps.an.a().bJ(10L).bK(2901L).qk("同步获取-> Server无包"), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.pms.f
    public void aca() {
        super.aca();
        if (DEBUG) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("aps_end_download")).r("type", "0");
        this.ceb.add(new UbcFlowEvent("na_start_update_db"));
        com.baidu.swan.apps.an.a aci = aci();
        this.ceb.add(new UbcFlowEvent("na_end_update_db"));
        if (aci == null) {
            if (DEBUG) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            com.baidu.swan.apps.u.c.b acl = acl();
            if (this.cdY != null && this.cdY.category == 0) {
                acl.b(com.baidu.swan.apps.swancore.b.hx(0));
                acl.ga(1);
            }
            if (this.cdY != null && this.cdY.category == 1) {
                acl.b(com.baidu.swan.apps.swancore.b.hx(1));
                acl.ga(1);
            }
            if (this.cdZ != null && this.cdZ.category == 0) {
                acl.c(com.baidu.swan.apps.extcore.b.fA(0));
                acl.ga(2);
            }
            if (this.cdZ != null && this.cdZ.category == 1) {
                acl.c(com.baidu.swan.apps.extcore.b.fA(1));
                acl.ga(2);
            }
            if (this.ced != null) {
                acl.eo(this.ced.dwl);
                acl.lP(this.ced.pkgName);
            }
            d(this.cea);
            be("main_download", "0");
            return;
        }
        if (DEBUG) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        a(aci, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        com.baidu.swan.apps.an.a qk;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            qk = pkgDownloadError.getErrCode();
        } else {
            if (DEBUG) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            qk = new com.baidu.swan.apps.an.a().bJ(10L).bK(2900L).qk("包下载过程未知错误");
        }
        a(qk, true);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType acb() {
        return PMSDownloadType.SYNC;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected int Zv() {
        return 200;
    }

    public com.baidu.swan.apps.u.c.b acl() {
        return this.cez.arz();
    }

    private void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.an.a aVar) {
        if (bVar != null) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.h.ho(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ajg();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.v("status", "1");
            if (aVar != null) {
                fVar.v("errcode", String.valueOf(aVar.avT()));
                fVar.v("msg", aVar.avS().toString());
            }
            fVar.py(bVar.ajm().getString("ubc"));
            fVar.b(bVar);
            com.baidu.swan.apps.statistic.h.onEvent(fVar);
            HybridUbcFlow mZ = com.baidu.swan.apps.performance.i.mZ("startup");
            if (mZ != null) {
                mZ.r("value", "na_success");
            }
        }
    }
}
