package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bm {
    public static final BdUniqueId SF = BdUniqueId.gen();
    public static final BdUniqueId SG = BdUniqueId.gen();
    public static final BdUniqueId SH = BdUniqueId.gen();
    public static final BdUniqueId SI = BdUniqueId.gen();
    public static final BdUniqueId SJ = BdUniqueId.gen();
    public static final BdUniqueId SK = BdUniqueId.gen();
    public static final BdUniqueId SL = BdUniqueId.gen();
    public static final BdUniqueId SM = BdUniqueId.gen();
    public static final BdUniqueId SN = BdUniqueId.gen();
    public static final BdUniqueId SO = BdUniqueId.gen();
    public static final BdUniqueId SP = BdUniqueId.gen();
    public static final BdUniqueId SQ = BdUniqueId.gen();
    public static final BdUniqueId SR = BdUniqueId.gen();
    public int SS;
    public String ST;
    public String SU;
    public int SV;
    public String SW;
    public String SX;
    public String SY;
    public String SZ;
    public String Sz;
    public String Ta;
    public int Tb;
    public String Tc;
    public long Td;
    public String Tg;
    public String Th;
    public String Ti;
    private App Tj;
    public AppData Tk;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Te = new a();
    public boolean Tf = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        boolean isNoPicAd();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int pk() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.e.eY().ad("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Te == null || TextUtils.isEmpty(this.Te.lego_card)) {
            return 11;
        }
        if (this.Te == null || this.Te.Tq != 1001) {
            if (TextUtils.isEmpty(this.ST) || TextUtils.isEmpty(this.ST.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Te.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.r.oK().oQ() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bm.Xx.get() || !TbadkCoreApplication.m9getInst().isRecAppExist()) {
                return 31;
            }
            if (this.Te == null || !this.Te.isValid()) {
                return 25;
            }
            if (this.SV == 3) {
                return !pl() ? 26 : 0;
            } else if (this.SV == 1) {
                return !pm() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pl() {
        if ((this.Te != null && this.Te.Tq == 1001) || this.SV != 3 || TextUtils.isEmpty(this.SY.trim()) || TextUtils.isEmpty(this.SX.trim()) || this.Te == null) {
            return false;
        }
        return ((TextUtils.isEmpty(this.Te.userName) || TextUtils.isEmpty(this.Te.userName.trim())) && TextUtils.isEmpty(this.Te.lego_card)) ? false : true;
    }

    public boolean pm() {
        if (this.Te == null || this.Te.Tq != 1001) {
            return this.SV == 1 && !((TextUtils.isEmpty(this.SW) || TextUtils.isEmpty(this.SW.trim())) && TextUtils.isEmpty(this.Te.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo mF;
        if (app != null) {
            this.Tj = app;
            this.ST = app.id;
            this.SU = app.name;
            this.SV = app.url_type.intValue();
            this.SW = app.url;
            this.SX = app.apk_url;
            this.deepUrl = app.deep_url;
            this.SY = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.SZ = app.first_name;
            this.Ta = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Tb = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Tc = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Td = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Te.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eY().ad("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Te.lego_card) && (mF = com.baidu.tieba.lego.card.b.mF(this.Te.lego_card)) != null) {
                ICardInfo viewItem = mF.getViewItem(0, 1);
                if (viewItem instanceof ILegoAdvert) {
                    this.legoCard = (ILegoAdvert) viewItem;
                    this.legoCard.setAdvertAppInfo(this);
                    return;
                }
                this.legoCard = null;
                BdLog.e("Got invalid card for ad, " + (viewItem == null ? "null ad" : String.valueOf(viewItem)));
            }
        }
    }

    public String pn() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Tk != null) {
            appData = this.Tk;
        } else if (this.Tj == null) {
            return "";
        } else {
            appData = new AppData(this.Tj);
        }
        if (!appData.fillInJsonObject(jSONObject)) {
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
        builder.da_cpid = String.valueOf(this.cpid);
        builder.da_ext_info = this.extensionInfo;
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.Te.Tl);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.ST;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Tb);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Tc;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo TA;
        public int Tl;
        public String Tm;
        public String Tn;
        public String To;
        public String Tp;
        public int Tq;
        public String Tr;
        public String Ts;
        public String Tt;
        public List<String> Tu = new ArrayList();
        public VideoInfo Tv;
        public String Tw;
        public String Tx;
        public String Ty;
        public float Tz;
        public String adSource;
        public String buttonText;
        public int height;
        public String lego_card;
        public boolean needResize;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Tl = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Tm = com.baidu.tbadk.core.util.aw.c(goodsInfo.thread_title, 29, "...");
                this.To = goodsInfo.thread_pic;
                this.Tp = goodsInfo.pop_window_text;
                this.Tq = goodsInfo.goods_style.intValue();
                this.Tr = goodsInfo.card_desc;
                this.Ts = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Tt = goodsInfo.button_url;
                this.Tn = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Tu.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Tv = goodsInfo.video_info;
                    this.Tw = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Tx = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.Ty = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aw.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Tz = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.TA = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.e.eY().ad("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.Te.Tq == 1001) {
            return SF;
        }
        if (!StringUtils.isNull(this.Te.lego_card, true)) {
            return SR;
        }
        return null;
    }
}
