package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.e;
import b.a.q0.s.q.o0;
import b.a.r0.q1.o.b;
import b.a.r0.q1.o.k.a;
import b.a.r0.z2.d0.c;
import b.a.r0.z2.z;
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
    public static AtomicBoolean q4;
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
    public String X3;
    public int Y3;
    public int Z3;
    public String a4;
    public boolean b4;
    public boolean c4;
    public String d4;
    public String e4;
    public ILegoAdvert f4;
    public e g4;
    public String h4;
    public int i4;
    public App j4;
    public String k4;
    public String l4;
    public int m4;
    public String n4;
    public String o4;
    public String p4;

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

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, b.a.e.l.e.n
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
        q4 = new AtomicBoolean(false);
        r4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        s4 = BdUniqueId.gen();
        t4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        u4 = BdUniqueId.gen();
        v4 = BdUniqueId.gen();
        w4 = BdUniqueId.gen();
        x4 = BdUniqueId.gen();
        y4 = BdUniqueId.gen();
        z4 = BdUniqueId.gen();
        A4 = BdUniqueId.gen();
        B4 = BdUniqueId.gen();
        C4 = BdUniqueId.gen();
        D4 = BdUniqueId.gen();
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
        this.b4 = false;
        this.c4 = false;
        this.f4 = null;
        this.i4 = 32;
    }

    @NonNull
    public static AdvertAppInfo X4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.a4 = optJSONObject.toString();
            advertAppInfo.Y4(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e4 : (String) invokeV.objValue;
    }

    public void Q4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.Y3));
                ICardInfo j = b.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.f4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.i4 = 40;
                } else {
                    this.i4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean R4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.Z3 == 1001 || this.m4 != 3 || (iLegoAdvert = this.f4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean S4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.f4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.Z3;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.m4 != 1 || TextUtils.isEmpty(this.n4) || TextUtils.isEmpty(this.n4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int U4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!d2.N3.get()) {
                z.A();
                return 31;
            } else if (!q4.get()) {
                z.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.h4) || TextUtils.equals("PIC_PAGE_BANNER", this.h4) || !TextUtils.isEmpty(this.d4)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.Z3;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.Y3) == 31) {
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
                if (this.f4 == null) {
                    return this.i4;
                }
                if (TextUtils.isEmpty(this.X3) || TextUtils.isEmpty(this.X3.trim())) {
                    return 24;
                }
                if (this.f4.getAppInfoModel() == null || b.a.q0.s.q.c.c(this.f4.getAppInfoModel())) {
                    if (k.c().g() || this.f4.isNoPicAd()) {
                        int i4 = this.m4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.m4 == 3) {
                                if (!R4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.a4).optJSONObject("download_info");
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.m4 != 1 || T4()) ? 0 : 27;
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

    public boolean V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ILegoAdvert iLegoAdvert = this.f4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void W4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.j4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.Z3 = goodsInfo.goods_style.intValue();
                try {
                    this.a4 = goodsInfo.lego_card;
                    Y4(new JSONObject(this.a4));
                    return;
                } catch (JSONException unused) {
                    this.i4 = 38;
                    return;
                }
            }
        }
    }

    public final void Y4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.Y3 = optJSONObject.optInt("card_type");
                this.Z3 = optJSONObject.optInt("goods_style");
                this.m4 = optJSONObject.optInt("url_type");
                this.X3 = optJSONObject.optString("id");
                this.e4 = optJSONObject.optString("ext_info");
                this.n4 = optJSONObject.optString("scheme");
                this.k4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.d4 = optString;
                this.position = b.a.e.e.m.b.e(optString.trim(), -1);
                this.l4 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("download_info");
            if (optJSONObject2 != null) {
                this.p4 = optJSONObject2.optString("apk_name");
                this.o4 = optJSONObject2.optString("apk_url");
            }
            Q4(jSONObject);
        }
    }

    @Override // b.a.r0.z2.d0.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setPosition(i2);
        }
    }

    @Override // b.a.q0.s.q.o0
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b4 : invokeV.booleanValue;
    }

    @Override // b.a.r0.z2.d0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Z3 == 1001 || getType() == r4 || getType() == s4 || getType() == t4 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.X3, this.X3) && TextUtils.equals(advertAppInfo.e4, this.e4);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R4() ? this.f4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.d2, com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.Z3;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.f4) != null && iLegoAdvert.isNoPicAd()) {
                    return r4;
                }
                ILegoAdvert iLegoAdvert2 = this.f4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = u4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return z4;
                                        case 13:
                                            return y4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return x4;
                        }
                        return w4;
                    }
                    return v4;
                }
                return null;
            }
            return r4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.X3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.e4;
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
            this.b4 = true;
        }
    }
}
