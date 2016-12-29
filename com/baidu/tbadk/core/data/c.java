package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class c extends bg {
    public static final BdUniqueId OU = BdUniqueId.gen();
    public static final BdUniqueId OV = BdUniqueId.gen();
    public static final BdUniqueId OW = BdUniqueId.gen();
    public static final BdUniqueId OX = BdUniqueId.gen();
    public static final BdUniqueId OY = BdUniqueId.gen();
    public static final BdUniqueId OZ = BdUniqueId.gen();
    public static final BdUniqueId Pa = BdUniqueId.gen();
    public static final BdUniqueId Pc = BdUniqueId.gen();
    public static final BdUniqueId Pd = BdUniqueId.gen();
    public static final BdUniqueId Pe = BdUniqueId.gen();
    public static final BdUniqueId Pf = BdUniqueId.gen();
    public static final BdUniqueId Pg = BdUniqueId.gen();
    public static final BdUniqueId Ph = BdUniqueId.gen();
    public String OO;
    public String PA;
    public String PC;
    public String PD;
    private App PE;
    public com.baidu.tieba.tbadkCore.data.e PF;
    public int Pi;
    public String Pj;
    public String Pk;
    public int Pl;
    public String Pm;
    public String Pn;
    public String Po;
    public String Pp;
    public String Pq;
    public String Pr;
    public int Ps;
    public int Pt;
    public String Pu;
    public long Pv;
    public a Pw = new a();
    public boolean Px = false;
    public ICardInfo Py = null;
    public b Pz;
    public String abtest;
    public String adPosition;
    public String extensionInfo;
    public String price;
    public String userId;

    public boolean pj() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.Pw.PL == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.Pj) || TextUtils.isEmpty(this.Pj.trim())) {
            return false;
        }
        int ac = com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.Pw.lego_card) || !(ac == 0 || this.Py == null)) {
            if ((TextUtils.isEmpty(this.Pw.lego_card) || bg.Tr.get() || bg.Tt.get()) && this.Pw != null && this.Pw.isValid() && this.Pl != 2) {
                return pk() || pl();
            }
            return false;
        }
        return false;
    }

    public boolean pk() {
        return (this.Pl != 3 || TextUtils.isEmpty(this.Pp.trim()) || TextUtils.isEmpty(this.Pn.trim()) || this.Pw == null || ((TextUtils.isEmpty(this.Pw.userName) || TextUtils.isEmpty(this.Pw.userName.trim())) && TextUtils.isEmpty(this.Pw.lego_card))) ? false : true;
    }

    public boolean pl() {
        if (this.Pw == null || this.Pw.PL != 1001) {
            return this.Pl == 1 && !((TextUtils.isEmpty(this.Pm) || TextUtils.isEmpty(this.Pm.trim())) && TextUtils.isEmpty(this.Pw.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ly;
        if (app != null) {
            this.PE = app;
            this.Pj = app.id;
            this.Pk = app.name;
            this.Pl = app.url_type.intValue();
            this.Pm = app.url;
            this.Pn = app.apk_url;
            this.Po = app.deep_url;
            this.Pp = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Pq = app.first_name;
            this.Pr = app.second_name;
            this.Ps = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Pt = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Pu = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Pv = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Pw.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Pw.lego_card) && (ly = com.baidu.tieba.lego.card.b.ly(this.Pw.lego_card)) != null) {
                this.Py = ly.getViewItem(0, 1);
                this.Py.setAdvertAppInfo(this);
            }
        }
    }

    public String pm() {
        com.baidu.tieba.tbadkCore.data.e eVar;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.PF != null) {
            eVar = this.PF;
        } else if (this.PE == null) {
            return "";
        } else {
            eVar = new com.baidu.tieba.tbadkCore.data.e(this.PE);
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
        builder.da_cpid = String.valueOf(this.Ps);
        builder.da_ext_info = this.extensionInfo;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.h.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Pw.PG);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Pj;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Pt);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Pu;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int PG;
        public String PH;
        public String PI;
        public String PJ;
        public String PK;
        public int PL;
        public String PM;
        public String PN;
        public String PO;
        public List<String> PP = new ArrayList();
        public VideoInfo PQ;
        public String PR;
        public String PS;
        public float PT;
        public String PU;
        public float PV;
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
                this.PG = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.PH = com.baidu.tbadk.core.util.av.c(goodsInfo.thread_title, 29, "...");
                this.PJ = goodsInfo.thread_pic;
                this.PK = goodsInfo.pop_window_text;
                this.PL = goodsInfo.goods_style.intValue();
                this.PM = goodsInfo.card_desc;
                this.PN = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.PO = goodsInfo.button_url;
                this.PI = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.PP.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.PQ = goodsInfo.video_info;
                    this.PR = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.PS = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.PT = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.PU = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.av.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.h.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.h.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.PV = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.PL == 7 || this.PL == 9) {
                    if (this.PQ != null && !StringUtils.isNull(this.PQ.video_url)) {
                        if (this.PQ.video_height.intValue() <= 0 || this.PQ.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.PQ.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.PL == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.PL == 2) {
                    return !StringUtils.isNull(this.PJ);
                } else if (this.PL == 6) {
                    return this.PP != null && this.PP.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.Pw.lego_card, true)) {
            return Ph;
        }
        if (this.Pw.PL == 1001) {
            return OU;
        }
        if (this.Pw.PL == 2) {
            return OV;
        }
        if (this.Pw.PL == 6) {
            return OW;
        }
        if (this.Pw.PL == 7) {
            return OX;
        }
        if (this.Pw.PL == 9) {
            return OY;
        }
        return null;
    }
}
