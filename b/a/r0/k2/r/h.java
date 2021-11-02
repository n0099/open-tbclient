package b.a.r0.k2.r;

import b.a.q0.s.q.z1;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h implements b.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f18766e;

    /* renamed from: f  reason: collision with root package name */
    public String f18767f;

    /* renamed from: g  reason: collision with root package name */
    public int f18768g;

    /* renamed from: h  reason: collision with root package name */
    public int f18769h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18770i;
    public String j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1251853998, "Lb/a/r0/k2/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1251853998, "Lb/a/r0/k2/r/h;");
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
        this.f18770i = false;
        if (forumData == null) {
            return;
        }
        this.f18766e = forumData.getName();
        this.f18767f = forumData.getImage_url();
        this.f18768g = forumData.getPost_num();
        this.f18769h = forumData.getMember_num();
        this.j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }

    public h(z1 z1Var) {
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
        this.f18770i = false;
        if (z1Var == null) {
            return;
        }
        this.f18766e = z1Var.f13506b;
        this.f18767f = z1Var.f13507c;
        this.f18768g = z1Var.f13512h;
        this.f18769h = z1Var.f13513i;
        this.j = z1Var.f13505a;
        this.l = z1Var.getIsLike();
    }
}
