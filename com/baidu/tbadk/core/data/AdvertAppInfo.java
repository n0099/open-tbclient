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
    public static final BdUniqueId dlX = BdUniqueId.gen();
    public static final BdUniqueId dlY = BdUniqueId.gen();
    public static final BdUniqueId dlZ = BdUniqueId.gen();
    public static final BdUniqueId dma = BdUniqueId.gen();
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
    public static AtomicBoolean dmm = new AtomicBoolean(false);
    public int XQ;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String bKb;
    public int cpid;
    public String deepUrl;
    public String dmA;
    public String dmB;
    public String dmC;
    private App dmD;
    public AppData dmE;
    public int dmn;
    public String dmo;
    public String dmp;
    public String dmq;
    public String dmr;
    public int dms;
    public String dmt;
    public int dmu;
    public String dmv;
    public long dmw;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a dmx = new a();
    public boolean dmy = false;
    public ILegoAdvert legoCard = null;
    private int dmz = 32;

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
        return (this.dmo != null ? this.dmo.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dmo, this.dmo) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aIF() {
        if (bj.drk.get() && dmm.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dmx == null || this.dmx.dmK != 1001) {
                if (this.dmx == null || TextUtils.isEmpty(this.dmx.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dmo) || TextUtils.isEmpty(this.dmo.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dmx.isValid()) {
                    return this.dmz;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.aIe().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dmx == null || !this.dmx.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.XQ == 3) {
                    if (!aIG()) {
                        return 26;
                    }
                } else if (this.XQ == 1) {
                    if (!aIH()) {
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

    public boolean aIG() {
        boolean z = true;
        if (this.dmx == null || this.dmx.dmK != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.XQ != 3 || this.legoCard.checkLegal(this.XQ) != 0) {
                    z = false;
                }
                return z;
            } else if (this.XQ != 3 || TextUtils.isEmpty(this.dmr.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dmx == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dmx.userName) || TextUtils.isEmpty(this.dmx.userName.trim())) && TextUtils.isEmpty(this.dmx.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aIH() {
        if (this.dmx == null || this.dmx.dmK != 1001) {
            if (this.dmx == null || this.dmx.dmK != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.XQ == 1 && !((TextUtils.isEmpty(this.dmq) || TextUtils.isEmpty(this.dmq.trim())) && TextUtils.isEmpty(this.dmx.lego_card)) : this.XQ == 1 && this.legoCard.checkLegal(this.XQ) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dmD = app;
            this.dmE = new AppData(app);
            this.dmo = app.id;
            this.dmp = app.name;
            this.XQ = app.url_type.intValue();
            this.dmq = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dmr = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dms = app.pos.intValue();
            this.bKb = app.first_name;
            this.dmt = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dmu = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dmv = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dmw = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dmx.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dmx.lego_card)) {
                try {
                    ICardInfo FI = com.baidu.tieba.lego.card.b.FI(this.dmx.lego_card);
                    if (FI != null) {
                        ICardInfo viewItem = FI.getViewItem(0, 1);
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
                        this.dmz = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dmz = 40;
                        } else {
                            this.dmz = 39;
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
        if (this.dmE != null) {
            appData = this.dmE;
        } else if (this.dmD == null) {
            return "";
        } else {
            appData = new AppData(this.dmD);
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
        builder.da_good_id = String.valueOf(this.dmx.dmF);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dmo;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dmu);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dmv;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dmF;
        public String dmG;
        public String dmH;
        public String dmI;
        public String dmJ;
        public int dmK;
        public String dmL;
        public String dmM;
        public String dmN;
        public List<String> dmO = new ArrayList(3);
        public VideoInfo dmP;
        public String dmQ;
        public String dmR;
        public float dmS;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> tI;
            if (goodsInfo != null) {
                this.dmF = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dmG = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dmI = goodsInfo.thread_pic;
                this.dmJ = goodsInfo.pop_window_text;
                this.dmK = goodsInfo.goods_style.intValue();
                this.dmL = goodsInfo.card_desc;
                this.dmM = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dmN = goodsInfo.button_url;
                this.dmH = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dmO.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.dmO) && (tI = tI(goodsInfo.lego_card)) != null && this.dmO != null) {
                        this.dmO.addAll(tI);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dmP = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dmQ = goodsInfo.tag_name_url;
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
                    this.dmR = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dmS = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> tI(String str) {
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
        if (this.dmx.dmK == 1001 || this.dmx.dmK == -1001) {
            return dlX;
        }
        if (!com.baidu.tbadk.core.i.aIe().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dlX;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dmg;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dmh;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dmi;
                case 7:
                    return dmj;
                case 12:
                    return dml;
                case 13:
                    return dmk;
            }
        }
        return null;
    }
}
