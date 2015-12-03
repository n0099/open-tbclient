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
    public static final BdUniqueId Uf = BdUniqueId.gen();
    public static final BdUniqueId Ug = BdUniqueId.gen();
    public static final BdUniqueId Uh = BdUniqueId.gen();
    public static final BdUniqueId Ui = BdUniqueId.gen();
    public static final BdUniqueId Uj = BdUniqueId.gen();
    public static final BdUniqueId Uk = BdUniqueId.gen();
    public a UA = new a();
    public boolean UB = false;
    public int Ul;
    public String Um;
    public String Un;
    public int Uo;
    public String Up;
    public String Uq;
    public String Ur;
    public String Us;
    public String Ut;
    public String Uu;
    public int Uv;
    public int Uw;
    public String Ux;
    public String Uy;
    public long Uz;
    public String abtest;
    public String price;
    public String userId;

    public boolean rB() {
        if (StringUtils.isNull(this.Us) || TextUtils.isEmpty(this.Um) || TextUtils.isEmpty(this.Um.trim()) || this.Uo == 2) {
            return false;
        }
        return rC() || rD();
    }

    public boolean rC() {
        return (this.Uo != 3 || TextUtils.isEmpty(this.Ur.trim()) || TextUtils.isEmpty(this.Uq.trim()) || this.UA == null || TextUtils.isEmpty(this.UA.userName.trim())) ? false : true;
    }

    public boolean rD() {
        return (this.Uo != 1 || TextUtils.isEmpty(this.Up) || TextUtils.isEmpty(this.Up.trim())) ? false : true;
    }

    public void a(App app) {
        if (app != null) {
            this.Um = app.id;
            this.Un = app.name;
            this.Uo = app.url_type.intValue();
            this.Up = app.url;
            this.Uq = app.apk_url;
            this.Ur = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.Us = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.Us = app.pos_name.trim();
            }
            this.Ut = app.first_name;
            this.Uu = app.second_name;
            this.Uv = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Uw = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Ux = app.verify;
            this.price = app.price;
            this.Uy = app.ext_info;
            this.Uz = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                for (GoodsInfo goodsInfo : app.goods_info) {
                    if (goodsInfo != null) {
                        this.UA.a(goodsInfo);
                        return;
                    }
                }
            }
        }
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Uv);
        builder.da_ext_info = this.Uy;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.UA.UC);
        builder.da_locate = String.valueOf(this.Us);
        builder.da_obj_id = this.Um;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Uw);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Ux;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int UC;
        public String UD;
        public String UE;
        public String UF;
        public String UG;
        public int UH;
        public String UI;
        public String UJ;
        public String UK;
        public List<String> UL = new ArrayList();
        public boolean UM;
        public int height;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.UC = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.UD = ax.d(goodsInfo.thread_title, 29, "...");
                this.UF = goodsInfo.thread_pic;
                this.UG = goodsInfo.pop_window_text;
                this.UH = goodsInfo.goods_style.intValue();
                this.UI = goodsInfo.card_desc;
                this.UJ = goodsInfo.card_tag;
                this.UK = goodsInfo.button_text;
                this.UE = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.UM = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.UL.add(threadPicList.pic);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.UA.UH == 2) {
            return Ug;
        }
        if (this.UA.UH == 4) {
            if (StringUtils.isNull(this.UA.UJ)) {
                return Ui;
            }
            return Uj;
        } else if (this.UA.UH == 5) {
            return Uk;
        } else {
            if (this.UA.UH == 6) {
                return Uh;
            }
            return Uf;
        }
    }
}
