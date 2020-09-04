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
    public static final BdUniqueId dVS = BdUniqueId.gen();
    public static final BdUniqueId dVT = BdUniqueId.gen();
    public static final BdUniqueId dVU = BdUniqueId.gen();
    public static final BdUniqueId dVV = BdUniqueId.gen();
    public static final BdUniqueId dVW = BdUniqueId.gen();
    public static final BdUniqueId dVX = BdUniqueId.gen();
    public static final BdUniqueId dVY = BdUniqueId.gen();
    public static final BdUniqueId dVZ = BdUniqueId.gen();
    public static final BdUniqueId dWa = BdUniqueId.gen();
    public static final BdUniqueId dWb = BdUniqueId.gen();
    public static final BdUniqueId dWc = BdUniqueId.gen();
    public static final BdUniqueId dWd = BdUniqueId.gen();
    public static final BdUniqueId dWe = BdUniqueId.gen();
    public static final BdUniqueId dWf = BdUniqueId.gen();
    public static final BdUniqueId dWg = BdUniqueId.gen();
    public static AtomicBoolean dWh = new AtomicBoolean(false);
    public int Zl;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String cey;
    public int cpid;
    public int dWi;
    public String dWj;
    public String dWk;
    public String dWl;
    public String dWm;
    public int dWn;
    public String dWo;
    public int dWp;
    public String dWq;
    public long dWr;
    public String dWv;
    public String dWw;
    public String dWx;
    private App dWy;
    public AppData dWz;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dWs = new a();
    public boolean dWt = false;
    public ILegoAdvert legoCard = null;
    private int dWu = 32;

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
        return (this.dWj != null ? this.dWj.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dWj, this.dWj) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bcv() {
        if (bw.ebH.get() && dWh.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dWs == null || this.dWs.dWF != 1001) {
                if (this.dWs == null || TextUtils.isEmpty(this.dWs.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dWj) || TextUtils.isEmpty(this.dWj.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dWs.isValid()) {
                    return this.dWu;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bbM().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dWs == null || !this.dWs.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Zl == 3) {
                    if (!bcw()) {
                        return 26;
                    }
                } else if (this.Zl == 1) {
                    if (!bcx()) {
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

    public boolean bcw() {
        boolean z = true;
        if (this.dWs == null || this.dWs.dWF != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Zl != 3 || this.legoCard.checkLegal(this.Zl) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Zl != 3 || TextUtils.isEmpty(this.dWm.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dWs == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dWs.userName) || TextUtils.isEmpty(this.dWs.userName.trim())) && TextUtils.isEmpty(this.dWs.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bcx() {
        if (this.dWs == null || this.dWs.dWF != 1001) {
            if (this.dWs == null || this.dWs.dWF != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Zl == 1 && !((TextUtils.isEmpty(this.dWl) || TextUtils.isEmpty(this.dWl.trim())) && TextUtils.isEmpty(this.dWs.lego_card)) : this.Zl == 1 && this.legoCard.checkLegal(this.Zl) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dWy = app;
            this.dWz = new AppData(app);
            this.dWj = app.id;
            this.dWk = app.name;
            this.Zl = app.url_type.intValue();
            this.dWl = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dWm = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dWn = app.pos.intValue();
            this.cey = app.first_name;
            this.dWo = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dWp = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dWq = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dWr = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dWs.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dWs.lego_card)) {
                try {
                    ICardInfo LE = com.baidu.tieba.lego.card.b.LE(this.dWs.lego_card);
                    if (LE != null) {
                        ICardInfo viewItem = LE.getViewItem(0, 1);
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
                        this.dWu = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dWu = 40;
                        } else {
                            this.dWu = 39;
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
        if (this.dWz != null) {
            appData = this.dWz;
        } else if (this.dWy == null) {
            return "";
        } else {
            appData = new AppData(this.dWy);
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
        builder.da_good_id = String.valueOf(this.dWs.dWA);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dWj;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dWp);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dWq;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dWA;
        public String dWB;
        public String dWC;
        public String dWD;
        public String dWE;
        public int dWF;
        public String dWG;
        public String dWH;
        public String dWI;
        public List<String> dWJ = new ArrayList(3);
        public VideoInfo dWK;
        public String dWL;
        public String dWM;
        public float dWN;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> yZ;
            if (goodsInfo != null) {
                this.dWA = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dWB = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dWD = goodsInfo.thread_pic;
                this.dWE = goodsInfo.pop_window_text;
                this.dWF = goodsInfo.goods_style.intValue();
                this.dWG = goodsInfo.card_desc;
                this.dWH = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dWI = goodsInfo.button_url;
                this.dWC = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dWJ.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.dWJ) && (yZ = yZ(goodsInfo.lego_card)) != null && this.dWJ != null) {
                        this.dWJ.addAll(yZ);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dWK = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dWL = goodsInfo.tag_name_url;
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
                    this.dWM = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dWN = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> yZ(String str) {
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
        if (this.dWs.dWF == 1001 || this.dWs.dWF == -1001) {
            return dVS;
        }
        if (!com.baidu.tbadk.core.k.bbM().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dVS;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dWb;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dWc;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dWd;
                case 7:
                case 14:
                    return dWe;
                case 12:
                    return dWg;
                case 13:
                    return dWf;
            }
        }
        return null;
    }

    public boolean bcy() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bcz() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
