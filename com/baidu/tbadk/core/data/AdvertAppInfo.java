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
    public static final BdUniqueId eke = BdUniqueId.gen();
    public static final BdUniqueId ekf = BdUniqueId.gen();
    public static final BdUniqueId ekg = BdUniqueId.gen();
    public static final BdUniqueId ekh = BdUniqueId.gen();
    public static final BdUniqueId eki = BdUniqueId.gen();
    public static final BdUniqueId ekj = BdUniqueId.gen();
    public static final BdUniqueId ekk = BdUniqueId.gen();
    public static final BdUniqueId ekl = BdUniqueId.gen();
    public static final BdUniqueId ekm = BdUniqueId.gen();
    public static final BdUniqueId ekn = BdUniqueId.gen();
    public static final BdUniqueId eko = BdUniqueId.gen();
    public static final BdUniqueId ekp = BdUniqueId.gen();
    public static final BdUniqueId ekq = BdUniqueId.gen();
    public static final BdUniqueId ekr = BdUniqueId.gen();
    public static final BdUniqueId eks = BdUniqueId.gen();
    public static AtomicBoolean ekt = new AtomicBoolean(false);
    public int ZT;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public int cpid;
    public String csQ;
    public String deepUrl;
    public String ekA;
    public int ekB;
    public String ekC;
    public long ekD;
    public String ekH;
    public String ekI;
    public String ekJ;
    private App ekK;
    public AppData ekL;
    public int eku;
    public String ekv;
    public String ekw;
    public String ekx;
    public String eky;
    public int ekz;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a ekE = new a();
    public boolean ekF = false;
    public ILegoAdvert legoCard = null;
    private int ekG = 32;

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
        return (this.ekv != null ? this.ekv.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.ekv, this.ekv) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bfY() {
        if (bw.epW.get() && ekt.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.ekE == null || this.ekE.ekR != 1001) {
                if (this.ekE == null || TextUtils.isEmpty(this.ekE.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.ekv) || TextUtils.isEmpty(this.ekv.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.ekE.isValid()) {
                    return this.ekG;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bfo().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.ekE == null || !this.ekE.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.ZT == 3) {
                    if (!bfZ()) {
                        return 26;
                    }
                } else if (this.ZT == 1) {
                    if (!bga()) {
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

    public boolean bfZ() {
        boolean z = true;
        if (this.ekE == null || this.ekE.ekR != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ZT != 3 || this.legoCard.checkLegal(this.ZT) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ZT != 3 || TextUtils.isEmpty(this.eky.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.ekE == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.ekE.userName) || TextUtils.isEmpty(this.ekE.userName.trim())) && TextUtils.isEmpty(this.ekE.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bga() {
        if (this.ekE == null || this.ekE.ekR != 1001) {
            if (this.ekE == null || this.ekE.ekR != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ZT == 1 && !((TextUtils.isEmpty(this.ekx) || TextUtils.isEmpty(this.ekx.trim())) && TextUtils.isEmpty(this.ekE.lego_card)) : this.ZT == 1 && this.legoCard.checkLegal(this.ZT) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.ekK = app;
            this.ekL = new AppData(app);
            this.ekv = app.id;
            this.ekw = app.name;
            this.ZT = app.url_type.intValue();
            this.ekx = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eky = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.ekz = app.pos.intValue();
            this.csQ = app.first_name;
            this.ekA = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.ekB = app.plan_id.intValue();
            this.userId = app.user_id;
            this.ekC = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.ekD = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.ekE.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.ekE.lego_card)) {
                try {
                    ICardInfo MV = com.baidu.tieba.lego.card.b.MV(this.ekE.lego_card);
                    if (MV != null) {
                        ICardInfo viewItem = MV.getViewItem(0, 1);
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
                        this.ekG = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.ekG = 40;
                        } else {
                            this.ekG = 39;
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
        if (this.ekL != null) {
            appData = this.ekL;
        } else if (this.ekK == null) {
            return "";
        } else {
            appData = new AppData(this.ekK);
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
        builder.da_good_id = String.valueOf(this.ekE.ekM);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.ekv;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.ekB);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.ekC;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int ekM;
        public String ekN;
        public String ekO;
        public String ekP;
        public String ekQ;
        public int ekR;
        public String ekS;
        public String ekT;
        public String ekU;
        public List<String> ekV = new ArrayList(3);
        public VideoInfo ekW;
        public String ekX;
        public String ekY;
        public float ekZ;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> Ag;
            if (goodsInfo != null) {
                this.ekM = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.ekN = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.ekP = goodsInfo.thread_pic;
                this.ekQ = goodsInfo.pop_window_text;
                this.ekR = goodsInfo.goods_style.intValue();
                this.ekS = goodsInfo.card_desc;
                this.ekT = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.ekU = goodsInfo.button_url;
                this.ekO = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.ekV.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.ekV) && (Ag = Ag(goodsInfo.lego_card)) != null && this.ekV != null) {
                        this.ekV.addAll(Ag);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.ekW = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.ekX = goodsInfo.tag_name_url;
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
                    this.ekY = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.ekZ = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> Ag(String str) {
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
        if (this.ekE.ekR == 1001 || this.ekE.ekR == -1001) {
            return eke;
        }
        if (!com.baidu.tbadk.core.k.bfo().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eke;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = ekn;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eko;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return ekp;
                case 7:
                case 14:
                    return ekq;
                case 12:
                    return eks;
                case 13:
                    return ekr;
            }
        }
        return null;
    }

    public boolean bgb() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bgc() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
