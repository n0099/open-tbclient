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
    public int Eb;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String bgD;
    public int cIF;
    public String cIG;
    public String cIH;
    public String cII;
    public String cIJ;
    public String cIK;
    public int cIL;
    public String cIM;
    public int cIN;
    public String cIO;
    public long cIP;
    public String cIT;
    public String cIU;
    public String cIV;
    private App cIW;
    public AppData cIX;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId cIp = BdUniqueId.gen();
    public static final BdUniqueId cIq = BdUniqueId.gen();
    public static final BdUniqueId cIr = BdUniqueId.gen();
    public static final BdUniqueId cIs = BdUniqueId.gen();
    public static final BdUniqueId cIt = BdUniqueId.gen();
    public static final BdUniqueId cIu = BdUniqueId.gen();
    public static final BdUniqueId cIv = BdUniqueId.gen();
    public static final BdUniqueId cIw = BdUniqueId.gen();
    public static final BdUniqueId cIx = BdUniqueId.gen();
    public static final BdUniqueId cIy = BdUniqueId.gen();
    public static final BdUniqueId cIz = BdUniqueId.gen();
    public static final BdUniqueId cIA = BdUniqueId.gen();
    public static final BdUniqueId cIB = BdUniqueId.gen();
    public static final BdUniqueId cIC = BdUniqueId.gen();
    public static final BdUniqueId cID = BdUniqueId.gen();
    public static AtomicBoolean cIE = new AtomicBoolean(false);
    public a cIQ = new a();
    public boolean cIR = false;
    public ILegoAdvert legoCard = null;
    private int cIS = 32;

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
        return (this.cIG != null ? this.cIG.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.cIG, this.cIG) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int axG() {
        if (bj.cNA.get() && cIE.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.cIQ == null || this.cIQ.cJd != 1001) {
                if (this.cIQ == null || TextUtils.isEmpty(this.cIQ.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.cIG) || TextUtils.isEmpty(this.cIG.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.cIQ.isValid()) {
                    return this.cIS;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.axf().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.cIQ == null || !this.cIQ.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.Eb == 3) {
                    if (!axH()) {
                        return 26;
                    }
                } else if (this.Eb == 1) {
                    if (!axI()) {
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

    public boolean axH() {
        boolean z = true;
        if (this.cIQ == null || this.cIQ.cJd != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Eb != 3 || this.legoCard.checkLegal(this.Eb) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Eb != 3 || TextUtils.isEmpty(this.cIK.trim()) || TextUtils.isEmpty(this.cIJ.trim()) || this.cIQ == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.cIQ.userName) || TextUtils.isEmpty(this.cIQ.userName.trim())) && TextUtils.isEmpty(this.cIQ.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean axI() {
        if (this.cIQ == null || this.cIQ.cJd != 1001) {
            if (this.cIQ == null || this.cIQ.cJd != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Eb == 1 && !((TextUtils.isEmpty(this.cII) || TextUtils.isEmpty(this.cII.trim())) && TextUtils.isEmpty(this.cIQ.lego_card)) : this.Eb == 1 && this.legoCard.checkLegal(this.Eb) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.cIW = app;
            this.cIX = new AppData(app);
            this.cIG = app.id;
            this.cIH = app.name;
            this.Eb = app.url_type.intValue();
            this.cII = app.url;
            this.cIJ = app.apk_url;
            this.deepUrl = app.deep_url;
            this.cIK = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.cIL = app.pos.intValue();
            this.bgD = app.first_name;
            this.cIM = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.cIN = app.plan_id.intValue();
            this.userId = app.user_id;
            this.cIO = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.cIP = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.cIQ.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.cIQ.lego_card)) {
                try {
                    ICardInfo Dz = com.baidu.tieba.lego.card.b.Dz(this.cIQ.lego_card);
                    if (Dz != null) {
                        ICardInfo viewItem = Dz.getViewItem(0, 1);
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
                        this.cIS = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.cIS = 40;
                        } else {
                            this.cIS = 39;
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
        if (this.cIX != null) {
            appData = this.cIX;
        } else if (this.cIW == null) {
            return "";
        } else {
            appData = new AppData(this.cIW);
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
        builder.da_good_id = String.valueOf(this.cIQ.cIY);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.cIG;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.cIN);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.cIO;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int cIY;
        public String cIZ;
        public String cJa;
        public String cJb;
        public String cJc;
        public int cJd;
        public String cJe;
        public String cJf;
        public String cJg;
        public List<String> cJh = new ArrayList(3);
        public VideoInfo cJi;
        public String cJj;
        public String cJk;
        public float cJl;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> sb;
            if (goodsInfo != null) {
                this.cIY = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.cIZ = com.baidu.tbadk.core.util.aq.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.cJb = goodsInfo.thread_pic;
                this.cJc = goodsInfo.pop_window_text;
                this.cJd = goodsInfo.goods_style.intValue();
                this.cJe = goodsInfo.card_desc;
                this.cJf = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.cJg = goodsInfo.button_url;
                this.cJa = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.cJh.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.isEmpty(this.cJh) && (sb = sb(goodsInfo.lego_card)) != null && this.cJh != null) {
                        this.cJh.addAll(sb);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.cJi = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.cJj = goodsInfo.tag_name_url;
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
                    this.cJk = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.cJl = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> sb(String str) {
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
        if (this.cIQ.cJd == 1001 || this.cIQ.cJd == -1001) {
            return cIp;
        }
        if (!com.baidu.tbadk.core.i.axf().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return cIp;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = cIy;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return cIz;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return cIA;
                case 7:
                    return cIB;
                case 9:
                    return cID;
                case 10:
                    return cIC;
            }
        }
        return null;
    }
}
