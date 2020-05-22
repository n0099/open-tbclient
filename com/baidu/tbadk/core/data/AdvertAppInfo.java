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
public class AdvertAppInfo extends bk {
    public static final BdUniqueId dAd = BdUniqueId.gen();
    public static final BdUniqueId dAe = BdUniqueId.gen();
    public static final BdUniqueId dAf = BdUniqueId.gen();
    public static final BdUniqueId dAg = BdUniqueId.gen();
    public static final BdUniqueId dAh = BdUniqueId.gen();
    public static final BdUniqueId dAi = BdUniqueId.gen();
    public static final BdUniqueId dAj = BdUniqueId.gen();
    public static final BdUniqueId dAk = BdUniqueId.gen();
    public static final BdUniqueId dAl = BdUniqueId.gen();
    public static final BdUniqueId dAm = BdUniqueId.gen();
    public static final BdUniqueId dAn = BdUniqueId.gen();
    public static final BdUniqueId dAo = BdUniqueId.gen();
    public static final BdUniqueId dAp = BdUniqueId.gen();
    public static final BdUniqueId dAq = BdUniqueId.gen();
    public static final BdUniqueId dAr = BdUniqueId.gen();
    public static AtomicBoolean dAs = new AtomicBoolean(false);
    public int Yj;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String bTd;
    public int cpid;
    public int dAA;
    public String dAB;
    public long dAC;
    public String dAG;
    public String dAH;
    public String dAI;
    private App dAJ;
    public AppData dAK;
    public int dAt;
    public String dAu;
    public String dAv;
    public String dAw;
    public String dAx;
    public int dAy;
    public String dAz;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dAD = new a();
    public boolean dAE = false;
    public ILegoAdvert legoCard = null;
    private int dAF = 32;

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
        return (this.dAu != null ? this.dAu.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dAu, this.dAu) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aOy() {
        if (bk.dFk.get() && dAs.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dAD == null || this.dAD.dAQ != 1001) {
                if (this.dAD == null || TextUtils.isEmpty(this.dAD.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dAu) || TextUtils.isEmpty(this.dAu.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dAD.isValid()) {
                    return this.dAF;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.aNQ().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dAD == null || !this.dAD.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Yj == 3) {
                    if (!aOz()) {
                        return 26;
                    }
                } else if (this.Yj == 1) {
                    if (!aOA()) {
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

    public boolean aOz() {
        boolean z = true;
        if (this.dAD == null || this.dAD.dAQ != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Yj != 3 || this.legoCard.checkLegal(this.Yj) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Yj != 3 || TextUtils.isEmpty(this.dAx.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dAD == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dAD.userName) || TextUtils.isEmpty(this.dAD.userName.trim())) && TextUtils.isEmpty(this.dAD.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aOA() {
        if (this.dAD == null || this.dAD.dAQ != 1001) {
            if (this.dAD == null || this.dAD.dAQ != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Yj == 1 && !((TextUtils.isEmpty(this.dAw) || TextUtils.isEmpty(this.dAw.trim())) && TextUtils.isEmpty(this.dAD.lego_card)) : this.Yj == 1 && this.legoCard.checkLegal(this.Yj) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dAJ = app;
            this.dAK = new AppData(app);
            this.dAu = app.id;
            this.dAv = app.name;
            this.Yj = app.url_type.intValue();
            this.dAw = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dAx = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dAy = app.pos.intValue();
            this.bTd = app.first_name;
            this.dAz = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dAA = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dAB = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dAC = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dAD.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dAD.lego_card)) {
                try {
                    ICardInfo Hu = com.baidu.tieba.lego.card.b.Hu(this.dAD.lego_card);
                    if (Hu != null) {
                        ICardInfo viewItem = Hu.getViewItem(0, 1);
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
                        this.dAF = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dAF = 40;
                        } else {
                            this.dAF = 39;
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
        if (this.dAK != null) {
            appData = this.dAK;
        } else if (this.dAJ == null) {
            return "";
        } else {
            appData = new AppData(this.dAJ);
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
        builder.da_good_id = String.valueOf(this.dAD.dAL);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dAu;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dAA);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dAB;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dAL;
        public String dAM;
        public String dAN;
        public String dAO;
        public String dAP;
        public int dAQ;
        public String dAR;
        public String dAS;
        public String dAT;
        public List<String> dAU = new ArrayList(3);
        public VideoInfo dAV;
        public String dAW;
        public String dAX;
        public float dAY;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> vr;
            if (goodsInfo != null) {
                this.dAL = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dAM = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dAO = goodsInfo.thread_pic;
                this.dAP = goodsInfo.pop_window_text;
                this.dAQ = goodsInfo.goods_style.intValue();
                this.dAR = goodsInfo.card_desc;
                this.dAS = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dAT = goodsInfo.button_url;
                this.dAN = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dAU.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.dAU) && (vr = vr(goodsInfo.lego_card)) != null && this.dAU != null) {
                        this.dAU.addAll(vr);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dAV = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dAW = goodsInfo.tag_name_url;
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
                    this.dAX = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dAY = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> vr(String str) {
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

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.dAD.dAQ == 1001 || this.dAD.dAQ == -1001) {
            return dAd;
        }
        if (!com.baidu.tbadk.core.k.aNQ().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dAd;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dAm;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dAn;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dAo;
                case 7:
                    return dAp;
                case 12:
                    return dAr;
                case 13:
                    return dAq;
            }
        }
        return null;
    }
}
