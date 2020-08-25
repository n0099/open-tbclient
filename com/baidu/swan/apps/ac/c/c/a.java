package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public Object cIi;
    public String cIj;
    public String caT;
    public String caU;
    public boolean isSuccess = false;

    public a(String str) {
        this.caT = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void awG() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.caT);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cIj);
            if (this.cIi != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.cIi.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.arY().a(this.caU, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.caT);
            jSONObject.put("pluginProvider", bVar.cIe);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.caU);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.caT + "', error=" + this.cIi + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cIj + "'}";
    }
}
