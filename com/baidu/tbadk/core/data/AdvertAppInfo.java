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
public class AdvertAppInfo extends bl {
    public static final BdUniqueId SU = BdUniqueId.gen();
    public static final BdUniqueId SV = BdUniqueId.gen();
    public static final BdUniqueId SW = BdUniqueId.gen();
    public static final BdUniqueId SX = BdUniqueId.gen();
    public static final BdUniqueId SY = BdUniqueId.gen();
    public static final BdUniqueId SZ = BdUniqueId.gen();
    public static final BdUniqueId Ta = BdUniqueId.gen();
    public static final BdUniqueId Tb = BdUniqueId.gen();
    public static final BdUniqueId Tc = BdUniqueId.gen();
    public static final BdUniqueId Td = BdUniqueId.gen();
    public static final BdUniqueId Te = BdUniqueId.gen();
    public static final BdUniqueId Tf = BdUniqueId.gen();
    public static final BdUniqueId Tg = BdUniqueId.gen();
    public String SO;
    public int Th;
    public String Ti;
    public String Tj;
    public int Tk;
    public String Tl;
    public String Tm;
    public String Tn;
    public String To;
    public String Tp;
    public int Tq;
    public String Tr;
    public long Ts;
    public String Tv;
    public String Tw;
    public String Tx;
    private App Ty;
    public AppData Tz;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Tt = new a();
    public boolean Tu = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        int checkLegal(int i);

        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        boolean isNoPicAd();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int pn() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Tt == null || this.Tt.TF != 1001) {
            if (this.Tt == null || TextUtils.isEmpty(this.Tt.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.Ti) || TextUtils.isEmpty(this.Ti.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Tt.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oN().oT() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bl.XO.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.Tt == null || !this.Tt.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.Tk);
            }
            if (this.Tk == 3) {
                return !po() ? 26 : 0;
            } else if (this.Tk == 1) {
                return !pp() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean po() {
        boolean z = true;
        if (this.Tt == null || this.Tt.TF != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Tk != 3 || this.legoCard.checkLegal(this.Tk) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Tk != 3 || TextUtils.isEmpty(this.Tn.trim()) || TextUtils.isEmpty(this.Tm.trim()) || this.Tt == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Tt.userName) || TextUtils.isEmpty(this.Tt.userName.trim())) && TextUtils.isEmpty(this.Tt.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pp() {
        if (this.Tt == null || this.Tt.TF != 1001) {
            if (this.Tt == null || this.Tt.TF != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Tk == 1 && !((TextUtils.isEmpty(this.Tl) || TextUtils.isEmpty(this.Tl.trim())) && TextUtils.isEmpty(this.Tt.lego_card)) : this.Tk == 1 && this.legoCard.checkLegal(this.Tk) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo mV;
        if (app != null) {
            this.Ty = app;
            this.Ti = app.id;
            this.Tj = app.name;
            this.Tk = app.url_type.intValue();
            this.Tl = app.url;
            this.Tm = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Tn = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.To = app.first_name;
            this.Tp = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Tq = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Tr = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ts = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Tt.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Tt.lego_card) && (mV = com.baidu.tieba.lego.card.b.mV(this.Tt.lego_card)) != null) {
                ICardInfo viewItem = mV.getViewItem(0, 1);
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

    public String pq() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Tz != null) {
            appData = this.Tz;
        } else if (this.Ty == null) {
            return "";
        } else {
            appData = new AppData(this.Ty);
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
        builder.da_good_id = String.valueOf(this.Tt.TA);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Ti;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Tq);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Tr;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int TA;
        public String TB;
        public String TC;
        public String TD;
        public String TE;
        public int TF;
        public String TG;
        public String TH;
        public String TI;
        public List<String> TJ = new ArrayList();
        public VideoInfo TK;
        public String TL;
        public String TM;
        public String TO;
        public float TP;
        public AdCloseInfo TQ;
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
                this.TA = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.TB = com.baidu.tbadk.core.util.al.c(goodsInfo.thread_title, 29, "...");
                this.TD = goodsInfo.thread_pic;
                this.TE = goodsInfo.pop_window_text;
                this.TF = goodsInfo.goods_style.intValue();
                this.TG = goodsInfo.card_desc;
                this.TH = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.TI = goodsInfo.button_url;
                this.TC = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.TJ.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.TK = goodsInfo.video_info;
                    this.TL = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.TM = goodsInfo.tag_name_url;
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
                    this.TO = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.al.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.TP = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.TQ = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.Tt.TF == 1001 || this.Tt.TF == -1001) {
            return SU;
        }
        if (!StringUtils.isNull(this.Tt.lego_card, true)) {
            return Tg;
        }
        return null;
    }
}
