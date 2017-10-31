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
public class AdvertAppInfo extends bh {
    public static final BdUniqueId TS = BdUniqueId.gen();
    public static final BdUniqueId TT = BdUniqueId.gen();
    public static final BdUniqueId TU = BdUniqueId.gen();
    public static final BdUniqueId TV = BdUniqueId.gen();
    public static final BdUniqueId TW = BdUniqueId.gen();
    public static final BdUniqueId TX = BdUniqueId.gen();
    public static final BdUniqueId TY = BdUniqueId.gen();
    public static final BdUniqueId TZ = BdUniqueId.gen();
    public static final BdUniqueId Ua = BdUniqueId.gen();
    public static final BdUniqueId Ub = BdUniqueId.gen();
    public static final BdUniqueId Uc = BdUniqueId.gen();
    public static final BdUniqueId Ud = BdUniqueId.gen();
    public static final BdUniqueId Ue = BdUniqueId.gen();
    public String TL;
    public int Uf;
    public String Ug;
    public String Uh;
    public int Ui;
    public String Uj;
    public String Uk;
    public String Ul;
    public int Um;
    public String Un;
    public String Uo;
    public int Up;
    public String Uq;
    public long Ur;
    public String Uu;
    public String Uv;
    public String Uw;
    private App Ux;
    public AppData Uy;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Us = new a();
    public boolean Ut = false;
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

    public int pr() {
        if (!bh.Yy.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
            return 31;
        }
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Us == null || this.Us.UF != 1001) {
            if (this.Us == null || TextUtils.isEmpty(this.Us.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.Ug) || TextUtils.isEmpty(this.Ug.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Us.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oT().oZ() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (this.Us == null || !this.Us.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.Ui);
            }
            if (this.Ui == 3) {
                return !ps() ? 26 : 0;
            } else if (this.Ui == 1) {
                return !pt() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean ps() {
        boolean z = true;
        if (this.Us == null || this.Us.UF != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Ui != 3 || this.legoCard.checkLegal(this.Ui) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Ui != 3 || TextUtils.isEmpty(this.Ul.trim()) || TextUtils.isEmpty(this.Uk.trim()) || this.Us == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Us.userName) || TextUtils.isEmpty(this.Us.userName.trim())) && TextUtils.isEmpty(this.Us.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pt() {
        if (this.Us == null || this.Us.UF != 1001) {
            if (this.Us == null || this.Us.UF != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Ui == 1 && !((TextUtils.isEmpty(this.Uj) || TextUtils.isEmpty(this.Uj.trim())) && TextUtils.isEmpty(this.Us.lego_card)) : this.Ui == 1 && this.legoCard.checkLegal(this.Ui) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo nA;
        if (app != null) {
            this.Ux = app;
            this.Uy = new AppData(app);
            this.Ug = app.id;
            this.Uh = app.name;
            this.Ui = app.url_type.intValue();
            this.Uj = app.url;
            this.Uk = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Ul = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Um = app.pos.intValue();
            this.Un = app.first_name;
            this.Uo = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Up = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Uq = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ur = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Us.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Us.lego_card) && (nA = com.baidu.tieba.lego.card.b.nA(this.Us.lego_card)) != null) {
                ICardInfo viewItem = nA.getViewItem(0, 1);
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

    public String pu() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Uy != null) {
            appData = this.Uy;
        } else if (this.Ux == null) {
            return "";
        } else {
            appData = new AppData(this.Ux);
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
        builder.da_good_id = String.valueOf(this.Us.Uz);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Ug;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Up);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Uq;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String UB;
        public String UC;
        public String UD;
        public String UE;
        public int UF;
        public String UG;
        public String UH;
        public String UI;
        public List<String> UJ = new ArrayList();
        public VideoInfo UK;
        public String UL;
        public String UM;
        public float UN;
        public AdCloseInfo UO;
        public int Uz;
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
                this.Uz = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.UB = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.UD = goodsInfo.thread_pic;
                this.UE = goodsInfo.pop_window_text;
                this.UF = goodsInfo.goods_style.intValue();
                this.UG = goodsInfo.card_desc;
                this.UH = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.UI = goodsInfo.button_url;
                this.UC = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.UJ.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.UK = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.UL = goodsInfo.tag_name_url;
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
                    this.UM = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.UN = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.UO = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.Us.UF == 1001 || this.Us.UF == -1001) {
            return TS;
        }
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return TS;
        }
        if (!StringUtils.isNull(this.Us.lego_card, true)) {
            return Ue;
        }
        return null;
    }
}
