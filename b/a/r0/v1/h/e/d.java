package b.a.r0.v1.h.e;

import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
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
/* loaded from: classes5.dex */
public class d implements n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f25850e;

    /* renamed from: f  reason: collision with root package name */
    public String f25851f;

    /* renamed from: g  reason: collision with root package name */
    public long f25852g;

    /* renamed from: h  reason: collision with root package name */
    public int f25853h;

    /* renamed from: i  reason: collision with root package name */
    public int f25854i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public long o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(4486994, "Lb/a/r0/v1/h/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(4486994, "Lb/a/r0/v1/h/e/d;");
                return;
            }
        }
        p = BdUniqueId.gen();
    }

    public d() {
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
        this.f25850e = "";
        this.f25851f = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25851f : (String) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? p : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25850e : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25852g : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : invokeV.intValue;
    }

    public void o(SugLiveInfo sugLiveInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, sugLiveInfo) == null) || sugLiveInfo == null) {
            return;
        }
        this.f25850e = sugLiveInfo.word;
        AlaLiveInfo alaLiveInfo = sugLiveInfo.ala_info;
        if (alaLiveInfo != null) {
            this.o = alaLiveInfo.room_id.longValue();
            this.f25853h = sugLiveInfo.ala_info.live_type.intValue();
            AlaUserInfo alaUserInfo = sugLiveInfo.ala_info.user_info;
            if (alaUserInfo != null) {
                this.f25852g = alaUserInfo.user_id.longValue();
            }
            YyExt yyExt = sugLiveInfo.ala_info.yy_ext;
            if (yyExt != null) {
                this.j = yyExt.sid;
                this.k = yyExt.ssid;
                this.l = yyExt.template_id;
                this.m = yyExt.yy_uid;
                int intValue = yyExt.is_yy_game.intValue();
                this.f25854i = intValue;
                this.n = q(this.f25853h, intValue);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f25851f = str;
        }
    }

    public final int q(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 0) {
                return 4;
            }
            if (i2 == 3 && i3 == 0) {
                return 2;
            }
            return (i2 == 3 && i3 == 1) ? 3 : 5;
        }
        return invokeII.intValue;
    }
}
