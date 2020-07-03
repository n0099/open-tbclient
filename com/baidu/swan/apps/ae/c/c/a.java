package com.baidu.swan.apps.ae.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.w.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bUt;
    public String bUu;
    public String cxA;
    public Object cxz;
    public boolean isSuccess = false;

    public a(String str) {
        this.bUt = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void ana() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bUt);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.cxA);
            if (this.cxz != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.cxz.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.ajb().a(this.bUu, gVar);
        com.baidu.swan.apps.ae.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ae.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bUt);
            jSONObject.put("pluginProvider", bVar.cxv);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bUu);
        } catch (JSONException e) {
            com.baidu.swan.apps.ae.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bUt + "', error=" + this.cxz + ", isSuccess=" + this.isSuccess + ", resultData='" + this.cxA + "'}";
    }
}
