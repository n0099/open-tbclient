package c.a.t0.s2.r;

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
    public String f22410e;

    /* renamed from: f  reason: collision with root package name */
    public String f22411f;

    /* renamed from: g  reason: collision with root package name */
    public int f22412g;

    /* renamed from: h  reason: collision with root package name */
    public int f22413h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22414i;

    /* renamed from: j  reason: collision with root package name */
    public String f22415j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136636781, "Lc/a/t0/s2/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136636781, "Lc/a/t0/s2/r/h;");
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
        this.f22414i = false;
        if (forumData == null) {
            return;
        }
        this.f22410e = forumData.getName();
        this.f22411f = forumData.getImage_url();
        this.f22412g = forumData.getPost_num();
        this.f22413h = forumData.getMember_num();
        this.f22415j = forumData.getId();
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
        this.f22414i = false;
        if (a2Var == null) {
            return;
        }
        this.f22410e = a2Var.f13273b;
        this.f22411f = a2Var.f13274c;
        this.f22412g = a2Var.f13279h;
        this.f22413h = a2Var.f13280i;
        this.f22415j = a2Var.a;
        this.l = a2Var.getIsLike();
    }
}
