package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends x {
    public static final BdUniqueId Dk = BdUniqueId.gen();
    public static final BdUniqueId Dl = BdUniqueId.gen();
    public long DA;
    public d DB = new d();
    public boolean DD = false;
    public int Dm;
    public String Dn;
    public String Do;
    public int Dp;
    public String Dq;
    public String Dr;
    public String Ds;
    public int Dt;
    public String Du;
    public String Dv;
    public int Dw;
    public int Dx;
    public String Dy;
    public String Dz;
    public String abtest;
    public String price;
    public String userId;

    public boolean mu() {
        if (this.Dt <= 0 || TextUtils.isEmpty(this.Dn) || TextUtils.isEmpty(this.Dn.trim()) || this.Dp == 2) {
            return false;
        }
        return mv() || mw();
    }

    public boolean mv() {
        return (this.Dp != 3 || TextUtils.isEmpty(this.Ds) || TextUtils.isEmpty(this.Dr) || TextUtils.isEmpty(this.Ds.trim()) || TextUtils.isEmpty(this.Dr.trim())) ? false : true;
    }

    public boolean mw() {
        return (this.Dp != 1 || TextUtils.isEmpty(this.Dq) || TextUtils.isEmpty(this.Dq.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Dn = app.id;
            this.Do = app.name;
            this.Dp = app.url_type.intValue();
            this.Dq = app.url;
            this.Dr = app.apk_url;
            this.Ds = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Dt = 3;
            } else {
                this.Dt = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Du = app.first_name;
            this.Dv = app.second_name;
            this.Dw = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Dx = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Dy = app.verify;
            this.price = app.price;
            this.Dz = app.ext_info;
            this.DA = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.DB.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Dw);
        builder.da_ext_info = this.Dz;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.DB.DE);
        builder.da_locate = String.valueOf(this.Dt);
        builder.da_obj_id = this.Dn;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Dx);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Dy;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId js() {
        return this.DB.DI == 2 ? Dl : Dk;
    }
}
