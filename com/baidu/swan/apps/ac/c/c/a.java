package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public Object cKm;
    public String cKn;
    public String ccZ;
    public String cda;
    public boolean isSuccess = false;

    public a(String str) {
        this.ccZ = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void axp() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.ccZ);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cKn);
            if (this.cKm != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.cKm.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.asJ().a(this.cda, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.ccZ);
            jSONObject.put("pluginProvider", bVar.cKi);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cda);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.ccZ + "', error=" + this.cKm + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cKn + "'}";
    }
}
