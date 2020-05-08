package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public int activityId;
    public boolean apN;
    public int apO;
    public long apP;
    public int apQ;
    public int apR;
    public int apS;
    public int apT;
    public long apU;
    public int apV;
    public int apW;
    public long apX;
    public int apY;
    public int apZ;
    public String[] aqa;
    public int aqb;
    public a aqc;
    public b aqd;
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
        this.aqc = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apN = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.apO = jSONObject.optInt("version_and");
            this.apQ = jSONObject.optInt("yule_show");
            this.apR = jSONObject.optInt("yule_game");
            this.apS = jSONObject.optInt("home_status");
            this.apT = jSONObject.optInt("guest_status");
            this.apP = jSONObject.optLong("anchor_user_id");
            this.apW = jSONObject.optInt("sequence_id");
            this.apX = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.apU = jSONObject.optInt("challenge_live");
            this.apV = jSONObject.optInt("normal_live");
            this.apZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.apY = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aqb = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aqa = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aqa[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aqd = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int aqe;
        public double aqf;
        public double aqg;
        public List<String> aqh;
        public List<String> aqi;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aqe = jSONObject.optInt("switch");
            this.aqf = jSONObject.optDouble("guard_club_rate");
            this.aqg = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aqh = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aqh.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aqi = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aqi.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
