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
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.pw()).MB().MA().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fO */
            public void onResponse(String str) {
                try {
                    com.baidu.prologue.business.data.a.ar(str, com.baidu.prologue.a.b.a.this.pw());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                f.brS.e("Afd", "update接口 " + th.getMessage());
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        Request.a a = a(aVar, "query", aVar.pw());
        a.cM(true);
        a.MB().MA().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: fO */
            public void onResponse(String str) {
                try {
                    List<com.baidu.prologue.business.data.e> ar = com.baidu.prologue.business.data.a.ar(str, com.baidu.prologue.a.b.a.this.pw());
                    if (ar != null && ar.size() > 0 && ar.get(0) != null) {
                        cVar.a(ar.get(0));
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
                f.brS.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2) {
        Request.a aVar2 = new Request.a(aVar.Lh(), com.baidu.prologue.a.a.a.Lg() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aw("ac", "3");
        aVar2.aw("pid", str2);
        aVar2.aw("product_id ", aVar.Ls());
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
            List<com.baidu.prologue.business.data.e> LU = com.baidu.prologue.business.data.d.LU();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (LU != null && LU.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : LU) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bsq);
                    if (!TextUtils.isEmpty(eVar.bsq)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bsq);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bsz));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", com.baidu.prologue.business.data.f.LZ());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", "adinfo");
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
            jSONArray.put(jSONObject5);
            aVar.aw("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aw("ver", aVar2.Li());
        aVar.aw("sv", "1.0");
        aVar.aw("uid", aVar2.Lq());
        aVar.aw("bdid", aVar2.Lo());
        aVar.aw("cuid", aVar2.Lk());
        aVar.aw("mod", aVar2.Ll());
        aVar.aw("ov", aVar2.Lj());
        aVar.aw("imei", aVar2.Lm());
        aVar.aw(j.c, aVar2.Lp());
        aVar.aw("fmt", "json");
        aVar.aw("coot", aVar2.Lv());
        aVar.aw("lgt", aVar2.Lw()[0]);
        aVar.aw("lat", aVar2.Lw()[1]);
        aVar.aw("apna", aVar2.Ln());
        aVar.aw("eid", aVar2.Lu());
        aVar.aw("st", "1");
        aVar.aw("ot", "2");
        aVar.aw("nt", String.valueOf(new g(aVar2.Lh()).My()));
        aVar.aw(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aw("is_https", "1");
        aVar.aw("android_id", aVar2.androidId());
        aVar.aw("from", aVar2.Lx());
        aVar.aw(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.Ly());
        aVar.av("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.LC())) {
            aVar.aw("oaid", aVar2.LC());
        }
    }
}
