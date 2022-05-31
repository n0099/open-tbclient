package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
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
import com.repackage.ag0;
import com.repackage.am4;
import com.repackage.b88;
import com.repackage.co4;
import com.repackage.db7;
import com.repackage.jg;
import com.repackage.qm4;
import com.repackage.r78;
import com.repackage.ra7;
import com.repackage.tm4;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes2.dex */
public class AdvertAppInfo extends ThreadData implements co4, b88 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId C;
    public static final BdUniqueId D;
    public static final BdUniqueId E;
    public static final BdUniqueId F;
    public static AtomicBoolean s;
    public static final BdUniqueId t;
    public static final BdUniqueId u;
    public static final BdUniqueId v;
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
    public String f;
    public String g;
    public ILegoAdvert h;
    public tm4 i;
    public String j;
    public int k;
    public String l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;
    public ag0 r;

    /* loaded from: classes2.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        qm4 getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, com.repackage.jn
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
        s = new AtomicBoolean(false);
        t = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        u = BdUniqueId.gen();
        v = BdUniqueId.gen();
        BdUniqueId.gen();
        BdUniqueId.gen();
        w = BdUniqueId.gen();
        x = BdUniqueId.gen();
        y = BdUniqueId.gen();
        z = BdUniqueId.gen();
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
        C = BdUniqueId.gen();
        D = BdUniqueId.gen();
        E = BdUniqueId.gen();
        F = BdUniqueId.gen();
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
        this.h = null;
        this.k = 32;
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

    @Override // com.repackage.b88
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            setPosition(i);
        }
    }

    @Override // com.repackage.b88
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c == 1001 || getType() == t || getType() == u || getType() == v : invokeV.booleanValue;
    }

    @Override // com.repackage.co4
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj != null && (obj instanceof AdvertAppInfo)) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                return TextUtils.equals(advertAppInfo.a, this.a) && TextUtils.equals(advertAppInfo.g, this.g);
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
                ICardInfo j = ra7.j(jSONObject);
                if (j instanceof ILegoAdvert) {
                    ILegoAdvert iLegoAdvert = (ILegoAdvert) j;
                    this.h = iLegoAdvert;
                    iLegoAdvert.setAdvertAppInfo(this);
                }
            } catch (CardParseException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    this.k = 40;
                } else {
                    this.k = 39;
                }
            } catch (JSONException unused) {
            }
        }
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? i() ? this.h.getDownloadId() : "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.data.ThreadData, com.baidu.tieba.card.data.BaseCardInfo, com.repackage.jn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.c;
            if (i != 1001 && i != -1001) {
                if (!am4.c().g() && (iLegoAdvert = this.h) != null && iLegoAdvert.isNoPicAd()) {
                    return t;
                }
                ILegoAdvert iLegoAdvert2 = this.h;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = w;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 14) {
                            if (goodsStyle == 6) {
                                return y;
                            }
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    return bdUniqueId;
                                }
                            }
                        }
                        return z;
                    }
                    return x;
                }
                return null;
            }
            return t;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.co4
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
            String str2 = this.g;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c == 1001 || this.m != 3 || (iLegoAdvert = this.h) == null) {
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
            ILegoAdvert iLegoAdvert = this.h;
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
            return (this.m != 1 || TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.n.trim())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.co4
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
                r78.n();
                return 31;
            } else if (!s.get()) {
                r78.n();
                return 31;
            } else if (TextUtils.equals("PB_BANNER", this.j) || TextUtils.equals("PIC_PAGE_BANNER", this.j) || !TextUtils.isEmpty(this.f)) {
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
                if (this.h == null) {
                    return this.k;
                }
                if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.a.trim())) {
                    return 24;
                }
                if (this.h.getAppInfoModel() == null || qm4.c(this.h.getAppInfoModel())) {
                    if (am4.c().g() || this.h.isNoPicAd()) {
                        int i3 = this.m;
                        if (i3 == 3 || i3 == 1) {
                            if (this.m == 3) {
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
                            return (this.m != 1 || m()) ? 0 : 27;
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
            ILegoAdvert iLegoAdvert = this.h;
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
        if (!(interceptable == null || interceptable.invokeL(1048592, this, app) == null) || app == null || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || db7.e(app.goods_info)) {
            return;
        }
        for (GoodsInfo goodsInfo : app.goods_info) {
            if (goodsInfo != null) {
                this.c = goodsInfo.goods_style.intValue();
                try {
                    this.d = goodsInfo.lego_card;
                    y(new JSONObject(this.d));
                    return;
                } catch (JSONException unused) {
                    this.k = 38;
                    return;
                }
            }
        }
    }

    @Override // com.repackage.co4
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
                this.m = optJSONObject.optInt("url_type");
                this.a = optJSONObject.optString("id");
                this.g = optJSONObject.optString("ext_info");
                this.n = optJSONObject.optString("scheme");
                this.l = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString("pos", "");
                this.f = optString;
                this.position = jg.e(optString.trim(), -1);
                optJSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
                this.q = optJSONObject.optString("cmd_scheme");
                optJSONObject.optString("play_cmd_scheme");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
            if (optJSONObject2 != null) {
                this.p = optJSONObject2.optString("apk_name");
                this.o = optJSONObject2.optString("apk_url");
            }
            g(jSONObject);
        }
    }
}
