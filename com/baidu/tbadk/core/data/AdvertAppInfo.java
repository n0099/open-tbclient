package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.downloader.OAdSqlLiteHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.c;
import d.a.m0.r.q.d;
import d.a.m0.r.q.m0;
import d.a.n0.k1.o.b;
import d.a.n0.k1.o.k.a;
import d.a.n0.t2.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes3.dex */
public class AdvertAppInfo extends a2 implements m0 {
    public static AtomicBoolean Z3 = new AtomicBoolean(false);
    public static final BdUniqueId a4 = BdUniqueId.gen();
    public static final BdUniqueId b4;
    public static final BdUniqueId c4;
    public static final BdUniqueId d4;
    public static final BdUniqueId e4;
    public static final BdUniqueId f4;
    public static final BdUniqueId g4;
    public static final BdUniqueId h4;
    public static final BdUniqueId i4;
    public static final BdUniqueId j4;
    public static final BdUniqueId k4;
    public static final BdUniqueId l4;
    public String G3;
    public int H3;
    public int I3;
    public String J3;
    public String M3;
    public String N3;
    public d P3;
    public String Q3;
    public App S3;
    public String T3;
    public String U3;
    public int V3;
    public String W3;
    public String X3;
    public String Y3;
    public boolean K3 = false;
    public boolean L3 = false;
    public ILegoAdvert O3 = null;
    public int R3 = 32;

    /* loaded from: classes3.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        int checkLegal(int i2);

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, d.a.c.j.e.n
        /* synthetic */ BdUniqueId getType();

        boolean isNoPicAd();

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    static {
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        b4 = BdUniqueId.gen();
        c4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        d4 = BdUniqueId.gen();
        e4 = BdUniqueId.gen();
        f4 = BdUniqueId.gen();
        g4 = BdUniqueId.gen();
        h4 = BdUniqueId.gen();
        i4 = BdUniqueId.gen();
        j4 = BdUniqueId.gen();
        k4 = BdUniqueId.gen();
        l4 = BdUniqueId.gen();
    }

