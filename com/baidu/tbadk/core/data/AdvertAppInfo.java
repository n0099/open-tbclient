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
import d.a.d.e.m.b;
import d.a.p0.s.k;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.c;
import d.a.p0.s.q.e;
import d.a.p0.s.q.n0;
import d.a.q0.n1.o.k.a;
import d.a.q0.w2.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes3.dex */
public class AdvertAppInfo extends b2 implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean k4;
    public static final BdUniqueId l4;
    public static final BdUniqueId m4;
    public static final BdUniqueId n4;
    public static final BdUniqueId o4;
    public static final BdUniqueId p4;
    public static final BdUniqueId q4;
    public static final BdUniqueId r4;
    public static final BdUniqueId s4;
    public static final BdUniqueId t4;
    public static final BdUniqueId u4;
    public static final BdUniqueId v4;
    public static final BdUniqueId w4;
    public transient /* synthetic */ FieldHolder $fh;
    public String R3;
    public int S3;
    public int T3;
    public String U3;
    public boolean V3;
    public boolean W3;
    public String X3;
    public String Y3;
    public ILegoAdvert Z3;
    public e a4;
    public String b4;
    public int c4;
    public App d4;
    public String e4;
    public String f4;
    public int g4;
    public String h4;
    public String i4;
    public String j4;

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

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, d.a.d.k.e.n
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
        k4 = new AtomicBoolean(false);
        l4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        m4 = BdUniqueId.gen();
        n4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        o4 = BdUniqueId.gen();
        p4 = BdUniqueId.gen();
        q4 = BdUniqueId.gen();
        r4 = BdUniqueId.gen();
        s4 = BdUniqueId.gen();
        t4 = BdUniqueId.gen();
        u4 = BdUniqueId.gen();
        v4 = BdUniqueId.gen();
        w4 = BdUniqueId.gen();
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
        this.V3 = false;
        this.W3 = false;
        this.Z3 = null;
        this.c4 = 32;
    }

    @NonNull
    public static AdvertAppInfo C4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.U3 = optJSONObject.toString();
            advertAppInfo.D4(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public boolean A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ILegoAdvert iLegoAdvert = this.Z3;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void B4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.d4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.T3 = goodsInfo.goods_style.intValue();
                try {
                    this.U3 = goodsInfo.lego_card;
                    D4(new JSONObject(this.U3));
                    return;
                } catch (JSONException unused) {
                    this.c4 = 38;
                    return;
                }
            }
        }
    }

    public final void D4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.S3 = optJSONObject.optInt("card_type");
                this.T3 = optJSONObject.optInt("goods_style");
                this.g4 = optJSONObject.optInt("url_type");
                this.R3 = optJSONObject.optString("id");
                this.Y3 = optJSONObject.optString("ext_info");
                this.h4 = optJSONObject.optString("scheme");
                this.e4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.X3 = optString;
                this.position = b.d(optString.trim(), -1);
                this.f4 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
            if (optJSONObject2 != null) {
                this.j4 = optJSONObject2.optString("apk_name");
                this.i4 = optJSONObject2.optString("apk_url");
            }
            v4(jSONObject);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.R3, this.R3) && TextUtils.equals(advertAppInfo.Y3, this.Y3);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.s.q.n0
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.V3 : invokeV.booleanValue;
    }

    @Override // d.a.p0.s.q.n0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? w4() ? this.Z3.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.b2, com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.T3;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.Z3) != null && iLegoAdvert.isNoPicAd()) {
                    return l4;
                }
                ILegoAdvert iLegoAdvert2 = this.Z3;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = o4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return t4;
                                        case 13:
                                            return s4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return r4;
                        }
                        return q4;
                    }
                    return p4;
                }
                return null;
            }
            return l4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.R3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.Y3;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.s.q.n0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.n0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.position = i2;
            this.V3 = true;
        }
    }

    public String u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Y3 : (String) invokeV.objValue;
    }

    public void v4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.S3));
                ICardInfo j = d.a.q0.n1.o.b.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.Z3 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.c4 = 40;
                } else {
                    this.c4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean w4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.T3 == 1001 || this.g4 != 3 || (iLegoAdvert = this.Z3) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ILegoAdvert iLegoAdvert = this.Z3;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.T3;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.g4 != 1 || TextUtils.isEmpty(this.h4) || TextUtils.isEmpty(this.h4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int z4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!b2.H3.get()) {
                x.A();
                return 31;
            } else if (!k4.get()) {
                x.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.b4) || TextUtils.equals("PIC_PAGE_BANNER", this.b4) || !TextUtils.isEmpty(this.X3)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.T3;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.S3) == 31) {
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
                if (this.Z3 == null) {
                    return this.c4;
                }
                if (TextUtils.isEmpty(this.R3) || TextUtils.isEmpty(this.R3.trim())) {
                    return 24;
                }
                if (this.Z3.getAppInfoModel() == null || c.c(this.Z3.getAppInfoModel())) {
                    if (k.c().g() || this.Z3.isNoPicAd()) {
                        int i4 = this.g4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.g4 == 3) {
                                if (!w4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.U3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.g4 != 1 || y4()) ? 0 : 27;
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
}
