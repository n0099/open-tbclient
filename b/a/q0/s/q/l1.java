package b.a.q0.s.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes4.dex */
public class l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f13389a;

    /* renamed from: b  reason: collision with root package name */
    public String f13390b;

    /* renamed from: c  reason: collision with root package name */
    public int f13391c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13392d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13393e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-68411789, "Lb/a/q0/s/q/l1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-68411789, "Lb/a/q0/s/q/l1;");
                return;
            }
        }
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public l1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13390b = "0";
        this.f13389a = j;
    }

    public static l1 g(@NonNull WriteData writeData, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, writeData, i2)) == null) {
            l1 l1Var = new l1(writeData.startPublishTime());
            if (!TextUtils.isEmpty(writeData.getForumId())) {
                l1Var.f13390b = writeData.getForumId();
            }
            l1Var.f13393e = writeData.isWork();
            l1Var.f13391c = i2;
            return l1Var;
        }
        return (l1) invokeLI.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13391c : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f13392d = false;
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f13390b.equals(str) : invokeL.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13392d : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13393e : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l1) && this.f13389a == ((l1) obj).f13389a;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f13392d = z;
            if (this.f13389a > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
                if (this.f13393e && this.f13391c == 93) {
                    WorkPostNotifyFlutterData g2 = WorkPostNotifyFlutterData.g();
                    g2.i(b.a.r0.l3.s0.g.j().i());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, g2));
                }
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Objects.hash(Long.valueOf(this.f13389a)) : invokeV.intValue;
    }

    public void update(@NonNull l1 l1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l1Var) == null) {
            if (!l1Var.f13392d) {
                this.f13392d = false;
            }
            this.f13391c = l1Var.a();
        }
    }
}
