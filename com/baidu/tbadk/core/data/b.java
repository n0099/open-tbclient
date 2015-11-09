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
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public static final BdUniqueId TS = BdUniqueId.gen();
    public static final BdUniqueId TT = BdUniqueId.gen();
    public static final BdUniqueId TU = BdUniqueId.gen();
    public int TV;
    public String TW;
    public String TX;
    public int TY;
    public String TZ;
    public String Ua;
    public String Ub;
    public String Uc;
    public String Ud;
    public String Ue;
    public int Uf;
    public int Ug;
    public String Uh;
    public String Ui;
    public long Uj;
    public a Uk = new a();
    public boolean Ul = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean rn() {
        if (StringUtils.isNull(this.Uc) || TextUtils.isEmpty(this.TW) || TextUtils.isEmpty(this.TW.trim()) || this.TY == 2) {
            return false;
        }
        return ro() || rp();
    }

    public boolean ro() {
        return (this.TY != 3 || TextUtils.isEmpty(this.Ub) || TextUtils.isEmpty(this.Ua) || TextUtils.isEmpty(this.Ub.trim()) || TextUtils.isEmpty(this.Ua.trim())) ? false : true;
    }

    public boolean rp() {
        return (this.TY != 1 || TextUtils.isEmpty(this.TZ) || TextUtils.isEmpty(this.TZ.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.TW = app.id;
            this.TX = app.name;
            this.TY = app.url_type.intValue();
            this.TZ = app.url;
            this.Ua = app.apk_url;
            this.Ub = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Uc = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Uc = app.pos_name.trim();
            }
            this.Ud = app.first_name;
            this.Ue = app.second_name;
            this.Uf = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Ug = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Uh = app.verify;
            this.price = app.price;
            this.Ui = app.ext_info;
            this.Uj = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Uk.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Uf);
        builder.da_ext_info = this.Ui;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Uk.Um);
        builder.da_locate = String.valueOf(this.Uc);
        builder.da_obj_id = this.TW;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Ug);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Uh;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Um;
        public String Un;
        public String Uo;
        public String Up;
        public String Uq;
        public int Ur;
        public String Us;
        public String Ut;
        public String Uu;
        public List<String> Uv = new ArrayList();
        public boolean Uw;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Um = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Un = goodsInfo.thread_title;
                this.Up = goodsInfo.thread_pic;
                this.Uq = goodsInfo.pop_window_text;
                this.Ur = goodsInfo.goods_style.intValue();
                this.Us = goodsInfo.card_desc;
                this.Ut = goodsInfo.card_tag;
                this.Uu = goodsInfo.button_text;
                this.Uo = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Uw = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Uv.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Uk.Ur == 2) {
            return TQ;
        }
        if (this.Uk.Ur == 4) {
            if (StringUtils.isNull(this.Uk.Ut)) {
                return TS;
            }
            return TT;
        } else if (this.Uk.Ur == 5) {
            return TU;
        } else {
            if (this.Uk.Ur == 6) {
                return TR;
            }
            return TP;
        }
    }
}
