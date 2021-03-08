package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class t {
    public boolean aJg;
    public int aJh;
    public long aJi;
    public int aJj;
    public int aJk;
    public int aJl;
    public int aJm;
    public long aJn;
    public int aJo;
    public int aJp;
    public long aJq;
    public int aJr;
    public int aJs;
    public String[] aJt;
    public int aJu;
    public a aJv;
    public b aJw;
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
        this.aJv = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJg = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aJh = jSONObject.optInt("version_and");
            this.aJj = jSONObject.optInt("yule_show");
            this.aJk = jSONObject.optInt("yule_game");
            this.aJl = jSONObject.optInt("home_status");
            this.aJm = jSONObject.optInt("guest_status");
            this.aJi = jSONObject.optLong("anchor_user_id");
            this.aJp = jSONObject.optInt("sequence_id");
            this.aJq = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aJn = jSONObject.optInt("challenge_live");
            this.aJo = jSONObject.optInt("normal_live");
            this.aJs = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aJr = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aJu = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aJt = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aJt[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aJw = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public long aJA;
        public List<String> aJB;
        public List<String> aJC;
        public int aJx;
        public double aJy;
        public double aJz;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aJx = jSONObject.optInt("switch");
            this.aJy = jSONObject.optDouble("guard_club_rate");
            this.aJz = jSONObject.optDouble("current_rate");
            this.aJA = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aJB = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aJB.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aJC = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aJC.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
