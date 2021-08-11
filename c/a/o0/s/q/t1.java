package c.a.o0.s.q;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes3.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14044a;

    /* renamed from: b  reason: collision with root package name */
    public String f14045b;

    /* renamed from: c  reason: collision with root package name */
    public String f14046c;

    /* renamed from: d  reason: collision with root package name */
    public String f14047d;

    /* renamed from: e  reason: collision with root package name */
    public int f14048e;

    public t1() {
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
        this.f14044a = "";
        this.f14045b = "";
        this.f14046c = "";
        this.f14047d = "";
        this.f14048e = -1;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14047d : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14048e : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14046c : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14044a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14045b : (String) invokeV.objValue;
    }

    public void f(SchoolRecomUserInfo schoolRecomUserInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, schoolRecomUserInfo) == null) || schoolRecomUserInfo == null) {
            return;
        }
        this.f14044a = StringUtils.string(schoolRecomUserInfo.uid);
        this.f14045b = schoolRecomUserInfo.uname;
        this.f14046c = schoolRecomUserInfo.portrait;
        this.f14047d = schoolRecomUserInfo.institute;
        this.f14048e = schoolRecomUserInfo.is_liked.intValue();
    }
}
