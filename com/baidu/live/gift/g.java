package com.baidu.live.gift;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    private String aVA;
    private String aVB;
    private long aVC;
    private String aVD;
    private int aVE;
    private int aVF;
    private String aVG;
    private int aVH;
    private int aVI;
    private int aVJ;
    private int aVK;
    private String aVL;
    private String aVM;
    public int aVN;
    private String aVO;
    private String aVP;
    private String aVQ;
    private boolean aVR;
    private boolean aVS;
    private int aVT;
    private int aVU;
    private int aVV;
    public boolean aVW;
    public b aVX;
    public boolean aVY;
    public String aVZ;
    private String aVz;
    public String aWa;
    public a aWb;
    public int aWc;
    public long aWd;
    public k aWe;
    public String aWf;
    public int aWg;
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
        this.aVE = 0;
        this.aVR = false;
        this.aWg = -1;
    }

    public g(g gVar) {
        this.aVE = 0;
        this.aVR = false;
        this.aWg = -1;
        if (gVar != null) {
            this.aVz = gVar.aVz;
            this.category_name = gVar.category_name;
            this.aVA = gVar.aVA;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.aVC = gVar.aVC;
            this.price = gVar.price;
            this.aVB = gVar.aVB;
            this.gift_desc = gVar.gift_desc;
            this.aVH = gVar.aVH;
            this.mark_url = gVar.mark_url;
            this.aVI = gVar.aVI;
            this.aVJ = gVar.aVJ;
            this.aVK = gVar.aVK;
            this.aVL = gVar.aVL;
            this.end_time = gVar.end_time;
            this.aVM = gVar.aVM;
            this.create_time = gVar.create_time;
            this.aVO = gVar.aVO;
            this.discount = gVar.discount;
            this.aVP = gVar.aVP;
            this.aVQ = gVar.aVQ;
            this.selected = gVar.selected;
            this.aVN = gVar.aVN;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aWe != null) {
                this.aWe = gVar.aWe.clone();
            }
            this.aVT = gVar.aVT;
            this.aVU = gVar.aVU;
            this.aVR = gVar.aVR;
            this.aVD = gVar.aVD;
            this.aVS = gVar.aVS;
            this.aVY = gVar.aVY;
            this.aVZ = gVar.aVZ;
            this.aWa = gVar.aWa;
            this.aVE = gVar.aVE;
            this.aVF = gVar.aVF;
            this.originalPrice = gVar.originalPrice;
            this.aVG = gVar.aVG;
            this.aWf = gVar.aWf;
        }
    }

    public boolean isRed() {
        return this.aVS;
    }

    public void bA(boolean z) {
        this.aVS = z;
    }

    public String DR() {
        return this.aVA;
    }

    public String DS() {
        return this.gift_name;
    }

    public String DT() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Eg() ? this.aVG : this.price;
    }

    public long DU() {
        return this.aVC;
    }

    public void aN(long j) {
        this.aVC = j;
    }

    public boolean DV() {
        return Ec();
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void fP(String str) {
        this.aVO = str;
    }

    public String DW() {
        return this.aVO;
    }

    public int DX() {
        return this.animationType;
    }

    public void fQ(String str) {
        this.aVA = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void fR(String str) {
        this.aVO = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int DY() {
        return this.aVH;
    }

    public String DZ() {
        return this.aVz;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void H(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aVX = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aVA = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.aVC = jSONObject.optLong("charm_value");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aVB = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aVO = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aVH = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aVI = jSONObject.optInt("mark_pic_width");
            this.aVJ = jSONObject.optInt("mark_pic_height");
            this.aVK = jSONObject.optInt("is_time_limit_gift");
            this.aVM = jSONObject.optString("gift_tip_text");
            this.aVL = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aVP = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aVQ = jSONObject.optString("proportion");
            this.aVN = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aVT = jSONObject.optInt("is_dynamic_gift");
            this.aVU = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aVD = jSONObject.optString("gift_tag");
            this.aVE = jSONObject.optInt("gift_tag_type", 0);
            this.aVF = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aVG = jSONObject.optString("discount_price");
            this.aVR = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aVz = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aVY = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aVZ = jSONObject.optString("toast_text");
            this.aWa = jSONObject.optString("toast_jump_url");
            this.aWf = jSONObject.optString("benefit_info");
            this.aVV = jSONObject.optInt("is_pk_gift", 0);
            this.aVW = jSONObject.optInt("is_toutiao", 0) == 1;
            this.aWc = jSONObject.optInt("max_send_num", Opcodes.NEWARRAY);
            this.aWd = jSONObject.optLong("luck_draw_id", 188L);
        }
    }

    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aWb = new a(jSONObject);
        }
    }

    public boolean Ea() {
        return this.aVN == 1;
    }

    public boolean Eb() {
        return this.aVH == 7;
    }

    @Deprecated
    public boolean Ec() {
        return this.aVH == 9;
    }

    public String Ed() {
        return this.aVM;
    }

    public void cG(int i) {
        this.aVH = i;
        if (i == 1) {
            this.aVN = 1;
        }
    }

    public boolean Ee() {
        return this.aVH == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Ef() {
        return this.aVT == 1;
    }

    private boolean Eg() {
        return this.aVF == 1;
    }

    public boolean Eh() {
        return this.aVE > 0;
    }

    public boolean Ei() {
        return this.aVE == 3;
    }

    public boolean Ej() {
        return this.aVE == 1;
    }

    public boolean Ek() {
        return this.aVE == 4;
    }

    public boolean El() {
        return this.aVE == 5;
    }

    public boolean Em() {
        return this.aVE == 6;
    }

    public boolean En() {
        return this.aVV == 1;
    }

    public boolean Eo() {
        return this.aVE == 2;
    }

    @Deprecated
    public boolean Ep() {
        return this.aVU > 0;
    }

    public int Eq() {
        return this.gift_type;
    }

    public boolean Er() {
        return this.aVR;
    }

    public String Es() {
        return this.aVD;
    }

    @Deprecated
    public boolean Et() {
        return this.gift_type == 81;
    }

    public boolean Eu() {
        return this.aVH == 10;
    }

    public boolean Ev() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes11.dex */
    public class b {
        public String aWl;
        public int aWm;
        public long aWn;
        public String aWo;
        public a aWp;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aWl = jSONObject.optString("item_type");
                this.aWm = jSONObject.optInt("gift_balance");
                this.aWn = jSONObject.optLong("recent_expire_time");
                this.aWo = jSONObject.optString("recent_gain_channel");
                this.aWp = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes11.dex */
        public class a {
            public JSONObject aWq;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aWq = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public boolean aWh;
        public String aWi;
        public int aWj;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aWh = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aWi = jSONObject.optString("dynamic_text");
                this.aWj = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
