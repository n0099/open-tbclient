package com.baidu.live.gift;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private boolean aXA;
    private int aXB;
    private int aXC;
    private int aXD;
    public boolean aXE;
    public b aXF;
    public boolean aXG;
    public String aXH;
    public String aXI;
    public a aXJ;
    public int aXK;
    public long aXL;
    public k aXM;
    public String aXN;
    public int aXO;
    private String aXi;
    private String aXj;
    private String aXk;
    private String aXl;
    private int aXm;
    private int aXn;
    private String aXo;
    private int aXp;
    private int aXq;
    private int aXr;
    private int aXs;
    private String aXt;
    private String aXu;
    public int aXv;
    private String aXw;
    private String aXx;
    private String aXy;
    private boolean aXz;
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
        this.aXm = 0;
        this.aXz = false;
        this.aXO = -1;
    }

    public g(g gVar) {
        this.aXm = 0;
        this.aXz = false;
        this.aXO = -1;
        if (gVar != null) {
            this.aXi = gVar.aXi;
            this.category_name = gVar.category_name;
            this.aXj = gVar.aXj;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aXk = gVar.aXk;
            this.gift_desc = gVar.gift_desc;
            this.aXp = gVar.aXp;
            this.mark_url = gVar.mark_url;
            this.aXq = gVar.aXq;
            this.aXr = gVar.aXr;
            this.aXs = gVar.aXs;
            this.aXt = gVar.aXt;
            this.end_time = gVar.end_time;
            this.aXu = gVar.aXu;
            this.create_time = gVar.create_time;
            this.aXw = gVar.aXw;
            this.discount = gVar.discount;
            this.aXx = gVar.aXx;
            this.aXy = gVar.aXy;
            this.selected = gVar.selected;
            this.aXv = gVar.aXv;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aXM != null) {
                this.aXM = gVar.aXM.clone();
            }
            this.aXB = gVar.aXB;
            this.aXC = gVar.aXC;
            this.aXz = gVar.aXz;
            this.aXl = gVar.aXl;
            this.aXA = gVar.aXA;
            this.aXG = gVar.aXG;
            this.aXH = gVar.aXH;
            this.aXI = gVar.aXI;
            this.aXm = gVar.aXm;
            this.aXn = gVar.aXn;
            this.originalPrice = gVar.originalPrice;
            this.aXo = gVar.aXo;
            this.aXN = gVar.aXN;
        }
    }

    public boolean isRed() {
        return this.aXA;
    }

    public void bz(boolean z) {
        this.aXA = z;
    }

    public String Gx() {
        return this.aXj;
    }

    public String Gy() {
        return this.gift_name;
    }

    public String Gz() {
        return this.gift_desc;
    }

    public String getPrice() {
        return GL() ? this.aXo : this.price;
    }

    public boolean GA() {
        return GH();
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void gG(String str) {
        this.aXw = str;
    }

    public String GB() {
        return this.aXw;
    }

    public int GC() {
        return this.animationType;
    }

    public void gH(String str) {
        this.aXj = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gI(String str) {
        this.aXw = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int GD() {
        return this.aXp;
    }

    public String GE() {
        return this.aXi;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void H(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXF = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXj = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aXk = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aXw = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aXp = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aXq = jSONObject.optInt("mark_pic_width");
            this.aXr = jSONObject.optInt("mark_pic_height");
            this.aXs = jSONObject.optInt("is_time_limit_gift");
            this.aXu = jSONObject.optString("gift_tip_text");
            this.aXt = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aXx = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aXy = jSONObject.optString("proportion");
            this.aXv = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aXB = jSONObject.optInt("is_dynamic_gift");
            this.aXC = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aXl = jSONObject.optString("gift_tag");
            this.aXm = jSONObject.optInt("gift_tag_type", 0);
            this.aXn = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aXo = jSONObject.optString("discount_price");
            this.aXz = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aXi = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aXG = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aXH = jSONObject.optString("toast_text");
            this.aXI = jSONObject.optString("toast_jump_url");
            this.aXN = jSONObject.optString("benefit_info");
            this.aXD = jSONObject.optInt("is_pk_gift", 0);
            this.aXE = jSONObject.optInt("is_toutiao", 0) == 1;
            this.aXK = jSONObject.optInt("max_send_num", Opcodes.NEWARRAY);
            this.aXL = jSONObject.optLong("luck_draw_id", 188L);
        }
    }

    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXJ = new a(jSONObject);
        }
    }

    public boolean GF() {
        return this.aXv == 1;
    }

    public boolean GG() {
        return this.aXp == 7;
    }

    @Deprecated
    public boolean GH() {
        return this.aXp == 9;
    }

    public String GI() {
        return this.aXu;
    }

    public void eh(int i) {
        this.aXp = i;
        if (i == 1) {
            this.aXv = 1;
        }
    }

    public boolean GJ() {
        return this.aXp == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean GK() {
        return this.aXB == 1;
    }

    private boolean GL() {
        return this.aXn == 1;
    }

    public boolean GM() {
        return this.aXm > 0;
    }

    public boolean GN() {
        return this.aXm == 3;
    }

    public boolean GO() {
        return this.aXm == 1;
    }

    public boolean GP() {
        return this.aXm == 4;
    }

    public boolean GQ() {
        return this.aXm == 5;
    }

    public boolean GR() {
        return this.aXm == 6;
    }

    public boolean GS() {
        return this.aXD == 1;
    }

    public boolean GT() {
        return this.aXm == 2;
    }

    @Deprecated
    public boolean GU() {
        return this.aXC > 0;
    }

    public int GV() {
        return this.gift_type;
    }

    public boolean GW() {
        return this.aXz;
    }

    public String GX() {
        return this.aXl;
    }

    @Deprecated
    public boolean GY() {
        return this.gift_type == 81;
    }

    public boolean GZ() {
        return this.aXp == 10;
    }

    public boolean Ha() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes11.dex */
    public class b {
        public String aXT;
        public int aXU;
        public long aXV;
        public String aXW;
        public a aXX;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aXT = jSONObject.optString("item_type");
                this.aXU = jSONObject.optInt("gift_balance");
                this.aXV = jSONObject.optLong("recent_expire_time");
                this.aXW = jSONObject.optString("recent_gain_channel");
                this.aXX = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes11.dex */
        public class a {
            public JSONObject aXY;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aXY = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public boolean aXP;
        public String aXQ;
        public int aXR;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aXP = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aXQ = jSONObject.optString("dynamic_text");
                this.aXR = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
