package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aUA;
    private String aUB;
    private boolean aUC;
    private boolean aUD;
    private int aUE;
    private int aUF;
    private int aUG;
    public boolean aUH;
    public b aUI;
    public boolean aUJ;
    public String aUK;
    public String aUL;
    public a aUM;
    public k aUN;
    public String aUO;
    public int aUP;
    private String aUl;
    private String aUm;
    private String aUn;
    private String aUo;
    private int aUp;
    private int aUq;
    private String aUr;
    private int aUs;
    private int aUt;
    private int aUu;
    private int aUv;
    private String aUw;
    private String aUx;
    public int aUy;
    private String aUz;
    private int animationType;
    private String category_name;
    private String create_time;
    private String discount;
    private String end_time;
    private String gift_desc;
    private String gift_name;
    private int gift_type;
    private String mark_url;
    private String originalPrice;
    private String price;
    private String scene_from;
    private String selected;
    private String thumbnail_url;

    public g() {
        this.aUp = 0;
        this.aUC = false;
        this.aUP = -1;
    }

    public g(g gVar) {
        this.aUp = 0;
        this.aUC = false;
        this.aUP = -1;
        if (gVar != null) {
            this.aUl = gVar.aUl;
            this.category_name = gVar.category_name;
            this.aUm = gVar.aUm;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aUn = gVar.aUn;
            this.gift_desc = gVar.gift_desc;
            this.aUs = gVar.aUs;
            this.mark_url = gVar.mark_url;
            this.aUt = gVar.aUt;
            this.aUu = gVar.aUu;
            this.aUv = gVar.aUv;
            this.aUw = gVar.aUw;
            this.end_time = gVar.end_time;
            this.aUx = gVar.aUx;
            this.create_time = gVar.create_time;
            this.aUz = gVar.aUz;
            this.discount = gVar.discount;
            this.aUA = gVar.aUA;
            this.aUB = gVar.aUB;
            this.selected = gVar.selected;
            this.aUy = gVar.aUy;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aUN != null) {
                this.aUN = gVar.aUN.clone();
            }
            this.aUE = gVar.aUE;
            this.aUF = gVar.aUF;
            this.aUC = gVar.aUC;
            this.aUo = gVar.aUo;
            this.aUD = gVar.aUD;
            this.aUJ = gVar.aUJ;
            this.aUK = gVar.aUK;
            this.aUL = gVar.aUL;
            this.aUp = gVar.aUp;
            this.aUq = gVar.aUq;
            this.originalPrice = gVar.originalPrice;
            this.aUr = gVar.aUr;
            this.aUO = gVar.aUO;
        }
    }

    public boolean isRed() {
        return this.aUD;
    }

    public void bq(boolean z) {
        this.aUD = z;
    }

    public String FT() {
        return this.aUm;
    }

    public String FU() {
        return this.gift_name;
    }

    public String FV() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Gf() ? this.aUr : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void gG(String str) {
        this.aUz = str;
    }

    public String FW() {
        return this.aUz;
    }

    public int FX() {
        return this.animationType;
    }

    public void gH(String str) {
        this.aUm = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gI(String str) {
        this.aUz = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int FY() {
        return this.aUs;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void G(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aUI = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aUm = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aUn = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aUz = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aUs = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aUt = jSONObject.optInt("mark_pic_width");
            this.aUu = jSONObject.optInt("mark_pic_height");
            this.aUv = jSONObject.optInt("is_time_limit_gift");
            this.aUx = jSONObject.optString("gift_tip_text");
            this.aUw = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aUA = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aUB = jSONObject.optString("proportion");
            this.aUy = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aUE = jSONObject.optInt("is_dynamic_gift");
            this.aUF = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aUo = jSONObject.optString("gift_tag");
            this.aUp = jSONObject.optInt("gift_tag_type", 0);
            this.aUq = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aUr = jSONObject.optString("discount_price");
            this.aUC = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aUl = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aUJ = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aUK = jSONObject.optString("toast_text");
            this.aUL = jSONObject.optString("toast_jump_url");
            this.aUO = jSONObject.optString("benefit_info");
            this.aUG = jSONObject.optInt("is_pk_gift", 0);
            this.aUH = jSONObject.optInt("is_toutiao", 0) == 1;
        }
    }

    public void H(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aUM = new a(jSONObject);
        }
    }

    public boolean FZ() {
        return this.aUy == 1;
    }

    public boolean Ga() {
        return this.aUs == 7;
    }

    @Deprecated
    public boolean Gb() {
        return this.aUs == 9;
    }

    public String Gc() {
        return this.aUx;
    }

    public boolean Gd() {
        return this.aUs == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Ge() {
        return this.aUE == 1;
    }

    private boolean Gf() {
        return this.aUq == 1;
    }

    public boolean Gg() {
        return this.aUp > 0;
    }

    public boolean Gh() {
        return this.aUp == 3;
    }

    public boolean Gi() {
        return this.aUp == 1;
    }

    public boolean Gj() {
        return this.aUp == 4;
    }

    public boolean Gk() {
        return this.aUp == 5;
    }

    public boolean Gl() {
        return this.aUp == 6;
    }

    public boolean Gm() {
        return this.aUG == 1;
    }

    public boolean Gn() {
        return this.aUp == 2;
    }

    @Deprecated
    public boolean Go() {
        return this.aUF > 0;
    }

    public int Gp() {
        return this.gift_type;
    }

    public boolean Gq() {
        return this.aUC;
    }

    public String Gr() {
        return this.aUo;
    }

    @Deprecated
    public boolean Gs() {
        return this.gift_type == 81;
    }

    public boolean Gt() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aUU;
        public int aUV;
        public long aUW;
        public String aUX;
        public a aUY;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aUU = jSONObject.optString("item_type");
                this.aUV = jSONObject.optInt("gift_balance");
                this.aUW = jSONObject.optLong("recent_expire_time");
                this.aUX = jSONObject.optString("recent_gain_channel");
                this.aUY = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aUZ;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aUZ = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aUQ;
        public String aUR;
        public int aUS;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aUQ = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aUR = jSONObject.optString("dynamic_text");
                this.aUS = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
