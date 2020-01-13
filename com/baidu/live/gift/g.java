package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private String adN;
    private String adO;
    private String adP;
    private int adQ;
    private int adR;
    private int adS;
    private int adT;
    private String adU;
    private String adV;
    private String adW;
    private String adX;
    private String adY;
    public int adZ;
    private int aea;
    private int aeb;
    private int aec;
    private boolean aed;
    private String aee;
    private boolean aef;
    public a aeg;
    public boolean aeh;
    public String aei;
    public String aej;
    private int aek;
    public l ael;
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
        this.aed = false;
    }

    public g(g gVar) {
        this.aed = false;
        if (gVar != null) {
            this.adN = gVar.adN;
            this.category_name = gVar.category_name;
            this.adO = gVar.adO;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.adP = gVar.adP;
            this.gift_desc = gVar.gift_desc;
            this.adQ = gVar.adQ;
            this.mark_url = gVar.mark_url;
            this.adR = gVar.adR;
            this.adS = gVar.adS;
            this.adT = gVar.adT;
            this.adU = gVar.adU;
            this.end_time = gVar.end_time;
            this.adV = gVar.adV;
            this.create_time = gVar.create_time;
            this.adW = gVar.adW;
            this.discount = gVar.discount;
            this.adX = gVar.adX;
            this.adY = gVar.adY;
            this.selected = gVar.selected;
            this.adZ = gVar.adZ;
            this.scene_from = gVar.getSceneFrom();
            this.aea = gVar.aea;
            if (gVar.ael != null) {
                this.ael = gVar.ael.clone();
            }
            this.aeb = gVar.aeb;
            this.aec = gVar.aec;
            this.aed = gVar.aed;
            this.aee = gVar.aee;
            this.aef = gVar.aef;
            this.aeh = gVar.aeh;
            this.aei = gVar.aei;
            this.aej = gVar.aej;
        }
    }

    public boolean isRed() {
        return this.aef;
    }

    public void au(boolean z) {
        this.aef = z;
    }

    public String qE() {
        return this.adO;
    }

    public String qF() {
        return this.gift_name;
    }

    public String qG() {
        return this.gift_desc;
    }

    public String getPrice() {
        return this.price;
    }

    public String qH() {
        return this.thumbnail_url;
    }

    public String qI() {
        return this.adW;
    }

    public int qJ() {
        return this.aea;
    }

    public void cX(String str) {
        this.adO = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void cY(String str) {
        this.adW = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int qK() {
        return this.adQ;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aeg = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adO = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.adP = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.adW = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.adQ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.adR = jSONObject.optInt("mark_pic_width");
            this.adS = jSONObject.optInt("mark_pic_height");
            this.adT = jSONObject.optInt("is_time_limit_gift");
            this.adV = jSONObject.optString("gift_tip_text");
            this.adU = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.adX = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.adY = jSONObject.optString("proportion");
            this.adZ = jSONObject.optInt("is_combo");
            this.aea = jSONObject.optInt("animation_type");
            this.aeb = jSONObject.optInt("is_dynamic_gift");
            this.aec = jSONObject.optInt("is_broadcast_gift");
            this.aek = jSONObject.optInt("gift_type");
            this.aee = jSONObject.optString("gift_tag");
            this.aed = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.adN = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aeh = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aei = jSONObject.optString("toast_text");
            this.aej = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean qL() {
        return this.adZ == 1;
    }

    public boolean qM() {
        return this.adQ == 7;
    }

    public boolean qN() {
        return this.adQ == 9;
    }

    public String qO() {
        return this.adV;
    }

    public boolean qP() {
        return this.adQ == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean qQ() {
        return this.aeb == 1;
    }

    public boolean qR() {
        return this.aec > 0;
    }

    public int qS() {
        return this.aek;
    }

    public boolean qT() {
        return this.aed;
    }

    public String qU() {
        return this.aee;
    }

    public boolean qV() {
        return this.aek == 81;
    }

    public boolean qW() {
        return this.aek >= 2 && this.aek <= 12;
    }

    /* loaded from: classes2.dex */
    public class a {
        public String aem;
        public int aen;
        public long aeo;
        public String aep;
        public C0079a aeq;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aem = jSONObject.optString("item_type");
                this.aen = jSONObject.optInt("gift_balance");
                this.aeo = jSONObject.optLong("recent_expire_time");
                this.aep = jSONObject.optString("recent_gain_channel");
                this.aeq = new C0079a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0079a {
            public JSONObject aes;
            public int key;

            public C0079a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aes = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
