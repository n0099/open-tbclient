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
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bj {
    public static final BdUniqueId Tk = BdUniqueId.gen();
    public static final BdUniqueId Tl = BdUniqueId.gen();
    public static final BdUniqueId Tm = BdUniqueId.gen();
    public static final BdUniqueId Tn = BdUniqueId.gen();
    public static final BdUniqueId To = BdUniqueId.gen();
    public static final BdUniqueId Tp = BdUniqueId.gen();
    public static final BdUniqueId Tq = BdUniqueId.gen();
    public static final BdUniqueId Tr = BdUniqueId.gen();
    public static final BdUniqueId Ts = BdUniqueId.gen();
    public static final BdUniqueId Tt = BdUniqueId.gen();
    public static final BdUniqueId Tu = BdUniqueId.gen();
    public static final BdUniqueId Tv = BdUniqueId.gen();
    public static final BdUniqueId Tw = BdUniqueId.gen();
    public int TA;
    public String TB;
    public String TC;
    public String TD;
    public String TE;
    public String TF;
    public int TG;
    public String TH;
    public long TI;
    public String TL;
    public String TM;
    public String TO;
    private App TP;
    public AppData TQ;
    public String Te;
    public int Tx;
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
    public a TJ = new a();
    public boolean TK = false;
    public ILegoAdvert legoCard = null;

    /* loaded from: classes.dex */
    public interface ILegoAdvert extends ICardInfo {
        AdvertAppInfo getAdvertAppInfo();

        void refreshReservation(Object obj);

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    public boolean pq() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.TJ.TW == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.Ty) || TextUtils.isEmpty(this.Ty.trim())) {
            return false;
        }
        int ab = com.baidu.adp.lib.b.e.eT().ab("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.TJ.lego_card) || !(ab == 0 || this.legoCard == null)) {
            if ((TextUtils.isEmpty(this.TJ.lego_card) || bj.XQ.get() || bj.XS.get()) && this.TJ != null && this.TJ.isValid() && this.TA != 2) {
                return pr() || ps();
            }
            return false;
        }
        return false;
    }

    public boolean pr() {
        return (this.TA != 3 || TextUtils.isEmpty(this.TD.trim()) || TextUtils.isEmpty(this.TC.trim()) || this.TJ == null || ((TextUtils.isEmpty(this.TJ.userName) || TextUtils.isEmpty(this.TJ.userName.trim())) && TextUtils.isEmpty(this.TJ.lego_card))) ? false : true;
    }

    public boolean ps() {
        if (this.TJ == null || this.TJ.TW != 1001) {
            return this.TA == 1 && !((TextUtils.isEmpty(this.TB) || TextUtils.isEmpty(this.TB.trim())) && TextUtils.isEmpty(this.TJ.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo ln;
        if (app != null) {
            this.TP = app;
            this.Ty = app.id;
            this.Tz = app.name;
            this.TA = app.url_type.intValue();
            this.TB = app.url;
            this.TC = app.apk_url;
            this.deepUrl = app.deep_url;
            this.TD = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.TE = app.first_name;
            this.TF = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.TG = app.plan_id.intValue();
            this.userId = app.user_id;
            this.TH = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.TI = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.TJ.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.eT().ab("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.TJ.lego_card) && (ln = com.baidu.tieba.lego.card.b.ln(this.TJ.lego_card)) != null) {
                ICardInfo viewItem = ln.getViewItem(0, 1);
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

    public String pt() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.TQ != null) {
            appData = this.TQ;
        } else if (this.TP == null) {
            return "";
        } else {
            appData = new AppData(this.TP);
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
        builder.da_good_id = String.valueOf(this.TJ.TR);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Ty;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.TG);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.TH;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int TR;
        public String TS;
        public String TT;
        public String TU;
        public String TV;
        public int TW;
        public String TX;
        public String TY;
        public String TZ;
        public List<String> Ua = new ArrayList();
        public VideoInfo Ub;
        public String Uc;
        public String Ud;
        public String Ue;
        public float Uf;
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
                this.TR = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.TS = com.baidu.tbadk.core.util.au.c(goodsInfo.thread_title, 29, "...");
                this.TU = goodsInfo.thread_pic;
                this.TV = goodsInfo.pop_window_text;
                this.TW = goodsInfo.goods_style.intValue();
                this.TX = goodsInfo.card_desc;
                this.TY = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.TZ = goodsInfo.button_url;
                this.TT = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Ua.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Ub = goodsInfo.video_info;
                    this.Uc = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Ud = goodsInfo.tag_name_url;
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
                    this.Ue = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Uf = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.eT().ab("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.TW == 7 || this.TW == 9) {
                    if (this.Ub != null && !StringUtils.isNull(this.Ub.video_url)) {
                        if (this.Ub.video_height.intValue() <= 0 || this.Ub.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.Ub.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.TW == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.TW == 2) {
                    return !StringUtils.isNull(this.TU);
                } else if (this.TW == 6) {
                    return this.Ua != null && this.Ua.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.TJ.lego_card, true)) {
            return Tw;
        }
        if (this.TJ.TW == 1001) {
            return Tk;
        }
        if (this.TJ.TW == 2) {
            return Tl;
        }
        if (this.TJ.TW == 6) {
            return Tm;
        }
        if (this.TJ.TW == 7) {
            return Tn;
        }
        if (this.TJ.TW == 9) {
            return To;
        }
        return null;
    }
}
