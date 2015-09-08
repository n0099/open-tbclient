package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends x {
    public static final BdUniqueId Uc = BdUniqueId.gen();
    public static final BdUniqueId Ud = BdUniqueId.gen();
    public static final BdUniqueId Ue = BdUniqueId.gen();
    public static final BdUniqueId Uf = BdUniqueId.gen();
    public static final BdUniqueId Ug = BdUniqueId.gen();
    public int Uh;
    public String Ui;
    public String Uj;
    public int Uk;
    public String Ul;
    public String Um;
    public String Un;
    public int Uo;
    public String Up;
    public String Uq;
    public int Ur;
    public int Us;
    public String Ut;
    public String Uu;
    public long Uv;
    public a Uw = new a();
    public boolean Ux = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean ru() {
        if (this.Uo <= 0 || TextUtils.isEmpty(this.Ui) || TextUtils.isEmpty(this.Ui.trim()) || this.Uk == 2) {
            return false;
        }
        return rv() || rw();
    }

    public boolean rv() {
        return (this.Uk != 3 || TextUtils.isEmpty(this.Un) || TextUtils.isEmpty(this.Um) || TextUtils.isEmpty(this.Un.trim()) || TextUtils.isEmpty(this.Um.trim())) ? false : true;
    }

    public boolean rw() {
        return (this.Uk != 1 || TextUtils.isEmpty(this.Ul) || TextUtils.isEmpty(this.Ul.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Ui = app.id;
            this.Uj = app.name;
            this.Uk = app.url_type.intValue();
            this.Ul = app.url;
            this.Um = app.apk_url;
            this.Un = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Uo = 3;
            } else {
                this.Uo = com.baidu.adp.lib.g.b.g(app.pos_name.trim(), 3);
            }
            this.Up = app.first_name;
            this.Uq = app.second_name;
            this.Ur = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Us = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Ut = app.verify;
            this.price = app.price;
            this.Uu = app.ext_info;
            this.Uv = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Uw.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq b(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Ur);
        builder.da_ext_info = this.Uu;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Uw.Uy);
        builder.da_locate = String.valueOf(this.Uo);
        builder.da_obj_id = this.Ui;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Us);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Ut;
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String UA;
        public String UB;
        public int UC;
        public String UD;
        public String UE;
        public String UF;
        public int Uy;
        public String Uz;
        public String userName;
        public String userPortrait;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Uy = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Uz = goodsInfo.thread_title;
                this.UA = goodsInfo.thread_pic;
                this.UB = goodsInfo.pop_window_text;
                this.UC = goodsInfo.goods_style.intValue();
                this.UD = goodsInfo.card_desc;
                this.UE = goodsInfo.card_tag;
                this.UF = goodsInfo.button_text;
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Uw.UC == 2) {
            return Ud;
        }
        if (this.Uw.UC == 4) {
            if (StringUtils.isNull(this.Uw.UE)) {
                return Ue;
            }
            return Uf;
        } else if (this.Uw.UC == 5) {
            return Ug;
        } else {
            return Uc;
        }
    }
}
