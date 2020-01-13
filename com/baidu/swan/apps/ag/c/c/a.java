package com.baidu.swan.apps.ag.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.n.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public Object bEp;
    public String bEq;
    public String bdV;
    public String bdW;
    public boolean isSuccess = false;

    public a(String str) {
        this.bdV = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void XQ() {
        f fVar = new f();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bdV);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.bEq);
            if (this.bEp != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.bEp.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        fVar.mData = jSONObject;
        com.baidu.swan.apps.y.f.UC().a(this.bdW, fVar);
        com.baidu.swan.apps.ag.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bdV);
            jSONObject.put("pluginProvider", bVar.bEl);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bdW);
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bdV + "', error=" + this.bEp + ", isSuccess=" + this.isSuccess + ", resultData='" + this.bEq + "'}";
    }
}
