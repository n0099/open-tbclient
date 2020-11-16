package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aSA;
    private String aSB;
    private String aSC;
    private String aSD;
    private int aSE;
    private int aSF;
    private String aSG;
    private int aSH;
    private int aSI;
    private int aSJ;
    private int aSK;
    private String aSL;
    private String aSM;
    public int aSN;
    private String aSO;
    private String aSP;
    private String aSQ;
    private boolean aSR;
    private boolean aSS;
    private int aST;
    private int aSU;
    private int aSV;
    public boolean aSW;
    public b aSX;
    public boolean aSY;
    public String aSZ;
    public String aTa;
    public a aTb;
    public k aTc;
    public String aTd;
    public int aTe;
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
        this.aSE = 0;
        this.aSR = false;
        this.aTe = -1;
    }

    public g(g gVar) {
        this.aSE = 0;
        this.aSR = false;
        this.aTe = -1;
        if (gVar != null) {
            this.aSA = gVar.aSA;
            this.category_name = gVar.category_name;
            this.aSB = gVar.aSB;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aSC = gVar.aSC;
            this.gift_desc = gVar.gift_desc;
            this.aSH = gVar.aSH;
            this.mark_url = gVar.mark_url;
            this.aSI = gVar.aSI;
            this.aSJ = gVar.aSJ;
            this.aSK = gVar.aSK;
            this.aSL = gVar.aSL;
            this.end_time = gVar.end_time;
            this.aSM = gVar.aSM;
            this.create_time = gVar.create_time;
            this.aSO = gVar.aSO;
            this.discount = gVar.discount;
            this.aSP = gVar.aSP;
            this.aSQ = gVar.aSQ;
            this.selected = gVar.selected;
            this.aSN = gVar.aSN;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aTc != null) {
                this.aTc = gVar.aTc.clone();
            }
            this.aST = gVar.aST;
            this.aSU = gVar.aSU;
            this.aSR = gVar.aSR;
            this.aSD = gVar.aSD;
            this.aSS = gVar.aSS;
            this.aSY = gVar.aSY;
            this.aSZ = gVar.aSZ;
            this.aTa = gVar.aTa;
            this.aSE = gVar.aSE;
            this.aSF = gVar.aSF;
            this.originalPrice = gVar.originalPrice;
            this.aSG = gVar.aSG;
            this.aTd = gVar.aTd;
        }
    }

    public boolean isRed() {
        return this.aSS;
    }

    public void bs(boolean z) {
        this.aSS = z;
    }

    public String Fk() {
        return this.aSB;
    }

    public String Fl() {
        return this.gift_name;
    }

    public String Fm() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Fw() ? this.aSG : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void gA(String str) {
        this.aSO = str;
    }

    public String Fn() {
        return this.aSO;
    }

    public int Fo() {
        return this.animationType;
    }

    public void gB(String str) {
        this.aSB = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gC(String str) {
        this.aSO = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Fp() {
        return this.aSH;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void A(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSX = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSB = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aSC = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aSO = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aSH = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aSI = jSONObject.optInt("mark_pic_width");
            this.aSJ = jSONObject.optInt("mark_pic_height");
            this.aSK = jSONObject.optInt("is_time_limit_gift");
            this.aSM = jSONObject.optString("gift_tip_text");
            this.aSL = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aSP = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aSQ = jSONObject.optString("proportion");
            this.aSN = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aST = jSONObject.optInt("is_dynamic_gift");
            this.aSU = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aSD = jSONObject.optString("gift_tag");
            this.aSE = jSONObject.optInt("gift_tag_type", 0);
            this.aSF = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aSG = jSONObject.optString("discount_price");
            this.aSR = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aSA = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aSY = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aSZ = jSONObject.optString("toast_text");
            this.aTa = jSONObject.optString("toast_jump_url");
            this.aTd = jSONObject.optString("benefit_info");
            this.aSV = jSONObject.optInt("is_pk_gift", 0);
            this.aSW = jSONObject.optInt("is_toutiao", 0) == 1;
        }
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTb = new a(jSONObject);
        }
    }

    public boolean Fq() {
        return this.aSN == 1;
    }

    public boolean Fr() {
        return this.aSH == 7;
    }

    @Deprecated
    public boolean Fs() {
        return this.aSH == 9;
    }

    public String Ft() {
        return this.aSM;
    }

    public boolean Fu() {
        return this.aSH == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Fv() {
        return this.aST == 1;
    }

    private boolean Fw() {
        return this.aSF == 1;
    }

    public boolean Fx() {
        return this.aSE > 0;
    }

    public boolean Fy() {
        return this.aSE == 3;
    }

    public boolean Fz() {
        return this.aSE == 1;
    }

    public boolean FA() {
        return this.aSE == 4;
    }

    public boolean FB() {
        return this.aSE == 5;
    }

    public boolean FC() {
        return this.aSE == 6;
    }

    public boolean FD() {
        return this.aSV == 1;
    }

    public boolean FE() {
        return this.aSE == 2;
    }

    @Deprecated
    public boolean FF() {
        return this.aSU > 0;
    }

    public int FG() {
        return this.gift_type;
    }

    public boolean FH() {
        return this.aSR;
    }

    public String FI() {
        return this.aSD;
    }

    @Deprecated
    public boolean FJ() {
        return this.gift_type == 81;
    }

    public boolean FK() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aTj;
        public int aTk;
        public long aTl;
        public String aTm;
        public a aTn;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTj = jSONObject.optString("item_type");
                this.aTk = jSONObject.optInt("gift_balance");
                this.aTl = jSONObject.optLong("recent_expire_time");
                this.aTm = jSONObject.optString("recent_gain_channel");
                this.aTn = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aTo;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aTo = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aTf;
        public String aTg;
        public int aTh;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aTf = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aTg = jSONObject.optString("dynamic_text");
                this.aTh = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
