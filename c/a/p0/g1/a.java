package c.a.p0.g1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15127b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15128c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15129d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15130e;

    /* renamed from: f  reason: collision with root package name */
    public final double f15131f;

    public a(String str, String str2, String str3, int i, int i2, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f15127b = str2;
        this.f15129d = i;
        this.f15128c = str3;
        this.f15130e = i2;
        this.f15131f = d2;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "FunAdCacheInfo{adType='" + this.a + "', platform='" + this.f15127b + "', pid='" + this.f15128c + "', adHashCode=" + this.f15129d + ", count=" + this.f15130e + ", basePrice=" + this.f15131f + '}';
        }
        return (String) invokeV.objValue;
    }
}
