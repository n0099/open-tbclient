package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cNO;
    public String cNP;
    public Object dvc;
    public String dvd;
    public boolean isSuccess = false;

    public a(String str) {
        this.cNO = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aIo() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cNO);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.dvd);
            if (this.dvc != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dvc.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.aDH().a(this.cNP, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cNO);
            jSONObject.put("pluginProvider", bVar.duY);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cNP);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cNO + "', error=" + this.dvc + ", isSuccess=" + this.isSuccess + ", resultData='" + this.dvd + "'}";
    }
}
