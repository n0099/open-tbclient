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
    public static final BdUniqueId eIO = BdUniqueId.gen();
    public static final BdUniqueId eIP = BdUniqueId.gen();
    public static final BdUniqueId eIQ = BdUniqueId.gen();
    public static final BdUniqueId eIR = BdUniqueId.gen();
    public static final BdUniqueId eIS = BdUniqueId.gen();
    public static final BdUniqueId eIT = BdUniqueId.gen();
    public static final BdUniqueId eIU = BdUniqueId.gen();
    public static final BdUniqueId eIV = BdUniqueId.gen();
    public static final BdUniqueId eIW = BdUniqueId.gen();
    public static final BdUniqueId eIX = BdUniqueId.gen();
    public static final BdUniqueId eIY = BdUniqueId.gen();
    public static final BdUniqueId eIZ = BdUniqueId.gen();
    public static final BdUniqueId eJa = BdUniqueId.gen();
    public static final BdUniqueId eJb = BdUniqueId.gen();
    public static final BdUniqueId eJc = BdUniqueId.gen();
    public static final BdUniqueId eJd = BdUniqueId.gen();
    public static final BdUniqueId eJe = BdUniqueId.gen();
    public static final BdUniqueId eJf = BdUniqueId.gen();
    public static AtomicBoolean eJg = new AtomicBoolean(false);
    public int abE;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String cMC;
    public int cpid;
    public String deepUrl;
    public int eJh;
    public String eJi;
    public String eJj;
    public String eJk;
    public String eJl;
    public int eJm;
    public String eJn;
    public int eJo;
    public String eJp;
    public long eJq;
    public String eJu;
    public String eJv;
    public String eJw;
    private App eJx;
    public AppData eJy;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a eJr = new a();
    public boolean eJs = false;
    public ILegoAdvert legoCard = null;
    private int eJt = 32;
    private boolean eJz = false;

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
        return (this.eJi != null ? this.eJi.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eJi, this.eJi) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bll() {
        if (bz.eOO.get() && eJg.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eJr == null || this.eJr.eJF != 1001) {
                if (this.eJr == null || TextUtils.isEmpty(this.eJr.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eJi) || TextUtils.isEmpty(this.eJi.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eJr.isValid()) {
                    try {
                        if (new JSONObject(this.eJr.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.eJt;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bkB().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.eJr == null || !this.eJr.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.abE == 3) {
                        if (!blm()) {
                            return 26;
                        }
                    } else if (this.abE == 1) {
                        if (!bln()) {
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

    public boolean blm() {
        boolean z = true;
        if (this.eJr == null || this.eJr.eJF != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.abE != 3 || this.legoCard.checkLegal(this.abE) != 0) {
                    z = false;
                }
                return z;
            } else if (this.abE != 3 || TextUtils.isEmpty(this.eJl.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eJr == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.eJr.userName) || TextUtils.isEmpty(this.eJr.userName.trim())) && TextUtils.isEmpty(this.eJr.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bln() {
        if (this.eJr == null || this.eJr.eJF != 1001) {
            if (this.eJr == null || this.eJr.eJF != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.abE == 1 && !((TextUtils.isEmpty(this.eJk) || TextUtils.isEmpty(this.eJk.trim())) && TextUtils.isEmpty(this.eJr.lego_card)) : this.abE == 1 && this.legoCard.checkLegal(this.abE) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.eJx = app;
            this.eJy = new AppData(app);
            this.eJi = app.id;
            this.eJj = app.name;
            this.abE = app.url_type.intValue();
            this.eJk = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eJl = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.eJm = app.pos.intValue();
            this.cMC = app.first_name;
            this.eJn = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eJo = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eJp = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eJq = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eJr.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eJr.lego_card)) {
                try {
                    ICardInfo MO = com.baidu.tieba.lego.card.b.MO(this.eJr.lego_card);
                    if (MO != null) {
                        ICardInfo viewItem = MO.getViewItem(0, 1);
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
                        this.eJt = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eJt = 40;
                        } else {
                            this.eJt = 39;
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
        if (this.eJy != null) {
            appData = this.eJy;
        } else if (this.eJx == null) {
            return "";
        } else {
            appData = new AppData(this.eJx);
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
        builder.da_good_id = String.valueOf(this.eJr.eJA);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eJi;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eJo);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eJp;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int eJA;
        public String eJB;
        public String eJC;
        public String eJD;
        public String eJE;
        public int eJF;
        public String eJG;
        public String eJH;
        public String eJI;
        public List<String> eJJ = new ArrayList(3);
        public VideoInfo eJK;
        public String eJL;
        public String eJM;
        public float eJN;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> zB;
            if (goodsInfo != null) {
                this.eJA = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.eJB = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.eJD = goodsInfo.thread_pic;
                this.eJE = goodsInfo.pop_window_text;
                this.eJF = goodsInfo.goods_style.intValue();
                this.eJG = goodsInfo.card_desc;
                this.eJH = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.eJI = goodsInfo.button_url;
                this.eJC = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.eJJ.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.x.isEmpty(this.eJJ) && (zB = zB(goodsInfo.lego_card)) != null && this.eJJ != null) {
                        this.eJJ.addAll(zB);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.eJK = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.eJL = goodsInfo.tag_name_url;
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
                    this.eJM = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.eJN = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> zB(String str) {
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
        if (this.eJr.eJF == 1001 || this.eJr.eJF == -1001) {
            return eIO;
        }
        if (!com.baidu.tbadk.core.k.bkB().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eIO;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eIX;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eJb;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eJc;
                case 7:
                case 14:
                    return eJd;
                case 12:
                    return eJf;
                case 13:
                    return eJe;
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

    public boolean blo() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    @Override // com.baidu.tbadk.core.data.al
    public AdvertAppInfo blp() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.al
    public void setPosition(int i) {
        this.position = i;
        this.eJz = true;
    }

    @Override // com.baidu.tbadk.core.data.al
    public int blq() {
        return this.position;
    }

    @Override // com.baidu.tbadk.core.data.al
    public boolean blr() {
        return this.eJz;
    }
}
