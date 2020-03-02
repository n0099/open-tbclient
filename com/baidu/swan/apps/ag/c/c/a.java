package com.baidu.swan.apps.ag.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.n.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public Object bIv;
    public String bIw;
    public String bil;
    public String bim;
    public boolean isSuccess = false;

    public a(String str) {
        this.bil = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aag() {
        f fVar = new f();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bil);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.bIw);
            if (this.bIv != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.bIv.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        fVar.mData = jSONObject;
        com.baidu.swan.apps.y.f.WS().a(this.bim, fVar);
        com.baidu.swan.apps.ag.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bil);
            jSONObject.put("pluginProvider", bVar.bIr);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bim);
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bil + "', error=" + this.bIv + ", isSuccess=" + this.isSuccess + ", resultData='" + this.bIw + "'}";
    }
}
