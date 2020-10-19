package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aRX;
    private String aRY;
    private String aRZ;
    public String aSA;
    private String aSa;
    private int aSb;
    private int aSc;
    private String aSd;
    private int aSe;
    private int aSf;
    private int aSg;
    private int aSh;
    private String aSi;
    private String aSj;
    public int aSk;
    private String aSl;
    private String aSm;
    private String aSn;
    private boolean aSo;
    private boolean aSp;
    private int aSq;
    private int aSr;
    private int aSs;
    public b aSt;
    public boolean aSu;
    public String aSv;
    public String aSw;
    public a aSx;
    private int aSy;
    public l aSz;
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
        this.aSb = 0;
        this.aSo = false;
    }

    public g(g gVar) {
        this.aSb = 0;
        this.aSo = false;
        if (gVar != null) {
            this.aRX = gVar.aRX;
            this.category_name = gVar.category_name;
            this.aRY = gVar.aRY;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aRZ = gVar.aRZ;
            this.gift_desc = gVar.gift_desc;
            this.aSe = gVar.aSe;
            this.mark_url = gVar.mark_url;
            this.aSf = gVar.aSf;
            this.aSg = gVar.aSg;
            this.aSh = gVar.aSh;
            this.aSi = gVar.aSi;
            this.end_time = gVar.end_time;
            this.aSj = gVar.aSj;
            this.create_time = gVar.create_time;
            this.aSl = gVar.aSl;
            this.discount = gVar.discount;
            this.aSm = gVar.aSm;
            this.aSn = gVar.aSn;
            this.selected = gVar.selected;
            this.aSk = gVar.aSk;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aSz != null) {
                this.aSz = gVar.aSz.clone();
            }
            this.aSq = gVar.aSq;
            this.aSr = gVar.aSr;
            this.aSo = gVar.aSo;
            this.aSa = gVar.aSa;
            this.aSp = gVar.aSp;
            this.aSu = gVar.aSu;
            this.aSv = gVar.aSv;
            this.aSw = gVar.aSw;
            this.aSb = gVar.aSb;
            this.aSc = gVar.aSc;
            this.originalPrice = gVar.originalPrice;
            this.aSd = gVar.aSd;
            this.aSA = gVar.aSA;
        }
    }

    public boolean isRed() {
        return this.aSp;
    }

    public void bn(boolean z) {
        this.aSp = z;
    }

    public String Fd() {
        return this.aRY;
    }

    public String Fe() {
        return this.gift_name;
    }

    public String Ff() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Fp() ? this.aSd : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String Fg() {
        return this.aSl;
    }

    public int Fh() {
        return this.animationType;
    }

    public void gy(String str) {
        this.aRY = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gz(String str) {
        this.aSl = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Fi() {
        return this.aSe;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSt = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRY = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aRZ = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aSl = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aSe = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aSf = jSONObject.optInt("mark_pic_width");
            this.aSg = jSONObject.optInt("mark_pic_height");
            this.aSh = jSONObject.optInt("is_time_limit_gift");
            this.aSj = jSONObject.optString("gift_tip_text");
            this.aSi = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aSm = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aSn = jSONObject.optString("proportion");
            this.aSk = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aSq = jSONObject.optInt("is_dynamic_gift");
            this.aSr = jSONObject.optInt("is_broadcast_gift");
            this.aSy = jSONObject.optInt("gift_type");
            this.aSa = jSONObject.optString("gift_tag");
            this.aSb = jSONObject.optInt("gift_tag_type", 0);
            this.aSc = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aSd = jSONObject.optString("discount_price");
            this.aSo = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aRX = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aSu = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aSv = jSONObject.optString("toast_text");
            this.aSw = jSONObject.optString("toast_jump_url");
            this.aSA = jSONObject.optString("benefit_info");
            this.aSs = jSONObject.optInt("is_pk_gift", 0);
        }
    }

    public void E(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSx = new a(jSONObject);
        }
    }

    public boolean Fj() {
        return this.aSk == 1;
    }

    public boolean Fk() {
        return this.aSe == 7;
    }

    @Deprecated
    public boolean Fl() {
        return this.aSe == 9;
    }

    public String Fm() {
        return this.aSj;
    }

    public boolean Fn() {
        return this.aSe == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Fo() {
        return this.aSq == 1;
    }

    private boolean Fp() {
        return this.aSc == 1;
    }

    public boolean Fq() {
        return this.aSb > 0;
    }

    public boolean Fr() {
        return this.aSb == 3;
    }

    public boolean Fs() {
        return this.aSb == 1;
    }

    public boolean Ft() {
        return this.aSb == 4;
    }

    public boolean Fu() {
        return this.aSb == 5;
    }

    public boolean Fv() {
        return this.aSb == 6;
    }

    public boolean Fw() {
        return this.aSs == 1;
    }

    public boolean Fx() {
        return this.aSb == 2;
    }

    @Deprecated
    public boolean Fy() {
        return this.aSr > 0;
    }

    public int Fz() {
        return this.aSy;
    }

    public boolean FA() {
        return this.aSo;
    }

    public String FB() {
        return this.aSa;
    }

    @Deprecated
    public boolean FC() {
        return this.aSy == 81;
    }

    public boolean FD() {
        return this.aSy >= 2 && this.aSy <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aSF;
        public int aSG;
        public long aSH;
        public String aSI;
        public a aSJ;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aSF = jSONObject.optString("item_type");
                this.aSG = jSONObject.optInt("gift_balance");
                this.aSH = jSONObject.optLong("recent_expire_time");
                this.aSI = jSONObject.optString("recent_gain_channel");
                this.aSJ = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aSK;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aSK = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aSB;
        public String aSC;
        public int aSD;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aSB = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aSC = jSONObject.optString("dynamic_text");
                this.aSD = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
