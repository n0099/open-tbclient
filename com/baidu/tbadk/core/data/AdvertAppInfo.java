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
    public static final BdUniqueId aKs = BdUniqueId.gen();
    public static AtomicBoolean aKt = new AtomicBoolean(false);
    public String aJY;
    public String aKA;
    public int aKB;
    public String aKC;
    public String aKD;
    public int aKE;
    public String aKF;
    public long aKG;
    public String aKJ;
    public String aKK;
    public String aKL;
    private App aKM;
    public AppData aKN;
    public int aKu;
    public String aKv;
    public String aKw;
    public int aKx;
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
    public a aKH = new a();
    public boolean aKI = false;
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
        if (bd.aOu.get() && aKt.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aKH == null || this.aKH.aKT != 1001) {
                if (this.aKH == null || TextUtils.isEmpty(this.aKH.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.aKv) || TextUtils.isEmpty(this.aKv.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aKH.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.xo().xu() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aKH == null || !this.aKH.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aKx);
                }
                if (this.aKx == 3) {
                    if (!xK()) {
                        return 26;
                    }
                } else if (this.aKx == 1) {
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
        if (this.aKH == null || this.aKH.aKT != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aKx != 3 || this.legoCard.checkLegal(this.aKx) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aKx != 3 || TextUtils.isEmpty(this.aKA.trim()) || TextUtils.isEmpty(this.aKz.trim()) || this.aKH == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aKH.userName) || TextUtils.isEmpty(this.aKH.userName.trim())) && TextUtils.isEmpty(this.aKH.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean xL() {
        if (this.aKH == null || this.aKH.aKT != 1001) {
            if (this.aKH == null || this.aKH.aKT != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aKx == 1 && !((TextUtils.isEmpty(this.aKy) || TextUtils.isEmpty(this.aKy.trim())) && TextUtils.isEmpty(this.aKH.lego_card)) : this.aKx == 1 && this.legoCard.checkLegal(this.aKx) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo or;
        if (app != null) {
            this.aKM = app;
            this.aKN = new AppData(app);
            this.aKv = app.id;
            this.aKw = app.name;
            this.aKx = app.url_type.intValue();
            this.aKy = app.url;
            this.aKz = app.apk_url;
            this.deepUrl = app.deep_url;
            this.aKA = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.aKB = app.pos.intValue();
            this.aKC = app.first_name;
            this.aKD = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aKE = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aKF = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aKG = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aKH.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aKH.lego_card) && (or = com.baidu.tieba.lego.card.b.or(this.aKH.lego_card)) != null) {
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
        if (this.aKN != null) {
            appData = this.aKN;
        } else if (this.aKM == null) {
            return "";
        } else {
            appData = new AppData(this.aKM);
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
        builder.da_good_id = String.valueOf(this.aKH.aKO);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.aKv;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aKE);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aKF;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aKO;
        public String aKP;
        public String aKQ;
        public String aKR;
        public String aKS;
        public int aKT;
        public String aKU;
        public String aKV;
        public String aKW;
        public List<String> aKX = new ArrayList();
        public VideoInfo aKY;
        public String aKZ;
        public String aLa;
        public float aLb;
        public AdCloseInfo aLc;
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
                this.aKO = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aKP = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.aKR = goodsInfo.thread_pic;
                this.aKS = goodsInfo.pop_window_text;
                this.aKT = goodsInfo.goods_style.intValue();
                this.aKU = goodsInfo.card_desc;
                this.aKV = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aKW = goodsInfo.button_url;
                this.aKQ = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aKX.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aKY = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aKZ = goodsInfo.tag_name_url;
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
                    this.aLa = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int h3 = com.baidu.adp.lib.g.b.h(split2[0], 1);
                            int h4 = com.baidu.adp.lib.g.b.h(split2[1], 1);
                            if (h4 != 0) {
                                this.aLb = h3 / h4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aLc = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.mA().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.aKH.aKT == 1001 || this.aKH.aKT == -1001) {
            return aKe;
        }
        if (!com.baidu.tbadk.core.i.xo().xu() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aKe;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = aKn;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return aKo;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return aKp;
                case 7:
                    return aKq;
                case 9:
                    return aKs;
                case 10:
                    return aKr;
            }
        }
        return null;
    }
}
