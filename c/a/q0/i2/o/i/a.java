package c.a.q0.i2.o.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20126e;

    /* renamed from: f  reason: collision with root package name */
    public String f20127f;

    /* renamed from: g  reason: collision with root package name */
    public String f20128g;

    /* renamed from: h  reason: collision with root package name */
    public String f20129h;

    /* renamed from: i  reason: collision with root package name */
    public String f20130i;

    /* renamed from: j  reason: collision with root package name */
    public Long f20131j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;
    public long o;
    public boolean p;
    public YyExtData q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-964692196, "Lc/a/q0/i2/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-964692196, "Lc/a/q0/i2/o/i/a;");
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
        this.k = false;
        this.p = false;
    }

    public Long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20131j : (Long) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20126e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? r : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20128g : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20129h : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20130i : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20127f : (String) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void t(@NonNull AlaLiveInfo alaLiveInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveInfo) == null) {
            this.f20126e = alaLiveInfo.first_headline;
            this.f20127f = alaLiveInfo.second_headline;
            String str = alaLiveInfo.cover_wide;
            this.f20128g = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f20128g = alaLiveInfo.cover;
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
            this.f20129h = "";
            this.f20130i = TbadkCoreApplication.getInst().getString(R.string.pb_ala_enter);
            this.f20131j = 1L;
            this.k = true;
            this.p = false;
        }
    }

    public void w(Promotion promotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, promotion) == null) {
            this.f20126e = promotion.title;
            this.f20127f = promotion.sub_title;
            this.f20128g = promotion.image;
            this.f20129h = promotion.link;
            this.f20130i = promotion.link_text;
            this.f20131j = promotion.appear_time;
            this.k = false;
            this.p = false;
        }
    }
}