    @NonNull
    public static AdvertAppInfo K4(@NonNull JSONObject jSONObject) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        advertAppInfo.I3 = jSONObject.optInt("goods_style");
        JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
        advertAppInfo.J3 = optJSONObject.toString();
        advertAppInfo.L4(optJSONObject);
        return advertAppInfo;
    }

    public String C4() {
        return this.N3;
    }

    public void D4(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("card_type", Integer.valueOf(this.H3));
            ICardInfo j = b.j(jSONObject);
            if (j instanceof ILegoAdvert) {
                ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                this.O3 = iLegoAdvert;
                iLegoAdvert.setAdvertAppInfo(this);
            }
        } catch (CardParseException e2) {
            if (e2.getCause() instanceof IllegalStateException) {
                this.R3 = 40;
            } else {
                this.R3 = 39;
            }
        } catch (JSONException unused) {
        }
    }

    public boolean E4() {
        ILegoAdvert iLegoAdvert;
        if (this.I3 == 1001 || this.V3 != 3 || (iLegoAdvert = this.O3) == null) {
            return false;
        }
        return iLegoAdvert.checkIsAppAdvert();
    }

    public boolean F4() {
        ILegoAdvert iLegoAdvert = this.O3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    public boolean G4() {
        int i2 = this.I3;
        if (i2 == 1001 || i2 == -1001) {
            return true;
        }
        return (this.V3 != 1 || TextUtils.isEmpty(this.W3) || TextUtils.isEmpty(this.W3.trim())) ? false : true;
    }

    public int H4() {
        int i2;
        if (!a2.w3.get()) {
            y.A();
            return 31;
        } else if (!Z3.get()) {
            y.A();
            return 31;
        } else if (TextUtils.equals("PB_BANNER", this.Q3) || TextUtils.equals("PIC_PAGE_BANNER", this.Q3) || !TextUtils.isEmpty(this.M3)) {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            int i3 = this.I3;
            if (i3 == 1001) {
                return 0;
            }
            if (i3 == 11 || (i2 = this.H3) == 31) {
                return 12;
            }
            if (i2 == 25 || i2 == 10 || i2 == 9) {
                return 37;
            }
            if (i2 == 99) {
                return 41;
            }
            if (i2 == 26) {
                return 45;
            }
            if (this.O3 == null) {
                return this.R3;
            }
            if (TextUtils.isEmpty(this.G3) || TextUtils.isEmpty(this.G3.trim())) {
                return 24;
            }
            if (this.O3.getAppInfoModel() == null || c.c(this.O3.getAppInfoModel())) {
                if (k.c().g() || this.O3.isNoPicAd()) {
                    int i5 = this.V3;
                    if (i5 == 3 || i5 == 1) {
                        if (this.V3 == 3) {
                            if (!E4()) {
                                return 26;
                            }
                            try {
                                JSONObject optJSONObject = new JSONObject(this.J3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                if (optJSONObject != null) {
                                    if (optJSONObject.optBoolean("direcrt_download")) {
                                        return 43;
                                    }
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return (this.V3 != 1 || G4()) ? 0 : 27;
                    }
                    return 21;
                }
                return 34;
            }
            return 42;
        } else {
            return 23;
        }
    }

    public boolean I4() {
        ILegoAdvert iLegoAdvert = this.O3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public void J4(App app) {
        if (app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.S3 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.I3 = goodsInfo.goods_style.intValue();
                try {
                    this.J3 = goodsInfo.lego_card;
                    L4(new JSONObject(this.J3));
                    return;
                } catch (JSONException unused) {
                    this.R3 = 38;
                    return;
                }
            }
        }
    }

    public final void L4(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.H3 = optJSONObject.optInt("card_type");
            this.I3 = optJSONObject.optInt("goods_style", this.I3);
            this.V3 = optJSONObject.optInt("url_type");
            this.G3 = optJSONObject.optString("id");
            this.N3 = optJSONObject.optString("ext_info");
            this.W3 = optJSONObject.optString("scheme");
            this.T3 = optJSONObject.optString("user_name");
            String optString = optJSONObject.optString(IAdRequestParam.POS, "");
            this.M3 = optString;
            this.position = d.a.c.e.m.b.d(optString.trim(), -1);
            this.U3 = optJSONObject.optString("user_portrait");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject2 != null) {
            this.Y3 = optJSONObject2.optString("apk_name");
            this.X3 = optJSONObject2.optString("apk_url");
        }
        D4(jSONObject);
    }

    @Override // d.a.m0.r.q.m0
    public boolean b() {
        return this.K3;
    }

    @Override // d.a.m0.r.q.m0
    public int d() {
        return this.position;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.G3, this.G3) && TextUtils.equals(advertAppInfo.N3, this.N3);
        }
        return false;
    }

    @NonNull
    public String getDownloadId() {
        return E4() ? this.O3.getDownloadId() : "";
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        ILegoAdvert iLegoAdvert;
        int i2 = this.I3;
        if (i2 != 1001 && i2 != -1001) {
            if (!k.c().g() && (iLegoAdvert = this.O3) != null && iLegoAdvert.isNoPicAd()) {
                return a4;
            }
            ILegoAdvert iLegoAdvert2 = this.O3;
            if (iLegoAdvert2 != null) {
                BdUniqueId bdUniqueId = d4;
                int goodsStyle = iLegoAdvert2.getGoodsStyle();
                if (goodsStyle != 2) {
                    if (goodsStyle != 6) {
                        if (goodsStyle != 7) {
                            if (goodsStyle != 8) {
                                switch (goodsStyle) {
                                    case 12:
                                        return i4;
                                    case 13:
                                        return h4;
                                    case 14:
                                        break;
                                    default:
                                        return bdUniqueId;
                                }
                            }
                        }
                        return g4;
                    }
                    return f4;
                }
                return e4;
            }
            return null;
        }
        return a4;
    }

    public int hashCode() {
        String str = this.G3;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.N3;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // d.a.m0.r.q.m0
    public AdvertAppInfo j() {
        return this;
    }

    @Override // d.a.m0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.K3 = true;
    }
}
