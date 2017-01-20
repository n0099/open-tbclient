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
public class c extends bh {
    public static final BdUniqueId Og = BdUniqueId.gen();
    public static final BdUniqueId Oh = BdUniqueId.gen();
    public static final BdUniqueId Oi = BdUniqueId.gen();
    public static final BdUniqueId Oj = BdUniqueId.gen();
    public static final BdUniqueId Ok = BdUniqueId.gen();
    public static final BdUniqueId Ol = BdUniqueId.gen();
    public static final BdUniqueId Om = BdUniqueId.gen();
    public static final BdUniqueId On = BdUniqueId.gen();
    public static final BdUniqueId Oo = BdUniqueId.gen();
    public static final BdUniqueId Op = BdUniqueId.gen();
    public static final BdUniqueId Oq = BdUniqueId.gen();
    public static final BdUniqueId Or = BdUniqueId.gen();
    public static final BdUniqueId Os = BdUniqueId.gen();
    public String OA;
    public String OB;
    public int OC;
    public String OD;
    public long OE;
    public String OH;
    public String OI;
    public String OJ;
    private App OL;
    public AppData OM;
    public String Oa;
    public int Ot;
    public String Ou;
    public String Ov;
    public int Ow;
    public String Ox;
    public String Oy;
    public String Oz;
    public String abtest;
    public String adPosition;
    public b advertAppContext;
    public int cpid;
    public String deepUrl;
    public String extensionInfo;
    public String price;
    public String userId;
    public a OF = new a();
    public boolean OG = false;
    public ICardInfo legoCard = null;

    public boolean pc() {
        if (StringUtils.isNull(this.adPosition)) {
            return false;
        }
        if (this.OF.OT == 1001) {
            return true;
        }
        if (TextUtils.isEmpty(this.Ou) || TextUtils.isEmpty(this.Ou.trim())) {
            return false;
        }
        int ac = com.baidu.adp.lib.b.e.dL().ac("is_support_lego_ad_style");
        if (TextUtils.isEmpty(this.OF.lego_card) || !(ac == 0 || this.legoCard == null)) {
            if ((TextUtils.isEmpty(this.OF.lego_card) || bh.SD.get() || bh.SF.get()) && this.OF != null && this.OF.isValid() && this.Ow != 2) {
                return pd() || pe();
            }
            return false;
        }
        return false;
    }

    public boolean pd() {
        return (this.Ow != 3 || TextUtils.isEmpty(this.Oz.trim()) || TextUtils.isEmpty(this.Oy.trim()) || this.OF == null || ((TextUtils.isEmpty(this.OF.userName) || TextUtils.isEmpty(this.OF.userName.trim())) && TextUtils.isEmpty(this.OF.lego_card))) ? false : true;
    }

    public boolean pe() {
        if (this.OF == null || this.OF.OT != 1001) {
            return this.Ow == 1 && !((TextUtils.isEmpty(this.Ox) || TextUtils.isEmpty(this.Ox.trim())) && TextUtils.isEmpty(this.OF.lego_card));
        }
        return true;
    }

