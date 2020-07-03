package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private String aGA;
    private String aGB;
    private String aGC;
    private boolean aGD;
    private boolean aGE;
    private int aGF;
    private int aGG;
    public a aGH;
    public boolean aGI;
    public String aGJ;
    public String aGK;
    private int aGL;
    public l aGM;
    private String aGm;
    private String aGn;
    private String aGo;
    private String aGp;
    private int aGq;
    private int aGr;
    private String aGs;
    private int aGt;
    private int aGu;
    private int aGv;
    private int aGw;
    private String aGx;
    private String aGy;
    public int aGz;
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
        this.aGq = 0;
        this.aGD = false;
    }

    public g(g gVar) {
        this.aGq = 0;
        this.aGD = false;
        if (gVar != null) {
            this.aGm = gVar.aGm;
            this.category_name = gVar.category_name;
            this.aGn = gVar.aGn;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aGo = gVar.aGo;
            this.gift_desc = gVar.gift_desc;
            this.aGt = gVar.aGt;
            this.mark_url = gVar.mark_url;
            this.aGu = gVar.aGu;
            this.aGv = gVar.aGv;
            this.aGw = gVar.aGw;
            this.aGx = gVar.aGx;
            this.end_time = gVar.end_time;
            this.aGy = gVar.aGy;
            this.create_time = gVar.create_time;
            this.aGA = gVar.aGA;
            this.discount = gVar.discount;
            this.aGB = gVar.aGB;
            this.aGC = gVar.aGC;
            this.selected = gVar.selected;
            this.aGz = gVar.aGz;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aGM != null) {
                this.aGM = gVar.aGM.clone();
            }
            this.aGF = gVar.aGF;
            this.aGG = gVar.aGG;
            this.aGD = gVar.aGD;
            this.aGp = gVar.aGp;
            this.aGE = gVar.aGE;
            this.aGI = gVar.aGI;
            this.aGJ = gVar.aGJ;
            this.aGK = gVar.aGK;
            this.aGq = gVar.aGq;
            this.aGr = gVar.aGr;
            this.originalPrice = gVar.originalPrice;
            this.aGs = gVar.aGs;
        }
    }

    public boolean isRed() {
        return this.aGE;
    }

    public void ba(boolean z) {
        this.aGE = z;
    }

    public String xM() {
        return this.aGn;
    }

    public String xN() {
        return this.gift_name;
    }

    public String xO() {
        return this.gift_desc;
    }

    public String getPrice() {
        return xY() ? this.aGs : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String xP() {
        return this.aGA;
    }

    public int xQ() {
        return this.animationType;
    }

    public void eJ(String str) {
        this.aGn = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void eK(String str) {
        this.aGA = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int xR() {
        return this.aGt;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGH = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGn = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aGo = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aGA = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aGt = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aGu = jSONObject.optInt("mark_pic_width");
            this.aGv = jSONObject.optInt("mark_pic_height");
            this.aGw = jSONObject.optInt("is_time_limit_gift");
            this.aGy = jSONObject.optString("gift_tip_text");
            this.aGx = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aGB = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aGC = jSONObject.optString("proportion");
            this.aGz = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aGF = jSONObject.optInt("is_dynamic_gift");
            this.aGG = jSONObject.optInt("is_broadcast_gift");
            this.aGL = jSONObject.optInt("gift_type");
            this.aGp = jSONObject.optString("gift_tag");
            this.aGq = jSONObject.optInt("gift_tag_type", 0);
            this.aGr = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aGs = jSONObject.optString("discount_price");
            this.aGD = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aGm = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aGI = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aGJ = jSONObject.optString("toast_text");
            this.aGK = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean xS() {
        return this.aGz == 1;
    }

    public boolean xT() {
        return this.aGt == 7;
    }

    @Deprecated
    public boolean xU() {
        return this.aGt == 9;
    }

    public String xV() {
        return this.aGy;
    }

    public boolean xW() {
        return this.aGt == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean xX() {
        return this.aGF == 1;
    }

    private boolean xY() {
        return this.aGr == 1;
    }

    public boolean xZ() {
        return this.aGq > 0;
    }

    public boolean ya() {
        return this.aGq == 3;
    }

    public boolean yb() {
        return this.aGq == 1;
    }

    public boolean yc() {
        return this.aGq == 4;
    }

    public boolean yd() {
        return this.aGq == 5;
    }

    public boolean ye() {
        return this.aGq == 6;
    }

    public boolean yf() {
        return this.aGq == 2;
    }

    @Deprecated
    public boolean yg() {
        return this.aGG > 0;
    }

    public int yh() {
        return this.aGL;
    }

    public boolean yi() {
        return this.aGD;
    }

    public String yj() {
        return this.aGp;
    }

    @Deprecated
    public boolean yk() {
        return this.aGL == 81;
    }

    public boolean yl() {
        return this.aGL >= 2 && this.aGL <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String aGN;
        public int aGO;
        public long aGP;
        public String aGQ;
        public C0166a aGR;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aGN = jSONObject.optString("item_type");
                this.aGO = jSONObject.optInt("gift_balance");
                this.aGP = jSONObject.optLong("recent_expire_time");
                this.aGQ = jSONObject.optString("recent_gain_channel");
                this.aGR = new C0166a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0166a {
            public JSONObject aGT;
            public int key;

            public C0166a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aGT = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
