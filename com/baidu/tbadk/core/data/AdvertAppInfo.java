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
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public int TS;
    public String TT;
    public String TU;
    public int TV;
    public String TW;
    public String TX;
    public String TY;
    public String TZ;
    public String Ty;
    public String Ua;
    public int Ub;
    public String Uc;
    public long Ud;
    public String Ug;
    public String Uh;
    public String Ui;
    private App Uj;
    public AppData Uk;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Ue = new a();
    public boolean Uf = false;
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
        if (this.Ue.Uq == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.TT) || TextUtils.isEmpty(this.TT.trim())) {
            return false;
        }
        int Y = com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.Ue.lego_card) || !(Y == 0 || this.legoCard == null)) {
            if ((TextUtils.isEmpty(this.Ue.lego_card) || bi.Yh.get() || bi.Yj.get()) && this.Ue != null && this.Ue.isValid() && this.TV != 2) {
                return pP() || pQ();
            }
            return false;
        }
        return false;
    }

    public boolean pP() {
        return (this.TV != 3 || TextUtils.isEmpty(this.TY.trim()) || TextUtils.isEmpty(this.TX.trim()) || this.Ue == null || ((TextUtils.isEmpty(this.Ue.userName) || TextUtils.isEmpty(this.Ue.userName.trim())) && TextUtils.isEmpty(this.Ue.lego_card))) ? false : true;
    }

    public boolean pQ() {
        if (this.Ue == null || this.Ue.Uq != 1001) {
            return this.TV == 1 && !((TextUtils.isEmpty(this.TW) || TextUtils.isEmpty(this.TW.trim())) && TextUtils.isEmpty(this.Ue.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo lu;
        if (app != null) {
            this.Uj = app;
            this.TT = app.id;
            this.TU = app.name;
            this.TV = app.url_type.intValue();
            this.TW = app.url;
            this.TX = app.apk_url;
            this.deepUrl = app.deep_url;
            this.TY = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.TZ = app.first_name;
            this.Ua = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Ub = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Uc = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ud = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Ue.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Ue.lego_card) && (lu = com.baidu.tieba.lego.card.b.lu(this.Ue.lego_card)) != null) {
                ICardInfo viewItem = lu.getViewItem(0, 1);
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
        if (this.Uk != null) {
            appData = this.Uk;
        } else if (this.Uj == null) {
            return "";
        } else {
            appData = new AppData(this.Uj);
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
        builder.da_good_id = String.valueOf(this.Ue.Ul);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.TT;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Ub);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Uc;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public AdCloseInfo UB;
        public int Ul;
        public String Um;
        public String Un;
        public String Uo;
        public String Up;
        public int Uq;
        public String Ur;
        public String Us;
        public String Ut;
        public List<String> Uu = new ArrayList();
        public VideoInfo Uv;
        public String Uw;
        public String Ux;
        public String Uy;
        public float Uz;
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
                this.Ul = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Um = com.baidu.tbadk.core.util.au.c(goodsInfo.thread_title, 29, "...");
                this.Uo = goodsInfo.thread_pic;
                this.Up = goodsInfo.pop_window_text;
                this.Uq = goodsInfo.goods_style.intValue();
                this.Ur = goodsInfo.card_desc;
                this.Us = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Ut = goodsInfo.button_url;
                this.Un = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Uu.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = com.baidu.tieba.recapp.y.pj(goodsInfo.lego_card);
                    this.Uv = goodsInfo.video_info;
                    this.Uw = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Ux = goodsInfo.tag_name_url;
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
                    this.Uy = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Uz = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.UB = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.Uq == 7 || this.Uq == 9) {
                    if (this.Uv != null && !StringUtils.isNull(this.Uv.video_url)) {
                        if (this.Uv.video_height.intValue() <= 0 || this.Uv.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.Uv.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.Uq == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.Uq == 2) {
                    return !StringUtils.isNull(this.Uo);
                } else if (this.Uq == 6) {
                    return this.Uu != null && this.Uu.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.Ue.lego_card, true)) {
            return TR;
        }
        if (this.Ue.Uq == 1001) {
            return TE;
        }
        if (this.Ue.Uq == 2) {
            return TF;
        }
        if (this.Ue.Uq == 6) {
            return TG;
        }
        if (this.Ue.Uq == 7) {
            return TH;
        }
        if (this.Ue.Uq == 9) {
            return TI;
        }
        return null;
    }
}
