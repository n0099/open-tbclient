package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class c extends ax {
    public static final BdUniqueId MG = BdUniqueId.gen();
    public static final BdUniqueId MH = BdUniqueId.gen();
    public static final BdUniqueId MI = BdUniqueId.gen();
    public static final BdUniqueId MJ = BdUniqueId.gen();
    public static final BdUniqueId MK = BdUniqueId.gen();
    public static final BdUniqueId ML = BdUniqueId.gen();
    public int MM;
    public String MN;
    public String MO;
    public int MP;
    public String MQ;
    public String MR;
    public String MS;
    public String MT;
    public String MU;
    public String MV;
    public int MW;
    public int MX;
    public String MY;
    public String MZ;
    public long Na;
    public a Nb = new a();
    public boolean Nc = false;
    public boolean Nd;
    public String Ne;
    public String Nf;
    public boolean Ng;
    public String abtest;
    public String price;
    public String userId;

    public boolean oF() {
        if (StringUtils.isNull(this.MT) || TextUtils.isEmpty(this.MN) || TextUtils.isEmpty(this.MN.trim()) || this.MP == 2) {
            return false;
        }
        return oG() || oH();
    }

    public boolean oG() {
        return (this.MP != 3 || TextUtils.isEmpty(this.MS.trim()) || TextUtils.isEmpty(this.MR.trim()) || this.Nb == null || TextUtils.isEmpty(this.Nb.userName.trim())) ? false : true;
    }

    public boolean oH() {
        return (this.MP != 1 || TextUtils.isEmpty(this.MQ) || TextUtils.isEmpty(this.MQ.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.MN = app.id;
            this.MO = app.name;
            this.MP = app.url_type.intValue();
            this.MQ = app.url;
            this.MR = app.apk_url;
            this.MS = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.MT = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.MT = app.pos_name.trim();
            }
            this.MU = app.first_name;
            this.MV = app.second_name;
            this.MW = app.cpid.intValue();
            this.abtest = app.abtest;
            this.MX = app.plan_id.intValue();
            this.userId = app.user_id;
            this.MY = app.verify;
            this.price = app.price;
            this.MZ = app.ext_info;
            this.Na = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Nb.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.MW);
        builder.da_ext_info = this.MZ;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Nb.Nh);
        builder.da_locate = String.valueOf(this.MT);
        builder.da_obj_id = this.MN;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.MX);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.MY;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String EZ;
        public int Nh;
        public String Ni;
        public String Nj;
        public String Nk;
        public String Nl;
        public int Nm;
        public String Nn;
        public String No;
        public List<String> Np = new ArrayList();
        public boolean Nq;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Nh = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ni = com.baidu.tbadk.core.util.ay.c(goodsInfo.thread_title, 29, "...");
                this.Nk = goodsInfo.thread_pic;
                this.Nl = goodsInfo.pop_window_text;
                this.Nm = goodsInfo.goods_style.intValue();
                this.Nn = goodsInfo.card_desc;
                this.No = goodsInfo.card_tag;
                this.EZ = goodsInfo.button_text;
                this.Nj = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Nq = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Np.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Nb.Nm == 2) {
            return MH;
        }
        if (this.Nb.Nm == 4) {
            if (StringUtils.isNull(this.Nb.No)) {
                return MJ;
            }
            return MK;
        } else if (this.Nb.Nm == 5) {
            return ML;
        } else {
            if (this.Nb.Nm == 6) {
                return MI;
            }
            return MG;
        }
    }
}
