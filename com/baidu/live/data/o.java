package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public int aIA;
    public long aIB;
    public int aIC;
    public int aID;
    public int aIE;
    public int aIF;
    public long aIG;
    public int aIH;
    public int aII;
    public long aIJ;
    public int aIK;
    public int aIL;
    public String[] aIM;
    public int aIN;
    public a aIO;
    public b aIP;
    public boolean aIz;
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
        this.aIO = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIz = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aIA = jSONObject.optInt("version_and");
            this.aIC = jSONObject.optInt("yule_show");
            this.aID = jSONObject.optInt("yule_game");
            this.aIE = jSONObject.optInt("home_status");
            this.aIF = jSONObject.optInt("guest_status");
            this.aIB = jSONObject.optLong("anchor_user_id");
            this.aII = jSONObject.optInt("sequence_id");
            this.aIJ = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aIG = jSONObject.optInt("challenge_live");
            this.aIH = jSONObject.optInt("normal_live");
            this.aIL = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aIK = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aIN = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aIM = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aIM[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aIP = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int aIQ;
        public double aIR;
        public double aIS;
        public List<String> aIT;
        public List<String> aIU;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aIQ = jSONObject.optInt("switch");
            this.aIR = jSONObject.optDouble("guard_club_rate");
            this.aIS = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aIT = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aIT.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aIU = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aIU.add(String.valueOf(optJSONArray2.optLong(i2)));
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
