package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p {
    public boolean aJX;
    public int aJY;
    public long aJZ;
    public int aKa;
    public int aKb;
    public int aKc;
    public int aKd;
    public long aKe;
    public int aKf;
    public int aKg;
    public long aKh;
    public int aKi;
    public int aKj;
    public String[] aKk;
    public int aKl;
    public a aKm;
    public b aKn;
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
        this.aKm = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJX = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aJY = jSONObject.optInt("version_and");
            this.aKa = jSONObject.optInt("yule_show");
            this.aKb = jSONObject.optInt("yule_game");
            this.aKc = jSONObject.optInt("home_status");
            this.aKd = jSONObject.optInt("guest_status");
            this.aJZ = jSONObject.optLong("anchor_user_id");
            this.aKg = jSONObject.optInt("sequence_id");
            this.aKh = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aKe = jSONObject.optInt("challenge_live");
            this.aKf = jSONObject.optInt("normal_live");
            this.aKj = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aKi = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aKl = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aKk = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aKk[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aKn = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int aKo;
        public double aKp;
        public double aKq;
        public long aKr;
        public List<String> aKs;
        public List<String> aKt;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aKo = jSONObject.optInt("switch");
            this.aKp = jSONObject.optDouble("guard_club_rate");
            this.aKq = jSONObject.optDouble("current_rate");
            this.aKr = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aKs = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aKs.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aKt = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aKt.add(String.valueOf(optJSONArray2.optLong(i2)));
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
