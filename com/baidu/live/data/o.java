package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public boolean aHH;
    public int aHI;
    public long aHJ;
    public int aHK;
    public int aHL;
    public int aHM;
    public int aHN;
    public long aHO;
    public int aHP;
    public int aHQ;
    public long aHR;
    public int aHS;
    public int aHT;
    public String[] aHU;
    public int aHV;
    public a aHW;
    public b aHX;
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
        this.aHW = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHH = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aHI = jSONObject.optInt("version_and");
            this.aHK = jSONObject.optInt("yule_show");
            this.aHL = jSONObject.optInt("yule_game");
            this.aHM = jSONObject.optInt("home_status");
            this.aHN = jSONObject.optInt("guest_status");
            this.aHJ = jSONObject.optLong("anchor_user_id");
            this.aHQ = jSONObject.optInt("sequence_id");
            this.aHR = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aHO = jSONObject.optInt("challenge_live");
            this.aHP = jSONObject.optInt("normal_live");
            this.aHT = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aHS = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aHV = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aHU = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aHU[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aHX = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aHY;
        public double aHZ;
        public double aIa;
        public List<String> aIb;
        public List<String> aIc;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aHY = jSONObject.optInt("switch");
            this.aHZ = jSONObject.optDouble("guard_club_rate");
            this.aIa = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
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
