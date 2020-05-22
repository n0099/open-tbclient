package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int activityId;
    public boolean auM;
    public int auN;
    public long auO;
    public int auP;
    public int auQ;
    public int auR;
    public int auS;
    public long auT;
    public int auU;
    public int auV;
    public long auW;
    public int auX;
    public int auY;
    public String[] auZ;
    public int ava;
    public a avb;
    public b avc;
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
        this.avb = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auM = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.auN = jSONObject.optInt("version_and");
            this.auP = jSONObject.optInt("yule_show");
            this.auQ = jSONObject.optInt("yule_game");
            this.auR = jSONObject.optInt("home_status");
            this.auS = jSONObject.optInt("guest_status");
            this.auO = jSONObject.optLong("anchor_user_id");
            this.auV = jSONObject.optInt("sequence_id");
            this.auW = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.auT = jSONObject.optInt("challenge_live");
            this.auU = jSONObject.optInt("normal_live");
            this.auY = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.auX = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.ava = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.auZ = new String[length];
                for (int i = 0; i < length; i++) {
                    this.auZ[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.avc = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int avd;
        public double ave;
        public double avf;
        public List<String> avg;
        public List<String> avh;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.avd = jSONObject.optInt("switch");
            this.ave = jSONObject.optDouble("guard_club_rate");
            this.avf = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.avg = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.avg.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.avh = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.avh.add(String.valueOf(optJSONArray2.optLong(i2)));
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
