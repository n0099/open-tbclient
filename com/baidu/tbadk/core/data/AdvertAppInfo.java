package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
public class AdvertAppInfo extends bx {
    public static final BdUniqueId ewL = BdUniqueId.gen();
    public static final BdUniqueId ewM = BdUniqueId.gen();
    public static final BdUniqueId ewN = BdUniqueId.gen();
    public static final BdUniqueId ewO = BdUniqueId.gen();
    public static final BdUniqueId ewP = BdUniqueId.gen();
    public static final BdUniqueId ewQ = BdUniqueId.gen();
    public static final BdUniqueId ewR = BdUniqueId.gen();
    public static final BdUniqueId ewS = BdUniqueId.gen();
    public static final BdUniqueId ewT = BdUniqueId.gen();
    public static final BdUniqueId ewU = BdUniqueId.gen();
    public static final BdUniqueId ewV = BdUniqueId.gen();
    public static final BdUniqueId ewW = BdUniqueId.gen();
    public static final BdUniqueId ewX = BdUniqueId.gen();
    public static final BdUniqueId ewY = BdUniqueId.gen();
    public static final BdUniqueId ewZ = BdUniqueId.gen();
    public static AtomicBoolean exa = new AtomicBoolean(false);
    public int ZZ;
    public String abtest;
    public String adPosition;
    public c advertAppContext;
    public String apkUrl;
    public String cFz;
    public int cpid;
    public String deepUrl;
    public int exb;
    public String exc;
    public String exd;
    public String exe;
    public String exf;
    public int exg;
    public String exh;
    public int exi;
    public String exj;
    public long exk;
    public String exo;
    public String exp;
    public String exq;
    private App exr;
    public AppData exs;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a exl = new a();
    public boolean exm = false;
    public ILegoAdvert legoCard = null;
    private int exn = 32;

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
        return (this.exc != null ? this.exc.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.exc, this.exc) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bjt() {
        if (bx.eCE.get() && exa.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.exl == null || this.exl.exz != 1001) {
                if (this.exl == null || TextUtils.isEmpty(this.exl.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.exc) || TextUtils.isEmpty(this.exc.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.exl.isValid()) {
                    try {
                        if (new JSONObject(this.exl.lego_card).optInt(IntentConfig.CARD_TYPE) == 99) {
                            return 41;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return this.exn;
                } else if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.biL().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                } else {
                    if (this.legoCard.getCardType() == 12) {
                        return 12;
                    }
                    if (this.exl == null || !this.exl.isValid()) {
                        return 25;
                    }
                    if (this.legoCard.getGoodsStyle() == 11) {
                        return 12;
                    }
                    if (this.ZZ == 3) {
                        if (!bju()) {
                            return 26;
                        }
                    } else if (this.ZZ == 1) {
                        if (!bjv()) {
                            return 27;
                        }
                    } else {
                        return 21;
                    }
                    return (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) ? 37 : 0;
                }
            }
            return 0;
        }
        return 31;
    }

    public boolean bju() {
        boolean z = true;
        if (this.exl == null || this.exl.exz != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ZZ != 3 || this.legoCard.checkLegal(this.ZZ) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ZZ != 3 || TextUtils.isEmpty(this.exf.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.exl == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.exl.userName) || TextUtils.isEmpty(this.exl.userName.trim())) && TextUtils.isEmpty(this.exl.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bjv() {
        if (this.exl == null || this.exl.exz != 1001) {
            if (this.exl == null || this.exl.exz != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ZZ == 1 && !((TextUtils.isEmpty(this.exe) || TextUtils.isEmpty(this.exe.trim())) && TextUtils.isEmpty(this.exl.lego_card)) : this.ZZ == 1 && this.legoCard.checkLegal(this.ZZ) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.exr = app;
            this.exs = new AppData(app);
            this.exc = app.id;
            this.exd = app.name;
            this.ZZ = app.url_type.intValue();
            this.exe = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.exf = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.exg = app.pos.intValue();
            this.cFz = app.first_name;
            this.exh = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.exi = app.plan_id.intValue();
            this.userId = app.user_id;
            this.exj = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.exk = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.exl.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.exl.lego_card)) {
                try {
                    ICardInfo Ni = com.baidu.tieba.lego.card.b.Ni(this.exl.lego_card);
                    if (Ni != null) {
                        ICardInfo viewItem = Ni.getViewItem(0, 1);
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
                        this.exn = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.exn = 40;
                        } else {
                            this.exn = 39;
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
        if (this.exs != null) {
            appData = this.exs;
        } else if (this.exr == null) {
            return "";
        } else {
            appData = new AppData(this.exr);
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
        builder.da_good_id = String.valueOf(this.exl.exu);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.exc;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.exi);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.exj;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public String exA;
        public String exB;
        public String exC;
        public List<String> exD = new ArrayList(3);
        public VideoInfo exE;
        public String exF;
        public String exG;
        public float exH;
        public int exu;
        public String exv;
        public String exw;
        public String exx;
        public String exy;
        public int exz;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> Ai;
            if (goodsInfo != null) {
                this.exu = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.exv = com.baidu.tbadk.core.util.au.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.exx = goodsInfo.thread_pic;
                this.exy = goodsInfo.pop_window_text;
                this.exz = goodsInfo.goods_style.intValue();
                this.exA = goodsInfo.card_desc;
                this.exB = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.exC = goodsInfo.button_url;
                this.exw = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.exD.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.exD) && (Ai = Ai(goodsInfo.lego_card)) != null && this.exD != null) {
                        this.exD.addAll(Ai);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.exE = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.exF = goodsInfo.tag_name_url;
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
                    this.exG = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.exH = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> Ai(String str) {
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

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.exl.exz == 1001 || this.exl.exz == -1001) {
            return ewL;
        }
        if (!com.baidu.tbadk.core.k.biL().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return ewL;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = ewU;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return ewV;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return ewW;
                case 7:
                case 14:
                    return ewX;
                case 12:
                    return ewZ;
                case 13:
                    return ewY;
            }
        }
        return null;
    }

    public boolean bjw() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bjx() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
