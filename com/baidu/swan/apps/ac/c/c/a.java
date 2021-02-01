package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cLq;
    public String cLr;
    public String dsA;
    public Object dsz;
    public boolean isSuccess = false;

    public a(String str) {
        this.cLq = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aEP() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cLq);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.dsA);
            if (this.dsz != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dsz.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.aAl().a(this.cLr, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cLq);
            jSONObject.put("pluginProvider", bVar.dsv);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cLr);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cLq + "', error=" + this.dsz + ", isSuccess=" + this.isSuccess + ", resultData='" + this.dsA + "'}";
    }
}
