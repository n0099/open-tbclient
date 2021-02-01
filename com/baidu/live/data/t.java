package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class t {
    public boolean aHG;
    public int aHH;
    public long aHI;
    public int aHJ;
    public int aHK;
    public int aHL;
    public int aHM;
    public long aHN;
    public int aHO;
    public int aHP;
    public long aHQ;
    public int aHR;
    public int aHS;
    public String[] aHT;
    public int aHU;
    public a aHV;
    public b aHW;
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
        this.aHV = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHG = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aHH = jSONObject.optInt("version_and");
            this.aHJ = jSONObject.optInt("yule_show");
            this.aHK = jSONObject.optInt("yule_game");
            this.aHL = jSONObject.optInt("home_status");
            this.aHM = jSONObject.optInt("guest_status");
            this.aHI = jSONObject.optLong("anchor_user_id");
            this.aHP = jSONObject.optInt("sequence_id");
            this.aHQ = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aHN = jSONObject.optInt("challenge_live");
            this.aHO = jSONObject.optInt("normal_live");
            this.aHS = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aHR = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aHU = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aHT = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aHT[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aHW = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int aHX;
        public double aHY;
        public double aHZ;
        public long aIa;
        public List<String> aIb;
        public List<String> aIc;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aHX = jSONObject.optInt("switch");
            this.aHY = jSONObject.optDouble("guard_club_rate");
            this.aHZ = jSONObject.optDouble("current_rate");
            this.aIa = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aIb = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aIb.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aIc = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aIc.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public int height;
        public int pos;
        public int width;

        public b() {
        }

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
