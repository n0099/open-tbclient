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
    public static final BdUniqueId bwk = BdUniqueId.gen();
    public static final BdUniqueId bwl = BdUniqueId.gen();
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
    public static AtomicBoolean bwz = new AtomicBoolean(false);
    public int Uw;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String anB;
    public int bwA;
    public String bwB;
    public String bwC;
    public String bwD;
    public String bwE;
    public String bwF;
    public int bwG;
    public String bwH;
    public int bwI;
    public String bwJ;
    public long bwK;
    public String bwO;
    public String bwP;
    public String bwQ;
    private App bwR;
    public AppData bwS;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bwL = new a();
    public boolean bwM = false;
    public ILegoAdvert legoCard = null;
    private int bwN = 32;

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
        return (this.bwB != null ? this.bwB.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bwB, this.bwB) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int Xa() {
        if (bg.bBm.get() && bwz.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bwL == null || this.bwL.bwY != 1001) {
                if (this.bwL == null || TextUtils.isEmpty(this.bwL.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bwB) || TextUtils.isEmpty(this.bwB.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bwL.isValid()) {
                    return this.bwN;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.Wy().WC() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bwL == null || !this.bwL.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Uw == 3) {
                    if (!Xb()) {
                        return 26;
                    }
                } else if (this.Uw == 1) {
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
        if (this.bwL == null || this.bwL.bwY != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Uw != 3 || this.legoCard.checkLegal(this.Uw) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Uw != 3 || TextUtils.isEmpty(this.bwF.trim()) || TextUtils.isEmpty(this.bwE.trim()) || this.bwL == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bwL.userName) || TextUtils.isEmpty(this.bwL.userName.trim())) && TextUtils.isEmpty(this.bwL.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean Xc() {
        if (this.bwL == null || this.bwL.bwY != 1001) {
            if (this.bwL == null || this.bwL.bwY != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Uw == 1 && !((TextUtils.isEmpty(this.bwD) || TextUtils.isEmpty(this.bwD.trim())) && TextUtils.isEmpty(this.bwL.lego_card)) : this.Uw == 1 && this.legoCard.checkLegal(this.Uw) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bwR = app;
            this.bwS = new AppData(app);
            this.bwB = app.id;
            this.bwC = app.name;
            this.Uw = app.url_type.intValue();
            this.bwD = app.url;
            this.bwE = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bwF = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bwG = app.pos.intValue();
            this.anB = app.first_name;
            this.bwH = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bwI = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bwJ = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bwK = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bwL.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bwL.lego_card)) {
                try {
                    ICardInfo xX = com.baidu.tieba.lego.card.b.xX(this.bwL.lego_card);
                    if (xX != null) {
                        ICardInfo viewItem = xX.getViewItem(0, 1);
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
                        this.bwN = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bwN = 40;
                        } else {
                            this.bwN = 39;
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
        if (this.bwS != null) {
            appData = this.bwS;
        } else if (this.bwR == null) {
            return "";
        } else {
            appData = new AppData(this.bwR);
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
        builder.da_good_id = String.valueOf(this.bwL.bwT);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bwB;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bwI);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bwJ;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int bwT;
        public String bwU;
        public String bwV;
        public String bwW;
        public String bwX;
        public int bwY;
        public String bwZ;
        public String bxa;
        public String bxb;
        public List<String> bxc = new ArrayList(3);
        public VideoInfo bxd;
        public String bxe;
        public String bxf;
        public float bxg;
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
                this.bwT = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bwU = com.baidu.tbadk.core.util.ap.f(goodsInfo.thread_title, 29, "...");
                this.bwW = goodsInfo.thread_pic;
                this.bwX = goodsInfo.pop_window_text;
                this.bwY = goodsInfo.goods_style.intValue();
                this.bwZ = goodsInfo.card_desc;
                this.bxa = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bxb = goodsInfo.button_url;
                this.bwV = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bxc.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.T(this.bxc) && (kY = kY(goodsInfo.lego_card)) != null && this.bxc != null) {
                        this.bxc.addAll(kY);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bxd = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bxe = goodsInfo.tag_name_url;
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
                    this.bxf = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.bxg = l3 / l4;
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
        if (this.bwL.bwY == 1001 || this.bwL.bwY == -1001) {
            return bwk;
        }
        if (!com.baidu.tbadk.core.i.Wy().WC() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bwk;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bwt;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bwu;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bwv;
                case 7:
                    return bww;
                case 9:
                    return bwy;
                case 10:
                    return bwx;
            }
        }
        return null;
    }
}
