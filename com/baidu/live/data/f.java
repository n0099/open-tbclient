package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public long XA;
    public int XB;
    public int XC;
    public long XD;
    public int XE;
    public int XF;
    public String[] XG;
    public int XH;
    public a XI;
    public b XJ;
    public boolean Xt;
    public int Xu;
    public long Xv;
    public int Xw;
    public int Xx;
    public int Xy;
    public int Xz;
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
        this.XI = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Xt = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.Xu = jSONObject.optInt("version_and");
            this.Xw = jSONObject.optInt("yule_show");
            this.Xx = jSONObject.optInt("yule_game");
            this.Xy = jSONObject.optInt("home_status");
            this.Xz = jSONObject.optInt("guest_status");
            this.Xv = jSONObject.optLong("anchor_user_id");
            this.XC = jSONObject.optInt("sequence_id");
            this.XD = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.XA = jSONObject.optInt("challenge_live");
            this.XB = jSONObject.optInt("normal_live");
            this.XF = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.XE = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.XH = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.XG = new String[length];
                for (int i = 0; i < length; i++) {
                    this.XG[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.XJ = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int XK;
        public double XL;
        public double XM;
        public List<String> XN;
        public List<String> XO;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.XK = jSONObject.optInt("switch");
            this.XL = jSONObject.optDouble("guard_club_rate");
            this.XM = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.XN = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.XN.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.XO = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.XO.add(String.valueOf(optJSONArray2.optLong(i2)));
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
