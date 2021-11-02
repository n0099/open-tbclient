package b.a.r0.x0.v2;

import b.a.r0.x0.o1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f26451a;

    /* renamed from: b  reason: collision with root package name */
    public int f26452b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f26453c;

    /* renamed from: d  reason: collision with root package name */
    public String f26454d;

    /* renamed from: e  reason: collision with root package name */
    public int f26455e;

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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null || !(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f26452b == eVar.f26452b && (str = this.f26451a) != null && str.equals(eVar.f26451a)) {
                return true;
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }
}
