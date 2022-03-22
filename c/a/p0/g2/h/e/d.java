package c.a.p0.g2.h.e;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.SugLiveInfo;
import tbclient.YyExt;
/* loaded from: classes2.dex */
public class d implements n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f15189b;

    /* renamed from: c  reason: collision with root package name */
    public long f15190c;

    /* renamed from: d  reason: collision with root package name */
    public int f15191d;

    /* renamed from: e  reason: collision with root package name */
    public int f15192e;

    /* renamed from: f  reason: collision with root package name */
    public String f15193f;

    /* renamed from: g  reason: collision with root package name */
    public String f15194g;

    /* renamed from: h  reason: collision with root package name */
    public String f15195h;
    public String i;
    public int j;
    public long k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1974356413, "Lc/a/p0/g2/h/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1974356413, "Lc/a/p0/g2/h/e/d;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public d() {
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
        this.a = "";
        this.f15189b = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15189b : (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15193f : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15194g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15195h : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15190c : invokeV.longValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.intValue;
    }

    public void n(SugLiveInfo sugLiveInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, sugLiveInfo) == null) || sugLiveInfo == null) {
            return;
        }
        this.a = sugLiveInfo.word;
        AlaLiveInfo alaLiveInfo = sugLiveInfo.ala_info;
        if (alaLiveInfo != null) {
            this.k = alaLiveInfo.room_id.longValue();
            this.f15191d = sugLiveInfo.ala_info.live_type.intValue();
            AlaUserInfo alaUserInfo = sugLiveInfo.ala_info.user_info;
            if (alaUserInfo != null) {
                this.f15190c = alaUserInfo.user_id.longValue();
            }
            YyExt yyExt = sugLiveInfo.ala_info.yy_ext;
            if (yyExt != null) {
                this.f15193f = yyExt.sid;
                this.f15194g = yyExt.ssid;
                this.f15195h = yyExt.template_id;
                this.i = yyExt.yy_uid;
                int intValue = yyExt.is_yy_game.intValue();
                this.f15192e = intValue;
                this.j = q(this.f15191d, intValue);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15189b = str;
        }
    }

    public final int q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            if (i == 1) {
                return 1;
            }
            if (i == 0) {
                return 4;
            }
            if (i == 3 && i2 == 0) {
                return 2;
            }
            return (i == 3 && i2 == 1) ? 3 : 5;
        }
        return invokeII.intValue;
    }
}
