package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public boolean OW;
    public int OX;
    public long OY;
    public int OZ;
    public int Pa;
    public int Pb;
    public int Pc;
    public long Pd;
    public int Pe;
    public int Pf;
    public long Pg;
    public int Ph;
    public int Pi;
    public String[] Pj;
    public int Pk;
    public a Pl;
    public b Pm;
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
            this.OW = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.OX = jSONObject.optInt("version_and");
            this.OZ = jSONObject.optInt("yule_show");
            this.Pa = jSONObject.optInt("yule_game");
            this.Pb = jSONObject.optInt("home_status");
            this.Pc = jSONObject.optInt("guest_status");
            this.OY = jSONObject.optLong("anchor_user_id");
            this.Pf = jSONObject.optInt("sequence_id");
            this.Pg = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.Pd = jSONObject.optInt("challenge_live");
            this.Pe = jSONObject.optInt("normal_live");
            this.Pi = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.Ph = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.Pk = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.Pj = new String[length];
                for (int i = 0; i < length; i++) {
                    this.Pj[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("gift_rate");
            if (optJSONObject != null) {
                this.Pl = new a(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject2 != null) {
                this.Pm = new b(optJSONObject2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public double Pn;
        public double Po;
        public long Pp;
        public List<String> Pq;
        public long endTime;

        a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.Pn = jSONObject.optDouble("guard_club_rate");
            this.Po = jSONObject.optDouble("current_rate");
            this.Pp = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.Pq = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Pq.add(String.valueOf(optJSONArray.optLong(i)));
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
