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
    public static final BdUniqueId apB = BdUniqueId.gen();
    public static final BdUniqueId apC = BdUniqueId.gen();
    public static final BdUniqueId apD = BdUniqueId.gen();
    public static final BdUniqueId apE = BdUniqueId.gen();
    public static final BdUniqueId apF = BdUniqueId.gen();
    public static final BdUniqueId apG = BdUniqueId.gen();
    public static final BdUniqueId apH = BdUniqueId.gen();
    public static final BdUniqueId apI = BdUniqueId.gen();
    public static final BdUniqueId apJ = BdUniqueId.gen();
    public static final BdUniqueId apK = BdUniqueId.gen();
    public static final BdUniqueId apL = BdUniqueId.gen();
    public static final BdUniqueId apM = BdUniqueId.gen();
    public static final BdUniqueId apN = BdUniqueId.gen();
    public static final BdUniqueId apO = BdUniqueId.gen();
    public static final BdUniqueId apP = BdUniqueId.gen();
    public static AtomicBoolean apQ = new AtomicBoolean(false);
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int apR;
    public String apS;
    public String apT;
    public int apU;
    public String apV;
    public String apW;
    public String apX;
    public int apY;
    public String apZ;
    public int aqa;
    public String aqb;
    public long aqc;
    public String aqg;
    public String aqh;
    public String aqi;
    private App aqj;
    public AppData aqk;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String firstName;
    public String page;
    public String price;
    public String userId;
    public a aqd = new a();
    public boolean aqe = false;
    public ILegoAdvert legoCard = null;
    private int aqf = 32;

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
        return (this.apS != null ? this.apS.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.apS, this.apS) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int yp() {
        if (bb.atU.get() && apQ.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aqd == null || this.aqd.aqq != 1001) {
                if (this.aqd == null || TextUtils.isEmpty(this.aqd.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.apS) || TextUtils.isEmpty(this.apS.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aqd.isValid()) {
                    return this.aqf;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.xR().xV() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aqd == null || !this.aqd.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.apU);
                }
                if (this.apU == 3) {
                    if (!yq()) {
                        return 26;
                    }
                } else if (this.apU == 1) {
                    if (!yr()) {
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

    public boolean yq() {
        boolean z = true;
        if (this.aqd == null || this.aqd.aqq != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.apU != 3 || this.legoCard.checkLegal(this.apU) != 0) {
                    z = false;
                }
                return z;
            } else if (this.apU != 3 || TextUtils.isEmpty(this.apX.trim()) || TextUtils.isEmpty(this.apW.trim()) || this.aqd == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aqd.userName) || TextUtils.isEmpty(this.aqd.userName.trim())) && TextUtils.isEmpty(this.aqd.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean yr() {
        if (this.aqd == null || this.aqd.aqq != 1001) {
            if (this.aqd == null || this.aqd.aqq != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.apU == 1 && !((TextUtils.isEmpty(this.apV) || TextUtils.isEmpty(this.apV.trim())) && TextUtils.isEmpty(this.aqd.lego_card)) : this.apU == 1 && this.legoCard.checkLegal(this.apU) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.aqj = app;
            this.aqk = new AppData(app);
            this.apS = app.id;
            this.apT = app.name;
            this.apU = app.url_type.intValue();
            this.apV = app.url;
            this.apW = app.apk_url;
            this.deepUrl = app.deep_url;
            this.apX = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.apY = app.pos.intValue();
            this.firstName = app.first_name;
            this.apZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aqa = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aqb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aqc = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aqd.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aqd.lego_card)) {
                try {
                    ICardInfo rt = com.baidu.tieba.lego.card.b.rt(this.aqd.lego_card);
                    if (rt != null) {
                        ICardInfo viewItem = rt.getViewItem(0, 1);
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
                        this.aqf = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.aqf = 40;
                        } else {
                            this.aqf = 39;
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
        if (this.aqk != null) {
            appData = this.aqk;
        } else if (this.aqj == null) {
            return "";
        } else {
            appData = new AppData(this.aqj);
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
        builder.da_good_id = String.valueOf(this.aqd.aql);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.apS;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aqa);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aqb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int aql;
        public String aqm;
        public String aqn;
        public String aqo;
        public String aqp;
        public int aqq;
        public String aqr;
        public String aqs;
        public String aqt;
        public List<String> aqu = new ArrayList(3);
        public VideoInfo aqv;
        public String aqw;
        public String aqx;
        public float aqy;
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
            List<String> eo;
            if (goodsInfo != null) {
                this.aql = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aqm = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.aqo = goodsInfo.thread_pic;
                this.aqp = goodsInfo.pop_window_text;
                this.aqq = goodsInfo.goods_style.intValue();
                this.aqr = goodsInfo.card_desc;
                this.aqs = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aqt = goodsInfo.button_url;
                this.aqn = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aqu.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.I(this.aqu) && (eo = eo(goodsInfo.lego_card)) != null && this.aqu != null) {
                        this.aqu.addAll(eo);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aqv = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aqw = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                            int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                            if (l2 != 0) {
                                this.tagRatio = l / l2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.aqx = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.aqy = l3 / l4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public List<String> eo(String str) {
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

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.aqd.aqq == 1001 || this.aqd.aqq == -1001) {
            return apB;
        }
        if (!com.baidu.tbadk.core.i.xR().xV() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return apB;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = apK;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return apL;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return apM;
                case 7:
                    return apN;
                case 9:
                    return apP;
                case 10:
                    return apO;
            }
        }
        return null;
    }
}
