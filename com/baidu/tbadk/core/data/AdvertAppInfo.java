package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.components.downloader.OAdSqlLiteHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.c.e.m.b;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.c;
import d.a.i0.r.q.d;
import d.a.i0.r.q.m0;
import d.a.j0.s2.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.LogTogether.AdReq;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdvertAppInfo extends a2 implements m0 {
    public static final BdUniqueId h4 = BdUniqueId.gen();
    public static final BdUniqueId i4;
    public static final BdUniqueId j4;
    public static final BdUniqueId k4;
    public static final BdUniqueId l4;
    public static final BdUniqueId m4;
    public static final BdUniqueId n4;
    public static final BdUniqueId o4;
    public static final BdUniqueId p4;
    public static final BdUniqueId q4;
    public static final BdUniqueId r4;
    public static final BdUniqueId s4;
    public static AtomicBoolean t4;
    public String E3;
    public String F3;
    public int G3;
    public String H3;
    public String I3;
    public String J3;
    public String K3;
    public String L3;
    public String M3;
    public int N3;
    public String O3;
    public String P3;
    public int Q3;
    public String R3;
    public String S3;
    public String T3;
    public d Y3;
    public String Z3;
    public String a4;
    public String b4;
    public String c4;
    public App d4;
    public AppData e4;
    public a U3 = new a();
    public boolean V3 = false;
    public ILegoAdvert W3 = null;
    public int X3 = 32;
    public boolean f4 = false;
    public boolean g4 = false;

    /* loaded from: classes3.dex */
    public interface ILegoAdvert extends ICardInfo {
        int checkLegal(int i2);

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c getAppInfoModel();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, d.a.c.j.e.n
        /* synthetic */ BdUniqueId getType();

        boolean isNoPicAd();

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12787a;

        /* renamed from: b  reason: collision with root package name */
        public String f12788b;

        /* renamed from: c  reason: collision with root package name */
        public String f12789c;

        /* renamed from: d  reason: collision with root package name */
        public String f12790d;

        /* renamed from: e  reason: collision with root package name */
        public String f12791e;

        /* renamed from: f  reason: collision with root package name */
        public String f12792f;

        /* renamed from: g  reason: collision with root package name */
        public String f12793g;

        /* renamed from: h  reason: collision with root package name */
        public int f12794h;

        /* renamed from: i  reason: collision with root package name */
        public String f12795i;
        public String j;
        public List<String> k = new ArrayList(3);
        public String l;
        public VideoInfo m;
        public String n;
        public String o;
        public String p;
        public float q;
        public AdCloseInfo r;

        public static List<String> c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(3);
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("thread_pic_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public boolean a() {
            return SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !TextUtils.isEmpty(this.l);
        }

        public void b(GoodsInfo goodsInfo) {
            List<String> c2;
            List<String> list;
            if (goodsInfo == null) {
                return;
            }
            this.f12787a = goodsInfo.id.intValue();
            this.f12788b = goodsInfo.user_name;
            this.f12789c = goodsInfo.user_portrait;
            this.f12790d = StringHelper.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
            this.f12792f = goodsInfo.thread_pic;
            this.f12793g = goodsInfo.pop_window_text;
            this.f12794h = goodsInfo.goods_style.intValue();
            String str = goodsInfo.card_desc;
            String str2 = goodsInfo.card_tag;
            this.f12795i = goodsInfo.button_text;
            String str3 = goodsInfo.button_url;
            String str4 = goodsInfo.thread_content;
            goodsInfo.height.intValue();
            goodsInfo.width.intValue();
            goodsInfo.label_measure.intValue();
            List<ThreadPicList> list2 = goodsInfo.thread_pic_list;
            if (list2 == null) {
                return;
            }
            for (ThreadPicList threadPicList : list2) {
                if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                    this.k.add(threadPicList.pic);
                }
            }
            if (ListUtils.isEmpty(this.k) && (c2 = c(goodsInfo.lego_card)) != null && (list = this.k) != null) {
                list.addAll(c2);
            }
            this.l = goodsInfo.lego_card;
            VideoInfo videoInfo = goodsInfo.video_info;
            this.n = goodsInfo.tag_name;
            this.o = goodsInfo.ad_source;
            String str5 = goodsInfo.tag_name_url;
            String str6 = goodsInfo.tag_name_wh;
            if (str6 != null) {
                try {
                    String[] split = str6.split(",");
                    b.d(split[0], 1);
                    b.d(split[1], 1);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            String str7 = goodsInfo.brand_icon;
            String str8 = goodsInfo.brand_icon_wh;
            if (!k.isEmpty(str8)) {
                try {
                    String[] split2 = str8.split(",");
                    b.d(split2[0], 1);
                    b.d(split2[1], 1);
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
            }
            this.r = goodsInfo.close_info;
        }
    }

    static {
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        i4 = BdUniqueId.gen();
        j4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        k4 = BdUniqueId.gen();
        l4 = BdUniqueId.gen();
        m4 = BdUniqueId.gen();
        n4 = BdUniqueId.gen();
        o4 = BdUniqueId.gen();
        p4 = BdUniqueId.gen();
        q4 = BdUniqueId.gen();
        r4 = BdUniqueId.gen();
        s4 = BdUniqueId.gen();
        t4 = new AtomicBoolean(false);
    }

    @NonNull
    public static AdvertAppInfo G4(@NonNull JSONObject jSONObject) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        advertAppInfo.U3.f12794h = jSONObject.optInt("goods_style");
        JSONObject optJSONObject = jSONObject.optJSONObject(AdDebugActivity.KEY_LEGO);
        advertAppInfo.U3.l = optJSONObject.toString();
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("ad_common");
        if (optJSONObject2 != null) {
            advertAppInfo.E3 = optJSONObject2.optString("id");
            advertAppInfo.G3 = optJSONObject2.optInt("url_type");
            advertAppInfo.T3 = optJSONObject2.optString("ext_info");
            advertAppInfo.H3 = optJSONObject2.optString("scheme");
            advertAppInfo.F3 = optJSONObject2.optString("user_name");
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject3 != null) {
            advertAppInfo.J3 = optJSONObject3.optString("apk_name");
            advertAppInfo.I3 = optJSONObject3.optString("apk_url");
        }
        advertAppInfo.I4(jSONObject.optJSONObject(AdDebugActivity.KEY_LEGO));
        return advertAppInfo;
    }

    public AdReq A4(String str, long j, String str2, String str3, int i2) {
        AdReq.Builder builder = new AdReq.Builder();
        builder.da_cpid = String.valueOf(this.N3);
        builder.da_ext_info = this.T3;
        builder.da_fid = Integer.valueOf(b.d(str, 0));
        builder.da_good_id = String.valueOf(this.U3.f12787a);
        builder.da_locate = String.valueOf(this.K3);
        builder.da_obj_id = this.E3;
        builder.da_page = str2;
        builder.da_threadid = Long.valueOf(j);
        builder.da_plan_id = String.valueOf(this.Q3);
        builder.da_price = this.O3;
        builder.da_task = "tbda";
        builder.da_type = str3;
        builder.da_user_id = this.R3;
        builder.da_verify = this.S3;
        builder.da_utime = Long.valueOf(System.currentTimeMillis() / 1000);
        builder.da_pn = Integer.valueOf(i2);
        return builder.build(false);
    }

    public boolean B4() {
        a aVar;
        a aVar2 = this.U3;
        if (aVar2 == null || aVar2.f12794h != 1001) {
            ILegoAdvert iLegoAdvert = this.W3;
            if (iLegoAdvert == null || iLegoAdvert.getGoodsStyle() != 11) {
                return (this.G3 != 3 || TextUtils.isEmpty(this.J3) || TextUtils.isEmpty(this.I3) || (aVar = this.U3) == null || TextUtils.isEmpty(aVar.l)) ? false : true;
            }
            int i2 = this.G3;
            return i2 == 3 && this.W3.checkLegal(i2) == 0;
        }
        return false;
    }

    public boolean C4() {
        ILegoAdvert iLegoAdvert = this.W3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    public boolean D4() {
        a aVar = this.U3;
        if (aVar == null || aVar.f12794h != 1001) {
            a aVar2 = this.U3;
            if (aVar2 == null || aVar2.f12794h != -1001) {
                ILegoAdvert iLegoAdvert = this.W3;
                if (iLegoAdvert == null || iLegoAdvert.getGoodsStyle() != 11) {
                    return this.G3 == 1 && !((TextUtils.isEmpty(this.H3) || TextUtils.isEmpty(this.H3.trim())) && TextUtils.isEmpty(this.U3.l));
                }
                int i2 = this.G3;
                return i2 == 1 && this.W3.checkLegal(i2) == 0;
            }
            return true;
        }
        return true;
    }

    public int E4() {
        JSONObject jSONObject;
        if (!a2.u3.get()) {
            x.A();
            return 31;
        } else if (!t4.get()) {
            x.A();
            return 31;
        } else if (TextUtils.equals("PB_BANNER", this.c4) || !StringUtils.isNull(this.K3)) {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            a aVar = this.U3;
            if (aVar == null || aVar.f12794h != 1001) {
                a aVar2 = this.U3;
                if (aVar2 == null || TextUtils.isEmpty(aVar2.l)) {
                    return 11;
                }
                if (TextUtils.isEmpty(this.E3) || TextUtils.isEmpty(this.E3.trim())) {
                    return 24;
                }
                if (this.W3 != null && this.U3.a()) {
                    if (!(this.W3 instanceof ILegoAdvert) || d.a.i0.r.k.c().g() || this.W3.isNoPicAd()) {
                        if (this.W3.getCardType() == 12) {
                            return 12;
                        }
                        a aVar3 = this.U3;
                        if (aVar3 == null || !aVar3.a()) {
                            return 25;
                        }
                        if (this.W3.getGoodsStyle() == 11) {
                            return 12;
                        }
                        int i2 = this.G3;
                        if (i2 == 3) {
                            if (!B4()) {
                                return 26;
                            }
                        } else if (i2 != 1) {
                            return 21;
                        } else {
                            if (!D4()) {
                                return 27;
                            }
                        }
                        if (this.W3.getCardType() == 25 || this.W3.getCardType() == 10 || this.W3.getCardType() == 9) {
                            return 37;
                        }
                        return (this.W3.getAppInfoModel() == null || c.c(this.W3.getAppInfoModel())) ? 0 : 42;
                    }
                    return 34;
                }
                try {
                    jSONObject = new JSONObject(this.U3.l);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (jSONObject.optInt("card_type") == 99) {
                    return 41;
                }
                if (jSONObject.optInt("direct_download_switch") == 1) {
                    return 43;
                }
                return this.X3;
            }
            return 0;
        } else {
            return 23;
        }
    }

    public boolean F4() {
        ILegoAdvert iLegoAdvert = this.W3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public void H4(App app) {
        if (app == null) {
            return;
        }
        this.d4 = app;
        this.e4 = new AppData(app);
        this.E3 = app.id;
        this.F3 = app.name;
        this.G3 = app.url_type.intValue();
        this.H3 = app.url;
        this.I3 = app.apk_url;
        String str = app.deep_url;
        this.J3 = app.apk_name;
        if (!TextUtils.isEmpty(app.pos_name) && !TextUtils.isEmpty(app.pos_name.trim())) {
            this.K3 = app.pos_name.trim();
        } else {
            this.K3 = "3";
        }
        this.position = b.d(app.pos_name, -1) - 1;
        app.pos.intValue();
        this.L3 = app.first_name;
        this.M3 = app.second_name;
        this.N3 = app.cpid.intValue();
        this.P3 = app.abtest;
        this.Q3 = app.plan_id.intValue();
        this.R3 = app.user_id;
        this.S3 = app.verify;
        this.O3 = app.price;
        this.T3 = app.ext_info;
        app.app_time.intValue();
        List<GoodsInfo> list = app.goods_info;
        if (list != null) {
            Iterator<GoodsInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GoodsInfo next = it.next();
                if (next != null) {
                    this.U3.b(next);
                    break;
                }
            }
        }
        if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || TextUtils.isEmpty(this.U3.l)) {
            return;
        }
        try {
            ICardInfo k = d.a.j0.j1.o.b.k(this.U3.l);
            if (k != null) {
                ICardInfo viewItem = k.getViewItem(0, 1);
                if (viewItem instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) viewItem;
                    this.W3 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                    return;
                }
                this.W3 = null;
                StringBuilder sb = new StringBuilder();
                sb.append("Got invalid card for ad, ");
                sb.append(viewItem == null ? "null ad" : String.valueOf(viewItem));
                BdLog.e(sb.toString());
            }
        } catch (Exception e2) {
            if (e2 instanceof JSONException) {
                this.X3 = 38;
            } else if (e2 instanceof CardParseException) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.X3 = 40;
                } else {
                    this.X3 = 39;
                }
            }
            this.W3 = null;
        }
    }

    public void I4(JSONObject jSONObject) {
        try {
            jSONObject.put("card_type", 88);
            ICardInfo j = d.a.j0.j1.o.b.j(jSONObject);
            if (j instanceof ILegoAdvert) {
                ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                this.W3 = iLegoAdvert;
                iLegoAdvert.setAdvertAppInfo(this);
            }
        } catch (CardParseException | JSONException unused) {
        }
    }

    @Override // d.a.i0.r.q.m0
    public boolean b() {
        return this.f4;
    }

    @Override // d.a.i0.r.q.m0
    public int d() {
        return this.position;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.E3, this.E3) && TextUtils.equals(advertAppInfo.T3, this.T3);
        }
        return false;
    }

    @Override // d.a.i0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        ILegoAdvert iLegoAdvert;
        int i2 = this.U3.f12794h;
        if (i2 != 1001 && i2 != -1001) {
            if (!d.a.i0.r.k.c().g() && (iLegoAdvert = this.W3) != null && !iLegoAdvert.isNoPicAd()) {
                return h4;
            }
            ILegoAdvert iLegoAdvert2 = this.W3;
            if (iLegoAdvert2 != null) {
                BdUniqueId bdUniqueId = k4;
                int goodsStyle = iLegoAdvert2.getGoodsStyle();
                if (goodsStyle != 2) {
                    if (goodsStyle != 6) {
                        if (goodsStyle != 7) {
                            if (goodsStyle != 8) {
                                switch (goodsStyle) {
                                    case 12:
                                        return s4;
                                    case 13:
                                        return r4;
                                    case 14:
                                        break;
                                    default:
                                        return bdUniqueId;
                                }
                            }
                        }
                        return q4;
                    }
                    return p4;
                }
                return o4;
            }
            return null;
        }
        return h4;
    }

    public int hashCode() {
        String str = this.E3;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.T3;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // d.a.i0.r.q.m0
    public AdvertAppInfo j() {
        return this;
    }

    @Override // d.a.i0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.f4 = true;
    }

    public String z4() {
        JSONObject jSONObject = new JSONObject();
        AppData appData = this.e4;
        if (appData == null) {
            App app = this.d4;
            if (app == null) {
                return "";
            }
            appData = new AppData(app);
        }
        if (appData.fillInJsonObject(jSONObject)) {
            byte[] bytes = jSONObject.toString().getBytes();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bytes[i2] = (byte) (bytes[i2] ^ 47);
            }
            return new String(d.a.c.e.p.c.m(bytes));
        }
        return "";
    }
}
