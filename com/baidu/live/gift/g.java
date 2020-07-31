package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private String aHH;
    private String aHI;
    private String aHJ;
    private String aHK;
    private int aHL;
    private int aHM;
    private String aHN;
    private int aHO;
    private int aHP;
    private int aHQ;
    private int aHR;
    private String aHS;
    private String aHT;
    public int aHU;
    private String aHV;
    private String aHW;
    private String aHX;
    private boolean aHY;
    private boolean aHZ;
    private int aIa;
    private int aIb;
    public a aIc;
    public boolean aId;
    public String aIe;
    public String aIf;
    private int aIg;
    public l aIh;
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
        this.aHL = 0;
        this.aHY = false;
    }

    public g(g gVar) {
        this.aHL = 0;
        this.aHY = false;
        if (gVar != null) {
            this.aHH = gVar.aHH;
            this.category_name = gVar.category_name;
            this.aHI = gVar.aHI;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aHJ = gVar.aHJ;
            this.gift_desc = gVar.gift_desc;
            this.aHO = gVar.aHO;
            this.mark_url = gVar.mark_url;
            this.aHP = gVar.aHP;
            this.aHQ = gVar.aHQ;
            this.aHR = gVar.aHR;
            this.aHS = gVar.aHS;
            this.end_time = gVar.end_time;
            this.aHT = gVar.aHT;
            this.create_time = gVar.create_time;
            this.aHV = gVar.aHV;
            this.discount = gVar.discount;
            this.aHW = gVar.aHW;
            this.aHX = gVar.aHX;
            this.selected = gVar.selected;
            this.aHU = gVar.aHU;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aIh != null) {
                this.aIh = gVar.aIh.clone();
            }
            this.aIa = gVar.aIa;
            this.aIb = gVar.aIb;
            this.aHY = gVar.aHY;
            this.aHK = gVar.aHK;
            this.aHZ = gVar.aHZ;
            this.aId = gVar.aId;
            this.aIe = gVar.aIe;
            this.aIf = gVar.aIf;
            this.aHL = gVar.aHL;
            this.aHM = gVar.aHM;
            this.originalPrice = gVar.originalPrice;
            this.aHN = gVar.aHN;
        }
    }

    public boolean isRed() {
        return this.aHZ;
    }

    public void bd(boolean z) {
        this.aHZ = z;
    }

    public String yo() {
        return this.aHI;
    }

    public String yp() {
        return this.gift_name;
    }

    public String yq() {
        return this.gift_desc;
    }

    public String getPrice() {
        return yA() ? this.aHN : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String yr() {
        return this.aHV;
    }

    public int ys() {
        return this.animationType;
    }

    public void eI(String str) {
        this.aHI = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void eJ(String str) {
        this.aHV = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int yt() {
        return this.aHO;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIc = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHI = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aHJ = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aHV = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aHO = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aHP = jSONObject.optInt("mark_pic_width");
            this.aHQ = jSONObject.optInt("mark_pic_height");
            this.aHR = jSONObject.optInt("is_time_limit_gift");
            this.aHT = jSONObject.optString("gift_tip_text");
            this.aHS = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aHW = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aHX = jSONObject.optString("proportion");
            this.aHU = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aIa = jSONObject.optInt("is_dynamic_gift");
            this.aIb = jSONObject.optInt("is_broadcast_gift");
            this.aIg = jSONObject.optInt("gift_type");
            this.aHK = jSONObject.optString("gift_tag");
            this.aHL = jSONObject.optInt("gift_tag_type", 0);
            this.aHM = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aHN = jSONObject.optString("discount_price");
            this.aHY = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aHH = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aId = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aIe = jSONObject.optString("toast_text");
            this.aIf = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean yu() {
        return this.aHU == 1;
    }

    public boolean yv() {
        return this.aHO == 7;
    }

    @Deprecated
    public boolean yw() {
        return this.aHO == 9;
    }

    public String yx() {
        return this.aHT;
    }

    public boolean yy() {
        return this.aHO == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean yz() {
        return this.aIa == 1;
    }

    private boolean yA() {
        return this.aHM == 1;
    }

    public boolean yB() {
        return this.aHL > 0;
    }

    public boolean yC() {
        return this.aHL == 3;
    }

    public boolean yD() {
        return this.aHL == 1;
    }

    public boolean yE() {
        return this.aHL == 4;
    }

    public boolean yF() {
        return this.aHL == 5;
    }

    public boolean yG() {
        return this.aHL == 6;
    }

    public boolean yH() {
        return this.aHL == 2;
    }

    @Deprecated
    public boolean yI() {
        return this.aIb > 0;
    }

    public int yJ() {
        return this.aIg;
    }

    public boolean yK() {
        return this.aHY;
    }

    public String yL() {
        return this.aHK;
    }

    @Deprecated
    public boolean yM() {
        return this.aIg == 81;
    }

    public boolean yN() {
        return this.aIg >= 2 && this.aIg <= 12;
    }

    /* loaded from: classes4.dex */
    public class a {
        public String aIi;
        public int aIj;
        public long aIk;
        public String aIl;
        public C0165a aIm;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aIi = jSONObject.optString("item_type");
                this.aIj = jSONObject.optInt("gift_balance");
                this.aIk = jSONObject.optLong("recent_expire_time");
                this.aIl = jSONObject.optString("recent_gain_channel");
                this.aIm = new C0165a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0165a {
            public JSONObject aIo;
            public int key;

            public C0165a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aIo = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
