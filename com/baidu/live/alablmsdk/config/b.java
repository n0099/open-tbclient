package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.config.enums.BLMRtcType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b ayY;
    private volatile boolean ayZ = false;
    private volatile boolean aza = false;
    private Map<String, BLMRtcType> azb = new ConcurrentHashMap();

    private b() {
        initData();
    }

    public static b xQ() {
        if (ayY == null) {
            synchronized (b.class) {
                if (ayY == null) {
                    ayY = new b();
                }
            }
        }
        return ayY;
    }

    public synchronized void eC(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.xs().putString("blm_rtc_config_sp", str);
            if (!this.ayZ) {
                parse(str);
            } else {
                this.aza = true;
            }
        }
    }

    public synchronized void xR() {
        this.ayZ = true;
    }

    public synchronized void xS() {
        this.ayZ = false;
        if (this.aza) {
            initData();
            this.aza = false;
        }
    }

    public synchronized BLMRtcType eP(String str) {
        BLMRtcType bLMRtcType;
        if (TextUtils.isEmpty(str)) {
            bLMRtcType = BLMRtcType.NONE;
        } else if (this.azb.containsKey(str)) {
            bLMRtcType = this.azb.get(str);
        } else {
            bLMRtcType = BLMRtcType.NONE;
        }
        return bLMRtcType;
    }

    private synchronized void initData() {
        parse(d.xs().getString("blm_rtc_config_sp"));
    }

    private void parse(String str) {
        JSONArray optJSONArray;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("rtc_type")) != null && optJSONArray.length() > 0) {
                    this.azb.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("source");
                        String optString2 = jSONObject2.optString("type");
                        if (BLMRtcType.BDRTC.getRtcType().equals(optString2)) {
                            this.azb.put(optString, BLMRtcType.BDRTC);
                        } else if (BLMRtcType.YYRTC.getRtcType().equals(optString2)) {
                            this.azb.put(optString, BLMRtcType.YYRTC);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
