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
public class b extends bi {
    public static final BdUniqueId OP = BdUniqueId.gen();
    public static final BdUniqueId OQ = BdUniqueId.gen();
    public static final BdUniqueId OR = BdUniqueId.gen();
    public static final BdUniqueId OS = BdUniqueId.gen();
    public static final BdUniqueId OT = BdUniqueId.gen();
    public static final BdUniqueId OU = BdUniqueId.gen();
    public static final BdUniqueId OV = BdUniqueId.gen();
    public static final BdUniqueId OW = BdUniqueId.gen();
    public static final BdUniqueId OX = BdUniqueId.gen();
    public int OY;
    public String OZ;
    public String Pa;
    public int Pc;
    public String Pd;
    public String Pe;
    public String Pf;
    public String Pg;
    public String Ph;
    public String Pi;
    public int Pj;
    public int Pk;
    public String Pl;
    public long Pm;
    public a Pn = new a();
    public boolean Po = false;
    public ICardInfo Pp = null;
    public String abtest;
    public String adPosition;
    public String extensionInfo;
    public String price;
    public String userId;

    public boolean ph() {
        if (StringUtils.isNull(this.adPosition) || TextUtils.isEmpty(this.OZ) || TextUtils.isEmpty(this.OZ.trim())) {
            return false;
        }
        if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") != 0 || TextUtils.isEmpty(this.Pn.lego_card)) {
            if ((TextUtils.isEmpty(this.Pn.lego_card) || bi.Tw.get()) && this.Pn != null && this.Pn.isValid() && this.Pc != 2) {
                return pi() || pj();
            }
            return false;
        }
        return false;
    }

    public boolean pi() {
        return (this.Pc != 3 || TextUtils.isEmpty(this.Pg.trim()) || TextUtils.isEmpty(this.Pe.trim()) || this.Pn == null || ((TextUtils.isEmpty(this.Pn.userName) || TextUtils.isEmpty(this.Pn.userName.trim())) && TextUtils.isEmpty(this.Pn.lego_card))) ? false : true;
    }

    public boolean pj() {
        return (this.Pc != 1 || TextUtils.isEmpty(this.Pd) || TextUtils.isEmpty(this.Pd.trim())) ? false : true;
    }

    public void a(App app) {
        ICardInfo mY;
        if (app != null) {
            this.OZ = app.id;
            this.Pa = app.name;
            this.Pc = app.url_type.intValue();
            this.Pd = app.url;
            this.Pe = app.apk_url;
            this.Pf = app.deep_url;
            this.Pg = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Ph = app.first_name;
            this.Pi = app.second_name;
            this.Pj = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pk = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Pl = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
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
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Pn.lego_card) && (mY = com.baidu.tieba.lego.card.b.mY(this.Pn.lego_card)) != null) {
                this.Pp = mY.getViewItem(0, 1);
                this.Pp.setAdvertAppInfo(this);
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Pj);
        builder.da_ext_info = this.extensionInfo;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Pn.Pq);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.OZ;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pk);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Pl;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public VideoInfo PA;
        public String PC;
        public String PD;
        public float PE;
        public int Pq;
        public String Pr;
        public String Ps;
        public String Pt;
        public String Pu;
        public int Pv;
        public String Pw;
        public String Px;
        public String Py;
        public List<String> Pz = new ArrayList();
        public String adSource;
        public String buttonText;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Pq = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Pr = com.baidu.tbadk.core.util.az.c(goodsInfo.thread_title, 29, "...");
                this.Pt = goodsInfo.thread_pic;
                this.Pu = goodsInfo.pop_window_text;
                this.Pv = goodsInfo.goods_style.intValue();
                this.Pw = goodsInfo.card_desc;
                this.Px = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Py = goodsInfo.button_url;
                this.Ps = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Pz.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.PA = goodsInfo.video_info;
                    this.PC = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.PD = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.PE = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.Pv == 7) {
                    if (this.PA != null && !StringUtils.isNull(this.PA.video_url)) {
                        if (this.PA.video_height.intValue() <= 0 || this.PA.video_width.intValue() <= 0) {
                            return false;
                        }
                        return this.PA.video_duration.intValue() > 0;
                    }
                    return false;
                } else if (this.Pv == 2) {
                    return !StringUtils.isNull(this.Pt);
                } else if (this.Pv == 6) {
                    return this.Pz != null && this.Pz.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Pp != null) {
            return OX;
        }
        if (this.Pn.Pv == 2) {
            return OP;
        }
        if (this.Pn.Pv == 6) {
            return OQ;
        }
        if (this.Pn.Pv == 7) {
            return OR;
        }
        return null;
    }
}
