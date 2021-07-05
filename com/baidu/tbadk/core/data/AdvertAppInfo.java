package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.downloader.OAdSqlLiteHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.b;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.c;
import d.a.r0.r.q.e;
import d.a.r0.r.q.n0;
import d.a.s0.n1.o.k.a;
import d.a.s0.w2.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes4.dex */
public class AdvertAppInfo extends b2 implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean e4;
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
    public static final BdUniqueId p4;
    public static final BdUniqueId q4;
    public transient /* synthetic */ FieldHolder $fh;
    public String L3;
    public int M3;
    public int N3;
    public String O3;
    public boolean P3;
    public boolean Q3;
    public String R3;
    public String S3;
    public ILegoAdvert T3;
    public e U3;
    public String V3;
    public int W3;
    public App X3;
    public String Y3;
    public String Z3;
    public int a4;
    public String b4;
    public String c4;
    public String d4;

    /* loaded from: classes4.dex */
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1560561192, "Lcom/baidu/tbadk/core/data/AdvertAppInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1560561192, "Lcom/baidu/tbadk/core/data/AdvertAppInfo;");
                return;
            }
        }
        e4 = new AtomicBoolean(false);
        f4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        g4 = BdUniqueId.gen();
        h4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        i4 = BdUniqueId.gen();
        j4 = BdUniqueId.gen();
        k4 = BdUniqueId.gen();
        l4 = BdUniqueId.gen();
        m4 = BdUniqueId.gen();
        n4 = BdUniqueId.gen();
        o4 = BdUniqueId.gen();
        p4 = BdUniqueId.gen();
        q4 = BdUniqueId.gen();
    }

    public AdvertAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.P3 = false;
        this.Q3 = false;
        this.T3 = null;
        this.W3 = 32;
    }

    @NonNull
    public static AdvertAppInfo z4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            advertAppInfo.N3 = jSONObject.optInt("goods_style");
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.O3 = optJSONObject.toString();
            advertAppInfo.A4(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public final void A4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.M3 = optJSONObject.optInt("card_type");
                this.N3 = optJSONObject.optInt("goods_style", this.N3);
                this.a4 = optJSONObject.optInt("url_type");
                this.L3 = optJSONObject.optString("id");
                this.S3 = optJSONObject.optString("ext_info");
                this.b4 = optJSONObject.optString("scheme");
                this.Y3 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.R3 = optString;
                this.position = b.d(optString.trim(), -1);
                this.Z3 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
            if (optJSONObject2 != null) {
                this.d4 = optJSONObject2.optString("apk_name");
                this.c4 = optJSONObject2.optString("apk_url");
            }
            s4(jSONObject);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.L3, this.L3) && TextUtils.equals(advertAppInfo.S3, this.S3);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.r0.r.q.n0
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.P3 : invokeV.booleanValue;
    }

    @Override // d.a.r0.r.q.n0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? t4() ? this.T3.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // d.a.r0.r.q.b2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.N3;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.T3) != null && iLegoAdvert.isNoPicAd()) {
                    return f4;
                }
                ILegoAdvert iLegoAdvert2 = this.T3;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = i4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return n4;
                                        case 13:
                                            return m4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return l4;
                        }
                        return k4;
                    }
                    return j4;
                }
                return null;
            }
            return f4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.L3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.S3;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // d.a.r0.r.q.n0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    public String r4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.S3 : (String) invokeV.objValue;
    }

    public void s4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.M3));
                ICardInfo j = d.a.s0.n1.o.b.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.T3 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.W3 = 40;
                } else {
                    this.W3 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    @Override // d.a.r0.r.q.n0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.position = i2;
            this.P3 = true;
        }
    }

    public boolean t4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.N3 == 1001 || this.a4 != 3 || (iLegoAdvert = this.T3) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ILegoAdvert iLegoAdvert = this.T3;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.N3;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.a4 != 1 || TextUtils.isEmpty(this.b4) || TextUtils.isEmpty(this.b4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int w4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!b2.B3.get()) {
                x.A();
                return 31;
            } else if (!e4.get()) {
                x.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.V3) || TextUtils.equals("PIC_PAGE_BANNER", this.V3) || !TextUtils.isEmpty(this.R3)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.N3;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.M3) == 31) {
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
                if (this.T3 == null) {
                    return this.W3;
                }
                if (TextUtils.isEmpty(this.L3) || TextUtils.isEmpty(this.L3.trim())) {
                    return 24;
                }
                if (this.T3.getAppInfoModel() == null || c.c(this.T3.getAppInfoModel())) {
                    if (k.c().g() || this.T3.isNoPicAd()) {
                        int i5 = this.a4;
                        if (i5 == 3 || i5 == 1) {
                            if (this.a4 == 3) {
                                if (!t4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.O3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.a4 != 1 || v4()) ? 0 : 27;
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
        return invokeV.intValue;
    }

    public boolean x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ILegoAdvert iLegoAdvert = this.T3;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void y4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.X3 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.N3 = goodsInfo.goods_style.intValue();
                try {
                    this.O3 = goodsInfo.lego_card;
                    A4(new JSONObject(this.O3));
                    return;
                } catch (JSONException unused) {
                    this.W3 = 38;
                    return;
                }
            }
        }
    }
}
