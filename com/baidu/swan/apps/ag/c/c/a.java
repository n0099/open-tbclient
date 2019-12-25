package com.baidu.swan.apps.ag.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.n.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public Object bDE;
    public String bDF;
    public String bdh;
    public String bdi;
    public boolean isSuccess = false;

    public a(String str) {
        this.bdh = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void Xt() {
        f fVar = new f();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bdh);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.bDF);
            if (this.bDE != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.bDE.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        fVar.mData = jSONObject;
        com.baidu.swan.apps.y.f.Uf().a(this.bdi, fVar);
        com.baidu.swan.apps.ag.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bdh);
            jSONObject.put("pluginProvider", bVar.bDA);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bdi);
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bdh + "', error=" + this.bDE + ", isSuccess=" + this.isSuccess + ", resultData='" + this.bDF + "'}";
    }
}
