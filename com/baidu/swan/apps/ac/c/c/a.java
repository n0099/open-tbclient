package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public Object cIm;
    public String cIn;
    public String caX;
    public String caY;
    public boolean isSuccess = false;

    public a(String str) {
        this.caX = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void awG() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.caX);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cIn);
            if (this.cIm != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.cIm.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.arY().a(this.caY, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.caX);
            jSONObject.put("pluginProvider", bVar.cIi);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.caY);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.caX + "', error=" + this.cIm + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cIn + "'}";
    }
}
