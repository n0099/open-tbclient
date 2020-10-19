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
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.ry(), currentTimeMillis).YJ().YI().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iW */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aR(str, com.baidu.prologue.a.b.a.this.ry());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.bSX.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a2 = a(aVar, "query", aVar.ry(), currentTimeMillis);
        a2.dt(true);
        a2.YJ().YI().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iW */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aR = com.baidu.prologue.business.data.a.aR(str, com.baidu.prologue.a.b.a.this.ry());
                    if (aR != null && aR.size() > 0 && aR.get(0) != null) {
                        cVar.a(aR.get(0));
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
                g.bSX.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.Xq(), com.baidu.prologue.a.a.a.Xp() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aW("ac", "3");
        aVar2.aW("pid", str2);
        aVar2.aW("product_id ", aVar.XB());
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
            List<com.baidu.prologue.business.data.e> Yd = com.baidu.prologue.business.data.d.Yd();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (Yd != null && Yd.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : Yd) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bTv);
                    if (!TextUtils.isEmpty(eVar.bTv)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bTv);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bTE));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.Yi());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.Xt() + j));
            jSONArray.put(jSONObject6);
            aVar.aW("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aW("ver", aVar2.Xr());
        aVar.aW("sv", "1.0.4");
        aVar.aW("uid", aVar2.Xz());
        aVar.aW("bdid", aVar2.Xx());
        aVar.aW("cuid", aVar2.Xt());
        aVar.aW("mod", aVar2.Xu());
        aVar.aW("ov", aVar2.Xs());
        aVar.aW("imei", aVar2.Xv());
        aVar.aW(j.c, aVar2.Xy());
        aVar.aW("fmt", "json");
        aVar.aW("coot", aVar2.XE());
        aVar.aW("lgt", aVar2.XF()[0]);
        aVar.aW("lat", aVar2.XF()[1]);
        aVar.aW("apna", aVar2.Xw());
        aVar.aW("eid", aVar2.XD());
        aVar.aW("st", "1");
        aVar.aW("ot", "2");
        aVar.aW("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.Xq()).YG()));
        aVar.aW(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aW("is_https", "1");
        aVar.aW("android_id", aVar2.androidId());
        aVar.aW("from", aVar2.XG());
        aVar.aW(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.XH());
        aVar.aV("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.XL())) {
            aVar.aW("oaid", aVar2.XL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.Xt() + j), aVar.ry(), str, System.currentTimeMillis() - j, str2);
    }
}
