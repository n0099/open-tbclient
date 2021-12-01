package c.a.r0.q2.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes6.dex */
public class q implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public static final BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f21554e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f21555f;

    /* renamed from: g  reason: collision with root package name */
    public int f21556g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21557h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21558i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f21559j;

    /* renamed from: k  reason: collision with root package name */
    public List<PbSortType> f21560k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776350442, "Lc/a/r0/q2/r/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776350442, "Lc/a/r0/q2/r/q;");
                return;
            }
        }
        l = BdUniqueId.gen();
        m = BdUniqueId.gen();
    }

    public q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21555f = m;
        this.f21556g = 0;
        this.f21557h = false;
        this.f21555f = bdUniqueId;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21555f : (BdUniqueId) invokeV.objValue;
    }
}
