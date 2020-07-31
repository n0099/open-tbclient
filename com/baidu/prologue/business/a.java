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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.pU(), currentTimeMillis).Qi().Qh().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gG */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aI(str, com.baidu.prologue.a.b.a.this.pU());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void o(Throwable th) {
                g.bEK.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a = a(aVar, "query", aVar.pU(), currentTimeMillis);
        a.df(true);
        a.Qi().Qh().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gG */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aI = com.baidu.prologue.business.data.a.aI(str, com.baidu.prologue.a.b.a.this.pU());
                    if (aI != null && aI.size() > 0 && aI.get(0) != null) {
                        cVar.a(aI.get(0));
                    } else {
                        cVar.n(new Throwable("no ad"));
                    }
                } catch (ParseError e) {
                    e.printStackTrace();
                    cVar.n(e);
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void o(Throwable th) {
                g.bEK.e("Afd", "query接口 " + th.getMessage());
                cVar.n(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.OO(), com.baidu.prologue.a.a.a.ON() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aN("ac", "3");
        aVar2.aN("pid", str2);
        aVar2.aN("product_id ", aVar.OZ());
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
            List<com.baidu.prologue.business.data.e> PB = com.baidu.prologue.business.data.d.PB();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (PB != null && PB.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : PB) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bFi);
                    if (!TextUtils.isEmpty(eVar.bFi)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bFi);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bFr));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.PG());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", "adinfo");
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
            jSONArray.put(jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("k", "logid");
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.OR() + j));
            jSONArray.put(jSONObject6);
            aVar.aN("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aN("ver", aVar2.OP());
        aVar.aN("sv", "1.0.4");
        aVar.aN("uid", aVar2.OX());
        aVar.aN("bdid", aVar2.OV());
        aVar.aN("cuid", aVar2.OR());
        aVar.aN("mod", aVar2.OS());
        aVar.aN("ov", aVar2.OQ());
        aVar.aN("imei", aVar2.OT());
        aVar.aN(j.c, aVar2.OW());
        aVar.aN("fmt", "json");
        aVar.aN("coot", aVar2.Pc());
        aVar.aN("lgt", aVar2.Pd()[0]);
        aVar.aN("lat", aVar2.Pd()[1]);
        aVar.aN("apna", aVar2.OU());
        aVar.aN("eid", aVar2.Pb());
        aVar.aN("st", "1");
        aVar.aN("ot", "2");
        aVar.aN("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.OO()).Qf()));
        aVar.aN(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aN("is_https", "1");
        aVar.aN("android_id", aVar2.androidId());
        aVar.aN("from", aVar2.Pe());
        aVar.aN(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.Pf());
        aVar.aM("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.Pj())) {
            aVar.aN("oaid", aVar2.Pj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.OR() + j), aVar.pU(), str, System.currentTimeMillis() - j, str2);
    }
}
