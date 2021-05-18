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
import d.a.j0.r.k;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.c;
import d.a.j0.r.q.d;
import d.a.j0.r.q.m0;
import d.a.k0.j1.o.b;
import d.a.k0.j1.o.k.a;
import d.a.k0.s2.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes3.dex */
public class AdvertAppInfo extends a2 implements m0 {
    public static AtomicBoolean Y3 = new AtomicBoolean(false);
    public static final BdUniqueId Z3 = BdUniqueId.gen();
    public static final BdUniqueId a4;
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
    public String F3;
    public int G3;
    public int H3;
    public String I3;
    public String L3;
    public String M3;
    public d O3;
    public String P3;
    public App R3;
    public String S3;
    public String T3;
    public int U3;
    public String V3;
    public String W3;
    public String X3;
    public boolean J3 = false;
    public boolean K3 = false;
    public ILegoAdvert N3 = null;
    public int Q3 = 32;

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
        a4 = BdUniqueId.gen();
        b4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        c4 = BdUniqueId.gen();
        d4 = BdUniqueId.gen();
        e4 = BdUniqueId.gen();
        f4 = BdUniqueId.gen();
        g4 = BdUniqueId.gen();
        h4 = BdUniqueId.gen();
        i4 = BdUniqueId.gen();
        j4 = BdUniqueId.gen();
        k4 = BdUniqueId.gen();
    }

    @NonNull
    public static AdvertAppInfo J4(@NonNull JSONObject jSONObject) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        advertAppInfo.H3 = jSONObject.optInt("goods_style");
        JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
        advertAppInfo.I3 = optJSONObject.toString();
        advertAppInfo.K4(optJSONObject);
        return advertAppInfo;
    }

    public String B4() {
        return this.M3;
    }

    public void C4(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("card_type", Integer.valueOf(this.G3));
            ICardInfo j = b.j(jSONObject);
            if (j instanceof ILegoAdvert) {
                ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                this.N3 = iLegoAdvert;
                iLegoAdvert.setAdvertAppInfo(this);
            }
        } catch (CardParseException e2) {
            if (e2.getCause() instanceof IllegalStateException) {
                this.Q3 = 40;
            } else {
                this.Q3 = 39;
            }
        } catch (JSONException unused) {
        }
    }

    public boolean D4() {
        ILegoAdvert iLegoAdvert;
        if (this.H3 == 1001 || this.U3 != 3 || (iLegoAdvert = this.N3) == null) {
            return false;
        }
        return iLegoAdvert.checkIsAppAdvert();
    }

    public boolean E4() {
        ILegoAdvert iLegoAdvert = this.N3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    public boolean F4() {
        int i2 = this.H3;
        if (i2 == 1001 || i2 == -1001) {
            return true;
        }
        return (this.U3 != 1 || TextUtils.isEmpty(this.V3) || TextUtils.isEmpty(this.V3.trim())) ? false : true;
    }

    public int G4() {
        int i2;
        if (!a2.v3.get()) {
            y.A();
            return 31;
        } else if (!Y3.get()) {
            y.A();
            return 31;
        } else if (TextUtils.equals("PB_BANNER", this.P3) || TextUtils.equals("PIC_PAGE_BANNER", this.P3) || !TextUtils.isEmpty(this.L3)) {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            int i3 = this.H3;
            if (i3 == 1001) {
                return 0;
            }
            if (i3 == 11 || (i2 = this.G3) == 31) {
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
            if (this.N3 == null) {
                return this.Q3;
            }
            if (TextUtils.isEmpty(this.F3) || TextUtils.isEmpty(this.F3.trim())) {
                return 24;
            }
            if (this.N3.getAppInfoModel() == null || c.c(this.N3.getAppInfoModel())) {
                if (k.c().g() || this.N3.isNoPicAd()) {
                    int i5 = this.U3;
                    if (i5 == 3 || i5 == 1) {
                        if (this.U3 == 3) {
                            if (!D4()) {
                                return 26;
                            }
                            try {
                                JSONObject optJSONObject = new JSONObject(this.I3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                if (optJSONObject != null) {
                                    if (optJSONObject.optBoolean("direcrt_download")) {
                                        return 43;
                                    }
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return (this.U3 != 1 || F4()) ? 0 : 27;
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

    public boolean H4() {
        ILegoAdvert iLegoAdvert = this.N3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public void I4(App app) {
        if (app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.R3 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.H3 = goodsInfo.goods_style.intValue();
                try {
                    this.I3 = goodsInfo.lego_card;
                    K4(new JSONObject(this.I3));
                    return;
                } catch (JSONException unused) {
                    this.Q3 = 38;
                    return;
                }
            }
        }
    }

    public final void K4(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.G3 = optJSONObject.optInt("card_type");
            this.H3 = optJSONObject.optInt("goods_style", this.H3);
            this.U3 = optJSONObject.optInt("url_type");
            this.F3 = optJSONObject.optString("id");
            this.M3 = optJSONObject.optString("ext_info");
            this.V3 = optJSONObject.optString("scheme");
            this.S3 = optJSONObject.optString("user_name");
            String optString = optJSONObject.optString(IAdRequestParam.POS, "");
            this.L3 = optString;
            this.position = d.a.c.e.m.b.d(optString.trim(), -1);
            this.T3 = optJSONObject.optString("user_portrait");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject2 != null) {
            this.X3 = optJSONObject2.optString("apk_name");
            this.W3 = optJSONObject2.optString("apk_url");
        }
        C4(jSONObject);
    }

    @Override // d.a.j0.r.q.m0
    public boolean b() {
        return this.J3;
    }

    @Override // d.a.j0.r.q.m0
    public int d() {
        return this.position;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.F3, this.F3) && TextUtils.equals(advertAppInfo.M3, this.M3);
        }
        return false;
    }

    @NonNull
    public String getDownloadId() {
        return D4() ? this.N3.getDownloadId() : "";
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        ILegoAdvert iLegoAdvert;
        int i2 = this.H3;
        if (i2 != 1001 && i2 != -1001) {
            if (!k.c().g() && (iLegoAdvert = this.N3) != null && iLegoAdvert.isNoPicAd()) {
                return Z3;
            }
            ILegoAdvert iLegoAdvert2 = this.N3;
            if (iLegoAdvert2 != null) {
                BdUniqueId bdUniqueId = c4;
                int goodsStyle = iLegoAdvert2.getGoodsStyle();
                if (goodsStyle != 2) {
                    if (goodsStyle != 6) {
                        if (goodsStyle != 7) {
                            if (goodsStyle != 8) {
                                switch (goodsStyle) {
                                    case 12:
                                        return h4;
                                    case 13:
                                        return g4;
                                    case 14:
                                        break;
                                    default:
                                        return bdUniqueId;
                                }
                            }
                        }
                        return f4;
                    }
                    return e4;
                }
                return d4;
            }
            return null;
        }
        return Z3;
    }

    public int hashCode() {
        String str = this.F3;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.M3;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // d.a.j0.r.q.m0
    public AdvertAppInfo j() {
        return this;
    }

    @Override // d.a.j0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.J3 = true;
    }
}
