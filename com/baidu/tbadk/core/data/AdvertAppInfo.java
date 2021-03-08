package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
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
public class AdvertAppInfo extends cb implements am {
    public static final BdUniqueId eMB = BdUniqueId.gen();
    public static final BdUniqueId eMC = BdUniqueId.gen();
    public static final BdUniqueId eMD = BdUniqueId.gen();
    public static final BdUniqueId eME = BdUniqueId.gen();
    public static final BdUniqueId eMF = BdUniqueId.gen();
    public static final BdUniqueId eMG = BdUniqueId.gen();
    public static final BdUniqueId eMH = BdUniqueId.gen();
    public static final BdUniqueId eMI = BdUniqueId.gen();
    public static final BdUniqueId eMJ = BdUniqueId.gen();
    public static final BdUniqueId eMK = BdUniqueId.gen();
    public static final BdUniqueId eML = BdUniqueId.gen();
    public static final BdUniqueId eMM = BdUniqueId.gen();
    public static final BdUniqueId eMN = BdUniqueId.gen();
    public static final BdUniqueId eMO = BdUniqueId.gen();
    public static final BdUniqueId eMP = BdUniqueId.gen();
    public static final BdUniqueId eMQ = BdUniqueId.gen();
    public static final BdUniqueId eMR = BdUniqueId.gen();
    public static final BdUniqueId eMS = BdUniqueId.gen();
    public static AtomicBoolean eMT = new AtomicBoolean(false);
    public String abtest;
    public int acV;
    public String adPosition;
    public d advertAppContext;
    public String apkUrl;
    public String cQq;
    public int cpid;
    public String deepUrl;
    public String eMU;
    public String eMV;
    public String eMW;
    public String eMX;
    public int eMY;
    public String eMZ;
    public int eNa;
    public String eNb;
    public long eNc;
    public String eNg;
    public String eNh;
    public String eNi;
    public App eNj;
    public AppData eNk;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a eNd = new a();
    public boolean eNe = false;
    public ILegoAdvert legoCard = null;
    private int eNf = 32;
    private boolean eNl = false;
    public boolean eNm = false;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        int checkLegal(int i);

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c getAppInfoModel();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        boolean isNoPicAd();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int hashCode() {
        return (this.eMU != null ? this.eMU.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eMU, this.eMU) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int blF() {
        if (!cb.eSB.get()) {
            com.baidu.tieba.recapp.t.dDC();
            return 31;
        } else if (!eMT.get()) {
            com.baidu.tieba.recapp.t.dDC();
            return 31;
        } else if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
            return 23;
        } else {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eNd == null || this.eNd.eNs != 1001) {
                if (this.eNd == null || TextUtils.isEmpty(this.eNd.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eMU) || TextUtils.isEmpty(this.eMU.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eNd.isValid()) {
                    try {
                        if (new JSONObject(this.eNd.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.eNf;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bkV().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.eNd == null || !this.eNd.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.acV == 3) {
                        if (!blG()) {
                            return 26;
                        }
                    } else if (this.acV == 1) {
                        if (!blH()) {
                            return 27;
                        }
                    } else {
                        return 21;
                    }
                    if (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) {
                        return 37;
                    }
                    return (this.legoCard.getAppInfoModel() == null || c.a(this.legoCard.getAppInfoModel())) ? 0 : 42;
                }
            }
            return 0;
        }
    }

    public boolean blG() {
        if (this.eNd == null || this.eNd.eNs != 1001) {
            return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? (this.acV != 3 || TextUtils.isEmpty(this.eMX.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eNd == null || ((TextUtils.isEmpty(this.eNd.userName) || TextUtils.isEmpty(this.eNd.userName.trim())) && TextUtils.isEmpty(this.eNd.lego_card))) ? false : true : this.acV == 3 && this.legoCard.checkLegal(this.acV) == 0;
        }
        return false;
    }

    public boolean blH() {
        if (this.eNd == null || this.eNd.eNs != 1001) {
            if (this.eNd == null || this.eNd.eNs != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.acV == 1 && !((TextUtils.isEmpty(this.eMW) || TextUtils.isEmpty(this.eMW.trim())) && TextUtils.isEmpty(this.eNd.lego_card)) : this.acV == 1 && this.legoCard.checkLegal(this.acV) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.eNj = app;
            this.eNk = new AppData(app);
            this.eMU = app.id;
            this.eMV = app.name;
            this.acV = app.url_type.intValue();
            this.eMW = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eMX = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.position = com.baidu.adp.lib.f.b.toInt(app.pos_name, -1) - 1;
            this.eMY = app.pos.intValue();
            this.cQq = app.first_name;
            this.eMZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eNa = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eNb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eNc = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eNd.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eNd.lego_card)) {
                try {
                    ICardInfo NK = com.baidu.tieba.lego.card.b.NK(this.eNd.lego_card);
                    if (NK != null) {
                        ICardInfo viewItem = NK.getViewItem(0, 1);
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
                        this.eNf = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eNf = 40;
                        } else {
                            this.eNf = 39;
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
        if (this.eNk != null) {
            appData = this.eNk;
        } else if (this.eNj == null) {
            return "";
        } else {
            appData = new AppData(this.eNj);
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
        builder.da_good_id = String.valueOf(this.eNd.eNn);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eMU;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eNa);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eNb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public float eNA;
        public int eNn;
        public String eNo;
        public String eNp;
        public String eNq;
        public String eNr;
        public int eNs;
        public String eNt;
        public String eNu;
        public String eNv;
        public List<String> eNw = new ArrayList(3);
        public VideoInfo eNx;
        public String eNy;
        public String eNz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> zZ;
            if (goodsInfo != null) {
                this.eNn = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.eNo = com.baidu.tbadk.core.util.au.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.eNq = goodsInfo.thread_pic;
                this.eNr = goodsInfo.pop_window_text;
                this.eNs = goodsInfo.goods_style.intValue();
                this.eNt = goodsInfo.card_desc;
                this.eNu = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.eNv = goodsInfo.button_url;
                this.eNp = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.eNw.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.eNw) && (zZ = zZ(goodsInfo.lego_card)) != null && this.eNw != null) {
                        this.eNw.addAll(zZ);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.eNx = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.eNy = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                            int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                            if (i2 != 0) {
                                this.tagRatio = i / i2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.eNz = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.eNA = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> zZ(String str) {
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

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eNd.eNs == 1001 || this.eNd.eNs == -1001) {
            return eMB;
        }
        if (!com.baidu.tbadk.core.k.bkV().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eMB;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eMK;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eMO;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eMP;
                case 7:
                case 14:
                    return eMQ;
                case 12:
                    return eMS;
                case 13:
                    return eMR;
            }
        }
        return null;
    }

    public boolean isVideoAd() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean blI() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blJ() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        this.position = i;
        this.eNl = true;
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blK() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blL() {
        return this.eNl;
    }
}
