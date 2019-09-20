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
public class AdvertAppInfo extends bh {
    public static final BdUniqueId bFb = BdUniqueId.gen();
    public static final BdUniqueId bFc = BdUniqueId.gen();
    public static final BdUniqueId bFd = BdUniqueId.gen();
    public static final BdUniqueId bFe = BdUniqueId.gen();
    public static final BdUniqueId bFf = BdUniqueId.gen();
    public static final BdUniqueId bFg = BdUniqueId.gen();
    public static final BdUniqueId bFh = BdUniqueId.gen();
    public static final BdUniqueId bFi = BdUniqueId.gen();
    public static final BdUniqueId bFj = BdUniqueId.gen();
    public static final BdUniqueId bFk = BdUniqueId.gen();
    public static final BdUniqueId bFl = BdUniqueId.gen();
    public static final BdUniqueId bFm = BdUniqueId.gen();
    public static final BdUniqueId bFn = BdUniqueId.gen();
    public static final BdUniqueId bFo = BdUniqueId.gen();
    public static final BdUniqueId bFp = BdUniqueId.gen();
    public static AtomicBoolean bFq = new AtomicBoolean(false);
    public int SA;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String aoU;
    public String bFA;
    public long bFB;
    public String bFF;
    public String bFG;
    public String bFH;
    private App bFI;
    public AppData bFJ;
    public int bFr;
    public String bFs;
    public String bFt;
    public String bFu;
    public String bFv;
    public String bFw;
    public int bFx;
    public String bFy;
    public int bFz;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bFC = new a();
    public boolean bFD = false;
    public ILegoAdvert legoCard = null;
    private int bFE = 32;

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
        return (this.bFs != null ? this.bFs.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bFs, this.bFs) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int acL() {
        if (bh.bKm.get() && bFq.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bFC == null || this.bFC.bFP != 1001) {
                if (this.bFC == null || TextUtils.isEmpty(this.bFC.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bFs) || TextUtils.isEmpty(this.bFs.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bFC.isValid()) {
                    return this.bFE;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.ace().aci() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bFC == null || !this.bFC.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.SA == 3) {
                    if (!acM()) {
                        return 26;
                    }
                } else if (this.SA == 1) {
                    if (!acN()) {
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

    public boolean acM() {
        boolean z = true;
        if (this.bFC == null || this.bFC.bFP != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.SA != 3 || this.legoCard.checkLegal(this.SA) != 0) {
                    z = false;
                }
                return z;
            } else if (this.SA != 3 || TextUtils.isEmpty(this.bFw.trim()) || TextUtils.isEmpty(this.bFv.trim()) || this.bFC == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bFC.userName) || TextUtils.isEmpty(this.bFC.userName.trim())) && TextUtils.isEmpty(this.bFC.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean acN() {
        if (this.bFC == null || this.bFC.bFP != 1001) {
            if (this.bFC == null || this.bFC.bFP != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.SA == 1 && !((TextUtils.isEmpty(this.bFu) || TextUtils.isEmpty(this.bFu.trim())) && TextUtils.isEmpty(this.bFC.lego_card)) : this.SA == 1 && this.legoCard.checkLegal(this.SA) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bFI = app;
            this.bFJ = new AppData(app);
            this.bFs = app.id;
            this.bFt = app.name;
            this.SA = app.url_type.intValue();
            this.bFu = app.url;
            this.bFv = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bFw = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bFx = app.pos.intValue();
            this.aoU = app.first_name;
            this.bFy = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bFz = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bFA = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bFB = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bFC.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bFC.lego_card)) {
                try {
                    ICardInfo Ay = com.baidu.tieba.lego.card.b.Ay(this.bFC.lego_card);
                    if (Ay != null) {
                        ICardInfo viewItem = Ay.getViewItem(0, 1);
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
                        this.bFE = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bFE = 40;
                        } else {
                            this.bFE = 39;
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
        if (this.bFJ != null) {
            appData = this.bFJ;
        } else if (this.bFI == null) {
            return "";
        } else {
            appData = new AppData(this.bFI);
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
        builder.da_good_id = String.valueOf(this.bFC.bFK);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bFs;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bFz);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bFA;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bFK;
        public String bFL;
        public String bFM;
        public String bFN;
        public String bFO;
        public int bFP;
        public String bFQ;
        public String bFR;
        public String bFS;
        public List<String> bFT = new ArrayList(3);
        public VideoInfo bFU;
        public String bFV;
        public String bFW;
        public float bFX;
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
            List<String> mq;
            if (goodsInfo != null) {
                this.bFK = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bFL = com.baidu.tbadk.core.util.aq.i(goodsInfo.thread_title, 29, "...");
                this.bFN = goodsInfo.thread_pic;
                this.bFO = goodsInfo.pop_window_text;
                this.bFP = goodsInfo.goods_style.intValue();
                this.bFQ = goodsInfo.card_desc;
                this.bFR = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bFS = goodsInfo.button_url;
                this.bFM = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bFT.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.aa(this.bFT) && (mq = mq(goodsInfo.lego_card)) != null && this.bFT != null) {
                        this.bFT.addAll(mq);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bFU = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bFV = goodsInfo.tag_name_url;
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
                    this.bFW = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f3 = com.baidu.adp.lib.g.b.f(split2[0], 1);
                            int f4 = com.baidu.adp.lib.g.b.f(split2[1], 1);
                            if (f4 != 0) {
                                this.bFX = f3 / f4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> mq(String str) {
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
            return com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bFC.bFP == 1001 || this.bFC.bFP == -1001) {
            return bFb;
        }
        if (!com.baidu.tbadk.core.i.ace().aci() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bFb;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bFk;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bFl;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bFm;
                case 7:
                    return bFn;
                case 9:
                    return bFp;
                case 10:
                    return bFo;
            }
        }
        return null;
    }
}
