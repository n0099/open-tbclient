package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends v {
    public static final BdUniqueId Ub = BdUniqueId.gen();
    public static final BdUniqueId Uc = BdUniqueId.gen();
    public static final BdUniqueId Ud = BdUniqueId.gen();
    public static final BdUniqueId Ue = BdUniqueId.gen();
    public static final BdUniqueId Uf = BdUniqueId.gen();
    public int Ug;
    public String Uh;
    public String Ui;
    public int Uj;
    public String Uk;
    public String Ul;
    public String Um;
    public int Un;
    public String Uo;
    public String Up;
    public int Uq;
    public int Ur;
    public String Us;
    public String Ut;
    public long Uu;
    public a Uv = new a();
    public boolean Uw = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean rv() {
        if (this.Un <= 0 || TextUtils.isEmpty(this.Uh) || TextUtils.isEmpty(this.Uh.trim()) || this.Uj == 2) {
            return false;
        }
        return rw() || rx();
    }

    public boolean rw() {
        return (this.Uj != 3 || TextUtils.isEmpty(this.Um) || TextUtils.isEmpty(this.Ul) || TextUtils.isEmpty(this.Um.trim()) || TextUtils.isEmpty(this.Ul.trim())) ? false : true;
    }

    public boolean rx() {
        return (this.Uj != 1 || TextUtils.isEmpty(this.Uk) || TextUtils.isEmpty(this.Uk.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Uh = app.id;
            this.Ui = app.name;
            this.Uj = app.url_type.intValue();
            this.Uk = app.url;
            this.Ul = app.apk_url;
            this.Um = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Un = 3;
            } else {
                this.Un = com.baidu.adp.lib.g.b.g(app.pos_name.trim(), 3);
            }
            this.Uo = app.first_name;
            this.Up = app.second_name;
            this.Uq = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Ur = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Us = app.verify;
            this.price = app.price;
            this.Ut = app.ext_info;
            this.Uu = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Uv.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq b(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Uq);
        builder.da_ext_info = this.Ut;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Uv.Ux);
        builder.da_locate = String.valueOf(this.Un);
        builder.da_obj_id = this.Uh;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Ur);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Us;
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String UA;
        public int UB;
        public String UC;
        public String UD;
        public String UE;
        public int Ux;
        public String Uy;
        public String Uz;
        public String userName;
        public String userPortrait;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Ux = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Uy = goodsInfo.thread_title;
                this.Uz = goodsInfo.thread_pic;
                this.UA = goodsInfo.pop_window_text;
                this.UB = goodsInfo.goods_style.intValue();
                this.UC = goodsInfo.card_desc;
                this.UD = goodsInfo.card_tag;
                this.UE = goodsInfo.button_text;
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Uv.UB == 2) {
            return Uc;
        }
        if (this.Uv.UB == 4) {
            if (StringUtils.isNull(this.Uv.UD)) {
                return Ud;
            }
            return Ue;
        } else if (this.Uv.UB == 5) {
            return Uf;
        } else {
            return Ub;
        }
    }
}
