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
    public String adPosition;
    public b advertAppContext;
    public int alO;
    public String alP;
    public String alQ;
    public int alR;
    public String alS;
    public String alT;
    public String alU;
    public int alV;
    public String alW;
    public int alX;
    public String alY;
    public long alZ;
    public String amd;
    public String ame;
    public String amf;
    private App amg;
    public AppData amh;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String firstName;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId aly = BdUniqueId.gen();
    public static final BdUniqueId alz = BdUniqueId.gen();
    public static final BdUniqueId alA = BdUniqueId.gen();
    public static final BdUniqueId alB = BdUniqueId.gen();
    public static final BdUniqueId alC = BdUniqueId.gen();
    public static final BdUniqueId alD = BdUniqueId.gen();
    public static final BdUniqueId alE = BdUniqueId.gen();
    public static final BdUniqueId alF = BdUniqueId.gen();
    public static final BdUniqueId alG = BdUniqueId.gen();
    public static final BdUniqueId alH = BdUniqueId.gen();
    public static final BdUniqueId alI = BdUniqueId.gen();
    public static final BdUniqueId alJ = BdUniqueId.gen();
    public static final BdUniqueId alK = BdUniqueId.gen();
    public static final BdUniqueId alL = BdUniqueId.gen();
    public static final BdUniqueId alM = BdUniqueId.gen();
    public static AtomicBoolean alN = new AtomicBoolean(false);
    public a ama = new a();
    public boolean amb = false;
    public ILegoAdvert legoCard = null;
    private int amc = 32;

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
        return (this.alP != null ? this.alP.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.alP, this.alP) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int wY() {
        if (bb.apS.get() && alN.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.ama == null || this.ama.amn != 1001) {
                if (this.ama == null || TextUtils.isEmpty(this.ama.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.alP) || TextUtils.isEmpty(this.alP.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.ama.isValid()) {
                    return this.amc;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.wA().wE() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.ama == null || !this.ama.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.alR);
                }
                if (this.alR == 3) {
                    if (!wZ()) {
                        return 26;
                    }
                } else if (this.alR == 1) {
                    if (!xa()) {
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

    public boolean wZ() {
        boolean z = true;
        if (this.ama == null || this.ama.amn != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.alR != 3 || this.legoCard.checkLegal(this.alR) != 0) {
                    z = false;
                }
                return z;
            } else if (this.alR != 3 || TextUtils.isEmpty(this.alU.trim()) || TextUtils.isEmpty(this.alT.trim()) || this.ama == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.ama.userName) || TextUtils.isEmpty(this.ama.userName.trim())) && TextUtils.isEmpty(this.ama.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean xa() {
        if (this.ama == null || this.ama.amn != 1001) {
            if (this.ama == null || this.ama.amn != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.alR == 1 && !((TextUtils.isEmpty(this.alS) || TextUtils.isEmpty(this.alS.trim())) && TextUtils.isEmpty(this.ama.lego_card)) : this.alR == 1 && this.legoCard.checkLegal(this.alR) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.amg = app;
            this.amh = new AppData(app);
            this.alP = app.id;
            this.alQ = app.name;
            this.alR = app.url_type.intValue();
            this.alS = app.url;
            this.alT = app.apk_url;
            this.deepUrl = app.deep_url;
            this.alU = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.alV = app.pos.intValue();
            this.firstName = app.first_name;
            this.alW = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.alX = app.plan_id.intValue();
            this.userId = app.user_id;
            this.alY = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.alZ = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.ama.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.ama.lego_card)) {
                try {
                    ICardInfo qy = com.baidu.tieba.lego.card.b.qy(this.ama.lego_card);
                    if (qy != null) {
                        ICardInfo viewItem = qy.getViewItem(0, 1);
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
                        this.amc = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.amc = 40;
                        } else {
                            this.amc = 39;
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
        if (this.amh != null) {
            appData = this.amh;
        } else if (this.amg == null) {
            return "";
        } else {
            appData = new AppData(this.amg);
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
        builder.da_good_id = String.valueOf(this.ama.ami);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.alP;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.alX);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.alY;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int ami;
        public String amj;
        public String amk;
        public String aml;
        public String amm;
        public int amn;
        public String amo;
        public String amp;
        public String amq;
        public List<String> amr = new ArrayList(3);
        public VideoInfo ams;
        public String amt;
        public String amu;
        public float amv;
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
            List<String> dN;
            if (goodsInfo != null) {
                this.ami = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.amj = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.aml = goodsInfo.thread_pic;
                this.amm = goodsInfo.pop_window_text;
                this.amn = goodsInfo.goods_style.intValue();
                this.amo = goodsInfo.card_desc;
                this.amp = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.amq = goodsInfo.button_url;
                this.amk = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.amr.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.I(this.amr) && (dN = dN(goodsInfo.lego_card)) != null && this.amr != null) {
                        this.amr.addAll(dN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.ams = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.amt = goodsInfo.tag_name_url;
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
                    this.amu = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.amv = l3 / l4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public List<String> dN(String str) {
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
        if (this.ama.amn == 1001 || this.ama.amn == -1001) {
            return aly;
        }
        if (!com.baidu.tbadk.core.i.wA().wE() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aly;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = alH;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return alI;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return alJ;
                case 7:
                    return alK;
                case 9:
                    return alM;
                case 10:
                    return alL;
            }
        }
        return null;
    }
}
