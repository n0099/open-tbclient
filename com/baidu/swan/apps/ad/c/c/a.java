package com.baidu.swan.apps.ad.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String bVl;
    public String bVm;
    public String cAa;
    public Object czZ;
    public boolean isSuccess = false;

    public a(String str) {
        this.bVl = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aoJ() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bVl);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cAa);
            if (this.czZ != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.czZ.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ad.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.akr().a(this.bVm, gVar);
        com.baidu.swan.apps.ad.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ad.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bVl);
            jSONObject.put("pluginProvider", bVar.czV);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bVm);
        } catch (JSONException e) {
            com.baidu.swan.apps.ad.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bVl + "', error=" + this.czZ + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cAa + "'}";
    }
}
