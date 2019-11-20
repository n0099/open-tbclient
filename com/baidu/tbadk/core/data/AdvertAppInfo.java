package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
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
public class AdvertAppInfo extends bh {
    public static final BdUniqueId bWc = BdUniqueId.gen();
    public static final BdUniqueId bWd = BdUniqueId.gen();
    public static final BdUniqueId bWe = BdUniqueId.gen();
    public static final BdUniqueId bWf = BdUniqueId.gen();
    public static final BdUniqueId bWg = BdUniqueId.gen();
    public static final BdUniqueId bWh = BdUniqueId.gen();
    public static final BdUniqueId bWi = BdUniqueId.gen();
    public static final BdUniqueId bWj = BdUniqueId.gen();
    public static final BdUniqueId bWk = BdUniqueId.gen();
    public static final BdUniqueId bWl = BdUniqueId.gen();
    public static final BdUniqueId bWm = BdUniqueId.gen();
    public static final BdUniqueId bWn = BdUniqueId.gen();
    public static final BdUniqueId bWo = BdUniqueId.gen();
    public static final BdUniqueId bWp = BdUniqueId.gen();
    public static final BdUniqueId bWq = BdUniqueId.gen();
    public static AtomicBoolean bWr = new AtomicBoolean(false);
    public int Bv;
    public String aHT;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public int bWA;
    public String bWB;
    public long bWC;
    public String bWG;
    public String bWH;
    public String bWI;
    private App bWJ;
    public AppData bWK;
    public int bWs;
    public String bWt;
    public String bWu;
    public String bWv;
    public String bWw;
    public String bWx;
    public int bWy;
    public String bWz;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bWD = new a();
    public boolean bWE = false;
    public ILegoAdvert legoCard = null;
    private int bWF = 32;

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
        return (this.bWt != null ? this.bWt.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bWt, this.bWt) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int agP() {
        if (bh.cbd.get() && bWr.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bWD == null || this.bWD.bWQ != 1001) {
                if (this.bWD == null || TextUtils.isEmpty(this.bWD.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bWt) || TextUtils.isEmpty(this.bWt.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bWD.isValid()) {
                    return this.bWF;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.ago().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bWD == null || !this.bWD.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Bv == 3) {
                    if (!agQ()) {
                        return 26;
                    }
                } else if (this.Bv == 1) {
                    if (!agR()) {
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

    public boolean agQ() {
        boolean z = true;
        if (this.bWD == null || this.bWD.bWQ != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Bv != 3 || this.legoCard.checkLegal(this.Bv) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Bv != 3 || TextUtils.isEmpty(this.bWx.trim()) || TextUtils.isEmpty(this.bWw.trim()) || this.bWD == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bWD.userName) || TextUtils.isEmpty(this.bWD.userName.trim())) && TextUtils.isEmpty(this.bWD.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean agR() {
        if (this.bWD == null || this.bWD.bWQ != 1001) {
            if (this.bWD == null || this.bWD.bWQ != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Bv == 1 && !((TextUtils.isEmpty(this.bWv) || TextUtils.isEmpty(this.bWv.trim())) && TextUtils.isEmpty(this.bWD.lego_card)) : this.Bv == 1 && this.legoCard.checkLegal(this.Bv) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bWJ = app;
            this.bWK = new AppData(app);
            this.bWt = app.id;
            this.bWu = app.name;
            this.Bv = app.url_type.intValue();
            this.bWv = app.url;
            this.bWw = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bWx = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bWy = app.pos.intValue();
            this.aHT = app.first_name;
            this.bWz = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bWA = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bWB = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bWC = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bWD.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bWD.lego_card)) {
                try {
                    ICardInfo yQ = com.baidu.tieba.lego.card.b.yQ(this.bWD.lego_card);
                    if (yQ != null) {
                        ICardInfo viewItem = yQ.getViewItem(0, 1);
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
                        this.bWF = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bWF = 40;
                        } else {
                            this.bWF = 39;
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
        if (this.bWK != null) {
            appData = this.bWK;
        } else if (this.bWJ == null) {
            return "";
        } else {
            appData = new AppData(this.bWJ);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.bWD.bWL);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bWt;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bWA);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bWB;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bWL;
        public String bWM;
        public String bWN;
        public String bWO;
        public String bWP;
        public int bWQ;
        public String bWR;
        public String bWS;
        public String bWT;
        public List<String> bWU = new ArrayList(3);
        public VideoInfo bWV;
        public String bWW;
        public String bWX;
        public float bWY;
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
            List<String> mN;
            if (goodsInfo != null) {
                this.bWL = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bWM = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.bWO = goodsInfo.thread_pic;
                this.bWP = goodsInfo.pop_window_text;
                this.bWQ = goodsInfo.goods_style.intValue();
                this.bWR = goodsInfo.card_desc;
                this.bWS = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bWT = goodsInfo.button_url;
                this.bWN = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bWU.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.bWU) && (mN = mN(goodsInfo.lego_card)) != null && this.bWU != null) {
                        this.bWU.addAll(mN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bWV = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bWW = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                            int i2 = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                            if (i2 != 0) {
                                this.tagRatio = i / i2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.bWX = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.g.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.g.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.bWY = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> mN(String str) {
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
            return com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bWD.bWQ == 1001 || this.bWD.bWQ == -1001) {
            return bWc;
        }
        if (!com.baidu.tbadk.core.i.ago().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bWc;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bWl;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bWm;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bWn;
                case 7:
                    return bWo;
                case 9:
                    return bWq;
                case 10:
                    return bWp;
            }
        }
        return null;
    }
}
