package com.baidu.swan.apps.ag.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.n.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bGI;
    public String bGJ;
    public Object chq;
    public String chr;
    public boolean isSuccess = false;

    public a(String str) {
        this.bGI = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aio() {
        f fVar = new f();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bGI);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.chr);
            if (this.chq != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.chq.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        fVar.mData = jSONObject;
        com.baidu.swan.apps.y.f.aeK().a(this.bGJ, fVar);
        com.baidu.swan.apps.ag.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bGI);
            jSONObject.put("pluginProvider", bVar.chm);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bGJ);
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bGI + "', error=" + this.chq + ", isSuccess=" + this.isSuccess + ", resultData='" + this.chr + "'}";
    }
}
