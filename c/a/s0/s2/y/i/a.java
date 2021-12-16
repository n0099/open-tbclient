package c.a.s0.s2.y.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s2.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.Promotion;
/* loaded from: classes8.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f23521e;

    /* renamed from: f  reason: collision with root package name */
    public String f23522f;

    /* renamed from: g  reason: collision with root package name */
    public String f23523g;

    /* renamed from: h  reason: collision with root package name */
    public String f23524h;

    /* renamed from: i  reason: collision with root package name */
    public String f23525i;

    /* renamed from: j  reason: collision with root package name */
    public Long f23526j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23527k;
    public boolean l;
    public String m;
    public String n;
    public long o;
    public boolean p;
    public YyExtData q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1314910694, "Lc/a/s0/s2/y/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1314910694, "Lc/a/s0/s2/y/i/a;");
                return;
            }
        }
        r = BdUniqueId.gen();
    }

    public a() {
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
        this.f23527k = false;
        this.p = false;
    }

    public Long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23526j : (Long) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23521e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? r : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23523g : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23524h : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23525i : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23522f : (String) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23527k : invokeV.booleanValue;
    }

    public void t(@NonNull AlaLiveInfo alaLiveInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveInfo) == null) {
            this.f23521e = alaLiveInfo.first_headline;
            this.f23522f = alaLiveInfo.second_headline;
            String str = alaLiveInfo.cover_wide;
            this.f23523g = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f23523g = alaLiveInfo.cover;
            }
            alaLiveInfo.live_id.longValue();
            YyExtData yyExtData = new YyExtData();
            this.q = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            this.o = alaUserInfo != null ? alaUserInfo.user_id.longValue() : 0L;
            this.l = alaLiveInfo.live_from.intValue() == 1;
            this.m = alaLiveInfo.third_live_type;
            this.n = alaLiveInfo.third_room_id;
            String str2 = alaLiveInfo.router_type;
            this.f23524h = "";
            this.f23525i = TbadkCoreApplication.getInst().getString(l.pb_ala_enter);
            this.f23526j = 1L;
            this.f23527k = true;
            this.p = false;
        }
    }

    public void w(Promotion promotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, promotion) == null) {
            this.f23521e = promotion.title;
            this.f23522f = promotion.sub_title;
            this.f23523g = promotion.image;
            this.f23524h = promotion.link;
            this.f23525i = promotion.link_text;
            this.f23526j = promotion.appear_time;
            this.f23527k = false;
            this.p = false;
        }
    }
}
