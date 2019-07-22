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
    public static final BdUniqueId bEC = BdUniqueId.gen();
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
    public static AtomicBoolean bER = new AtomicBoolean(false);
    public int SB;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String aow;
    public int bES;
    public String bET;
    public String bEU;
    public String bEV;
    public String bEW;
    public String bEX;
    public int bEY;
    public String bEZ;
    public int bFa;
    public String bFb;
    public long bFc;
    public String bFg;
    public String bFh;
    public String bFi;
    private App bFj;
    public AppData bFk;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a bFd = new a();
    public boolean bFe = false;
    public ILegoAdvert legoCard = null;
    private int bFf = 32;

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
        return (this.bET != null ? this.bET.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.bET, this.bET) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int acG() {
        if (bg.bJJ.get() && bER.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.bFd == null || this.bFd.bFq != 1001) {
                if (this.bFd == null || TextUtils.isEmpty(this.bFd.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.bET) || TextUtils.isEmpty(this.bET.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.bFd.isValid()) {
                    return this.bFf;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.aca().ace() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.bFd == null || !this.bFd.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.SB == 3) {
                    if (!acH()) {
                        return 26;
                    }
                } else if (this.SB == 1) {
                    if (!acI()) {
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

    public boolean acH() {
        boolean z = true;
        if (this.bFd == null || this.bFd.bFq != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.SB != 3 || this.legoCard.checkLegal(this.SB) != 0) {
                    z = false;
                }
                return z;
            } else if (this.SB != 3 || TextUtils.isEmpty(this.bEX.trim()) || TextUtils.isEmpty(this.bEW.trim()) || this.bFd == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.bFd.userName) || TextUtils.isEmpty(this.bFd.userName.trim())) && TextUtils.isEmpty(this.bFd.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean acI() {
        if (this.bFd == null || this.bFd.bFq != 1001) {
            if (this.bFd == null || this.bFd.bFq != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.SB == 1 && !((TextUtils.isEmpty(this.bEV) || TextUtils.isEmpty(this.bEV.trim())) && TextUtils.isEmpty(this.bFd.lego_card)) : this.SB == 1 && this.legoCard.checkLegal(this.SB) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.bFj = app;
            this.bFk = new AppData(app);
            this.bET = app.id;
            this.bEU = app.name;
            this.SB = app.url_type.intValue();
            this.bEV = app.url;
            this.bEW = app.apk_url;
            this.deepUrl = app.deep_url;
            this.bEX = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.bEY = app.pos.intValue();
            this.aow = app.first_name;
            this.bEZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.bFa = app.plan_id.intValue();
            this.userId = app.user_id;
            this.bFb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.bFc = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.bFd.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hS().az("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.bFd.lego_card)) {
                try {
                    ICardInfo zY = com.baidu.tieba.lego.card.b.zY(this.bFd.lego_card);
                    if (zY != null) {
                        ICardInfo viewItem = zY.getViewItem(0, 1);
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
                        this.bFf = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.bFf = 40;
                        } else {
                            this.bFf = 39;
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
        if (this.bFk != null) {
            appData = this.bFk;
        } else if (this.bFj == null) {
            return "";
        } else {
            appData = new AppData(this.bFj);
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
        builder.da_good_id = String.valueOf(this.bFd.bFl);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.bET;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.bFa);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.bFb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int bFl;
        public String bFm;
        public String bFn;
        public String bFo;
        public String bFp;
        public int bFq;
        public String bFr;
        public String bFs;
        public String bFt;
        public List<String> bFu = new ArrayList(3);
        public VideoInfo bFv;
        public String bFw;
        public String bFx;
        public float bFy;
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
                this.bFl = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.bFm = com.baidu.tbadk.core.util.aq.i(goodsInfo.thread_title, 29, "...");
                this.bFo = goodsInfo.thread_pic;
                this.bFp = goodsInfo.pop_window_text;
                this.bFq = goodsInfo.goods_style.intValue();
                this.bFr = goodsInfo.card_desc;
                this.bFs = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.bFt = goodsInfo.button_url;
                this.bFn = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.bFu.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.aa(this.bFu) && (mo = mo(goodsInfo.lego_card)) != null && this.bFu != null) {
                        this.bFu.addAll(mo);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.bFv = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.bFw = goodsInfo.tag_name_url;
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
                    this.bFx = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int f3 = com.baidu.adp.lib.g.b.f(split2[0], 1);
                            int f4 = com.baidu.adp.lib.g.b.f(split2[1], 1);
                            if (f4 != 0) {
                                this.bFy = f3 / f4;
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

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.bFd.bFq == 1001 || this.bFd.bFq == -1001) {
            return bEC;
        }
        if (!com.baidu.tbadk.core.i.aca().ace() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return bEC;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = bEL;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return bEM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return bEN;
                case 7:
                    return bEO;
                case 9:
                    return bEQ;
                case 10:
                    return bEP;
            }
        }
        return null;
    }
}
