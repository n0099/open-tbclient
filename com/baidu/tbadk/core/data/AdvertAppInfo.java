package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bd {
    public static final BdUniqueId aIV = BdUniqueId.gen();
    public static final BdUniqueId aIW = BdUniqueId.gen();
    public static final BdUniqueId aIX = BdUniqueId.gen();
    public static final BdUniqueId aIY = BdUniqueId.gen();
    public static final BdUniqueId aIZ = BdUniqueId.gen();
    public static final BdUniqueId aJa = BdUniqueId.gen();
    public static final BdUniqueId aJb = BdUniqueId.gen();
    public static final BdUniqueId aJc = BdUniqueId.gen();
    public static final BdUniqueId aJd = BdUniqueId.gen();
    public static final BdUniqueId aJe = BdUniqueId.gen();
    public static final BdUniqueId aJf = BdUniqueId.gen();
    public static final BdUniqueId aJg = BdUniqueId.gen();
    public static final BdUniqueId aJh = BdUniqueId.gen();
    public static final BdUniqueId aJi = BdUniqueId.gen();
    public static final BdUniqueId aJj = BdUniqueId.gen();
    public static AtomicBoolean aJk = new AtomicBoolean(false);
    public String aIP;
    public String aJA;
    public String aJB;
    public String aJC;
    private App aJD;
    public AppData aJE;
    public int aJl;
    public String aJm;
    public String aJn;
    public int aJo;
    public String aJp;
    public String aJq;
    public String aJr;
    public int aJs;
    public String aJt;
    public String aJu;
    public int aJv;
    public String aJw;
    public long aJx;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a aJy = new a();
    public boolean aJz = false;
    public ILegoAdvert legoCard = null;

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

    public int wZ() {
        if (bd.aNl.get() && aJk.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aJy == null || this.aJy.aJK != 1001) {
                if (this.aJy == null || TextUtils.isEmpty(this.aJy.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.aJm) || TextUtils.isEmpty(this.aJm.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aJy.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.wB().wH() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aJy == null || !this.aJy.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aJo);
                }
                if (this.aJo == 3) {
                    if (!xa()) {
                        return 26;
                    }
                } else if (this.aJo == 1) {
                    if (!xb()) {
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

    public boolean xa() {
        boolean z = true;
        if (this.aJy == null || this.aJy.aJK != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aJo != 3 || this.legoCard.checkLegal(this.aJo) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aJo != 3 || TextUtils.isEmpty(this.aJr.trim()) || TextUtils.isEmpty(this.aJq.trim()) || this.aJy == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aJy.userName) || TextUtils.isEmpty(this.aJy.userName.trim())) && TextUtils.isEmpty(this.aJy.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean xb() {
        if (this.aJy == null || this.aJy.aJK != 1001) {
            if (this.aJy == null || this.aJy.aJK != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aJo == 1 && !((TextUtils.isEmpty(this.aJp) || TextUtils.isEmpty(this.aJp.trim())) && TextUtils.isEmpty(this.aJy.lego_card)) : this.aJo == 1 && this.legoCard.checkLegal(this.aJo) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo oe;
        if (app != null) {
            this.aJD = app;
            this.aJE = new AppData(app);
            this.aJm = app.id;
            this.aJn = app.name;
            this.aJo = app.url_type.intValue();
            this.aJp = app.url;
            this.aJq = app.apk_url;
            this.deepUrl = app.deep_url;
            this.aJr = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.aJs = app.pos.intValue();
            this.aJt = app.first_name;
            this.aJu = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aJv = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aJw = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aJx = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aJy.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aJy.lego_card) && (oe = com.baidu.tieba.lego.card.b.oe(this.aJy.lego_card)) != null) {
                ICardInfo viewItem = oe.getViewItem(0, 1);
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

    public String xc() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.aJE != null) {
            appData = this.aJE;
        } else if (this.aJD == null) {
            return "";
        } else {
            appData = new AppData(this.aJD);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.h(str, 0));
        builder.da_good_id = String.valueOf(this.aJy.aJF);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.aJm;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aJv);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aJw;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aJF;
        public String aJG;
        public String aJH;
        public String aJI;
        public String aJJ;
        public int aJK;
        public String aJL;
        public String aJM;
        public String aJN;
        public List<String> aJO = new ArrayList();
        public VideoInfo aJP;
        public String aJQ;
        public String aJR;
        public float aJS;
        public AdCloseInfo aJT;
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
                this.aJF = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aJG = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.aJI = goodsInfo.thread_pic;
                this.aJJ = goodsInfo.pop_window_text;
                this.aJK = goodsInfo.goods_style.intValue();
                this.aJL = goodsInfo.card_desc;
                this.aJM = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aJN = goodsInfo.button_url;
                this.aJH = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aJO.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aJP = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aJQ = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int h = com.baidu.adp.lib.g.b.h(split[0], 1);
                            int h2 = com.baidu.adp.lib.g.b.h(split[1], 1);
                            if (h2 != 0) {
                                this.tagRatio = h / h2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.aJR = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int h3 = com.baidu.adp.lib.g.b.h(split2[0], 1);
                            int h4 = com.baidu.adp.lib.g.b.h(split2[1], 1);
                            if (h4 != 0) {
                                this.aJS = h3 / h4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aJT = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.aJy.aJK == 1001 || this.aJy.aJK == -1001) {
            return aIV;
        }
        if (!com.baidu.tbadk.core.i.wB().wH() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aIV;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = aJe;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return aJf;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return aJg;
                case 7:
                    return aJh;
                case 9:
                    return aJj;
                case 10:
                    return aJi;
            }
        }
        return null;
    }
}
