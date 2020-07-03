package com.baidu.prologue.business;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.prologue.a.c.f;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.service.network.Request;
import com.baidu.prologue.service.network.g;
import com.baidu.prologue.service.network.m;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.pT()).PT().PS().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gI */
            public void onResponse(String str) {
                try {
                    com.baidu.prologue.business.data.a.aI(str, com.baidu.prologue.a.b.a.this.pT());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void o(Throwable th) {
                f.bEn.e("Afd", "update接口 " + th.getMessage());
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        Request.a a = a(aVar, "query", aVar.pT());
        a.dd(true);
        a.PT().PS().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gI */
            public void onResponse(String str) {
                try {
                    List<com.baidu.prologue.business.data.e> aI = com.baidu.prologue.business.data.a.aI(str, com.baidu.prologue.a.b.a.this.pT());
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
                f.bEn.e("Afd", "query接口 " + th.getMessage());
                cVar.n(th);
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2) {
        Request.a aVar2 = new Request.a(aVar.Oz(), com.baidu.prologue.a.a.a.Oy() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aN("ac", "3");
        aVar2.aN("pid", str2);
        aVar2.aN("product_id ", aVar.OK());
        a(aVar2, aVar);
        a(aVar2, str);
        return aVar2;
    }

    private static void a(Request.a aVar, String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<com.baidu.prologue.business.data.e> Pm = com.baidu.prologue.business.data.d.Pm();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (Pm != null && Pm.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : Pm) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bEL);
                    if (!TextUtils.isEmpty(eVar.bEL)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bEL);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bEU));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", com.baidu.prologue.business.data.f.Pr());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", "adinfo");
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
            jSONArray.put(jSONObject5);
            aVar.aN("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aN("ver", aVar2.OA());
        aVar.aN("sv", "1.0.2");
        aVar.aN("uid", aVar2.OI());
        aVar.aN("bdid", aVar2.OG());
        aVar.aN("cuid", aVar2.OC());
        aVar.aN("mod", aVar2.OD());
        aVar.aN("ov", aVar2.OB());
        aVar.aN("imei", aVar2.OE());
        aVar.aN(j.c, aVar2.OH());
        aVar.aN("fmt", "json");
        aVar.aN("coot", aVar2.ON());
        aVar.aN("lgt", aVar2.OO()[0]);
        aVar.aN("lat", aVar2.OO()[1]);
        aVar.aN("apna", aVar2.OF());
        aVar.aN("eid", aVar2.OM());
        aVar.aN("st", "1");
        aVar.aN("ot", "2");
        aVar.aN("nt", String.valueOf(new g(aVar2.Oz()).PQ()));
        aVar.aN(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aN("is_https", "1");
        aVar.aN("android_id", aVar2.androidId());
        aVar.aN("from", aVar2.OP());
        aVar.aN(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.OQ());
        aVar.aM("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.OU())) {
            aVar.aN("oaid", aVar2.OU());
        }
    }
}
