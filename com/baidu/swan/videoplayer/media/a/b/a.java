package com.baidu.swan.videoplayer.media.a.b;

import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    public int dsn;
    public int dso;
    public int mAudioBitrate;
    public int mVideoBitrate;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("videoBitrate", this.mVideoBitrate);
            jSONObject.put("audioBitrate", this.mAudioBitrate);
            jSONObject.put("videoFPS", this.dsn);
            jSONObject.put("netSpeed", this.dso);
            jSONObject.put("videoWidth", this.mVideoWidth);
            jSONObject.put("videoHeight", this.mVideoHeight);
            jSONObject2.putOpt("info", jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e));
            }
            return null;
        }
    }
}
