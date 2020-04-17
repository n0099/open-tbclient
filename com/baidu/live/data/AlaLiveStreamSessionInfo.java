package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveStreamSessionInfo implements Serializable {
    public static final String STREAM_LEVEL_DEFAULT = "L0";
    public static final String STREAM_LEVEL_HIGH = "L3";
    public static final String STREAM_LEVEL_LOW = "L1";
    public static final String STREAM_LEVEL_MEDIUM = "L2";
    public static final String STREAM_LEVEL_SUPER_HIGH = "L4";
    private static al iReplaceUrl;
    public String defaultLine;
    public String flvUrl;
    public String hlsUrl;
    public Map<String, AlaLiveStreamSessionLine> mLines;
    public String mSessionId;
    private String pushUrl;
    public String rtmpUrl;

    /* loaded from: classes3.dex */
    public static class AlaLiveStreamSessionLine implements Serializable {
        public String flvUrl;
        public String hslUrl;
        public String pushUrl;
        public String rtmpUrl;
    }

    private AlaLiveStreamSessionLine parseSessionLine(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AlaLiveStreamSessionLine alaLiveStreamSessionLine = new AlaLiveStreamSessionLine();
        alaLiveStreamSessionLine.rtmpUrl = jSONObject.optString("rtmpUrl");
        alaLiveStreamSessionLine.hslUrl = jSONObject.optString("hlsUrl");
        alaLiveStreamSessionLine.pushUrl = jSONObject.optString("pushUrl");
        alaLiveStreamSessionLine.flvUrl = jSONObject.optString("flvUrl");
        return alaLiveStreamSessionLine;
    }

    private static JSONObject sessionLineToJson(AlaLiveStreamSessionLine alaLiveStreamSessionLine) {
        JSONObject jSONObject = new JSONObject();
        if (alaLiveStreamSessionLine == null) {
            return null;
        }
        try {
            jSONObject.put("rtmpUrl", alaLiveStreamSessionLine.rtmpUrl);
            jSONObject.put("hlsUrl", alaLiveStreamSessionLine.hslUrl);
            jSONObject.put("pushUrl", alaLiveStreamSessionLine.pushUrl);
            jSONObject.put("flvUrl", alaLiveStreamSessionLine.flvUrl);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AlaLiveStreamSessionInfo() {
    }

    public AlaLiveStreamSessionInfo(AlaLiveStreamSessionInfo alaLiveStreamSessionInfo) {
        if (alaLiveStreamSessionInfo != null) {
            this.rtmpUrl = alaLiveStreamSessionInfo.rtmpUrl;
            this.hlsUrl = alaLiveStreamSessionInfo.hlsUrl;
            this.pushUrl = alaLiveStreamSessionInfo.pushUrl;
            this.flvUrl = alaLiveStreamSessionInfo.flvUrl;
            this.defaultLine = alaLiveStreamSessionInfo.defaultLine;
            this.mSessionId = alaLiveStreamSessionInfo.mSessionId;
            if (alaLiveStreamSessionInfo.mLines != null && alaLiveStreamSessionInfo.mLines.size() > 0) {
                this.mLines = new HashMap(alaLiveStreamSessionInfo.mLines);
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.rtmpUrl = jSONObject.optString("rtmpUrl");
            this.hlsUrl = jSONObject.optString("hlsUrl");
            this.pushUrl = jSONObject.optString("pushUrl");
            this.flvUrl = jSONObject.optString("flvUrl");
            this.defaultLine = jSONObject.optString("default_line", STREAM_LEVEL_LOW);
            this.mSessionId = jSONObject.optString("sessionId");
            this.mLines = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject(STREAM_LEVEL_LOW);
            if (optJSONObject != null) {
                AlaLiveStreamSessionLine parseSessionLine = parseSessionLine(optJSONObject);
                if (!TextUtils.isEmpty(this.rtmpUrl) && parseSessionLine != null && this.rtmpUrl.equals(parseSessionLine.rtmpUrl)) {
                    this.defaultLine = STREAM_LEVEL_LOW;
                }
                this.mLines.put(STREAM_LEVEL_LOW, parseSessionLine(optJSONObject));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(STREAM_LEVEL_MEDIUM);
            if (optJSONObject != null) {
                AlaLiveStreamSessionLine parseSessionLine2 = parseSessionLine(optJSONObject);
                if (!TextUtils.isEmpty(this.rtmpUrl) && parseSessionLine2 != null && this.rtmpUrl.equals(parseSessionLine2.rtmpUrl)) {
                    this.defaultLine = STREAM_LEVEL_LOW;
                }
                this.mLines.put(STREAM_LEVEL_MEDIUM, parseSessionLine(optJSONObject2));
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(STREAM_LEVEL_HIGH);
            if (optJSONObject != null) {
                AlaLiveStreamSessionLine parseSessionLine3 = parseSessionLine(optJSONObject);
                if (!TextUtils.isEmpty(this.rtmpUrl) && parseSessionLine3 != null && this.rtmpUrl.equals(parseSessionLine3.rtmpUrl)) {
                    this.defaultLine = STREAM_LEVEL_LOW;
                }
                this.mLines.put(STREAM_LEVEL_HIGH, parseSessionLine(optJSONObject3));
            }
        }
    }

    public String getFlvUrl(String str) {
        String str2;
        AlaLiveStreamSessionLine sessionLine = getSessionLine(str);
        if (sessionLine == null) {
            str2 = this.flvUrl;
        } else {
            str2 = sessionLine.flvUrl;
        }
        if (iReplaceUrl != null) {
            return iReplaceUrl.replaceFlvUrl(str2);
        }
        return str2;
    }

    public String getRtmpUrl(String str) {
        String str2;
        AlaLiveStreamSessionLine sessionLine = getSessionLine(str);
        if (sessionLine == null) {
            str2 = this.rtmpUrl;
        } else {
            str2 = sessionLine.rtmpUrl;
        }
        if (iReplaceUrl != null) {
            return iReplaceUrl.replaceRtmpUrl(str2);
        }
        return str2;
    }

    public String getHslUrl(String str) {
        String str2;
        AlaLiveStreamSessionLine sessionLine = getSessionLine(str);
        if (sessionLine == null) {
            str2 = this.hlsUrl;
        } else {
            str2 = sessionLine.hslUrl;
        }
        if (iReplaceUrl != null) {
            return iReplaceUrl.replaceHslUrl(str2);
        }
        return str2;
    }

    public AlaLiveStreamSessionLine getSessionLine(String str) {
        if (TextUtils.isEmpty(str) || this.mLines == null) {
            return null;
        }
        return this.mLines.get(str);
    }

    public int getLineCount() {
        if (this.mLines == null) {
            return 0;
        }
        return this.mLines.size();
    }

    public static JSONObject toJson(AlaLiveStreamSessionInfo alaLiveStreamSessionInfo) {
        if (alaLiveStreamSessionInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rtmpUrl", alaLiveStreamSessionInfo.rtmpUrl);
                jSONObject.put("hlsUrl", alaLiveStreamSessionInfo.hlsUrl);
                jSONObject.put("pushUrl", alaLiveStreamSessionInfo.getPushUrl());
                jSONObject.put("flvUrl", alaLiveStreamSessionInfo.flvUrl);
                jSONObject.put("default_line", alaLiveStreamSessionInfo.defaultLine);
                jSONObject.put("sessionId", alaLiveStreamSessionInfo.mSessionId);
                if (alaLiveStreamSessionInfo.mLines != null) {
                    Iterator<String> it = alaLiveStreamSessionInfo.mLines.keySet().iterator();
                    while (it.hasNext()) {
                        jSONObject.put(it.next(), sessionLineToJson(alaLiveStreamSessionInfo.mLines.get(it.next())));
                    }
                }
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String streamLevelKeyToName(String str) {
        if (STREAM_LEVEL_LOW.equals(str)) {
            return TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_live_play_level_low);
        }
        if (STREAM_LEVEL_MEDIUM.equals(str)) {
            return TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_live_play_level_medium);
        }
        if (STREAM_LEVEL_HIGH.equals(str)) {
            return TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_live_play_level_high);
        }
        if (STREAM_LEVEL_SUPER_HIGH.equals(str)) {
            return TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_live_play_level_super_high);
        }
        return null;
    }

    public String getPushUrl() {
        return iReplaceUrl != null ? iReplaceUrl.replacePushUrl(this.pushUrl) : this.pushUrl;
    }

    public static al getIReplaceUrl() {
        return iReplaceUrl;
    }

    public static void setIReplaceUrl(al alVar) {
        iReplaceUrl = alVar;
    }
}
