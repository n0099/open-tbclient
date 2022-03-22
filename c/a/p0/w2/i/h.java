package c.a.p0.w2.i;

import c.a.o0.r.r.x1;
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
    public static BdUniqueId i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19822b;

    /* renamed from: c  reason: collision with root package name */
    public int f19823c;

    /* renamed from: d  reason: collision with root package name */
    public int f19824d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19825e;

    /* renamed from: f  reason: collision with root package name */
    public String f19826f;

    /* renamed from: g  reason: collision with root package name */
    public String f19827g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19828h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1095803452, "Lc/a/p0/w2/i/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1095803452, "Lc/a/p0/w2/i/h;");
                return;
            }
        }
        i = BdUniqueId.gen();
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
        this.f19825e = false;
        if (forumData == null) {
            return;
        }
        this.a = forumData.getName();
        this.f19822b = forumData.getImage_url();
        this.f19823c = forumData.getPost_num();
        this.f19824d = forumData.getMember_num();
        this.f19826f = forumData.getId();
        this.f19828h = forumData.isLike() == 1;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? i : (BdUniqueId) invokeV.objValue;
    }

    public h(x1 x1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19825e = false;
        if (x1Var == null) {
            return;
        }
        this.a = x1Var.f10991b;
        this.f19822b = x1Var.f10992c;
        this.f19823c = x1Var.f10997h;
        this.f19824d = x1Var.i;
        this.f19826f = x1Var.a;
        this.f19828h = x1Var.getIsLike();
    }
}
