package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class DpRTCSession {
    public static final String TAG = "DpRTCSession";
    public DpStatDataList mCommonDataList = new DpStatDataList(20488);

    public synchronized void upload() {
        DpSessionDatasUploader.getInstance().upload(toJson(), "sailor_monitor");
    }

    private synchronized JSONObject toJson(JSONObject jSONObject) throws JSONException {
        this.mCommonDataList.toJson(jSONObject);
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

    public synchronized void add(int i, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    add(i, entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public synchronized void add(int i, String str, String str2) {
        if (20488 == i) {
            this.mCommonDataList.add(new DpStatItem(20488, str, str2));
        }
    }

    public synchronized String toJson() {
        String jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            DpInitKernelSession.getInstance().toJson(jSONObject2);
            jSONObject2.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_RTC);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            toJson(jSONObject3);
            jSONArray.put(jSONObject3);
            jSONObject2.put("items", jSONArray);
            jSONObject = jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jSONObject2.remove("cuid");
        CyberLog.i(TAG, "toJson rtc session = " + jSONObject2.toString());
        return jSONObject;
    }
}
