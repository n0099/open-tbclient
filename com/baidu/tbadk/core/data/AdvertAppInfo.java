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
    public static AtomicBoolean c4 = new AtomicBoolean(false);
    public static final BdUniqueId d4 = BdUniqueId.gen();
    public static final BdUniqueId e4;
    public static final BdUniqueId f4;
    public static final BdUniqueId g4;
    public static final BdUniqueId h4;
    public static final BdUniqueId i4;
    public static final BdUniqueId j4;
    public static final BdUniqueId k4;
    public static final BdUniqueId l4;
    public static final BdUniqueId m4;
    public static final BdUniqueId n4;
    public static final BdUniqueId o4;
    public String J3;
    public int K3;
    public int L3;
    public String M3;
    public String P3;
    public String Q3;
    public d S3;
    public String T3;
    public App V3;
    public String W3;
    public String X3;
    public int Y3;
    public String Z3;
    public String a4;
    public String b4;
    public boolean N3 = false;
    public boolean O3 = false;
    public ILegoAdvert R3 = null;
    public int U3 = 32;

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

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, d.a.c.k.e.n
        /* synthetic */ BdUniqueId getType();

        boolean isNoPicAd();

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    static {
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        e4 = BdUniqueId.gen();
        f4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        g4 = BdUniqueId.gen();
        h4 = BdUniqueId.gen();
        i4 = BdUniqueId.gen();
        j4 = BdUniqueId.gen();
        k4 = BdUniqueId.gen();
        l4 = BdUniqueId.gen();
        m4 = BdUniqueId.gen();
        n4 = BdUniqueId.gen();
        o4 = BdUniqueId.gen();
    }

    @NonNull
    public static AdvertAppInfo L4(@NonNull JSONObject jSONObject) {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        advertAppInfo.L3 = jSONObject.optInt("goods_style");
        JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
        advertAppInfo.M3 = optJSONObject.toString();
        advertAppInfo.M4(optJSONObject);
        return advertAppInfo;
    }

    public String D4() {
        return this.Q3;
    }

    public void E4(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("card_type", Integer.valueOf(this.K3));
            ICardInfo j = b.j(jSONObject);
            if (j instanceof ILegoAdvert) {
                ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                this.R3 = iLegoAdvert;
                iLegoAdvert.setAdvertAppInfo(this);
            }
        } catch (CardParseException e2) {
            if (e2.getCause() instanceof IllegalStateException) {
                this.U3 = 40;
            } else {
                this.U3 = 39;
            }
        } catch (JSONException unused) {
        }
    }

    public boolean F4() {
        ILegoAdvert iLegoAdvert;
        if (this.L3 == 1001 || this.Y3 != 3 || (iLegoAdvert = this.R3) == null) {
            return false;
        }
        return iLegoAdvert.checkIsAppAdvert();
    }

    public boolean G4() {
        ILegoAdvert iLegoAdvert = this.R3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 2 || goodsStyle == 8;
    }

    public boolean H4() {
        int i2 = this.L3;
        if (i2 == 1001 || i2 == -1001) {
            return true;
        }
        return (this.Y3 != 1 || TextUtils.isEmpty(this.Z3) || TextUtils.isEmpty(this.Z3.trim())) ? false : true;
    }

    public int I4() {
        int i2;
        if (!a2.z3.get()) {
            y.A();
            return 31;
        } else if (!c4.get()) {
            y.A();
            return 31;
        } else if (TextUtils.equals("PB_BANNER", this.T3) || TextUtils.equals("PIC_PAGE_BANNER", this.T3) || !TextUtils.isEmpty(this.P3)) {
            if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                return 28;
            }
            int i3 = this.L3;
            if (i3 == 1001) {
                return 0;
            }
            if (i3 == 11 || (i2 = this.K3) == 31) {
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
            if (this.R3 == null) {
                return this.U3;
            }
            if (TextUtils.isEmpty(this.J3) || TextUtils.isEmpty(this.J3.trim())) {
                return 24;
            }
            if (this.R3.getAppInfoModel() == null || c.c(this.R3.getAppInfoModel())) {
                if (k.c().g() || this.R3.isNoPicAd()) {
                    int i5 = this.Y3;
                    if (i5 == 3 || i5 == 1) {
                        if (this.Y3 == 3) {
                            if (!F4()) {
                                return 26;
                            }
                            try {
                                JSONObject optJSONObject = new JSONObject(this.M3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                if (optJSONObject != null) {
                                    if (optJSONObject.optBoolean("direcrt_download")) {
                                        return 43;
                                    }
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return (this.Y3 != 1 || H4()) ? 0 : 27;
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

    public boolean J4() {
        ILegoAdvert iLegoAdvert = this.R3;
        if (iLegoAdvert == null) {
            return false;
        }
        int goodsStyle = iLegoAdvert.getGoodsStyle();
        return goodsStyle == 7 || goodsStyle == 14;
    }

    public void K4(App app) {
        if (app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.V3 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.L3 = goodsInfo.goods_style.intValue();
                try {
                    this.M3 = goodsInfo.lego_card;
                    M4(new JSONObject(this.M3));
                    return;
                } catch (JSONException unused) {
                    this.U3 = 38;
                    return;
                }
            }
        }
    }

    public final void M4(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.K3 = optJSONObject.optInt("card_type");
            this.L3 = optJSONObject.optInt("goods_style", this.L3);
            this.Y3 = optJSONObject.optInt("url_type");
            this.J3 = optJSONObject.optString("id");
            this.Q3 = optJSONObject.optString("ext_info");
            this.Z3 = optJSONObject.optString("scheme");
            this.W3 = optJSONObject.optString("user_name");
            String optString = optJSONObject.optString(IAdRequestParam.POS, "");
            this.P3 = optString;
            this.position = d.a.c.e.m.b.d(optString.trim(), -1);
            this.X3 = optJSONObject.optString("user_portrait");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject2 != null) {
            this.b4 = optJSONObject2.optString("apk_name");
            this.a4 = optJSONObject2.optString("apk_url");
        }
        E4(jSONObject);
    }

    @Override // d.a.m0.r.q.m0
    public boolean d() {
        return this.N3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AdvertAppInfo)) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            return TextUtils.equals(advertAppInfo.J3, this.J3) && TextUtils.equals(advertAppInfo.Q3, this.Q3);
        }
        return false;
    }

    @Override // d.a.m0.r.q.m0
    public int f() {
        return this.position;
    }

    @NonNull
    public String getDownloadId() {
        return F4() ? this.R3.getDownloadId() : "";
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        ILegoAdvert iLegoAdvert;
        int i2 = this.L3;
        if (i2 != 1001 && i2 != -1001) {
            if (!k.c().g() && (iLegoAdvert = this.R3) != null && iLegoAdvert.isNoPicAd()) {
                return d4;
            }
            ILegoAdvert iLegoAdvert2 = this.R3;
            if (iLegoAdvert2 != null) {
                BdUniqueId bdUniqueId = g4;
                int goodsStyle = iLegoAdvert2.getGoodsStyle();
                if (goodsStyle != 2) {
                    if (goodsStyle != 6) {
                        if (goodsStyle != 7) {
                            if (goodsStyle != 8) {
                                switch (goodsStyle) {
                                    case 12:
                                        return l4;
                                    case 13:
                                        return k4;
                                    case 14:
                                        break;
                                    default:
                                        return bdUniqueId;
                                }
                            }
                        }
                        return j4;
                    }
                    return i4;
                }
                return h4;
            }
            return null;
        }
        return d4;
    }

    public int hashCode() {
        String str = this.J3;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.Q3;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // d.a.m0.r.q.m0
    public AdvertAppInfo m() {
        return this;
    }

    @Override // d.a.m0.r.q.m0
    public void setPosition(int i2) {
        this.position = i2;
        this.N3 = true;
    }
}
