package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String cMQ;
    public String cMR;
    public Object dub;
    public String duc;
    public boolean isSuccess = false;

    public a(String str) {
        this.cMQ = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aES() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cMQ);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.duc);
            if (this.dub != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dub.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.aAo().a(this.cMR, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cMQ);
            jSONObject.put("pluginProvider", bVar.dtX);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cMR);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cMQ + "', error=" + this.dub + ", isSuccess=" + this.isSuccess + ", resultData='" + this.duc + "'}";
    }
}
