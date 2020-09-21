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
/* loaded from: classes10.dex */
public class a {
    public static void a(final com.baidu.prologue.a.b.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        a(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.ry(), currentTimeMillis).WM().WL().a(new m() { // from class: com.baidu.prologue.business.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iu */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
                try {
                    com.baidu.prologue.business.data.a.aM(str, com.baidu.prologue.a.b.a.this.ry());
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.j
            public void n(Throwable th) {
                g.bMo.e("Afd", "update接口 " + th.getMessage());
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
            }
        });
    }

    public static void a(final com.baidu.prologue.a.b.a aVar, final c cVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        Request.a a = a(aVar, "query", aVar.ry(), currentTimeMillis);
        a.dm(true);
        a.WM().WL().a(new m() { // from class: com.baidu.prologue.business.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.prologue.service.network.j
            /* renamed from: iu */
            public void onResponse(String str) {
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, BasicPushStatus.SUCCESS_CODE, "query");
                try {
                    List<com.baidu.prologue.business.data.e> aM = com.baidu.prologue.business.data.a.aM(str, com.baidu.prologue.a.b.a.this.ry());
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
                g.bMo.e("Afd", "query接口 " + th.getMessage());
                cVar.m(th);
                a.a(com.baidu.prologue.a.b.a.this, currentTimeMillis, th.getMessage(), "query");
            }
        });
    }

    private static Request.a a(com.baidu.prologue.a.b.a aVar, String str, String str2, long j) {
        Request.a aVar2 = new Request.a(aVar.Vt(), com.baidu.prologue.a.a.a.Vs() + (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query"));
        aVar2.aR("ac", "3");
        aVar2.aR("pid", str2);
        aVar2.aR("product_id ", aVar.VE());
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
            List<com.baidu.prologue.business.data.e> Wg = com.baidu.prologue.business.data.d.Wg();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (Wg != null && Wg.size() > 0) {
                for (com.baidu.prologue.business.data.e eVar : Wg) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", eVar.bMM);
                    if (!TextUtils.isEmpty(eVar.bMM)) {
                        int f = com.baidu.prologue.business.data.d.f(eVar);
                        Log.e("Afd", "onAdSuccess: " + f);
                        if (f == 0) {
                            arrayList.add(eVar.bMM);
                        }
                    }
                    jSONObject3.put("r", String.valueOf(eVar.bMV));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", f.Wl());
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
            jSONObject6.put("v", com.baidu.prologue.a.c.f.md5(aVar2.Vw() + j));
            jSONArray.put(jSONObject6);
            aVar.aR("ext", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(Request.a aVar, com.baidu.prologue.a.b.a aVar2) {
        aVar.aR("ver", aVar2.Vu());
        aVar.aR("sv", "1.0.4");
        aVar.aR("uid", aVar2.VC());
        aVar.aR("bdid", aVar2.VA());
        aVar.aR("cuid", aVar2.Vw());
        aVar.aR("mod", aVar2.Vx());
        aVar.aR("ov", aVar2.Vv());
        aVar.aR("imei", aVar2.Vy());
        aVar.aR(j.c, aVar2.VB());
        aVar.aR("fmt", "json");
        aVar.aR("coot", aVar2.VH());
        aVar.aR("lgt", aVar2.VI()[0]);
        aVar.aR("lat", aVar2.VI()[1]);
        aVar.aR("apna", aVar2.Vz());
        aVar.aR("eid", aVar2.VG());
        aVar.aR("st", "1");
        aVar.aR("ot", "2");
        aVar.aR("nt", String.valueOf(new com.baidu.prologue.service.network.g(aVar2.Vt()).WJ()));
        aVar.aR(Config.EXCEPTION_CRASH_TYPE, "2");
        aVar.aR("is_https", "1");
        aVar.aR("android_id", aVar2.androidId());
        aVar.aR("from", aVar2.VJ());
        aVar.aR(BdStatsConstant.StatsKey.CURRENT_CHANNEL, aVar2.VK());
        aVar.aQ("User-Agent", aVar2.userAgent());
        if (!TextUtils.isEmpty(aVar2.VO())) {
            aVar.aR("oaid", aVar2.VO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.prologue.a.b.a aVar, long j, String str, String str2) {
        Als.a(com.baidu.prologue.a.c.f.md5(aVar.Vw() + j), aVar.ry(), str, System.currentTimeMillis() - j, str2);
    }
}
