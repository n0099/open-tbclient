package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public boolean aHg;
    public int aHh;
    public long aHi;
    public int aHj;
    public int aHk;
    public int aHl;
    public int aHm;
    public long aHn;
    public int aHo;
    public int aHp;
    public long aHq;
    public int aHr;
    public int aHs;
    public String[] aHt;
    public int aHu;
    public a aHv;
    public b aHw;
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

    public void a(a aVar) {
        this.aHv = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHg = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aHh = jSONObject.optInt("version_and");
            this.aHj = jSONObject.optInt("yule_show");
            this.aHk = jSONObject.optInt("yule_game");
            this.aHl = jSONObject.optInt("home_status");
            this.aHm = jSONObject.optInt("guest_status");
            this.aHi = jSONObject.optLong("anchor_user_id");
            this.aHp = jSONObject.optInt("sequence_id");
            this.aHq = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aHn = jSONObject.optInt("challenge_live");
            this.aHo = jSONObject.optInt("normal_live");
            this.aHs = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aHr = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aHu = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aHt = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aHt[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aHw = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public List<String> aHA;
        public List<String> aHB;
        public int aHx;
        public double aHy;
        public double aHz;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aHx = jSONObject.optInt("switch");
            this.aHy = jSONObject.optDouble("guard_club_rate");
            this.aHz = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aHA = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aHA.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aHB = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aHB.add(String.valueOf(optJSONArray2.optLong(i2)));
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
