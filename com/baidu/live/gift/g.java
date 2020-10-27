package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aSS;
    private String aST;
    private String aSU;
    private String aSV;
    private int aSW;
    private int aSX;
    private String aSY;
    private int aSZ;
    private int aTa;
    private int aTb;
    private int aTc;
    private String aTd;
    private String aTe;
    public int aTf;
    private String aTg;
    private String aTh;
    private String aTi;
    private boolean aTj;
    private boolean aTk;
    private int aTl;
    private int aTm;
    private int aTn;
    public boolean aTo;
    public b aTp;
    public boolean aTq;
    public String aTr;
    public String aTs;
    public a aTt;
    private int aTu;
    public l aTv;
    public String aTw;
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
        this.aSW = 0;
        this.aTj = false;
    }

    public g(g gVar) {
        this.aSW = 0;
        this.aTj = false;
        if (gVar != null) {
            this.aSS = gVar.aSS;
            this.category_name = gVar.category_name;
            this.aST = gVar.aST;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aSU = gVar.aSU;
            this.gift_desc = gVar.gift_desc;
            this.aSZ = gVar.aSZ;
            this.mark_url = gVar.mark_url;
            this.aTa = gVar.aTa;
            this.aTb = gVar.aTb;
            this.aTc = gVar.aTc;
            this.aTd = gVar.aTd;
            this.end_time = gVar.end_time;
            this.aTe = gVar.aTe;
            this.create_time = gVar.create_time;
            this.aTg = gVar.aTg;
            this.discount = gVar.discount;
            this.aTh = gVar.aTh;
            this.aTi = gVar.aTi;
            this.selected = gVar.selected;
            this.aTf = gVar.aTf;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aTv != null) {
                this.aTv = gVar.aTv.clone();
            }
            this.aTl = gVar.aTl;
            this.aTm = gVar.aTm;
            this.aTj = gVar.aTj;
            this.aSV = gVar.aSV;
            this.aTk = gVar.aTk;
            this.aTq = gVar.aTq;
            this.aTr = gVar.aTr;
            this.aTs = gVar.aTs;
            this.aSW = gVar.aSW;
            this.aSX = gVar.aSX;
            this.originalPrice = gVar.originalPrice;
            this.aSY = gVar.aSY;
            this.aTw = gVar.aTw;
        }
    }

    public boolean isRed() {
        return this.aTk;
    }

    public void bp(boolean z) {
        this.aTk = z;
    }

    public String Fs() {
        return this.aST;
    }

    public String Ft() {
        return this.gift_name;
    }

    public String Fu() {
        return this.gift_desc;
    }

    public String getPrice() {
        return FE() ? this.aSY : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void gB(String str) {
        this.aTg = str;
    }

    public String Fv() {
        return this.aTg;
    }

    public int Fw() {
        return this.animationType;
    }

    public void gC(String str) {
        this.aST = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gD(String str) {
        this.aTg = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Fx() {
        return this.aSZ;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTp = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aST = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aSU = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aTg = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aSZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aTa = jSONObject.optInt("mark_pic_width");
            this.aTb = jSONObject.optInt("mark_pic_height");
            this.aTc = jSONObject.optInt("is_time_limit_gift");
            this.aTe = jSONObject.optString("gift_tip_text");
            this.aTd = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aTh = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aTi = jSONObject.optString("proportion");
            this.aTf = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aTl = jSONObject.optInt("is_dynamic_gift");
            this.aTm = jSONObject.optInt("is_broadcast_gift");
            this.aTu = jSONObject.optInt("gift_type");
            this.aSV = jSONObject.optString("gift_tag");
            this.aSW = jSONObject.optInt("gift_tag_type", 0);
            this.aSX = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aSY = jSONObject.optString("discount_price");
            this.aTj = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aSS = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aTq = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aTr = jSONObject.optString("toast_text");
            this.aTs = jSONObject.optString("toast_jump_url");
            this.aTw = jSONObject.optString("benefit_info");
            this.aTn = jSONObject.optInt("is_pk_gift", 0);
            this.aTo = jSONObject.optInt("is_toutiao", 0) == 1;
        }
    }

    public void E(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTt = new a(jSONObject);
        }
    }

    public boolean Fy() {
        return this.aTf == 1;
    }

    public boolean Fz() {
        return this.aSZ == 7;
    }

    @Deprecated
    public boolean FA() {
        return this.aSZ == 9;
    }

    public String FB() {
        return this.aTe;
    }

    public boolean FC() {
        return this.aSZ == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean FD() {
        return this.aTl == 1;
    }

    private boolean FE() {
        return this.aSX == 1;
    }

    public boolean FF() {
        return this.aSW > 0;
    }

    public boolean FG() {
        return this.aSW == 3;
    }

    public boolean FH() {
        return this.aSW == 1;
    }

    public boolean FI() {
        return this.aSW == 4;
    }

    public boolean FJ() {
        return this.aSW == 5;
    }

    public boolean FK() {
        return this.aSW == 6;
    }

    public boolean FL() {
        return this.aTn == 1;
    }

    public boolean FM() {
        return this.aSW == 2;
    }

    @Deprecated
    public boolean FN() {
        return this.aTm > 0;
    }

    public int FO() {
        return this.aTu;
    }

    public boolean FP() {
        return this.aTj;
    }

    public String FQ() {
        return this.aSV;
    }

    @Deprecated
    public boolean FR() {
        return this.aTu == 81;
    }

    public boolean FS() {
        return this.aTu >= 2 && this.aTu <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aTB;
        public int aTC;
        public long aTD;
        public String aTE;
        public a aTF;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTB = jSONObject.optString("item_type");
                this.aTC = jSONObject.optInt("gift_balance");
                this.aTD = jSONObject.optLong("recent_expire_time");
                this.aTE = jSONObject.optString("recent_gain_channel");
                this.aTF = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aTG;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aTG = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aTx;
        public String aTy;
        public int aTz;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aTx = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aTy = jSONObject.optString("dynamic_text");
                this.aTz = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
