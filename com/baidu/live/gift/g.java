package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private String aDQ;
    private String aDR;
    private String aDS;
    private String aDT;
    private int aDU;
    private int aDV;
    private String aDW;
    private int aDX;
    private int aDY;
    private int aDZ;
    private int aEa;
    private String aEb;
    private String aEc;
    public int aEd;
    private String aEe;
    private String aEf;
    private String aEg;
    private boolean aEh;
    private boolean aEi;
    private int aEj;
    private int aEk;
    public a aEl;
    public boolean aEm;
    public String aEn;
    public String aEo;
    private int aEp;
    public l aEq;
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
        this.aDU = 0;
        this.aEh = false;
    }

    public g(g gVar) {
        this.aDU = 0;
        this.aEh = false;
        if (gVar != null) {
            this.aDQ = gVar.aDQ;
            this.category_name = gVar.category_name;
            this.aDR = gVar.aDR;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aDS = gVar.aDS;
            this.gift_desc = gVar.gift_desc;
            this.aDX = gVar.aDX;
            this.mark_url = gVar.mark_url;
            this.aDY = gVar.aDY;
            this.aDZ = gVar.aDZ;
            this.aEa = gVar.aEa;
            this.aEb = gVar.aEb;
            this.end_time = gVar.end_time;
            this.aEc = gVar.aEc;
            this.create_time = gVar.create_time;
            this.aEe = gVar.aEe;
            this.discount = gVar.discount;
            this.aEf = gVar.aEf;
            this.aEg = gVar.aEg;
            this.selected = gVar.selected;
            this.aEd = gVar.aEd;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aEq != null) {
                this.aEq = gVar.aEq.clone();
            }
            this.aEj = gVar.aEj;
            this.aEk = gVar.aEk;
            this.aEh = gVar.aEh;
            this.aDT = gVar.aDT;
            this.aEi = gVar.aEi;
            this.aEm = gVar.aEm;
            this.aEn = gVar.aEn;
            this.aEo = gVar.aEo;
            this.aDU = gVar.aDU;
            this.aDV = gVar.aDV;
            this.originalPrice = gVar.originalPrice;
            this.aDW = gVar.aDW;
        }
    }

    public boolean isRed() {
        return this.aEi;
    }

    public void ba(boolean z) {
        this.aEi = z;
    }

    public String xl() {
        return this.aDR;
    }

    public String xm() {
        return this.gift_name;
    }

    public String xn() {
        return this.gift_desc;
    }

    public String getPrice() {
        return xy() ? this.aDW : this.price;
    }

    public String xo() {
        return this.thumbnail_url;
    }

    public String xp() {
        return this.aEe;
    }

    public int xq() {
        return this.animationType;
    }

    public void eD(String str) {
        this.aDR = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void eE(String str) {
        this.aEe = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int xr() {
        return this.aDX;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEl = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDR = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aDS = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aEe = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aDX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aDY = jSONObject.optInt("mark_pic_width");
            this.aDZ = jSONObject.optInt("mark_pic_height");
            this.aEa = jSONObject.optInt("is_time_limit_gift");
            this.aEc = jSONObject.optString("gift_tip_text");
            this.aEb = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aEf = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aEg = jSONObject.optString("proportion");
            this.aEd = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aEj = jSONObject.optInt("is_dynamic_gift");
            this.aEk = jSONObject.optInt("is_broadcast_gift");
            this.aEp = jSONObject.optInt("gift_type");
            this.aDT = jSONObject.optString("gift_tag");
            this.aDU = jSONObject.optInt("gift_tag_type", 0);
            this.aDV = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aDW = jSONObject.optString("discount_price");
            this.aEh = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aDQ = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aEm = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aEn = jSONObject.optString("toast_text");
            this.aEo = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean xs() {
        return this.aEd == 1;
    }

    public boolean xt() {
        return this.aDX == 7;
    }

    @Deprecated
    public boolean xu() {
        return this.aDX == 9;
    }

    public String xv() {
        return this.aEc;
    }

    public boolean xw() {
        return this.aDX == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean xx() {
        return this.aEj == 1;
    }

    private boolean xy() {
        return this.aDV == 1;
    }

    public boolean xz() {
        return this.aDU > 0;
    }

    public boolean xA() {
        return this.aDU == 3;
    }

    public boolean xB() {
        return this.aDU == 1;
    }

    public boolean xC() {
        return this.aDU == 4;
    }

    public boolean xD() {
        return this.aDU == 5;
    }

    public boolean xE() {
        return this.aDU == 6;
    }

    public boolean xF() {
        return this.aDU == 2;
    }

    @Deprecated
    public boolean xG() {
        return this.aEk > 0;
    }

    public int xH() {
        return this.aEp;
    }

    public boolean xI() {
        return this.aEh;
    }

    public String xJ() {
        return this.aDT;
    }

    @Deprecated
    public boolean xK() {
        return this.aEp == 81;
    }

    public boolean xL() {
        return this.aEp >= 2 && this.aEp <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String aEr;
        public int aEs;
        public long aEt;
        public String aEu;
        public C0164a aEv;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aEr = jSONObject.optString("item_type");
                this.aEs = jSONObject.optInt("gift_balance");
                this.aEt = jSONObject.optLong("recent_expire_time");
                this.aEu = jSONObject.optString("recent_gain_channel");
                this.aEv = new C0164a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0164a {
            public JSONObject aEx;
            public int key;

            public C0164a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aEx = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
