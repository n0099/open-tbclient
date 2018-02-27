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
    public static final BdUniqueId aKd = BdUniqueId.gen();
    public static final BdUniqueId aKe = BdUniqueId.gen();
    public static final BdUniqueId aKf = BdUniqueId.gen();
    public static final BdUniqueId aKg = BdUniqueId.gen();
    public static final BdUniqueId aKh = BdUniqueId.gen();
    public static final BdUniqueId aKi = BdUniqueId.gen();
    public static final BdUniqueId aKj = BdUniqueId.gen();
    public static final BdUniqueId aKk = BdUniqueId.gen();
    public static final BdUniqueId aKl = BdUniqueId.gen();
    public static final BdUniqueId aKm = BdUniqueId.gen();
    public static final BdUniqueId aKn = BdUniqueId.gen();
    public static final BdUniqueId aKo = BdUniqueId.gen();
    public static final BdUniqueId aKp = BdUniqueId.gen();
    public static final BdUniqueId aKq = BdUniqueId.gen();
    public static final BdUniqueId aKr = BdUniqueId.gen();
    public static AtomicBoolean aKs = new AtomicBoolean(false);
    public String aJX;
    public int aKA;
    public String aKB;
    public String aKC;
    public int aKD;
    public String aKE;
    public long aKF;
    public String aKI;
    public String aKJ;
    public String aKK;
    private App aKL;
    public AppData aKM;
    public int aKt;
    public String aKu;
    public String aKv;
    public int aKw;
    public String aKx;
    public String aKy;
    public String aKz;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a aKG = new a();
    public boolean aKH = false;
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

    public int xJ() {
        if (bd.aOt.get() && aKs.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aKG == null || this.aKG.aKS != 1001) {
                if (this.aKG == null || TextUtils.isEmpty(this.aKG.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.aKu) || TextUtils.isEmpty(this.aKu.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aKG.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.xo().xu() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aKG == null || !this.aKG.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aKw);
                }
                if (this.aKw == 3) {
                    if (!xK()) {
                        return 26;
                    }
                } else if (this.aKw == 1) {
                    if (!xL()) {
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

    public boolean xK() {
        boolean z = true;
        if (this.aKG == null || this.aKG.aKS != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aKw != 3 || this.legoCard.checkLegal(this.aKw) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aKw != 3 || TextUtils.isEmpty(this.aKz.trim()) || TextUtils.isEmpty(this.aKy.trim()) || this.aKG == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aKG.userName) || TextUtils.isEmpty(this.aKG.userName.trim())) && TextUtils.isEmpty(this.aKG.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean xL() {
        if (this.aKG == null || this.aKG.aKS != 1001) {
            if (this.aKG == null || this.aKG.aKS != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aKw == 1 && !((TextUtils.isEmpty(this.aKx) || TextUtils.isEmpty(this.aKx.trim())) && TextUtils.isEmpty(this.aKG.lego_card)) : this.aKw == 1 && this.legoCard.checkLegal(this.aKw) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo or;
        if (app != null) {
            this.aKL = app;
            this.aKM = new AppData(app);
            this.aKu = app.id;
            this.aKv = app.name;
            this.aKw = app.url_type.intValue();
            this.aKx = app.url;
            this.aKy = app.apk_url;
            this.deepUrl = app.deep_url;
            this.aKz = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.aKA = app.pos.intValue();
            this.aKB = app.first_name;
            this.aKC = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aKD = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aKE = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aKF = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aKG.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aKG.lego_card) && (or = com.baidu.tieba.lego.card.b.or(this.aKG.lego_card)) != null) {
                ICardInfo viewItem = or.getViewItem(0, 1);
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

    public String xM() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.aKM != null) {
            appData = this.aKM;
        } else if (this.aKL == null) {
            return "";
        } else {
            appData = new AppData(this.aKL);
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
        builder.da_good_id = String.valueOf(this.aKG.aKN);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.aKu;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aKD);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aKE;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aKN;
        public String aKO;
        public String aKP;
        public String aKQ;
        public String aKR;
        public int aKS;
        public String aKT;
        public String aKU;
        public String aKV;
        public List<String> aKW = new ArrayList();
        public VideoInfo aKX;
        public String aKY;
        public String aKZ;
        public float aLa;
        public AdCloseInfo aLb;
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
                this.aKN = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aKO = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.aKQ = goodsInfo.thread_pic;
                this.aKR = goodsInfo.pop_window_text;
                this.aKS = goodsInfo.goods_style.intValue();
                this.aKT = goodsInfo.card_desc;
                this.aKU = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aKV = goodsInfo.button_url;
                this.aKP = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aKW.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aKX = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aKY = goodsInfo.tag_name_url;
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
                    this.aKZ = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int h3 = com.baidu.adp.lib.g.b.h(split2[0], 1);
                            int h4 = com.baidu.adp.lib.g.b.h(split2[1], 1);
                            if (h4 != 0) {
                                this.aLa = h3 / h4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aLb = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.aKG.aKS == 1001 || this.aKG.aKS == -1001) {
            return aKd;
        }
        if (!com.baidu.tbadk.core.i.xo().xu() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aKd;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = aKm;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return aKn;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return aKo;
                case 7:
                    return aKp;
                case 9:
                    return aKr;
                case 10:
                    return aKq;
            }
        }
        return null;
    }
}
