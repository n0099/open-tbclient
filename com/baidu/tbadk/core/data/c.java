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
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class c extends bk {
    public static final BdUniqueId OY = BdUniqueId.gen();
    public static final BdUniqueId OZ = BdUniqueId.gen();
    public static final BdUniqueId Pa = BdUniqueId.gen();
    public static final BdUniqueId Pc = BdUniqueId.gen();
    public static final BdUniqueId Pd = BdUniqueId.gen();
    public static final BdUniqueId Pe = BdUniqueId.gen();
    public static final BdUniqueId Pf = BdUniqueId.gen();
    public static final BdUniqueId Pg = BdUniqueId.gen();
    public static final BdUniqueId Ph = BdUniqueId.gen();
    public static final BdUniqueId Pi = BdUniqueId.gen();
    public static final BdUniqueId Pj = BdUniqueId.gen();
    public static final BdUniqueId Pk = BdUniqueId.gen();
    public String OS;
    public b PD;
    public String PE;
    public String PF;
    public String PG;
    private App PH;
    public com.baidu.tieba.tbadkCore.data.e PI;
    public int Pl;
    public String Pm;
    public String Pn;
    public int Po;
    public String Pp;
    public String Pq;
    public String Pr;
    public String Ps;
    public String Pt;
    public String Pu;
    public int Pv;
    public int Pw;
    public String Px;
    public long Py;
    public String abtest;
    public String adPosition;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Pz = new a();
    public boolean PA = false;
    public ICardInfo PC = null;

    public boolean pj() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.Pz.PP == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.Pm) || TextUtils.isEmpty(this.Pm.trim())) {
            return false;
        }
        int ac = com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.Pz.lego_card) || !(ac == 0 || this.PC == null)) {
            if ((TextUtils.isEmpty(this.Pz.lego_card) || bk.TS.get()) && this.Pz != null && this.Pz.isValid() && this.Po != 2) {
                return pk() || pl();
            }
            return false;
        }
        return false;
    }

    public boolean pk() {
        return (this.Po != 3 || TextUtils.isEmpty(this.Ps.trim()) || TextUtils.isEmpty(this.Pq.trim()) || this.Pz == null || ((TextUtils.isEmpty(this.Pz.userName) || TextUtils.isEmpty(this.Pz.userName.trim())) && TextUtils.isEmpty(this.Pz.lego_card))) ? false : true;
    }

    public boolean pl() {
        if (this.Pz == null || this.Pz.PP != 1001) {
            return this.Po == 1 && !((TextUtils.isEmpty(this.Pp) || TextUtils.isEmpty(this.Pp.trim())) && TextUtils.isEmpty(this.Pz.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nk;
        if (app != null) {
            this.PH = app;
            this.Pm = app.id;
            this.Pn = app.name;
            this.Po = app.url_type.intValue();
            this.Pp = app.url;
            this.Pq = app.apk_url;
            this.Pr = app.deep_url;
            this.Ps = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Pt = app.first_name;
            this.Pu = app.second_name;
            this.Pv = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pw = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Px = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Py = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Pz.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Pz.lego_card) && (nk = com.baidu.tieba.lego.card.b.nk(this.Pz.lego_card)) != null) {
                this.PC = nk.getViewItem(0, 1);
                this.PC.setAdvertAppInfo(this);
            }
        }
    }

    public String pm() {
        com.baidu.tieba.tbadkCore.data.e eVar;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.PI != null) {
            eVar = this.PI;
        } else if (this.PH == null) {
            return "";
        } else {
            eVar = new com.baidu.tieba.tbadkCore.data.e(this.PH);
        }
        if (!eVar.fillInJsonObject(jSONObject)) {
            str = "";
        } else {
            byte[] bytes = jSONObject.toString().getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 47);
            }
            str = new String(com.baidu.adp.lib.util.c.encodeBytesToBytes(bytes));
        }
        return str;
    }

    public AdReq a(String str, long j, String str2, String str3, int i) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.Pv);
        builder.da_ext_info = this.extensionInfo;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Pz.PJ);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Pm;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pw);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Px;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int PJ;
        public String PK;
        public String PM;
        public String PN;
        public String PO;
        public int PP;
        public String PQ;
        public String PR;
        public String PT;
        public List<String> PU = new ArrayList();
        public VideoInfo PV;
        public String PW;
        public String PX;
        public float PY;
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
                this.PJ = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.PK = com.baidu.tbadk.core.util.ax.c(goodsInfo.thread_title, 29, "...");
                this.PN = goodsInfo.thread_pic;
                this.PO = goodsInfo.pop_window_text;
                this.PP = goodsInfo.goods_style.intValue();
                this.PQ = goodsInfo.card_desc;
                this.PR = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.PT = goodsInfo.button_url;
                this.PM = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.PU.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.PV = goodsInfo.video_info;
                    this.PW = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.PX = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.PY = g / g2;
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
                if (this.PP == 7) {
                    if (this.PV != null && !StringUtils.isNull(this.PV.video_url)) {
                        if (this.PV.video_height.intValue() <= 0 || this.PV.video_width.intValue() <= 0) {
                            return false;
                        }
                        return this.PV.video_duration.intValue() > 0;
                    }
                    return false;
                } else if (this.PP == 2) {
                    return !StringUtils.isNull(this.PN);
                } else if (this.PP == 6) {
                    return this.PU != null && this.PU.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.PC != null) {
            return Pk;
        }
        if (this.Pz.PP == 1001) {
            return OY;
        }
        if (this.Pz.PP == 2) {
            return OZ;
        }
        if (this.Pz.PP == 6) {
            return Pa;
        }
        if (this.Pz.PP == 7) {
            return Pc;
        }
        return null;
    }
}
