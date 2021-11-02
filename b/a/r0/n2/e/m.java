package b.a.r0.n2.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f21472a;

    /* renamed from: b  reason: collision with root package name */
    public Long f21473b;

    /* renamed from: c  reason: collision with root package name */
    public String f21474c;

    /* renamed from: d  reason: collision with root package name */
    public String f21475d;

    /* renamed from: e  reason: collision with root package name */
    public String f21476e;

    /* renamed from: f  reason: collision with root package name */
    public String f21477f;

    /* renamed from: g  reason: collision with root package name */
    public String f21478g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f21479h;

    public m(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {smartApp};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21472a = 0;
        if (smartApp == null) {
            return;
        }
        this.f21473b = smartApp.swan_app_id;
        this.f21474c = smartApp.id;
        this.f21475d = smartApp.avatar;
        this.f21476e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f21477f = smartApp.h5_url;
        this.f21478g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f21472a = 1;
        }
        this.f21479h = smartApp.is_game;
    }

    public Long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21473b : (Long) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21474c : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21475d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21477f : (String) invokeV.objValue;
    }

    public Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21479h : (Integer) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21478g : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21476e : (String) invokeV.objValue;
    }

    @Override // b.a.r0.n2.e.c
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21472a : invokeV.intValue;
    }
}
