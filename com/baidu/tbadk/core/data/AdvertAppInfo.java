package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bd {
    public int VO;
    public String VP;
    public String VQ;
    public int VR;
    public String VS;
    public String VT;
    public String VU;
    public int VV;
    public String VW;
    public String VX;
    public int VY;
    public String VZ;
    public String Vt;
    public long Wa;
    public String Wd;
    public String We;
    public String Wf;
    private App Wg;
    public AppData Wh;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId Vy = BdUniqueId.gen();
    public static final BdUniqueId Vz = BdUniqueId.gen();
    public static final BdUniqueId VA = BdUniqueId.gen();
    public static final BdUniqueId VB = BdUniqueId.gen();
    public static final BdUniqueId VC = BdUniqueId.gen();
    public static final BdUniqueId VD = BdUniqueId.gen();
    public static final BdUniqueId VE = BdUniqueId.gen();
    public static final BdUniqueId VF = BdUniqueId.gen();
    public static final BdUniqueId VG = BdUniqueId.gen();
    public static final BdUniqueId VH = BdUniqueId.gen();
    public static final BdUniqueId VI = BdUniqueId.gen();
    public static final BdUniqueId VJ = BdUniqueId.gen();
    public static final BdUniqueId VK = BdUniqueId.gen();
    public static final BdUniqueId VL = BdUniqueId.gen();
    public static final BdUniqueId VM = BdUniqueId.gen();
    public static AtomicBoolean VN = new AtomicBoolean(false);
    public a Wb = new a();
    public boolean Wc = false;
    public ILegoAdvert legoCard = null;

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

    public int qs() {
        if (bd.ZS.get() && VN.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.Wb == null || this.Wb.Wn != 1001) {
                if (this.Wb == null || TextUtils.isEmpty(this.Wb.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.VP) || TextUtils.isEmpty(this.VP.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.Wb.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.pY().qe() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.Wb == null || !this.Wb.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.VR);
                }
                if (this.VR == 3) {
                    if (!qt()) {
                        return 26;
                    }
                } else if (this.VR == 1) {
                    if (!qu()) {
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

    public boolean qt() {
        boolean z = true;
        if (this.Wb == null || this.Wb.Wn != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.VR != 3 || this.legoCard.checkLegal(this.VR) != 0) {
                    z = false;
                }
                return z;
            } else if (this.VR != 3 || TextUtils.isEmpty(this.VU.trim()) || TextUtils.isEmpty(this.VT.trim()) || this.Wb == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Wb.userName) || TextUtils.isEmpty(this.Wb.userName.trim())) && TextUtils.isEmpty(this.Wb.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean qu() {
        if (this.Wb == null || this.Wb.Wn != 1001) {
            if (this.Wb == null || this.Wb.Wn != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.VR == 1 && !((TextUtils.isEmpty(this.VS) || TextUtils.isEmpty(this.VS.trim())) && TextUtils.isEmpty(this.Wb.lego_card)) : this.VR == 1 && this.legoCard.checkLegal(this.VR) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ov;
        if (app != null) {
            this.Wg = app;
            this.Wh = new AppData(app);
            this.VP = app.id;
            this.VQ = app.name;
            this.VR = app.url_type.intValue();
            this.VS = app.url;
            this.VT = app.apk_url;
            this.deepUrl = app.deep_url;
            this.VU = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.VV = app.pos.intValue();
            this.VW = app.first_name;
            this.VX = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.VY = app.plan_id.intValue();
            this.userId = app.user_id;
            this.VZ = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Wa = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Wb.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Wb.lego_card) && (ov = com.baidu.tieba.lego.card.b.ov(this.Wb.lego_card)) != null) {
                ICardInfo viewItem = ov.getViewItem(0, 1);
                if (viewItem instanceof ILegoAdvert) {
                    this.legoCard = (ILegoAdvert) viewItem;
                    this.legoCard.setAdvertAppInfo(this);
                    return;
                }
                this.legoCard = null;
                BdLog.e("Got invalid card for ad, " + (viewItem == null ? "null ad" : String.valueOf(viewItem)));
            }
        }
    }

    public String adCollect() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Wh != null) {
            appData = this.Wh;
        } else if (this.Wg == null) {
            return "";
        } else {
            appData = new AppData(this.Wg);
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
        builder.da_good_id = String.valueOf(this.Wb.Wi);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.VP;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.VY);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.VZ;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Wi;
        public String Wj;
        public String Wk;
        public String Wl;
        public String Wm;
        public int Wn;
        public String Wo;
        public String Wp;
        public String Wq;
        public List<String> Wr = new ArrayList();
        public VideoInfo Ws;
        public String Wt;
        public String Wu;
        public float Wv;
        public AdCloseInfo Ww;
        public String adSource;
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
            if (goodsInfo != null) {
                this.Wi = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Wj = com.baidu.tbadk.core.util.an.d(goodsInfo.thread_title, 29, "...");
                this.Wl = goodsInfo.thread_pic;
                this.Wm = goodsInfo.pop_window_text;
                this.Wn = goodsInfo.goods_style.intValue();
                this.Wo = goodsInfo.card_desc;
                this.Wp = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Wq = goodsInfo.button_url;
                this.Wk = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Wr.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Ws = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Wt = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.Wu = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.an.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Wv = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Ww = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.Wb.Wn == 1001 || this.Wb.Wn == -1001) {
            return Vy;
        }
        if (!com.baidu.tbadk.core.i.pY().qe() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return Vy;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = VH;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return VI;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return VJ;
                case 7:
                    return VK;
                case 9:
                    return VM;
                case 10:
                    return VL;
            }
        }
        return null;
    }
}
