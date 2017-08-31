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
public class AdvertAppInfo extends bj {
    public int TK;
    public String TL;
    public String TM;
    public int TO;
    public String TP;
    public String TQ;
    public String TR;
    public int TS;
    public String TT;
    public String TU;
    public int TV;
    public String TW;
    public long TX;
    public String Tr;
    public String Ua;
    public String Ub;
    public String Uc;
    private App Ud;
    public AppData Ue;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId Tx = BdUniqueId.gen();
    public static final BdUniqueId Ty = BdUniqueId.gen();
    public static final BdUniqueId Tz = BdUniqueId.gen();
    public static final BdUniqueId TA = BdUniqueId.gen();
    public static final BdUniqueId TB = BdUniqueId.gen();
    public static final BdUniqueId TC = BdUniqueId.gen();
    public static final BdUniqueId TD = BdUniqueId.gen();
    public static final BdUniqueId TE = BdUniqueId.gen();
    public static final BdUniqueId TF = BdUniqueId.gen();
    public static final BdUniqueId TG = BdUniqueId.gen();
    public static final BdUniqueId TH = BdUniqueId.gen();
    public static final BdUniqueId TI = BdUniqueId.gen();
    public static final BdUniqueId TJ = BdUniqueId.gen();
    public a TY = new a();
    public boolean TZ = false;
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

    public int ps() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.TY == null || this.TY.Uk != 1001) {
            if (this.TY == null || TextUtils.isEmpty(this.TY.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.TL) || TextUtils.isEmpty(this.TL.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.TY.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oS().oY() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bj.Yr.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.TY == null || !this.TY.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.TO);
            }
            if (this.TO == 3) {
                return !pt() ? 26 : 0;
            } else if (this.TO == 1) {
                return !pu() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pt() {
        boolean z = true;
        if (this.TY == null || this.TY.Uk != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.TO != 3 || this.legoCard.checkLegal(this.TO) != 0) {
                    z = false;
                }
                return z;
            } else if (this.TO != 3 || TextUtils.isEmpty(this.TR.trim()) || TextUtils.isEmpty(this.TQ.trim()) || this.TY == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.TY.userName) || TextUtils.isEmpty(this.TY.userName.trim())) && TextUtils.isEmpty(this.TY.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pu() {
        if (this.TY == null || this.TY.Uk != 1001) {
            if (this.TY == null || this.TY.Uk != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.TO == 1 && !((TextUtils.isEmpty(this.TP) || TextUtils.isEmpty(this.TP.trim())) && TextUtils.isEmpty(this.TY.lego_card)) : this.TO == 1 && this.legoCard.checkLegal(this.TO) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nA;
        if (app != null) {
            this.Ud = app;
            this.Ue = new AppData(app);
            this.TL = app.id;
            this.TM = app.name;
            this.TO = app.url_type.intValue();
            this.TP = app.url;
            this.TQ = app.apk_url;
            this.deepUrl = app.deep_url;
            this.TR = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.TS = app.pos.intValue();
            this.TT = app.first_name;
            this.TU = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.TV = app.plan_id.intValue();
            this.userId = app.user_id;
            this.TW = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.TX = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.TY.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.TY.lego_card) && (nA = com.baidu.tieba.lego.card.b.nA(this.TY.lego_card)) != null) {
                ICardInfo viewItem = nA.getViewItem(0, 1);
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

    public String pv() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Ue != null) {
            appData = this.Ue;
        } else if (this.Ud == null) {
            return "";
        } else {
            appData = new AppData(this.Ud);
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
        builder.da_good_id = String.valueOf(this.TY.Uf);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.TL;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.TV);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.TW;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Uf;
        public String Ug;
        public String Uh;
        public String Ui;
        public String Uj;
        public int Uk;
        public String Ul;
        public String Um;
        public String Un;
        public List<String> Uo = new ArrayList();
        public VideoInfo Up;
        public String Uq;
        public String Ur;
        public float Us;
        public AdCloseInfo Ut;
        public String adSource;
        public String buttonText;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Uf = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ug = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.Ui = goodsInfo.thread_pic;
                this.Uj = goodsInfo.pop_window_text;
                this.Uk = goodsInfo.goods_style.intValue();
                this.Ul = goodsInfo.card_desc;
                this.Um = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Un = goodsInfo.button_url;
                this.Uh = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Uo.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Up = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Uq = goodsInfo.tag_name_url;
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
                    this.Ur = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Us = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Ut = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eW().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.TY.Uk == 1001 || this.TY.Uk == -1001) {
            return Tx;
        }
        if (!StringUtils.isNull(this.TY.lego_card, true)) {
            return TJ;
        }
        return null;
    }
}
