package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.config.enums.BLMRtcType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b axy;
    private volatile boolean axz = false;
    private volatile boolean axA = false;
    private Map<String, BLMRtcType> axB = new ConcurrentHashMap();

    private b() {
        initData();
    }

    public static b xN() {
        if (axy == null) {
            synchronized (b.class) {
                if (axy == null) {
                    axy = new b();
                }
            }
        }
        return axy;
    }

    public synchronized void ev(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.xp().putString("blm_rtc_config_sp", str);
            if (!this.axz) {
                parse(str);
            } else {
                this.axA = true;
            }
        }
    }

    public synchronized void xO() {
        this.axz = true;
    }

    public synchronized void xP() {
        this.axz = false;
        if (this.axA) {
            initData();
            this.axA = false;
        }
    }

    public synchronized BLMRtcType eJ(String str) {
        BLMRtcType bLMRtcType;
        if (TextUtils.isEmpty(str)) {
            bLMRtcType = BLMRtcType.NONE;
        } else if (this.axB.containsKey(str)) {
            bLMRtcType = this.axB.get(str);
        } else {
            bLMRtcType = BLMRtcType.NONE;
        }
        return bLMRtcType;
    }

    private synchronized void initData() {
        parse(d.xp().getString("blm_rtc_config_sp"));
    }

    private void parse(String str) {
        JSONArray optJSONArray;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("rtc_type")) != null && optJSONArray.length() > 0) {
                    this.axB.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("source");
                        String optString2 = jSONObject2.optString("type");
                        if (BLMRtcType.BDRTC.getRtcType().equals(optString2)) {
                            this.axB.put(optString, BLMRtcType.BDRTC);
                        } else if (BLMRtcType.YYRTC.getRtcType().equals(optString2)) {
                            this.axB.put(optString, BLMRtcType.YYRTC);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
