package com.baidu.live.gift;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    private int aSA;
    private String aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private String aSG;
    private String aSH;
    public int aSI;
    private String aSJ;
    private String aSK;
    private String aSL;
    private boolean aSM;
    private boolean aSN;
    private int aSO;
    private int aSP;
    private int aSQ;
    public boolean aSR;
    public b aSS;
    public boolean aST;
    public String aSU;
    public String aSV;
    public a aSW;
    public int aSX;
    public long aSY;
    public k aSZ;
    private String aSv;
    private String aSw;
    private String aSx;
    private String aSy;
    private int aSz;
    public String aTa;
    public int aTb;
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

    public void setPrice(String str) {
        this.price = str;
    }

    public g() {
        this.aSz = 0;
        this.aSM = false;
        this.aTb = -1;
    }

    public g(g gVar) {
        this.aSz = 0;
        this.aSM = false;
        this.aTb = -1;
        if (gVar != null) {
            this.aSv = gVar.aSv;
            this.category_name = gVar.category_name;
            this.aSw = gVar.aSw;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aSx = gVar.aSx;
            this.gift_desc = gVar.gift_desc;
            this.aSC = gVar.aSC;
            this.mark_url = gVar.mark_url;
            this.aSD = gVar.aSD;
            this.aSE = gVar.aSE;
            this.aSF = gVar.aSF;
            this.aSG = gVar.aSG;
            this.end_time = gVar.end_time;
            this.aSH = gVar.aSH;
            this.create_time = gVar.create_time;
            this.aSJ = gVar.aSJ;
            this.discount = gVar.discount;
            this.aSK = gVar.aSK;
            this.aSL = gVar.aSL;
            this.selected = gVar.selected;
            this.aSI = gVar.aSI;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aSZ != null) {
                this.aSZ = gVar.aSZ.clone();
            }
            this.aSO = gVar.aSO;
            this.aSP = gVar.aSP;
            this.aSM = gVar.aSM;
            this.aSy = gVar.aSy;
            this.aSN = gVar.aSN;
            this.aST = gVar.aST;
            this.aSU = gVar.aSU;
            this.aSV = gVar.aSV;
            this.aSz = gVar.aSz;
            this.aSA = gVar.aSA;
            this.originalPrice = gVar.originalPrice;
            this.aSB = gVar.aSB;
            this.aTa = gVar.aTa;
        }
    }

    public boolean isRed() {
        return this.aSN;
    }

    public void bv(boolean z) {
        this.aSN = z;
    }

    public String CC() {
        return this.aSw;
    }

    public String CD() {
        return this.gift_name;
    }

    public String CE() {
        return this.gift_desc;
    }

    public String getPrice() {
        return CQ() ? this.aSB : this.price;
    }

    public boolean CF() {
        return CM();
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void fu(String str) {
        this.aSJ = str;
    }

    public String CG() {
        return this.aSJ;
    }

    public int CH() {
        return this.animationType;
    }

    public void fv(String str) {
        this.aSw = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void fw(String str) {
        this.aSJ = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int CI() {
        return this.aSC;
    }

    public String CJ() {
        return this.aSv;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void H(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSS = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSw = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aSx = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aSJ = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aSC = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aSD = jSONObject.optInt("mark_pic_width");
            this.aSE = jSONObject.optInt("mark_pic_height");
            this.aSF = jSONObject.optInt("is_time_limit_gift");
            this.aSH = jSONObject.optString("gift_tip_text");
            this.aSG = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aSK = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aSL = jSONObject.optString("proportion");
            this.aSI = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aSO = jSONObject.optInt("is_dynamic_gift");
            this.aSP = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aSy = jSONObject.optString("gift_tag");
            this.aSz = jSONObject.optInt("gift_tag_type", 0);
            this.aSA = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aSB = jSONObject.optString("discount_price");
            this.aSM = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aSv = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aST = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aSU = jSONObject.optString("toast_text");
            this.aSV = jSONObject.optString("toast_jump_url");
            this.aTa = jSONObject.optString("benefit_info");
            this.aSQ = jSONObject.optInt("is_pk_gift", 0);
            this.aSR = jSONObject.optInt("is_toutiao", 0) == 1;
            this.aSX = jSONObject.optInt("max_send_num", Opcodes.NEWARRAY);
            this.aSY = jSONObject.optLong("luck_draw_id", 188L);
        }
    }

    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSW = new a(jSONObject);
        }
    }

    public boolean CK() {
        return this.aSI == 1;
    }

    public boolean CL() {
        return this.aSC == 7;
    }

    @Deprecated
    public boolean CM() {
        return this.aSC == 9;
    }

    public String CN() {
        return this.aSH;
    }

    public void cB(int i) {
        this.aSC = i;
        if (i == 1) {
            this.aSI = 1;
        }
    }

    public boolean CO() {
        return this.aSC == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean CP() {
        return this.aSO == 1;
    }

    private boolean CQ() {
        return this.aSA == 1;
    }

    public boolean CR() {
        return this.aSz > 0;
    }

    public boolean CS() {
        return this.aSz == 3;
    }

    public boolean CT() {
        return this.aSz == 1;
    }

    public boolean CU() {
        return this.aSz == 4;
    }

    public boolean CV() {
        return this.aSz == 5;
    }

    public boolean CW() {
        return this.aSz == 6;
    }

    public boolean CX() {
        return this.aSQ == 1;
    }

    public boolean CY() {
        return this.aSz == 2;
    }

    @Deprecated
    public boolean CZ() {
        return this.aSP > 0;
    }

    public int Da() {
        return this.gift_type;
    }

    public boolean Db() {
        return this.aSM;
    }

    public String Dc() {
        return this.aSy;
    }

    @Deprecated
    public boolean Dd() {
        return this.gift_type == 81;
    }

    public boolean De() {
        return this.aSC == 10;
    }

    public boolean Df() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes10.dex */
    public class b {
        public String aTg;
        public int aTh;
        public long aTi;
        public String aTj;
        public a aTk;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTg = jSONObject.optString("item_type");
                this.aTh = jSONObject.optInt("gift_balance");
                this.aTi = jSONObject.optLong("recent_expire_time");
                this.aTj = jSONObject.optString("recent_gain_channel");
                this.aTk = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes10.dex */
        public class a {
            public JSONObject aTl;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aTl = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public boolean aTc;
        public String aTd;
        public int aTe;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aTc = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aTd = jSONObject.optString("dynamic_text");
                this.aTe = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
