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
public class AdvertAppInfo extends be {
    public static final BdUniqueId aIU = BdUniqueId.gen();
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
    public static AtomicBoolean aJj = new AtomicBoolean(false);
    public String aIO;
    public String aJA;
    public String aJB;
    private App aJC;
    public AppData aJD;
    public int aJk;
    public String aJl;
    public String aJm;
    public int aJn;
    public String aJo;
    public String aJp;
    public String aJq;
    public int aJr;
    public String aJs;
    public String aJt;
    public int aJu;
    public String aJv;
    public long aJw;
    public String aJz;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a aJx = new a();
    public boolean aJy = false;
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
        if (be.aNm.get() && aJj.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.mz().an("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aJx == null || this.aJx.aJJ != 1001) {
                if (this.aJx == null || TextUtils.isEmpty(this.aJx.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.aJl) || TextUtils.isEmpty(this.aJl.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aJx.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.wB().wH() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aJx == null || !this.aJx.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aJn);
                }
                if (this.aJn == 3) {
                    if (!xa()) {
                        return 26;
                    }
                } else if (this.aJn == 1) {
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
        if (this.aJx == null || this.aJx.aJJ != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aJn != 3 || this.legoCard.checkLegal(this.aJn) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aJn != 3 || TextUtils.isEmpty(this.aJq.trim()) || TextUtils.isEmpty(this.aJp.trim()) || this.aJx == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aJx.userName) || TextUtils.isEmpty(this.aJx.userName.trim())) && TextUtils.isEmpty(this.aJx.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean xb() {
        if (this.aJx == null || this.aJx.aJJ != 1001) {
            if (this.aJx == null || this.aJx.aJJ != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aJn == 1 && !((TextUtils.isEmpty(this.aJo) || TextUtils.isEmpty(this.aJo.trim())) && TextUtils.isEmpty(this.aJx.lego_card)) : this.aJn == 1 && this.legoCard.checkLegal(this.aJn) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nU;
        if (app != null) {
            this.aJC = app;
            this.aJD = new AppData(app);
            this.aJl = app.id;
            this.aJm = app.name;
            this.aJn = app.url_type.intValue();
            this.aJo = app.url;
            this.aJp = app.apk_url;
            this.deepUrl = app.deep_url;
            this.aJq = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.aJr = app.pos.intValue();
            this.aJs = app.first_name;
            this.aJt = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aJu = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aJv = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aJw = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aJx.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.mz().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aJx.lego_card) && (nU = com.baidu.tieba.lego.card.b.nU(this.aJx.lego_card)) != null) {
                ICardInfo viewItem = nU.getViewItem(0, 1);
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
        if (this.aJD != null) {
            appData = this.aJD;
        } else if (this.aJC == null) {
            return "";
        } else {
            appData = new AppData(this.aJC);
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
        builder.da_good_id = String.valueOf(this.aJx.aJE);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.aJl;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aJu);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aJv;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aJE;
        public String aJF;
        public String aJG;
        public String aJH;
        public String aJI;
        public int aJJ;
        public String aJK;
        public String aJL;
        public String aJM;
        public List<String> aJN = new ArrayList();
        public VideoInfo aJO;
        public String aJP;
        public String aJQ;
        public float aJR;
        public AdCloseInfo aJS;
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
                this.aJE = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aJF = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.aJH = goodsInfo.thread_pic;
                this.aJI = goodsInfo.pop_window_text;
                this.aJJ = goodsInfo.goods_style.intValue();
                this.aJK = goodsInfo.card_desc;
                this.aJL = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aJM = goodsInfo.button_url;
                this.aJG = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aJN.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aJO = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aJP = goodsInfo.tag_name_url;
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
                    this.aJQ = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int h3 = com.baidu.adp.lib.g.b.h(split2[0], 1);
                            int h4 = com.baidu.adp.lib.g.b.h(split2[1], 1);
                            if (h4 != 0) {
                                this.aJR = h3 / h4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aJS = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.mz().an("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.aJx.aJJ == 1001 || this.aJx.aJJ == -1001) {
            return aIU;
        }
        if (!com.baidu.tbadk.core.i.wB().wH() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aIU;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = aJd;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return aJe;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return aJf;
                case 7:
                    return aJg;
                case 9:
                    return aJi;
                case 10:
                    return aJh;
            }
        }
        return null;
    }
}
