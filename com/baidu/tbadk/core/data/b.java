package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class b extends z {
    public static final BdUniqueId UF = BdUniqueId.gen();
    public static final BdUniqueId UG = BdUniqueId.gen();
    public static final BdUniqueId UH = BdUniqueId.gen();
    public static final BdUniqueId UI = BdUniqueId.gen();
    public static final BdUniqueId UJ = BdUniqueId.gen();
    public static final BdUniqueId UK = BdUniqueId.gen();
    public int UL;
    public String UM;
    public String UN;
    public int UO;
    public String UQ;
    public String UR;
    public String US;
    public String UT;
    public String UU;
    public String UV;
    public int UW;
    public int UX;
    public String UY;
    public String UZ;
    public long Va;
    public a Vb = new a();
    public boolean Vc = false;
    public String abtest;
    public String price;
    public String userId;

    public boolean rk() {
        if (StringUtils.isNull(this.UT) || TextUtils.isEmpty(this.UM) || TextUtils.isEmpty(this.UM.trim()) || this.UO == 2) {
            return false;
        }
        return rl() || rm();
    }

    public boolean rl() {
        return (this.UO != 3 || TextUtils.isEmpty(this.US.trim()) || TextUtils.isEmpty(this.UR.trim()) || this.Vb == null || TextUtils.isEmpty(this.Vb.userName.trim())) ? false : true;
    }

    public boolean rm() {
        return (this.UO != 1 || TextUtils.isEmpty(this.UQ) || TextUtils.isEmpty(this.UQ.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.UM = app.id;
            this.UN = app.name;
            this.UO = app.url_type.intValue();
            this.UQ = app.url;
            this.UR = app.apk_url;
            this.US = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.UT = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.UT = app.pos_name.trim();
            }
            this.UU = app.first_name;
            this.UV = app.second_name;
            this.UW = app.cpid.intValue();
            this.abtest = app.abtest;
            this.UX = app.plan_id.intValue();
            this.userId = app.user_id;
            this.UY = app.verify;
            this.price = app.price;
            this.UZ = app.ext_info;
            this.Va = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.Vb.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.UW);
        builder.da_ext_info = this.UZ;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Vb.Vd);
        builder.da_locate = String.valueOf(this.UT);
        builder.da_obj_id = this.UM;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.UX);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.UY;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Vd;
        public String Ve;
        public String Vf;
        public String Vg;
        public String Vh;
        public int Vi;
        public String Vj;
        public String Vk;
        public String Vl;
        public List<String> Vm = new ArrayList();
        public boolean Vn;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Vd = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ve = ax.d(goodsInfo.thread_title, 29, "...");
                this.Vg = goodsInfo.thread_pic;
                this.Vh = goodsInfo.pop_window_text;
                this.Vi = goodsInfo.goods_style.intValue();
                this.Vj = goodsInfo.card_desc;
                this.Vk = goodsInfo.card_tag;
                this.Vl = goodsInfo.button_text;
                this.Vf = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.Vn = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Vm.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.Vb.Vi == 2) {
            return UG;
        }
        if (this.Vb.Vi == 4) {
            if (StringUtils.isNull(this.Vb.Vk)) {
                return UI;
            }
            return UJ;
        } else if (this.Vb.Vi == 5) {
            return UK;
        } else {
            if (this.Vb.Vi == 6) {
                return UH;
            }
            return UF;
        }
    }
}
