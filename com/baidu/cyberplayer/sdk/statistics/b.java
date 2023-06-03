package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public ArrayList<c> a = new ArrayList<>();
    public c b;

    public b(Context context) {
        String networkStatisticsNoOperator = DpNetworkUtils.getNetworkStatisticsNoOperator(context);
        c cVar = new c(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.b = cVar;
        cVar.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", q.g()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsNoOperator));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        this.b.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject2 = new JSONObject();
            this.a.get(i).a(jSONObject2);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }

    public static void a(Context context, int i, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            b bVar = new b(context);
            bVar.a(i, hashMap);
            bVar.a();
            if (!hashMap.containsKey("errorCode") && hashMap.get("loadcode").equals("0")) {
                CyberLog.y(DpStatConstants.SERVER_TYPE_DUPLAYER_INIT, "Install Success");
            } else {
                CyberLog.y(DpStatConstants.SERVER_TYPE_DUPLAYER_INIT, bVar.c());
            }
        }
    }

    public void a() {
        DpSessionDatasUploader.getInstance().uploadLibInitSession(b(), "sailor_monitor");
        if (CyberCfgManager.getInstance().getCfgBoolValue("init_session_ubc", true)) {
            UbcSessionUploader.getInstance().upload(c(), "ubc", -1010);
        }
        if (CyberCfgManager.getInstance().getCfgBoolValue("cyber_down_init_session_ubcid", true) && CyberVersion.isLaterDownCyber()) {
            UbcSessionUploader.getInstance().upload(c(), "ubc", -1012);
        }
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            a.a().a(jSONObject);
            jSONObject.put(DpStatConstants.KEY_CORE_VERSION, CyberVersion.getCoreVersionInternal());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            jSONArray.put(jSONObject2);
            jSONObject.put("items", jSONArray);
            String jSONObject3 = jSONObject.toString();
            jSONObject.remove("cuid");
            CyberLog.i("DpLibsInitSession", "session=" + jSONObject.toString());
            return jSONObject3;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            a.a().a(jSONObject);
            jSONObject.remove("abtest_sid");
            jSONObject.remove("app_name");
            jSONObject.remove("app_version");
            jSONObject.remove("cuid");
            jSONObject.remove("network");
            jSONObject.put(DpStatConstants.KEY_CORE_VERSION, CyberVersion.getCoreVersionInternal());
            a(jSONObject);
            jSONObject2.put("items", jSONObject);
            jSONObject3.put("ext", jSONObject2);
            jSONObject3.put("from", "cyber");
            jSONObject3.put("page", "vod");
            return jSONObject3.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(int i, String str, String str2) {
        if (24323 == i) {
            this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
            return;
        }
        e eVar = new e(i, str, str2);
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.a.get(i2);
            if (cVar != null && cVar.a() == i) {
                cVar.a(eVar);
                return;
            }
        }
        c cVar2 = new c(i);
        cVar2.a(eVar);
        this.a.add(cVar2);
    }

    public void a(int i, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                a(i, entry.getKey(), entry.getValue());
            }
        }
    }
}
