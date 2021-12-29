package c.a.s0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f13734b;

    /* renamed from: c  reason: collision with root package name */
    public long f13735c;

    /* renamed from: d  reason: collision with root package name */
    public String f13736d;

    /* renamed from: e  reason: collision with root package name */
    public String f13737e;

    /* renamed from: f  reason: collision with root package name */
    public int f13738f;

    /* renamed from: g  reason: collision with root package name */
    public String f13739g;

    /* renamed from: h  reason: collision with root package name */
    public long f13740h;

    /* renamed from: i  reason: collision with root package name */
    public long f13741i;

    /* renamed from: j  reason: collision with root package name */
    public long f13742j;

    /* renamed from: k  reason: collision with root package name */
    public int f13743k;
    public int l;
    public long m;
    public long n;
    public String o;
    public long p;
    public int q;
    public int r;
    public int s;

    public j0() {
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

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13742j : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13735c : invokeV.longValue;
    }
}
