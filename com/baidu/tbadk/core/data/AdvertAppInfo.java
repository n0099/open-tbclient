package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
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
public class AdvertAppInfo extends bh {
    public static final BdUniqueId bWT = BdUniqueId.gen();
    public static final BdUniqueId bWU = BdUniqueId.gen();
    public static final BdUniqueId bWV = BdUniqueId.gen();
    public static final BdUniqueId bWW = BdUniqueId.gen();
    public static final BdUniqueId bWX = BdUniqueId.gen();
    public static final BdUniqueId bWY = BdUniqueId.gen();
    public static final BdUniqueId bWZ = BdUniqueId.gen();
    public static final BdUniqueId bXa = BdUniqueId.gen();
    public static final BdUniqueId bXb = BdUniqueId.gen();
    public static final BdUniqueId bXc = BdUniqueId.gen();
    public static final BdUniqueId bXd = BdUniqueId.gen();
    public static final BdUniqueId bXe = BdUniqueId.gen();
    public static final BdUniqueId bXf = BdUniqueId.gen();
    public static final BdUniqueId bXg = BdUniqueId.gen();
    public static final BdUniqueId bXh = BdUniqueId.gen();
    public static AtomicBoolean bXi = new AtomicBoolean(false);
    public int BV;
    public String aIl;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    private App bXA;
    public AppData bXB;
    public int bXj;
    public String bXk;
    public String bXl;
    public String bXm;
    public String bXn;
    public String bXo;
    public int bXp;
    public String bXq;
    public int bXr;
    public String bXs;
    public long bXt;
    public String bXx;
    public String bXy;
    public String bXz;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bXu = new a();
    public boolean bXv = false;
    public ILegoAdvert legoCard = null;
    private int bXw = 32;

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
        return (this.bXk != null ? this.bXk.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bXk, this.bXk) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int agR() {
        if (bh.cbU.get() && bXi.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bXu == null || this.bXu.bXH != 1001) {
                if (this.bXu == null || TextUtils.isEmpty(this.bXu.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bXk) || TextUtils.isEmpty(this.bXk.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bXu.isValid()) {
                    return this.bXw;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.agq().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bXu == null || !this.bXu.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.BV == 3) {
                    if (!agS()) {
                        return 26;
                    }
                } else if (this.BV == 1) {
                    if (!agT()) {
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

    public boolean agS() {
        boolean z = true;
        if (this.bXu == null || this.bXu.bXH != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.BV != 3 || this.legoCard.checkLegal(this.BV) != 0) {
                    z = false;
                }
                return z;
            } else if (this.BV != 3 || TextUtils.isEmpty(this.bXo.trim()) || TextUtils.isEmpty(this.bXn.trim()) || this.bXu == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bXu.userName) || TextUtils.isEmpty(this.bXu.userName.trim())) && TextUtils.isEmpty(this.bXu.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean agT() {
        if (this.bXu == null || this.bXu.bXH != 1001) {
            if (this.bXu == null || this.bXu.bXH != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.BV == 1 && !((TextUtils.isEmpty(this.bXm) || TextUtils.isEmpty(this.bXm.trim())) && TextUtils.isEmpty(this.bXu.lego_card)) : this.BV == 1 && this.legoCard.checkLegal(this.BV) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bXA = app;
            this.bXB = new AppData(app);
            this.bXk = app.id;
            this.bXl = app.name;
            this.BV = app.url_type.intValue();
            this.bXm = app.url;
            this.bXn = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bXo = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bXp = app.pos.intValue();
            this.aIl = app.first_name;
            this.bXq = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bXr = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bXs = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bXt = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bXu.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bXu.lego_card)) {
                try {
                    ICardInfo yQ = com.baidu.tieba.lego.card.b.yQ(this.bXu.lego_card);
                    if (yQ != null) {
                        ICardInfo viewItem = yQ.getViewItem(0, 1);
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
                        this.bXw = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bXw = 40;
                        } else {
                            this.bXw = 39;
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
        if (this.bXB != null) {
            appData = this.bXB;
        } else if (this.bXA == null) {
            return "";
        } else {
            appData = new AppData(this.bXA);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.bXu.bXC);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bXk;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bXr);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bXs;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bXC;
        public String bXD;
        public String bXE;
        public String bXF;
        public String bXG;
        public int bXH;
        public String bXI;
        public String bXJ;
        public String bXK;
        public List<String> bXL = new ArrayList(3);
        public VideoInfo bXM;
        public String bXN;
        public String bXO;
        public float bXP;
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
            List<String> mN;
            if (goodsInfo != null) {
                this.bXC = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bXD = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.bXF = goodsInfo.thread_pic;
                this.bXG = goodsInfo.pop_window_text;
                this.bXH = goodsInfo.goods_style.intValue();
                this.bXI = goodsInfo.card_desc;
                this.bXJ = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bXK = goodsInfo.button_url;
                this.bXE = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bXL.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.bXL) && (mN = mN(goodsInfo.lego_card)) != null && this.bXL != null) {
                        this.bXL.addAll(mN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bXM = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bXN = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                            int i2 = com.baidu.adp.lib.g.b.toInt(split[1], 1);
                            if (i2 != 0) {
                                this.tagRatio = i / i2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.bXO = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.g.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.g.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.bXP = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> mN(String str) {
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
            return com.baidu.adp.lib.b.d.ft().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bXu.bXH == 1001 || this.bXu.bXH == -1001) {
            return bWT;
        }
        if (!com.baidu.tbadk.core.i.agq().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bWT;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bXc;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bXd;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bXe;
                case 7:
                    return bXf;
                case 9:
                    return bXh;
                case 10:
                    return bXg;
            }
        }
        return null;
    }
}
