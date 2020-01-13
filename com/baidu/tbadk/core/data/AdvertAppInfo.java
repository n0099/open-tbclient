package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
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
public class AdvertAppInfo extends bj {
    public static final BdUniqueId cIB = BdUniqueId.gen();
    public static final BdUniqueId cIC = BdUniqueId.gen();
    public static final BdUniqueId cID = BdUniqueId.gen();
    public static final BdUniqueId cIE = BdUniqueId.gen();
    public static final BdUniqueId cIF = BdUniqueId.gen();
    public static final BdUniqueId cIG = BdUniqueId.gen();
    public static final BdUniqueId cIH = BdUniqueId.gen();
    public static final BdUniqueId cII = BdUniqueId.gen();
    public static final BdUniqueId cIJ = BdUniqueId.gen();
    public static final BdUniqueId cIK = BdUniqueId.gen();
    public static final BdUniqueId cIL = BdUniqueId.gen();
    public static final BdUniqueId cIM = BdUniqueId.gen();
    public static final BdUniqueId cIN = BdUniqueId.gen();
    public static final BdUniqueId cIO = BdUniqueId.gen();
    public static final BdUniqueId cIP = BdUniqueId.gen();
    public static AtomicBoolean cIQ = new AtomicBoolean(false);
    public int Eg;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String bhs;
    public int cIR;
    public String cIS;
    public String cIT;
    public String cIU;
    public String cIV;
    public int cIW;
    public String cIX;
    public int cIY;
    public String cIZ;
    public long cJa;
    public String cJe;
    public String cJf;
    public String cJg;
    private App cJh;
    public AppData cJi;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a cJb = new a();
    public boolean cJc = false;
    public ILegoAdvert legoCard = null;
    private int cJd = 32;

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
        return (this.cIS != null ? this.cIS.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.cIS, this.cIS) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int axZ() {
        if (bj.cNK.get() && cIQ.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.cJb == null || this.cJb.cJo != 1001) {
                if (this.cJb == null || TextUtils.isEmpty(this.cJb.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.cIS) || TextUtils.isEmpty(this.cIS.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.cJb.isValid()) {
                    return this.cJd;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.axy().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.cJb == null || !this.cJb.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Eg == 3) {
                    if (!aya()) {
                        return 26;
                    }
                } else if (this.Eg == 1) {
                    if (!ayb()) {
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

    public boolean aya() {
        boolean z = true;
        if (this.cJb == null || this.cJb.cJo != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Eg != 3 || this.legoCard.checkLegal(this.Eg) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Eg != 3 || TextUtils.isEmpty(this.cIV.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.cJb == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.cJb.userName) || TextUtils.isEmpty(this.cJb.userName.trim())) && TextUtils.isEmpty(this.cJb.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean ayb() {
        if (this.cJb == null || this.cJb.cJo != 1001) {
            if (this.cJb == null || this.cJb.cJo != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Eg == 1 && !((TextUtils.isEmpty(this.cIU) || TextUtils.isEmpty(this.cIU.trim())) && TextUtils.isEmpty(this.cJb.lego_card)) : this.Eg == 1 && this.legoCard.checkLegal(this.Eg) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.cJh = app;
            this.cJi = new AppData(app);
            this.cIS = app.id;
            this.cIT = app.name;
            this.Eg = app.url_type.intValue();
            this.cIU = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.cIV = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.cIW = app.pos.intValue();
            this.bhs = app.first_name;
            this.cIX = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.cIY = app.plan_id.intValue();
            this.userId = app.user_id;
            this.cIZ = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.cJa = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.cJb.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.cJb.lego_card)) {
                try {
                    ICardInfo DJ = com.baidu.tieba.lego.card.b.DJ(this.cJb.lego_card);
                    if (DJ != null) {
                        ICardInfo viewItem = DJ.getViewItem(0, 1);
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
                        this.cJd = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.cJd = 40;
                        } else {
                            this.cJd = 39;
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
        if (this.cJi != null) {
            appData = this.cJi;
        } else if (this.cJh == null) {
            return "";
        } else {
            appData = new AppData(this.cJh);
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
        builder.da_fid = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(str, 0));
        builder.da_good_id = String.valueOf(this.cJb.cJj);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.cIS;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.cIY);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.cIZ;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int cJj;
        public String cJk;
        public String cJl;
        public String cJm;
        public String cJn;
        public int cJo;
        public String cJp;
        public String cJq;
        public String cJr;
        public List<String> cJs = new ArrayList(3);
        public VideoInfo cJt;
        public String cJu;
        public String cJv;
        public float cJw;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> se;
            if (goodsInfo != null) {
                this.cJj = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.cJk = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.cJm = goodsInfo.thread_pic;
                this.cJn = goodsInfo.pop_window_text;
                this.cJo = goodsInfo.goods_style.intValue();
                this.cJp = goodsInfo.card_desc;
                this.cJq = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.cJr = goodsInfo.button_url;
                this.cJl = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.cJs.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.cJs) && (se = se(goodsInfo.lego_card)) != null && this.cJs != null) {
                        this.cJs.addAll(se);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.cJt = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.cJu = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                            int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                            if (i2 != 0) {
                                this.tagRatio = i / i2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.cJv = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.cJw = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> se(String str) {
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
            return SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cJb.cJo == 1001 || this.cJb.cJo == -1001) {
            return cIB;
        }
        if (!com.baidu.tbadk.core.i.axy().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return cIB;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = cIK;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return cIL;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return cIM;
                case 7:
                    return cIN;
                case 9:
                    return cIP;
                case 10:
                    return cIO;
            }
        }
        return null;
    }
}
