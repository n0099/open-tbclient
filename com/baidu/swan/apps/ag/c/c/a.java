package com.baidu.swan.apps.ag.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.n.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public Object bIu;
    public String bIv;
    public String bik;
    public String bil;
    public boolean isSuccess = false;

    public a(String str) {
        this.bik = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aae() {
        f fVar = new f();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.bik);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.bIv);
            if (this.bIu != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.bIu.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        fVar.mData = jSONObject;
        com.baidu.swan.apps.y.f.WQ().a(this.bil, fVar);
        com.baidu.swan.apps.ag.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.bik);
            jSONObject.put("pluginProvider", bVar.bIq);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.bil);
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.bik + "', error=" + this.bIu + ", isSuccess=" + this.isSuccess + ", resultData='" + this.bIv + "'}";
    }
}
