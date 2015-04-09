package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends w {
    public static final BdUniqueId OR = BdUniqueId.gen();
    public static final BdUniqueId OS = BdUniqueId.gen();
    public static final BdUniqueId OT = BdUniqueId.gen();
    public static final BdUniqueId OV = BdUniqueId.gen();
    public static final BdUniqueId OW = BdUniqueId.gen();
    public int OX;
    public String OY;
    public String OZ;
    public int Pa;
    public String Pb;
    public String Pc;
    public String Pd;
    public int Pe;
    public String Pf;
    public String Pg;
    public int Ph;
    public int Pi;
    public String Pj;
    public String Pk;
    public long Pl;
    public d Pm = new d();
    public boolean Pn = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean pO() {
        if (this.Pe <= 0 || TextUtils.isEmpty(this.OY) || TextUtils.isEmpty(this.OY.trim()) || this.Pa == 2) {
            return false;
        }
        return pP() || pQ();
    }

    public boolean pP() {
        return (this.Pa != 3 || TextUtils.isEmpty(this.Pd) || TextUtils.isEmpty(this.Pc) || TextUtils.isEmpty(this.Pd.trim()) || TextUtils.isEmpty(this.Pc.trim())) ? false : true;
    }

    public boolean pQ() {
        return (this.Pa != 1 || TextUtils.isEmpty(this.Pb) || TextUtils.isEmpty(this.Pb.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.OY = app.id;
            this.OZ = app.name;
            this.Pa = app.url_type.intValue();
            this.Pb = app.url;
            this.Pc = app.apk_url;
            this.Pd = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Pe = 3;
            } else {
                this.Pe = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Pf = app.first_name;
            this.Pg = app.second_name;
            this.Ph = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pi = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Pj = app.verify;
            this.price = app.price;
            this.Pk = app.ext_info;
            this.Pl = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Pm.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Ph);
        builder.da_ext_info = this.Pk;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.Pm.Po);
        builder.da_locate = String.valueOf(this.Pe);
        builder.da_obj_id = this.OY;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pi);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Pj;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        if (this.Pm.Ps == 2) {
            return OS;
        }
        if (this.Pm.Ps == 4) {
            if (StringUtils.isNull(this.Pm.Pu)) {
                return OT;
            }
            return OV;
        } else if (this.Pm.Ps == 5) {
            return OW;
        } else {
            return OR;
        }
    }
}
