package c.a.p0.w2.q.j;

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
    public static final BdUniqueId n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f20516b;

    /* renamed from: c  reason: collision with root package name */
    public String f20517c;

    /* renamed from: d  reason: collision with root package name */
    public String f20518d;

    /* renamed from: e  reason: collision with root package name */
    public String f20519e;

    /* renamed from: f  reason: collision with root package name */
    public Long f20520f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20521g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20522h;
    public String i;
    public String j;
    public long k;
    public boolean l;
    public YyExtData m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-571045528, "Lc/a/p0/w2/q/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-571045528, "Lc/a/p0/w2/q/j/a;");
                return;
            }
        }
        n = BdUniqueId.gen();
    }

    public a() {
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
        this.f20521g = false;
        this.l = false;
    }

    public Long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20520f : (Long) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20517c : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? n : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20518d : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20519e : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20516b : (String) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20521g : invokeV.booleanValue;
    }

    public void r(@NonNull AlaLiveInfo alaLiveInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveInfo) == null) {
            this.a = alaLiveInfo.first_headline;
            this.f20516b = alaLiveInfo.second_headline;
            String str = alaLiveInfo.cover_wide;
            this.f20517c = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f20517c = alaLiveInfo.cover;
            }
            alaLiveInfo.live_id.longValue();
            YyExtData yyExtData = new YyExtData();
            this.m = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            this.k = alaUserInfo != null ? alaUserInfo.user_id.longValue() : 0L;
            this.f20522h = alaLiveInfo.live_from.intValue() == 1;
            this.i = alaLiveInfo.third_live_type;
            this.j = alaLiveInfo.third_room_id;
            String str2 = alaLiveInfo.router_type;
            this.f20518d = "";
            this.f20519e = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d8f);
            this.f20520f = 1L;
            this.f20521g = true;
            this.l = false;
        }
    }

    public void s(Promotion promotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, promotion) == null) {
            this.a = promotion.title;
            this.f20516b = promotion.sub_title;
            this.f20517c = promotion.image;
            this.f20518d = promotion.link;
            this.f20519e = promotion.link_text;
            this.f20520f = promotion.appear_time;
            this.f20521g = false;
            this.l = false;
        }
    }
}
