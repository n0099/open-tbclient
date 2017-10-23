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
public class AdvertAppInfo extends bh {
    public int TM;
    public String TO;
    public String TP;
    public int TQ;
    public String TR;
    public String TS;
    public String TT;
    public int TU;
    public String TV;
    public String TW;
    public int TX;
    public String TY;
    public long TZ;
    public String Tt;
    public String Uc;
    public String Ud;
    public String Ue;
    private App Uf;
    public AppData Ug;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
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
    public static final BdUniqueId TK = BdUniqueId.gen();
    public static final BdUniqueId TL = BdUniqueId.gen();
    public a Ua = new a();
    public boolean Ub = false;
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

    public int pm() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Ua == null || this.Ua.Um != 1001) {
            if (this.Ua == null || TextUtils.isEmpty(this.Ua.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.TO) || TextUtils.isEmpty(this.TO.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Ua.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oM().oS() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bh.Yg.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.Ua == null || !this.Ua.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.TQ);
            }
            if (this.TQ == 3) {
                return !pn() ? 26 : 0;
            } else if (this.TQ == 1) {
                return !po() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pn() {
        boolean z = true;
        if (this.Ua == null || this.Ua.Um != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.TQ != 3 || this.legoCard.checkLegal(this.TQ) != 0) {
                    z = false;
                }
                return z;
            } else if (this.TQ != 3 || TextUtils.isEmpty(this.TT.trim()) || TextUtils.isEmpty(this.TS.trim()) || this.Ua == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Ua.userName) || TextUtils.isEmpty(this.Ua.userName.trim())) && TextUtils.isEmpty(this.Ua.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean po() {
        if (this.Ua == null || this.Ua.Um != 1001) {
            if (this.Ua == null || this.Ua.Um != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.TQ == 1 && !((TextUtils.isEmpty(this.TR) || TextUtils.isEmpty(this.TR.trim())) && TextUtils.isEmpty(this.Ua.lego_card)) : this.TQ == 1 && this.legoCard.checkLegal(this.TQ) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nf;
        if (app != null) {
            this.Uf = app;
            this.Ug = new AppData(app);
            this.TO = app.id;
            this.TP = app.name;
            this.TQ = app.url_type.intValue();
            this.TR = app.url;
            this.TS = app.apk_url;
            this.deepUrl = app.deep_url;
            this.TT = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.TU = app.pos.intValue();
            this.TV = app.first_name;
            this.TW = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.TX = app.plan_id.intValue();
            this.userId = app.user_id;
            this.TY = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.TZ = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Ua.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Ua.lego_card) && (nf = com.baidu.tieba.lego.card.b.nf(this.Ua.lego_card)) != null) {
                ICardInfo viewItem = nf.getViewItem(0, 1);
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

    public String pp() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Ug != null) {
            appData = this.Ug;
        } else if (this.Uf == null) {
            return "";
        } else {
            appData = new AppData(this.Uf);
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
        builder.da_good_id = String.valueOf(this.Ua.Uh);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.TO;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.TX);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.TY;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Uh;
        public String Ui;
        public String Uj;
        public String Uk;
        public String Ul;
        public int Um;
        public String Un;
        public String Uo;
        public String Up;
        public List<String> Uq = new ArrayList();
        public VideoInfo Ur;
        public String Us;
        public String Ut;
        public float Uu;
        public AdCloseInfo Uv;
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
                this.Uh = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ui = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.Uk = goodsInfo.thread_pic;
                this.Ul = goodsInfo.pop_window_text;
                this.Um = goodsInfo.goods_style.intValue();
                this.Un = goodsInfo.card_desc;
                this.Uo = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Up = goodsInfo.button_url;
                this.Uj = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Uq.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Ur = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Us = goodsInfo.tag_name_url;
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
                    this.Ut = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Uu = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Uv = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.Ua.Um == 1001 || this.Ua.Um == -1001) {
            return Tz;
        }
        if (!com.baidu.tbadk.core.h.oM().oS() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return Tz;
        }
        if (!StringUtils.isNull(this.Ua.lego_card, true)) {
            return TL;
        }
        return null;
    }
}
