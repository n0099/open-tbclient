package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends x {
    public static final BdUniqueId Dh = BdUniqueId.gen();
    public static final BdUniqueId Di = BdUniqueId.gen();
    public int Dj;
    public String Dk;
    public String Dl;
    public int Dm;
    public String Dn;
    public String Do;
    public String Dp;
    public int Dq;
    public String Dr;
    public String Ds;
    public int Dt;
    public int Du;
    public String Dv;
    public String Dw;
    public long Dx;
    public d Dy = new d();
    public boolean Dz = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean mn() {
        if (this.Dq <= 0 || TextUtils.isEmpty(this.Dk) || TextUtils.isEmpty(this.Dk.trim()) || this.Dm == 2) {
            return false;
        }
        return mo() || mp();
    }

    public boolean mo() {
        return (this.Dm != 3 || TextUtils.isEmpty(this.Dp) || TextUtils.isEmpty(this.Do) || TextUtils.isEmpty(this.Dp.trim()) || TextUtils.isEmpty(this.Do.trim())) ? false : true;
    }

    public boolean mp() {
        return (this.Dm != 1 || TextUtils.isEmpty(this.Dn) || TextUtils.isEmpty(this.Dn.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Dk = app.id;
            this.Dl = app.name;
            this.Dm = app.url_type.intValue();
            this.Dn = app.url;
            this.Do = app.apk_url;
            this.Dp = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Dq = 3;
            } else {
                this.Dq = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Dr = app.first_name;
            this.Ds = app.second_name;
            this.Dt = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Du = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Dv = app.verify;
            this.price = app.price;
            this.Dw = app.ext_info;
            this.Dx = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Dy.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Dt);
        builder.da_ext_info = this.Dw;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.Dy.DA);
        builder.da_locate = String.valueOf(this.Dq);
        builder.da_obj_id = this.Dk;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Du);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Dv;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId jl() {
        return this.Dy.DF == 2 ? Di : Dh;
    }
}
