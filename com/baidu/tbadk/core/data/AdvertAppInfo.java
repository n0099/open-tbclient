package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bd {
    public String abtest;
    public int adK;
    public String adL;
    public String adM;
    public int adN;
    public String adO;
    public String adP;
    public String adPosition;
    public String adQ;
    public int adR;
    public String adS;
    public String adT;
    public int adU;
    public String adV;
    public long adW;
    public String adp;
    public b advertAppContext;
    public String aea;
    public String aeb;
    public String aec;
    private App aed;
    public AppData aee;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId adu = BdUniqueId.gen();
    public static final BdUniqueId adv = BdUniqueId.gen();
    public static final BdUniqueId adw = BdUniqueId.gen();
    public static final BdUniqueId adx = BdUniqueId.gen();
    public static final BdUniqueId ady = BdUniqueId.gen();
    public static final BdUniqueId adz = BdUniqueId.gen();
    public static final BdUniqueId adA = BdUniqueId.gen();
    public static final BdUniqueId adB = BdUniqueId.gen();
    public static final BdUniqueId adC = BdUniqueId.gen();
    public static final BdUniqueId adD = BdUniqueId.gen();
    public static final BdUniqueId adE = BdUniqueId.gen();
    public static final BdUniqueId adF = BdUniqueId.gen();
    public static final BdUniqueId adG = BdUniqueId.gen();
    public static final BdUniqueId adH = BdUniqueId.gen();
    public static final BdUniqueId adI = BdUniqueId.gen();
    public static AtomicBoolean adJ = new AtomicBoolean(false);
    public a adX = new a();
    public boolean adY = false;
    public ILegoAdvert legoCard = null;
    private int adZ = 32;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        int checkLegal(int i);

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        String getExtInfo();

        int getGoodsStyle();

        boolean isNoPicAd();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int tN() {
        if (bd.ahU.get() && adJ.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.adX == null || this.adX.aek != 1001) {
                if (this.adX == null || TextUtils.isEmpty(this.adX.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.adL) || TextUtils.isEmpty(this.adL.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.adX.isValid()) {
                    return this.adZ;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.tt().tz() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.adX == null || !this.adX.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.adN);
                }
                if (this.adN == 3) {
                    if (!tO()) {
                        return 26;
                    }
                } else if (this.adN == 1) {
                    if (!tP()) {
                        return 27;
                    }
                } else {
                    return 21;
                }
                return 0;
            }
            return 0;
        }
        return 31;
    }

    public boolean tO() {
        boolean z = true;
        if (this.adX == null || this.adX.aek != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.adN != 3 || this.legoCard.checkLegal(this.adN) != 0) {
                    z = false;
                }
                return z;
            } else if (this.adN != 3 || TextUtils.isEmpty(this.adQ.trim()) || TextUtils.isEmpty(this.adP.trim()) || this.adX == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.adX.userName) || TextUtils.isEmpty(this.adX.userName.trim())) && TextUtils.isEmpty(this.adX.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean tP() {
        if (this.adX == null || this.adX.aek != 1001) {
            if (this.adX == null || this.adX.aek != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.adN == 1 && !((TextUtils.isEmpty(this.adO) || TextUtils.isEmpty(this.adO.trim())) && TextUtils.isEmpty(this.adX.lego_card)) : this.adN == 1 && this.legoCard.checkLegal(this.adN) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.aed = app;
            this.aee = new AppData(app);
            this.adL = app.id;
            this.adM = app.name;
            this.adN = app.url_type.intValue();
            this.adO = app.url;
            this.adP = app.apk_url;
            this.deepUrl = app.deep_url;
            this.adQ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.adR = app.pos.intValue();
            this.adS = app.first_name;
            this.adT = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.adU = app.plan_id.intValue();
            this.userId = app.user_id;
            this.adV = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.adW = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.adX.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.adX.lego_card)) {
                try {
                    ICardInfo pl = com.baidu.tieba.lego.card.b.pl(this.adX.lego_card);
                    if (pl != null) {
                        ICardInfo viewItem = pl.getViewItem(0, 1);
                        if (viewItem instanceof ILegoAdvert) {
                            this.legoCard = (ILegoAdvert) viewItem;
                            this.legoCard.setAdvertAppInfo(this);
                            return;
                        }
                        this.legoCard = null;
                        BdLog.e("Got invalid card for ad, " + (viewItem == null ? "null ad" : String.valueOf(viewItem)));
                    }
                } catch (Exception e) {
                    if (e instanceof JSONException) {
                        this.adZ = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.adZ = 40;
                        } else {
                            this.adZ = 39;
                        }
                    }
                    this.legoCard = null;
                }
            }
        }
    }

    public String adCollect() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.aee != null) {
            appData = this.aee;
        } else if (this.aed == null) {
            return "";
        } else {
            appData = new AppData(this.aed);
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
        builder.da_good_id = String.valueOf(this.adX.aef);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.adL;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.adU);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.adV;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String adSource;
        public int aef;
        public String aeg;
        public String aeh;
        public String aei;
        public String aej;
        public int aek;
        public String ael;
        public String aem;
        public String aen;
        public List<String> aeo = new ArrayList();
        public VideoInfo aep;
        public String aeq;
        public String aer;
        public float aes;
        public AdCloseInfo aet;
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
                this.aef = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aeg = com.baidu.tbadk.core.util.ao.d(goodsInfo.thread_title, 29, "...");
                this.aei = goodsInfo.thread_pic;
                this.aej = goodsInfo.pop_window_text;
                this.aek = goodsInfo.goods_style.intValue();
                this.ael = goodsInfo.card_desc;
                this.aem = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aen = goodsInfo.button_url;
                this.aeh = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aeo.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aep = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aeq = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.aer = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.aes = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aet = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.adX.aek == 1001 || this.adX.aek == -1001) {
            return adu;
        }
        if (!com.baidu.tbadk.core.i.tt().tz() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return adu;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = adD;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return adE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return adF;
                case 7:
                    return adG;
                case 9:
                    return adI;
                case 10:
                    return adH;
            }
        }
        return null;
    }
}
