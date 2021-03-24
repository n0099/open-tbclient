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
    public ArrayList<c> f5067a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public c f5068b;

    public b(Context context) {
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(context);
        c cVar = new c(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.f5068b = cVar;
        cVar.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.f5068b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", n.g()));
        this.f5068b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "MODEL", Build.MODEL));
        this.f5068b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "HARDWARE", Build.HARDWARE));
        this.f5068b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsData));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f5068b.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        int size = this.f5067a.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject2 = new JSONObject();
            this.f5067a.get(i).a(jSONObject2);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }

    public static void a(Context context, int i, HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        b bVar = new b(context);
        bVar.a(i, hashMap);
        bVar.a();
    }

    public void a() {
        DpSessionDatasUploader.getInstance().upload(b(), DpSessionDatasUploader.SAILOR_MONITOR);
    }

    public void a(int i, String str, String str2) {
        if (24323 == i) {
            this.f5068b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
            return;
        }
        e eVar = new e(i, str, str2);
        int size = this.f5067a.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.f5067a.get(i2);
            if (cVar != null && cVar.a() == i) {
                cVar.a(eVar);
                return;
            }
        }
        c cVar2 = new c(i);
        cVar2.a(eVar);
        this.f5067a.add(cVar2);
    }

    public void a(int i, HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(i, entry.getKey(), entry.getValue());
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
