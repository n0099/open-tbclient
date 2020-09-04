package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    public boolean aDj;
    public int aDk;
    public long aDl;
    public int aDm;
    public int aDn;
    public int aDo;
    public int aDp;
    public long aDq;
    public int aDr;
    public int aDs;
    public long aDt;
    public int aDu;
    public int aDv;
    public String[] aDw;
    public int aDx;
    public a aDy;
    public b aDz;
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
        this.aDy = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDj = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aDk = jSONObject.optInt("version_and");
            this.aDm = jSONObject.optInt("yule_show");
            this.aDn = jSONObject.optInt("yule_game");
            this.aDo = jSONObject.optInt("home_status");
            this.aDp = jSONObject.optInt("guest_status");
            this.aDl = jSONObject.optLong("anchor_user_id");
            this.aDs = jSONObject.optInt("sequence_id");
            this.aDt = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aDq = jSONObject.optInt("challenge_live");
            this.aDr = jSONObject.optInt("normal_live");
            this.aDv = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aDu = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aDx = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aDw = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aDw[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aDz = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public int aDA;
        public double aDB;
        public double aDC;
        public List<String> aDD;
        public List<String> aDE;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aDA = jSONObject.optInt("switch");
            this.aDB = jSONObject.optDouble("guard_club_rate");
            this.aDC = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aDD = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aDD.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aDE = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aDE.add(String.valueOf(optJSONArray2.optLong(i2)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
