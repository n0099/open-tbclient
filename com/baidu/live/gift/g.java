package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    private String aMU;
    private String aMV;
    private String aMW;
    private String aMX;
    private int aMY;
    private int aMZ;
    private String aNa;
    private int aNb;
    private int aNc;
    private int aNd;
    private int aNe;
    private String aNf;
    private String aNg;
    public int aNh;
    private String aNi;
    private String aNj;
    private String aNk;
    private boolean aNl;
    private boolean aNm;
    private int aNn;
    private int aNo;
    public a aNp;
    public boolean aNq;
    public String aNr;
    public String aNs;
    private int aNt;
    public l aNu;
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
        this.aMY = 0;
        this.aNl = false;
    }

    public g(g gVar) {
        this.aMY = 0;
        this.aNl = false;
        if (gVar != null) {
            this.aMU = gVar.aMU;
            this.category_name = gVar.category_name;
            this.aMV = gVar.aMV;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aMW = gVar.aMW;
            this.gift_desc = gVar.gift_desc;
            this.aNb = gVar.aNb;
            this.mark_url = gVar.mark_url;
            this.aNc = gVar.aNc;
            this.aNd = gVar.aNd;
            this.aNe = gVar.aNe;
            this.aNf = gVar.aNf;
            this.end_time = gVar.end_time;
            this.aNg = gVar.aNg;
            this.create_time = gVar.create_time;
            this.aNi = gVar.aNi;
            this.discount = gVar.discount;
            this.aNj = gVar.aNj;
            this.aNk = gVar.aNk;
            this.selected = gVar.selected;
            this.aNh = gVar.aNh;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aNu != null) {
                this.aNu = gVar.aNu.clone();
            }
            this.aNn = gVar.aNn;
            this.aNo = gVar.aNo;
            this.aNl = gVar.aNl;
            this.aMX = gVar.aMX;
            this.aNm = gVar.aNm;
            this.aNq = gVar.aNq;
            this.aNr = gVar.aNr;
            this.aNs = gVar.aNs;
            this.aMY = gVar.aMY;
            this.aMZ = gVar.aMZ;
            this.originalPrice = gVar.originalPrice;
            this.aNa = gVar.aNa;
        }
    }

    public boolean isRed() {
        return this.aNm;
    }

    public void bi(boolean z) {
        this.aNm = z;
    }

    public String DR() {
        return this.aMV;
    }

    public String DS() {
        return this.gift_name;
    }

    public String DT() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Ed() ? this.aNa : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String DU() {
        return this.aNi;
    }

    public int DV() {
        return this.animationType;
    }

    public void gd(String str) {
        this.aMV = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void ge(String str) {
        this.aNi = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int DW() {
        return this.aNb;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNp = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMV = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aMW = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aNi = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aNb = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aNc = jSONObject.optInt("mark_pic_width");
            this.aNd = jSONObject.optInt("mark_pic_height");
            this.aNe = jSONObject.optInt("is_time_limit_gift");
            this.aNg = jSONObject.optString("gift_tip_text");
            this.aNf = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aNj = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aNk = jSONObject.optString("proportion");
            this.aNh = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aNn = jSONObject.optInt("is_dynamic_gift");
            this.aNo = jSONObject.optInt("is_broadcast_gift");
            this.aNt = jSONObject.optInt("gift_type");
            this.aMX = jSONObject.optString("gift_tag");
            this.aMY = jSONObject.optInt("gift_tag_type", 0);
            this.aMZ = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aNa = jSONObject.optString("discount_price");
            this.aNl = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aMU = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aNq = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aNr = jSONObject.optString("toast_text");
            this.aNs = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean DX() {
        return this.aNh == 1;
    }

    public boolean DY() {
        return this.aNb == 7;
    }

    @Deprecated
    public boolean DZ() {
        return this.aNb == 9;
    }

    public String Ea() {
        return this.aNg;
    }

    public boolean Eb() {
        return this.aNb == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Ec() {
        return this.aNn == 1;
    }

    private boolean Ed() {
        return this.aMZ == 1;
    }

    public boolean Ee() {
        return this.aMY > 0;
    }

    public boolean Ef() {
        return this.aMY == 3;
    }

    public boolean Eg() {
        return this.aMY == 1;
    }

    public boolean Eh() {
        return this.aMY == 4;
    }

    public boolean Ei() {
        return this.aMY == 5;
    }

    public boolean Ej() {
        return this.aMY == 6;
    }

    public boolean Ek() {
        return this.aMY == 2;
    }

    @Deprecated
    public boolean El() {
        return this.aNo > 0;
    }

    public int Em() {
        return this.aNt;
    }

    public boolean En() {
        return this.aNl;
    }

    public String Eo() {
        return this.aMX;
    }

    @Deprecated
    public boolean Ep() {
        return this.aNt == 81;
    }

    public boolean Eq() {
        return this.aNt >= 2 && this.aNt <= 12;
    }

    /* loaded from: classes7.dex */
    public class a {
        public String aNv;
        public int aNw;
        public long aNx;
        public String aNy;
        public C0173a aNz;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aNv = jSONObject.optString("item_type");
                this.aNw = jSONObject.optInt("gift_balance");
                this.aNx = jSONObject.optLong("recent_expire_time");
                this.aNy = jSONObject.optString("recent_gain_channel");
                this.aNz = new C0173a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0173a {
            public JSONObject aNB;
            public int key;

            public C0173a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aNB = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