    public void a(App app) {
        ICardInfo lM;
        if (app != null) {
            this.OL = app;
            this.Ou = app.id;
            this.Ov = app.name;
            this.Ow = app.url_type.intValue();
            this.Ox = app.url;
            this.Oy = app.apk_url;
            this.deepUrl = app.deep_url;
            this.Oz = app.apk_name;
            if (TextUtils.isEmpty(app.pos_name) || TextUtils.isEmpty(app.pos_name.trim())) {
                this.adPosition = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
            } else {
                this.adPosition = app.pos_name.trim();
            }
            this.OA = app.first_name;
            this.OB = app.second_name;
            this.cpid = app.cpid.intValue();
            this.abtest = app.abtest;
            this.OC = app.plan_id.intValue();
            this.userId = app.user_id;
            this.OD = app.verify;
            this.price = app.price;
            this.extensionInfo = app.ext_info;
            this.OE = app.app_time.intValue() * 1000;
            if (app.goods_info != null) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        this.OF.a(next);
                        break;
                    }
                }
            }
            if (com.baidu.adp.lib.b.e.dL().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.OF.lego_card) && (lM = com.baidu.tieba.lego.card.b.lM(this.OF.lego_card)) != null) {
                this.legoCard = lM.getViewItem(0, 1);
                this.legoCard.setAdvertAppInfo(this);
            }
        }
    }

    public String pf() {
        AppData appData;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.OM != null) {
            appData = this.OM;
        } else if (this.OL == null) {
            return "";
        } else {
            appData = new AppData(this.OL);
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
        builder.da_good_id = String.valueOf(this.OF.OO);
        builder.da_locate = String.valueOf(this.adPosition);
        builder.da_obj_id = this.Ou;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.OC);
        builder.da_price = this.price;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.userId;
        builder.da_verify = this.OD;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i);
        return builder.build(false);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int OO;
        public String OP;
        public String OQ;
        public String OR;
        public String OS;
        public int OT;
        public String OU;
        public String OV;
        public String OW;
        public List<String> OX = new ArrayList();
        public VideoInfo OY;
        public String OZ;
        public String Pa;
        public String Pc;
        public float Pd;
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
                this.OO = goodsInfo.id.intValue();
                this.userName = goodsInfo.user_name;
                this.userPortrait = goodsInfo.user_portrait;
                this.OP = com.baidu.tbadk.core.util.at.c(goodsInfo.thread_title, 29, "...");
                this.OR = goodsInfo.thread_pic;
                this.OS = goodsInfo.pop_window_text;
                this.OT = goodsInfo.goods_style.intValue();
                this.OU = goodsInfo.card_desc;
                this.OV = goodsInfo.card_tag;
                this.buttonText = goodsInfo.button_text;
                this.OW = goodsInfo.button_url;
                this.OQ = goodsInfo.thread_content;
                this.height = goodsInfo.height.intValue();
                this.width = goodsInfo.width.intValue();
                this.needResize = goodsInfo.label_measure.intValue() == 2;
                if (goodsInfo.thread_pic_list != null) {
                    for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                        if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                            this.OX.add(threadPicList.pic);
                        }
                    }
                    this.lego_card = goodsInfo.lego_card;
                    this.OY = goodsInfo.video_info;
                    this.OZ = goodsInfo.tag_name;
                    this.adSource = goodsInfo.ad_source;
                    this.Pa = goodsInfo.tag_name_url;
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
                    this.Pc = goodsInfo.brand_icon;
                    String str2 = goodsInfo.brand_icon_wh;
                    if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                        try {
                            String[] split2 = str2.split(",");
                            int g3 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                            int g4 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                            if (g4 != 0) {
                                this.Pd = g3 / g4;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
            }
        }

        public boolean isValid() {
            if (com.baidu.adp.lib.b.e.dL().ac("is_support_lego_ad_style") != 1 || TextUtils.isEmpty(this.lego_card)) {
                if (this.OT == 7 || this.OT == 9) {
                    if (this.OY != null && !StringUtils.isNull(this.OY.video_url)) {
                        if (this.OY.video_height.intValue() <= 0 || this.OY.video_width.intValue() <= 0) {
                            return false;
                        }
                        if (this.OY.video_duration.intValue() <= 0) {
                            return false;
                        }
                        return (this.OT == 9 && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) == null) ? false : true;
                    }
                    return false;
                } else if (this.OT == 2) {
                    return !StringUtils.isNull(this.OR);
                } else if (this.OT == 6) {
                    return this.OX != null && this.OX.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (!StringUtils.isNull(this.OF.lego_card, true)) {
            return Os;
        }
        if (this.OF.OT == 1001) {
            return Og;
        }
        if (this.OF.OT == 2) {
            return Oh;
        }
        if (this.OF.OT == 6) {
            return Oi;
        }
        if (this.OF.OT == 7) {
            return Oj;
        }
        if (this.OF.OT == 9) {
            return Ok;
        }
        return null;
    }
}
