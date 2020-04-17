package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private int ayA;
    private int ayB;
    private String ayC;
    private String ayD;
    public int ayE;
    private String ayF;
    private String ayG;
    private String ayH;
    private boolean ayI;
    private boolean ayJ;
    private int ayK;
    private int ayL;
    private int ayM;
    public a ayN;
    public boolean ayO;
    public String ayP;
    public String ayQ;
    private int ayR;
    public l ayS;
    private String ayr;
    private String ays;
    private String ayt;
    private String ayu;
    private int ayv;
    private int ayw;
    private String ayx;
    private int ayy;
    private int ayz;
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
        this.ayv = 0;
        this.ayI = false;
    }

    public g(g gVar) {
        this.ayv = 0;
        this.ayI = false;
        if (gVar != null) {
            this.ayr = gVar.ayr;
            this.category_name = gVar.category_name;
            this.ays = gVar.ays;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.ayt = gVar.ayt;
            this.gift_desc = gVar.gift_desc;
            this.ayy = gVar.ayy;
            this.mark_url = gVar.mark_url;
            this.ayz = gVar.ayz;
            this.ayA = gVar.ayA;
            this.ayB = gVar.ayB;
            this.ayC = gVar.ayC;
            this.end_time = gVar.end_time;
            this.ayD = gVar.ayD;
            this.create_time = gVar.create_time;
            this.ayF = gVar.ayF;
            this.discount = gVar.discount;
            this.ayG = gVar.ayG;
            this.ayH = gVar.ayH;
            this.selected = gVar.selected;
            this.ayE = gVar.ayE;
            this.scene_from = gVar.getSceneFrom();
            this.ayK = gVar.ayK;
            if (gVar.ayS != null) {
                this.ayS = gVar.ayS.clone();
            }
            this.ayL = gVar.ayL;
            this.ayM = gVar.ayM;
            this.ayI = gVar.ayI;
            this.ayu = gVar.ayu;
            this.ayJ = gVar.ayJ;
            this.ayO = gVar.ayO;
            this.ayP = gVar.ayP;
            this.ayQ = gVar.ayQ;
            this.ayv = gVar.ayv;
            this.ayw = gVar.ayw;
            this.originalPrice = gVar.originalPrice;
            this.ayx = gVar.ayx;
        }
    }

    public boolean isRed() {
        return this.ayJ;
    }

    public void aV(boolean z) {
        this.ayJ = z;
    }

    public String vV() {
        return this.ays;
    }

    public String vW() {
        return this.gift_name;
    }

    public String vX() {
        return this.gift_desc;
    }

    public String getPrice() {
        return wi() ? this.ayx : this.price;
    }

    public String vY() {
        return this.thumbnail_url;
    }

    public String vZ() {
        return this.ayF;
    }

    public int wa() {
        return this.ayK;
    }

    public void dW(String str) {
        this.ays = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void dX(String str) {
        this.ayF = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int wb() {
        return this.ayy;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayN = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ays = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.ayt = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.ayF = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.ayy = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.ayz = jSONObject.optInt("mark_pic_width");
            this.ayA = jSONObject.optInt("mark_pic_height");
            this.ayB = jSONObject.optInt("is_time_limit_gift");
            this.ayD = jSONObject.optString("gift_tip_text");
            this.ayC = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.ayG = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.ayH = jSONObject.optString("proportion");
            this.ayE = jSONObject.optInt("is_combo");
            this.ayK = jSONObject.optInt("animation_type");
            this.ayL = jSONObject.optInt("is_dynamic_gift");
            this.ayM = jSONObject.optInt("is_broadcast_gift");
            this.ayR = jSONObject.optInt("gift_type");
            this.ayu = jSONObject.optString("gift_tag");
            this.ayv = jSONObject.optInt("gift_tag_type", 0);
            this.ayw = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.ayx = jSONObject.optString("discount_price");
            this.ayI = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.ayr = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.ayO = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.ayP = jSONObject.optString("toast_text");
            this.ayQ = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean wc() {
        return this.ayE == 1;
    }

    public boolean wd() {
        return this.ayy == 7;
    }

    @Deprecated
    public boolean we() {
        return this.ayy == 9;
    }

    public String wf() {
        return this.ayD;
    }

    public boolean wg() {
        return this.ayy == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean wh() {
        return this.ayL == 1;
    }

    private boolean wi() {
        return this.ayw == 1;
    }

    public boolean wj() {
        return this.ayv > 0;
    }

    public boolean wk() {
        return this.ayv == 3;
    }

    public boolean wl() {
        return this.ayv == 1;
    }

    public boolean wm() {
        return this.ayv == 4;
    }

    public boolean wn() {
        return this.ayv == 5;
    }

    public boolean wo() {
        return this.ayv == 6;
    }

    public boolean wp() {
        return this.ayv == 2;
    }

    @Deprecated
    public boolean wq() {
        return this.ayM > 0;
    }

    public int wr() {
        return this.ayR;
    }

    public boolean ws() {
        return this.ayI;
    }

    public String wt() {
        return this.ayu;
    }

    @Deprecated
    public boolean wu() {
        return this.ayR == 81;
    }

    public boolean wv() {
        return this.ayR >= 2 && this.ayR <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String ayT;
        public int ayU;
        public long ayV;
        public String ayW;
        public C0112a ayX;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.ayT = jSONObject.optString("item_type");
                this.ayU = jSONObject.optInt("gift_balance");
                this.ayV = jSONObject.optLong("recent_expire_time");
                this.ayW = jSONObject.optString("recent_gain_channel");
                this.ayX = new C0112a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0112a {
            public JSONObject ayZ;
            public int key;

            public C0112a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.ayZ = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
