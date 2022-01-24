package c.a.t0.t2.r;

import c.a.s0.s.q.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f22689e;

    /* renamed from: f  reason: collision with root package name */
    public String f22690f;

    /* renamed from: g  reason: collision with root package name */
    public int f22691g;

    /* renamed from: h  reason: collision with root package name */
    public int f22692h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22693i;

    /* renamed from: j  reason: collision with root package name */
    public String f22694j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249133100, "Lc/a/t0/t2/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-249133100, "Lc/a/t0/t2/r/h;");
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
        this.f22693i = false;
        if (forumData == null) {
            return;
        }
        this.f22689e = forumData.getName();
        this.f22690f = forumData.getImage_url();
        this.f22691g = forumData.getPost_num();
        this.f22692h = forumData.getMember_num();
        this.f22694j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // c.a.d.n.e.n
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
        this.f22693i = false;
        if (a2Var == null) {
            return;
        }
        this.f22689e = a2Var.f13459b;
        this.f22690f = a2Var.f13460c;
        this.f22691g = a2Var.f13465h;
        this.f22692h = a2Var.f13466i;
        this.f22694j = a2Var.a;
        this.l = a2Var.getIsLike();
    }
}
