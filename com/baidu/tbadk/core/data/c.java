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
public class c extends as {
    public static final BdUniqueId RS = BdUniqueId.gen();
    public static final BdUniqueId RT = BdUniqueId.gen();
    public static final BdUniqueId RU = BdUniqueId.gen();
    public static final BdUniqueId RV = BdUniqueId.gen();
    public static final BdUniqueId RW = BdUniqueId.gen();
    public static final BdUniqueId RX = BdUniqueId.gen();
    public int RY;
    public String RZ;
    public String Sa;
    public int Sb;
    public String Sc;
    public String Sd;
    public String Se;
    public String Sf;
    public String Sg;
    public String Sh;
    public int Si;
    public int Sj;
    public String Sk;
    public String Sl;
    public long Sm;
    public a Sn = new a();
    public boolean So = false;
    public boolean Sp;
    public String Sq;
    public String Sr;
    public boolean Ss;
    public String abtest;
    public String price;
    public String userId;

    public boolean rk() {
        if (StringUtils.isNull(this.Sf) || TextUtils.isEmpty(this.RZ) || TextUtils.isEmpty(this.RZ.trim()) || this.Sb == 2) {
            return false;
        }
        return rl() || rm();
    }

    public boolean rl() {
        return (this.Sb != 3 || TextUtils.isEmpty(this.Se.trim()) || TextUtils.isEmpty(this.Sd.trim()) || this.Sn == null || TextUtils.isEmpty(this.Sn.userName.trim())) ? false : true;
    }

    public boolean rm() {
        return (this.Sb != 1 || TextUtils.isEmpty(this.Sc) || TextUtils.isEmpty(this.Sc.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.RZ = app.id;
            this.Sa = app.name;
            this.Sb = app.url_type.intValue();
            this.Sc = app.url;
            this.Sd = app.apk_url;
            this.Se = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Sf = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Sf = app.pos_name.trim();
            }
            this.Sg = app.first_name;
            this.Sh = app.second_name;
            this.Si = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Sj = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Sk = app.verify;
            this.price = app.price;
            this.Sl = app.ext_info;
            this.Sm = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Sn.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Si);
        builder.da_ext_info = this.Sl;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Sn.St);
        builder.da_locate = String.valueOf(this.Sf);
        builder.da_obj_id = this.RZ;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Sj);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Sk;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String OJ;
        public String SA;
        public List<String> SB = new ArrayList();
        public boolean SC;
        public int St;
        public String Su;
        public String Sv;
        public String Sw;
        public String Sx;
        public int Sy;
        public String Sz;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.St = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Su = com.baidu.tbadk.core.util.ay.c(goodsInfo.thread_title, 29, "...");
                this.Sw = goodsInfo.thread_pic;
                this.Sx = goodsInfo.pop_window_text;
                this.Sy = goodsInfo.goods_style.intValue();
                this.Sz = goodsInfo.card_desc;
                this.SA = goodsInfo.card_tag;
                this.OJ = goodsInfo.button_text;
                this.Sv = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.SC = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.SB.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Sn.Sy == 2) {
            return RT;
        }
        if (this.Sn.Sy == 4) {
            if (StringUtils.isNull(this.Sn.SA)) {
                return RV;
            }
            return RW;
        } else if (this.Sn.Sy == 5) {
            return RX;
        } else {
            if (this.Sn.Sy == 6) {
                return RU;
            }
            return RS;
        }
    }
}
