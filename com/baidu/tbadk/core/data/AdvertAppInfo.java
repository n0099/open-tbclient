package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
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
public class AdvertAppInfo extends bi {
    public static final BdUniqueId TC = BdUniqueId.gen();
    public static final BdUniqueId TD = BdUniqueId.gen();
    public static final BdUniqueId TE = BdUniqueId.gen();
    public static final BdUniqueId TF = BdUniqueId.gen();
    public static final BdUniqueId TG = BdUniqueId.gen();
    public static final BdUniqueId TH = BdUniqueId.gen();
    public static final BdUniqueId TI = BdUniqueId.gen();
    public static final BdUniqueId TJ = BdUniqueId.gen();
    public static final BdUniqueId TK = BdUniqueId.gen();
    public static final BdUniqueId TL = BdUniqueId.gen();
    public static final BdUniqueId TM = BdUniqueId.gen();
    public static final BdUniqueId TO = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public int TQ;
    public String TR;
    public String TS;
    public int TT;
    public String TU;
    public String TV;
    public String TW;
    public String TX;
    public String TY;
    public int TZ;
    public String Tw;
    public String Ua;
    public long Ub;
    public String Ue;
    public String Uf;
    public String Ug;
    private App Uh;
    public AppData Ui;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Uc = new a();
    public boolean Ud = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public boolean pO() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.Uc.Uo == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.TR) || TextUtils.isEmpty(this.TR.trim())) {
            return false;
        }
        int Y = com.baidu.adp.lib.b.e.eY().Y("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.Uc.lego_card) || !(Y == 0 || this.legoCard == null)) {
            if ((TextUtils.isEmpty(this.Uc.lego_card) || bi.Yg.get() || bi.Yi.get()) && this.Uc != null && this.Uc.isValid() && this.TT != 2) {
                return pP() || pQ();
            }
            return false;
        }
        return false;
    }

    public boolean pP() {
        return (this.TT != 3 || TextUtils.isEmpty(this.TW.trim()) || TextUtils.isEmpty(this.TV.trim()) || this.Uc == null || ((TextUtils.isEmpty(this.Uc.userName) || TextUtils.isEmpty(this.Uc.userName.trim())) && TextUtils.isEmpty(this.Uc.lego_card))) ? false : true;
    }

    public boolean pQ() {
        if (this.Uc == null || this.Uc.Uo != 1001) {
            return this.TT == 1 && !((TextUtils.isEmpty(this.TU) || TextUtils.isEmpty(this.TU.trim())) && TextUtils.isEmpty(this.Uc.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo lt;
        if (app != null) {
            this.Uh = app;
            this.TR = app.id;
            this.TS = app.name;
            this.TT = app.url_type.intValue();
            this.TU = app.url;
            this.TV = app.apk_url;
            this.deepUrl = app.deep_url;
            this.TW = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.TX = app.first_name;
            this.TY = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.TZ = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Ua = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ub = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Uc.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eY().Y("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Uc.lego_card) && (lt = com.baidu.tieba.lego.card.b.lt(this.Uc.lego_card)) != null) {
                ICardInfo viewItem = lt.getViewItem(0, 1);
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

    public String pR() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Ui != null) {
            appData = this.Ui;
        } else if (this.Uh == null) {
            return "";
        } else {
            appData = new AppData(this.Uh);
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
        builder.da_good_id = String.valueOf(this.Uc.Uj);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.TR;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.TZ);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Ua;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Uj;
        public String Uk;
        public String Ul;
        public String Um;
        public String Un;
        public int Uo;
        public String Up;
        public String Uq;
        public String Ur;
        public List<String> Us = new ArrayList();
        public VideoInfo Ut;
        public String Uu;
        public String Uv;
        public String Uw;
        public float Ux;
        public AdCloseInfo Uy;
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
                this.Uj = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Uk = com.baidu.tbadk.core.util.au.c(goodsInfo.thread_title, 29, "...");
                this.Um = goodsInfo.thread_pic;
                this.Un = goodsInfo.pop_window_text;
                this.Uo = goodsInfo.goods_style.intValue();
                this.Up = goodsInfo.card_desc;
                this.Uq = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Ur = goodsInfo.button_url;
                this.Ul = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Us.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = com.baidu.tieba.recapp.y.pi(goodsInfo.lego_card);
                    this.Ut = goodsInfo.video_info;
                    this.Uu = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Uv = goodsInfo.tag_name_url;
                    String str = goodsInfo.tag_name_wh;
                    if (str != null) {
                        try {
                            String[] split = str.split(",");
                            int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                            int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                            if (g2 != 0) {
                                this.tagRatio = g / g2;
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                    }
                    this.Uw = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Ux = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Uy = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.eY().Y("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.Uo == 7 || this.Uo == 9) {
                    if (this.Ut != null && !StringUtils.isNull(this.Ut.video_url)) {
                        if (this.Ut.video_height.intValue() <= 0 || this.Ut.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.Ut.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.Uo == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.Uo == 2) {
                    return !StringUtils.isNull(this.Um);
                } else if (this.Uo == 6) {
                    return this.Us != null && this.Us.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.Uc.lego_card, true)) {
            return TP;
        }
        if (this.Uc.Uo == 1001) {
            return TC;
        }
        if (this.Uc.Uo == 2) {
            return TD;
        }
        if (this.Uc.Uo == 6) {
            return TE;
        }
        if (this.Uc.Uo == 7) {
            return TF;
        }
        if (this.Uc.Uo == 9) {
            return TG;
        }
        return null;
    }
}
