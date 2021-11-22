package b.a.r0.x0.w2;

import b.a.r0.x0.p1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28051a;

    /* renamed from: b  reason: collision with root package name */
    public int f28052b;

    /* renamed from: c  reason: collision with root package name */
    public p1 f28053c;

    /* renamed from: d  reason: collision with root package name */
    public String f28054d;

    /* renamed from: e  reason: collision with root package name */
    public int f28055e;

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
            if (this.f28052b == eVar.f28052b && (str = this.f28051a) != null && str.equals(eVar.f28051a)) {
                return true;
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }
}
