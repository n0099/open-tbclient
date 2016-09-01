package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
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
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class b extends bg {
    public static final BdUniqueId OO = BdUniqueId.gen();
    public static final BdUniqueId OP = BdUniqueId.gen();
    public static final BdUniqueId OQ = BdUniqueId.gen();
    public static final BdUniqueId OR = BdUniqueId.gen();
    public static final BdUniqueId OS = BdUniqueId.gen();
    public static final BdUniqueId OT = BdUniqueId.gen();
    public static final BdUniqueId OU = BdUniqueId.gen();
    public static final BdUniqueId OV = BdUniqueId.gen();
    public static final BdUniqueId OW = BdUniqueId.gen();
    public int OX;
    public String OY;
    public String OZ;
    public int Pa;
    public String Pc;
    public String Pd;
    public String Pe;
    public String Pf;
    public String Pg;
    public String Ph;
    public int Pi;
    public int Pj;
    public String Pk;
    public String Pl;
    public long Pm;
    public a Pn = new a();
    public boolean Po = false;
    public ICardInfo Pp = null;
    public String abtest;
    public String adUrl;
    public String price;
    public String userId;

    public boolean pg() {
        if (StringUtils.isNull(this.Pf) || TextUtils.isEmpty(this.OY) || TextUtils.isEmpty(this.OY.trim())) {
            return false;
        }
        if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") != 0 || TextUtils.isEmpty(this.Pn.lego_card)) {
            if ((TextUtils.isEmpty(this.Pn.lego_card) || bg.To.get()) && this.Pn != null && this.Pn.isValid() && this.Pa != 2) {
                return ph() || pi();
            }
            return false;
        }
        return false;
    }

    public boolean ph() {
        return (this.Pa != 3 || TextUtils.isEmpty(this.Pe.trim()) || TextUtils.isEmpty(this.Pc.trim()) || this.Pn == null || TextUtils.isEmpty(this.Pn.userName.trim())) ? false : true;
    }

    public boolean pi() {
        return (this.Pa != 1 || TextUtils.isEmpty(this.adUrl) || TextUtils.isEmpty(this.adUrl.trim())) ? false : true;
    }

    public void a(App app) {
        ICardInfo mL;
        if (app != null) {
            this.OY = app.id;
            this.OZ = app.name;
            this.Pa = app.url_type.intValue();
            this.adUrl = app.url;
            this.Pc = app.apk_url;
            this.Pd = app.deep_url;
            this.Pe = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Pf = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Pf = app.pos_name.trim();
            }
            this.Pg = app.first_name;
            this.Ph = app.second_name;
            this.Pi = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pj = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Pk = app.verify;
            this.price = app.price;
            this.Pl = app.ext_info;
            this.Pm = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Pn.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Pn.lego_card) && (mL = com.baidu.tieba.lego.card.b.mL(this.Pn.lego_card)) != null) {
                this.Pp = mL.getViewItem(0, 1);
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Pi);
        builder.da_ext_info = this.Pl;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Pn.Pq);
        builder.da_locate = String.valueOf(this.Pf);
        builder.da_obj_id = this.OY;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pj);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Pk;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String HT;
        public List<String> PA = new ArrayList();
        public boolean PC;
        public VideoInfo PD;
        public String PE;
        public String PF;
        public float PG;
        public int Pq;
        public String Pr;
        public String Ps;
        public String Pt;
        public String Pu;
        public String Pv;
        public int Pw;
        public String Px;
        public String Py;
        public String Pz;
        public int height;
        public String lego_card;
        public String userName;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Pq = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.Pr = goodsInfo.user_portrait;
                this.Ps = com.baidu.tbadk.core.util.ba.c(goodsInfo.thread_title, 29, "...");
                this.Pu = goodsInfo.thread_pic;
                this.Pv = goodsInfo.pop_window_text;
                this.Pw = goodsInfo.goods_style.intValue();
                this.Px = goodsInfo.card_desc;
                this.Py = goodsInfo.card_tag;
                this.HT = goodsInfo.button_text;
                this.Pz = goodsInfo.button_url;
                this.Pt = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.PC = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.PA.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.PD = goodsInfo.video_info;
                    this.PE = goodsInfo.tag_name;
                    this.PF = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.PG = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                }
            }
        }

        public boolean isValid() {
            return this.Pw == 7 ? this.PD != null && !StringUtils.isNull(this.PD.video_url) && this.PD.video_height.intValue() > 0 && this.PD.video_width.intValue() > 0 && this.PD.video_duration.intValue() > 0 : this.Pw == 2 ? !StringUtils.isNull(this.Pu) : this.Pw == 6 && this.PA != null && this.PA.size() > 0;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Pp != null) {
            return OW;
        }
        if (this.Pn.Pw == 2) {
            return OO;
        }
        if (this.Pn.Pw == 6) {
            return OP;
        }
        if (this.Pn.Pw == 7) {
            return OQ;
        }
        return null;
    }
}
