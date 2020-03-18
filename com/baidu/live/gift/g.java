package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String agA;
    private int agB;
    public l agC;
    private String aga;
    private String agb;
    private String agc;
    private String agd;
    private int agf;
    private int agg;
    private String agh;
    private int agi;
    private int agj;
    private int agk;
    private int agl;
    private String agm;
    private String agn;
    public int ago;
    private String agp;
    private String agq;
    private String agr;
    private boolean ags;
    private boolean agt;
    private int agu;
    private int agv;
    private int agw;
    public a agx;
    public boolean agy;
    public String agz;
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
        this.agf = 0;
        this.ags = false;
    }

    public g(g gVar) {
        this.agf = 0;
        this.ags = false;
        if (gVar != null) {
            this.aga = gVar.aga;
            this.category_name = gVar.category_name;
            this.agb = gVar.agb;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.agc = gVar.agc;
            this.gift_desc = gVar.gift_desc;
            this.agi = gVar.agi;
            this.mark_url = gVar.mark_url;
            this.agj = gVar.agj;
            this.agk = gVar.agk;
            this.agl = gVar.agl;
            this.agm = gVar.agm;
            this.end_time = gVar.end_time;
            this.agn = gVar.agn;
            this.create_time = gVar.create_time;
            this.agp = gVar.agp;
            this.discount = gVar.discount;
            this.agq = gVar.agq;
            this.agr = gVar.agr;
            this.selected = gVar.selected;
            this.ago = gVar.ago;
            this.scene_from = gVar.getSceneFrom();
            this.agu = gVar.agu;
            if (gVar.agC != null) {
                this.agC = gVar.agC.clone();
            }
            this.agv = gVar.agv;
            this.agw = gVar.agw;
            this.ags = gVar.ags;
            this.agd = gVar.agd;
            this.agt = gVar.agt;
            this.agy = gVar.agy;
            this.agz = gVar.agz;
            this.agA = gVar.agA;
            this.agf = gVar.agf;
            this.agg = gVar.agg;
            this.originalPrice = gVar.originalPrice;
            this.agh = gVar.agh;
        }
    }

    public boolean isRed() {
        return this.agt;
    }

    public void ax(boolean z) {
        this.agt = z;
    }

    public String rC() {
        return this.agb;
    }

    public String rD() {
        return this.gift_name;
    }

    public String rE() {
        return this.gift_desc;
    }

    public String getPrice() {
        return rP() ? this.agh : this.price;
    }

    public String rF() {
        return this.thumbnail_url;
    }

    public String rG() {
        return this.agp;
    }

    public int rH() {
        return this.agu;
    }

    public void df(String str) {
        this.agb = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void dg(String str) {
        this.agp = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int rI() {
        return this.agi;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.agx = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.agb = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.agc = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.agp = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.agi = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.agj = jSONObject.optInt("mark_pic_width");
            this.agk = jSONObject.optInt("mark_pic_height");
            this.agl = jSONObject.optInt("is_time_limit_gift");
            this.agn = jSONObject.optString("gift_tip_text");
            this.agm = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.agq = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.agr = jSONObject.optString("proportion");
            this.ago = jSONObject.optInt("is_combo");
            this.agu = jSONObject.optInt("animation_type");
            this.agv = jSONObject.optInt("is_dynamic_gift");
            this.agw = jSONObject.optInt("is_broadcast_gift");
            this.agB = jSONObject.optInt("gift_type");
            this.agd = jSONObject.optString("gift_tag");
            this.agf = jSONObject.optInt("gift_tag_type", 0);
            this.agg = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.agh = jSONObject.optString("discount_price");
            this.ags = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.aga = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.agy = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.agz = jSONObject.optString("toast_text");
            this.agA = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean rJ() {
        return this.ago == 1;
    }

    @Deprecated
    public boolean rK() {
        return this.agi == 7;
    }

    @Deprecated
    public boolean rL() {
        return this.agi == 9;
    }

    public String rM() {
        return this.agn;
    }

    public boolean rN() {
        return this.agi == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean rO() {
        return this.agv == 1;
    }

    private boolean rP() {
        return this.agg == 1;
    }

    public boolean rQ() {
        return this.agf > 0;
    }

    public boolean rR() {
        return this.agf == 3;
    }

    public boolean rS() {
        return this.agf == 1;
    }

    public boolean rT() {
        return this.agf == 4;
    }

    public boolean rU() {
        return this.agf == 5;
    }

    public boolean rV() {
        return this.agf == 6;
    }

    public boolean rW() {
        return this.agf == 2;
    }

    @Deprecated
    public boolean rX() {
        return this.agw > 0;
    }

    public int rY() {
        return this.agB;
    }

    public boolean rZ() {
        return this.ags;
    }

    public String sa() {
        return this.agd;
    }

    @Deprecated
    public boolean sb() {
        return this.agB == 81;
    }

    public boolean sc() {
        return this.agB >= 2 && this.agB <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String agD;
        public int agE;
        public long agF;
        public String agG;
        public C0086a agH;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.agD = jSONObject.optString("item_type");
                this.agE = jSONObject.optInt("gift_balance");
                this.agF = jSONObject.optLong("recent_expire_time");
                this.agG = jSONObject.optString("recent_gain_channel");
                this.agH = new C0086a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0086a {
            public JSONObject agJ;
            public int key;

            public C0086a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.agJ = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
