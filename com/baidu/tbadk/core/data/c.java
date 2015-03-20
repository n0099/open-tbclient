package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends w {
    public static final BdUniqueId OP = BdUniqueId.gen();
    public static final BdUniqueId OQ = BdUniqueId.gen();
    public static final BdUniqueId OR = BdUniqueId.gen();
    public static final BdUniqueId OS = BdUniqueId.gen();
    public static final BdUniqueId OT = BdUniqueId.gen();
    public int OV;
    public String OW;
    public String OX;
    public int OY;
    public String OZ;
    public String Pa;
    public String Pb;
    public int Pc;
    public String Pd;
    public String Pe;
    public int Pf;
    public int Pg;
    public String Ph;
    public String Pi;
    public long Pj;
    public d Pk = new d();
    public boolean Pl = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean pO() {
        if (this.Pc <= 0 || TextUtils.isEmpty(this.OW) || TextUtils.isEmpty(this.OW.trim()) || this.OY == 2) {
            return false;
        }
        return pP() || pQ();
    }

    public boolean pP() {
        return (this.OY != 3 || TextUtils.isEmpty(this.Pb) || TextUtils.isEmpty(this.Pa) || TextUtils.isEmpty(this.Pb.trim()) || TextUtils.isEmpty(this.Pa.trim())) ? false : true;
    }

    public boolean pQ() {
        return (this.OY != 1 || TextUtils.isEmpty(this.OZ) || TextUtils.isEmpty(this.OZ.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.OW = app.id;
            this.OX = app.name;
            this.OY = app.url_type.intValue();
            this.OZ = app.url;
            this.Pa = app.apk_url;
            this.Pb = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Pc = 3;
            } else {
                this.Pc = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Pd = app.first_name;
            this.Pe = app.second_name;
            this.Pf = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pg = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Ph = app.verify;
            this.price = app.price;
            this.Pi = app.ext_info;
            this.Pj = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Pk.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Pf);
        builder.da_ext_info = this.Pi;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.Pk.Pm);
        builder.da_locate = String.valueOf(this.Pc);
        builder.da_obj_id = this.OW;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pg);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Ph;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        if (this.Pk.Pq == 2) {
            return OQ;
        }
        if (this.Pk.Pq == 4) {
            if (StringUtils.isNull(this.Pk.Ps)) {
                return OR;
            }
            return OS;
        } else if (this.Pk.Pq == 5) {
            return OT;
        } else {
            return OP;
        }
    }
}
