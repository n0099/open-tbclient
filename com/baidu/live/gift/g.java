package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private String adA;
    private int adB;
    private int adC;
    private int adD;
    private int adE;
    private String adF;
    private String adG;
    private String adH;
    private String adI;
    private String adJ;
    public int adK;
    private int adL;
    private int adM;
    private int adN;
    private boolean adO;
    private String adP;
    private boolean adQ;
    public a adR;
    public boolean adS;
    public String adT;
    public String adU;
    private int adV;
    public l adW;
    private String ady;
    private String adz;
    private String category_name;
    private String create_time;
    private String discount;
    private String end_time;
    private String gift_desc;
    private String gift_name;
    private String mark_url;
    private String price;
    private String scene_from;
    private String selected;
    private String thumbnail_url;

    public g() {
        this.adO = false;
    }

    public g(g gVar) {
        this.adO = false;
        if (gVar != null) {
            this.ady = gVar.ady;
            this.category_name = gVar.category_name;
            this.adz = gVar.adz;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.adA = gVar.adA;
            this.gift_desc = gVar.gift_desc;
            this.adB = gVar.adB;
            this.mark_url = gVar.mark_url;
            this.adC = gVar.adC;
            this.adD = gVar.adD;
            this.adE = gVar.adE;
            this.adF = gVar.adF;
            this.end_time = gVar.end_time;
            this.adG = gVar.adG;
            this.create_time = gVar.create_time;
            this.adH = gVar.adH;
            this.discount = gVar.discount;
            this.adI = gVar.adI;
            this.adJ = gVar.adJ;
            this.selected = gVar.selected;
            this.adK = gVar.adK;
            this.scene_from = gVar.getSceneFrom();
            this.adL = gVar.adL;
            if (gVar.adW != null) {
                this.adW = gVar.adW.clone();
            }
            this.adM = gVar.adM;
            this.adN = gVar.adN;
            this.adO = gVar.adO;
            this.adP = gVar.adP;
            this.adQ = gVar.adQ;
            this.adS = gVar.adS;
            this.adT = gVar.adT;
            this.adU = gVar.adU;
        }
    }

    public boolean isRed() {
        return this.adQ;
    }

    public void au(boolean z) {
        this.adQ = z;
    }

    public String qx() {
        return this.adz;
    }

    public String qy() {
        return this.gift_name;
    }

    public String qz() {
        return this.gift_desc;
    }

    public String getPrice() {
        return this.price;
    }

    public String qA() {
        return this.thumbnail_url;
    }

    public String qB() {
        return this.adH;
    }

    public int qC() {
        return this.adL;
    }

    public void cV(String str) {
        this.adz = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void cW(String str) {
        this.adH = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int qD() {
        return this.adB;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void q(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adR = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adz = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.adA = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.adH = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.adB = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.adC = jSONObject.optInt("mark_pic_width");
            this.adD = jSONObject.optInt("mark_pic_height");
            this.adE = jSONObject.optInt("is_time_limit_gift");
            this.adG = jSONObject.optString("gift_tip_text");
            this.adF = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.adI = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.adJ = jSONObject.optString("proportion");
            this.adK = jSONObject.optInt("is_combo");
            this.adL = jSONObject.optInt("animation_type");
            this.adM = jSONObject.optInt("is_dynamic_gift");
            this.adN = jSONObject.optInt("is_broadcast_gift");
            this.adV = jSONObject.optInt("gift_type");
            this.adP = jSONObject.optString("gift_tag");
            this.adO = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.ady = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.adS = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.adT = jSONObject.optString("toast_text");
            this.adU = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean qE() {
        return this.adK == 1;
    }

    public boolean qF() {
        return this.adB == 7;
    }

    public boolean qG() {
        return this.adB == 9;
    }

    public String qH() {
        return this.adG;
    }

    public boolean qI() {
        return this.adB == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean qJ() {
        return this.adM == 1;
    }

    public boolean qK() {
        return this.adN > 0;
    }

    public int qL() {
        return this.adV;
    }

    public boolean qM() {
        return this.adO;
    }

    public String qN() {
        return this.adP;
    }

    public boolean qO() {
        return this.adV == 81;
    }

    public boolean qP() {
        return this.adV >= 2 && this.adV <= 12;
    }

    /* loaded from: classes2.dex */
    public class a {
        public String adX;
        public int adY;
        public long adZ;
        public String aea;
        public C0079a aeb;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.adX = jSONObject.optString("item_type");
                this.adY = jSONObject.optInt("gift_balance");
                this.adZ = jSONObject.optLong("recent_expire_time");
                this.aea = jSONObject.optString("recent_gain_channel");
                this.aeb = new C0079a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0079a {
            public JSONObject aed;
            public int key;

            public C0079a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aed = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
