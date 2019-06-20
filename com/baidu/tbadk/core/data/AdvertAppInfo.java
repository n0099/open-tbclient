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
    public static final BdUniqueId bDQ = BdUniqueId.gen();
    public static AtomicBoolean bDR = new AtomicBoolean(false);
    public int Sj;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String anT;
    public int bDS;
    public String bDT;
    public String bDU;
    public String bDV;
    public String bDW;
    public String bDX;
    public int bDY;
    public String bDZ;
    public int bEa;
    public String bEb;
    public long bEc;
    public String bEg;
    public String bEh;
    public String bEi;
    private App bEj;
    public AppData bEk;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bEd = new a();
    public boolean bEe = false;
    public ILegoAdvert legoCard = null;
    private int bEf = 32;

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
        return (this.bDT != null ? this.bDT.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bDT, this.bDT) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int abE() {
        if (bg.bIJ.get() && bDR.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hI().ay("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bEd == null || this.bEd.bEq != 1001) {
                if (this.bEd == null || TextUtils.isEmpty(this.bEd.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bDT) || TextUtils.isEmpty(this.bDT.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bEd.isValid()) {
                    return this.bEf;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.abb().abf() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bEd == null || !this.bEd.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Sj == 3) {
                    if (!abF()) {
                        return 26;
                    }
                } else if (this.Sj == 1) {
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
        if (this.bEd == null || this.bEd.bEq != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Sj != 3 || this.legoCard.checkLegal(this.Sj) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Sj != 3 || TextUtils.isEmpty(this.bDX.trim()) || TextUtils.isEmpty(this.bDW.trim()) || this.bEd == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bEd.userName) || TextUtils.isEmpty(this.bEd.userName.trim())) && TextUtils.isEmpty(this.bEd.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean abG() {
        if (this.bEd == null || this.bEd.bEq != 1001) {
            if (this.bEd == null || this.bEd.bEq != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Sj == 1 && !((TextUtils.isEmpty(this.bDV) || TextUtils.isEmpty(this.bDV.trim())) && TextUtils.isEmpty(this.bEd.lego_card)) : this.Sj == 1 && this.legoCard.checkLegal(this.Sj) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bEj = app;
            this.bEk = new AppData(app);
            this.bDT = app.id;
            this.bDU = app.name;
            this.Sj = app.url_type.intValue();
            this.bDV = app.url;
            this.bDW = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bDX = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bDY = app.pos.intValue();
            this.anT = app.first_name;
            this.bDZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bEa = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bEb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bEc = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bEd.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hI().ay("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bEd.lego_card)) {
                try {
                    ICardInfo zn = com.baidu.tieba.lego.card.b.zn(this.bEd.lego_card);
                    if (zn != null) {
                        ICardInfo viewItem = zn.getViewItem(0, 1);
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
                        this.bEf = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bEf = 40;
                        } else {
                            this.bEf = 39;
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
        if (this.bEk != null) {
            appData = this.bEk;
        } else if (this.bEj == null) {
            return "";
        } else {
            appData = new AppData(this.bEj);
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
        builder.da_good_id = String.valueOf(this.bEd.bEl);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bDT;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bEa);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bEb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bEl;
        public String bEm;
        public String bEn;
        public String bEo;
        public String bEp;
        public int bEq;
        public String bEr;
        public String bEs;
        public String bEt;
        public List<String> bEu = new ArrayList(3);
        public VideoInfo bEv;
        public String bEw;
        public String bEx;
        public float bEy;
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
            List<String> md;
            if (goodsInfo != null) {
                this.bEl = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bEm = com.baidu.tbadk.core.util.ap.i(goodsInfo.thread_title, 29, "...");
                this.bEo = goodsInfo.thread_pic;
                this.bEp = goodsInfo.pop_window_text;
                this.bEq = goodsInfo.goods_style.intValue();
                this.bEr = goodsInfo.card_desc;
                this.bEs = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bEt = goodsInfo.button_url;
                this.bEn = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bEu.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.aa(this.bEu) && (md = md(goodsInfo.lego_card)) != null && this.bEu != null) {
                        this.bEu.addAll(md);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bEv = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bEw = goodsInfo.tag_name_url;
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
                    this.bEx = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f3 = com.baidu.adp.lib.g.b.f(split2[0], 1);
                            int f4 = com.baidu.adp.lib.g.b.f(split2[1], 1);
                            if (f4 != 0) {
                                this.bEy = f3 / f4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> md(String str) {
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
        if (this.bEd.bEq == 1001 || this.bEd.bEq == -1001) {
            return bDC;
        }
        if (!com.baidu.tbadk.core.i.abb().abf() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bDC;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bDL;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bDM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bDN;
                case 7:
                    return bDO;
                case 9:
                    return bDQ;
                case 10:
                    return bDP;
            }
        }
        return null;
    }
}
