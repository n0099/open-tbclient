package com.baidu.live.tbadk.ala;

import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLastLiveroomInfo {
    public static final String KEY_LAST_ANCHOR_ID = "key_last_anchor_id";
    public static final String KEY_LAST_ANCHOR_NAME = "key_last_anchor_name";
    public static final String KEY_LAST_ANCHOR_PORTRAIT = "key_last_anchor_portrait";
    public static final String KEY_LAST_FROM = "key_last_from";
    public static final String KEY_LAST_LIVE_ID = "key_last_live_id";
    public static final String KEY_LAST_ROOM_ID = "key_last_room_id";
    public static final String TYPE_FROM_BROADCAST = "type_from_broadcast";
    public static final String TYPE_FROM_GUARD_RANK = "type_from_guard_rank";
    public static final String TYPE_FROM_HALF_WEBVIEW = "type_from_half_webview";
    public static final String TYPE_FROM_HOUR_RANK = "type_from_hour_rank";
    public static final String TYPE_FROM_RECOMMEND = "type_from_recommend";
    private String mFrom;
    private String mLastAnchorPortrait;
    private String mLastAnchorUid;
    private String mLastAnchorUname;
    private long mLastLiveId;
    private long mLastRoomId;

    public long getLastLiveId() {
        return this.mLastLiveId;
    }

    public void setLastLiveId(long j) {
        this.mLastLiveId = j;
    }

    public long getLastRoomId() {
        return this.mLastRoomId;
    }

    public void setLastRoomId(long j) {
        this.mLastRoomId = j;
    }

    public String getLastAnchorUid() {
        return this.mLastAnchorUid;
    }

    public void setLastAnchorUid(String str) {
        this.mLastAnchorUid = str;
    }

    public String getLastAnchorUname() {
        return this.mLastAnchorUname;
    }

    public void setLastAnchorUname(String str) {
        this.mLastAnchorUname = str;
    }

    public String getLastAnchorPortrait() {
        return this.mLastAnchorPortrait;
    }

    public void setLastAnchorPortrait(String str) {
        this.mLastAnchorPortrait = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_LAST_LIVE_ID, this.mLastLiveId);
            jSONObject.put(KEY_LAST_ROOM_ID, this.mLastRoomId);
            jSONObject.put(KEY_LAST_FROM, this.mFrom);
            jSONObject.put(KEY_LAST_ANCHOR_ID, this.mLastAnchorUid);
            jSONObject.put(KEY_LAST_ANCHOR_NAME, this.mLastAnchorUname);
            jSONObject.put(KEY_LAST_ANCHOR_PORTRAIT, this.mLastAnchorPortrait);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mLastLiveId = jSONObject.optLong(KEY_LAST_LIVE_ID);
                this.mLastRoomId = jSONObject.optLong(KEY_LAST_ROOM_ID);
                this.mFrom = jSONObject.optString(KEY_LAST_FROM);
                this.mLastAnchorUid = jSONObject.optString(KEY_LAST_ANCHOR_ID);
                this.mLastAnchorUname = jSONObject.optString(KEY_LAST_ANCHOR_NAME);
                this.mLastAnchorPortrait = jSONObject.optString(KEY_LAST_ANCHOR_PORTRAIT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
