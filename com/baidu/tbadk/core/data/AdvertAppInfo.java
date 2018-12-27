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
    public static final BdUniqueId aoY = BdUniqueId.gen();
    public static final BdUniqueId aoZ = BdUniqueId.gen();
    public static final BdUniqueId apa = BdUniqueId.gen();
    public static final BdUniqueId apb = BdUniqueId.gen();
    public static final BdUniqueId apc = BdUniqueId.gen();
    public static final BdUniqueId apd = BdUniqueId.gen();
    public static final BdUniqueId ape = BdUniqueId.gen();
    public static final BdUniqueId apf = BdUniqueId.gen();
    public static final BdUniqueId apg = BdUniqueId.gen();
    public static final BdUniqueId aph = BdUniqueId.gen();
    public static final BdUniqueId api = BdUniqueId.gen();
    public static final BdUniqueId apj = BdUniqueId.gen();
    public static final BdUniqueId apk = BdUniqueId.gen();
    public static final BdUniqueId apl = BdUniqueId.gen();
    public static final BdUniqueId apm = BdUniqueId.gen();
    public static AtomicBoolean apn = new AtomicBoolean(false);
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public long apA;
    public String apE;
    public String apF;
    public String apG;
    private App apH;
    public AppData apI;
    public int apo;
    public String apq;
    public String apr;
    public int aps;
    public String apt;
    public String apu;
    public String apv;
    public int apw;
    public String apx;
    public int apy;
    public String apz;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String firstName;
    public String page;
    public String price;
    public String userId;
    public a apB = new a();
    public boolean apC = false;
    public ILegoAdvert legoCard = null;
    private int apD = 32;

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
        return (this.apq != null ? this.apq.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.apq, this.apq) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int yc() {
        if (bb.ats.get() && apn.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.apB == null || this.apB.apO != 1001) {
                if (this.apB == null || TextUtils.isEmpty(this.apB.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.apq) || TextUtils.isEmpty(this.apq.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.apB.isValid()) {
                    return this.apD;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.xE().xI() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.apB == null || !this.apB.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.aps);
                }
                if (this.aps == 3) {
                    if (!yd()) {
                        return 26;
                    }
                } else if (this.aps == 1) {
                    if (!ye()) {
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

    public boolean yd() {
        boolean z = true;
        if (this.apB == null || this.apB.apO != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.aps != 3 || this.legoCard.checkLegal(this.aps) != 0) {
                    z = false;
                }
                return z;
            } else if (this.aps != 3 || TextUtils.isEmpty(this.apv.trim()) || TextUtils.isEmpty(this.apu.trim()) || this.apB == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.apB.userName) || TextUtils.isEmpty(this.apB.userName.trim())) && TextUtils.isEmpty(this.apB.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean ye() {
        if (this.apB == null || this.apB.apO != 1001) {
            if (this.apB == null || this.apB.apO != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.aps == 1 && !((TextUtils.isEmpty(this.apt) || TextUtils.isEmpty(this.apt.trim())) && TextUtils.isEmpty(this.apB.lego_card)) : this.aps == 1 && this.legoCard.checkLegal(this.aps) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.apH = app;
            this.apI = new AppData(app);
            this.apq = app.id;
            this.apr = app.name;
            this.aps = app.url_type.intValue();
            this.apt = app.url;
            this.apu = app.apk_url;
            this.deepUrl = app.deep_url;
            this.apv = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.apw = app.pos.intValue();
            this.firstName = app.first_name;
            this.apx = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.apy = app.plan_id.intValue();
            this.userId = app.user_id;
            this.apz = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.apA = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.apB.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iQ().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.apB.lego_card)) {
                try {
                    ICardInfo rd = com.baidu.tieba.lego.card.b.rd(this.apB.lego_card);
                    if (rd != null) {
                        ICardInfo viewItem = rd.getViewItem(0, 1);
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
                        this.apD = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.apD = 40;
                        } else {
                            this.apD = 39;
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
        if (this.apI != null) {
            appData = this.apI;
        } else if (this.apH == null) {
            return "";
        } else {
            appData = new AppData(this.apH);
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
        builder.da_good_id = String.valueOf(this.apB.apJ);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.apq;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.apy);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.apz;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public int apJ;
        public String apK;
        public String apL;
        public String apM;
        public String apN;
        public int apO;
        public String apP;
        public String apQ;
        public String apR;
        public List<String> apS = new ArrayList(3);
        public VideoInfo apT;
        public String apU;
        public String apV;
        public float apW;
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
            List<String> ef;
            if (goodsInfo != null) {
                this.apJ = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.apK = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.apM = goodsInfo.thread_pic;
                this.apN = goodsInfo.pop_window_text;
                this.apO = goodsInfo.goods_style.intValue();
                this.apP = goodsInfo.card_desc;
                this.apQ = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.apR = goodsInfo.button_url;
                this.apL = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.apS.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.I(this.apS) && (ef = ef(goodsInfo.lego_card)) != null && this.apS != null) {
                        this.apS.addAll(ef);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.apT = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.apU = goodsInfo.tag_name_url;
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
                    this.apV = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.apW = l3 / l4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public List<String> ef(String str) {
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
        if (this.apB.apO == 1001 || this.apB.apO == -1001) {
            return aoY;
        }
        if (!com.baidu.tbadk.core.i.xE().xI() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return aoY;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = aph;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return api;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return apj;
                case 7:
                    return apk;
                case 9:
                    return apm;
                case 10:
                    return apl;
            }
        }
        return null;
    }
}
