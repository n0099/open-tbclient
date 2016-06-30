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
public class b extends az {
    public int MF;
    public String MG;
    public String MH;
    public int MI;
    public String MJ;
    public String MK;
    public String MM;
    public String MN;
    public String MO;
    public String MP;
    public String MQ;
    public int MR;
    public int MS;
    public String MT;
    public String MU;
    public long MV;
    public boolean MY;
    public String MZ;
    public String Na;
    public boolean Nb;
    public String abtest;
    public String price;
    public String userId;
    public static final BdUniqueId My = BdUniqueId.gen();
    public static final BdUniqueId Mz = BdUniqueId.gen();
    public static final BdUniqueId MA = BdUniqueId.gen();
    public static final BdUniqueId MB = BdUniqueId.gen();
    public static final BdUniqueId MC = BdUniqueId.gen();
    public static final BdUniqueId MD = BdUniqueId.gen();
    public static final BdUniqueId ME = BdUniqueId.gen();
    public a MW = new a();
    public boolean MX = false;
    public ICardInfo Nc = null;

    public boolean ov() {
        if (StringUtils.isNull(this.MO) || TextUtils.isEmpty(this.MG) || TextUtils.isEmpty(this.MG.trim())) {
            return false;
        }
        if (com.baidu.adp.lib.c.e.cT().Z("is_support_lego_ad_style") != 0 || TextUtils.isEmpty(this.MW.lego_card)) {
            if ((TextUtils.isEmpty(this.MW.lego_card) || az.Qk.get()) && this.MI != 2) {
                return ow() || ox();
            }
            return false;
        }
        return false;
    }

    public boolean ow() {
        return (this.MI != 3 || TextUtils.isEmpty(this.MN.trim()) || TextUtils.isEmpty(this.MK.trim()) || this.MW == null || TextUtils.isEmpty(this.MW.userName.trim())) ? false : true;
    }

    public boolean ox() {
        return (this.MI != 1 || TextUtils.isEmpty(this.MJ) || TextUtils.isEmpty(this.MJ.trim())) ? false : true;
    }

    public void a(App app) {
        ICardInfo lV;
        if (app != null) {
            this.MG = app.id;
            this.MH = app.name;
            this.MI = app.url_type.intValue();
            this.MJ = app.url;
            this.MK = app.apk_url;
            this.MM = app.deep_url;
            this.MN = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.MO = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.MO = app.pos_name.trim();
            }
            this.MP = app.first_name;
            this.MQ = app.second_name;
            this.MR = app.cpid.intValue();
            this.abtest = app.abtest;
            this.MS = app.plan_id.intValue();
            this.userId = app.user_id;
            this.MT = app.verify;
            this.price = app.price;
            this.MU = app.ext_info;
            this.MV = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.MW.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.c.e.cT().Z("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.MW.lego_card) && (lV = com.baidu.tieba.lego.card.a.lV(this.MW.lego_card)) != null) {
                this.Nc = lV.getViewItem(0, 1);
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.MR);
        builder.da_ext_info = this.MU;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.MW.Nd);
        builder.da_locate = String.valueOf(this.MO);
        builder.da_obj_id = this.MG;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.MS);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.MT;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String Fg;
        public int Nd;
        public String Ne;
        public String Nf;
        public String Ng;
        public String Nh;
        public int Ni;
        public String Nj;
        public String Nk;
        public List<String> Nl = new ArrayList();
        public boolean Nm;
        public int height;
        public String lego_card;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Nd = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ne = com.baidu.tbadk.core.util.ba.c(goodsInfo.thread_title, 29, "...");
                this.Ng = goodsInfo.thread_pic;
                this.Nh = goodsInfo.pop_window_text;
                this.Ni = goodsInfo.goods_style.intValue();
                this.Nj = goodsInfo.card_desc;
                this.Nk = goodsInfo.card_tag;
                this.Fg = goodsInfo.button_text;
                this.Nf = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Nm = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Nl.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Nc != null) {
            return ME;
        }
        if (this.MW.Ni == 2) {
            return Mz;
        }
        if (this.MW.Ni == 4) {
            if (StringUtils.isNull(this.MW.Nk)) {
                return MB;
            }
            return MC;
        } else if (this.MW.Ni == 5) {
            return MD;
        } else {
            if (this.MW.Ni == 6) {
                return MA;
            }
            return My;
        }
    }
}
