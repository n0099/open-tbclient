package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aOM;
    private String aON;
    private String aOO;
    private String aOP;
    private int aOQ;
    private int aOR;
    private String aOS;
    private int aOT;
    private int aOU;
    private int aOV;
    private int aOW;
    private String aOX;
    private String aOY;
    public int aOZ;
    private String aPa;
    private String aPb;
    private String aPc;
    private boolean aPd;
    private boolean aPe;
    private int aPf;
    private int aPg;
    private int aPh;
    public b aPi;
    public boolean aPj;
    public String aPk;
    public String aPl;
    public a aPm;
    private int aPn;
    public l aPo;
    public String aPp;
    private int animationType;
    private String category_name;
    private String create_time;
    private String discount;
    private String end_time;
    private String gift_desc;
    private String gift_name;
    private String mark_url;
    private String originalPrice;
    private String price;
    private String scene_from;
    private String selected;
    private String thumbnail_url;

    public g() {
        this.aOQ = 0;
        this.aPd = false;
    }

    public g(g gVar) {
        this.aOQ = 0;
        this.aPd = false;
        if (gVar != null) {
            this.aOM = gVar.aOM;
            this.category_name = gVar.category_name;
            this.aON = gVar.aON;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aOO = gVar.aOO;
            this.gift_desc = gVar.gift_desc;
            this.aOT = gVar.aOT;
            this.mark_url = gVar.mark_url;
            this.aOU = gVar.aOU;
            this.aOV = gVar.aOV;
            this.aOW = gVar.aOW;
            this.aOX = gVar.aOX;
            this.end_time = gVar.end_time;
            this.aOY = gVar.aOY;
            this.create_time = gVar.create_time;
            this.aPa = gVar.aPa;
            this.discount = gVar.discount;
            this.aPb = gVar.aPb;
            this.aPc = gVar.aPc;
            this.selected = gVar.selected;
            this.aOZ = gVar.aOZ;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aPo != null) {
                this.aPo = gVar.aPo.clone();
            }
            this.aPf = gVar.aPf;
            this.aPg = gVar.aPg;
            this.aPd = gVar.aPd;
            this.aOP = gVar.aOP;
            this.aPe = gVar.aPe;
            this.aPj = gVar.aPj;
            this.aPk = gVar.aPk;
            this.aPl = gVar.aPl;
            this.aOQ = gVar.aOQ;
            this.aOR = gVar.aOR;
            this.originalPrice = gVar.originalPrice;
            this.aOS = gVar.aOS;
            this.aPp = gVar.aPp;
        }
    }

    public boolean isRed() {
        return this.aPe;
    }

    public void bj(boolean z) {
        this.aPe = z;
    }

    public String Eh() {
        return this.aON;
    }

    public String Ei() {
        return this.gift_name;
    }

    public String Ej() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Et() ? this.aOS : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String Ek() {
        return this.aPa;
    }

    public int El() {
        return this.animationType;
    }

    public void gj(String str) {
        this.aON = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gk(String str) {
        this.aPa = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Em() {
        return this.aOT;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPi = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aON = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aOO = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aPa = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aOT = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aOU = jSONObject.optInt("mark_pic_width");
            this.aOV = jSONObject.optInt("mark_pic_height");
            this.aOW = jSONObject.optInt("is_time_limit_gift");
            this.aOY = jSONObject.optString("gift_tip_text");
            this.aOX = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aPb = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aPc = jSONObject.optString("proportion");
            this.aOZ = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aPf = jSONObject.optInt("is_dynamic_gift");
            this.aPg = jSONObject.optInt("is_broadcast_gift");
            this.aPn = jSONObject.optInt("gift_type");
            this.aOP = jSONObject.optString("gift_tag");
            this.aOQ = jSONObject.optInt("gift_tag_type", 0);
            this.aOR = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aOS = jSONObject.optString("discount_price");
            this.aPd = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aOM = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aPj = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aPk = jSONObject.optString("toast_text");
            this.aPl = jSONObject.optString("toast_jump_url");
            this.aPp = jSONObject.optString("benefit_info");
            this.aPh = jSONObject.optInt("is_pk_gift", 0);
        }
    }

    public void E(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPm = new a(jSONObject);
        }
    }

    public boolean En() {
        return this.aOZ == 1;
    }

    public boolean Eo() {
        return this.aOT == 7;
    }

    @Deprecated
    public boolean Ep() {
        return this.aOT == 9;
    }

    public String Eq() {
        return this.aOY;
    }

    public boolean Er() {
        return this.aOT == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Es() {
        return this.aPf == 1;
    }

    private boolean Et() {
        return this.aOR == 1;
    }

    public boolean Eu() {
        return this.aOQ > 0;
    }

    public boolean Ev() {
        return this.aOQ == 3;
    }

    public boolean Ew() {
        return this.aOQ == 1;
    }

    public boolean Ex() {
        return this.aOQ == 4;
    }

    public boolean Ey() {
        return this.aOQ == 5;
    }

    public boolean Ez() {
        return this.aOQ == 6;
    }

    public boolean EA() {
        return this.aPh == 1;
    }

    public boolean EB() {
        return this.aOQ == 2;
    }

    @Deprecated
    public boolean EC() {
        return this.aPg > 0;
    }

    public int ED() {
        return this.aPn;
    }

    public boolean EE() {
        return this.aPd;
    }

    public String EF() {
        return this.aOP;
    }

    @Deprecated
    public boolean EG() {
        return this.aPn == 81;
    }

    public boolean EH() {
        return this.aPn >= 2 && this.aPn <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aPu;
        public int aPv;
        public long aPw;
        public String aPx;
        public a aPy;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aPu = jSONObject.optString("item_type");
                this.aPv = jSONObject.optInt("gift_balance");
                this.aPw = jSONObject.optLong("recent_expire_time");
                this.aPx = jSONObject.optString("recent_gain_channel");
                this.aPy = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aPz;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aPz = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aPq;
        public String aPr;
        public int aPs;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aPq = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aPr = jSONObject.optString("dynamic_text");
                this.aPs = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
