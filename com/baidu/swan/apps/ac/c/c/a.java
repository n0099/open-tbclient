package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String cxR;
    public String cxS;
    public Object deQ;
    public String deR;
    public boolean isSuccess = false;

    public a(String str) {
        this.cxR = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aBU() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cxR);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.deR);
            if (this.deQ != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.deQ.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.axo().a(this.cxS, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cxR);
            jSONObject.put("pluginProvider", bVar.deM);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cxS);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cxR + "', error=" + this.deQ + ", isSuccess=" + this.isSuccess + ", resultData='" + this.deR + "'}";
    }
}
