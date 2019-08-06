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
    public static final BdUniqueId bED = BdUniqueId.gen();
    public static final BdUniqueId bEE = BdUniqueId.gen();
    public static final BdUniqueId bEF = BdUniqueId.gen();
    public static final BdUniqueId bEG = BdUniqueId.gen();
    public static final BdUniqueId bEH = BdUniqueId.gen();
    public static final BdUniqueId bEI = BdUniqueId.gen();
    public static final BdUniqueId bEJ = BdUniqueId.gen();
    public static final BdUniqueId bEK = BdUniqueId.gen();
    public static final BdUniqueId bEL = BdUniqueId.gen();
    public static final BdUniqueId bEM = BdUniqueId.gen();
    public static final BdUniqueId bEN = BdUniqueId.gen();
    public static final BdUniqueId bEO = BdUniqueId.gen();
    public static final BdUniqueId bEP = BdUniqueId.gen();
    public static final BdUniqueId bEQ = BdUniqueId.gen();
    public static final BdUniqueId bER = BdUniqueId.gen();
    public static AtomicBoolean bES = new AtomicBoolean(false);
    public int SB;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String aow;
    public int bET;
    public String bEU;
    public String bEV;
    public String bEW;
    public String bEX;
    public String bEY;
    public int bEZ;
    public String bFa;
    public int bFb;
    public String bFc;
    public long bFd;
    public String bFh;
    public String bFi;
    public String bFj;
    private App bFk;
    public AppData bFl;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bFe = new a();
    public boolean bFf = false;
    public ILegoAdvert legoCard = null;
    private int bFg = 32;

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
        return (this.bEU != null ? this.bEU.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bEU, this.bEU) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int acH() {
        if (bh.bJO.get() && bES.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bFe == null || this.bFe.bFr != 1001) {
                if (this.bFe == null || TextUtils.isEmpty(this.bFe.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bEU) || TextUtils.isEmpty(this.bEU.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bFe.isValid()) {
                    return this.bFg;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.aca().ace() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bFe == null || !this.bFe.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.SB == 3) {
                    if (!acI()) {
                        return 26;
                    }
                } else if (this.SB == 1) {
                    if (!acJ()) {
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

    public boolean acI() {
        boolean z = true;
        if (this.bFe == null || this.bFe.bFr != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.SB != 3 || this.legoCard.checkLegal(this.SB) != 0) {
                    z = false;
                }
                return z;
            } else if (this.SB != 3 || TextUtils.isEmpty(this.bEY.trim()) || TextUtils.isEmpty(this.bEX.trim()) || this.bFe == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bFe.userName) || TextUtils.isEmpty(this.bFe.userName.trim())) && TextUtils.isEmpty(this.bFe.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean acJ() {
        if (this.bFe == null || this.bFe.bFr != 1001) {
            if (this.bFe == null || this.bFe.bFr != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.SB == 1 && !((TextUtils.isEmpty(this.bEW) || TextUtils.isEmpty(this.bEW.trim())) && TextUtils.isEmpty(this.bFe.lego_card)) : this.SB == 1 && this.legoCard.checkLegal(this.SB) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bFk = app;
            this.bFl = new AppData(app);
            this.bEU = app.id;
            this.bEV = app.name;
            this.SB = app.url_type.intValue();
            this.bEW = app.url;
            this.bEX = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bEY = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bEZ = app.pos.intValue();
            this.aow = app.first_name;
            this.bFa = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bFb = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bFc = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bFd = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bFe.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bFe.lego_card)) {
                try {
                    ICardInfo zZ = com.baidu.tieba.lego.card.b.zZ(this.bFe.lego_card);
                    if (zZ != null) {
                        ICardInfo viewItem = zZ.getViewItem(0, 1);
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
                        this.bFg = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bFg = 40;
                        } else {
                            this.bFg = 39;
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
        if (this.bFl != null) {
            appData = this.bFl;
        } else if (this.bFk == null) {
            return "";
        } else {
            appData = new AppData(this.bFk);
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
        builder.da_good_id = String.valueOf(this.bFe.bFm);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bEU;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bFb);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bFc;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bFm;
        public String bFn;
        public String bFo;
        public String bFp;
        public String bFq;
        public int bFr;
        public String bFs;
        public String bFt;
        public String bFu;
        public List<String> bFv = new ArrayList(3);
        public VideoInfo bFw;
        public String bFx;
        public String bFy;
        public float bFz;
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
            List<String> mo;
            if (goodsInfo != null) {
                this.bFm = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bFn = com.baidu.tbadk.core.util.aq.i(goodsInfo.thread_title, 29, "...");
                this.bFp = goodsInfo.thread_pic;
                this.bFq = goodsInfo.pop_window_text;
                this.bFr = goodsInfo.goods_style.intValue();
                this.bFs = goodsInfo.card_desc;
                this.bFt = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bFu = goodsInfo.button_url;
                this.bFo = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bFv.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.aa(this.bFv) && (mo = mo(goodsInfo.lego_card)) != null && this.bFv != null) {
                        this.bFv.addAll(mo);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bFw = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bFx = goodsInfo.tag_name_url;
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
                    this.bFy = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f3 = com.baidu.adp.lib.g.b.f(split2[0], 1);
                            int f4 = com.baidu.adp.lib.g.b.f(split2[1], 1);
                            if (f4 != 0) {
                                this.bFz = f3 / f4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> mo(String str) {
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
        if (this.bFe.bFr == 1001 || this.bFe.bFr == -1001) {
            return bED;
        }
        if (!com.baidu.tbadk.core.i.aca().ace() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bED;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bEM;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bEN;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bEO;
                case 7:
                    return bEP;
                case 9:
                    return bER;
                case 10:
                    return bEQ;
            }
        }
        return null;
    }
}
