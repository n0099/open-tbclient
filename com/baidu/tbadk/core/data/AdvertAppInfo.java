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
    public static final BdUniqueId cMF = BdUniqueId.gen();
    public static final BdUniqueId cMG = BdUniqueId.gen();
    public static final BdUniqueId cMH = BdUniqueId.gen();
    public static final BdUniqueId cMI = BdUniqueId.gen();
    public static final BdUniqueId cMJ = BdUniqueId.gen();
    public static final BdUniqueId cMK = BdUniqueId.gen();
    public static final BdUniqueId cML = BdUniqueId.gen();
    public static final BdUniqueId cMM = BdUniqueId.gen();
    public static final BdUniqueId cMN = BdUniqueId.gen();
    public static final BdUniqueId cMO = BdUniqueId.gen();
    public static final BdUniqueId cMP = BdUniqueId.gen();
    public static final BdUniqueId cMQ = BdUniqueId.gen();
    public static final BdUniqueId cMR = BdUniqueId.gen();
    public static final BdUniqueId cMS = BdUniqueId.gen();
    public static final BdUniqueId cMT = BdUniqueId.gen();
    public static AtomicBoolean cMU = new AtomicBoolean(false);
    public int Ez;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String blF;
    public int cMV;
    public String cMW;
    public String cMX;
    public String cMY;
    public String cMZ;
    public int cNa;
    public String cNb;
    public int cNc;
    public String cNd;
    public long cNe;
    public String cNi;
    public String cNj;
    public String cNk;
    private App cNl;
    public AppData cNm;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a cNf = new a();
    public boolean cNg = false;
    public ILegoAdvert legoCard = null;
    private int cNh = 32;

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
        return (this.cMW != null ? this.cMW.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.cMW, this.cMW) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aAp() {
        if (bj.cRO.get() && cMU.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.cNf == null || this.cNf.cNs != 1001) {
                if (this.cNf == null || TextUtils.isEmpty(this.cNf.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.cMW) || TextUtils.isEmpty(this.cMW.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.cNf.isValid()) {
                    return this.cNh;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.azO().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.cNf == null || !this.cNf.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Ez == 3) {
                    if (!aAq()) {
                        return 26;
                    }
                } else if (this.Ez == 1) {
                    if (!aAr()) {
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

    public boolean aAq() {
        boolean z = true;
        if (this.cNf == null || this.cNf.cNs != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Ez != 3 || this.legoCard.checkLegal(this.Ez) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Ez != 3 || TextUtils.isEmpty(this.cMZ.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.cNf == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.cNf.userName) || TextUtils.isEmpty(this.cNf.userName.trim())) && TextUtils.isEmpty(this.cNf.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aAr() {
        if (this.cNf == null || this.cNf.cNs != 1001) {
            if (this.cNf == null || this.cNf.cNs != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Ez == 1 && !((TextUtils.isEmpty(this.cMY) || TextUtils.isEmpty(this.cMY.trim())) && TextUtils.isEmpty(this.cNf.lego_card)) : this.Ez == 1 && this.legoCard.checkLegal(this.Ez) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.cNl = app;
            this.cNm = new AppData(app);
            this.cMW = app.id;
            this.cMX = app.name;
            this.Ez = app.url_type.intValue();
            this.cMY = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.cMZ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.cNa = app.pos.intValue();
            this.blF = app.first_name;
            this.cNb = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.cNc = app.plan_id.intValue();
            this.userId = app.user_id;
            this.cNd = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.cNe = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.cNf.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.cNf.lego_card)) {
                try {
                    ICardInfo DZ = com.baidu.tieba.lego.card.b.DZ(this.cNf.lego_card);
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
                        this.cNh = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.cNh = 40;
                        } else {
                            this.cNh = 39;
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
        if (this.cNm != null) {
            appData = this.cNm;
        } else if (this.cNl == null) {
            return "";
        } else {
            appData = new AppData(this.cNl);
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
        builder.da_good_id = String.valueOf(this.cNf.cNn);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.cMW;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.cNc);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.cNd;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public float cNA;
        public int cNn;
        public String cNo;
        public String cNp;
        public String cNq;
        public String cNr;
        public int cNs;
        public String cNt;
        public String cNu;
        public String cNv;
        public List<String> cNw = new ArrayList(3);
        public VideoInfo cNx;
        public String cNy;
        public String cNz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> sv;
            if (goodsInfo != null) {
                this.cNn = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.cNo = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.cNq = goodsInfo.thread_pic;
                this.cNr = goodsInfo.pop_window_text;
                this.cNs = goodsInfo.goods_style.intValue();
                this.cNt = goodsInfo.card_desc;
                this.cNu = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.cNv = goodsInfo.button_url;
                this.cNp = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.cNw.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.cNw) && (sv = sv(goodsInfo.lego_card)) != null && this.cNw != null) {
                        this.cNw.addAll(sv);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.cNx = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.cNy = goodsInfo.tag_name_url;
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
                    this.cNz = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.cNA = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> sv(String str) {
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
        if (this.cNf.cNs == 1001 || this.cNf.cNs == -1001) {
            return cMF;
        }
        if (!com.baidu.tbadk.core.i.azO().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return cMF;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = cMO;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return cMP;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return cMQ;
                case 7:
                    return cMR;
                case 9:
                    return cMT;
                case 10:
                    return cMS;
            }
        }
        return null;
    }
}
