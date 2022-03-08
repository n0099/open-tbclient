package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.l;
import c.a.q0.r.r.e;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.o0;
import c.a.r0.j3.a0;
import c.a.r0.j3.e0.c;
import c.a.r0.z1.o.b;
import c.a.r0.z1.o.k.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
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
/* loaded from: classes5.dex */
public class AdvertAppInfo extends e2 implements o0, c {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean A4;
    public static final BdUniqueId B4;
    public static final BdUniqueId C4;
    public static final BdUniqueId D4;
    public static final BdUniqueId E4;
    public static final BdUniqueId F4;
    public static final BdUniqueId G4;
    public static final BdUniqueId H4;
    public static final BdUniqueId I4;
    public static final BdUniqueId J4;
    public static final BdUniqueId K4;
    public static final BdUniqueId L4;
    public static final BdUniqueId M4;
    public static final BdUniqueId N4;
    public transient /* synthetic */ FieldHolder $fh;
    public String g4;
    public int h4;
    public int i4;
    public String j4;
    public boolean k4;
    public boolean l4;
    public String m4;
    public String n4;
    public ILegoAdvert o4;
    public e p4;
    public String q4;
    public int r4;
    public App s4;
    public String t4;
    public String u4;
    public int v4;
    public String w4;
    public String x4;
    public String y4;
    public String z4;

    /* loaded from: classes5.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c.a.q0.r.r.c getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, c.a.d.o.e.n
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
        A4 = new AtomicBoolean(false);
        B4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        C4 = BdUniqueId.gen();
        D4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        E4 = BdUniqueId.gen();
        F4 = BdUniqueId.gen();
        G4 = BdUniqueId.gen();
        H4 = BdUniqueId.gen();
        I4 = BdUniqueId.gen();
        J4 = BdUniqueId.gen();
        K4 = BdUniqueId.gen();
        L4 = BdUniqueId.gen();
        M4 = BdUniqueId.gen();
        N4 = BdUniqueId.gen();
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
        this.k4 = false;
        this.l4 = false;
        this.o4 = null;
        this.r4 = 32;
    }

    @NonNull
    public static AdvertAppInfo c5(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.j4 = optJSONObject.toString();
            advertAppInfo.d5(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n4 : (String) invokeV.objValue;
    }

    public void V4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.h4));
                ICardInfo j2 = b.j(jSONObject);
                if (j2 instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j2;
                    this.o4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.r4 = 40;
                } else {
                    this.r4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean W4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.i4 == 1001 || this.v4 != 3 || (iLegoAdvert = this.o4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.o4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.i4;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.v4 != 1 || TextUtils.isEmpty(this.w4) || TextUtils.isEmpty(this.w4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int Z4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!e2.X3.get()) {
                a0.B();
                return 31;
            } else if (!A4.get()) {
                a0.B();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.q4) || TextUtils.equals("PIC_PAGE_BANNER", this.q4) || !TextUtils.isEmpty(this.m4)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.i4;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.h4) == 31) {
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
                if (this.o4 == null) {
                    return this.r4;
                }
                if (TextUtils.isEmpty(this.g4) || TextUtils.isEmpty(this.g4.trim())) {
                    return 24;
                }
                if (this.o4.getAppInfoModel() == null || c.a.q0.r.r.c.c(this.o4.getAppInfoModel())) {
                    if (l.c().g() || this.o4.isNoPicAd()) {
                        int i4 = this.v4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.v4 == 3) {
                                if (!W4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.j4).optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.v4 != 1 || Y4()) ? 0 : 27;
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

    @Override // c.a.r0.j3.e0.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            setPosition(i2);
        }
    }

    public boolean a5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ILegoAdvert iLegoAdvert = this.o4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void b5(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.s4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.i4 = goodsInfo.goods_style.intValue();
                try {
                    this.j4 = goodsInfo.lego_card;
                    d5(new JSONObject(this.j4));
                    return;
                } catch (JSONException unused) {
                    this.r4 = 38;
                    return;
                }
            }
        }
    }

    @Override // c.a.q0.r.r.o0
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k4 : invokeV.booleanValue;
    }

    @Override // c.a.r0.j3.e0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i4 == 1001 || getType() == B4 || getType() == C4 || getType() == D4 : invokeV.booleanValue;
    }

    public final void d5(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.h4 = optJSONObject.optInt("card_type");
                this.i4 = optJSONObject.optInt("goods_style");
                this.v4 = optJSONObject.optInt("url_type");
                this.g4 = optJSONObject.optString("id");
                this.n4 = optJSONObject.optString("ext_info");
                this.w4 = optJSONObject.optString("scheme");
                this.t4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString("pos", "");
                this.m4 = optString;
                this.position = c.a.d.f.m.b.e(optString.trim(), -1);
                this.u4 = optJSONObject.optString("user_portrait");
                this.z4 = optJSONObject.optString("cmd_scheme");
                optJSONObject.optString("play_cmd_scheme");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
            if (optJSONObject2 != null) {
                this.y4 = optJSONObject2.optString("apk_name");
                this.x4 = optJSONObject2.optString("apk_url");
            }
            V4(jSONObject);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.g4, this.g4) && TextUtils.equals(advertAppInfo.n4, this.n4);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.r.r.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? W4() ? this.o4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.e2, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.i4;
            if (i2 != 1001 && i2 != -1001) {
                if (!l.c().g() && (iLegoAdvert = this.o4) != null && iLegoAdvert.isNoPicAd()) {
                    return B4;
                }
                ILegoAdvert iLegoAdvert2 = this.o4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = E4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return J4;
                                        case 13:
                                            return I4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return H4;
                        }
                        return G4;
                    }
                    return F4;
                }
                return null;
            }
            return B4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.g4;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.n4;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.r.r.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.position = i2;
            this.k4 = true;
        }
    }
}
