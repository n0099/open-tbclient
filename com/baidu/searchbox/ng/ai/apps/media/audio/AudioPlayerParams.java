package com.baidu.searchbox.ng.ai.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioPlayerParams {
    protected static final boolean DEBUG = false;
    private static final String KEY_AUTO_PLAY = "autoplay";
    private static final String KEY_CALLBACKS = "cb";
    private static final String KEY_LOOP = "loop";
    private static final String KEY_OBEY_MUTE = "obeyMuteSwitch";
    public static final String KEY_PLAYER_ID = "audioId";
    private static final String KEY_POS = "position";
    private static final String KEY_SLAVE_ID = "slaveId";
    private static final String KEY_SRC = "src";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_VOLUME = "volume";
    protected static final String TAG = "AudioPlayerParams";
    String mCallbacks;
    public String mPlayerId = "";
    public String mSlaveId = "";
    public String mUrl = "";
    public int mStartTime = 0;
    public boolean mAutoPlay = false;
    public boolean mLoop = false;
    boolean mObeyMute = true;
    public int mPos = 0;
    float mVolume = 1.0f;

    public static AudioPlayerParams createFromJSON(JSONObject jSONObject, AudioPlayerParams audioPlayerParams) {
        AudioPlayerParams audioPlayerParams2 = new AudioPlayerParams();
        if (jSONObject != null) {
            audioPlayerParams2.mPlayerId = jSONObject.optString("audioId", audioPlayerParams.mPlayerId);
            audioPlayerParams2.mSlaveId = jSONObject.optString("slaveId", audioPlayerParams.mSlaveId);
            String optString = jSONObject.optString("src", audioPlayerParams.mUrl);
            AiApp aiApp = AiApp.get();
            if (aiApp != null) {
                audioPlayerParams2.mUrl = StorageUtil.obtainPathFromScheme(optString, aiApp);
            } else {
                audioPlayerParams2.mUrl = optString;
            }
            audioPlayerParams2.mAutoPlay = jSONObject.optBoolean(KEY_AUTO_PLAY, audioPlayerParams.mAutoPlay);
            audioPlayerParams2.mLoop = jSONObject.optBoolean(KEY_LOOP, audioPlayerParams.mLoop);
            audioPlayerParams2.mStartTime = jSONObject.optInt(KEY_START_TIME, audioPlayerParams.mStartTime);
            audioPlayerParams2.mObeyMute = jSONObject.optBoolean(KEY_OBEY_MUTE, audioPlayerParams.mObeyMute);
            audioPlayerParams2.mPos = jSONObject.optInt("position", audioPlayerParams.mPos);
            audioPlayerParams2.mVolume = (float) jSONObject.optDouble(KEY_VOLUME, audioPlayerParams.mVolume);
            audioPlayerParams2.mCallbacks = jSONObject.optString("cb", audioPlayerParams.mCallbacks);
        }
        return audioPlayerParams2;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId);
    }

    public String toString() {
        return "playerId : " + this.mPlayerId + "; slaveId : " + this.mSlaveId + "; url : " + this.mUrl + "; AutoPlay : " + this.mAutoPlay + "; Loop : " + this.mLoop + "; startTime : " + this.mStartTime + "; ObeyMute : " + this.mObeyMute + "; pos : " + this.mPos;
    }
}
