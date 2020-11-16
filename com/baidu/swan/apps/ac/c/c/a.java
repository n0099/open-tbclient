package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String cCa;
    public String cCb;
    public Object dje;
    public String djf;
    public boolean isSuccess = false;

    public a(String str) {
        this.cCa = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aDM() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cCa);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.djf);
            if (this.dje != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dje.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.azg().a(this.cCb, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cCa);
            jSONObject.put("pluginProvider", bVar.dja);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cCb);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cCa + "', error=" + this.dje + ", isSuccess=" + this.isSuccess + ", resultData='" + this.djf + "'}";
    }
}
