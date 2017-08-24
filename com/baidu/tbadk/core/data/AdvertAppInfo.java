package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
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
public class AdvertAppInfo extends bl {
    public int UJ;
    public String UK;
    public String UL;
    public int UM;
    public String UN;
    public String UO;
    public String UQ;
    public String UR;
    public String US;
    public int UT;
    public String UU;
    public long UV;
    public String UY;
    public String UZ;
    public String Up;
    public String Va;
    private App Vb;
    public AppData Vc;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
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
    public a UW = new a();
    public boolean UX = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        int checkLegal(int i);

        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        boolean isNoPicAd();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int py() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.fh().am("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.UW == null || this.UW.Vi != 1001) {
            if (this.UW == null || TextUtils.isEmpty(this.UW.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.UK) || TextUtils.isEmpty(this.UK.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.UW.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oY().pe() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bl.Zn.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.UW == null || !this.UW.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.UM);
            }
            if (this.UM == 3) {
                return !pz() ? 26 : 0;
            } else if (this.UM == 1) {
                return !pA() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pz() {
        boolean z = true;
        if (this.UW == null || this.UW.Vi != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.UM != 3 || this.legoCard.checkLegal(this.UM) != 0) {
                    z = false;
                }
                return z;
            } else if (this.UM != 3 || TextUtils.isEmpty(this.UQ.trim()) || TextUtils.isEmpty(this.UO.trim()) || this.UW == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.UW.userName) || TextUtils.isEmpty(this.UW.userName.trim())) && TextUtils.isEmpty(this.UW.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pA() {
        if (this.UW == null || this.UW.Vi != 1001) {
            if (this.UW == null || this.UW.Vi != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.UM == 1 && !((TextUtils.isEmpty(this.UN) || TextUtils.isEmpty(this.UN.trim())) && TextUtils.isEmpty(this.UW.lego_card)) : this.UM == 1 && this.legoCard.checkLegal(this.UM) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ni;
        if (app != null) {
            this.Vb = app;
            this.UK = app.id;
            this.UL = app.name;
            this.UM = app.url_type.intValue();
            this.UN = app.url;
            this.UO = app.apk_url;
            this.deepUrl = app.deep_url;
            this.UQ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.UR = app.first_name;
            this.US = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.UT = app.plan_id.intValue();
            this.userId = app.user_id;
            this.UU = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.UV = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.UW.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.fh().am("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.UW.lego_card) && (ni = com.baidu.tieba.lego.card.b.ni(this.UW.lego_card)) != null) {
                ICardInfo viewItem = ni.getViewItem(0, 1);
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
        if (this.Vc != null) {
            appData = this.Vc;
        } else if (this.Vb == null) {
            return "";
        } else {
            appData = new AppData(this.Vb);
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
        builder.da_good_id = String.valueOf(this.UW.Vd);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.UK;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.UT);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.UU;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Vd;
        public String Ve;
        public String Vf;
        public String Vg;
        public String Vh;
        public int Vi;
        public String Vj;
        public String Vk;
        public String Vl;
        public List<String> Vm = new ArrayList();
        public VideoInfo Vn;
        public String Vo;
        public String Vp;
        public String Vq;
        public float Vr;
        public AdCloseInfo Vs;
        public String adSource;
        public String buttonText;
        public int height;
        public String lego_card;
        public boolean needResize;
        public float tagRatio;
        public String userName;
        public String userPortrait;
        public int width;

        public void a(GoodsInfo goodsInfo) {
            if (goodsInfo != null) {
                this.Vd = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Ve = com.baidu.tbadk.core.util.al.d(goodsInfo.thread_title, 29, "...");
                this.Vg = goodsInfo.thread_pic;
                this.Vh = goodsInfo.pop_window_text;
                this.Vi = goodsInfo.goods_style.intValue();
                this.Vj = goodsInfo.card_desc;
                this.Vk = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Vl = goodsInfo.button_url;
                this.Vf = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Vm.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Vn = goodsInfo.video_info;
                    this.Vo = goodsInfo.tag_name;
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
                    if (!com.baidu.tbadk.core.util.al.isEmpty(str2)) {
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
            return com.baidu.adp.lib.b.d.fh().am("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.UW.Vi == 1001 || this.UW.Vi == -1001) {
            return Uv;
        }
        if (!StringUtils.isNull(this.UW.lego_card, true)) {
            return UI;
        }
        return null;
    }
}
