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
    public int UJ;
    public String UK;
    public String UL;
    public int UM;
    public String UN;
    public String UO;
    public String UQ;
    public int UR;
    public String US;
    public String UT;
    public int UU;
    public String UV;
    public long UW;
    public String UZ;
    public String Un;
    public String Va;
    public String Vb;
    private App Vc;
    public AppData Vd;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId Ut = BdUniqueId.gen();
    public static final BdUniqueId Uu = BdUniqueId.gen();
    public static final BdUniqueId Uv = BdUniqueId.gen();
    public static final BdUniqueId Uw = BdUniqueId.gen();
    public static final BdUniqueId Ux = BdUniqueId.gen();
    public static final BdUniqueId Uy = BdUniqueId.gen();
    public static final BdUniqueId Uz = BdUniqueId.gen();
    public static final BdUniqueId UB = BdUniqueId.gen();
    public static final BdUniqueId UC = BdUniqueId.gen();
    public static final BdUniqueId UD = BdUniqueId.gen();
    public static final BdUniqueId UE = BdUniqueId.gen();
    public static final BdUniqueId UF = BdUniqueId.gen();
    public static final BdUniqueId UG = BdUniqueId.gen();
    public static final BdUniqueId UH = BdUniqueId.gen();
    public static final BdUniqueId UI = BdUniqueId.gen();
    public a UX = new a();
    public boolean UY = false;
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

    public int pw() {
        if (!bd.YL.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
            return 31;
        }
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.UX == null || this.UX.Vj != 1001) {
            if (this.UX == null || TextUtils.isEmpty(this.UX.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.UK) || TextUtils.isEmpty(this.UK.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.UX.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oY().pe() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (this.UX == null || !this.UX.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.UM);
            }
            if (this.UM == 3) {
                return !px() ? 26 : 0;
            } else if (this.UM == 1) {
                return !py() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean px() {
        boolean z = true;
        if (this.UX == null || this.UX.Vj != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.UM != 3 || this.legoCard.checkLegal(this.UM) != 0) {
                    z = false;
                }
                return z;
            } else if (this.UM != 3 || TextUtils.isEmpty(this.UQ.trim()) || TextUtils.isEmpty(this.UO.trim()) || this.UX == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.UX.userName) || TextUtils.isEmpty(this.UX.userName.trim())) && TextUtils.isEmpty(this.UX.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean py() {
        if (this.UX == null || this.UX.Vj != 1001) {
            if (this.UX == null || this.UX.Vj != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.UM == 1 && !((TextUtils.isEmpty(this.UN) || TextUtils.isEmpty(this.UN.trim())) && TextUtils.isEmpty(this.UX.lego_card)) : this.UM == 1 && this.legoCard.checkLegal(this.UM) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nL;
        if (app != null) {
            this.Vc = app;
            this.Vd = new AppData(app);
            this.UK = app.id;
            this.UL = app.name;
            this.UM = app.url_type.intValue();
            this.UN = app.url;
            this.UO = app.apk_url;
            this.deepUrl = app.deep_url;
            this.UQ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.UR = app.pos.intValue();
            this.US = app.first_name;
            this.UT = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.UU = app.plan_id.intValue();
            this.userId = app.user_id;
            this.UV = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.UW = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.UX.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.UX.lego_card) && (nL = com.baidu.tieba.lego.card.b.nL(this.UX.lego_card)) != null) {
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

    public String pz() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Vd != null) {
            appData = this.Vd;
        } else if (this.Vc == null) {
            return "";
        } else {
            appData = new AppData(this.Vc);
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
        builder.da_good_id = String.valueOf(this.UX.Ve);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.UK;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.UU);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.UV;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Ve;
        public String Vf;
        public String Vg;
        public String Vh;
        public String Vi;
        public int Vj;
        public String Vk;
        public String Vl;
        public String Vm;
        public List<String> Vn = new ArrayList();
        public VideoInfo Vo;
        public String Vp;
        public String Vq;
        public float Vr;
        public AdCloseInfo Vs;
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
                this.Ve = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Vf = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.Vh = goodsInfo.thread_pic;
                this.Vi = goodsInfo.pop_window_text;
                this.Vj = goodsInfo.goods_style.intValue();
                this.Vk = goodsInfo.card_desc;
                this.Vl = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Vm = goodsInfo.button_url;
                this.Vg = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Vn.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Vo = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Vp = goodsInfo.tag_name_url;
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
                    this.Vq = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Vr = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Vs = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.UX.Vj == 1001 || this.UX.Vj == -1001) {
            return Ut;
        }
        if (!com.baidu.tbadk.core.h.oY().pe() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return Ut;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = UD;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return UE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return UF;
                case 7:
                    return UG;
                case 9:
                    return UI;
                case 10:
                    return UH;
            }
        }
        return null;
    }
}
