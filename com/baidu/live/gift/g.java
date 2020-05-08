package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private String ayA;
    private int ayB;
    private int ayC;
    private String ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private String ayI;
    private String ayJ;
    public int ayK;
    private String ayL;
    private String ayM;
    private String ayN;
    private boolean ayO;
    private boolean ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    public a ayT;
    public boolean ayU;
    public String ayV;
    public String ayW;
    private int ayX;
    public l ayY;
    private String ayx;
    private String ayy;
    private String ayz;
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
        this.ayB = 0;
        this.ayO = false;
    }

    public g(g gVar) {
        this.ayB = 0;
        this.ayO = false;
        if (gVar != null) {
            this.ayx = gVar.ayx;
            this.category_name = gVar.category_name;
            this.ayy = gVar.ayy;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.ayz = gVar.ayz;
            this.gift_desc = gVar.gift_desc;
            this.ayE = gVar.ayE;
            this.mark_url = gVar.mark_url;
            this.ayF = gVar.ayF;
            this.ayG = gVar.ayG;
            this.ayH = gVar.ayH;
            this.ayI = gVar.ayI;
            this.end_time = gVar.end_time;
            this.ayJ = gVar.ayJ;
            this.create_time = gVar.create_time;
            this.ayL = gVar.ayL;
            this.discount = gVar.discount;
            this.ayM = gVar.ayM;
            this.ayN = gVar.ayN;
            this.selected = gVar.selected;
            this.ayK = gVar.ayK;
            this.scene_from = gVar.getSceneFrom();
            this.ayQ = gVar.ayQ;
            if (gVar.ayY != null) {
                this.ayY = gVar.ayY.clone();
            }
            this.ayR = gVar.ayR;
            this.ayS = gVar.ayS;
            this.ayO = gVar.ayO;
            this.ayA = gVar.ayA;
            this.ayP = gVar.ayP;
            this.ayU = gVar.ayU;
            this.ayV = gVar.ayV;
            this.ayW = gVar.ayW;
            this.ayB = gVar.ayB;
            this.ayC = gVar.ayC;
            this.originalPrice = gVar.originalPrice;
            this.ayD = gVar.ayD;
        }
    }

    public boolean isRed() {
        return this.ayP;
    }

    public void aV(boolean z) {
        this.ayP = z;
    }

    public String vU() {
        return this.ayy;
    }

    public String vV() {
        return this.gift_name;
    }

    public String vW() {
        return this.gift_desc;
    }

    public String getPrice() {
        return wh() ? this.ayD : this.price;
    }

    public String vX() {
        return this.thumbnail_url;
    }

    public String vY() {
        return this.ayL;
    }

    public int vZ() {
        return this.ayQ;
    }

    public void dW(String str) {
        this.ayy = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void dX(String str) {
        this.ayL = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int wa() {
        return this.ayE;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayT = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayy = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.ayz = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.ayL = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.ayE = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.ayF = jSONObject.optInt("mark_pic_width");
            this.ayG = jSONObject.optInt("mark_pic_height");
            this.ayH = jSONObject.optInt("is_time_limit_gift");
            this.ayJ = jSONObject.optString("gift_tip_text");
            this.ayI = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.ayM = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.ayN = jSONObject.optString("proportion");
            this.ayK = jSONObject.optInt("is_combo");
            this.ayQ = jSONObject.optInt("animation_type");
            this.ayR = jSONObject.optInt("is_dynamic_gift");
            this.ayS = jSONObject.optInt("is_broadcast_gift");
            this.ayX = jSONObject.optInt("gift_type");
            this.ayA = jSONObject.optString("gift_tag");
            this.ayB = jSONObject.optInt("gift_tag_type", 0);
            this.ayC = jSONObject.optInt("is_discount", 0);
            this.originalPrice = jSONObject.optString("original_price");
            this.ayD = jSONObject.optString("discount_price");
            this.ayO = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.ayx = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
            this.ayU = jSONObject.optInt("is_toast_gift", -1) == 1;
            this.ayV = jSONObject.optString("toast_text");
            this.ayW = jSONObject.optString("toast_jump_url");
        }
    }

    public boolean wb() {
        return this.ayK == 1;
    }

    public boolean wc() {
        return this.ayE == 7;
    }

    @Deprecated
    public boolean wd() {
        return this.ayE == 9;
    }

    public String we() {
        return this.ayJ;
    }

    public boolean wf() {
        return this.ayE == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean wg() {
        return this.ayR == 1;
    }

    private boolean wh() {
        return this.ayC == 1;
    }

    public boolean wi() {
        return this.ayB > 0;
    }

    public boolean wj() {
        return this.ayB == 3;
    }

    public boolean wk() {
        return this.ayB == 1;
    }

    public boolean wl() {
        return this.ayB == 4;
    }

    public boolean wm() {
        return this.ayB == 5;
    }

    public boolean wn() {
        return this.ayB == 6;
    }

    public boolean wo() {
        return this.ayB == 2;
    }

    @Deprecated
    public boolean wp() {
        return this.ayS > 0;
    }

    public int wq() {
        return this.ayX;
    }

    public boolean wr() {
        return this.ayO;
    }

    public String ws() {
        return this.ayA;
    }

    @Deprecated
    public boolean wt() {
        return this.ayX == 81;
    }

    public boolean wu() {
        return this.ayX >= 2 && this.ayX <= 12;
    }

    /* loaded from: classes3.dex */
    public class a {
        public String ayZ;
        public int aza;
        public long azb;
        public String azc;
        public C0133a azd;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.ayZ = jSONObject.optString("item_type");
                this.aza = jSONObject.optInt("gift_balance");
                this.azb = jSONObject.optLong("recent_expire_time");
                this.azc = jSONObject.optString("recent_gain_channel");
                this.azd = new C0133a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0133a {
            public JSONObject azf;
            public int key;

            public C0133a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt("key");
                    this.azf = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
