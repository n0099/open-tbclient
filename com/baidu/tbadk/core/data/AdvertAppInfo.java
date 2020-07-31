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
public class AdvertAppInfo extends bv {
    public static final BdUniqueId dMF = BdUniqueId.gen();
    public static final BdUniqueId dMG = BdUniqueId.gen();
    public static final BdUniqueId dMH = BdUniqueId.gen();
    public static final BdUniqueId dMI = BdUniqueId.gen();
    public static final BdUniqueId dMJ = BdUniqueId.gen();
    public static final BdUniqueId dMK = BdUniqueId.gen();
    public static final BdUniqueId dML = BdUniqueId.gen();
    public static final BdUniqueId dMM = BdUniqueId.gen();
    public static final BdUniqueId dMN = BdUniqueId.gen();
    public static final BdUniqueId dMO = BdUniqueId.gen();
    public static final BdUniqueId dMP = BdUniqueId.gen();
    public static final BdUniqueId dMQ = BdUniqueId.gen();
    public static final BdUniqueId dMR = BdUniqueId.gen();
    public static final BdUniqueId dMS = BdUniqueId.gen();
    public static final BdUniqueId dMT = BdUniqueId.gen();
    public static AtomicBoolean dMU = new AtomicBoolean(false);
    public int YD;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String bYK;
    public int cpid;
    public int dMV;
    public String dMW;
    public String dMX;
    public String dMY;
    public String dMZ;
    public int dNa;
    public String dNb;
    public int dNc;
    public String dNd;
    public long dNe;
    public String dNi;
    public String dNj;
    public String dNk;
    private App dNl;
    public AppData dNm;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dNf = new a();
    public boolean dNg = false;
    public ILegoAdvert legoCard = null;
    private int dNh = 32;

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
        return (this.dMW != null ? this.dMW.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dMW, this.dMW) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aUe() {
        if (bv.dSh.get() && dMU.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dNf == null || this.dNf.dNs != 1001) {
                if (this.dNf == null || TextUtils.isEmpty(this.dNf.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dMW) || TextUtils.isEmpty(this.dMW.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dNf.isValid()) {
                    return this.dNh;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.aTv().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dNf == null || !this.dNf.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.YD == 3) {
                    if (!aUf()) {
                        return 26;
                    }
                } else if (this.YD == 1) {
                    if (!aUg()) {
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

    public boolean aUf() {
        boolean z = true;
        if (this.dNf == null || this.dNf.dNs != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.YD != 3 || this.legoCard.checkLegal(this.YD) != 0) {
                    z = false;
                }
                return z;
            } else if (this.YD != 3 || TextUtils.isEmpty(this.dMZ.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dNf == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dNf.userName) || TextUtils.isEmpty(this.dNf.userName.trim())) && TextUtils.isEmpty(this.dNf.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aUg() {
        if (this.dNf == null || this.dNf.dNs != 1001) {
            if (this.dNf == null || this.dNf.dNs != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.YD == 1 && !((TextUtils.isEmpty(this.dMY) || TextUtils.isEmpty(this.dMY.trim())) && TextUtils.isEmpty(this.dNf.lego_card)) : this.YD == 1 && this.legoCard.checkLegal(this.YD) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dNl = app;
            this.dNm = new AppData(app);
            this.dMW = app.id;
            this.dMX = app.name;
            this.YD = app.url_type.intValue();
            this.dMY = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dMZ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dNa = app.pos.intValue();
            this.bYK = app.first_name;
            this.dNb = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dNc = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dNd = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dNe = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dNf.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dNf.lego_card)) {
                try {
                    ICardInfo IL = com.baidu.tieba.lego.card.b.IL(this.dNf.lego_card);
                    if (IL != null) {
                        ICardInfo viewItem = IL.getViewItem(0, 1);
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
                        this.dNh = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dNh = 40;
                        } else {
                            this.dNh = 39;
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
        if (this.dNm != null) {
            appData = this.dNm;
        } else if (this.dNl == null) {
            return "";
        } else {
            appData = new AppData(this.dNl);
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
        builder.da_good_id = String.valueOf(this.dNf.dNn);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dMW;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dNc);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dNd;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public float dNA;
        public int dNn;
        public String dNo;
        public String dNp;
        public String dNq;
        public String dNr;
        public int dNs;
        public String dNt;
        public String dNu;
        public String dNv;
        public List<String> dNw = new ArrayList(3);
        public VideoInfo dNx;
        public String dNy;
        public String dNz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> wK;
            if (goodsInfo != null) {
                this.dNn = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dNo = com.baidu.tbadk.core.util.as.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dNq = goodsInfo.thread_pic;
                this.dNr = goodsInfo.pop_window_text;
                this.dNs = goodsInfo.goods_style.intValue();
                this.dNt = goodsInfo.card_desc;
                this.dNu = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dNv = goodsInfo.button_url;
                this.dNp = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dNw.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.x.isEmpty(this.dNw) && (wK = wK(goodsInfo.lego_card)) != null && this.dNw != null) {
                        this.dNw.addAll(wK);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dNx = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dNy = goodsInfo.tag_name_url;
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
                    this.dNz = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.as.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dNA = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> wK(String str) {
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

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dNf.dNs == 1001 || this.dNf.dNs == -1001) {
            return dMF;
        }
        if (!com.baidu.tbadk.core.k.aTv().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dMF;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dMO;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dMP;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dMQ;
                case 7:
                case 14:
                    return dMR;
                case 12:
                    return dMT;
                case 13:
                    return dMS;
            }
        }
        return null;
    }
}
