package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bd {
    public int UQ;
    public String UR;
    public String US;
    public int UT;
    public String UU;
    public String UV;
    public String UW;
    public int UX;
    public String UY;
    public String UZ;
    public String Ut;
    public int Va;
    public String Vb;
    public long Vc;
    public String Vf;
    public String Vg;
    public String Vh;
    private App Vi;
    public AppData Vj;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId Uz = BdUniqueId.gen();
    public static final BdUniqueId UB = BdUniqueId.gen();
    public static final BdUniqueId UC = BdUniqueId.gen();
    public static final BdUniqueId UD = BdUniqueId.gen();
    public static final BdUniqueId UE = BdUniqueId.gen();
    public static final BdUniqueId UF = BdUniqueId.gen();
    public static final BdUniqueId UG = BdUniqueId.gen();
    public static final BdUniqueId UH = BdUniqueId.gen();
    public static final BdUniqueId UI = BdUniqueId.gen();
    public static final BdUniqueId UJ = BdUniqueId.gen();
    public static final BdUniqueId UK = BdUniqueId.gen();
    public static final BdUniqueId UL = BdUniqueId.gen();
    public static final BdUniqueId UM = BdUniqueId.gen();
    public static final BdUniqueId UN = BdUniqueId.gen();
    public static final BdUniqueId UO = BdUniqueId.gen();
    public a Vd = new a();
    public boolean Ve = false;
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

    public int py() {
        if (!bd.YR.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
            return 31;
        }
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Vd == null || this.Vd.Vp != 1001) {
            if (this.Vd == null || TextUtils.isEmpty(this.Vd.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.UR) || TextUtils.isEmpty(this.UR.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Vd.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.pa().pg() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (this.Vd == null || !this.Vd.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.UT);
            }
            if (this.UT == 3) {
                return !pz() ? 26 : 0;
            } else if (this.UT == 1) {
                return !pA() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pz() {
        boolean z = true;
        if (this.Vd == null || this.Vd.Vp != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.UT != 3 || this.legoCard.checkLegal(this.UT) != 0) {
                    z = false;
                }
                return z;
            } else if (this.UT != 3 || TextUtils.isEmpty(this.UW.trim()) || TextUtils.isEmpty(this.UV.trim()) || this.Vd == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Vd.userName) || TextUtils.isEmpty(this.Vd.userName.trim())) && TextUtils.isEmpty(this.Vd.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pA() {
        if (this.Vd == null || this.Vd.Vp != 1001) {
            if (this.Vd == null || this.Vd.Vp != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.UT == 1 && !((TextUtils.isEmpty(this.UU) || TextUtils.isEmpty(this.UU.trim())) && TextUtils.isEmpty(this.Vd.lego_card)) : this.UT == 1 && this.legoCard.checkLegal(this.UT) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nL;
        if (app != null) {
            this.Vi = app;
            this.Vj = new AppData(app);
            this.UR = app.id;
            this.US = app.name;
            this.UT = app.url_type.intValue();
            this.UU = app.url;
            this.UV = app.apk_url;
            this.deepUrl = app.deep_url;
            this.UW = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.UX = app.pos.intValue();
            this.UY = app.first_name;
            this.UZ = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Va = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Vb = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Vc = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Vd.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Vd.lego_card) && (nL = com.baidu.tieba.lego.card.b.nL(this.Vd.lego_card)) != null) {
                ICardInfo viewItem = nL.getViewItem(0, 1);
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

    public String pB() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Vj != null) {
            appData = this.Vj;
        } else if (this.Vi == null) {
            return "";
        } else {
            appData = new AppData(this.Vi);
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
        builder.da_good_id = String.valueOf(this.Vd.Vk);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.UR;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Va);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Vb;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Vk;
        public String Vl;
        public String Vm;
        public String Vn;
        public String Vo;
        public int Vp;
        public String Vq;
        public String Vr;
        public String Vs;
        public List<String> Vt = new ArrayList();
        public VideoInfo Vu;
        public String Vv;
        public String Vw;
        public float Vx;
        public AdCloseInfo Vy;
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
                this.Vk = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Vl = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.Vn = goodsInfo.thread_pic;
                this.Vo = goodsInfo.pop_window_text;
                this.Vp = goodsInfo.goods_style.intValue();
                this.Vq = goodsInfo.card_desc;
                this.Vr = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Vs = goodsInfo.button_url;
                this.Vm = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Vt.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Vu = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Vv = goodsInfo.tag_name_url;
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
                    this.Vw = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Vx = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Vy = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.Vd.Vp == 1001 || this.Vd.Vp == -1001) {
            return Uz;
        }
        if (!com.baidu.tbadk.core.h.pa().pg() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return Uz;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = UJ;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return UK;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return UL;
                case 7:
                    return UM;
                case 9:
                    return UO;
                case 10:
                    return UN;
            }
        }
        return null;
    }
}
