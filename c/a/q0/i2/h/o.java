package c.a.q0.i2.h;

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
/* loaded from: classes3.dex */
public class o implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public static final BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19101e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f19102f;

    /* renamed from: g  reason: collision with root package name */
    public int f19103g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19104h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19105i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19106j;
    public List<PbSortType> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-832496177, "Lc/a/q0/i2/h/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-832496177, "Lc/a/q0/i2/h/o;");
                return;
            }
        }
        l = BdUniqueId.gen();
        m = BdUniqueId.gen();
    }

    public o(BdUniqueId bdUniqueId) {
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
        this.f19102f = m;
        this.f19103g = 0;
        this.f19104h = false;
        this.f19102f = bdUniqueId;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19102f : (BdUniqueId) invokeV.objValue;
    }
}
