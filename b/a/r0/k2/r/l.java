package b.a.r0.k2.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f18779a;

    /* renamed from: b  reason: collision with root package name */
    public int f18780b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f18781c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f18782d;

    /* renamed from: e  reason: collision with root package name */
    public String f18783e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18784f;

    /* renamed from: g  reason: collision with root package name */
    public int f18785g;

    /* renamed from: h  reason: collision with root package name */
    public int f18786h;

    public l() {
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

    public static l i(ManagerElection managerElection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, managerElection)) == null) {
            if (managerElection == null) {
                return null;
            }
            l lVar = new l();
            managerElection.begin_vote_time.intValue();
            lVar.f18779a = managerElection.can_vote.intValue() == 1;
            lVar.f18780b = managerElection.vote_num.intValue();
            lVar.f18784f = managerElection.is_show_distribute.intValue() == 1;
            lVar.f18785g = managerElection.remainder_time.intValue();
            lVar.f18786h = managerElection.status.intValue();
            lVar.f18783e = managerElection.tail_text;
            List<String> list = managerElection.vote_condition_pic;
            lVar.f18781c = managerElection.vote_condition_title;
            lVar.f18782d = managerElection.vote_condition;
            return lVar;
        }
        return (l) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18779a : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18784f : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18785g : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18786h : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18783e : (String) invokeV.objValue;
    }

    public List<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18782d : (List) invokeV.objValue;
    }

    public List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18781c : (List) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18780b : invokeV.intValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f18779a = z;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f18786h = i2;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f18780b = i2;
        }
    }
}
