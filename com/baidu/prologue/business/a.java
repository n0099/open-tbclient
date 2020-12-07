package com.baidu.prologue.business;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.prologue.a.c.g;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.Request;
import com.baidu.prologue.service.network.m;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.rA(), currentTimeMillis).afA().afz().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fK */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.be(str, com.baidu.prologue.a.b.a.this.rA());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.cmb.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.rA(), currentTimeMillis);
        a2.eg(true);
        a2.afA().afz().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fK */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> be = com.baidu.prologue.business.data.a.be(str, com.baidu.prologue.a.b.a.this.rA());
                    if (be != null && be.size() > 0 && be.get(0) != null) {
                        cVar.a(be.get(0));
                    } else {
                        cVar.m(new Throwable("no ad"));
                    }
                } catch (ParseError e) {
                    e.printStackTrace();
                    cVar.m(e);
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.cmb.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.aei(), com.baidu.prologue.a.a.a.aeh() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.bj("ac", "3");
        aVar2.bj("pid", str2);
        aVar2.bj("product_id ", aVar.aet());
        a(aVar2, aVar);
        a(aVar2, str, aVar, j);
        return aVar2;
    }

    private static void a(Request.a aVar, String str, com.baidu.prologue.a.b.a aVar2, long j) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<com.baidu.prologue.business.data.e> aeV = com.baidu.prologue.business.data.d.aeV();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (aeV != null && aeV.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : aeV) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.cmA);
                    if (!TextUtils.isEmpty(eVar.cmA)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.cmA);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.cmJ));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.afa());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", "adinfo");
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(",", arrayList));
            jSONArray.put(jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("k", "logid");
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.ael() + j));
            jSONArray.put(jSONObject6);
            aVar.bj("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bj("ver", aVar2.aej());
        aVar.bj("sv", "1.0.4");
        aVar.bj("uid", aVar2.aer());
        aVar.bj("bdid", aVar2.aep());
        aVar.bj("cuid", aVar2.ael());
        aVar.bj("mod", aVar2.aem());
        aVar.bj("ov", aVar2.aek());
        aVar.bj("imei", aVar2.aen());
        aVar.bj(j.c, aVar2.aeq());
        aVar.bj("fmt", "json");
        aVar.bj("coot", aVar2.aew());
        aVar.bj("lgt", aVar2.aex()[0]);
        aVar.bj("lat", aVar2.aex()[1]);
        aVar.bj("apna", aVar2.aeo());
        aVar.bj("eid", aVar2.aev());
        aVar.bj("st", "1");
        aVar.bj("ot", "2");
        aVar.bj("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.aei()).afx()));
        aVar.bj(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.bj("is_https", "1");
        aVar.bj("android_id", aVar2.androidId());
        aVar.bj("from", aVar2.aey());
        aVar.bj(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.aez());
        aVar.bi("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.aeD())) {
            aVar.bj("oaid", aVar2.aeD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.ael() + j), aVar.rA(), str, System.currentTimeMillis() - j, str2);
    }
}
