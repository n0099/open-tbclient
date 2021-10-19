package c.a.r0.k2.h;

import c.a.q0.s.q.z1;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19813e;

    /* renamed from: f  reason: collision with root package name */
    public String f19814f;

    /* renamed from: g  reason: collision with root package name */
    public int f19815g;

    /* renamed from: h  reason: collision with root package name */
    public int f19816h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19817i;

    /* renamed from: j  reason: collision with root package name */
    public String f19818j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(745997432, "Lc/a/r0/k2/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(745997432, "Lc/a/r0/k2/h/g;");
                return;
            }
        }
        m = BdUniqueId.gen();
    }

    public g(ForumData forumData) {
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
        this.f19817i = false;
        if (forumData == null) {
            return;
        }
        this.f19813e = forumData.getName();
        this.f19814f = forumData.getImage_url();
        this.f19815g = forumData.getPost_num();
        this.f19816h = forumData.getMember_num();
        this.f19818j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }

    public g(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19817i = false;
        if (z1Var == null) {
            return;
        }
        this.f19813e = z1Var.f14394b;
        this.f19814f = z1Var.f14395c;
        this.f19815g = z1Var.f14400h;
        this.f19816h = z1Var.f14401i;
        this.f19818j = z1Var.f14393a;
        this.l = z1Var.getIsLike();
    }
}
