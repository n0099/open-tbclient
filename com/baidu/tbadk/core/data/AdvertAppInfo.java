package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bj {
    public static final BdUniqueId cMR = BdUniqueId.gen();
    public static final BdUniqueId cMS = BdUniqueId.gen();
    public static final BdUniqueId cMT = BdUniqueId.gen();
    public static final BdUniqueId cMU = BdUniqueId.gen();
    public static final BdUniqueId cMV = BdUniqueId.gen();
    public static final BdUniqueId cMW = BdUniqueId.gen();
    public static final BdUniqueId cMX = BdUniqueId.gen();
    public static final BdUniqueId cMY = BdUniqueId.gen();
    public static final BdUniqueId cMZ = BdUniqueId.gen();
    public static final BdUniqueId cNa = BdUniqueId.gen();
    public static final BdUniqueId cNb = BdUniqueId.gen();
    public static final BdUniqueId cNc = BdUniqueId.gen();
    public static final BdUniqueId cNd = BdUniqueId.gen();
    public static final BdUniqueId cNe = BdUniqueId.gen();
    public static final BdUniqueId cNf = BdUniqueId.gen();
    public static final BdUniqueId cNg = BdUniqueId.gen();
    public static final BdUniqueId cNh = BdUniqueId.gen();
    public static AtomicBoolean cNi = new AtomicBoolean(false);
    public int Ez;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String blT;
    public AppData cNA;
    public int cNj;
    public String cNk;
    public String cNl;
    public String cNm;
    public String cNn;
    public int cNo;
    public String cNp;
    public int cNq;
    public String cNr;
    public long cNs;
    public String cNw;
    public String cNx;
    public String cNy;
    private App cNz;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a cNt = new a();
    public boolean cNu = false;
    public ILegoAdvert legoCard = null;
    private int cNv = 32;

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

    public int hashCode() {
        return (this.cNk != null ? this.cNk.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.cNk, this.cNk) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aAs() {
        if (bj.cSc.get() && cNi.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.cNt == null || this.cNt.cNG != 1001) {
                if (this.cNt == null || TextUtils.isEmpty(this.cNt.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.cNk) || TextUtils.isEmpty(this.cNk.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.cNt.isValid()) {
                    return this.cNv;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.azR().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.cNt == null || !this.cNt.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Ez == 3) {
                    if (!aAt()) {
                        return 26;
                    }
                } else if (this.Ez == 1) {
                    if (!aAu()) {
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

    public boolean aAt() {
        boolean z = true;
        if (this.cNt == null || this.cNt.cNG != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Ez != 3 || this.legoCard.checkLegal(this.Ez) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Ez != 3 || TextUtils.isEmpty(this.cNn.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.cNt == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.cNt.userName) || TextUtils.isEmpty(this.cNt.userName.trim())) && TextUtils.isEmpty(this.cNt.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aAu() {
        if (this.cNt == null || this.cNt.cNG != 1001) {
            if (this.cNt == null || this.cNt.cNG != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Ez == 1 && !((TextUtils.isEmpty(this.cNm) || TextUtils.isEmpty(this.cNm.trim())) && TextUtils.isEmpty(this.cNt.lego_card)) : this.Ez == 1 && this.legoCard.checkLegal(this.Ez) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.cNz = app;
            this.cNA = new AppData(app);
            this.cNk = app.id;
            this.cNl = app.name;
            this.Ez = app.url_type.intValue();
            this.cNm = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.cNn = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.cNo = app.pos.intValue();
            this.blT = app.first_name;
            this.cNp = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.cNq = app.plan_id.intValue();
            this.userId = app.user_id;
            this.cNr = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.cNs = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.cNt.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.cNt.lego_card)) {
                try {
                    ICardInfo DZ = com.baidu.tieba.lego.card.b.DZ(this.cNt.lego_card);
                    if (DZ != null) {
                        ICardInfo viewItem = DZ.getViewItem(0, 1);
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
                        this.cNv = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.cNv = 40;
                        } else {
                            this.cNv = 39;
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
        if (this.cNA != null) {
            appData = this.cNA;
        } else if (this.cNz == null) {
            return "";
        } else {
            appData = new AppData(this.cNz);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.cNt.cNB);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.cNk;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.cNq);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.cNr;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int cNB;
        public String cNC;
        public String cND;
        public String cNE;
        public String cNF;
        public int cNG;
        public String cNH;
        public String cNI;
        public String cNJ;
        public List<String> cNK = new ArrayList(3);
        public VideoInfo cNL;
        public String cNM;
        public String cNN;
        public float cNO;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> su;
            if (goodsInfo != null) {
                this.cNB = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.cNC = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.cNE = goodsInfo.thread_pic;
                this.cNF = goodsInfo.pop_window_text;
                this.cNG = goodsInfo.goods_style.intValue();
                this.cNH = goodsInfo.card_desc;
                this.cNI = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.cNJ = goodsInfo.button_url;
                this.cND = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.cNK.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.cNK) && (su = su(goodsInfo.lego_card)) != null && this.cNK != null) {
                        this.cNK.addAll(su);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.cNL = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.cNM = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                            int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                            if (i2 != 0) {
                                this.tagRatio = i / i2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.cNN = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.cNO = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> su(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(3);
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("thread_pic_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean isValid() {
            return SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cNt.cNG == 1001 || this.cNt.cNG == -1001) {
            return cMR;
        }
        if (!com.baidu.tbadk.core.i.azR().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return cMR;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = cNa;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return cNb;
                case 3:
                case 4:
                case 5:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return cNc;
                case 7:
                    return cNd;
                case 9:
                    return cNf;
                case 10:
                    return cNe;
                case 12:
                    return cNh;
                case 13:
                    return cNg;
            }
        }
        return null;
    }
}
