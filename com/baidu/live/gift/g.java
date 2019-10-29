package com.baidu.live.gift;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private String WA;
    public int WB;
    private int WC;
    private int WD;
    private int WE;
    private boolean WF;
    private String WG;
    public a WH;
    private int WI;
    public k WJ;
    private String Wp;
    private String Wq;
    private String Wr;
    private int Ws;
    private int Wt;
    private int Wu;
    private int Wv;
    private String Ww;
    private String Wx;
    private String Wy;
    private String Wz;
    private String category_name;
    private String create_time;
    private String discount;
    private String end_time;
    private String gift_desc;
    private String gift_name;
    private String mark_url;
    private String price;
    private String scene_from;
    private String selected;
    private String thumbnail_url;

    public g() {
        this.WF = false;
    }

    public g(g gVar) {
        this.WF = false;
        if (gVar != null) {
            this.Wp = gVar.Wp;
            this.category_name = gVar.category_name;
            this.Wq = gVar.Wq;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.Wr = gVar.Wr;
            this.gift_desc = gVar.gift_desc;
            this.Ws = gVar.Ws;
            this.mark_url = gVar.mark_url;
            this.Wt = gVar.Wt;
            this.Wu = gVar.Wu;
            this.Wv = gVar.Wv;
            this.Ww = gVar.Ww;
            this.end_time = gVar.end_time;
            this.Wx = gVar.Wx;
            this.create_time = gVar.create_time;
            this.Wy = gVar.Wy;
            this.discount = gVar.discount;
            this.Wz = gVar.Wz;
            this.WA = gVar.WA;
            this.selected = gVar.selected;
            this.WB = gVar.WB;
            this.scene_from = gVar.getSceneFrom();
            this.WC = gVar.WC;
            if (gVar.WJ != null) {
                this.WJ = gVar.WJ.clone();
            }
            this.WD = gVar.WD;
            this.WE = gVar.WE;
            this.WF = gVar.WF;
            this.WG = gVar.WG;
        }
    }

    public String pc() {
        return this.Wq;
    }

    public String pd() {
        return this.gift_name;
    }

    public String pe() {
        return this.gift_desc;
    }

    public String getPrice() {
        return this.price;
    }

    public String pf() {
        return this.thumbnail_url;
    }

    public String pg() {
        return this.Wy;
    }

    public int ph() {
        return this.WC;
    }

    public void ce(String str) {
        this.Wq = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void cf(String str) {
        this.Wy = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int pi() {
        return this.Ws;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.WH = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Wq = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.Wr = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.Wy = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.Ws = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.Wt = jSONObject.optInt("mark_pic_width");
            this.Wu = jSONObject.optInt("mark_pic_height");
            this.Wv = jSONObject.optInt("is_time_limit_gift");
            this.Wx = jSONObject.optString("gift_tip_text");
            this.Ww = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.Wz = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.WA = jSONObject.optString("proportion");
            this.WB = jSONObject.optInt("is_combo");
            this.WC = jSONObject.optInt("animation_type");
            this.WD = jSONObject.optInt("is_dynamic_gift");
            this.WE = jSONObject.optInt("is_broadcast_gift");
            this.WI = jSONObject.optInt("gift_type");
            this.WG = jSONObject.optString("gift_tag");
            this.WF = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.Wp = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
        }
    }

    public boolean pj() {
        return this.WB == 1;
    }

    public boolean pk() {
        return this.Ws == 7;
    }

    public String pl() {
        return this.Wx;
    }

    public boolean pm() {
        return this.Ws == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean pn() {
        return this.WD == 1;
    }

    public boolean po() {
        return this.WE > 0;
    }

    public int pp() {
        return this.WI;
    }

    public boolean pq() {
        return this.WF;
    }

    public String pr() {
        return this.WG;
    }

    public boolean ps() {
        return this.WI >= 2 && this.WI <= 12;
    }

    /* loaded from: classes6.dex */
    public class a {
        public String WK;
        public int WL;
        public long WM;
        public String WN;
        public C0065a WO;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.WK = jSONObject.optString("item_type");
                this.WL = jSONObject.optInt("gift_balance");
                this.WM = jSONObject.optLong("recent_expire_time");
                this.WN = jSONObject.optString("recent_gain_channel");
                this.WO = new C0065a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0065a {
            public JSONObject WQ;
            public int key;

            public C0065a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt(TiebaInitialize.Params.KEY);
                    this.WQ = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
