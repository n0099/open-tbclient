package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class b extends be {
    public int MD;
    public String ME;
    public String MF;
    public int MG;
    public String MH;
    public String MI;
    public String MJ;
    public String MK;
    public String MM;
    public String MN;
    public String MO;
    public int MP;
    public int MQ;
    public String MR;
    public String MS;
    public long MT;
    public boolean MW;
    public String MX;
    public String MY;
    public boolean MZ;
    public String abtest;
    public String price;
    public String userId;
    public static final BdUniqueId Mw = BdUniqueId.gen();
    public static final BdUniqueId Mx = BdUniqueId.gen();
    public static final BdUniqueId My = BdUniqueId.gen();
    public static final BdUniqueId Mz = BdUniqueId.gen();
    public static final BdUniqueId MA = BdUniqueId.gen();
    public static final BdUniqueId MB = BdUniqueId.gen();
    public static final BdUniqueId MC = BdUniqueId.gen();
    public a MU = new a();
    public boolean MV = false;
    public ICardInfo Na = null;

    public boolean ok() {
        if (StringUtils.isNull(this.MM) || TextUtils.isEmpty(this.ME) || TextUtils.isEmpty(this.ME.trim())) {
            return false;
        }
        if (com.baidu.adp.lib.c.e.cS().ab("is_support_lego_ad_style") != 0 || TextUtils.isEmpty(this.MU.lego_card)) {
            if ((TextUtils.isEmpty(this.MU.lego_card) || be.QF.get()) && this.MG != 2) {
                return ol() || om();
            }
            return false;
        }
        return false;
    }

    public boolean ol() {
        return (this.MG != 3 || TextUtils.isEmpty(this.MK.trim()) || TextUtils.isEmpty(this.MI.trim()) || this.MU == null || TextUtils.isEmpty(this.MU.userName.trim())) ? false : true;
    }

    public boolean om() {
        return (this.MG != 1 || TextUtils.isEmpty(this.MH) || TextUtils.isEmpty(this.MH.trim())) ? false : true;
    }

    public void a(App app) {
        ICardInfo mc;
        if (app != null) {
            this.ME = app.id;
            this.MF = app.name;
            this.MG = app.url_type.intValue();
            this.MH = app.url;
            this.MI = app.apk_url;
            this.MJ = app.deep_url;
            this.MK = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.MM = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.MM = app.pos_name.trim();
            }
            this.MN = app.first_name;
            this.MO = app.second_name;
            this.MP = app.cpid.intValue();
            this.abtest = app.abtest;
            this.MQ = app.plan_id.intValue();
            this.userId = app.user_id;
            this.MR = app.verify;
            this.price = app.price;
            this.MS = app.ext_info;
            this.MT = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.MU.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.c.e.cS().ab("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.MU.lego_card) && (mc = com.baidu.tieba.lego.card.a.mc(this.MU.lego_card)) != null) {
                this.Na = mc.getViewItem(0, 1);
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.MP);
        builder.da_ext_info = this.MS;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.MU.Nb);
        builder.da_locate = String.valueOf(this.MM);
        builder.da_obj_id = this.ME;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.MQ);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.MR;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String FG;
        public int Nb;
        public String Nc;
        public String Nd;
        public String Ne;
        public String Nf;
        public int Ng;
        public String Nh;
        public String Ni;
        public List<String> Nj = new ArrayList();
        public boolean Nk;
        public int height;
        public String lego_card;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Nb = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Nc = com.baidu.tbadk.core.util.ba.c(goodsInfo.thread_title, 29, "...");
                this.Ne = goodsInfo.thread_pic;
                this.Nf = goodsInfo.pop_window_text;
                this.Ng = goodsInfo.goods_style.intValue();
                this.Nh = goodsInfo.card_desc;
                this.Ni = goodsInfo.card_tag;
                this.FG = goodsInfo.button_text;
                this.Nd = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Nk = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Nj.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Na != null) {
            return MC;
        }
        if (this.MU.Ng == 2) {
            return Mx;
        }
        if (this.MU.Ng == 4) {
            if (StringUtils.isNull(this.MU.Ni)) {
                return Mz;
            }
            return MA;
        } else if (this.MU.Ng == 5) {
            return MB;
        } else {
            if (this.MU.Ng == 6) {
                return My;
            }
            return Mw;
        }
    }
}
