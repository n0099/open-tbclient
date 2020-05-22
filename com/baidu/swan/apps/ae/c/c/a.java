package com.baidu.swan.apps.ae.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.w.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bPF;
    public String bPG;
    public Object csL;
    public String csM;
    public boolean isSuccess = false;

    public a(String str) {
        this.bPF = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void alU() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bPF);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.csM);
            if (this.csL != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.csL.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.ahV().a(this.bPG, gVar);
        com.baidu.swan.apps.ae.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ae.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bPF);
            jSONObject.put("pluginProvider", bVar.csH);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bPG);
        } catch (JSONException e) {
            com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bPF + "', error=" + this.csL + ", isSuccess=" + this.isSuccess + ", resultData='" + this.csM + "'}";
    }
}
