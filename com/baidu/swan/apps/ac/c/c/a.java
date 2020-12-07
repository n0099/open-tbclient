package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    public String cIV;
    public String cIW;
    public Object dqd;
    public String dqe;
    public boolean isSuccess = false;

    public a(String str) {
        this.cIV = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aGU() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cIV);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.dqe);
            if (this.dqd != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dqd.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.aCp().a(this.cIW, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cIV);
            jSONObject.put("pluginProvider", bVar.dpZ);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cIW);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cIV + "', error=" + this.dqd + ", isSuccess=" + this.isSuccess + ", resultData='" + this.dqe + "'}";
    }
}
