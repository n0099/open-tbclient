package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class c extends w {
    public static final BdUniqueId Pm = BdUniqueId.gen();
    public static final BdUniqueId Pn = BdUniqueId.gen();
    public static final BdUniqueId Po = BdUniqueId.gen();
    public static final BdUniqueId Pp = BdUniqueId.gen();
    public static final BdUniqueId Pq = BdUniqueId.gen();
    public String PA;
    public int PC;
    public int PD;
    public String PE;
    public String PF;
    public long PG;
    public d PH = new d();
    public boolean PJ = false;
    public int Pr;
    public String Ps;
    public String Pt;
    public int Pu;
    public String Pv;
    public String Pw;
    public String Px;
    public int Py;
    public String Pz;
    public String abtest;
    public String price;
    public String userId;

    public boolean qu() {
        if (this.Py <= 0 || TextUtils.isEmpty(this.Ps) || TextUtils.isEmpty(this.Ps.trim()) || this.Pu == 2) {
            return false;
        }
        return qv() || qw();
    }

    public boolean qv() {
        return (this.Pu != 3 || TextUtils.isEmpty(this.Px) || TextUtils.isEmpty(this.Pw) || TextUtils.isEmpty(this.Px.trim()) || TextUtils.isEmpty(this.Pw.trim())) ? false : true;
    }

    public boolean qw() {
        return (this.Pu != 1 || TextUtils.isEmpty(this.Pv) || TextUtils.isEmpty(this.Pv.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Ps = app.id;
            this.Pt = app.name;
            this.Pu = app.url_type.intValue();
            this.Pv = app.url;
            this.Pw = app.apk_url;
            this.Px = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Py = 3;
            } else {
                this.Py = com.baidu.adp.lib.g.c.toInt(app.pos_name.trim(), 3);
            }
            this.Pz = app.first_name;
            this.PA = app.second_name;
            this.PC = app.cpid.intValue();
            this.abtest = app.abtest;
            this.PD = app.plan_id.intValue();
            this.userId = app.user_id;
            this.PE = app.verify;
            this.price = app.price;
            this.PF = app.ext_info;
            this.PG = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.PH.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.PC);
        builder.da_ext_info = this.PF;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.c.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.PH.PK);
        builder.da_locate = String.valueOf(this.Py);
        builder.da_obj_id = this.Ps;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.PD);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.PE;
        return builder.build(false);
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        if (this.PH.PO == 2) {
            return Pn;
        }
        if (this.PH.PO == 4) {
            if (StringUtils.isNull(this.PH.PQ)) {
                return Po;
            }
            return Pp;
        } else if (this.PH.PO == 5) {
            return Pq;
        } else {
            return Pm;
        }
    }
}
