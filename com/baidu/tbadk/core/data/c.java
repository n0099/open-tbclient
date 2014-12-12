package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends w {
    public static final BdUniqueId Di = BdUniqueId.gen();
    public static final BdUniqueId Dj = BdUniqueId.gen();
    public int Dk;
    public String Dl;
    public String Dm;
    public int Dn;
    public String Do;
    public String Dp;
    public String Dq;
    public int Dr;
    public String Ds;
    public String Dt;
    public int Du;
    public int Dv;
    public String Dw;
    public String Dx;
    public long Dy;
    public String abtest;
    public String price;
    public String userId;
    public d Dz = new d();
    public boolean DA = false;

    public boolean mu() {
        if (this.Dr <= 0 || TextUtils.isEmpty(this.Dl) || TextUtils.isEmpty(this.Dl.trim()) || this.Dn == 2) {
            return false;
        }
        return mv() || mw();
    }

    public boolean mv() {
        return (this.Dn != 3 || TextUtils.isEmpty(this.Dq) || TextUtils.isEmpty(this.Dp) || TextUtils.isEmpty(this.Dq.trim()) || TextUtils.isEmpty(this.Dp.trim())) ? false : true;
    }

    public boolean mw() {
        return (this.Dn != 1 || TextUtils.isEmpty(this.Do) || TextUtils.isEmpty(this.Do.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Dl = app.id;
            this.Dm = app.name;
            this.Dn = app.url_type.intValue();
            this.Do = app.url;
            this.Dp = app.apk_url;
            this.Dq = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Dr = 3;
            } else {
                this.Dr = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Ds = app.first_name;
            this.Dt = app.second_name;
            this.Du = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Dv = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Dw = app.verify;
            this.price = app.price;
            this.Dx = app.ext_info;
            this.Dy = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Dz.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Du);
        builder.da_ext_info = this.Dx;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.Dz.DB);
        builder.da_locate = String.valueOf(this.Dr);
        builder.da_obj_id = this.Dl;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Dv);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Dw;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.am
    public BdUniqueId jr() {
        return this.Dz.DG == 2 ? Dj : Di;
    }
}
