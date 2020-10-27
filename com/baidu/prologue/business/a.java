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
/* loaded from: classes19.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.ry(), currentTimeMillis).aaC().aaB().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jp */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aY(str, com.baidu.prologue.a.b.a.this.ry());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.cbu.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.ry(), currentTimeMillis);
        a2.dH(true);
        a2.aaC().aaB().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: jp */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aY = com.baidu.prologue.business.data.a.aY(str, com.baidu.prologue.a.b.a.this.ry());
                    if (aY != null && aY.size() > 0 && aY.get(0) != null) {
                        cVar.a(aY.get(0));
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
                g.cbu.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.Zk(), com.baidu.prologue.a.a.a.Zj() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.bd("ac", "3");
        aVar2.bd("pid", str2);
        aVar2.bd("product_id ", aVar.Zv());
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
            List<com.baidu.prologue.business.data.e> ZX = com.baidu.prologue.business.data.d.ZX();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (ZX != null && ZX.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : ZX) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.cbS);
                    if (!TextUtils.isEmpty(eVar.cbS)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.cbS);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.ccb));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.aac());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.Zn() + j));
            jSONArray.put(jSONObject6);
            aVar.bd("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.bd("ver", aVar2.Zl());
        aVar.bd("sv", "1.0.4");
        aVar.bd("uid", aVar2.Zt());
        aVar.bd("bdid", aVar2.Zr());
        aVar.bd("cuid", aVar2.Zn());
        aVar.bd("mod", aVar2.Zo());
        aVar.bd("ov", aVar2.Zm());
        aVar.bd("imei", aVar2.Zp());
        aVar.bd(j.c, aVar2.Zs());
        aVar.bd("fmt", "json");
        aVar.bd("coot", aVar2.Zy());
        aVar.bd("lgt", aVar2.Zz()[0]);
        aVar.bd("lat", aVar2.Zz()[1]);
        aVar.bd("apna", aVar2.Zq());
        aVar.bd("eid", aVar2.Zx());
        aVar.bd("st", "1");
        aVar.bd("ot", "2");
        aVar.bd("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.Zk()).aaz()));
        aVar.bd(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.bd("is_https", "1");
        aVar.bd("android_id", aVar2.androidId());
        aVar.bd("from", aVar2.ZA());
        aVar.bd(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.ZB());
        aVar.bc("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.ZF())) {
            aVar.bd("oaid", aVar2.ZF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.Zn() + j), aVar.ry(), str, System.currentTimeMillis() - j, str2);
    }
}
