package c.a.r0.j.u.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e implements c.a.r0.j.u.c.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.j.u.c.f
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/user/addiction/gamevalid", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/minigame/get_game_tencent_ads", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/msgame/reservation/query", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/report/download", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/msgame/adblock", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", u())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/exchange/transfer_report", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/user/addiction/polling", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/user/addiction/realname", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/user/rechargecheck", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/od/get_friend_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/user/gamehistory/upload", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/od/remove_user_cloud_storage", c.a.r0.a.d0.a.c())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/msgame/reservation/auto_download/finish", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/od/set_user_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/exchange/list", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/user/addiction/behavior_report", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/od/get_user_info", u())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/ma/game/od/get_user_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.j.u.c.f
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c.a.r0.a.d0.c.v(String.format("%s/api/minigame/get_return_guide_config", c.a.r0.a.d0.a.a())) : (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? c.a.r0.a.d0.c.a : (String) invokeV.objValue;
    }
}
