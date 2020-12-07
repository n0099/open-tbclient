package com.baidu.live.gift;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aVC;
    private String aVD;
    private String aVE;
    private String aVF;
    private int aVG;
    private int aVH;
    private String aVI;
    private int aVJ;
    private int aVK;
    private int aVL;
    private int aVM;
    private String aVN;
    private String aVO;
    public int aVP;
    private String aVQ;
    private String aVR;
    private String aVS;
    private boolean aVT;
    private boolean aVU;
    private int aVV;
    private int aVW;
    private int aVX;
    public boolean aVY;
    public b aVZ;
    public boolean aWa;
    public String aWb;
    public String aWc;
    public a aWd;
    public int aWe;
    public long aWf;
    public k aWg;
    public String aWh;
    public int aWi;
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
        this.aVG = 0;
        this.aVT = false;
        this.aWi = -1;
    }

    public g(g gVar) {
        this.aVG = 0;
        this.aVT = false;
        this.aWi = -1;
        if (gVar != null) {
            this.aVC = gVar.aVC;
            this.category_name = gVar.category_name;
            this.aVD = gVar.aVD;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aVE = gVar.aVE;
            this.gift_desc = gVar.gift_desc;
            this.aVJ = gVar.aVJ;
            this.mark_url = gVar.mark_url;
            this.aVK = gVar.aVK;
            this.aVL = gVar.aVL;
            this.aVM = gVar.aVM;
            this.aVN = gVar.aVN;
            this.end_time = gVar.end_time;
            this.aVO = gVar.aVO;
            this.create_time = gVar.create_time;
            this.aVQ = gVar.aVQ;
            this.discount = gVar.discount;
            this.aVR = gVar.aVR;
            this.aVS = gVar.aVS;
            this.selected = gVar.selected;
            this.aVP = gVar.aVP;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aWg != null) {
                this.aWg = gVar.aWg.clone();
            }
            this.aVV = gVar.aVV;
            this.aVW = gVar.aVW;
            this.aVT = gVar.aVT;
            this.aVF = gVar.aVF;
            this.aVU = gVar.aVU;
            this.aWa = gVar.aWa;
            this.aWb = gVar.aWb;
            this.aWc = gVar.aWc;
            this.aVG = gVar.aVG;
            this.aVH = gVar.aVH;
            this.originalPrice = gVar.originalPrice;
            this.aVI = gVar.aVI;
            this.aWh = gVar.aWh;
        }
    }

    public boolean isRed() {
        return this.aVU;
    }

    public void bB(boolean z) {
        this.aVU = z;
    }

    public String GX() {
        return this.aVD;
    }

    public String GY() {
        return this.gift_name;
    }

    public String GZ() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Hk() ? this.aVI : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void gV(String str) {
        this.aVQ = str;
    }

    public String Ha() {
        return this.aVQ;
    }

    public int Hb() {
        return this.animationType;
    }

    public void gW(String str) {
        this.aVD = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gX(String str) {
        this.aVQ = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int Hc() {
        return this.aVJ;
    }

    public String Hd() {
        return this.aVC;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void A(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aVZ = new b(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aVD = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aVE = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aVQ = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aVJ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aVK = jSONObject.optInt("mark_pic_width");
            this.aVL = jSONObject.optInt("mark_pic_height");
            this.aVM = jSONObject.optInt("is_time_limit_gift");
            this.aVO = jSONObject.optString("gift_tip_text");
            this.aVN = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aVR = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aVS = jSONObject.optString("proportion");
            this.aVP = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aVV = jSONObject.optInt("is_dynamic_gift");
            this.aVW = jSONObject.optInt("is_broadcast_gift");
            this.gift_type = jSONObject.optInt("gift_type");
            this.aVF = jSONObject.optString("gift_tag");
            this.aVG = jSONObject.optInt("gift_tag_type", 0);
            this.aVH = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aVI = jSONObject.optString("discount_price");
            this.aVT = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aVC = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aWa = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aWb = jSONObject.optString("toast_text");
            this.aWc = jSONObject.optString("toast_jump_url");
            this.aWh = jSONObject.optString("benefit_info");
            this.aVX = jSONObject.optInt("is_pk_gift", 0);
            this.aVY = jSONObject.optInt("is_toutiao", 0) == 1;
            this.aWe = jSONObject.optInt("max_send_num", Opcodes.NEWARRAY);
            this.aWf = jSONObject.optLong("luck_draw_id", 188L);
        }
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aWd = new a(jSONObject);
        }
    }

    public boolean He() {
        return this.aVP == 1;
    }

    public boolean Hf() {
        return this.aVJ == 7;
    }

    @Deprecated
    public boolean Hg() {
        return this.aVJ == 9;
    }

    public String Hh() {
        return this.aVO;
    }

    public void ej(int i) {
        this.aVJ = i;
        if (i == 1) {
            this.aVP = 1;
        }
    }

    public boolean Hi() {
        return this.aVJ == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Hj() {
        return this.aVV == 1;
    }

    private boolean Hk() {
        return this.aVH == 1;
    }

    public boolean Hl() {
        return this.aVG > 0;
    }

    public boolean Hm() {
        return this.aVG == 3;
    }

    public boolean Hn() {
        return this.aVG == 1;
    }

    public boolean Ho() {
        return this.aVG == 4;
    }

    public boolean Hp() {
        return this.aVG == 5;
    }

    public boolean Hq() {
        return this.aVG == 6;
    }

    public boolean Hr() {
        return this.aVX == 1;
    }

    public boolean Hs() {
        return this.aVG == 2;
    }

    @Deprecated
    public boolean Ht() {
        return this.aVW > 0;
    }

    public int Hu() {
        return this.gift_type;
    }

    public boolean Hv() {
        return this.aVT;
    }

    public String Hw() {
        return this.aVF;
    }

    @Deprecated
    public boolean Hx() {
        return this.gift_type == 81;
    }

    public boolean Hy() {
        return this.aVJ == 10;
    }

    public boolean Hz() {
        return this.gift_type >= 2 && this.gift_type <= 12;
    }

    /* loaded from: classes4.dex */
    public class b {
        public String aWn;
        public int aWo;
        public long aWp;
        public String aWq;
        public a aWr;

        public b(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aWn = jSONObject.optString("item_type");
                this.aWo = jSONObject.optInt("gift_balance");
                this.aWp = jSONObject.optLong("recent_expire_time");
                this.aWq = jSONObject.optString("recent_gain_channel");
                this.aWr = new a(jSONObject.optJSONObject("type"));
            }
        }

        /* loaded from: classes4.dex */
        public class a {
            public JSONObject aWs;
            public int key;

            public a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aWs = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public boolean aWj;
        public String aWk;
        public int aWl;
        public String detailUrl;
        public boolean enabled;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.enabled = jSONObject.optInt("bol_long_press", 0) == 1;
                this.aWj = jSONObject.optInt("bol_dynamic", 0) == 1;
                this.aWk = jSONObject.optString("dynamic_text");
                this.aWl = jSONObject.optInt("screen_type");
                this.detailUrl = jSONObject.optString("screen_url");
            }
        }
    }
}
