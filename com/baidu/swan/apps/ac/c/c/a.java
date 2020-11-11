package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String cDK;
    public String cDL;
    public Object dkL;
    public String dkM;
    public boolean isSuccess = false;

    public a(String str) {
        this.cDK = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aEu() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cDK);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.dkM);
            if (this.dkL != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dkL.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.azO().a(this.cDL, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cDK);
            jSONObject.put("pluginProvider", bVar.dkH);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cDL);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cDK + "', error=" + this.dkL + ", isSuccess=" + this.isSuccess + ", resultData='" + this.dkM + "'}";
    }
}
