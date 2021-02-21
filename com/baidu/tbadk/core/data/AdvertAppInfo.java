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
    public static final BdUniqueId eLa = BdUniqueId.gen();
    public static final BdUniqueId eLb = BdUniqueId.gen();
    public static final BdUniqueId eLc = BdUniqueId.gen();
    public static final BdUniqueId eLd = BdUniqueId.gen();
    public static final BdUniqueId eLe = BdUniqueId.gen();
    public static final BdUniqueId eLf = BdUniqueId.gen();
    public static final BdUniqueId eLg = BdUniqueId.gen();
    public static final BdUniqueId eLh = BdUniqueId.gen();
    public static final BdUniqueId eLi = BdUniqueId.gen();
    public static final BdUniqueId eLj = BdUniqueId.gen();
    public static final BdUniqueId eLk = BdUniqueId.gen();
    public static final BdUniqueId eLl = BdUniqueId.gen();
    public static final BdUniqueId eLm = BdUniqueId.gen();
    public static final BdUniqueId eLn = BdUniqueId.gen();
    public static final BdUniqueId eLo = BdUniqueId.gen();
    public static final BdUniqueId eLp = BdUniqueId.gen();
    public static final BdUniqueId eLq = BdUniqueId.gen();
    public static final BdUniqueId eLr = BdUniqueId.gen();
    public static AtomicBoolean eLs = new AtomicBoolean(false);
    public String abtest;
    public int abz;
    public String adPosition;
    public d advertAppContext;
    public String apkUrl;
    public String cOQ;
    public int cpid;
    public String deepUrl;
    public String eLA;
    public long eLB;
    public String eLF;
    public String eLG;
    public String eLH;
    public App eLI;
    public AppData eLJ;
    public String eLt;
    public String eLu;
    public String eLv;
    public String eLw;
    public int eLx;
    public String eLy;
    public int eLz;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a eLC = new a();
    public boolean eLD = false;
    public ILegoAdvert legoCard = null;
    private int eLE = 32;
    private boolean eLK = false;
    public boolean eLL = false;

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
        return (this.eLt != null ? this.eLt.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eLt, this.eLt) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int blD() {
        if (!cb.eRa.get()) {
            com.baidu.tieba.recapp.t.dDu();
            return 31;
        } else if (!eLs.get()) {
            com.baidu.tieba.recapp.t.dDu();
            return 31;
        } else if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
            return 23;
        } else {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eLC == null || this.eLC.eLR != 1001) {
                if (this.eLC == null || TextUtils.isEmpty(this.eLC.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eLt) || TextUtils.isEmpty(this.eLt.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eLC.isValid()) {
                    try {
                        if (new JSONObject(this.eLC.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.eLE;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bkT().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.eLC == null || !this.eLC.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.abz == 3) {
                        if (!blE()) {
                            return 26;
                        }
                    } else if (this.abz == 1) {
                        if (!blF()) {
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

    public boolean blE() {
        boolean z = true;
        if (this.eLC == null || this.eLC.eLR != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.abz != 3 || this.legoCard.checkLegal(this.abz) != 0) {
                    z = false;
                }
                return z;
            } else if (this.abz != 3 || TextUtils.isEmpty(this.eLw.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eLC == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.eLC.userName) || TextUtils.isEmpty(this.eLC.userName.trim())) && TextUtils.isEmpty(this.eLC.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean blF() {
        if (this.eLC == null || this.eLC.eLR != 1001) {
            if (this.eLC == null || this.eLC.eLR != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.abz == 1 && !((TextUtils.isEmpty(this.eLv) || TextUtils.isEmpty(this.eLv.trim())) && TextUtils.isEmpty(this.eLC.lego_card)) : this.abz == 1 && this.legoCard.checkLegal(this.abz) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.eLI = app;
            this.eLJ = new AppData(app);
            this.eLt = app.id;
            this.eLu = app.name;
            this.abz = app.url_type.intValue();
            this.eLv = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eLw = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.position = com.baidu.adp.lib.f.b.toInt(app.pos_name, -1) - 1;
            this.eLx = app.pos.intValue();
            this.cOQ = app.first_name;
            this.eLy = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eLz = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eLA = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eLB = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eLC.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eLC.lego_card)) {
                try {
                    ICardInfo NE = com.baidu.tieba.lego.card.b.NE(this.eLC.lego_card);
                    if (NE != null) {
                        ICardInfo viewItem = NE.getViewItem(0, 1);
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
                        this.eLE = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eLE = 40;
                        } else {
                            this.eLE = 39;
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
        if (this.eLJ != null) {
            appData = this.eLJ;
        } else if (this.eLI == null) {
            return "";
        } else {
            appData = new AppData(this.eLI);
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
        builder.da_good_id = String.valueOf(this.eLC.eLM);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eLt;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eLz);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eLA;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int eLM;
        public String eLN;
        public String eLO;
        public String eLP;
        public String eLQ;
        public int eLR;
        public String eLS;
        public String eLT;
        public String eLU;
        public List<String> eLV = new ArrayList(3);
        public VideoInfo eLW;
        public String eLX;
        public String eLY;
        public float eLZ;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> zS;
            if (goodsInfo != null) {
                this.eLM = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.eLN = com.baidu.tbadk.core.util.au.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.eLP = goodsInfo.thread_pic;
                this.eLQ = goodsInfo.pop_window_text;
                this.eLR = goodsInfo.goods_style.intValue();
                this.eLS = goodsInfo.card_desc;
                this.eLT = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.eLU = goodsInfo.button_url;
                this.eLO = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.eLV.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.eLV) && (zS = zS(goodsInfo.lego_card)) != null && this.eLV != null) {
                        this.eLV.addAll(zS);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.eLW = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.eLX = goodsInfo.tag_name_url;
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
                    this.eLY = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.eLZ = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> zS(String str) {
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
        if (this.eLC.eLR == 1001 || this.eLC.eLR == -1001) {
            return eLa;
        }
        if (!com.baidu.tbadk.core.k.bkT().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eLa;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eLj;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eLn;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eLo;
                case 7:
                case 14:
                    return eLp;
                case 12:
                    return eLr;
                case 13:
                    return eLq;
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

    public boolean blG() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    @Override // com.baidu.tbadk.core.data.am
    public AdvertAppInfo blH() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.am
    public void setPosition(int i) {
        this.position = i;
        this.eLK = true;
    }

    @Override // com.baidu.tbadk.core.data.am
    public int blI() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.am
    public boolean blJ() {
        return this.eLK;
    }
}
