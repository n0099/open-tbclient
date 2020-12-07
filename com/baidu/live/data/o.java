package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public long aJA;
    public int aJB;
    public int aJC;
    public int aJD;
    public int aJE;
    public long aJF;
    public int aJG;
    public int aJH;
    public long aJI;
    public int aJJ;
    public int aJK;
    public String[] aJL;
    public int aJM;
    public a aJN;
    public b aJO;
    public boolean aJy;
    public int aJz;
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
        this.aJN = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJy = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aJz = jSONObject.optInt("version_and");
            this.aJB = jSONObject.optInt("yule_show");
            this.aJC = jSONObject.optInt("yule_game");
            this.aJD = jSONObject.optInt("home_status");
            this.aJE = jSONObject.optInt("guest_status");
            this.aJA = jSONObject.optLong("anchor_user_id");
            this.aJH = jSONObject.optInt("sequence_id");
            this.aJI = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aJF = jSONObject.optInt("challenge_live");
            this.aJG = jSONObject.optInt("normal_live");
            this.aJK = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aJJ = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aJM = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aJL = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aJL[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aJO = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aJP;
        public double aJQ;
        public double aJR;
        public long aJS;
        public List<String> aJT;
        public List<String> aJU;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aJP = jSONObject.optInt("switch");
            this.aJQ = jSONObject.optDouble("guard_club_rate");
            this.aJR = jSONObject.optDouble("current_rate");
            this.aJS = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aJT = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aJT.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aJU = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aJU.add(String.valueOf(optJSONArray2.optLong(i2)));
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
