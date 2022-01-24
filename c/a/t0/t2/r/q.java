package c.a.t0.t2.r;

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
/* loaded from: classes8.dex */
public class q implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public static final BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f22716e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f22717f;

    /* renamed from: g  reason: collision with root package name */
    public int f22718g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22719h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22720i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22721j;
    public List<PbSortType> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249132821, "Lc/a/t0/t2/r/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-249132821, "Lc/a/t0/t2/r/q;");
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
        this.f22717f = m;
        this.f22718g = 0;
        this.f22719h = false;
        this.f22717f = bdUniqueId;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22717f : (BdUniqueId) invokeV.objValue;
    }
}
