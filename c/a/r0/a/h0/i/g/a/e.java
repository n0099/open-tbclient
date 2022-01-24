package c.a.r0.a.h0.i.g.a;

import c.a.r0.a.z2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6623b;

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
                return;
            }
        }
        this.a = new ArrayList();
        this.f6623b = false;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
            List<a> list = this.a;
            if (list != null && !list.isEmpty()) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (a aVar : this.a) {
                    if (aVar.c()) {
                        i2++;
                        if (aVar.b()) {
                            i3++;
                        } else {
                            i4++;
                        }
                    }
                }
                return String.format("\n%s jserror：共%d个，影响渲染%d个（框架%d个，开发者%d个）；", g2, Integer.valueOf(this.a.size()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            }
            return String.format("\n%s jserror：共0个；", g2);
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6623b : invokeV.booleanValue;
    }

    public void c(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.a = list;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f6623b = z;
        }
    }
}
