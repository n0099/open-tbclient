package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    public b aFA;
    public boolean aFk;
    public int aFl;
    public long aFm;
    public int aFn;
    public int aFo;
    public int aFp;
    public int aFq;
    public long aFr;
    public int aFs;
    public int aFt;
    public long aFu;
    public int aFv;
    public int aFw;
    public String[] aFx;
    public int aFy;
    public a aFz;
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
        this.aFz = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aFk = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aFl = jSONObject.optInt("version_and");
            this.aFn = jSONObject.optInt("yule_show");
            this.aFo = jSONObject.optInt("yule_game");
            this.aFp = jSONObject.optInt("home_status");
            this.aFq = jSONObject.optInt("guest_status");
            this.aFm = jSONObject.optLong("anchor_user_id");
            this.aFt = jSONObject.optInt("sequence_id");
            this.aFu = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aFr = jSONObject.optInt("challenge_live");
            this.aFs = jSONObject.optInt("normal_live");
            this.aFw = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aFv = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aFy = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aFx = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aFx[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aFA = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int aFB;
        public double aFC;
        public double aFD;
        public long aFE;
        public List<String> aFF;
        public List<String> aFG;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aFB = jSONObject.optInt("switch");
            this.aFC = jSONObject.optDouble("guard_club_rate");
            this.aFD = jSONObject.optDouble("current_rate");
            this.aFE = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aFF = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aFF.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aFG = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aFG.add(String.valueOf(optJSONArray2.optLong(i2)));
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
