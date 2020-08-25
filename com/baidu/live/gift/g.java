package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    private String aMS;
    private String aMT;
    private String aMU;
    private String aMV;
    private int aMW;
    private int aMX;
    private String aMY;
    private int aMZ;
    private int aNa;
    private int aNb;
    private int aNc;
    private String aNd;
    private String aNe;
    public int aNf;
    private String aNg;
    private String aNh;
    private String aNi;
    private boolean aNj;
    private boolean aNk;
    private int aNl;
    private int aNm;
    public a aNn;
    public boolean aNo;
    public String aNp;
    public String aNq;
    private int aNr;
    public l aNs;
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
        this.aMW = 0;
        this.aNj = false;
    }

    public g(g gVar) {
        this.aMW = 0;
        this.aNj = false;
        if (gVar != null) {
            this.aMS = gVar.aMS;
            this.category_name = gVar.category_name;
            this.aMT = gVar.aMT;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.aMU = gVar.aMU;
            this.gift_desc = gVar.gift_desc;
            this.aMZ = gVar.aMZ;
            this.mark_url = gVar.mark_url;
            this.aNa = gVar.aNa;
            this.aNb = gVar.aNb;
            this.aNc = gVar.aNc;
            this.aNd = gVar.aNd;
            this.end_time = gVar.end_time;
            this.aNe = gVar.aNe;
            this.create_time = gVar.create_time;
            this.aNg = gVar.aNg;
            this.discount = gVar.discount;
            this.aNh = gVar.aNh;
            this.aNi = gVar.aNi;
            this.selected = gVar.selected;
            this.aNf = gVar.aNf;
            this.scene_from = gVar.getSceneFrom();
            this.animationType = gVar.animationType;
            if (gVar.aNs != null) {
                this.aNs = gVar.aNs.clone();
            }
            this.aNl = gVar.aNl;
            this.aNm = gVar.aNm;
            this.aNj = gVar.aNj;
            this.aMV = gVar.aMV;
            this.aNk = gVar.aNk;
            this.aNo = gVar.aNo;
            this.aNp = gVar.aNp;
            this.aNq = gVar.aNq;
            this.aMW = gVar.aMW;
            this.aMX = gVar.aMX;
            this.originalPrice = gVar.originalPrice;
            this.aMY = gVar.aMY;
        }
    }

    public boolean isRed() {
        return this.aNk;
    }

    public void bi(boolean z) {
        this.aNk = z;
    }

    public String DR() {
        return this.aMT;
    }

    public String DS() {
        return this.gift_name;
    }

    public String DT() {
        return this.gift_desc;
    }

    public String getPrice() {
        return Ed() ? this.aMY : this.price;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String DU() {
        return this.aNg;
    }

    public int DV() {
        return this.animationType;
    }

    public void gc(String str) {
        this.aMT = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void gd(String str) {
        this.aNg = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int DW() {
        return this.aMZ;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNn = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMT = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.aMU = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.aNg = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.aMZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.aNa = jSONObject.optInt("mark_pic_width");
            this.aNb = jSONObject.optInt("mark_pic_height");
            this.aNc = jSONObject.optInt("is_time_limit_gift");
            this.aNe = jSONObject.optString("gift_tip_text");
            this.aNd = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.aNh = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.aNi = jSONObject.optString("proportion");
            this.aNf = jSONObject.optInt("is_combo");
            this.animationType = jSONObject.optInt("animation_type");
            this.aNl = jSONObject.optInt("is_dynamic_gift");
            this.aNm = jSONObject.optInt("is_broadcast_gift");
            this.aNr = jSONObject.optInt("gift_type");
            this.aMV = jSONObject.optString("gift_tag");
            this.aMW = jSONObject.optInt("gift_tag_type", 0);
            this.aMX = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.aMY = jSONObject.optString("discount_price");
            this.aNj = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aMS = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.aNo = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.aNp = jSONObject.optString("toast_text");
            this.aNq = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean DX() {
        return this.aNf == 1;
    }

    public boolean DY() {
        return this.aMZ == 7;
    }

    @Deprecated
    public boolean DZ() {
        return this.aMZ == 9;
    }

    public String Ea() {
        return this.aNe;
    }

    public boolean Eb() {
        return this.aMZ == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean Ec() {
        return this.aNl == 1;
    }

    private boolean Ed() {
        return this.aMX == 1;
    }

    public boolean Ee() {
        return this.aMW > 0;
    }

    public boolean Ef() {
        return this.aMW == 3;
    }

    public boolean Eg() {
        return this.aMW == 1;
    }

    public boolean Eh() {
        return this.aMW == 4;
    }

    public boolean Ei() {
        return this.aMW == 5;
    }

    public boolean Ej() {
        return this.aMW == 6;
    }

    public boolean Ek() {
        return this.aMW == 2;
    }

    @Deprecated
    public boolean El() {
        return this.aNm > 0;
    }

    public int Em() {
        return this.aNr;
    }

    public boolean En() {
        return this.aNj;
    }

    public String Eo() {
        return this.aMV;
    }

    @Deprecated
    public boolean Ep() {
        return this.aNr == 81;
    }

    public boolean Eq() {
        return this.aNr >= 2 && this.aNr <= 12;
    }

    /* loaded from: classes7.dex */
    public class a {
        public String aNt;
        public int aNu;
        public long aNv;
        public String aNw;
        public C0173a aNx;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aNt = jSONObject.optString("item_type");
                this.aNu = jSONObject.optInt("gift_balance");
                this.aNv = jSONObject.optLong("recent_expire_time");
                this.aNw = jSONObject.optString("recent_gain_channel");
                this.aNx = new C0173a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0173a {
            public JSONObject aNz;
            public int key;

            public C0173a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.aNz = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
