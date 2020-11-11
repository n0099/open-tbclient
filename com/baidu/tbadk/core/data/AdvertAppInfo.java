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
public class AdvertAppInfo extends bw {
    public int ZU;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public String apkUrl;
    public String cHj;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public int eyN;
    public String eyO;
    public String eyP;
    public String eyQ;
    public String eyR;
    public int eyS;
    public String eyT;
    public int eyU;
    public String eyV;
    public long eyW;
    public String eza;
    public String ezb;
    public String ezc;
    private App ezd;
    public AppData eze;
    public String page;
    public String price;
    public String userId;
    public static final BdUniqueId eyx = BdUniqueId.gen();
    public static final BdUniqueId eyy = BdUniqueId.gen();
    public static final BdUniqueId eyz = BdUniqueId.gen();
    public static final BdUniqueId eyA = BdUniqueId.gen();
    public static final BdUniqueId eyB = BdUniqueId.gen();
    public static final BdUniqueId eyC = BdUniqueId.gen();
    public static final BdUniqueId eyD = BdUniqueId.gen();
    public static final BdUniqueId eyE = BdUniqueId.gen();
    public static final BdUniqueId eyF = BdUniqueId.gen();
    public static final BdUniqueId eyG = BdUniqueId.gen();
    public static final BdUniqueId eyH = BdUniqueId.gen();
    public static final BdUniqueId eyI = BdUniqueId.gen();
    public static final BdUniqueId eyJ = BdUniqueId.gen();
    public static final BdUniqueId eyK = BdUniqueId.gen();
    public static final BdUniqueId eyL = BdUniqueId.gen();
    public static AtomicBoolean eyM = new AtomicBoolean(false);
    public a eyX = new a();
    public boolean eyY = false;
    public ILegoAdvert legoCard = null;
    private int eyZ = 32;

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
        return (this.eyO != null ? this.eyO.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.eyO, this.eyO) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int bkr() {
        if (bw.eEm.get() && eyM.get()) {
            if (!TextUtils.equals("PB_BANNER", this.page) && StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            if (this.eyX == null || this.eyX.ezk != 1001) {
                if (this.eyX == null || TextUtils.isEmpty(this.eyX.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.eyO) || TextUtils.isEmpty(this.eyO.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.eyX.isValid()) {
                    return this.eyZ;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.k.bjH().isShowImages() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.eyX == null || !this.eyX.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return 12;
                }
                if (this.ZU == 3) {
                    if (!bks()) {
                        return 26;
                    }
                } else if (this.ZU == 1) {
                    if (!bkt()) {
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

    public boolean bks() {
        boolean z = true;
        if (this.eyX == null || this.eyX.ezk != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.ZU != 3 || this.legoCard.checkLegal(this.ZU) != 0) {
                    z = false;
                }
                return z;
            } else if (this.ZU != 3 || TextUtils.isEmpty(this.eyR.trim()) || TextUtils.isEmpty(this.apkUrl.trim()) || this.eyX == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.eyX.userName) || TextUtils.isEmpty(this.eyX.userName.trim())) && TextUtils.isEmpty(this.eyX.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean bkt() {
        if (this.eyX == null || this.eyX.ezk != 1001) {
            if (this.eyX == null || this.eyX.ezk != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.ZU == 1 && !((TextUtils.isEmpty(this.eyQ) || TextUtils.isEmpty(this.eyQ.trim())) && TextUtils.isEmpty(this.eyX.lego_card)) : this.ZU == 1 && this.legoCard.checkLegal(this.ZU) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.ezd = app;
            this.eze = new AppData(app);
            this.eyO = app.id;
            this.eyP = app.name;
            this.ZU = app.url_type.intValue();
            this.eyQ = app.url;
            this.apkUrl = app.apk_url;
            this.deepUrl = app.deep_url;
            this.eyR = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.eyS = app.pos.intValue();
            this.cHj = app.first_name;
            this.eyT = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.eyU = app.plan_id.intValue();
            this.userId = app.user_id;
            this.eyV = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.eyW = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.eyX.a(next);
                        break;
                    }
                }
            }
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.eyX.lego_card)) {
                try {
                    ICardInfo NK = com.baidu.tieba.lego.card.b.NK(this.eyX.lego_card);
                    if (NK != null) {
                        ICardInfo viewItem = NK.getViewItem(0, 1);
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
                        this.eyZ = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.eyZ = 40;
                        } else {
                            this.eyZ = 39;
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
        if (this.eze != null) {
            appData = this.eze;
        } else if (this.ezd == null) {
            return "";
        } else {
            appData = new AppData(this.ezd);
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
        builder.da_good_id = String.valueOf(this.eyX.ezf);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.eyO;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.eyU);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.eyV;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String buttonText;
        public int ezf;
        public String ezg;
        public String ezh;
        public String ezi;
        public String ezj;
        public int ezk;
        public String ezl;
        public String ezm;
        public String ezn;
        public List<String> ezo = new ArrayList(3);
        public VideoInfo ezp;
        public String ezq;
        public String ezr;
        public float ezs;
        public int height;
        public String lego_card;
        public boolean needResize;
        public String tagName;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            List<String> AN;
            if (goodsInfo != null) {
                this.ezf = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.ezg = com.baidu.tbadk.core.util.at.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
                this.ezi = goodsInfo.thread_pic;
                this.ezj = goodsInfo.pop_window_text;
                this.ezk = goodsInfo.goods_style.intValue();
                this.ezl = goodsInfo.card_desc;
                this.ezm = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.ezn = goodsInfo.button_url;
                this.ezh = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.ezo.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.y.isEmpty(this.ezo) && (AN = AN(goodsInfo.lego_card)) != null && this.ezo != null) {
                        this.ezo.addAll(AN);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.ezp = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.ezq = goodsInfo.tag_name_url;
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
                    this.ezr = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int i3 = com.baidu.adp.lib.f.b.toInt(split2[0], 1);
                            int i4 = com.baidu.adp.lib.f.b.toInt(split2[1], 1);
                            if (i4 != 0) {
                                this.ezs = i3 / i4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public static List<String> AN(String str) {
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

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eyX.ezk == 1001 || this.eyX.ezk == -1001) {
            return eyx;
        }
        if (!com.baidu.tbadk.core.k.bjH().isShowImages() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return eyx;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = eyG;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return eyH;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return eyI;
                case 7:
                case 14:
                    return eyJ;
                case 12:
                    return eyL;
                case 13:
                    return eyK;
            }
        }
        return null;
    }

    public boolean bku() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public boolean bkv() {
        if (this.legoCard == null) {
            return false;
        }
        int goodsStyle = this.legoCard.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }
}
