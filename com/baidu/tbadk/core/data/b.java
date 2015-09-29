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
public class b extends v {
    public static final BdUniqueId TM = BdUniqueId.gen();
    public static final BdUniqueId TO = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public static final BdUniqueId TS = BdUniqueId.gen();
    public int TT;
    public String TU;
    public String TV;
    public int TW;
    public String TX;
    public String TY;
    public String TZ;
    public String Ua;
    public String Ub;
    public String Uc;
    public int Ud;
    public int Ue;
    public String Uf;
    public String Ug;
    public long Uh;
    public a Ui = new a();
    public boolean Uj = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean rp() {
        if (StringUtils.isNull(this.Ua) || TextUtils.isEmpty(this.TU) || TextUtils.isEmpty(this.TU.trim()) || this.TW == 2) {
            return false;
        }
        return rq() || rr();
    }

    public boolean rq() {
        return (this.TW != 3 || TextUtils.isEmpty(this.TZ) || TextUtils.isEmpty(this.TY) || TextUtils.isEmpty(this.TZ.trim()) || TextUtils.isEmpty(this.TY.trim())) ? false : true;
    }

    public boolean rr() {
        return (this.TW != 1 || TextUtils.isEmpty(this.TX) || TextUtils.isEmpty(this.TX.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.TU = app.id;
            this.TV = app.name;
            this.TW = app.url_type.intValue();
            this.TX = app.url;
            this.TY = app.apk_url;
            this.TZ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Ua = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Ua = app.pos_name.trim();
            }
            this.Ub = app.first_name;
            this.Uc = app.second_name;
            this.Ud = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Ue = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Uf = app.verify;
            this.price = app.price;
            this.Ug = app.ext_info;
            this.Uh = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Ui.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq b(String str, long j, String str2, String str3) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Ud);
        builder.da_ext_info = this.Ug;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Ui.Uk);
        builder.da_locate = String.valueOf(this.Ua);
        builder.da_obj_id = this.TU;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Ue);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Uf;
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Uk;
        public String Ul;
        public String Um;
        public String Un;
        public String Uo;
        public int Up;
        public String Uq;
        public String Ur;
        public String Us;
        public List<String> Ut = new ArrayList();
        public boolean Uu;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Uk = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ul = goodsInfo.thread_title;
                this.Un = goodsInfo.thread_pic;
                this.Uo = goodsInfo.pop_window_text;
                this.Up = goodsInfo.goods_style.intValue();
                this.Uq = goodsInfo.card_desc;
                this.Ur = goodsInfo.card_tag;
                this.Us = goodsInfo.button_text;
                this.Um = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Uu = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Ut.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Ui.Up == 2) {
            return TO;
        }
        if (this.Ui.Up == 4) {
            if (StringUtils.isNull(this.Ui.Ur)) {
                return TQ;
            }
            return TR;
        } else if (this.Ui.Up == 5) {
            return TS;
        } else {
            if (this.Ui.Up == 6) {
                return TP;
            }
            return TM;
        }
    }
}
