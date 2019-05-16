package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
public class AdvertAppInfo extends bg {
    public static final BdUniqueId bDB = BdUniqueId.gen();
    public static final BdUniqueId bDC = BdUniqueId.gen();
    public static final BdUniqueId bDD = BdUniqueId.gen();
    public static final BdUniqueId bDE = BdUniqueId.gen();
    public static final BdUniqueId bDF = BdUniqueId.gen();
    public static final BdUniqueId bDG = BdUniqueId.gen();
    public static final BdUniqueId bDH = BdUniqueId.gen();
    public static final BdUniqueId bDI = BdUniqueId.gen();
    public static final BdUniqueId bDJ = BdUniqueId.gen();
    public static final BdUniqueId bDK = BdUniqueId.gen();
    public static final BdUniqueId bDL = BdUniqueId.gen();
    public static final BdUniqueId bDM = BdUniqueId.gen();
    public static final BdUniqueId bDN = BdUniqueId.gen();
    public static final BdUniqueId bDO = BdUniqueId.gen();
    public static final BdUniqueId bDP = BdUniqueId.gen();
    public static AtomicBoolean bDQ = new AtomicBoolean(false);
    public int Sk;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String anT;
    public int bDR;
    public String bDS;
    public String bDT;
    public String bDU;
    public String bDV;
    public String bDW;
    public int bDX;
    public String bDY;
    public int bDZ;
    public String bEa;
    public long bEb;
    public String bEf;
    public String bEg;
    public String bEh;
    private App bEi;
    public AppData bEj;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bEc = new a();
    public boolean bEd = false;
    public ILegoAdvert legoCard = null;
    private int bEe = 32;

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
        return (this.bDS != null ? this.bDS.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bDS, this.bDS) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int abE() {
        if (bg.bII.get() && bDQ.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hI().ay("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bEc == null || this.bEc.bEp != 1001) {
                if (this.bEc == null || TextUtils.isEmpty(this.bEc.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bDS) || TextUtils.isEmpty(this.bDS.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bEc.isValid()) {
                    return this.bEe;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.abb().abf() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bEc == null || !this.bEc.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Sk == 3) {
                    if (!abF()) {
                        return 26;
                    }
                } else if (this.Sk == 1) {
                    if (!abG()) {
                        return 27;
                    }
                } else {
                    return 21;
                }
                return 0;
            }
            return 0;
        }
        return 31;
    }

    public boolean abF() {
        boolean z = true;
        if (this.bEc == null || this.bEc.bEp != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Sk != 3 || this.legoCard.checkLegal(this.Sk) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Sk != 3 || TextUtils.isEmpty(this.bDW.trim()) || TextUtils.isEmpty(this.bDV.trim()) || this.bEc == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bEc.userName) || TextUtils.isEmpty(this.bEc.userName.trim())) && TextUtils.isEmpty(this.bEc.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean abG() {
        if (this.bEc == null || this.bEc.bEp != 1001) {
            if (this.bEc == null || this.bEc.bEp != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Sk == 1 && !((TextUtils.isEmpty(this.bDU) || TextUtils.isEmpty(this.bDU.trim())) && TextUtils.isEmpty(this.bEc.lego_card)) : this.Sk == 1 && this.legoCard.checkLegal(this.Sk) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bEi = app;
            this.bEj = new AppData(app);
            this.bDS = app.id;
            this.bDT = app.name;
            this.Sk = app.url_type.intValue();
            this.bDU = app.url;
            this.bDV = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bDW = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bDX = app.pos.intValue();
            this.anT = app.first_name;
            this.bDY = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bDZ = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bEa = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bEb = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bEc.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hI().ay("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bEc.lego_card)) {
                try {
                    ICardInfo zl = com.baidu.tieba.lego.card.b.zl(this.bEc.lego_card);
                    if (zl != null) {
                        ICardInfo viewItem = zl.getViewItem(0, 1);
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
                        this.bEe = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bEe = 40;
                        } else {
                            this.bEe = 39;
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
        if (this.bEj != null) {
            appData = this.bEj;
        } else if (this.bEi == null) {
            return "";
        } else {
            appData = new AppData(this.bEi);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.f(str, 0));
        builder.da_good_id = String.valueOf(this.bEc.bEk);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bDS;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bDZ);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bEa;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bEk;
        public String bEl;
        public String bEm;
        public String bEn;
        public String bEo;
        public int bEp;
        public String bEq;
        public String bEr;
        public String bEs;
        public List<String> bEt = new ArrayList(3);
        public VideoInfo bEu;
        public String bEv;
        public String bEw;
        public float bEx;
        public String buttonText;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> me;
            if (goodsInfo != null) {
                this.bEk = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bEl = com.baidu.tbadk.core.util.ap.i(goodsInfo.thread_title, 29, "...");
                this.bEn = goodsInfo.thread_pic;
                this.bEo = goodsInfo.pop_window_text;
                this.bEp = goodsInfo.goods_style.intValue();
                this.bEq = goodsInfo.card_desc;
                this.bEr = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bEs = goodsInfo.button_url;
                this.bEm = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bEt.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.aa(this.bEt) && (me = me(goodsInfo.lego_card)) != null && this.bEt != null) {
                        this.bEt.addAll(me);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bEu = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bEv = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                            int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                            if (f2 != 0) {
                                this.tagRatio = f / f2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.bEw = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f3 = com.baidu.adp.lib.g.b.f(split2[0], 1);
                            int f4 = com.baidu.adp.lib.g.b.f(split2[1], 1);
                            if (f4 != 0) {
                                this.bEx = f3 / f4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> me(String str) {
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
            return com.baidu.adp.lib.b.d.hI().ay("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bEc.bEp == 1001 || this.bEc.bEp == -1001) {
            return bDB;
        }
        if (!com.baidu.tbadk.core.i.abb().abf() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bDB;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bDK;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bDL;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bDM;
                case 7:
                    return bDN;
                case 9:
                    return bDP;
                case 10:
                    return bDO;
            }
        }
        return null;
    }
}
