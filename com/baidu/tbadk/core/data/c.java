package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class c extends ah {
    public static final BdUniqueId Um = BdUniqueId.gen();
    public static final BdUniqueId Un = BdUniqueId.gen();
    public static final BdUniqueId Uo = BdUniqueId.gen();
    public static final BdUniqueId Up = BdUniqueId.gen();
    public static final BdUniqueId Uq = BdUniqueId.gen();
    public static final BdUniqueId Ur = BdUniqueId.gen();
    public String UB;
    public String UC;
    public int UD;
    public int UE;
    public String UF;
    public String UG;
    public long UH;
    public a UI = new a();
    public boolean UJ = false;
    public boolean UK;
    public String UL;
    public String UM;
    public boolean UN;
    public int Us;
    public String Ut;
    public String Uu;
    public int Uv;
    public String Uw;
    public String Ux;
    public String Uy;
    public String Uz;
    public String abtest;
    public String price;
    public String userId;

    public boolean rM() {
        if (StringUtils.isNull(this.Uz) || TextUtils.isEmpty(this.Ut) || TextUtils.isEmpty(this.Ut.trim()) || this.Uv == 2) {
            return false;
        }
        return rN() || rO();
    }

    public boolean rN() {
        return (this.Uv != 3 || TextUtils.isEmpty(this.Uy.trim()) || TextUtils.isEmpty(this.Ux.trim()) || this.UI == null || TextUtils.isEmpty(this.UI.userName.trim())) ? false : true;
    }

    public boolean rO() {
        return (this.Uv != 1 || TextUtils.isEmpty(this.Uw) || TextUtils.isEmpty(this.Uw.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Ut = app.id;
            this.Uu = app.name;
            this.Uv = app.url_type.intValue();
            this.Uw = app.url;
            this.Ux = app.apk_url;
            this.Uy = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Uz = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Uz = app.pos_name.trim();
            }
            this.UB = app.first_name;
            this.UC = app.second_name;
            this.UD = app.cpid.intValue();
            this.abtest = app.abtest;
            this.UE = app.plan_id.intValue();
            this.userId = app.user_id;
            this.UF = app.verify;
            this.price = app.price;
            this.UG = app.ext_info;
            this.UH = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.UI.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.UD);
        builder.da_ext_info = this.UG;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.UI.UO);
        builder.da_locate = String.valueOf(this.Uz);
        builder.da_obj_id = this.Ut;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.UE);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.UF;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String OC;
        public int UO;
        public String UQ;
        public String UR;
        public String US;
        public String UT;
        public int UU;
        public String UV;
        public String UW;
        public List<String> UX = new ArrayList();
        public boolean UY;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.UO = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.UQ = aw.d(goodsInfo.thread_title, 29, "...");
                this.US = goodsInfo.thread_pic;
                this.UT = goodsInfo.pop_window_text;
                this.UU = goodsInfo.goods_style.intValue();
                this.UV = goodsInfo.card_desc;
                this.UW = goodsInfo.card_tag;
                this.OC = goodsInfo.button_text;
                this.UR = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.UY = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.UX.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.UI.UU == 2) {
            return Un;
        }
        if (this.UI.UU == 4) {
            if (StringUtils.isNull(this.UI.UW)) {
                return Up;
            }
            return Uq;
        } else if (this.UI.UU == 5) {
            return Ur;
        } else {
            if (this.UI.UU == 6) {
                return Uo;
            }
            return Um;
        }
    }
}
