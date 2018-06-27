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
public class AdvertAppInfo extends bc {
    public static final BdUniqueId adJ = BdUniqueId.gen();
    public static final BdUniqueId adK = BdUniqueId.gen();
    public static final BdUniqueId adL = BdUniqueId.gen();
    public static final BdUniqueId adM = BdUniqueId.gen();
    public static final BdUniqueId adN = BdUniqueId.gen();
    public static final BdUniqueId adO = BdUniqueId.gen();
    public static final BdUniqueId adP = BdUniqueId.gen();
    public static final BdUniqueId adQ = BdUniqueId.gen();
    public static final BdUniqueId adR = BdUniqueId.gen();
    public static final BdUniqueId adS = BdUniqueId.gen();
    public static final BdUniqueId adT = BdUniqueId.gen();
    public static final BdUniqueId adU = BdUniqueId.gen();
    public static final BdUniqueId adV = BdUniqueId.gen();
    public static final BdUniqueId adW = BdUniqueId.gen();
    public static final BdUniqueId adX = BdUniqueId.gen();
    public static AtomicBoolean adY = new AtomicBoolean(false);
    public String abtest;
    public String adE;
    public String adPosition;
    public int adZ;
    public b advertAppContext;
    public String aea;
    public String aeb;
    public int aec;
    public String aed;
    public String aee;
    public String aef;
    public int aeg;
    public String aeh;
    public String aei;
    public int aej;
    public String aek;
    public long ael;
    public String aep;
    public String aeq;
    public String aer;
    private App aes;
    public AppData aet;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a aem = new a();
    public boolean aen = false;
    public ILegoAdvert legoCard = null;
    private int aeo = 32;

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

    public int tT() {
        if (bc.ain.get() && adY.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.aem == null || this.aem.aez != 1001) {
                if (this.aem == null || TextUtils.isEmpty(this.aem.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.aea) || TextUtils.isEmpty(this.aea.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.aem.isValid()) {
                    return this.aeo;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.tt().tz() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.aem == null || !this.aem.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aec);
                }
                if (this.aec == 3) {
                    if (!tU()) {
                        return 26;
                    }
                } else if (this.aec == 1) {
                    if (!tV()) {
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

    public boolean tU() {
        boolean z = true;
        if (this.aem == null || this.aem.aez != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aec != 3 || this.legoCard.checkLegal(this.aec) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aec != 3 || TextUtils.isEmpty(this.aef.trim()) || TextUtils.isEmpty(this.aee.trim()) || this.aem == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.aem.userName) || TextUtils.isEmpty(this.aem.userName.trim())) && TextUtils.isEmpty(this.aem.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean tV() {
        if (this.aem == null || this.aem.aez != 1001) {
            if (this.aem == null || this.aem.aez != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aec == 1 && !((TextUtils.isEmpty(this.aed) || TextUtils.isEmpty(this.aed.trim())) && TextUtils.isEmpty(this.aem.lego_card)) : this.aec == 1 && this.legoCard.checkLegal(this.aec) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.aes = app;
            this.aet = new AppData(app);
            this.aea = app.id;
            this.aeb = app.name;
            this.aec = app.url_type.intValue();
            this.aed = app.url;
            this.aee = app.apk_url;
            this.deepUrl = app.deep_url;
            this.aef = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.aeg = app.pos.intValue();
            this.aeh = app.first_name;
            this.aei = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.aej = app.plan_id.intValue();
            this.userId = app.user_id;
            this.aek = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.ael = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.aem.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.aem.lego_card)) {
                try {
                    ICardInfo pm = com.baidu.tieba.lego.card.b.pm(this.aem.lego_card);
                    if (pm != null) {
                        ICardInfo viewItem = pm.getViewItem(0, 1);
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
                        this.aeo = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.aeo = 40;
                        } else {
                            this.aeo = 39;
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
        if (this.aet != null) {
            appData = this.aet;
        } else if (this.aes == null) {
            return "";
        } else {
            appData = new AppData(this.aes);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.g.b.g(str, 0));
        builder.da_good_id = String.valueOf(this.aem.aeu);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.aea;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.aej);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.aek;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String adSource;
        public String aeA;
        public String aeB;
        public String aeC;
        public List<String> aeD = new ArrayList(3);
        public VideoInfo aeE;
        public String aeF;
        public String aeG;
        public float aeH;
        public AdCloseInfo aeI;
        public int aeu;
        public String aev;
        public String aew;
        public String aex;
        public String aey;
        public int aez;
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
            List<String> dh;
            if (goodsInfo != null) {
                this.aeu = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.aev = com.baidu.tbadk.core.util.ap.d(goodsInfo.thread_title, 29, "...");
                this.aex = goodsInfo.thread_pic;
                this.aey = goodsInfo.pop_window_text;
                this.aez = goodsInfo.goods_style.intValue();
                this.aeA = goodsInfo.card_desc;
                this.aeB = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.aeC = goodsInfo.button_url;
                this.aew = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.aeD.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.w.A(this.aeD) && (dh = dh(goodsInfo.lego_card)) != null && this.aeD != null) {
                        this.aeD.addAll(dh);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.aeE = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.aeF = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.aeG = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.aeH = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.aeI = goodsInfo.close_info;
                }
            }
        }

        public List<String> dh(String str) {
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
            return com.baidu.adp.lib.b.d.hv().aw("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bc, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.aem.aez == 1001 || this.aem.aez == -1001) {
            return adJ;
        }
        if (!com.baidu.tbadk.core.i.tt().tz() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return adJ;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = adS;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return adT;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return adU;
                case 7:
                    return adV;
                case 9:
                    return adX;
                case 10:
                    return adW;
            }
        }
        return null;
    }
}
