package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public Object cWp;
    public String cWq;
    public String cpp;
    public String cpq;
    public boolean isSuccess = false;

    public a(String str) {
        this.cpp = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aAa() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cpp);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cWq);
            if (this.cWp != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.cWp.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.avu().a(this.cpq, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cpp);
            jSONObject.put("pluginProvider", bVar.cWl);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cpq);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cpp + "', error=" + this.cWp + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cWq + "'}";
    }
}
