package com.baidu.live.gift;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private String VW;
    private String VX;
    private String VY;
    private int VZ;
    private int Wa;
    private int Wb;
    private int Wc;
    private String Wd;
    private String We;
    private String Wf;
    private String Wg;
    private String Wh;
    public int Wi;
    private int Wj;
    private int Wk;
    private int Wl;
    private boolean Wm;
    private String Wn;
    public a Wo;
    private int Wp;
    public k Wq;
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
        this.Wm = false;
    }

    public g(g gVar) {
        this.Wm = false;
        if (gVar != null) {
            this.VW = gVar.VW;
            this.category_name = gVar.category_name;
            this.VX = gVar.VX;
            this.gift_name = gVar.gift_name;
            this.thumbnail_url = gVar.thumbnail_url;
            this.price = gVar.price;
            this.VY = gVar.VY;
            this.gift_desc = gVar.gift_desc;
            this.VZ = gVar.VZ;
            this.mark_url = gVar.mark_url;
            this.Wa = gVar.Wa;
            this.Wb = gVar.Wb;
            this.Wc = gVar.Wc;
            this.Wd = gVar.Wd;
            this.end_time = gVar.end_time;
            this.We = gVar.We;
            this.create_time = gVar.create_time;
            this.Wf = gVar.Wf;
            this.discount = gVar.discount;
            this.Wg = gVar.Wg;
            this.Wh = gVar.Wh;
            this.selected = gVar.selected;
            this.Wi = gVar.Wi;
            this.scene_from = gVar.getSceneFrom();
            this.Wj = gVar.Wj;
            if (gVar.Wq != null) {
                this.Wq = gVar.Wq.clone();
            }
            this.Wk = gVar.Wk;
            this.Wl = gVar.Wl;
            this.Wm = gVar.Wm;
            this.Wn = gVar.Wn;
        }
    }

    public String pc() {
        return this.VX;
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
        return this.Wf;
    }

    public int ph() {
        return this.Wj;
    }

    public void ce(String str) {
        this.VX = str;
    }

    public void setGiftName(String str) {
        this.gift_name = str;
    }

    public void cf(String str) {
        this.Wf = str;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnail_url = str;
    }

    public int pi() {
        return this.VZ;
    }

    public void setSceneFrom(String str) {
        this.scene_from = str;
    }

    public void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Wo = new a(jSONObject);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.VX = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.gift_name = jSONObject.optString("gift_name");
            this.price = jSONObject.optString("price");
            this.thumbnail_url = jSONObject.optString("thumbnail_url");
            this.VY = jSONObject.optString("ios_price");
            this.create_time = jSONObject.optString("create_time");
            this.Wf = jSONObject.optString("gift_count");
            this.gift_desc = jSONObject.optString("gift_desc");
            this.VZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.mark_url = jSONObject.optString("mark_url");
            this.Wa = jSONObject.optInt("mark_pic_width");
            this.Wb = jSONObject.optInt("mark_pic_height");
            this.Wc = jSONObject.optInt("is_time_limit_gift");
            this.We = jSONObject.optString("gift_tip_text");
            this.Wd = jSONObject.optString("begin_time");
            this.end_time = jSONObject.optString("end_time");
            this.discount = jSONObject.optString("discount");
            this.Wg = jSONObject.optString("ios_discount");
            this.selected = jSONObject.optString("pitch_on");
            this.Wh = jSONObject.optString("proportion");
            this.Wi = jSONObject.optInt("is_combo");
            this.Wj = jSONObject.optInt("animation_type");
            this.Wk = jSONObject.optInt("is_dynamic_gift");
            this.Wl = jSONObject.optInt("is_broadcast_gift");
            this.Wp = jSONObject.optInt("gift_type");
            this.Wn = jSONObject.optString("gift_tag");
            this.Wm = jSONObject.optInt("is_lock") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("category_id");
            if (optJSONObject != null) {
                this.VW = optJSONObject.optString("category_id");
                this.category_name = optJSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            }
        }
    }

    public boolean pj() {
        return this.Wi == 1;
    }

    public boolean pk() {
        return this.VZ == 7;
    }

    public String pl() {
        return this.We;
    }

    public boolean pm() {
        return this.VZ == 6;
    }

    public String getSceneFrom() {
        return this.scene_from;
    }

    public boolean pn() {
        return this.Wk == 1;
    }

    public boolean po() {
        return this.Wl > 0;
    }

    public int pp() {
        return this.Wp;
    }

    public boolean pq() {
        return this.Wm;
    }

    public String pr() {
        return this.Wn;
    }

    public boolean ps() {
        return this.Wp >= 2 && this.Wp <= 12;
    }

    /* loaded from: classes6.dex */
    public class a {
        public String Wr;
        public int Ws;
        public long Wt;
        public String Wu;
        public C0065a Wv;

        public a(JSONObject jSONObject) {
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.Wr = jSONObject.optString("item_type");
                this.Ws = jSONObject.optInt("gift_balance");
                this.Wt = jSONObject.optLong("recent_expire_time");
                this.Wu = jSONObject.optString("recent_gain_channel");
                this.Wv = new C0065a(jSONObject.optJSONObject("type"));
            }
        }

        /* renamed from: com.baidu.live.gift.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0065a {
            public JSONObject Wx;
            public int key;

            public C0065a(JSONObject jSONObject) {
                parseJson(jSONObject);
            }

            private void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.key = jSONObject.optInt(TiebaInitialize.Params.KEY);
                    this.Wx = jSONObject.optJSONObject(Config.EVENT_ATTR);
                }
            }
        }
    }
}
