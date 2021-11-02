package b.a.q0.s.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes4.dex */
public class u1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13455a;

    /* renamed from: b  reason: collision with root package name */
    public String f13456b;

    /* renamed from: c  reason: collision with root package name */
    public String f13457c;

    /* renamed from: d  reason: collision with root package name */
    public String f13458d;

    /* renamed from: e  reason: collision with root package name */
    public int f13459e;

    public u1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13455a = "";
        this.f13456b = "";
        this.f13457c = "";
        this.f13458d = "";
        this.f13459e = -1;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13458d : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13459e : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13457c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13455a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13456b : (String) invokeV.objValue;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, schoolRecomUserInfo) == null) || schoolRecomUserInfo == null) {
            return;
        }
        this.f13455a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f13456b = schoolRecomUserInfo.uname;
        this.f13457c = schoolRecomUserInfo.portrait;
        this.f13458d = schoolRecomUserInfo.institute;
        this.f13459e = schoolRecomUserInfo.is_liked.intValue();
    }
}
