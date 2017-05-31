package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class AdvertAppInfo extends bl {
    public static final BdUniqueId SK = BdUniqueId.gen();
    public static final BdUniqueId SL = BdUniqueId.gen();
    public static final BdUniqueId SM = BdUniqueId.gen();
    public static final BdUniqueId SN = BdUniqueId.gen();
    public static final BdUniqueId SO = BdUniqueId.gen();
    public static final BdUniqueId SP = BdUniqueId.gen();
    public static final BdUniqueId SQ = BdUniqueId.gen();
    public static final BdUniqueId SR = BdUniqueId.gen();
    public static final BdUniqueId SS = BdUniqueId.gen();
    public static final BdUniqueId ST = BdUniqueId.gen();
    public static final BdUniqueId SU = BdUniqueId.gen();
    public static final BdUniqueId SV = BdUniqueId.gen();
    public static final BdUniqueId SW = BdUniqueId.gen();
    public String SE;
    public int SX;
    public String SY;
    public String SZ;
    public int Ta;
    public String Tb;
    public String Tc;
    public String Td;
    public String Te;
    public String Tf;
    public int Tg;
    public String Th;
    public long Ti;
    public String Tl;
    public String Tm;
    public String Tn;
    private App To;
    public AppData Tp;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Tj = new a();
    public boolean Tk = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public int pn() {
        if (StringUtils.isNull(this.adPosition)) {
            return 1;
        }
        if (this.Tj.Tv == 1001) {
            return 0;
        }
        if (TextUtils.isEmpty(this.SY) || TextUtils.isEmpty(this.SY.trim())) {
            return 1;
        }
        if (TextUtils.isEmpty(this.Tj.lego_card)) {
            return 2;
        }
        if (this.legoCard != null) {
            if (this.legoCard.getCardType() == 12) {
                return 3;
            }
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") == 0 || !bl.Xx.get() || !TbadkCoreApplication.m9getInst().isRecAppExist() || this.Tj == null || !this.Tj.isValid() || this.Ta == 2) {
                return 1;
            }
            return (po() || pp()) ? 0 : 1;
        }
        return 1;
    }

    public boolean po() {
        return (this.Ta != 3 || TextUtils.isEmpty(this.Td.trim()) || TextUtils.isEmpty(this.Tc.trim()) || this.Tj == null || ((TextUtils.isEmpty(this.Tj.userName) || TextUtils.isEmpty(this.Tj.userName.trim())) && TextUtils.isEmpty(this.Tj.lego_card))) ? false : true;
    }

    public boolean pp() {
        if (this.Tj == null || this.Tj.Tv != 1001) {
            return this.Ta == 1 && !((TextUtils.isEmpty(this.Tb) || TextUtils.isEmpty(this.Tb.trim())) && TextUtils.isEmpty(this.Tj.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo lI;
        if (app != null) {
            this.To = app;
            this.SY = app.id;
            this.SZ = app.name;
            this.Ta = app.url_type.intValue();
            this.Tb = app.url;
            this.Tc = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Td = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Te = app.first_name;
            this.Tf = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Tg = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Th = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Ti = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Tj.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Tj.lego_card) && (lI = com.baidu.tieba.lego.card.b.lI(this.Tj.lego_card)) != null) {
                ICardInfo viewItem = lI.getViewItem(0, 1);
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

    public String pq() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Tp != null) {
            appData = this.Tp;
        } else if (this.To == null) {
            return "";
        } else {
            appData = new AppData(this.To);
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
        builder.da_good_id = String.valueOf(this.Tj.Tq);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.SY;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Tg);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Th;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public VideoInfo TA;
        public String TB;
        public String TC;
        public String TD;
        public float TE;
        public AdCloseInfo TF;
        public int Tq;
        public String Tr;
        public String Ts;
        public String Tt;
        public String Tu;
        public int Tv;
        public String Tw;
        public String Tx;
        public String Ty;
        public List<String> Tz = new ArrayList();
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
                this.Tq = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Tr = com.baidu.tbadk.core.util.au.c(goodsInfo.thread_title, 29, "...");
                this.Tt = goodsInfo.thread_pic;
                this.Tu = goodsInfo.pop_window_text;
                this.Tv = goodsInfo.goods_style.intValue();
                this.Tw = goodsInfo.card_desc;
                this.Tx = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Ty = goodsInfo.button_url;
                this.Ts = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Tz.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.TA = goodsInfo.video_info;
                    this.TB = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.TC = goodsInfo.tag_name_url;
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
                    this.TD = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.TE = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.TF = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.Tv == 7 || this.Tv == 9) {
                    if (this.TA != null && !StringUtils.isNull(this.TA.video_url)) {
                        if (this.TA.video_height.intValue() <= 0 || this.TA.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.TA.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.Tv == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.Tv == 2) {
                    return !StringUtils.isNull(this.Tt);
                } else if (this.Tv == 6) {
                    return this.Tz != null && this.Tz.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.Tj.lego_card, true)) {
            return SW;
        }
        if (this.Tj.Tv == 1001) {
            return SK;
        }
        return null;
    }
}
