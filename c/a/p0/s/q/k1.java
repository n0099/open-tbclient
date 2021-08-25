package c.a.p0.s.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes3.dex */
public class k1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f14284a;

    /* renamed from: b  reason: collision with root package name */
    public String f14285b;

    /* renamed from: c  reason: collision with root package name */
    public int f14286c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14287d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14288e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-377457870, "Lc/a/p0/s/q/k1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-377457870, "Lc/a/p0/s/q/k1;");
                return;
            }
        }
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public k1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14285b = "0";
        this.f14284a = j2;
    }

    public static k1 h(@NonNull WriteData writeData, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, writeData, i2)) == null) {
            k1 k1Var = new k1(writeData.startPublishTime());
            if (!TextUtils.isEmpty(writeData.getForumId())) {
                k1Var.f14285b = writeData.getForumId();
            }
            k1Var.f14288e = writeData.isWork();
            k1Var.f14286c = i2;
            return k1Var;
        }
        return (k1) invokeLI.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14286c : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14287d = false;
        }
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f14285b.equals(str) : invokeL.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14287d : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14288e : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k1) && this.f14284a == ((k1) obj).f14284a;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f14287d = z;
            if (this.f14284a > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
                if (this.f14288e && this.f14286c == 93) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, m2.c()));
                }
            }
        }
    }

    public void g(@NonNull k1 k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, k1Var) == null) {
            if (!k1Var.f14287d) {
                this.f14287d = false;
            }
            this.f14286c = k1Var.a();
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Objects.hash(Long.valueOf(this.f14284a)) : invokeV.intValue;
    }
}
