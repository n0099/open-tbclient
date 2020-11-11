package com.baidu.live.data;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveMarkData implements Serializable {
    public static final String DEFAULT_ANCHOR_USER_ID = "0";
    public static final int NOBLE_LEVEL_BARON = 2;
    public static final int NOBLE_LEVEL_DUKE = 6;
    public static final int NOBLE_LEVEL_EARL = 4;
    public static final int NOBLE_LEVEL_KING = 7;
    public static final int NOBLE_LEVEL_KNIGHT = 1;
    public static final int NOBLE_LEVEL_MARQUIS = 5;
    public static final String[] NOBLE_LEVEL_NAMES = {"", "骑士", "男爵", "子爵", "伯爵", "侯爵", "公爵", "国王"};
    public static final int NOBLE_LEVEL_NORMAL = 0;
    public static final int NOBLE_LEVEL_VISCOUNT = 3;
    public static final int TYPE_FAN = 6;
    public static final int TYPE_USER_ACHIEVE = 103;
    public static final int TYPE_USER_ADMIN = 2;
    public static final int TYPE_USER_GUARD_CLUB = 102;
    public static final int TYPE_USER_HORNOR = 104;
    public static final int TYPE_USER_LABEL = 3;
    public static final int TYPE_USER_LEVEL = 1;
    public static final int TYPE_USER_NOBLE = 105;
    public static final int TYPE_USER_TB_ACTIVITY = 4;
    public String anchor_user_id;
    public int height;
    public int levelHeight;
    public String levelPic;
    public int levelWidth;
    public String markPicBak;
    public long mark_id;
    public String mark_name;
    public String mark_pic;
    public int royalLevel;
    public int type;
    public int userLevel;
    public int width;
    public boolean isWidthAutoFit = false;
    public int limitedHeight = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.anchor_user_id = jSONObject.optString("anchor_user_id");
            this.mark_id = jSONObject.optLong("mark_id");
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.markPicBak = this.mark_pic;
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.royalLevel = jSONObject.optInt("royal_level");
            this.levelPic = jSONObject.optString("level_pic");
            this.levelWidth = jSONObject.optInt("level_width");
            this.levelHeight = jSONObject.optInt("level_height");
            setupNewLevelMark();
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("anchor_user_id", this.anchor_user_id);
            jSONObject.put("mark_id", this.mark_id);
            jSONObject.put("mark_name", this.mark_name);
            jSONObject.put("mark_pic", this.markPicBak);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            jSONObject.put("royal_level", this.royalLevel);
            jSONObject.put("level_pic", this.levelPic);
            jSONObject.put("level_width", this.levelWidth);
            jSONObject.put("level_height", this.levelHeight);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void setupNewLevelMark() {
        String str;
        if (this.type == 1) {
            if (!TextUtils.isEmpty(this.levelPic)) {
                this.mark_pic = this.levelPic;
                if (this.levelWidth > 0 && this.levelHeight > 0) {
                    this.width = this.levelWidth;
                    this.height = this.levelHeight;
                }
            } else if (com.baidu.live.aa.a.PQ().bod != null && (str = com.baidu.live.aa.a.PQ().bod.aNC.get(Integer.valueOf(this.userLevel))) != null) {
                this.mark_pic = str;
                this.height = 48;
                if (this.userLevel <= 9) {
                    this.width = 78;
                } else if (this.userLevel <= 19) {
                    this.width = 93;
                } else {
                    this.width = 96;
                }
            }
        }
    }
}
