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
    public boolean apH;
    public int apI;
    public long apJ;
    public int apK;
    public int apL;
    public int apM;
    public int apN;
    public long apO;
    public int apP;
    public int apQ;
    public long apR;
    public int apS;
    public int apT;
    public String[] apU;
    public int apV;
    public a apW;
    public b apX;
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
        this.apW = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apH = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.apI = jSONObject.optInt("version_and");
            this.apK = jSONObject.optInt("yule_show");
            this.apL = jSONObject.optInt("yule_game");
            this.apM = jSONObject.optInt("home_status");
            this.apN = jSONObject.optInt("guest_status");
            this.apJ = jSONObject.optLong("anchor_user_id");
            this.apQ = jSONObject.optInt("sequence_id");
            this.apR = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.apO = jSONObject.optInt("challenge_live");
            this.apP = jSONObject.optInt("normal_live");
            this.apT = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.apS = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.apV = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.apU = new String[length];
                for (int i = 0; i < length; i++) {
                    this.apU[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.apX = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int apY;
        public double apZ;
        public double aqa;
        public List<String> aqb;
        public List<String> aqc;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.apY = jSONObject.optInt("switch");
            this.apZ = jSONObject.optDouble("guard_club_rate");
            this.aqa = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aqb = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aqb.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aqc = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aqc.add(String.valueOf(optJSONArray2.optLong(i2)));
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
