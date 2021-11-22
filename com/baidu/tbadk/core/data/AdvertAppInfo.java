package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.e;
import b.a.q0.s.q.o0;
import b.a.r0.a3.d0.c;
import b.a.r0.a3.z;
import b.a.r0.q1.o.b;
import b.a.r0.q1.o.k.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
/* loaded from: classes8.dex */
public class AdvertAppInfo extends d2 implements o0, c {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A4;
    public static final BdUniqueId B4;
    public static final BdUniqueId C4;
    public static final BdUniqueId D4;
    public static final BdUniqueId E4;
    public static AtomicBoolean r4;
    public static final BdUniqueId s4;
    public static final BdUniqueId t4;
    public static final BdUniqueId u4;
    public static final BdUniqueId v4;
    public static final BdUniqueId w4;
    public static final BdUniqueId x4;
    public static final BdUniqueId y4;
    public static final BdUniqueId z4;
    public transient /* synthetic */ FieldHolder $fh;
    public String Y3;
    public int Z3;
    public int a4;
    public String b4;
    public boolean c4;
    public boolean d4;
    public String e4;
    public String f4;
    public ILegoAdvert g4;
    public e h4;
    public String i4;
    public int j4;
    public App k4;
    public String l4;
    public String m4;
    public int n4;
    public String o4;
    public String p4;
    public String q4;

    /* loaded from: classes8.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        b.a.q0.s.q.c getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, b.a.e.m.e.n
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
        r4 = new AtomicBoolean(false);
        s4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        t4 = BdUniqueId.gen();
        u4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        v4 = BdUniqueId.gen();
        w4 = BdUniqueId.gen();
        x4 = BdUniqueId.gen();
        y4 = BdUniqueId.gen();
        z4 = BdUniqueId.gen();
        A4 = BdUniqueId.gen();
        B4 = BdUniqueId.gen();
        C4 = BdUniqueId.gen();
        D4 = BdUniqueId.gen();
        E4 = BdUniqueId.gen();
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
        this.c4 = false;
        this.d4 = false;
        this.g4 = null;
        this.j4 = 32;
    }

    @NonNull
    public static AdvertAppInfo Z4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.b4 = optJSONObject.toString();
            advertAppInfo.a5(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4 : (String) invokeV.objValue;
    }

    public void S4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.Z3));
                ICardInfo j = b.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.g4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.j4 = 40;
                } else {
                    this.j4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean T4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a4 == 1001 || this.n4 != 3 || (iLegoAdvert = this.g4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.g4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.a4;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.n4 != 1 || TextUtils.isEmpty(this.o4) || TextUtils.isEmpty(this.o4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int W4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!d2.P3.get()) {
                z.A();
                return 31;
            } else if (!r4.get()) {
                z.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.i4) || TextUtils.equals("PIC_PAGE_BANNER", this.i4) || !TextUtils.isEmpty(this.e4)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.a4;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.Z3) == 31) {
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
                if (this.g4 == null) {
                    return this.j4;
                }
                if (TextUtils.isEmpty(this.Y3) || TextUtils.isEmpty(this.Y3.trim())) {
                    return 24;
                }
                if (this.g4.getAppInfoModel() == null || b.a.q0.s.q.c.c(this.g4.getAppInfoModel())) {
                    if (k.c().g() || this.g4.isNoPicAd()) {
                        int i4 = this.n4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.n4 == 3) {
                                if (!T4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.b4).optJSONObject("download_info");
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.n4 != 1 || V4()) ? 0 : 27;
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

    public boolean X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ILegoAdvert iLegoAdvert = this.g4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void Y4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.k4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.a4 = goodsInfo.goods_style.intValue();
                try {
                    this.b4 = goodsInfo.lego_card;
                    a5(new JSONObject(this.b4));
                    return;
                } catch (JSONException unused) {
                    this.j4 = 38;
                    return;
                }
            }
        }
    }

    @Override // b.a.r0.a3.d0.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            setPosition(i2);
        }
    }

    public final void a5(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.Z3 = optJSONObject.optInt("card_type");
                this.a4 = optJSONObject.optInt("goods_style");
                this.n4 = optJSONObject.optInt("url_type");
                this.Y3 = optJSONObject.optString("id");
                this.f4 = optJSONObject.optString("ext_info");
                this.o4 = optJSONObject.optString("scheme");
                this.l4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.e4 = optString;
                this.position = b.a.e.f.m.b.e(optString.trim(), -1);
                this.m4 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("download_info");
            if (optJSONObject2 != null) {
                this.q4 = optJSONObject2.optString("apk_name");
                this.p4 = optJSONObject2.optString("apk_url");
            }
            S4(jSONObject);
        }
    }

    @Override // b.a.q0.s.q.o0
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c4 : invokeV.booleanValue;
    }

    @Override // b.a.r0.a3.d0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a4 == 1001 || getType() == s4 || getType() == t4 || getType() == u4 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.Y3, this.Y3) && TextUtils.equals(advertAppInfo.f4, this.f4);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.q0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? T4() ? this.g4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.d2, com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.a4;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.g4) != null && iLegoAdvert.isNoPicAd()) {
                    return s4;
                }
                ILegoAdvert iLegoAdvert2 = this.g4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = v4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return A4;
                                        case 13:
                                            return z4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return y4;
                        }
                        return x4;
                    }
                    return w4;
                }
                return null;
            }
            return s4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.Y3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.f4;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // b.a.q0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.position = i2;
            this.c4 = true;
        }
    }
}
