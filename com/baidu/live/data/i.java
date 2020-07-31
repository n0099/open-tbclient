package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int activityId;
    public boolean ayf;
    public int ayg;
    public long ayh;
    public int ayi;
    public int ayj;
    public int ayk;
    public int ayl;
    public long aym;
    public int ayn;
    public int ayo;
    public long ayp;
    public int ayq;
    public int ayr;
    public String[] ays;
    public int ayt;
    public a ayu;
    public b ayv;
    public long begin_time;
    public long end_time;
    public String jump_url;
    public int picType;
    public String pic_url;
    public int pos;
    public int position;
    public long serverTime;
    public long showTime;
    public int type;
    public String webUrl;

    public void a(a aVar) {
        this.ayu = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayf = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.ayg = jSONObject.optInt("version_and");
            this.ayi = jSONObject.optInt("yule_show");
            this.ayj = jSONObject.optInt("yule_game");
            this.ayk = jSONObject.optInt("home_status");
            this.ayl = jSONObject.optInt("guest_status");
            this.ayh = jSONObject.optLong("anchor_user_id");
            this.ayo = jSONObject.optInt("sequence_id");
            this.ayp = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aym = jSONObject.optInt("challenge_live");
            this.ayn = jSONObject.optInt("normal_live");
            this.ayr = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.ayq = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.ayt = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.ays = new String[length];
                for (int i = 0; i < length; i++) {
                    this.ays[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.ayv = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public List<String> ayA;
        public int ayw;
        public double ayx;
        public double ayy;
        public List<String> ayz;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.ayw = jSONObject.optInt("switch");
            this.ayx = jSONObject.optDouble("guard_club_rate");
            this.ayy = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.ayz = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ayz.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.ayA = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.ayA.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public int height;
        public int pos;
        public int width;

        b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.pos = jSONObject.optInt("pos");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
        }
    }
}
