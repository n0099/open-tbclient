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
    public static final BdUniqueId afN = BdUniqueId.gen();
    public static final BdUniqueId afO = BdUniqueId.gen();
    public static final BdUniqueId afP = BdUniqueId.gen();
    public static final BdUniqueId afQ = BdUniqueId.gen();
    public static final BdUniqueId afR = BdUniqueId.gen();
    public static final BdUniqueId afS = BdUniqueId.gen();
    public static final BdUniqueId afT = BdUniqueId.gen();
    public static final BdUniqueId afU = BdUniqueId.gen();
    public static final BdUniqueId afV = BdUniqueId.gen();
    public static final BdUniqueId afW = BdUniqueId.gen();
    public static final BdUniqueId afX = BdUniqueId.gen();
    public static final BdUniqueId afY = BdUniqueId.gen();
    public static final BdUniqueId afZ = BdUniqueId.gen();
    public static final BdUniqueId aga = BdUniqueId.gen();
    public static final BdUniqueId agb = BdUniqueId.gen();
    public static AtomicBoolean agc = new AtomicBoolean(false);
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int agd;
    public String agf;
    public String agg;
    public int agh;
    public String agi;
    public String agj;
    public String agk;
    public int agl;
    public String agm;
    public String agn;
    public int ago;
    public String agp;
    public long agq;
    public String agu;
    public String agv;
    public String agw;
    private App agx;
    public AppData agy;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String page;
    public String price;
    public String userId;
    public a agr = new a();
    public boolean ags = false;
    public ILegoAdvert legoCard = null;
    private int agt = 32;

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
        return (this.agf != null ? this.agf.hashCode() : 0) + (this.extensionInfo != null ? this.extensionInfo.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.agf, this.agf) && TextUtils.equals(advertAppInfo.extensionInfo, this.extensionInfo);
        }
        return false;
    }

    public int uH() {
        if (bb.akj.get() && agc.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.iB().aO("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.agr == null || this.agr.agE != 1001) {
                if (this.agr == null || TextUtils.isEmpty(this.agr.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.agf) || TextUtils.isEmpty(this.agf.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.agr.isValid()) {
                    return this.agt;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.uj().un() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.agr == null || !this.agr.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.agh);
                }
                if (this.agh == 3) {
                    if (!uI()) {
                        return 26;
                    }
                } else if (this.agh == 1) {
                    if (!uJ()) {
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

    public boolean uI() {
        boolean z = true;
        if (this.agr == null || this.agr.agE != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.agh != 3 || this.legoCard.checkLegal(this.agh) != 0) {
                    z = false;
                }
                return z;
            } else if (this.agh != 3 || TextUtils.isEmpty(this.agk.trim()) || TextUtils.isEmpty(this.agj.trim()) || this.agr == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.agr.userName) || TextUtils.isEmpty(this.agr.userName.trim())) && TextUtils.isEmpty(this.agr.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean uJ() {
        if (this.agr == null || this.agr.agE != 1001) {
            if (this.agr == null || this.agr.agE != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.agh == 1 && !((TextUtils.isEmpty(this.agi) || TextUtils.isEmpty(this.agi.trim())) && TextUtils.isEmpty(this.agr.lego_card)) : this.agh == 1 && this.legoCard.checkLegal(this.agh) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        if (app != null) {
            this.agx = app;
            this.agy = new AppData(app);
            this.agf = app.id;
            this.agg = app.name;
            this.agh = app.url_type.intValue();
            this.agi = app.url;
            this.agj = app.apk_url;
            this.deepUrl = app.deep_url;
            this.agk = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.agl = app.pos.intValue();
            this.agm = app.first_name;
            this.agn = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.ago = app.plan_id.intValue();
            this.userId = app.user_id;
            this.agp = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.agq = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.agr.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.iB().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.agr.lego_card)) {
                try {
                    ICardInfo pV = com.baidu.tieba.lego.card.b.pV(this.agr.lego_card);
                    if (pV != null) {
                        ICardInfo viewItem = pV.getViewItem(0, 1);
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
                        this.agt = 38;
                    } else if (e instanceof CardParseException) {
                        if (e.getCause() instanceof IllegalStateException) {
                            this.agt = 40;
                        } else {
                            this.agt = 39;
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
        if (this.agy != null) {
            appData = this.agy;
        } else if (this.agx == null) {
            return "";
        } else {
            appData = new AppData(this.agx);
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
        builder.da_good_id = String.valueOf(this.agr.agz);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.agf;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.ago);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.agp;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo adCloseInfo;
        public String adSource;
        public String agA;
        public String agB;
        public String agC;
        public String agD;
        public int agE;
        public String agF;
        public String agG;
        public String agH;
        public List<String> agI = new ArrayList(3);
        public VideoInfo agJ;
        public String agK;
        public String agL;
        public float agM;
        public int agz;
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
            List<String> dx;
            if (goodsInfo != null) {
                this.agz = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.agA = com.baidu.tbadk.core.util.ao.c(goodsInfo.thread_title, 29, "...");
                this.agC = goodsInfo.thread_pic;
                this.agD = goodsInfo.pop_window_text;
                this.agE = goodsInfo.goods_style.intValue();
                this.agF = goodsInfo.card_desc;
                this.agG = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.agH = goodsInfo.button_url;
                this.agB = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.agI.add(threadPicList.pic);
                        }
                    }
                    if (com.baidu.tbadk.core.util.v.z(this.agI) && (dx = dx(goodsInfo.lego_card)) != null && this.agI != null) {
                        this.agI.addAll(dx);
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.agJ = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.agK = goodsInfo.tag_name_url;
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
                    this.agL = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.ao.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                            int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                            if (l4 != 0) {
                                this.agM = l3 / l4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.adCloseInfo = goodsInfo.close_info;
                }
            }
        }

        public List<String> dx(String str) {
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
            return com.baidu.adp.lib.b.d.iB().aO("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.agr.agE == 1001 || this.agr.agE == -1001) {
            return afN;
        }
        if (!com.baidu.tbadk.core.i.uj().un() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return afN;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = afW;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return afX;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return afY;
                case 7:
                    return afZ;
                case 9:
                    return agb;
                case 10:
                    return aga;
            }
        }
        return null;
    }
}
