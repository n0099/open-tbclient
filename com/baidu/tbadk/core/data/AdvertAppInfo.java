package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.k;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.e;
import c.a.q0.s.q.o0;
import c.a.r0.p1.o.b;
import c.a.r0.p1.o.k.a;
import c.a.r0.y2.d0.c;
import c.a.r0.y2.z;
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
/* loaded from: classes6.dex */
public class AdvertAppInfo extends d2 implements o0, c {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A4;
    public static final BdUniqueId B4;
    public static final BdUniqueId C4;
    public static AtomicBoolean p4;
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
    public String W3;
    public int X3;
    public int Y3;
    public String Z3;
    public boolean a4;
    public boolean b4;
    public String c4;
    public String d4;
    public ILegoAdvert e4;
    public e f4;
    public String g4;
    public int h4;
    public App i4;
    public String j4;
    public String k4;
    public int l4;
    public String m4;
    public String n4;
    public String o4;

    /* loaded from: classes6.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c.a.q0.s.q.c getAppInfoModel();

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
        p4 = new AtomicBoolean(false);
        q4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        r4 = BdUniqueId.gen();
        s4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        t4 = BdUniqueId.gen();
        u4 = BdUniqueId.gen();
        v4 = BdUniqueId.gen();
        w4 = BdUniqueId.gen();
        x4 = BdUniqueId.gen();
        y4 = BdUniqueId.gen();
        z4 = BdUniqueId.gen();
        A4 = BdUniqueId.gen();
        B4 = BdUniqueId.gen();
        C4 = BdUniqueId.gen();
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
        this.a4 = false;
        this.b4 = false;
        this.e4 = null;
        this.h4 = 32;
    }

    @NonNull
    public static AdvertAppInfo W4(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.Z3 = optJSONObject.toString();
            advertAppInfo.X4(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d4 : (String) invokeV.objValue;
    }

    public void P4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.X3));
                ICardInfo j2 = b.j(jSONObject);
                if (j2 instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j2;
                    this.e4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.h4 = 40;
                } else {
                    this.h4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean Q4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.Y3 == 1001 || this.l4 != 3 || (iLegoAdvert = this.e4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.e4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean S4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.Y3;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.l4 != 1 || TextUtils.isEmpty(this.m4) || TextUtils.isEmpty(this.m4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int T4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!d2.M3.get()) {
                z.A();
                return 31;
            } else if (!p4.get()) {
                z.A();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.g4) || TextUtils.equals("PIC_PAGE_BANNER", this.g4) || !TextUtils.isEmpty(this.c4)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.Y3;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.X3) == 31) {
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
                if (this.e4 == null) {
                    return this.h4;
                }
                if (TextUtils.isEmpty(this.W3) || TextUtils.isEmpty(this.W3.trim())) {
                    return 24;
                }
                if (this.e4.getAppInfoModel() == null || c.a.q0.s.q.c.c(this.e4.getAppInfoModel())) {
                    if (k.c().g() || this.e4.isNoPicAd()) {
                        int i4 = this.l4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.l4 == 3) {
                                if (!Q4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.Z3).optJSONObject("download_info");
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.l4 != 1 || S4()) ? 0 : 27;
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

    public boolean U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ILegoAdvert iLegoAdvert = this.e4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void V4(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.i4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.Y3 = goodsInfo.goods_style.intValue();
                try {
                    this.Z3 = goodsInfo.lego_card;
                    X4(new JSONObject(this.Z3));
                    return;
                } catch (JSONException unused) {
                    this.h4 = 38;
                    return;
                }
            }
        }
    }

    public final void X4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.X3 = optJSONObject.optInt("card_type");
                this.Y3 = optJSONObject.optInt("goods_style");
                this.l4 = optJSONObject.optInt("url_type");
                this.W3 = optJSONObject.optString("id");
                this.d4 = optJSONObject.optString("ext_info");
                this.m4 = optJSONObject.optString("scheme");
                this.j4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString(IAdRequestParam.POS, "");
                this.c4 = optString;
                this.position = c.a.e.e.m.b.e(optString.trim(), -1);
                this.k4 = optJSONObject.optString("user_portrait");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("download_info");
            if (optJSONObject2 != null) {
                this.o4 = optJSONObject2.optString("apk_name");
                this.n4 = optJSONObject2.optString("apk_url");
            }
            P4(jSONObject);
        }
    }

    @Override // c.a.r0.y2.d0.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setPosition(i2);
        }
    }

    @Override // c.a.r0.y2.d0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.Y3 == 1001 || getType() == q4 || getType() == r4 || getType() == s4 : invokeV.booleanValue;
    }

    @Override // c.a.q0.s.q.o0
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a4 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.W3, this.W3) && TextUtils.equals(advertAppInfo.d4, this.d4);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Q4() ? this.e4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.d2, com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.Y3;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.e4) != null && iLegoAdvert.isNoPicAd()) {
                    return q4;
                }
                ILegoAdvert iLegoAdvert2 = this.e4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = t4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return y4;
                                        case 13:
                                            return x4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return w4;
                        }
                        return v4;
                    }
                    return u4;
                }
                return null;
            }
            return q4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.W3;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.d4;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.position = i2;
            this.a4 = true;
        }
    }
}
