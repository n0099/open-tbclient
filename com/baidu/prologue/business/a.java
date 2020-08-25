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
/* loaded from: classes9.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.rt(), currentTimeMillis).Wd().Wc().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ia */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aM(str, com.baidu.prologue.a.b.a.this.rt());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.bKk.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a = a(aVar, "query", aVar.rt(), currentTimeMillis);
        a.dn(true);
        a.Wd().Wc().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: ia */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aM = com.baidu.prologue.business.data.a.aM(str, com.baidu.prologue.a.b.a.this.rt());
                    if (aM != null && aM.size() > 0 && aM.get(0) != null) {
                        cVar.a(aM.get(0));
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
                g.bKk.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.UK(), com.baidu.prologue.a.a.a.UJ() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aR("ac", "3");
        aVar2.aR("pid", str2);
        aVar2.aR("product_id ", aVar.UV());
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
            List<com.baidu.prologue.business.data.e> Vx = com.baidu.prologue.business.data.d.Vx();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (Vx != null && Vx.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : Vx) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bKI);
                    if (!TextUtils.isEmpty(eVar.bKI)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bKI);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bKR));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.VC());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.UN() + j));
            jSONArray.put(jSONObject6);
            aVar.aR("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aR("ver", aVar2.UL());
        aVar.aR("sv", "1.0.4");
        aVar.aR("uid", aVar2.UT());
        aVar.aR("bdid", aVar2.UR());
        aVar.aR("cuid", aVar2.UN());
        aVar.aR("mod", aVar2.UO());
        aVar.aR("ov", aVar2.UM());
        aVar.aR("imei", aVar2.UP());
        aVar.aR(j.c, aVar2.US());
        aVar.aR("fmt", "json");
        aVar.aR("coot", aVar2.UY());
        aVar.aR("lgt", aVar2.UZ()[0]);
        aVar.aR("lat", aVar2.UZ()[1]);
        aVar.aR("apna", aVar2.UQ());
        aVar.aR("eid", aVar2.UX());
        aVar.aR("st", "1");
        aVar.aR("ot", "2");
        aVar.aR("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.UK()).Wa()));
        aVar.aR(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aR("is_https", "1");
        aVar.aR("android_id", aVar2.androidId());
        aVar.aR("from", aVar2.Va());
        aVar.aR(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.Vb());
        aVar.aQ("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.Vf())) {
            aVar.aR("oaid", aVar2.Vf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.UN() + j), aVar.rt(), str, System.currentTimeMillis() - j, str2);
    }
}
