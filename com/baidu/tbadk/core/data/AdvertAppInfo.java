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
    public int UI;
    public String UJ;
    public String UK;
    public int UL;
    public String UM;
    public String UN;
    public String UO;
    public String UQ;
    public String UR;
    public int US;
    public String UT;
    public long UU;
    public String UX;
    public String UY;
    public String UZ;
    public String Uo;
    private App Va;
    public AppData Vb;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
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
    public a UV = new a();
    public boolean UW = false;
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

    public int px() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.fh().al("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.UV == null || this.UV.Vh != 1001) {
            if (this.UV == null || TextUtils.isEmpty(this.UV.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.UJ) || TextUtils.isEmpty(this.UJ.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.UV.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oX().pd() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bl.Zm.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.UV == null || !this.UV.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.UL);
            }
            if (this.UL == 3) {
                return !py() ? 26 : 0;
            } else if (this.UL == 1) {
                return !pz() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean py() {
        boolean z = true;
        if (this.UV == null || this.UV.Vh != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.UL != 3 || this.legoCard.checkLegal(this.UL) != 0) {
                    z = false;
                }
                return z;
            } else if (this.UL != 3 || TextUtils.isEmpty(this.UO.trim()) || TextUtils.isEmpty(this.UN.trim()) || this.UV == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.UV.userName) || TextUtils.isEmpty(this.UV.userName.trim())) && TextUtils.isEmpty(this.UV.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pz() {
        if (this.UV == null || this.UV.Vh != 1001) {
            if (this.UV == null || this.UV.Vh != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.UL == 1 && !((TextUtils.isEmpty(this.UM) || TextUtils.isEmpty(this.UM.trim())) && TextUtils.isEmpty(this.UV.lego_card)) : this.UL == 1 && this.legoCard.checkLegal(this.UL) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nd;
        if (app != null) {
            this.Va = app;
            this.UJ = app.id;
            this.UK = app.name;
            this.UL = app.url_type.intValue();
            this.UM = app.url;
            this.UN = app.apk_url;
            this.deepUrl = app.deep_url;
            this.UO = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.UQ = app.first_name;
            this.UR = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.US = app.plan_id.intValue();
            this.userId = app.user_id;
            this.UT = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.UU = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.UV.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.fh().al("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.UV.lego_card) && (nd = com.baidu.tieba.lego.card.b.nd(this.UV.lego_card)) != null) {
                ICardInfo viewItem = nd.getViewItem(0, 1);
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

    public String pA() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Vb != null) {
            appData = this.Vb;
        } else if (this.Va == null) {
            return "";
        } else {
            appData = new AppData(this.Va);
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
        builder.da_good_id = String.valueOf(this.UV.Vc);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.UJ;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.US);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.UT;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Vc;
        public String Vd;
        public String Ve;
        public String Vf;
        public String Vg;
        public int Vh;
        public String Vi;
        public String Vj;
        public String Vk;
        public List<String> Vl = new ArrayList();
        public VideoInfo Vm;
        public String Vn;
        public String Vo;
        public String Vp;
        public float Vq;
        public AdCloseInfo Vr;
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
                this.Vc = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Vd = com.baidu.tbadk.core.util.al.c(goodsInfo.thread_title, 29, "...");
                this.Vf = goodsInfo.thread_pic;
                this.Vg = goodsInfo.pop_window_text;
                this.Vh = goodsInfo.goods_style.intValue();
                this.Vi = goodsInfo.card_desc;
                this.Vj = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Vk = goodsInfo.button_url;
                this.Ve = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Vl.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Vm = goodsInfo.video_info;
                    this.Vn = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Vo = goodsInfo.tag_name_url;
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
                    this.Vp = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.al.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Vq = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Vr = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.fh().al("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.UV.Vh == 1001 || this.UV.Vh == -1001) {
            return Uu;
        }
        if (!StringUtils.isNull(this.UV.lego_card, true)) {
            return UH;
        }
        return null;
    }
}
