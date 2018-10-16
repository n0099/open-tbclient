package com.baidu.searchbox.ng.ai.apps.media.audio;

import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AudioBGPlayerParams {
    protected static final boolean DEBUG = false;
    private static final String KEY_CALLBACKS = "cb";
    private static final String KEY_COVER_URL = "coverImgUrl";
    private static final String KEY_EPNAME = "epname";
    private static final String KEY_GET_PARAM = "param";
    private static final String KEY_IS_LOCAL = "isLocal";
    public static final String KEY_PLAYER_ID = "audioId";
    private static final String KEY_POS = "position";
    private static final String KEY_SINGER = "singer";
    private static final String KEY_SLAVE_ID = "slaveId";
    private static final String KEY_SRC = "src";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_TITLE = "title";
    protected static final String TAG = "AudioPlayerParams";
    String mCallbacks;
    public String mPlayerId = "";
    public String mSlaveId = "";
    public String mUrl = "";
    public String mTitle = "";
    public String mEpName = "";
    public String mSinger = "";
    public String mCoverUrl = "";
    public int mStartTime = 0;
    public int mPos = 0;
    public String mGetParam = "";
    public boolean isLocalMedia = false;

    public static AudioBGPlayerParams createFromJSON(JSONObject jSONObject, AudioBGPlayerParams audioBGPlayerParams) {
        AudioBGPlayerParams audioBGPlayerParams2 = new AudioBGPlayerParams();
        if (jSONObject != null) {
            audioBGPlayerParams2.mPlayerId = jSONObject.optString("audioId", audioBGPlayerParams.mPlayerId);
            audioBGPlayerParams2.mSlaveId = jSONObject.optString("slaveId", audioBGPlayerParams.mSlaveId);
            String optString = jSONObject.optString("src", audioBGPlayerParams.mUrl);
            AiApp aiApp = AiApp.get();
            if (StorageUtil.isLocalFileScheme(optString) && aiApp != null) {
                audioBGPlayerParams2.mUrl = StorageUtil.obtainPathFromScheme(optString, aiApp);
                audioBGPlayerParams2.isLocalMedia = true;
            } else {
                audioBGPlayerParams2.mUrl = optString;
                audioBGPlayerParams2.isLocalMedia = false;
            }
            audioBGPlayerParams2.mTitle = jSONObject.optString("title", audioBGPlayerParams.mTitle);
            audioBGPlayerParams2.mEpName = jSONObject.optString(KEY_EPNAME, audioBGPlayerParams.mEpName);
            audioBGPlayerParams2.mSinger = jSONObject.optString(KEY_SINGER, audioBGPlayerParams.mSinger);
            audioBGPlayerParams2.mCoverUrl = jSONObject.optString(KEY_COVER_URL, audioBGPlayerParams.mCoverUrl);
            audioBGPlayerParams2.mStartTime = jSONObject.optInt(KEY_START_TIME, audioBGPlayerParams.mStartTime);
            audioBGPlayerParams2.mPos = jSONObject.optInt("position", audioBGPlayerParams.mPos);
            audioBGPlayerParams2.mCallbacks = jSONObject.optString("cb", audioBGPlayerParams.mCallbacks);
            audioBGPlayerParams2.mGetParam = jSONObject.optString(KEY_GET_PARAM, audioBGPlayerParams.mGetParam);
        }
        return audioBGPlayerParams2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toSongString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("src", this.mUrl);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt(KEY_EPNAME, this.mEpName);
            jSONObject.putOpt(KEY_SINGER, this.mSinger);
            jSONObject.putOpt(KEY_COVER_URL, this.mCoverUrl);
            jSONObject.putOpt(KEY_IS_LOCAL, Boolean.valueOf(this.isLocalMedia));
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.mPlayerId + "; slaveId : " + this.mSlaveId + "; url : " + this.mUrl + "; startTime : " + this.mStartTime + "; pos : " + this.mPos;
    }
}
