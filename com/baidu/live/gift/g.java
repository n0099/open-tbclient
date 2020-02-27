package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private String afQ;
    private String afR;
    private String afS;
    private String afT;
    private int afU;
    private int afV;
    private String afW;
    private int afX;
    private int afY;
    private int afZ;
    private int aga;
    private String agb;
    private String agc;
    public int agd;
    private String agf;
    private String agg;
    private String agh;
    private boolean agi;
    private boolean agj;
    private int agk;
    private int agl;
    private int agm;
    public a agn;
    public boolean ago;
    public String agp;
    public String agq;
    private int agr;
    public l ags;
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
        this.afU = 0;
        this.agi = false;
    }

    public g(g gVar) {
        this.afU = 0;
        this.agi = false;
        if (gVar != null) {
            this.afQ = gVar.afQ;
            this.category_name = gVar.category_name;
            this.afR = gVar.afR;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.afS = gVar.afS;
            this.gift_desc = gVar.gift_desc;
            this.afX = gVar.afX;
            this.mark_url = gVar.mark_url;
            this.afY = gVar.afY;
            this.afZ = gVar.afZ;
            this.aga = gVar.aga;
            this.agb = gVar.agb;
            this.end_time = gVar.end_time;
            this.agc = gVar.agc;
            this.create_time = gVar.create_time;
            this.agf = gVar.agf;
            this.discount = gVar.discount;
            this.agg = gVar.agg;
            this.agh = gVar.agh;
            this.selected = gVar.selected;
            this.agd = gVar.agd;
            this.scene_from = gVar.getSceneFrom();
            this.agk = gVar.agk;
            if (gVar.ags != null) {
                this.ags = gVar.ags.clone();
            }
            this.agl = gVar.agl;
            this.agm = gVar.agm;
            this.agi = gVar.agi;
            this.afT = gVar.afT;
            this.agj = gVar.agj;
            this.ago = gVar.ago;
            this.agp = gVar.agp;
            this.agq = gVar.agq;
            this.afU = gVar.afU;
            this.afV = gVar.afV;
            this.originalPrice = gVar.originalPrice;
            this.afW = gVar.afW;
        }
    }

    public boolean isRed() {
        return this.agj;
    }

    public void ax(boolean z) {
        this.agj = z;
    }

    public String rx() {
        return this.afR;
    }

    public String ry() {
        return this.gift_name;
    }

    public String rz() {
        return this.gift_desc;
    }

    public String getPrice() {
        return rK() ? this.afW : this.price;
    }

    public String rA() {
        return this.thumbnail_url;
    }

    public String rB() {
        return this.agf;
    }

    public int rC() {
        return this.agk;
    }

    public void dg(String str) {
        this.afR = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void dh(String str) {
        this.agf = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int rD() {
        return this.afX;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.agn = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.afR = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.afS = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.agf = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.afX = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.afY = jSONObject.optInt("mark_pic_width");
            this.afZ = jSONObject.optInt("mark_pic_height");
            this.aga = jSONObject.optInt("is_time_limit_gift");
            this.agc = jSONObject.optString("gift_tip_text");
            this.agb = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.agg = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.agh = jSONObject.optString("proportion");
            this.agd = jSONObject.optInt("is_combo");
            this.agk = jSONObject.optInt("animation_type");
            this.agl = jSONObject.optInt("is_dynamic_gift");
            this.agm = jSONObject.optInt("is_broadcast_gift");
            this.agr = jSONObject.optInt("gift_type");
            this.afT = jSONObject.optString("gift_tag");
            this.afU = jSONObject.optInt("gift_tag_type", 0);
            this.afV = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.afW = jSONObject.optString("discount_price");
            this.agi = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.afQ = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.ago = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.agp = jSONObject.optString("toast_text");
            this.agq = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean rE() {
        return this.agd == 1;
    }

    @Deprecated
    public boolean rF() {
        return this.afX == 7;
    }

    @Deprecated
    public boolean rG() {
        return this.afX == 9;
    }

    public String rH() {
        return this.agc;
    }

    public boolean rI() {
        return this.afX == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean rJ() {
        return this.agl == 1;
    }

    private boolean rK() {
        return this.afV == 1;
    }

    public boolean rL() {
        return this.afU > 0;
    }

    public boolean rM() {
        return this.afU == 3;
    }

    public boolean rN() {
        return this.afU == 1;
    }

    public boolean rO() {
        return this.afU == 4;
    }

    public boolean rP() {
        return this.afU == 5;
    }

    public boolean rQ() {
        return this.afU == 6;
    }

    public boolean rR() {
        return this.afU == 2;
    }

    @Deprecated
    public boolean rS() {
        return this.agm > 0;
    }

    public int rT() {
        return this.agr;
    }

    public boolean rU() {
        return this.agi;
    }

    public String rV() {
        return this.afT;
    }

    @Deprecated
    public boolean rW() {
        return this.agr == 81;
    }

    public boolean rX() {
        return this.agr >= 2 && this.agr <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String agt;
        public int agu;
        public long agv;
        public String agw;
        public C0086a agx;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.agt = jSONObject.optString("item_type");
                this.agu = jSONObject.optInt("gift_balance");
                this.agv = jSONObject.optLong("recent_expire_time");
                this.agw = jSONObject.optString("recent_gain_channel");
                this.agx = new C0086a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0086a {
            public JSONObject agz;
            public int key;

            public C0086a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.agz = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
