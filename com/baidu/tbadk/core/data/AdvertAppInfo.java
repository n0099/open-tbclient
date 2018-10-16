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
    public static final BdUniqueId akK = BdUniqueId.gen();
    public static final BdUniqueId akL = BdUniqueId.gen();
    public static final BdUniqueId akM = BdUniqueId.gen();
    public static final BdUniqueId akN = BdUniqueId.gen();
    public static final BdUniqueId akO = BdUniqueId.gen();
    public static final BdUniqueId akP = BdUniqueId.gen();
    public static final BdUniqueId akQ = BdUniqueId.gen();
    public static final BdUniqueId akR = BdUniqueId.gen();
    public static final BdUniqueId akS = BdUniqueId.gen();
    public static final BdUniqueId akT = BdUniqueId.gen();
    public static final BdUniqueId akU = BdUniqueId.gen();
    public static final BdUniqueId akV = BdUniqueId.gen();
    public static final BdUniqueId akW = BdUniqueId.gen();
    public static final BdUniqueId akX = BdUniqueId.gen();
    public static final BdUniqueId akY = BdUniqueId.gen();
    public static AtomicBoolean akZ = new AtomicBoolean(false);
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int ala;
    public String alb;
    public String alc;
    public int ald;
    public String ale;
    public String alf;
    public String alg;
    public int alh;
    public String ali;
    public int alj;
    public String alk;
    public long alm;
    public String alq;
    public String alr;
    public String als;
    private App alt;
    public AppData alu;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String firstName;
    public String page;
    public String price;
    public String userId;
    public a aln = new a();
    public boolean alo = false;
    public ILegoAdvert legoCard = null;
    private int alp = 32;

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
        return (this.alb != null ? this.alb.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.alb, this.alb) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int wQ() {
        if (bb.ape.get() && akZ.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iR().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aln == null || this.aln.alA != 1001) {
                if (this.aln == null || TextUtils.isEmpty(this.aln.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.alb) || TextUtils.isEmpty(this.alb.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aln.isValid()) {
                    return this.alp;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.ws().ww() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aln == null || !this.aln.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.ald);
                }
                if (this.ald == 3) {
                    if (!wR()) {
                        return 26;
                    }
                } else if (this.ald == 1) {
                    if (!wS()) {
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

    public boolean wR() {
        boolean z = true;
        if (this.aln == null || this.aln.alA != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ald != 3 || this.legoCard.checkLegal(this.ald) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ald != 3 || TextUtils.isEmpty(this.alg.trim()) || TextUtils.isEmpty(this.alf.trim()) || this.aln == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aln.userName) || TextUtils.isEmpty(this.aln.userName.trim())) && TextUtils.isEmpty(this.aln.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean wS() {
        if (this.aln == null || this.aln.alA != 1001) {
            if (this.aln == null || this.aln.alA != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ald == 1 && !((TextUtils.isEmpty(this.ale) || TextUtils.isEmpty(this.ale.trim())) && TextUtils.isEmpty(this.aln.lego_card)) : this.ald == 1 && this.legoCard.checkLegal(this.ald) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.alt = app;
            this.alu = new AppData(app);
            this.alb = app.id;
            this.alc = app.name;
            this.ald = app.url_type.intValue();
            this.ale = app.url;
            this.alf = app.apk_url;
            this.deepUrl = app.deep_url;
            this.alg = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.alh = app.pos.intValue();
            this.firstName = app.first_name;
            this.ali = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.alj = app.plan_id.intValue();
            this.userId = app.user_id;
            this.alk = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.alm = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aln.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iR().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aln.lego_card)) {
                try {
                    ICardInfo qx = com.baidu.tieba.lego.card.b.qx(this.aln.lego_card);
                    if (qx != null) {
                        ICardInfo viewItem = qx.getViewItem(0, 1);
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
                        this.alp = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.alp = 40;
                        } else {
                            this.alp = 39;
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
        if (this.alu != null) {
            appData = this.alu;
        } else if (this.alt == null) {
            return "";
        } else {
            appData = new AppData(this.alt);
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
        builder.da_good_id = String.valueOf(this.aln.alv);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.alb;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.alj);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.alk;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int alA;
        public String alB;
        public String alC;
        public String alD;
        public List<String> alE = new ArrayList(3);
        public VideoInfo alF;
        public String alG;
        public String alH;
        public float alI;
        public int alv;
        public String alw;
        public String alx;
        public String aly;
        public String alz;
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
                this.alv = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.alw = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.aly = goodsInfo.thread_pic;
                this.alz = goodsInfo.pop_window_text;
                this.alA = goodsInfo.goods_style.intValue();
                this.alB = goodsInfo.card_desc;
                this.alC = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.alD = goodsInfo.button_url;
                this.alx = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.alE.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.J(this.alE) && (dN = dN(goodsInfo.lego_card)) != null && this.alE != null) {
                        this.alE.addAll(dN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.alF = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.alG = goodsInfo.tag_name_url;
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
                    this.alH = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.alI = l3 / l4;
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
            return com.baidu.adp.lib.b.d.iR().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.aln.alA == 1001 || this.aln.alA == -1001) {
            return akK;
        }
        if (!com.baidu.tbadk.core.i.ws().ww() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return akK;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = akT;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return akU;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return akV;
                case 7:
                    return akW;
                case 9:
                    return akY;
                case 10:
                    return akX;
            }
        }
        return null;
    }
}
