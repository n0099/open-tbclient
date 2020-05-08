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
    public static final BdUniqueId dmb = BdUniqueId.gen();
    public static final BdUniqueId dmc = BdUniqueId.gen();
    public static final BdUniqueId dmd = BdUniqueId.gen();
    public static final BdUniqueId dme = BdUniqueId.gen();
    public static final BdUniqueId dmf = BdUniqueId.gen();
    public static final BdUniqueId dmg = BdUniqueId.gen();
    public static final BdUniqueId dmh = BdUniqueId.gen();
    public static final BdUniqueId dmi = BdUniqueId.gen();
    public static final BdUniqueId dmj = BdUniqueId.gen();
    public static final BdUniqueId dmk = BdUniqueId.gen();
    public static final BdUniqueId dml = BdUniqueId.gen();
    public static final BdUniqueId dmm = BdUniqueId.gen();
    public static final BdUniqueId dmn = BdUniqueId.gen();
    public static final BdUniqueId dmo = BdUniqueId.gen();
    public static final BdUniqueId dmp = BdUniqueId.gen();
    public static AtomicBoolean dmq = new AtomicBoolean(false);
    public int XT;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String bKg;
    public int cpid;
    public String deepUrl;
    public long dmA;
    public String dmE;
    public String dmF;
    public String dmG;
    private App dmH;
    public AppData dmI;
    public int dmr;
    public String dms;
    public String dmt;
    public String dmu;
    public String dmv;
    public int dmw;
    public String dmx;
    public int dmy;
    public String dmz;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dmB = new a();
    public boolean dmC = false;
    public ILegoAdvert legoCard = null;
    private int dmD = 32;

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
        return (this.dms != null ? this.dms.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dms, this.dms) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aID() {
        if (bj.dro.get() && dmq.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dmB == null || this.dmB.dmO != 1001) {
                if (this.dmB == null || TextUtils.isEmpty(this.dmB.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dms) || TextUtils.isEmpty(this.dms.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dmB.isValid()) {
                    return this.dmD;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.aIc().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dmB == null || !this.dmB.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.XT == 3) {
                    if (!aIE()) {
                        return 26;
                    }
                } else if (this.XT == 1) {
                    if (!aIF()) {
                        return 27;
                    }
                } else {
                    return 21;
                }
                return (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) ? 37 : 0;
            }
            return 0;
        }
        return 31;
    }

    public boolean aIE() {
        boolean z = true;
        if (this.dmB == null || this.dmB.dmO != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.XT != 3 || this.legoCard.checkLegal(this.XT) != 0) {
                    z = false;
                }
                return z;
            } else if (this.XT != 3 || TextUtils.isEmpty(this.dmv.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dmB == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dmB.userName) || TextUtils.isEmpty(this.dmB.userName.trim())) && TextUtils.isEmpty(this.dmB.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aIF() {
        if (this.dmB == null || this.dmB.dmO != 1001) {
            if (this.dmB == null || this.dmB.dmO != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.XT == 1 && !((TextUtils.isEmpty(this.dmu) || TextUtils.isEmpty(this.dmu.trim())) && TextUtils.isEmpty(this.dmB.lego_card)) : this.XT == 1 && this.legoCard.checkLegal(this.XT) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dmH = app;
            this.dmI = new AppData(app);
            this.dms = app.id;
            this.dmt = app.name;
            this.XT = app.url_type.intValue();
            this.dmu = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dmv = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dmw = app.pos.intValue();
            this.bKg = app.first_name;
            this.dmx = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dmy = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dmz = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dmA = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dmB.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dmB.lego_card)) {
                try {
                    ICardInfo FL = com.baidu.tieba.lego.card.b.FL(this.dmB.lego_card);
                    if (FL != null) {
                        ICardInfo viewItem = FL.getViewItem(0, 1);
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
                        this.dmD = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dmD = 40;
                        } else {
                            this.dmD = 39;
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
        if (this.dmI != null) {
            appData = this.dmI;
        } else if (this.dmH == null) {
            return "";
        } else {
            appData = new AppData(this.dmH);
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
        builder.da_good_id = String.valueOf(this.dmB.dmJ);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dms;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dmy);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dmz;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dmJ;
        public String dmK;
        public String dmL;
        public String dmM;
        public String dmN;
        public int dmO;
        public String dmP;
        public String dmQ;
        public String dmR;
        public List<String> dmS = new ArrayList(3);
        public VideoInfo dmT;
        public String dmU;
        public String dmV;
        public float dmW;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> tL;
            if (goodsInfo != null) {
                this.dmJ = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dmK = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dmM = goodsInfo.thread_pic;
                this.dmN = goodsInfo.pop_window_text;
                this.dmO = goodsInfo.goods_style.intValue();
                this.dmP = goodsInfo.card_desc;
                this.dmQ = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dmR = goodsInfo.button_url;
                this.dmL = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dmS.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.dmS) && (tL = tL(goodsInfo.lego_card)) != null && this.dmS != null) {
                        this.dmS.addAll(tL);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dmT = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dmU = goodsInfo.tag_name_url;
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
                    this.dmV = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dmW = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> tL(String str) {
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
        if (this.dmB.dmO == 1001 || this.dmB.dmO == -1001) {
            return dmb;
        }
        if (!com.baidu.tbadk.core.i.aIc().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dmb;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dmk;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dml;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dmm;
                case 7:
                    return dmn;
                case 12:
                    return dmp;
                case 13:
                    return dmo;
            }
        }
        return null;
    }
}
