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
/* loaded from: classes5.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.rc(), currentTimeMillis).adD().adC().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ei */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.bc(str, com.baidu.prologue.a.b.a.this.rc());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void l(Throwable th) {
                g.cor.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.rc(), currentTimeMillis);
        a2.el(true);
        a2.adD().adC().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ei */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> bc = com.baidu.prologue.business.data.a.bc(str, com.baidu.prologue.a.b.a.this.rc());
                    if (bc != null && bc.size() > 0 && bc.get(0) != null) {
                        cVar.a(bc.get(0));
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
                g.cor.e("Afd", "query接口 " + th.getMessage());
                cVar.k(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.acl(), com.baidu.prologue.a.a.a.ack() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.bh("ac", "3");
        aVar2.bh("pid", str2);
        aVar2.bh("product_id ", aVar.acw());
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
            List<com.baidu.prologue.business.data.e> acY = com.baidu.prologue.business.data.d.acY();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (acY != null && acY.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : acY) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.coP);
                    if (!TextUtils.isEmpty(eVar.coP)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.coP);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.coY));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.add());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.aco() + j));
            jSONArray.put(jSONObject6);
            aVar.bh("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bh("ver", aVar2.acm());
        aVar.bh("sv", "1.0.4");
        aVar.bh("uid", aVar2.acu());
        aVar.bh("bdid", aVar2.acs());
        aVar.bh("cuid", aVar2.aco());
        aVar.bh("mod", aVar2.acp());
        aVar.bh("ov", aVar2.acn());
        aVar.bh("imei", aVar2.acq());
        aVar.bh(j.c, aVar2.act());
        aVar.bh("fmt", "json");
        aVar.bh("coot", aVar2.acz());
        aVar.bh("lgt", aVar2.acA()[0]);
        aVar.bh("lat", aVar2.acA()[1]);
        aVar.bh("apna", aVar2.acr());
        aVar.bh("eid", aVar2.acy());
        aVar.bh("st", "1");
        aVar.bh("ot", "2");
        aVar.bh("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.acl()).adA()));
        aVar.bh(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.bh("is_https", "1");
        aVar.bh("android_id", aVar2.androidId());
        aVar.bh("from", aVar2.acB());
        aVar.bh(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.acC());
        aVar.bg("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.acG())) {
            aVar.bh("oaid", aVar2.acG());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.aco() + j), aVar.rc(), str, System.currentTimeMillis() - j, str2);
    }
}
