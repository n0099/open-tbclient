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
    public static final BdUniqueId TL = BdUniqueId.gen();
    public static final BdUniqueId TM = BdUniqueId.gen();
    public static final BdUniqueId TO = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public static final BdUniqueId TS = BdUniqueId.gen();
    public static final BdUniqueId TT = BdUniqueId.gen();
    public static final BdUniqueId TU = BdUniqueId.gen();
    public static final BdUniqueId TV = BdUniqueId.gen();
    public static final BdUniqueId TW = BdUniqueId.gen();
    public static final BdUniqueId TX = BdUniqueId.gen();
    public static final BdUniqueId TY = BdUniqueId.gen();
    public String TF;
    public int TZ;
    public String Ua;
    public String Ub;
    public int Uc;
    public String Ud;
    public String Ue;
    public String Uf;
    public int Ug;
    public String Uh;
    public String Ui;
    public int Uj;
    public String Uk;
    public long Ul;
    public String Uo;
    public String Up;
    public String Uq;
    private App Ur;
    public AppData Us;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Um = new a();
    public boolean Un = false;
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

    public int pt() {
        if (StringUtils.isNull(this.adPosition)) {
            return 23;
        }
        if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 0) {
            return 28;
        }
        if (this.Um == null || this.Um.Uy != 1001) {
            if (this.Um == null || TextUtils.isEmpty(this.Um.lego_card)) {
                return 11;
            }
            if (TextUtils.isEmpty(this.Ua) || TextUtils.isEmpty(this.Ua.trim())) {
                return 24;
            }
            if (this.legoCard == null || !this.Um.isValid()) {
                return 32;
            }
            if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.h.oT().oZ() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bh.Ys.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.Um == null || !this.Um.isValid()) {
                return 25;
            }
            if (this.legoCard.getGoodsStyle() == 11) {
                return this.legoCard.checkLegal(this.Uc);
            }
            if (this.Uc == 3) {
                return !pu() ? 26 : 0;
            } else if (this.Uc == 1) {
                return !pv() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean pu() {
        boolean z = true;
        if (this.Um == null || this.Um.Uy != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.Uc != 3 || this.legoCard.checkLegal(this.Uc) != 0) {
                    z = false;
                }
                return z;
            } else if (this.Uc != 3 || TextUtils.isEmpty(this.Uf.trim()) || TextUtils.isEmpty(this.Ue.trim()) || this.Um == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.Um.userName) || TextUtils.isEmpty(this.Um.userName.trim())) && TextUtils.isEmpty(this.Um.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean pv() {
        if (this.Um == null || this.Um.Uy != 1001) {
            if (this.Um == null || this.Um.Uy != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.Uc == 1 && !((TextUtils.isEmpty(this.Ud) || TextUtils.isEmpty(this.Ud.trim())) && TextUtils.isEmpty(this.Um.lego_card)) : this.Uc == 1 && this.legoCard.checkLegal(this.Uc) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ng;
        if (app != null) {
            this.Ur = app;
            this.Us = new AppData(app);
            this.Ua = app.id;
            this.Ub = app.name;
            this.Uc = app.url_type.intValue();
            this.Ud = app.url;
            this.Ue = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Uf = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Ug = app.pos.intValue();
            this.Uh = app.first_name;
            this.Ui = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Uj = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Uk = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ul = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Um.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Um.lego_card) && (ng = com.baidu.tieba.lego.card.b.ng(this.Um.lego_card)) != null) {
                ICardInfo viewItem = ng.getViewItem(0, 1);
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

    public String pw() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Us != null) {
            appData = this.Us;
        } else if (this.Ur == null) {
            return "";
        } else {
            appData = new AppData(this.Ur);
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
        builder.da_good_id = String.valueOf(this.Um.Ut);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Ua;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Uj);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Uk;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public String UB;
        public String UC;
        public List<String> UD = new ArrayList();
        public VideoInfo UE;
        public String UF;
        public String UG;
        public float UH;
        public AdCloseInfo UI;
        public int Ut;
        public String Uu;
        public String Uv;
        public String Uw;
        public String Ux;
        public int Uy;
        public String Uz;
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
                this.Ut = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Uu = com.baidu.tbadk.core.util.am.d(goodsInfo.thread_title, 29, "...");
                this.Uw = goodsInfo.thread_pic;
                this.Ux = goodsInfo.pop_window_text;
                this.Uy = goodsInfo.goods_style.intValue();
                this.Uz = goodsInfo.card_desc;
                this.UB = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.UC = goodsInfo.button_url;
                this.Uv = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.UD.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.UE = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.UF = goodsInfo.tag_name_url;
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
                    this.UG = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.am.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.UH = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.UI = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eV().af("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.Um.Uy == 1001 || this.Um.Uy == -1001) {
            return TL;
        }
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return TL;
        }
        if (!StringUtils.isNull(this.Um.lego_card, true)) {
            return TY;
        }
        return null;
    }
}
