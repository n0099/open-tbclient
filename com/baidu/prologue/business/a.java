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
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.pC()).ON().OM().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gA */
            public void onResponse(String str) {
                try {
                    com.baidu.prologue.business.data.a.aG(str, com.baidu.prologue.a.b.a.this.pC());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void o(Throwable th) {
                f.bzz.e("Afd", "update接口 " + th.getMessage());
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        Request.a a = a(aVar, "query", aVar.pC());
        a.cY(true);
        a.ON().OM().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: gA */
            public void onResponse(String str) {
                try {
                    List<com.baidu.prologue.business.data.e> aG = com.baidu.prologue.business.data.a.aG(str, com.baidu.prologue.a.b.a.this.pC());
                    if (aG != null && aG.size() > 0 && aG.get(0) != null) {
                        cVar.a(aG.get(0));
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
                f.bzz.e("Afd", "query接口 " + th.getMessage());
                cVar.n(th);
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2) {
        Request.a aVar2 = new Request.a(aVar.Nt(), com.baidu.prologue.a.a.a.Ns() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aL("ac", "3");
        aVar2.aL("pid", str2);
        aVar2.aL("product_id ", aVar.NE());
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
            List<com.baidu.prologue.business.data.e> Og = com.baidu.prologue.business.data.d.Og();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (Og != null && Og.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : Og) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bzX);
                    if (!TextUtils.isEmpty(eVar.bzX)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bzX);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bAg));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", com.baidu.prologue.business.data.f.Ol());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", "adinfo");
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("k", "ukey");
            jSONObject5.put("v", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
            jSONArray.put(jSONObject5);
            aVar.aL("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aL("ver", aVar2.Nu());
        aVar.aL("sv", "1.0");
        aVar.aL("uid", aVar2.NC());
        aVar.aL("bdid", aVar2.NA());
        aVar.aL("cuid", aVar2.Nw());
        aVar.aL("mod", aVar2.Nx());
        aVar.aL("ov", aVar2.Nv());
        aVar.aL("imei", aVar2.Ny());
        aVar.aL(j.c, aVar2.NB());
        aVar.aL("fmt", "json");
        aVar.aL("coot", aVar2.NH());
        aVar.aL("lgt", aVar2.NI()[0]);
        aVar.aL("lat", aVar2.NI()[1]);
        aVar.aL("apna", aVar2.Nz());
        aVar.aL("eid", aVar2.NG());
        aVar.aL("st", "1");
        aVar.aL("ot", "2");
        aVar.aL("nt", String.valueOf(new g(aVar2.Nt()).OK()));
        aVar.aL(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aL("is_https", "1");
        aVar.aL("android_id", aVar2.androidId());
        aVar.aL("from", aVar2.NJ());
        aVar.aL(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.NK());
        aVar.aK("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.NO())) {
            aVar.aL("oaid", aVar2.NO());
        }
    }
}
