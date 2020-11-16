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
/* loaded from: classes14.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.ry(), currentTimeMillis).acs().acr().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jw */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aX(str, com.baidu.prologue.a.b.a.this.ry());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.cfv.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.ry(), currentTimeMillis);
        a2.dQ(true);
        a2.acs().acr().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jw */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aX = com.baidu.prologue.business.data.a.aX(str, com.baidu.prologue.a.b.a.this.ry());
                    if (aX != null && aX.size() > 0 && aX.get(0) != null) {
                        cVar.a(aX.get(0));
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
                g.cfv.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.aba(), com.baidu.prologue.a.a.a.aaZ() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.bc("ac", "3");
        aVar2.bc("pid", str2);
        aVar2.bc("product_id ", aVar.abl());
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
            List<com.baidu.prologue.business.data.e> abN = com.baidu.prologue.business.data.d.abN();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (abN != null && abN.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : abN) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.cfT);
                    if (!TextUtils.isEmpty(eVar.cfT)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.cfT);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.cgc));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.abS());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.abd() + j));
            jSONArray.put(jSONObject6);
            aVar.bc("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bc("ver", aVar2.abb());
        aVar.bc("sv", "1.0.4");
        aVar.bc("uid", aVar2.abj());
        aVar.bc("bdid", aVar2.abh());
        aVar.bc("cuid", aVar2.abd());
        aVar.bc("mod", aVar2.abe());
        aVar.bc("ov", aVar2.abc());
        aVar.bc("imei", aVar2.abf());
        aVar.bc(j.c, aVar2.abi());
        aVar.bc("fmt", "json");
        aVar.bc("coot", aVar2.abo());
        aVar.bc("lgt", aVar2.abp()[0]);
        aVar.bc("lat", aVar2.abp()[1]);
        aVar.bc("apna", aVar2.abg());
        aVar.bc("eid", aVar2.abn());
        aVar.bc("st", "1");
        aVar.bc("ot", "2");
        aVar.bc("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.aba()).acp()));
        aVar.bc(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.bc("is_https", "1");
        aVar.bc("android_id", aVar2.androidId());
        aVar.bc("from", aVar2.abq());
        aVar.bc(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.abr());
        aVar.bb("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.abv())) {
            aVar.bc("oaid", aVar2.abv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.abd() + j), aVar.ry(), str, System.currentTimeMillis() - j, str2);
    }
}
