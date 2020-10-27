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
public class AdvertAppInfo extends bw {
    public static final BdUniqueId esD = BdUniqueId.gen();
    public static final BdUniqueId esE = BdUniqueId.gen();
    public static final BdUniqueId esF = BdUniqueId.gen();
    public static final BdUniqueId esG = BdUniqueId.gen();
    public static final BdUniqueId esH = BdUniqueId.gen();
    public static final BdUniqueId esI = BdUniqueId.gen();
    public static final BdUniqueId esJ = BdUniqueId.gen();
    public static final BdUniqueId esK = BdUniqueId.gen();
    public static final BdUniqueId esL = BdUniqueId.gen();
    public static final BdUniqueId esM = BdUniqueId.gen();
    public static final BdUniqueId esN = BdUniqueId.gen();
    public static final BdUniqueId esO = BdUniqueId.gen();
    public static final BdUniqueId esP = BdUniqueId.gen();
    public static final BdUniqueId esQ = BdUniqueId.gen();
    public static final BdUniqueId esR = BdUniqueId.gen();
    public static AtomicBoolean esS = new AtomicBoolean(false);
    public int ZU;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String cBq;
    public int cpid;
    public String deepUrl;
    public int esT;
    public String esU;
    public String esV;
    public String esW;
    public String esX;
    public int esY;
    public String esZ;
    public int eta;
    public String etb;
    public long etd;
    public String eth;
    public String eti;
    public String etj;
    private App etk;
    public AppData etl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a ete = new a();
    public boolean etf = false;
    public ILegoAdvert legoCard = null;
    private int etg = 32;

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
        return (this.esU != null ? this.esU.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.esU, this.esU) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bhR() {
        if (bw.eyx.get() && esS.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.ete == null || this.ete.etr != 1001) {
                if (this.ete == null || TextUtils.isEmpty(this.ete.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.esU) || TextUtils.isEmpty(this.esU.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.ete.isValid()) {
                    return this.etg;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bhh().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.ete == null || !this.ete.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.ZU == 3) {
                    if (!bhS()) {
                        return 26;
                    }
                } else if (this.ZU == 1) {
                    if (!bhT()) {
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

    public boolean bhS() {
        boolean z = true;
        if (this.ete == null || this.ete.etr != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ZU != 3 || this.legoCard.checkLegal(this.ZU) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ZU != 3 || TextUtils.isEmpty(this.esX.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.ete == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.ete.userName) || TextUtils.isEmpty(this.ete.userName.trim())) && TextUtils.isEmpty(this.ete.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bhT() {
        if (this.ete == null || this.ete.etr != 1001) {
            if (this.ete == null || this.ete.etr != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ZU == 1 && !((TextUtils.isEmpty(this.esW) || TextUtils.isEmpty(this.esW.trim())) && TextUtils.isEmpty(this.ete.lego_card)) : this.ZU == 1 && this.legoCard.checkLegal(this.ZU) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.etk = app;
            this.etl = new AppData(app);
            this.esU = app.id;
            this.esV = app.name;
            this.ZU = app.url_type.intValue();
            this.esW = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.esX = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.esY = app.pos.intValue();
            this.cBq = app.first_name;
            this.esZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eta = app.plan_id.intValue();
            this.userId = app.user_id;
            this.etb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.etd = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.ete.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.ete.lego_card)) {
                try {
                    ICardInfo Nt = com.baidu.tieba.lego.card.b.Nt(this.ete.lego_card);
                    if (Nt != null) {
                        ICardInfo viewItem = Nt.getViewItem(0, 1);
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
                        this.etg = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.etg = 40;
                        } else {
                            this.etg = 39;
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
        if (this.etl != null) {
            appData = this.etl;
        } else if (this.etk == null) {
            return "";
        } else {
            appData = new AppData(this.etk);
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
        builder.da_good_id = String.valueOf(this.ete.etm);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.esU;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eta);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.etb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int etm;
        public String etn;
        public String eto;
        public String etp;
        public String etq;
        public int etr;
        public String ets;
        public String ett;
        public String etu;
        public List<String> etv = new ArrayList(3);
        public VideoInfo etw;
        public String etx;
        public String ety;
        public float etz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> Az;
            if (goodsInfo != null) {
                this.etm = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.etn = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.etp = goodsInfo.thread_pic;
                this.etq = goodsInfo.pop_window_text;
                this.etr = goodsInfo.goods_style.intValue();
                this.ets = goodsInfo.card_desc;
                this.ett = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.etu = goodsInfo.button_url;
                this.eto = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.etv.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.etv) && (Az = Az(goodsInfo.lego_card)) != null && this.etv != null) {
                        this.etv.addAll(Az);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.etw = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.etx = goodsInfo.tag_name_url;
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
                    this.ety = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.etz = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> Az(String str) {
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

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.ete.etr == 1001 || this.ete.etr == -1001) {
            return esD;
        }
        if (!com.baidu.tbadk.core.k.bhh().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return esD;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = esM;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return esN;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return esO;
                case 7:
                case 14:
                    return esP;
                case 12:
                    return esR;
                case 13:
                    return esQ;
            }
        }
        return null;
    }

    public boolean bhU() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bhV() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
