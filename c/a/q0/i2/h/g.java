package c.a.q0.i2.h;

import c.a.p0.s.q.y1;
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
    public String f19072e;

    /* renamed from: f  reason: collision with root package name */
    public String f19073f;

    /* renamed from: g  reason: collision with root package name */
    public int f19074g;

    /* renamed from: h  reason: collision with root package name */
    public int f19075h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19076i;

    /* renamed from: j  reason: collision with root package name */
    public String f19077j;
    public String k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-832496425, "Lc/a/q0/i2/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-832496425, "Lc/a/q0/i2/h/g;");
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
        this.f19076i = false;
        if (forumData == null) {
            return;
        }
        this.f19072e = forumData.getName();
        this.f19073f = forumData.getImage_url();
        this.f19074g = forumData.getPost_num();
        this.f19075h = forumData.getMember_num();
        this.f19077j = forumData.getId();
        this.l = forumData.isLike() == 1;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }

    public g(y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19076i = false;
        if (y1Var == null) {
            return;
        }
        this.f19072e = y1Var.f14399b;
        this.f19073f = y1Var.f14400c;
        this.f19074g = y1Var.f14405h;
        this.f19075h = y1Var.f14406i;
        this.f19077j = y1Var.f14398a;
        this.l = y1Var.getIsLike();
    }
}
