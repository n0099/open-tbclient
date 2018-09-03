package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
public class AdvertAppInfo extends bb {
    public String abtest;
    public int adD;
    public String adE;
    public String adF;
    public int adG;
    public String adH;
    public String adI;
    public String adJ;
    public int adK;
    public String adL;
    public String adM;
    public int adN;
    public String adO;
    public long adP;
    public String adPosition;
    public String adT;
    public String adU;
    public String adV;
    private App adW;
    public AppData adX;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId adn = BdUniqueId.gen();
    public static final BdUniqueId ado = BdUniqueId.gen();
    public static final BdUniqueId adp = BdUniqueId.gen();
    public static final BdUniqueId adq = BdUniqueId.gen();
    public static final BdUniqueId adr = BdUniqueId.gen();
    public static final BdUniqueId ads = BdUniqueId.gen();
    public static final BdUniqueId adt = BdUniqueId.gen();
    public static final BdUniqueId adu = BdUniqueId.gen();
    public static final BdUniqueId adv = BdUniqueId.gen();
    public static final BdUniqueId adw = BdUniqueId.gen();
    public static final BdUniqueId adx = BdUniqueId.gen();
    public static final BdUniqueId ady = BdUniqueId.gen();
    public static final BdUniqueId adz = BdUniqueId.gen();
    public static final BdUniqueId adA = BdUniqueId.gen();
    public static final BdUniqueId adB = BdUniqueId.gen();
    public static AtomicBoolean adC = new AtomicBoolean(false);
    public a adQ = new a();
    public boolean adR = false;
    public ILegoAdvert legoCard = null;
    private int adS = 32;

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
        return (this.adE != null ? this.adE.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.adE, this.adE) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int tE() {
        if (bb.ahJ.get() && adC.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hv().ax("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.adQ == null || this.adQ.aed != 1001) {
                if (this.adQ == null || TextUtils.isEmpty(this.adQ.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.adE) || TextUtils.isEmpty(this.adE.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.adQ.isValid()) {
                    return this.adS;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.td().tj() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.adQ == null || !this.adQ.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.adG);
                }
                if (this.adG == 3) {
                    if (!tF()) {
                        return 26;
                    }
                } else if (this.adG == 1) {
                    if (!tG()) {
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

    public boolean tF() {
        boolean z = true;
        if (this.adQ == null || this.adQ.aed != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.adG != 3 || this.legoCard.checkLegal(this.adG) != 0) {
                    z = false;
                }
                return z;
            } else if (this.adG != 3 || TextUtils.isEmpty(this.adJ.trim()) || TextUtils.isEmpty(this.adI.trim()) || this.adQ == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.adQ.userName) || TextUtils.isEmpty(this.adQ.userName.trim())) && TextUtils.isEmpty(this.adQ.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean tG() {
        if (this.adQ == null || this.adQ.aed != 1001) {
            if (this.adQ == null || this.adQ.aed != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.adG == 1 && !((TextUtils.isEmpty(this.adH) || TextUtils.isEmpty(this.adH.trim())) && TextUtils.isEmpty(this.adQ.lego_card)) : this.adG == 1 && this.legoCard.checkLegal(this.adG) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.adW = app;
            this.adX = new AppData(app);
            this.adE = app.id;
            this.adF = app.name;
            this.adG = app.url_type.intValue();
            this.adH = app.url;
            this.adI = app.apk_url;
            this.deepUrl = app.deep_url;
            this.adJ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.adK = app.pos.intValue();
            this.adL = app.first_name;
            this.adM = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.adN = app.plan_id.intValue();
            this.userId = app.user_id;
            this.adO = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.adP = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.adQ.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hv().ax("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.adQ.lego_card)) {
                try {
                    ICardInfo pq = com.baidu.tieba.lego.card.b.pq(this.adQ.lego_card);
                    if (pq != null) {
                        ICardInfo viewItem = pq.getViewItem(0, 1);
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
                        this.adS = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.adS = 40;
                        } else {
                            this.adS = 39;
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
        if (this.adX != null) {
            appData = this.adX;
        } else if (this.adW == null) {
            return "";
        } else {
            appData = new AppData(this.adW);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.adQ.adY);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.adE;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.adN);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.adO;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int adY;
        public String adZ;
        public String aea;
        public String aeb;
        public String aec;
        public int aed;
        public String aee;
        public String aef;
        public String aeg;
        public List<String> aeh = new ArrayList(3);
        public VideoInfo aei;
        public String aej;
        public String aek;
        public float ael;
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
            List<String> df;
            if (goodsInfo != null) {
                this.adY = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.adZ = com.baidu.tbadk.core.util.ap.c(goodsInfo.thread_title, 29, "...");
                this.aeb = goodsInfo.thread_pic;
                this.aec = goodsInfo.pop_window_text;
                this.aed = goodsInfo.goods_style.intValue();
                this.aee = goodsInfo.card_desc;
                this.aef = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aeg = goodsInfo.button_url;
                this.aea = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aeh.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.w.z(this.aeh) && (df = df(goodsInfo.lego_card)) != null && this.aeh != null) {
                        this.aeh.addAll(df);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aei = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aej = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.aek = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.ael = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public List<String> df(String str) {
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
            return com.baidu.adp.lib.b.d.hv().ax("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.adQ.aed == 1001 || this.adQ.aed == -1001) {
            return adn;
        }
        if (!com.baidu.tbadk.core.i.td().tj() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return adn;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = adw;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return adx;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return ady;
                case 7:
                    return adz;
                case 9:
                    return adB;
                case 10:
                    return adA;
            }
        }
        return null;
    }
}
