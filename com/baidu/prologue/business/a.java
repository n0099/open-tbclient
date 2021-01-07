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
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.rc(), currentTimeMillis).ahx().ahw().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fu */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.bd(str, com.baidu.prologue.a.b.a.this.rc());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void l(Throwable th) {
                g.ctf.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.rc(), currentTimeMillis);
        a2.ep(true);
        a2.ahx().ahw().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fu */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> bd = com.baidu.prologue.business.data.a.bd(str, com.baidu.prologue.a.b.a.this.rc());
                    if (bd != null && bd.size() > 0 && bd.get(0) != null) {
                        cVar.a(bd.get(0));
                    } else {
                        cVar.k(new Throwable("no ad"));
                    }
                } catch (ParseError e) {
                    e.printStackTrace();
                    cVar.k(e);
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void l(Throwable th) {
                g.ctf.e("Afd", "query接口 " + th.getMessage());
                cVar.k(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.agf(), com.baidu.prologue.a.a.a.age() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.bi("ac", "3");
        aVar2.bi("pid", str2);
        aVar2.bi("product_id ", aVar.agq());
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
            List<com.baidu.prologue.business.data.e> agS = com.baidu.prologue.business.data.d.agS();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (agS != null && agS.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : agS) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.ctG);
                    if (!TextUtils.isEmpty(eVar.ctG)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.ctG);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.ctP));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.agX());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", Constants.KEYS.AD_INFO);
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(",", arrayList));
            jSONArray.put(jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("k", "logid");
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.agi() + j));
            jSONArray.put(jSONObject6);
            aVar.bi("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bi("ver", aVar2.agg());
        aVar.bi("sv", "1.0.4");
        aVar.bi("uid", aVar2.ago());
        aVar.bi("bdid", aVar2.agm());
        aVar.bi("cuid", aVar2.agi());
        aVar.bi("mod", aVar2.agj());
        aVar.bi("ov", aVar2.agh());
        aVar.bi("imei", aVar2.agk());
        aVar.bi(j.c, aVar2.agn());
        aVar.bi("fmt", "json");
        aVar.bi("coot", aVar2.agt());
        aVar.bi("lgt", aVar2.agu()[0]);
        aVar.bi("lat", aVar2.agu()[1]);
        aVar.bi("apna", aVar2.agl());
        aVar.bi("eid", aVar2.ags());
        aVar.bi("st", "1");
        aVar.bi("ot", "2");
        aVar.bi("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.agf()).ahu()));
        aVar.bi(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.bi("is_https", "1");
        aVar.bi("android_id", aVar2.androidId());
        aVar.bi("from", aVar2.agv());
        aVar.bi(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.agw());
        aVar.bh("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.agA())) {
            aVar.bi("oaid", aVar2.agA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.agi() + j), aVar.rc(), str, System.currentTimeMillis() - j, str2);
    }
}
