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
    public static final BdUniqueId apQ = BdUniqueId.gen();
    public static AtomicBoolean apR = new AtomicBoolean(false);
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int apS;
    public String apT;
    public String apU;
    public int apV;
    public String apW;
    public String apX;
    public String apY;
    public int apZ;
    public String aqa;
    public int aqb;
    public String aqc;
    public long aqd;
    public String aqh;
    public String aqi;
    public String aqj;
    private App aqk;
    public AppData aql;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String firstName;
    public String page;
    public String price;
    public String userId;
    public a aqe = new a();
    public boolean aqf = false;
    public ILegoAdvert legoCard = null;
    private int aqg = 32;

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
        return (this.apT != null ? this.apT.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.apT, this.apT) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int yp() {
        if (bb.atV.get() && apR.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aqe == null || this.aqe.aqr != 1001) {
                if (this.aqe == null || TextUtils.isEmpty(this.aqe.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.apT) || TextUtils.isEmpty(this.apT.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aqe.isValid()) {
                    return this.aqg;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.xR().xV() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aqe == null || !this.aqe.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.apV);
                }
                if (this.apV == 3) {
                    if (!yq()) {
                        return 26;
                    }
                } else if (this.apV == 1) {
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
        if (this.aqe == null || this.aqe.aqr != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.apV != 3 || this.legoCard.checkLegal(this.apV) != 0) {
                    z = false;
                }
                return z;
            } else if (this.apV != 3 || TextUtils.isEmpty(this.apY.trim()) || TextUtils.isEmpty(this.apX.trim()) || this.aqe == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aqe.userName) || TextUtils.isEmpty(this.aqe.userName.trim())) && TextUtils.isEmpty(this.aqe.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean yr() {
        if (this.aqe == null || this.aqe.aqr != 1001) {
            if (this.aqe == null || this.aqe.aqr != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.apV == 1 && !((TextUtils.isEmpty(this.apW) || TextUtils.isEmpty(this.apW.trim())) && TextUtils.isEmpty(this.aqe.lego_card)) : this.apV == 1 && this.legoCard.checkLegal(this.apV) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.aqk = app;
            this.aql = new AppData(app);
            this.apT = app.id;
            this.apU = app.name;
            this.apV = app.url_type.intValue();
            this.apW = app.url;
            this.apX = app.apk_url;
            this.deepUrl = app.deep_url;
            this.apY = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.apZ = app.pos.intValue();
            this.firstName = app.first_name;
            this.aqa = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aqb = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aqc = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.aqd = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aqe.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aqe.lego_card)) {
                try {
                    ICardInfo rt = com.baidu.tieba.lego.card.b.rt(this.aqe.lego_card);
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
                        this.aqg = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.aqg = 40;
                        } else {
                            this.aqg = 39;
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
        if (this.aql != null) {
            appData = this.aql;
        } else if (this.aqk == null) {
            return "";
        } else {
            appData = new AppData(this.aqk);
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
        builder.da_good_id = String.valueOf(this.aqe.aqm);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.apT;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aqb);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aqc;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int aqm;
        public String aqn;
        public String aqo;
        public String aqp;
        public String aqq;
        public int aqr;
        public String aqs;
        public String aqt;
        public String aqu;
        public List<String> aqv = new ArrayList(3);
        public VideoInfo aqw;
        public String aqx;
        public String aqy;
        public float aqz;
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
                this.aqm = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aqn = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.aqp = goodsInfo.thread_pic;
                this.aqq = goodsInfo.pop_window_text;
                this.aqr = goodsInfo.goods_style.intValue();
                this.aqs = goodsInfo.card_desc;
                this.aqt = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aqu = goodsInfo.button_url;
                this.aqo = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aqv.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.I(this.aqv) && (eo = eo(goodsInfo.lego_card)) != null && this.aqv != null) {
                        this.aqv.addAll(eo);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aqw = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aqx = goodsInfo.tag_name_url;
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
                    this.aqy = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.aqz = l3 / l4;
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
        if (this.aqe.aqr == 1001 || this.aqe.aqr == -1001) {
            return apC;
        }
        if (!com.baidu.tbadk.core.i.xR().xV() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return apC;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = apL;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return apM;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return apN;
                case 7:
                    return apO;
                case 9:
                    return apQ;
                case 10:
                    return apP;
            }
        }
        return null;
    }
}
