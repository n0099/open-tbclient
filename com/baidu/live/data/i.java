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
    public boolean awS;
    public int awT;
    public long awU;
    public int awV;
    public int awW;
    public int awX;
    public int awY;
    public long awZ;
    public int axa;
    public int axb;
    public long axc;
    public int axd;
    public int axe;
    public String[] axf;
    public int axg;
    public a axh;
    public b axi;
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
        this.axh = aVar;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.awS = jSONObject.optInt("is_new") == 1;
            this.pic_url = jSONObject.optString("pic_url");
            this.picType = jSONObject.optInt("pic_type");
            this.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.awT = jSONObject.optInt("version_and");
            this.awV = jSONObject.optInt("yule_show");
            this.awW = jSONObject.optInt("yule_game");
            this.awX = jSONObject.optInt("home_status");
            this.awY = jSONObject.optInt("guest_status");
            this.awU = jSONObject.optLong("anchor_user_id");
            this.axb = jSONObject.optInt("sequence_id");
            this.axc = jSONObject.optLong("add_time");
            this.begin_time = jSONObject.optLong("begin_time");
            this.end_time = jSONObject.optLong("end_time");
            this.pos = jSONObject.optInt("pos");
            this.position = jSONObject.optInt("position");
            this.type = jSONObject.optInt("type");
            this.awZ = jSONObject.optInt("challenge_live");
            this.axa = jSONObject.optInt("normal_live");
            this.axe = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.activityId = jSONObject.optInt("activity_id");
            this.showTime = jSONObject.optLong("show_time");
            this.axd = jSONObject.optInt("need_show");
            this.webUrl = jSONObject.optString("h5_url");
            this.axg = jSONObject.optInt("jump_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("info_fields");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.axf = new String[length];
                for (int i = 0; i < length; i++) {
                    this.axf[i] = optJSONArray.optString(i);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("pic_loc_info");
            if (optJSONObject != null) {
                this.axi = new b(optJSONObject);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int axj;
        public double axk;
        public double axl;
        public List<String> axm;
        public List<String> axn;
        public long currentTime;
        public long endTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        void parseJson(JSONObject jSONObject) {
            this.axj = jSONObject.optInt("switch");
            this.axk = jSONObject.optDouble("guard_club_rate");
            this.axl = jSONObject.optDouble("current_rate");
            this.currentTime = jSONObject.optLong("current_time");
            this.endTime = jSONObject.optLong("rate_end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("rate_gift_ids");
            if (optJSONArray != null) {
                this.axm = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.axm.add(String.valueOf(optJSONArray.optLong(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("speed_white_list");
            if (optJSONArray2 != null) {
                this.axn = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.axn.add(String.valueOf(optJSONArray2.optLong(i2)));
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
