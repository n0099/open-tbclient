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
public class AdvertAppInfo extends bk {
    public static final BdUniqueId SX = BdUniqueId.gen();
    public static final BdUniqueId SY = BdUniqueId.gen();
    public static final BdUniqueId SZ = BdUniqueId.gen();
    public static final BdUniqueId Ta = BdUniqueId.gen();
    public static final BdUniqueId Tb = BdUniqueId.gen();
    public static final BdUniqueId Tc = BdUniqueId.gen();
    public static final BdUniqueId Td = BdUniqueId.gen();
    public static final BdUniqueId Te = BdUniqueId.gen();
    public static final BdUniqueId Tf = BdUniqueId.gen();
    public static final BdUniqueId Tg = BdUniqueId.gen();
    public static final BdUniqueId Th = BdUniqueId.gen();
    public static final BdUniqueId Ti = BdUniqueId.gen();
    public static final BdUniqueId Tj = BdUniqueId.gen();
    public String SR;
    public String TA;
    private App TB;
    public AppData TC;
    public int Tk;
    public String Tl;
    public String Tm;
    public int Tn;
    public String To;
    public String Tp;
    public String Tq;
    public String Tr;
    public String Ts;
    public int Tt;
    public String Tu;
    public long Tv;
    public String Ty;
    public String Tz;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a Tw = new a();
    public boolean Tx = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        AdvertAppInfo getAdvertAppInfo();

        int getGoodsStyle();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public boolean pv() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.Tw.TI == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.Tl) || TextUtils.isEmpty(this.Tl.trim())) {
            return false;
        }
        int Y = com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.Tw.lego_card) || !(Y == 0 || this.legoCard == null)) {
            if ((TextUtils.isEmpty(this.Tw.lego_card) || bk.Xz.get() || bk.XB.get()) && this.Tw != null && this.Tw.isValid() && this.Tn != 2) {
                return pw() || px();
            }
            return false;
        }
        return false;
    }

    public boolean pw() {
        return (this.Tn != 3 || TextUtils.isEmpty(this.Tq.trim()) || TextUtils.isEmpty(this.Tp.trim()) || this.Tw == null || ((TextUtils.isEmpty(this.Tw.userName) || TextUtils.isEmpty(this.Tw.userName.trim())) && TextUtils.isEmpty(this.Tw.lego_card))) ? false : true;
    }

    public boolean px() {
        if (this.Tw == null || this.Tw.TI != 1001) {
            return this.Tn == 1 && !((TextUtils.isEmpty(this.To) || TextUtils.isEmpty(this.To.trim())) && TextUtils.isEmpty(this.Tw.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ly;
        if (app != null) {
            this.TB = app;
            this.Tl = app.id;
            this.Tm = app.name;
            this.Tn = app.url_type.intValue();
            this.To = app.url;
            this.Tp = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Tq = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.Tr = app.first_name;
            this.Ts = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.Tt = app.plan_id.intValue();
            this.userId = app.user_id;
            this.Tu = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.Tv = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.Tw.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.Tw.lego_card) && (ly = com.baidu.tieba.lego.card.b.ly(this.Tw.lego_card)) != null) {
                ICardInfo viewItem = ly.getViewItem(0, 1);
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

    public String py() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.TC != null) {
            appData = this.TC;
        } else if (this.TB == null) {
            return "";
        } else {
            appData = new AppData(this.TB);
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
        builder.da_good_id = String.valueOf(this.Tw.TD);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Tl;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Tt);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.Tu;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int TD;
        public String TE;
        public String TF;
        public String TG;
        public String TH;
        public int TI;
        public String TJ;
        public String TK;
        public String TL;
        public List<String> TM = new ArrayList();
        public VideoInfo TO;
        public String TP;
        public String TQ;
        public String TR;
        public float TS;
        public AdCloseInfo TT;
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
                this.TD = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.TE = com.baidu.tbadk.core.util.au.c(goodsInfo.thread_title, 29, "...");
                this.TG = goodsInfo.thread_pic;
                this.TH = goodsInfo.pop_window_text;
                this.TI = goodsInfo.goods_style.intValue();
                this.TJ = goodsInfo.card_desc;
                this.TK = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.TL = goodsInfo.button_url;
                this.TF = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.TM.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = com.baidu.tieba.recapp.aa.ph(goodsInfo.lego_card);
                    this.TO = goodsInfo.video_info;
                    this.TP = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.TQ = goodsInfo.tag_name_url;
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
                    this.TR = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.TS = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.TT = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.TI == 7 || this.TI == 9) {
                    if (this.TO != null && !StringUtils.isNull(this.TO.video_url)) {
                        if (this.TO.video_height.intValue() <= 0 || this.TO.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.TO.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.TI == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.TI == 2) {
                    return !StringUtils.isNull(this.TG);
                } else if (this.TI == 6) {
                    return this.TM != null && this.TM.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.Tw.lego_card, true)) {
            return Tj;
        }
        if (this.Tw.TI == 1001) {
            return SX;
        }
        if (this.Tw.TI == 2) {
            return SY;
        }
        if (this.Tw.TI == 6) {
            return SZ;
        }
        if (this.Tw.TI == 7) {
            return Ta;
        }
        if (this.Tw.TI == 9) {
            return Tb;
        }
        return null;
    }
}
