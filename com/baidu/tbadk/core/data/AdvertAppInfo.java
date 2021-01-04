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
public class AdvertAppInfo extends bz implements al {
    public int abG;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String cRo;
    public int cpid;
    public String deepUrl;
    public int eNS;
    public String eNT;
    public String eNU;
    public String eNV;
    public String eNW;
    public int eNX;
    public String eNY;
    public int eNZ;
    public String eOa;
    public long eOb;
    public String eOf;
    public String eOg;
    public String eOh;
    private App eOi;
    public AppData eOj;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId eNz = BdUniqueId.gen();
    public static final BdUniqueId eNA = BdUniqueId.gen();
    public static final BdUniqueId eNB = BdUniqueId.gen();
    public static final BdUniqueId eNC = BdUniqueId.gen();
    public static final BdUniqueId eND = BdUniqueId.gen();
    public static final BdUniqueId eNE = BdUniqueId.gen();
    public static final BdUniqueId eNF = BdUniqueId.gen();
    public static final BdUniqueId eNG = BdUniqueId.gen();
    public static final BdUniqueId eNH = BdUniqueId.gen();
    public static final BdUniqueId eNI = BdUniqueId.gen();
    public static final BdUniqueId eNJ = BdUniqueId.gen();
    public static final BdUniqueId eNK = BdUniqueId.gen();
    public static final BdUniqueId eNL = BdUniqueId.gen();
    public static final BdUniqueId eNM = BdUniqueId.gen();
    public static final BdUniqueId eNN = BdUniqueId.gen();
    public static final BdUniqueId eNO = BdUniqueId.gen();
    public static final BdUniqueId eNP = BdUniqueId.gen();
    public static final BdUniqueId eNQ = BdUniqueId.gen();
    public static AtomicBoolean eNR = new AtomicBoolean(false);
    public a eOc = new a();
    public boolean eOd = false;
    public ILegoAdvert legoCard = null;
    private int eOe = 32;
    private boolean eOk = false;

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
        return (this.eNT != null ? this.eNT.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eNT, this.eNT) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bpe() {
        if (bz.eTz.get() && eNR.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eOc == null || this.eOc.eOq != 1001) {
                if (this.eOc == null || TextUtils.isEmpty(this.eOc.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eNT) || TextUtils.isEmpty(this.eNT.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eOc.isValid()) {
                    try {
                        if (new JSONObject(this.eOc.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.eOe;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bou().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.eOc == null || !this.eOc.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.abG == 3) {
                        if (!bpf()) {
                            return 26;
                        }
                    } else if (this.abG == 1) {
                        if (!bpg()) {
                            return 27;
                        }
                    } else {
                        return 21;
                    }
                    return (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) ? 37 : 0;
                }
            }
            return 0;
        }
        return 31;
    }

    public boolean bpf() {
        boolean z = true;
        if (this.eOc == null || this.eOc.eOq != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.abG != 3 || this.legoCard.checkLegal(this.abG) != 0) {
                    z = false;
                }
                return z;
            } else if (this.abG != 3 || TextUtils.isEmpty(this.eNW.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eOc == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.eOc.userName) || TextUtils.isEmpty(this.eOc.userName.trim())) && TextUtils.isEmpty(this.eOc.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bpg() {
        if (this.eOc == null || this.eOc.eOq != 1001) {
            if (this.eOc == null || this.eOc.eOq != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.abG == 1 && !((TextUtils.isEmpty(this.eNV) || TextUtils.isEmpty(this.eNV.trim())) && TextUtils.isEmpty(this.eOc.lego_card)) : this.abG == 1 && this.legoCard.checkLegal(this.abG) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.eOi = app;
            this.eOj = new AppData(app);
            this.eNT = app.id;
            this.eNU = app.name;
            this.abG = app.url_type.intValue();
            this.eNV = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eNW = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.eNX = app.pos.intValue();
            this.cRo = app.first_name;
            this.eNY = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eNZ = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eOa = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eOb = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eOc.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eOc.lego_card)) {
                try {
                    ICardInfo NX = com.baidu.tieba.lego.card.b.NX(this.eOc.lego_card);
                    if (NX != null) {
                        ICardInfo viewItem = NX.getViewItem(0, 1);
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
                        this.eOe = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eOe = 40;
                        } else {
                            this.eOe = 39;
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
        if (this.eOj != null) {
            appData = this.eOj;
        } else if (this.eOi == null) {
            return "";
        } else {
            appData = new AppData(this.eOi);
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
        builder.da_good_id = String.valueOf(this.eOc.eOl);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eNT;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eNZ);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eOa;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int eOl;
        public String eOm;
        public String eOn;
        public String eOo;
        public String eOp;
        public int eOq;
        public String eOr;
        public String eOs;
        public String eOt;
        public List<String> eOu = new ArrayList(3);
        public VideoInfo eOv;
        public String eOw;
        public String eOx;
        public float eOy;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> AN;
            if (goodsInfo != null) {
                this.eOl = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.eOm = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.eOo = goodsInfo.thread_pic;
                this.eOp = goodsInfo.pop_window_text;
                this.eOq = goodsInfo.goods_style.intValue();
                this.eOr = goodsInfo.card_desc;
                this.eOs = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.eOt = goodsInfo.button_url;
                this.eOn = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.eOu.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.x.isEmpty(this.eOu) && (AN = AN(goodsInfo.lego_card)) != null && this.eOu != null) {
                        this.eOu.addAll(AN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.eOv = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.eOw = goodsInfo.tag_name_url;
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
                    this.eOx = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.eOy = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> AN(String str) {
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

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eOc.eOq == 1001 || this.eOc.eOq == -1001) {
            return eNz;
        }
        if (!com.baidu.tbadk.core.k.bou().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eNz;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eNI;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eNM;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eNN;
                case 7:
                case 14:
                    return eNO;
                case 12:
                    return eNQ;
                case 13:
                    return eNP;
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

    public boolean bph() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo bpi() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.eOk = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int bpj() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean bpk() {
        return this.eOk;
    }
}
