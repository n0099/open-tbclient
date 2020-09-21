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
    public static final BdUniqueId dYc = BdUniqueId.gen();
    public static final BdUniqueId dYd = BdUniqueId.gen();
    public static final BdUniqueId dYe = BdUniqueId.gen();
    public static final BdUniqueId dYf = BdUniqueId.gen();
    public static final BdUniqueId dYg = BdUniqueId.gen();
    public static final BdUniqueId dYh = BdUniqueId.gen();
    public static final BdUniqueId dYi = BdUniqueId.gen();
    public static final BdUniqueId dYj = BdUniqueId.gen();
    public static final BdUniqueId dYk = BdUniqueId.gen();
    public static final BdUniqueId dYl = BdUniqueId.gen();
    public static final BdUniqueId dYm = BdUniqueId.gen();
    public static final BdUniqueId dYn = BdUniqueId.gen();
    public static final BdUniqueId dYo = BdUniqueId.gen();
    public static final BdUniqueId dYp = BdUniqueId.gen();
    public static final BdUniqueId dYq = BdUniqueId.gen();
    public static AtomicBoolean dYr = new AtomicBoolean(false);
    public int ZD;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String cgz;
    public int cpid;
    public String dYA;
    public long dYB;
    public String dYF;
    public String dYG;
    public String dYH;
    private App dYI;
    public AppData dYJ;
    public int dYs;
    public String dYt;
    public String dYu;
    public String dYv;
    public String dYw;
    public int dYx;
    public String dYy;
    public int dYz;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dYC = new a();
    public boolean dYD = false;
    public ILegoAdvert legoCard = null;
    private int dYE = 32;

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
        return (this.dYt != null ? this.dYt.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dYt, this.dYt) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bdp() {
        if (bw.edR.get() && dYr.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dYC == null || this.dYC.dYP != 1001) {
                if (this.dYC == null || TextUtils.isEmpty(this.dYC.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dYt) || TextUtils.isEmpty(this.dYt.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dYC.isValid()) {
                    return this.dYE;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bcG().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dYC == null || !this.dYC.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.ZD == 3) {
                    if (!bdq()) {
                        return 26;
                    }
                } else if (this.ZD == 1) {
                    if (!bdr()) {
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

    public boolean bdq() {
        boolean z = true;
        if (this.dYC == null || this.dYC.dYP != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ZD != 3 || this.legoCard.checkLegal(this.ZD) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ZD != 3 || TextUtils.isEmpty(this.dYw.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dYC == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dYC.userName) || TextUtils.isEmpty(this.dYC.userName.trim())) && TextUtils.isEmpty(this.dYC.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bdr() {
        if (this.dYC == null || this.dYC.dYP != 1001) {
            if (this.dYC == null || this.dYC.dYP != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ZD == 1 && !((TextUtils.isEmpty(this.dYv) || TextUtils.isEmpty(this.dYv.trim())) && TextUtils.isEmpty(this.dYC.lego_card)) : this.ZD == 1 && this.legoCard.checkLegal(this.ZD) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dYI = app;
            this.dYJ = new AppData(app);
            this.dYt = app.id;
            this.dYu = app.name;
            this.ZD = app.url_type.intValue();
            this.dYv = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dYw = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dYx = app.pos.intValue();
            this.cgz = app.first_name;
            this.dYy = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dYz = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dYA = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dYB = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dYC.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dYC.lego_card)) {
                try {
                    ICardInfo Mg = com.baidu.tieba.lego.card.b.Mg(this.dYC.lego_card);
                    if (Mg != null) {
                        ICardInfo viewItem = Mg.getViewItem(0, 1);
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
                        this.dYE = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dYE = 40;
                        } else {
                            this.dYE = 39;
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
        if (this.dYJ != null) {
            appData = this.dYJ;
        } else if (this.dYI == null) {
            return "";
        } else {
            appData = new AppData(this.dYI);
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
        builder.da_good_id = String.valueOf(this.dYC.dYK);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dYt;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dYz);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dYA;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dYK;
        public String dYL;
        public String dYM;
        public String dYN;
        public String dYO;
        public int dYP;
        public String dYQ;
        public String dYR;
        public String dYS;
        public List<String> dYT = new ArrayList(3);
        public VideoInfo dYU;
        public String dYV;
        public String dYW;
        public float dYX;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> zu;
            if (goodsInfo != null) {
                this.dYK = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dYL = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dYN = goodsInfo.thread_pic;
                this.dYO = goodsInfo.pop_window_text;
                this.dYP = goodsInfo.goods_style.intValue();
                this.dYQ = goodsInfo.card_desc;
                this.dYR = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dYS = goodsInfo.button_url;
                this.dYM = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dYT.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.dYT) && (zu = zu(goodsInfo.lego_card)) != null && this.dYT != null) {
                        this.dYT.addAll(zu);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dYU = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dYV = goodsInfo.tag_name_url;
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
                    this.dYW = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dYX = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> zu(String str) {
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
        if (this.dYC.dYP == 1001 || this.dYC.dYP == -1001) {
            return dYc;
        }
        if (!com.baidu.tbadk.core.k.bcG().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dYc;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dYl;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dYm;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dYn;
                case 7:
                case 14:
                    return dYo;
                case 12:
                    return dYq;
                case 13:
                    return dYp;
            }
        }
        return null;
    }

    public boolean bds() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bdt() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
