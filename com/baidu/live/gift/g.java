package com.baidu.live.gift;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    private String aWZ;
    public String aXA;
    public a aXB;
    public int aXC;
    public long aXD;
    public k aXE;
    public String aXF;
    public int aXG;
    private String aXa;
    private String aXb;
    private long aXc;
    private String aXd;
    private int aXe;
    private int aXf;
    private String aXg;
    private int aXh;
    private int aXi;
    private int aXj;
    private int aXk;
    private String aXl;
    private String aXm;
    public int aXn;
    private String aXo;
    private String aXp;
    private String aXq;
    private boolean aXr;
    private boolean aXs;
    private int aXt;
    private int aXu;
    private int aXv;
    public boolean aXw;
    public b aXx;
    public boolean aXy;
    public String aXz;
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
        this.aXe = 0;
        this.aXr = false;
        this.aXG = -1;
    }

    public g(g gVar) {
        this.aXe = 0;
        this.aXr = false;
        this.aXG = -1;
        if (gVar != null) {
            this.aWZ = gVar.aWZ;
            this.category_name = gVar.category_name;
            this.aXa = gVar.aXa;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.aXc = gVar.aXc;
            this.price = gVar.price;
            this.aXb = gVar.aXb;
            this.gift_desc = gVar.gift_desc;
            this.aXh = gVar.aXh;
            this.mark_url = gVar.mark_url;
            this.aXi = gVar.aXi;
            this.aXj = gVar.aXj;
            this.aXk = gVar.aXk;
            this.aXl = gVar.aXl;
            this.end_time = gVar.end_time;
            this.aXm = gVar.aXm;
            this.create_time = gVar.create_time;
            this.aXo = gVar.aXo;
            this.discount = gVar.discount;
            this.aXp = gVar.aXp;
            this.aXq = gVar.aXq;
            this.selected = gVar.selected;
            this.aXn = gVar.aXn;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aXE != null) {
                this.aXE = gVar.aXE.clone();
            }
            this.aXt = gVar.aXt;
            this.aXu = gVar.aXu;
            this.aXr = gVar.aXr;
            this.aXd = gVar.aXd;
            this.aXs = gVar.aXs;
            this.aXy = gVar.aXy;
            this.aXz = gVar.aXz;
            this.aXA = gVar.aXA;
            this.aXe = gVar.aXe;
            this.aXf = gVar.aXf;
            this.originalPrice = gVar.originalPrice;
            this.aXg = gVar.aXg;
            this.aXF = gVar.aXF;
        }
    }

    public boolean isRed() {
        return this.aXs;
    }

    public void bA(boolean z) {
        this.aXs = z;
    }

    public String DU() {
        return this.aXa;
    }

    public String DV() {
        return this.gift_name;
    }

    public String DW() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Ej() ? this.aXg : this.price;
    }

    public long DX() {
        return this.aXc;
    }

    public void aN(long j) {
        this.aXc = j;
    }

    public boolean DY() {
        return Ef();
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void fV(String str) {
        this.aXo = str;
    }

    public String DZ() {
        return this.aXo;
    }

    public int Ea() {
        return this.animationType;
    }

    public void fW(String str) {
        this.aXa = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void fX(String str) {
        this.aXo = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Eb() {
        return this.aXh;
    }

    public String Ec() {
        return this.aWZ;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void J(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXx = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXa = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.aXc = jSONObject.optLong("charm_value");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aXb = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aXo = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aXh = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aXi = jSONObject.optInt("mark_pic_width");
            this.aXj = jSONObject.optInt("mark_pic_height");
            this.aXk = jSONObject.optInt("is_time_limit_gift");
            this.aXm = jSONObject.optString("gift_tip_text");
            this.aXl = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aXp = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aXq = jSONObject.optString("proportion");
            this.aXn = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aXt = jSONObject.optInt("is_dynamic_gift");
            this.aXu = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aXd = jSONObject.optString("gift_tag");
            this.aXe = jSONObject.optInt("gift_tag_type", 0);
            this.aXf = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aXg = jSONObject.optString("discount_price");
            this.aXr = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aWZ = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aXy = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aXz = jSONObject.optString("toast_text");
            this.aXA = jSONObject.optString("toast_jump_url");
            this.aXF = jSONObject.optString("benefit_info");
            this.aXv = jSONObject.optInt("is_pk_gift", 0);
            this.aXw = jSONObject.optInt("is_toutiao", 0) == 1;
            this.aXC = jSONObject.optInt("max_send_num", Opcodes.NEWARRAY);
            this.aXD = jSONObject.optLong("luck_draw_id", 188L);
        }
    }

    public void K(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXB = new a(jSONObject);
        }
    }

    public boolean Ed() {
        return this.aXn == 1;
    }

    public boolean Ee() {
        return this.aXh == 7;
    }

    @Deprecated
    public boolean Ef() {
        return this.aXh == 9;
    }

    public String Eg() {
        return this.aXm;
    }

    public void cH(int i) {
        this.aXh = i;
        if (i == 1) {
            this.aXn = 1;
        }
    }

    public boolean Eh() {
        return this.aXh == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Ei() {
        return this.aXt == 1;
    }

    private boolean Ej() {
        return this.aXf == 1;
    }

    public boolean Ek() {
        return this.aXe > 0;
    }

    public boolean El() {
        return this.aXe == 3;
    }

    public boolean Em() {
        return this.aXe == 1;
    }

    public boolean En() {
        return this.aXe == 4;
    }

    public boolean Eo() {
        return this.aXe == 5;
    }

    public boolean Ep() {
        return this.aXe == 6;
    }

    public boolean Eq() {
        return this.aXv == 1;
    }

    public boolean Er() {
        return this.aXe == 2;
    }

    @Deprecated
    public boolean Es() {
        return this.aXu > 0;
    }

    public int Et() {
        return this.gift_type;
    }

    public boolean Eu() {
        return this.aXr;
    }

    public String Ev() {
        return this.aXd;
    }

    @Deprecated
    public boolean Ew() {
        return this.gift_type == 81;
    }

    public boolean Ex() {
        return this.aXh == 10;
    }

    public boolean Ey() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes10.dex */
    public class b {
        public String aXL;
        public int aXM;
        public long aXN;
        public String aXO;
        public a aXP;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aXL = jSONObject.optString("item_type");
                this.aXM = jSONObject.optInt("gift_balance");
                this.aXN = jSONObject.optLong("recent_expire_time");
                this.aXO = jSONObject.optString("recent_gain_channel");
                this.aXP = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes10.dex */
        public class a {
            public JSONObject aXQ;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aXQ = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public boolean aXH;
        public String aXI;
        public int aXJ;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aXH = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aXI = jSONObject.optString("dynamic_text");
                this.aXJ = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
