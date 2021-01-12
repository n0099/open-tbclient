package com.baidu.swan.apps.ac.c.c;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.event.a.g;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String cJc;
    public String cJd;
    public Object dqn;
    public String dqo;
    public boolean isSuccess = false;

    public a(String str) {
        this.cJc = str;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject, T] */
    public void aEu() {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "functionPageFinished");
            jSONObject.put("componentId", this.cJc);
            jSONObject.put("isSuccess", this.isSuccess);
            jSONObject.put("data", this.dqo);
            if (this.dqn != null) {
                jSONObject.put(BdStatsConstant.StatsType.ERROR, this.dqn.toString());
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        gVar.mData = jSONObject;
        f.azN().a(this.cJd, gVar);
        com.baidu.swan.apps.ac.d.a.print("finish event, isSuccess = " + this.isSuccess);
    }

    public static String a(com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("componentId", bVar.cJc);
            jSONObject.put("pluginProvider", bVar.dqj);
            jSONObject.put("args", bVar.pageParams);
            jSONObject.put("slaveId", bVar.cJd);
        } catch (JSONException e) {
            com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "SwanPluginFunPageFinishEvent{eventType='functionPageFinished', componentId='" + this.cJc + "', error=" + this.dqn + ", isSuccess=" + this.isSuccess + ", resultData='" + this.dqo + "'}";
    }
}
