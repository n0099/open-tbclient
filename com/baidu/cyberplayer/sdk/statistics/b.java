package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.os.Build;
import com.baidu.cyberplayer.sdk.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f5232a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public c f5233b;

    public b(Context context) {
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(context);
        c cVar = new c(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.f5233b = cVar;
        cVar.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.f5233b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", n.g()));
        this.f5233b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "MODEL", Build.MODEL));
        this.f5233b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "HARDWARE", Build.HARDWARE));
        this.f5233b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsData));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f5233b.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        int size = this.f5232a.size();
        for (int i2 = 0; i2 < size; i2++) {
            JSONObject jSONObject2 = new JSONObject();
            this.f5232a.get(i2).a(jSONObject2);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }

    public static void a(Context context, int i2, HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        b bVar = new b(context);
        bVar.a(i2, hashMap);
        bVar.a();
    }

    public void a() {
        DpSessionDatasUploader.getInstance().upload(b(), DpSessionDatasUploader.SAILOR_MONITOR);
    }

    public void a(int i2, String str, String str2) {
        if (24323 == i2) {
            this.f5233b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
            return;
        }
        e eVar = new e(i2, str, str2);
        int size = this.f5232a.size();
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = this.f5232a.get(i3);
            if (cVar != null && cVar.a() == i2) {
                cVar.a(eVar);
                return;
            }
        }
        c cVar2 = new c(i2);
        cVar2.a(eVar);
        this.f5232a.add(cVar2);
    }

    public void a(int i2, HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(i2, entry.getKey(), entry.getValue());
        }
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            a.a().a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            jSONArray.put(jSONObject2);
            jSONObject.put("items", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
