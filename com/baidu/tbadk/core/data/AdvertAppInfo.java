package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.k;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.e;
import c.a.p0.s.q.o0;
import c.a.q0.o1.o.b;
import c.a.q0.o1.o.k.a;
import c.a.q0.x2.d0.c;
import c.a.q0.x2.z;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes6.dex */
public class AdvertAppInfo extends c2 implements o0, c {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean m4;
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
    public static final BdUniqueId x4;
    public static final BdUniqueId y4;
    public static final BdUniqueId z4;
    public transient /* synthetic */ FieldHolder $fh;
    public String T3;
    public int U3;
    public int V3;
    public String W3;
    public boolean X3;
    public boolean Y3;
    public String Z3;
    public String a4;
    public ILegoAdvert b4;
    public e c4;
    public String d4;
    public int e4;
    public App f4;
    public String g4;
    public String h4;
    public int i4;
    public String j4;
    public String k4;
    public String l4;

    /* loaded from: classes6.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c.a.p0.s.q.c getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, c.a.e.l.e.n
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
        m4 = new AtomicBoolean(false);
        n4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        o4 = BdUniqueId.gen();
        p4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        q4 = BdUniqueId.gen();
        r4 = BdUniqueId.gen();
        s4 = BdUniqueId.gen();
        t4 = BdUniqueId.gen();
        u4 = BdUniqueId.gen();
        v4 = BdUniqueId.gen();
        w4 = BdUniqueId.gen();
        x4 = BdUniqueId.gen();
        y4 = BdUniqueId.gen();
        z4 = BdUniqueId.gen();
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
        this.X3 = false;
        this.Y3 = false;
        this.b4 = null;
        this.e4 = 32;
    }

    @NonNull
    public static AdvertAppInfo L4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.W3 = optJSONObject.toString();
            advertAppInfo.M4(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a4 : (String) invokeV.objValue;
    }

    public void E4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.U3));
                ICardInfo j2 = b.j(jSONObject);
                if (j2 instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j2;
                    this.b4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.e4 = 40;
                } else {
                    this.e4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean F4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.V3 == 1001 || this.i4 != 3 || (iLegoAdvert = this.b4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean G4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.b4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.V3;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.i4 != 1 || TextUtils.isEmpty(this.j4) || TextUtils.isEmpty(this.j4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int I4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!c2.J3.get()) {
                z.A();
                return 31;
            } else if (!m4.get()) {
                z.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.d4) || TextUtils.equals("PIC_PAGE_BANNER", this.d4) || !TextUtils.isEmpty(this.Z3)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.V3;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.U3) == 31) {
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
                if (this.b4 == null) {
                    return this.e4;
                }
                if (TextUtils.isEmpty(this.T3) || TextUtils.isEmpty(this.T3.trim())) {
                    return 24;
                }
                if (this.b4.getAppInfoModel() == null || c.a.p0.s.q.c.c(this.b4.getAppInfoModel())) {
                    if (k.c().g() || this.b4.isNoPicAd()) {
                        int i4 = this.i4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.i4 == 3) {
                                if (!F4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.W3).optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.i4 != 1 || H4()) ? 0 : 27;
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

    public boolean J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ILegoAdvert iLegoAdvert = this.b4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void K4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.f4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.V3 = goodsInfo.goods_style.intValue();
                try {
                    this.W3 = goodsInfo.lego_card;
                    M4(new JSONObject(this.W3));
                    return;
                } catch (JSONException unused) {
                    this.e4 = 38;
                    return;
                }
            }
        }
    }

    public final void M4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.U3 = optJSONObject.optInt("card_type");
                this.V3 = optJSONObject.optInt("goods_style");
                this.i4 = optJSONObject.optInt("url_type");
                this.T3 = optJSONObject.optString("id");
                this.a4 = optJSONObject.optString("ext_info");
                this.j4 = optJSONObject.optString("scheme");
                this.g4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.Z3 = optString;
                this.position = c.a.e.e.m.b.d(optString.trim(), -1);
                this.h4 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
            if (optJSONObject2 != null) {
                this.l4 = optJSONObject2.optString("apk_name");
                this.k4 = optJSONObject2.optString("apk_url");
            }
            E4(jSONObject);
        }
    }

    @Override // c.a.q0.x2.d0.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setPosition(i2);
        }
    }

    @Override // c.a.q0.x2.d0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.V3 == 1001 || getType() == n4 || getType() == o4 || getType() == p4 : invokeV.booleanValue;
    }

    @Override // c.a.p0.s.q.o0
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.X3 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.T3, this.T3) && TextUtils.equals(advertAppInfo.a4, this.a4);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? F4() ? this.b4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.s.q.c2, com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.V3;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.b4) != null && iLegoAdvert.isNoPicAd()) {
                    return n4;
                }
                ILegoAdvert iLegoAdvert2 = this.b4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = q4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return v4;
                                        case 13:
                                            return u4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return t4;
                        }
                        return s4;
                    }
                    return r4;
                }
                return null;
            }
            return n4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.T3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.a4;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.p0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.position = i2;
            this.X3 = true;
        }
    }
}
