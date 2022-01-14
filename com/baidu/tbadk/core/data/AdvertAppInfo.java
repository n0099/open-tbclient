package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.k;
import c.a.s0.s.q.e;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.o0;
import c.a.t0.j3.d0.c;
import c.a.t0.j3.z;
import c.a.t0.x1.o.b;
import c.a.t0.x1.o.k.a;
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
/* loaded from: classes11.dex */
public class AdvertAppInfo extends e2 implements o0, c {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A4;
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
    public static AtomicBoolean z4;
    public transient /* synthetic */ FieldHolder $fh;
    public String f4;
    public int g4;
    public int h4;
    public String i4;
    public boolean j4;
    public boolean k4;
    public String l4;
    public String m4;
    public ILegoAdvert n4;
    public e o4;
    public String p4;
    public int q4;
    public App r4;
    public String s4;
    public String t4;
    public int u4;
    public String v4;
    public String w4;
    public String x4;
    public String y4;

    /* loaded from: classes11.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        c.a.s0.s.q.c getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, c.a.d.n.e.n
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
        z4 = new AtomicBoolean(false);
        A4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        B4 = BdUniqueId.gen();
        C4 = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        D4 = BdUniqueId.gen();
        E4 = BdUniqueId.gen();
        F4 = BdUniqueId.gen();
        G4 = BdUniqueId.gen();
        H4 = BdUniqueId.gen();
        I4 = BdUniqueId.gen();
        J4 = BdUniqueId.gen();
        K4 = BdUniqueId.gen();
        L4 = BdUniqueId.gen();
        M4 = BdUniqueId.gen();
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
        this.j4 = false;
        this.k4 = false;
        this.n4 = null;
        this.q4 = 32;
    }

    @NonNull
    public static AdvertAppInfo b5(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.i4 = optJSONObject.toString();
            advertAppInfo.c5(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public String T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m4 : (String) invokeV.objValue;
    }

    public void U4(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.g4));
                ICardInfo j2 = b.j(jSONObject);
                if (j2 instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j2;
                    this.n4 = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e2) {
                if (e2.getCause() instanceof IllegalStateException) {
                    this.q4 = 40;
                } else {
                    this.q4 = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean V4() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.h4 == 1001 || this.u4 != 3 || (iLegoAdvert = this.n4) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean W4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ILegoAdvert iLegoAdvert = this.n4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.h4;
            if (i2 == 1001 || i2 == -1001) {
                return true;
            }
            return (this.u4 != 1 || TextUtils.isEmpty(this.v4) || TextUtils.isEmpty(this.v4.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int Y4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!e2.W3.get()) {
                z.B();
                return 31;
            } else if (!z4.get()) {
                z.B();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.p4) || TextUtils.equals("PIC_PAGE_BANNER", this.p4) || !TextUtils.isEmpty(this.l4)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i3 = this.h4;
                if (i3 == 1001) {
                    return 0;
                }
                if (i3 == 11 || (i2 = this.g4) == 31) {
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
                if (this.n4 == null) {
                    return this.q4;
                }
                if (TextUtils.isEmpty(this.f4) || TextUtils.isEmpty(this.f4.trim())) {
                    return 24;
                }
                if (this.n4.getAppInfoModel() == null || c.a.s0.s.q.c.c(this.n4.getAppInfoModel())) {
                    if (k.c().g() || this.n4.isNoPicAd()) {
                        int i4 = this.u4;
                        if (i4 == 3 || i4 == 1) {
                            if (this.u4 == 3) {
                                if (!V4()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.i4).optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.u4 != 1 || X4()) ? 0 : 27;
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

    public boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ILegoAdvert iLegoAdvert = this.n4;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.j3.d0.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            setPosition(i2);
        }
    }

    public void a5(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || a.e(app.goods_info)) {
            return;
        }
        this.r4 = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.h4 = goodsInfo.goods_style.intValue();
                try {
                    this.i4 = goodsInfo.lego_card;
                    c5(new JSONObject(this.i4));
                    return;
                } catch (JSONException unused) {
                    this.q4 = 38;
                    return;
                }
            }
        }
    }

    @Override // c.a.s0.s.q.o0
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j4 : invokeV.booleanValue;
    }

    public final void c5(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.g4 = optJSONObject.optInt("card_type");
                this.h4 = optJSONObject.optInt("goods_style");
                this.u4 = optJSONObject.optInt("url_type");
                this.f4 = optJSONObject.optString("id");
                this.m4 = optJSONObject.optString("ext_info");
                this.v4 = optJSONObject.optString("scheme");
                this.s4 = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString("pos", "");
                this.l4 = optString;
                this.position = c.a.d.f.m.b.e(optString.trim(), -1);
                this.t4 = optJSONObject.optString("user_portrait");
                this.y4 = optJSONObject.optString("cmd_scheme");
                optJSONObject.optString("play_cmd_scheme");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
            if (optJSONObject2 != null) {
                this.x4 = optJSONObject2.optString("apk_name");
                this.w4 = optJSONObject2.optString("apk_url");
            }
            U4(jSONObject);
        }
    }

    @Override // c.a.t0.j3.d0.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.h4 == 1001 || getType() == A4 || getType() == B4 || getType() == C4 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.f4, this.f4) && TextUtils.equals(advertAppInfo.m4, this.m4);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.position : invokeV.intValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? V4() ? this.n4.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.e2, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.h4;
            if (i2 != 1001 && i2 != -1001) {
                if (!k.c().g() && (iLegoAdvert = this.n4) != null && iLegoAdvert.isNoPicAd()) {
                    return A4;
                }
                ILegoAdvert iLegoAdvert2 = this.n4;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = D4;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return I4;
                                        case 13:
                                            return H4;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return G4;
                        }
                        return F4;
                    }
                    return E4;
                }
                return null;
            }
            return A4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.f4;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.m4;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // c.a.s0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.position = i2;
            this.j4 = true;
        }
    }
}
