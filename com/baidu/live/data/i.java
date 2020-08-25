package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    public boolean aDh;
    public int aDi;
    public long aDj;
    public int aDk;
    public int aDl;
    public int aDm;
    public int aDn;
    public long aDo;
    public int aDp;
    public int aDq;
    public long aDr;
    public int aDs;
    public int aDt;
    public String[] aDu;
    public int aDv;
    public a aDw;
    public b aDx;
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
        this.aDw = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDh = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aDi = jSONObject.optInt("version_and");
            this.aDk = jSONObject.optInt("yule_show");
            this.aDl = jSONObject.optInt("yule_game");
            this.aDm = jSONObject.optInt("home_status");
            this.aDn = jSONObject.optInt("guest_status");
            this.aDj = jSONObject.optLong("anchor_user_id");
            this.aDq = jSONObject.optInt("sequence_id");
            this.aDr = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.aDo = jSONObject.optInt("challenge_live");
            this.aDp = jSONObject.optInt("normal_live");
            this.aDt = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.aDs = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.aDv = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.aDu = new String[length];
                for (int i = 0; i < length; i++) {
                    this.aDu[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.aDx = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public double aDA;
        public List<String> aDB;
        public List<String> aDC;
        public int aDy;
        public double aDz;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.aDy = jSONObject.optInt("switch");
            this.aDz = jSONObject.optDouble("guard_club_rate");
            this.aDA = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.aDB = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aDB.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.aDC = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aDC.add(String.valueOf(optJSONArray2.optLong(i2)));
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
