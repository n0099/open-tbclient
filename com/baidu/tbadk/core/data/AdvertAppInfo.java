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
public class AdvertAppInfo extends by implements al {
    public static final BdUniqueId eDM = BdUniqueId.gen();
    public static final BdUniqueId eDN = BdUniqueId.gen();
    public static final BdUniqueId eDO = BdUniqueId.gen();
    public static final BdUniqueId eDP = BdUniqueId.gen();
    public static final BdUniqueId eDQ = BdUniqueId.gen();
    public static final BdUniqueId eDR = BdUniqueId.gen();
    public static final BdUniqueId eDS = BdUniqueId.gen();
    public static final BdUniqueId eDT = BdUniqueId.gen();
    public static final BdUniqueId eDU = BdUniqueId.gen();
    public static final BdUniqueId eDV = BdUniqueId.gen();
    public static final BdUniqueId eDW = BdUniqueId.gen();
    public static final BdUniqueId eDX = BdUniqueId.gen();
    public static final BdUniqueId eDY = BdUniqueId.gen();
    public static final BdUniqueId eDZ = BdUniqueId.gen();
    public static final BdUniqueId eEa = BdUniqueId.gen();
    public static AtomicBoolean eEb = new AtomicBoolean(false);
    public int aaV;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String cMt;
    public int cpid;
    public String deepUrl;
    public int eEc;
    public String eEd;
    public String eEe;
    public String eEf;
    public String eEg;
    public int eEh;
    public String eEi;
    public int eEj;
    public String eEk;
    public long eEl;
    public String eEp;
    public String eEq;
    public String eEr;
    private App eEs;
    public AppData eEt;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a eEm = new a();
    public boolean eEn = false;
    public ILegoAdvert legoCard = null;
    private int eEo = 32;
    private boolean eEu = false;

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
        return (this.eEd != null ? this.eEd.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eEd, this.eEd) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bmD() {
        if (by.eJG.get() && eEb.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eEm == null || this.eEm.eEA != 1001) {
                if (this.eEm == null || TextUtils.isEmpty(this.eEm.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eEd) || TextUtils.isEmpty(this.eEd.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eEm.isValid()) {
                    try {
                        if (new JSONObject(this.eEm.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.eEo;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.blV().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.eEm == null || !this.eEm.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.aaV == 3) {
                        if (!bmE()) {
                            return 26;
                        }
                    } else if (this.aaV == 1) {
                        if (!bmF()) {
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

    public boolean bmE() {
        boolean z = true;
        if (this.eEm == null || this.eEm.eEA != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aaV != 3 || this.legoCard.checkLegal(this.aaV) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aaV != 3 || TextUtils.isEmpty(this.eEg.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eEm == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.eEm.userName) || TextUtils.isEmpty(this.eEm.userName.trim())) && TextUtils.isEmpty(this.eEm.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bmF() {
        if (this.eEm == null || this.eEm.eEA != 1001) {
            if (this.eEm == null || this.eEm.eEA != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aaV == 1 && !((TextUtils.isEmpty(this.eEf) || TextUtils.isEmpty(this.eEf.trim())) && TextUtils.isEmpty(this.eEm.lego_card)) : this.aaV == 1 && this.legoCard.checkLegal(this.aaV) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.eEs = app;
            this.eEt = new AppData(app);
            this.eEd = app.id;
            this.eEe = app.name;
            this.aaV = app.url_type.intValue();
            this.eEf = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eEg = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.eEh = app.pos.intValue();
            this.cMt = app.first_name;
            this.eEi = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eEj = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eEk = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eEl = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eEm.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eEm.lego_card)) {
                try {
                    ICardInfo Op = com.baidu.tieba.lego.card.b.Op(this.eEm.lego_card);
                    if (Op != null) {
                        ICardInfo viewItem = Op.getViewItem(0, 1);
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
                        this.eEo = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eEo = 40;
                        } else {
                            this.eEo = 39;
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
        if (this.eEt != null) {
            appData = this.eEt;
        } else if (this.eEs == null) {
            return "";
        } else {
            appData = new AppData(this.eEs);
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
        builder.da_good_id = String.valueOf(this.eEm.eEv);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eEd;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eEj);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eEk;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int eEA;
        public String eEB;
        public String eEC;
        public String eED;
        public List<String> eEE = new ArrayList(3);
        public VideoInfo eEF;
        public String eEG;
        public String eEH;
        public float eEI;
        public int eEv;
        public String eEw;
        public String eEx;
        public String eEy;
        public String eEz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> AP;
            if (goodsInfo != null) {
                this.eEv = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.eEw = com.baidu.tbadk.core.util.au.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.eEy = goodsInfo.thread_pic;
                this.eEz = goodsInfo.pop_window_text;
                this.eEA = goodsInfo.goods_style.intValue();
                this.eEB = goodsInfo.card_desc;
                this.eEC = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.eED = goodsInfo.button_url;
                this.eEx = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.eEE.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.eEE) && (AP = AP(goodsInfo.lego_card)) != null && this.eEE != null) {
                        this.eEE.addAll(AP);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.eEF = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.eEG = goodsInfo.tag_name_url;
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
                    this.eEH = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.eEI = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> AP(String str) {
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

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eEm.eEA == 1001 || this.eEm.eEA == -1001) {
            return eDM;
        }
        if (!com.baidu.tbadk.core.k.blV().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eDM;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eDV;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eDW;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eDX;
                case 7:
                case 14:
                    return eDY;
                case 12:
                    return eEa;
                case 13:
                    return eDZ;
            }
        }
        return null;
    }

    public boolean bmG() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bmH() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo bmI() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.eEu = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int bmJ() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean bmK() {
        return this.eEu;
    }
}
