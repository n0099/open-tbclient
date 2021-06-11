package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class DpRTCSession {

    /* renamed from: a  reason: collision with root package name */
    public c f4985a = new c(DpStatConstants.SESSION_TYPE_RTC_COMMON);

    private synchronized JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f4985a.a(jSONObject);
        return jSONObject;
    }

    public static synchronized void uploadSession(int i2, HashMap<String, String> hashMap) {
        synchronized (DpRTCSession.class) {
            if (hashMap != null) {
                if (hashMap.size() > 0) {
                    DpRTCSession dpRTCSession = new DpRTCSession();
                    dpRTCSession.add(i2, hashMap);
                    dpRTCSession.upload();
                }
            }
        }
    }

    public synchronized void add(int i2, String str, String str2) {
        if (20488 == i2) {
            this.f4985a.a(new e((int) DpStatConstants.SESSION_TYPE_RTC_COMMON, str, str2));
        }
    }

    public synchronized void add(int i2, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    add(i2, entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public synchronized String toJson() {
        String jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            a.a().a(jSONObject2);
            jSONObject2.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_RTC);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            a(jSONObject3);
            jSONArray.put(jSONObject3);
            jSONObject2.put("items", jSONArray);
            jSONObject = jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        jSONObject2.remove("cuid");
        CyberLog.i("DpRTCSession", "toJson rtc session = " + jSONObject2.toString());
        return jSONObject;
    }

    public synchronized void upload() {
        DpSessionDatasUploader.getInstance().upload(toJson(), "sailor_monitor");
    }
}
