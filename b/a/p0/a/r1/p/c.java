package b.a.p0.a.r1.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f7748a;

    /* renamed from: b  reason: collision with root package name */
    public long f7749b;

    public c() {
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
        this.f7748a = new ArrayList();
        this.f7749b = -1L;
    }

    @Override // b.a.p0.a.r1.p.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<Long> list = this.f7748a;
            if (list == null || list.size() <= 0 || this.f7749b < 0) {
                return -1L;
            }
            return this.f7749b - ((Long) Collections.min(this.f7748a)).longValue();
        }
        return invokeV.longValue;
    }

    @Override // b.a.p0.a.r1.p.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f7749b = j;
        }
    }

    @Override // b.a.p0.a.r1.p.e
    public void c(long j) {
        List<Long> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || (list = this.f7748a) == null) {
            return;
        }
        list.add(Long.valueOf(j));
    }

    @Override // b.a.p0.a.r1.p.e
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "PageUpdateRender" : (String) invokeV.objValue;
    }
}
