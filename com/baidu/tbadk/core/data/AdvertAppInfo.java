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
public class AdvertAppInfo extends bu {
    public int YN;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String bXR;
    public int cpid;
    public int dGK;
    public String dGL;
    public String dGM;
    public String dGN;
    public String dGO;
    public int dGP;
    public String dGQ;
    public int dGR;
    public String dGS;
    public long dGT;
    public String dGX;
    public String dGY;
    public String dGZ;
    private App dHa;
    public AppData dHb;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId dGu = BdUniqueId.gen();
    public static final BdUniqueId dGv = BdUniqueId.gen();
    public static final BdUniqueId dGw = BdUniqueId.gen();
    public static final BdUniqueId dGx = BdUniqueId.gen();
    public static final BdUniqueId dGy = BdUniqueId.gen();
    public static final BdUniqueId dGz = BdUniqueId.gen();
    public static final BdUniqueId dGA = BdUniqueId.gen();
    public static final BdUniqueId dGB = BdUniqueId.gen();
    public static final BdUniqueId dGC = BdUniqueId.gen();
    public static final BdUniqueId dGD = BdUniqueId.gen();
    public static final BdUniqueId dGE = BdUniqueId.gen();
    public static final BdUniqueId dGF = BdUniqueId.gen();
    public static final BdUniqueId dGG = BdUniqueId.gen();
    public static final BdUniqueId dGH = BdUniqueId.gen();
    public static final BdUniqueId dGI = BdUniqueId.gen();
    public static AtomicBoolean dGJ = new AtomicBoolean(false);
    public a dGU = new a();
    public boolean dGV = false;
    public ILegoAdvert legoCard = null;
    private int dGW = 32;

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
        return (this.dGL != null ? this.dGL.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.dGL, this.dGL) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int aQi() {
        if (bu.dLW.get() && dGJ.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.dGU == null || this.dGU.dHh != 1001) {
                if (this.dGU == null || TextUtils.isEmpty(this.dGU.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.dGL) || TextUtils.isEmpty(this.dGL.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.dGU.isValid()) {
                    return this.dGW;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.aPA().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.dGU == null || !this.dGU.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.YN == 3) {
                    if (!aQj()) {
                        return 26;
                    }
                } else if (this.YN == 1) {
                    if (!aQk()) {
                        return 27;
                    }
                } else {
                    return 21;
                }
                return (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) ? 37 : 0;
            }
            return 0;
        }
        return 31;
    }

    public boolean aQj() {
        boolean z = true;
        if (this.dGU == null || this.dGU.dHh != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.YN != 3 || this.legoCard.checkLegal(this.YN) != 0) {
                    z = false;
                }
                return z;
            } else if (this.YN != 3 || TextUtils.isEmpty(this.dGO.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.dGU == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.dGU.userName) || TextUtils.isEmpty(this.dGU.userName.trim())) && TextUtils.isEmpty(this.dGU.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean aQk() {
        if (this.dGU == null || this.dGU.dHh != 1001) {
            if (this.dGU == null || this.dGU.dHh != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.YN == 1 && !((TextUtils.isEmpty(this.dGN) || TextUtils.isEmpty(this.dGN.trim())) && TextUtils.isEmpty(this.dGU.lego_card)) : this.YN == 1 && this.legoCard.checkLegal(this.YN) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.dHa = app;
            this.dHb = new AppData(app);
            this.dGL = app.id;
            this.dGM = app.name;
            this.YN = app.url_type.intValue();
            this.dGN = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.dGO = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.dGP = app.pos.intValue();
            this.bXR = app.first_name;
            this.dGQ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.dGR = app.plan_id.intValue();
            this.userId = app.user_id;
            this.dGS = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.dGT = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.dGU.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.dGU.lego_card)) {
                try {
                    ICardInfo HW = com.baidu.tieba.lego.card.b.HW(this.dGU.lego_card);
                    if (HW != null) {
                        ICardInfo viewItem = HW.getViewItem(0, 1);
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
                        this.dGW = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.dGW = 40;
                        } else {
                            this.dGW = 39;
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
        if (this.dHb != null) {
            appData = this.dHb;
        } else if (this.dHa == null) {
            return "";
        } else {
            appData = new AppData(this.dHa);
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
        builder.da_good_id = String.valueOf(this.dGU.dHc);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.dGL;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.dGR);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.dGS;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int dHc;
        public String dHd;
        public String dHe;
        public String dHf;
        public String dHg;
        public int dHh;
        public String dHi;
        public String dHj;
        public String dHk;
        public List<String> dHl = new ArrayList(3);
        public VideoInfo dHm;
        public String dHn;
        public String dHo;
        public float dHp;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> vD;
            if (goodsInfo != null) {
                this.dHc = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.dHd = com.baidu.tbadk.core.util.ar.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.dHf = goodsInfo.thread_pic;
                this.dHg = goodsInfo.pop_window_text;
                this.dHh = goodsInfo.goods_style.intValue();
                this.dHi = goodsInfo.card_desc;
                this.dHj = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.dHk = goodsInfo.button_url;
                this.dHe = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.dHl.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.w.isEmpty(this.dHl) && (vD = vD(goodsInfo.lego_card)) != null && this.dHl != null) {
                        this.dHl.addAll(vD);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.dHm = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.dHn = goodsInfo.tag_name_url;
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
                    this.dHo = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ar.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.dHp = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> vD(String str) {
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

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dGU.dHh == 1001 || this.dGU.dHh == -1001) {
            return dGu;
        }
        if (!com.baidu.tbadk.core.k.aPA().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return dGu;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = dGD;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return dGE;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return dGF;
                case 7:
                case 14:
                    return dGG;
                case 12:
                    return dGI;
                case 13:
                    return dGH;
            }
        }
        return null;
    }
}
