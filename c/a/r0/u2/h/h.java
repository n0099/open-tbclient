package c.a.r0.u2.h;

import c.a.q0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f23101e;

    /* renamed from: f  reason: collision with root package name */
    public String f23102f;

    /* renamed from: g  reason: collision with root package name */
    public int f23103g;

    /* renamed from: h  reason: collision with root package name */
    public int f23104h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23105i;

    /* renamed from: j  reason: collision with root package name */
    public String f23106j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1031099681, "Lc/a/r0/u2/h/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1031099681, "Lc/a/r0/u2/h/h;");
                return;
            }
        }
        m = BdUniqueId.gen();
    }

    public h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumData};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f23105i = false;
        if (forumData == null) {
            return;
        }
        this.f23101e = forumData.getName();
        this.f23102f = forumData.getImage_url();
        this.f23103g = forumData.getPost_num();
        this.f23104h = forumData.getMember_num();
        this.f23106j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }

    public h(a2 a2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23105i = false;
        if (a2Var == null) {
            return;
        }
        this.f23101e = a2Var.f13159b;
        this.f23102f = a2Var.f13160c;
        this.f23103g = a2Var.f13165h;
        this.f23104h = a2Var.f13166i;
        this.f23106j = a2Var.a;
        this.l = a2Var.getIsLike();
    }
}
