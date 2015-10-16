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
public class b extends w {
    public static final BdUniqueId TO = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public static final BdUniqueId TS = BdUniqueId.gen();
    public static final BdUniqueId TT = BdUniqueId.gen();
    public int TU;
    public String TV;
    public String TW;
    public int TX;
    public String TY;
    public String TZ;
    public String Ua;
    public String Ub;
    public String Uc;
    public String Ud;
    public int Ue;
    public int Uf;
    public String Ug;
    public String Uh;
    public long Ui;
    public a Uj = new a();
    public boolean Uk = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean rp() {
        if (StringUtils.isNull(this.Ub) || TextUtils.isEmpty(this.TV) || TextUtils.isEmpty(this.TV.trim()) || this.TX == 2) {
            return false;
        }
        return rq() || rr();
    }

    public boolean rq() {
        return (this.TX != 3 || TextUtils.isEmpty(this.Ua) || TextUtils.isEmpty(this.TZ) || TextUtils.isEmpty(this.Ua.trim()) || TextUtils.isEmpty(this.TZ.trim())) ? false : true;
    }

    public boolean rr() {
        return (this.TX != 1 || TextUtils.isEmpty(this.TY) || TextUtils.isEmpty(this.TY.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.TV = app.id;
            this.TW = app.name;
            this.TX = app.url_type.intValue();
            this.TY = app.url;
            this.TZ = app.apk_url;
            this.Ua = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Ub = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Ub = app.pos_name.trim();
            }
            this.Uc = app.first_name;
            this.Ud = app.second_name;
            this.Ue = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Uf = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Ug = app.verify;
            this.price = app.price;
            this.Uh = app.ext_info;
            this.Ui = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Uj.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Ue);
        builder.da_ext_info = this.Uh;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Uj.Ul);
        builder.da_locate = String.valueOf(this.Ub);
        builder.da_obj_id = this.TV;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Uf);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Ug;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Ul;
        public String Um;
        public String Un;
        public String Uo;
        public String Up;
        public int Uq;
        public String Ur;
        public String Us;
        public String Ut;
        public List<String> Uu = new ArrayList();
        public boolean Uv;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Ul = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Um = goodsInfo.thread_title;
                this.Uo = goodsInfo.thread_pic;
                this.Up = goodsInfo.pop_window_text;
                this.Uq = goodsInfo.goods_style.intValue();
                this.Ur = goodsInfo.card_desc;
                this.Us = goodsInfo.card_tag;
                this.Ut = goodsInfo.button_text;
                this.Un = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Uv = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Uu.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Uj.Uq == 2) {
            return TP;
        }
        if (this.Uj.Uq == 4) {
            if (StringUtils.isNull(this.Uj.Us)) {
                return TR;
            }
            return TS;
        } else if (this.Uj.Uq == 5) {
            return TT;
        } else {
            if (this.Uj.Uq == 6) {
                return TQ;
            }
            return TO;
        }
    }
}
