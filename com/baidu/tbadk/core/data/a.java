package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a extends q {
    public static final BdUniqueId zd = BdUniqueId.gen();
    public static final BdUniqueId ze = BdUniqueId.gen();
    public String abtest;
    public String price;
    public String userId;
    public int zf;
    public String zg;
    public String zh;
    public int zi;
    public String zj;
    public String zk;
    public String zl;
    public int zm;
    public String zn;
    public String zo;
    public int zp;
    public int zq;
    public String zr;
    public String zs;
    public long zt;
    public b zu = new b();
    public boolean zv = false;

    public boolean jF() {
        if (this.zm <= 0 || TextUtils.isEmpty(this.zg) || TextUtils.isEmpty(this.zg.trim()) || this.zi == 2) {
            return false;
        }
        return jG() || jH();
    }

    public boolean jG() {
        return (this.zi != 3 || TextUtils.isEmpty(this.zl) || TextUtils.isEmpty(this.zk) || TextUtils.isEmpty(this.zl.trim()) || TextUtils.isEmpty(this.zk.trim())) ? false : true;
    }

    public boolean jH() {
        return (this.zi != 1 || TextUtils.isEmpty(this.zj) || TextUtils.isEmpty(this.zj.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.zg = app.id;
            this.zh = app.name;
            this.zi = app.url_type.intValue();
            this.zj = app.url;
            this.zk = app.apk_url;
            this.zl = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.zm = 3;
            } else {
                this.zm = com.baidu.adp.lib.g.c.f(app.pos_name.trim(), 3);
            }
            this.zn = app.first_name;
            this.zo = app.second_name;
            this.zp = app.cpid.intValue();
            this.abtest = app.abtest;
            this.zq = app.plan_id.intValue();
            this.userId = app.user_id;
            this.zr = app.verify;
            this.price = app.price;
            this.zs = app.ext_info;
            this.zt = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.zu.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.zp);
        builder.da_ext_info = this.zs;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.f(str, 0));
        builder.da_good_id = String.valueOf(this.zu.zw);
        builder.da_locate = String.valueOf(this.zm);
        builder.da_obj_id = this.zg;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.zq);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.zr;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.q, com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return this.zu.zA == 2 ? ze : zd;
    }
}
