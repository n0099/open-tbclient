package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public long OA;
    public int OB;
    public int OC;
    public long OD;
    public int OE;
    public int OF;
    public String[] OG;
    public int OH;
    public a OI;
    public b OJ;
    public boolean Ot;
    public int Ou;
    public long Ov;
    public int Ow;
    public int Ox;
    public int Oy;
    public int Oz;
    public int activityId;
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

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Ot = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.Ou = jSONObject.optInt("version_and");
            this.Ow = jSONObject.optInt("yule_show");
            this.Ox = jSONObject.optInt("yule_game");
            this.Oy = jSONObject.optInt("home_status");
            this.Oz = jSONObject.optInt("guest_status");
            this.Ov = jSONObject.optLong("anchor_user_id");
            this.OC = jSONObject.optInt("sequence_id");
            this.OD = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.OA = jSONObject.optInt("challenge_live");
            this.OB = jSONObject.optInt("normal_live");
            this.OF = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.OE = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.OH = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.OG = new String[length];
                for (int i = 0; i < length; i++) {
                    this.OG[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("gift_rate");
            if (optJSONObject != null) {
                this.OI = new a(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject2 != null) {
                this.OJ = new b(optJSONObject2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public double OL;
        public double OM;
        public long OO;
        public List<String> OP;
        public long endTime;

        a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.OL = jSONObject.optDouble("guard_club_rate");
            this.OM = jSONObject.optDouble("current_rate");
            this.OO = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.OP = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.OP.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
