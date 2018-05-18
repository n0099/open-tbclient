package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AdvertAppInfo extends bd {
    public int VK;
    public String VL;
    public String VM;
    public int VN;
    public String VO;
    public String VP;
    public String VQ;
    public int VR;
    public String VS;
    public String VT;
    public int VU;
    public String VV;
    public long VW;
    public String VZ;
    public String Vp;
    public String Wa;
    public String Wb;
    private App Wc;
    public AppData Wd;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public static final BdUniqueId Vu = BdUniqueId.gen();
    public static final BdUniqueId Vv = BdUniqueId.gen();
    public static final BdUniqueId Vw = BdUniqueId.gen();
    public static final BdUniqueId Vx = BdUniqueId.gen();
    public static final BdUniqueId Vy = BdUniqueId.gen();
    public static final BdUniqueId Vz = BdUniqueId.gen();
    public static final BdUniqueId VA = BdUniqueId.gen();
    public static final BdUniqueId VB = BdUniqueId.gen();
    public static final BdUniqueId VC = BdUniqueId.gen();
    public static final BdUniqueId VD = BdUniqueId.gen();
    public static final BdUniqueId VE = BdUniqueId.gen();
    public static final BdUniqueId VF = BdUniqueId.gen();
    public static final BdUniqueId VG = BdUniqueId.gen();
    public static final BdUniqueId VH = BdUniqueId.gen();
    public static final BdUniqueId VI = BdUniqueId.gen();
    public static AtomicBoolean VJ = new AtomicBoolean(false);
    public a VX = new a();
    public boolean VY = false;
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

    public int qr() {
        if (bd.ZS.get() && VJ.get()) {
            if (StringUtils.isNull(this.adPosition)) {
                return 23;
            }
            if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (this.VX == null || this.VX.Wj != 1001) {
                if (this.VX == null || TextUtils.isEmpty(this.VX.lego_card)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.VL) || TextUtils.isEmpty(this.VL.trim())) {
                    return 24;
                }
                if (this.legoCard == null || !this.VX.isValid()) {
                    return 32;
                }
                if ((this.legoCard instanceof ILegoAdvert) && !com.baidu.tbadk.core.i.pX().qd() && !this.legoCard.isNoPicAd()) {
                    return 34;
                }
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (this.VX == null || !this.VX.isValid()) {
                    return 25;
                }
                if (this.legoCard.getGoodsStyle() == 11) {
                    return this.legoCard.checkLegal(this.VN);
                }
                if (this.VN == 3) {
                    if (!qs()) {
                        return 26;
                    }
                } else if (this.VN == 1) {
                    if (!qt()) {
                        return 27;
                    }
                } else {
                    return 21;
                }
                return 0;
            }
            return 0;
        }
        return 31;
    }

    public boolean qs() {
        boolean z = true;
        if (this.VX == null || this.VX.Wj != 1001) {
            if (this.legoCard != null && this.legoCard.getGoodsStyle() == 11) {
                if (this.VN != 3 || this.legoCard.checkLegal(this.VN) != 0) {
                    z = false;
                }
                return z;
            } else if (this.VN != 3 || TextUtils.isEmpty(this.VQ.trim()) || TextUtils.isEmpty(this.VP.trim()) || this.VX == null) {
                return false;
            } else {
                return ((TextUtils.isEmpty(this.VX.userName) || TextUtils.isEmpty(this.VX.userName.trim())) && TextUtils.isEmpty(this.VX.lego_card)) ? false : true;
            }
        }
        return false;
    }

    public boolean qt() {
        if (this.VX == null || this.VX.Wj != 1001) {
            if (this.VX == null || this.VX.Wj != -1001) {
                return (this.legoCard == null || this.legoCard.getGoodsStyle() != 11) ? this.VN == 1 && !((TextUtils.isEmpty(this.VO) || TextUtils.isEmpty(this.VO.trim())) && TextUtils.isEmpty(this.VX.lego_card)) : this.VN == 1 && this.legoCard.checkLegal(this.VN) == 0;
            }
            return true;
        }
        return true;
    }

    public void a(App app) {
        ICardInfo oy;
        if (app != null) {
            this.Wc = app;
            this.Wd = new AppData(app);
            this.VL = app.id;
            this.VM = app.name;
            this.VN = app.url_type.intValue();
            this.VO = app.url;
            this.VP = app.apk_url;
            this.deepUrl = app.deep_url;
            this.VQ = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = "3";
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.VR = app.pos.intValue();
            this.VS = app.first_name;
            this.VT = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.VU = app.plan_id.intValue();
            this.userId = app.user_id;
            this.VV = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.VW = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.VX.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.VX.lego_card) && (oy = com.baidu.tieba.lego.card.b.oy(this.VX.lego_card)) != null) {
                ICardInfo viewItem = oy.getViewItem(0, 1);
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

    public String adCollect() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.Wd != null) {
            appData = this.Wd;
        } else if (this.Wc == null) {
            return "";
        } else {
            appData = new AppData(this.Wc);
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
        builder.da_good_id = String.valueOf(this.VX.We);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.VL;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.VU);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.VV;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int We;
        public String Wf;
        public String Wg;
        public String Wh;
        public String Wi;
        public int Wj;
        public String Wk;
        public String Wl;
        public String Wm;
        public List<String> Wn = new ArrayList();
        public VideoInfo Wo;
        public String Wp;
        public String Wq;
        public float Wr;
        public AdCloseInfo Ws;
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
                this.We = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.Wf = com.baidu.tbadk.core.util.an.d(goodsInfo.thread_title, 29, "...");
                this.Wh = goodsInfo.thread_pic;
                this.Wi = goodsInfo.pop_window_text;
                this.Wj = goodsInfo.goods_style.intValue();
                this.Wk = goodsInfo.card_desc;
                this.Wl = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.Wm = goodsInfo.button_url;
                this.Wg = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.Wn.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.Wo = goodsInfo.video_info;
                    this.tagName = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Wp = goodsInfo.tag_name_url;
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
                    this.Wq = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.an.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Wr = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    this.Ws = goodsInfo.close_info;
                }
            }
        }

        public boolean isValid() {
            return com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.lego_card);
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.VX.Wj == 1001 || this.VX.Wj == -1001) {
            return Vu;
        }
        if (!com.baidu.tbadk.core.i.pX().qd() && this.legoCard != null && !this.legoCard.isNoPicAd()) {
            return Vu;
        }
        if (this.legoCard != null) {
            BdUniqueId bdUniqueId = VD;
            switch (this.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return VE;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return VF;
                case 7:
                    return VG;
                case 9:
                    return VI;
                case 10:
                    return VH;
            }
        }
        return null;
    }
}
