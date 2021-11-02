package b.a.q0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13358a;

    /* renamed from: b  reason: collision with root package name */
    public String f13359b;

    /* renamed from: c  reason: collision with root package name */
    public long f13360c;

    /* renamed from: d  reason: collision with root package name */
    public String f13361d;

    /* renamed from: e  reason: collision with root package name */
    public String f13362e;

    /* renamed from: f  reason: collision with root package name */
    public int f13363f;

    /* renamed from: g  reason: collision with root package name */
    public String f13364g;

    /* renamed from: h  reason: collision with root package name */
    public long f13365h;

    /* renamed from: i  reason: collision with root package name */
    public long f13366i;
    public long j;
    public int k;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13360c : invokeV.longValue;
    }
}
