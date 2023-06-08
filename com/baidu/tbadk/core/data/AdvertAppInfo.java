package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.j15;
import com.baidu.tieba.km9;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.m15;
import com.baidu.tieba.mo8;
import com.baidu.tieba.n05;
import com.baidu.tieba.nj0;
import com.baidu.tieba.tg;
import com.baidu.tieba.um9;
import com.baidu.tieba.y25;
import com.baidu.tieba.yo8;
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
/* loaded from: classes4.dex */
public class AdvertAppInfo extends ThreadData implements y25, um9 {
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
    public String f;
    public String g;
    public ILegoAdvert h;
    public m15 i;
    public String j;
    public int k;
    public String l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;
    public nj0 r;
    public int s;
    public String t;
    public int u;

    /* loaded from: classes4.dex */
    public interface ILegoAdvert extends ICardInfo {
        boolean checkIsAppAdvert();

        boolean forFree();

        AdvertAppInfo getAdvertAppInfo();

        j15 getAppInfoModel();

        @NonNull
        String getDownloadId();

        String getDownloadKey();

        String getExtInfo();

        int getGoodsStyle();

        @Override // com.baidu.tieba.lego.card.model.ICardInfo, com.baidu.tieba.vn
        /* synthetic */ BdUniqueId getType();

        boolean isNoPicAd();

        void setAdvertAppInfo(AdvertAppInfo advertAppInfo);
    }

    @Override // com.baidu.tieba.y25
    public AdvertAppInfo G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (AdvertAppInfo) invokeV.objValue;
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
        this.h = null;
        this.k = 32;
        this.s = 0;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c != 1001 && this.m == 3 && (iLegoAdvert = this.h) != null) {
                return iLegoAdvert.checkIsAppAdvert();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ILegoAdvert iLegoAdvert = this.h;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            if (goodsStyle != 2 && goodsStyle != 8) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (e()) {
                return this.h.getDownloadId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String str = this.a;
            int i2 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            String str2 = this.g;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return i + i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.y25
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ILegoAdvert iLegoAdvert = this.h;
            if (iLegoAdvert == null) {
                return false;
            }
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            if (goodsStyle != 7 && goodsStyle != 14) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y25
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.position;
        }
        return invokeV.intValue;
    }

    @NonNull
    public static AdvertAppInfo m(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("lego_card");
            advertAppInfo.d = optJSONObject.toString();
            advertAppInfo.n(optJSONObject);
            return advertAppInfo;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.um9
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            setPosition(i);
        }
    }

    @Override // com.baidu.tieba.y25
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.position = i;
            this.e = true;
        }
    }

    @Override // com.baidu.tieba.um9
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c != 1001 && getType() != w && getType() != x && getType() != y) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.c;
            if (i == 1001 || i == -1001) {
                return true;
            }
            if (this.m == 1 && !TextUtils.isEmpty(this.n) && !TextUtils.isEmpty(this.n.trim())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            try {
                jSONObject.putOpt("card_type", Integer.valueOf(this.b));
                ICardInfo j = mo8.j(jSONObject);
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null || !(obj instanceof AdvertAppInfo)) {
                return false;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            if (!TextUtils.equals(advertAppInfo.a, this.a) || !TextUtils.equals(advertAppInfo.g, this.g)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.data.ThreadData, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.vn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.c;
            if (i != 1001 && i != -1001) {
                if (!n05.c().g() && (iLegoAdvert = this.h) != null && iLegoAdvert.isNoPicAd()) {
                    return w;
                }
                ILegoAdvert iLegoAdvert2 = this.h;
                if (iLegoAdvert2 != null) {
                    BdUniqueId bdUniqueId = z;
                    int goodsStyle = iLegoAdvert2.getGoodsStyle();
                    if (goodsStyle != 2) {
                        if (goodsStyle != 14) {
                            if (goodsStyle != 6) {
                                if (goodsStyle != 7) {
                                    if (goodsStyle != 8) {
                                        return bdUniqueId;
                                    }
                                }
                            } else {
                                return B;
                            }
                        }
                        return C;
                    }
                    return A;
                }
                return null;
            }
            return w;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                km9.n();
                return 31;
            } else if (!v.get()) {
                km9.n();
                return 31;
            } else if (!TextUtils.equals("PB_BANNER", this.j) && !TextUtils.equals("PIC_PAGE_BANNER", this.j) && TextUtils.isEmpty(this.f)) {
                return 23;
            } else {
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
                if (i != 25 && i != 10 && i != 9) {
                    if (i == 99) {
                        return 41;
                    }
                    if (i == 26) {
                        return 45;
                    }
                    if (this.h == null) {
                        return this.k;
                    }
                    if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.a.trim())) {
                        if (this.h.getAppInfoModel() != null && !j15.c(this.h.getAppInfoModel())) {
                            return 42;
                        }
                        if (!n05.c().g() && !this.h.isNoPicAd()) {
                            return 34;
                        }
                        int i3 = this.m;
                        if (i3 != 3 && i3 != 1) {
                            return 21;
                        }
                        if (this.m == 3) {
                            if (!e()) {
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
                        if (this.m != 1 || h()) {
                            return 0;
                        }
                        return 27;
                    }
                    return 24;
                }
                return 37;
            }
        }
        return invokeV.intValue;
    }

    public void l(App app) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, app) == null) && app != null && SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 1 && !yo8.e(app.goods_info)) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.c = goodsInfo.goods_style.intValue();
                    try {
                        this.d = goodsInfo.lego_card;
                        n(new JSONObject(this.d));
                        return;
                    } catch (JSONException unused) {
                        this.k = 38;
                        return;
                    }
                }
            }
        }
    }

    public final void n(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject != null) {
                this.b = optJSONObject.optInt("card_type");
                this.c = optJSONObject.optInt("goods_style");
                this.m = optJSONObject.optInt("url_type");
                this.a = optJSONObject.optString("id");
                this.g = optJSONObject.optString(MigrateStatisticUtils.EXT_INFO);
                this.n = optJSONObject.optString("scheme");
                this.l = optJSONObject.optString("user_name");
                String optString = optJSONObject.optString("pos", "");
                this.f = optString;
                this.position = tg.e(optString.trim(), -1);
                optJSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
                this.q = optJSONObject.optString("cmd_scheme");
                optJSONObject.optString("play_cmd_scheme");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO);
            if (optJSONObject2 != null) {
                this.p = optJSONObject2.optString("apk_name");
                this.o = optJSONObject2.optString("apk_url");
            }
            d(jSONObject);
        }
    }
}
