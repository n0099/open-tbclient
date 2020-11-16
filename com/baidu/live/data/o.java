package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public boolean aGO;
    public int aGP;
    public long aGQ;
    public int aGR;
    public int aGS;
    public int aGT;
    public int aGU;
    public long aGV;
    public int aGW;
    public int aGX;
    public long aGY;
    public int aGZ;
    public int aHa;
    public String[] aHb;
    public int aHc;
    public a aHd;
    public b aHe;
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
        this.aHd = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGO = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aGP = jSONObject.optInt("version_and");
            this.aGR = jSONObject.optInt("yule_show");
            this.aGS = jSONObject.optInt("yule_game");
            this.aGT = jSONObject.optInt("home_status");
            this.aGU = jSONObject.optInt("guest_status");
            this.aGQ = jSONObject.optLong("anchor_user_id");
            this.aGX = jSONObject.optInt("sequence_id");
            this.aGY = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aGV = jSONObject.optInt("challenge_live");
            this.aGW = jSONObject.optInt("normal_live");
            this.aHa = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aGZ = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aHc = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aHb = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aHb[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aHe = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aHf;
        public double aHg;
        public double aHh;
        public List<String> aHi;
        public List<String> aHj;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aHf = jSONObject.optInt("switch");
            this.aHg = jSONObject.optDouble("guard_club_rate");
            this.aHh = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aHi = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aHi.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aHj = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aHj.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
