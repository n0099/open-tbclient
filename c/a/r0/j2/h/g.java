package c.a.r0.j2.h;

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
    public String f19621e;

    /* renamed from: f  reason: collision with root package name */
    public String f19622f;

    /* renamed from: g  reason: collision with root package name */
    public int f19623g;

    /* renamed from: h  reason: collision with root package name */
    public int f19624h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19625i;

    /* renamed from: j  reason: collision with root package name */
    public String f19626j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-141506249, "Lc/a/r0/j2/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-141506249, "Lc/a/r0/j2/h/g;");
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
        this.f19625i = false;
        if (forumData == null) {
            return;
        }
        this.f19621e = forumData.getName();
        this.f19622f = forumData.getImage_url();
        this.f19623g = forumData.getPost_num();
        this.f19624h = forumData.getMember_num();
        this.f19626j = forumData.getId();
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
        this.f19625i = false;
        if (z1Var == null) {
            return;
        }
        this.f19621e = z1Var.f14374b;
        this.f19622f = z1Var.f14375c;
        this.f19623g = z1Var.f14380h;
        this.f19624h = z1Var.f14381i;
        this.f19626j = z1Var.f14373a;
        this.l = z1Var.getIsLike();
    }
}
