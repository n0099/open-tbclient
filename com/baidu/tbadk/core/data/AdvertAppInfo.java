package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.cn4;
import com.repackage.ep4;
import com.repackage.ga8;
import com.repackage.gd7;
import com.repackage.kh0;
import com.repackage.mg;
import com.repackage.sa8;
import com.repackage.sn4;
import com.repackage.tc7;
import com.repackage.vn4;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes3.dex */
public class AdvertAppInfo extends ThreadData implements ep4, sa8 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId C;
    public static final BdUniqueId D;
    public static final BdUniqueId E;
    public static final BdUniqueId F;
    public static final BdUniqueId G;
    public static final BdUniqueId H;
    public static final BdUniqueId I;
    public static AtomicBoolean v;
    public static final BdUniqueId w;
    public static final BdUniqueId x;
    public static final BdUniqueId y;
    public static final BdUniqueId z;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public ILegoAdvert i;
    public vn4 j;
    public String k;
    public int l;
    public App m;
    public String n;
    public String o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public kh0 u;

    /* loaded from: classes3.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        sn4 getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, com.repackage.uo
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
        v = new AtomicBoolean(false);
        w = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        x = BdUniqueId.gen();
        y = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        z = BdUniqueId.gen();
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
        C = BdUniqueId.gen();
        D = BdUniqueId.gen();
        E = BdUniqueId.gen();
        F = BdUniqueId.gen();
        G = BdUniqueId.gen();
        H = BdUniqueId.gen();
        I = BdUniqueId.gen();
    }

    public AdvertAppInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.i = null;
        this.l = 32;
    }

    @NonNull
    public static AdvertAppInfo v(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.d = optJSONObject.toString();
            advertAppInfo.y(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.repackage.sa8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            setPosition(i);
        }
    }

    @Override // com.repackage.sa8
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c == 1001 || getType() == w || getType() == x || getType() == y : invokeV.booleanValue;
    }

    @Override // com.repackage.ep4
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.a, this.a) && TextUtils.equals(advertAppInfo.h, this.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.b));
                ICardInfo j = tc7.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.i = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    this.l = 40;
                } else {
                    this.l = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? i() ? this.i.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.ThreadData, com.baidu.tieba.card.data.BaseCardInfo, com.repackage.uo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.c;
            if (i != 1001 && i != -1001) {
                if (!cn4.c().g() && (iLegoAdvert = this.i) != null && iLegoAdvert.isNoPicAd()) {
                    return w;
                }
                ILegoAdvert iLegoAdvert2 = this.i;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = z;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    switch (goodsStyle) {
                                        case 12:
                                            return E;
                                        case 13:
                                            return D;
                                        case 14:
                                            break;
                                        default:
                                            return bdUniqueId;
                                    }
                                }
                            }
                            return C;
                        }
                        return B;
                    }
                    return A;
                }
                return null;
            }
            return w;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.ep4
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.position : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.h;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c == 1001 || this.p != 3 || (iLegoAdvert = this.i) == null) {
                return false;
            }
            return iLegoAdvert.checkIsAppAdvert();
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ILegoAdvert iLegoAdvert = this.i;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 2 || goodsStyle == 8;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.c;
            if (i == 1001 || i == -1001) {
                return true;
            }
            return (this.p != 1 || TextUtils.isEmpty(this.q) || TextUtils.isEmpty(this.q.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ep4
    public AdvertAppInfo o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                ga8.B();
                return 31;
            } else if (!v.get()) {
                ga8.B();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.k) || TextUtils.equals("PIC_PAGE_BANNER", this.k) || !TextUtils.isEmpty(this.g)) {
                if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
                    return 28;
                }
                int i2 = this.c;
                if (i2 == 1001) {
                    return 0;
                }
                if (i2 == 11 || (i = this.b) == 31) {
                    return 12;
                }
                if (i == 25 || i == 10 || i == 9) {
                    return 37;
                }
                if (i == 99) {
                    return 41;
                }
                if (i == 26) {
                    return 45;
                }
                if (this.i == null) {
                    return this.l;
                }
                if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.a.trim())) {
                    return 24;
                }
                if (this.i.getAppInfoModel() == null || sn4.c(this.i.getAppInfoModel())) {
                    if (cn4.c().g() || this.i.isNoPicAd()) {
                        int i3 = this.p;
                        if (i3 == 3 || i3 == 1) {
                            if (this.p == 3) {
                                if (!i()) {
                                    return 26;
                                }
                                try {
                                    JSONObject optJSONObject = new JSONObject(this.d).optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
                                    if (optJSONObject != null) {
                                        if (optJSONObject.optBoolean("direcrt_download")) {
                                            return 43;
                                        }
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                            return (this.p != 1 || m()) ? 0 : 27;
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

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ILegoAdvert iLegoAdvert = this.i;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            return goodsStyle == 7 || goodsStyle == 14;
        }
        return invokeV.booleanValue;
    }

    public void s(App app) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || gd7.e(app.goods_info)) {
            return;
        }
        this.m = app;
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.c = goodsInfo.goods_style.intValue();
                try {
                    this.d = goodsInfo.lego_card;
                    y(new JSONObject(this.d));
                    return;
                } catch (JSONException unused) {
                    this.l = 38;
                    return;
                }
            }
        }
    }

    @Override // com.repackage.ep4
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.position = i;
            this.e = true;
        }
    }

    public final void y(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.b = optJSONObject.optInt("card_type");
                this.c = optJSONObject.optInt("goods_style");
                this.p = optJSONObject.optInt("url_type");
                this.a = optJSONObject.optString("id");
                this.h = optJSONObject.optString("ext_info");
                this.q = optJSONObject.optString("scheme");
                this.n = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString("pos", "");
                this.g = optString;
                this.position = mg.e(optString.trim(), -1);
                this.o = optJSONObject.optString("user_portrait");
                this.t = optJSONObject.optString("cmd_scheme");
                optJSONObject.optString("play_cmd_scheme");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
            if (optJSONObject2 != null) {
                this.s = optJSONObject2.optString("apk_name");
                this.r = optJSONObject2.optString("apk_url");
            }
            g(jSONObject);
        }
    }
}
