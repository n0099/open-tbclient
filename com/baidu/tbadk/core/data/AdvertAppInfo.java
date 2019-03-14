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
    public int Ux;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String anC;
    public int bwC;
    public String bwD;
    public String bwE;
    public String bwF;
    public String bwG;
    public String bwH;
    public int bwI;
    public String bwJ;
    public int bwK;
    public String bwL;
    public long bwM;
    public String bwQ;
    public String bwR;
    public String bwS;
    private App bwT;
    public AppData bwU;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId bwm = BdUniqueId.gen();
    public static final BdUniqueId bwn = BdUniqueId.gen();
    public static final BdUniqueId bwo = BdUniqueId.gen();
    public static final BdUniqueId bwp = BdUniqueId.gen();
    public static final BdUniqueId bwq = BdUniqueId.gen();
    public static final BdUniqueId bwr = BdUniqueId.gen();
    public static final BdUniqueId bws = BdUniqueId.gen();
    public static final BdUniqueId bwt = BdUniqueId.gen();
    public static final BdUniqueId bwu = BdUniqueId.gen();
    public static final BdUniqueId bwv = BdUniqueId.gen();
    public static final BdUniqueId bww = BdUniqueId.gen();
    public static final BdUniqueId bwx = BdUniqueId.gen();
    public static final BdUniqueId bwy = BdUniqueId.gen();
    public static final BdUniqueId bwz = BdUniqueId.gen();
    public static final BdUniqueId bwA = BdUniqueId.gen();
    public static AtomicBoolean bwB = new AtomicBoolean(false);
    public a bwN = new a();
    public boolean bwO = false;
    public ILegoAdvert legoCard = null;
    private int bwP = 32;

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
        return (this.bwD != null ? this.bwD.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bwD, this.bwD) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int Xa() {
        if (bg.bBo.get() && bwB.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bwN == null || this.bwN.bxa != 1001) {
                if (this.bwN == null || TextUtils.isEmpty(this.bwN.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bwD) || TextUtils.isEmpty(this.bwD.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bwN.isValid()) {
                    return this.bwP;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.Wy().WC() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bwN == null || !this.bwN.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Ux == 3) {
                    if (!Xb()) {
                        return 26;
                    }
                } else if (this.Ux == 1) {
                    if (!Xc()) {
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

    public boolean Xb() {
        boolean z = true;
        if (this.bwN == null || this.bwN.bxa != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Ux != 3 || this.legoCard.checkLegal(this.Ux) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Ux != 3 || TextUtils.isEmpty(this.bwH.trim()) || TextUtils.isEmpty(this.bwG.trim()) || this.bwN == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bwN.userName) || TextUtils.isEmpty(this.bwN.userName.trim())) && TextUtils.isEmpty(this.bwN.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean Xc() {
        if (this.bwN == null || this.bwN.bxa != 1001) {
            if (this.bwN == null || this.bwN.bxa != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Ux == 1 && !((TextUtils.isEmpty(this.bwF) || TextUtils.isEmpty(this.bwF.trim())) && TextUtils.isEmpty(this.bwN.lego_card)) : this.Ux == 1 && this.legoCard.checkLegal(this.Ux) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bwT = app;
            this.bwU = new AppData(app);
            this.bwD = app.id;
            this.bwE = app.name;
            this.Ux = app.url_type.intValue();
            this.bwF = app.url;
            this.bwG = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bwH = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bwI = app.pos.intValue();
            this.anC = app.first_name;
            this.bwJ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bwK = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bwL = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bwM = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bwN.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bwN.lego_card)) {
                try {
                    ICardInfo xW = com.baidu.tieba.lego.card.b.xW(this.bwN.lego_card);
                    if (xW != null) {
                        ICardInfo viewItem = xW.getViewItem(0, 1);
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
                        this.bwP = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bwP = 40;
                        } else {
                            this.bwP = 39;
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
        if (this.bwU != null) {
            appData = this.bwU;
        } else if (this.bwT == null) {
            return "";
        } else {
            appData = new AppData(this.bwT);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.l(str, 0));
        builder.da_good_id = String.valueOf(this.bwN.bwV);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bwD;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bwK);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bwL;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int bwV;
        public String bwW;
        public String bwX;
        public String bwY;
        public String bwZ;
        public int bxa;
        public String bxb;
        public String bxc;
        public String bxd;
        public List<String> bxe = new ArrayList(3);
        public VideoInfo bxf;
        public String bxg;
        public String bxh;
        public float bxi;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> kY;
            if (goodsInfo != null) {
                this.bwV = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bwW = com.baidu.tbadk.core.util.ap.f(goodsInfo.thread_title, 29, "...");
                this.bwY = goodsInfo.thread_pic;
                this.bwZ = goodsInfo.pop_window_text;
                this.bxa = goodsInfo.goods_style.intValue();
                this.bxb = goodsInfo.card_desc;
                this.bxc = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bxd = goodsInfo.button_url;
                this.bwX = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bxe.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.T(this.bxe) && (kY = kY(goodsInfo.lego_card)) != null && this.bxe != null) {
                        this.bxe.addAll(kY);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bxf = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bxg = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                            int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                            if (l2 != 0) {
                                this.tagRatio = l / l2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.bxh = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.bxi = l3 / l4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> kY(String str) {
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
            return com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bwN.bxa == 1001 || this.bwN.bxa == -1001) {
            return bwm;
        }
        if (!com.baidu.tbadk.core.i.Wy().WC() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bwm;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bwv;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bww;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bwx;
                case 7:
                    return bwy;
                case 9:
                    return bwA;
                case 10:
                    return bwz;
            }
        }
        return null;
    }
}
