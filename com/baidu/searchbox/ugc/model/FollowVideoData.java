package com.baidu.searchbox.ugc.model;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class FollowVideoData implements Serializable {
    public static final int SRC_FOLLOW_VIDEO = 1;
    public static final int SRC_MUSIC = 2;
    public static final int SRC_ORIGIN = 3;
    public String mAuthorAvatar;
    public String mAuthorUK;
    public String mBgSound;
    public String mBgSoundRec;
    public String mMusicName = "";
    public String mFollowMusicName = "";
    public int mSoundSrc = 1;

    public void parseFromString(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.mAuthorUK = jSONObject.optString("author_uk", "");
                this.mAuthorAvatar = jSONObject.optString("author_avatar", "");
                this.mMusicName = jSONObject.optString("music_name", "");
                this.mFollowMusicName = jSONObject.optString("follow_music_name", "");
                this.mBgSound = jSONObject.optString("bg_sound", "");
                this.mBgSoundRec = jSONObject.optString("bg_sound_rec", "");
                this.mSoundSrc = jSONObject.optInt("sound_src", TextUtils.isEmpty(this.mAuthorUK) ? 3 : 1);
            } else {
                this.mAuthorUK = "";
                this.mAuthorAvatar = "";
                this.mMusicName = "";
                this.mBgSound = "";
                this.mBgSoundRec = "";
                this.mSoundSrc = 3;
            }
        } catch (JSONException e) {
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("author_uk", this.mAuthorUK);
            jSONObject.put("author_avatar", this.mAuthorAvatar);
            jSONObject.put("music_name", this.mMusicName);
            jSONObject.put("follow_music_name", this.mFollowMusicName);
            jSONObject.put("bg_sound", this.mBgSound);
            jSONObject.put("bg_sound_rec", this.mBgSoundRec);
            jSONObject.put("sound_src", this.mSoundSrc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
