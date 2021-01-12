package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
public class DpRTCSession {

    /* renamed from: a  reason: collision with root package name */
    private c f1825a = new c(DpStatConstants.SESSION_TYPE_RTC_COMMON);

    private synchronized JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f1825a.a(jSONObject);
        return jSONObject;
    }

    public static synchronized void uploadSession(int i, HashMap<String, String> hashMap) {
        synchronized (DpRTCSession.class) {
            if (hashMap != null) {
                if (hashMap.size() > 0) {
                    DpRTCSession dpRTCSession = new DpRTCSession();
                    dpRTCSession.add(i, hashMap);
                    dpRTCSession.upload();
                }
            }
        }
    }

    public synchronized void add(int i, String str, String str2) {
        if (20488 == i) {
            this.f1825a.a(new e((int) DpStatConstants.SESSION_TYPE_RTC_COMMON, str, str2));
        }
    }

    public synchronized void add(int i, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    add(i, entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public synchronized String toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            a.a().a(jSONObject);
            jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_RTC);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            jSONArray.put(jSONObject2);
            jSONObject.put("items", jSONArray);
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        }
        jSONObject.remove("cuid");
        CyberLog.i("DpRTCSession", "toJson rtc session = " + jSONObject.toString());
        return str;
    }

    public synchronized void upload() {
        DpSessionDatasUploader.getInstance().upload(toJson(), DpSessionDatasUploader.SAILOR_MONITOR);
    }
}
