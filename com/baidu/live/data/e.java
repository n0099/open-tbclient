package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public long VA;
    public int VB;
    public int VC;
    public long VD;
    public int VE;
    public int VF;
    public String[] VG;
    public int VH;
    public a VI;
    public b VJ;
    public boolean Vt;
    public int Vu;
    public long Vv;
    public int Vw;
    public int Vx;
    public int Vy;
    public int Vz;
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

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Vt = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.Vu = jSONObject.optInt("version_and");
            this.Vw = jSONObject.optInt("yule_show");
            this.Vx = jSONObject.optInt("yule_game");
            this.Vy = jSONObject.optInt("home_status");
            this.Vz = jSONObject.optInt("guest_status");
            this.Vv = jSONObject.optLong("anchor_user_id");
            this.VC = jSONObject.optInt("sequence_id");
            this.VD = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.VA = jSONObject.optInt("challenge_live");
            this.VB = jSONObject.optInt("normal_live");
            this.VF = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.VE = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.VH = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.VG = new String[length];
                for (int i = 0; i < length; i++) {
                    this.VG[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("gift_rate");
            if (optJSONObject != null) {
                this.VI = new a(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject2 != null) {
                this.VJ = new b(optJSONObject2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public double VK;
        public double VL;
        public long VM;
        public List<String> VN;
        public long endTime;

        a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.VK = jSONObject.optDouble("guard_club_rate");
            this.VL = jSONObject.optDouble("current_rate");
            this.VM = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.VN = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.VN.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
