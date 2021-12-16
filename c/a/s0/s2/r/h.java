package c.a.s0.s2.r;

import c.a.r0.s.r.z1;
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
public class h implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f22532e;

    /* renamed from: f  reason: collision with root package name */
    public String f22533f;

    /* renamed from: g  reason: collision with root package name */
    public int f22534g;

    /* renamed from: h  reason: collision with root package name */
    public int f22535h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22536i;

    /* renamed from: j  reason: collision with root package name */
    public String f22537j;

    /* renamed from: k  reason: collision with root package name */
    public String f22538k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-940123276, "Lc/a/s0/s2/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-940123276, "Lc/a/s0/s2/r/h;");
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
        this.f22536i = false;
        if (forumData == null) {
            return;
        }
        this.f22532e = forumData.getName();
        this.f22533f = forumData.getImage_url();
        this.f22534g = forumData.getPost_num();
        this.f22535h = forumData.getMember_num();
        this.f22537j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // c.a.d.m.e.n
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
        this.f22536i = false;
        if (z1Var == null) {
            return;
        }
        this.f22532e = z1Var.f13488b;
        this.f22533f = z1Var.f13489c;
        this.f22534g = z1Var.f13494h;
        this.f22535h = z1Var.f13495i;
        this.f22537j = z1Var.a;
        this.l = z1Var.getIsLike();
    }
}
