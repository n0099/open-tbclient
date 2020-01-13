package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public boolean VJ;
    public int VK;
    public long VL;
    public int VM;
    public int VN;
    public int VO;
    public int VP;
    public long VQ;
    public int VR;
    public int VS;
    public long VT;
    public int VU;
    public int VV;
    public String[] VW;
    public int VX;
    public a VY;
    public b VZ;
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
            this.VJ = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.VK = jSONObject.optInt("version_and");
            this.VM = jSONObject.optInt("yule_show");
            this.VN = jSONObject.optInt("yule_game");
            this.VO = jSONObject.optInt("home_status");
            this.VP = jSONObject.optInt("guest_status");
            this.VL = jSONObject.optLong("anchor_user_id");
            this.VS = jSONObject.optInt("sequence_id");
            this.VT = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.VQ = jSONObject.optInt("challenge_live");
            this.VR = jSONObject.optInt("normal_live");
            this.VV = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.VU = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.VX = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.VW = new String[length];
                for (int i = 0; i < length; i++) {
                    this.VW[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("gift_rate");
            if (optJSONObject != null) {
                this.VY = new a(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject2 != null) {
                this.VZ = new b(optJSONObject2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public double Wa;
        public double Wb;
        public List<String> Wc;
        public long currentTime;
        public long endTime;

        a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.Wa = jSONObject.optDouble("guard_club_rate");
            this.Wb = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.Wc = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Wc.add(String.valueOf(optJSONArray.optLong(i)));
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
