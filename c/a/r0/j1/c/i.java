package c.a.r0.j1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.PkModule;
import tbclient.Hottopic.PkView;
/* loaded from: classes3.dex */
public class i implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19474e;

    /* renamed from: f  reason: collision with root package name */
    public String f19475f;

    /* renamed from: g  reason: collision with root package name */
    public String f19476g;

    /* renamed from: h  reason: collision with root package name */
    public long f19477h;

    /* renamed from: i  reason: collision with root package name */
    public String f19478i;

    /* renamed from: j  reason: collision with root package name */
    public long f19479j;
    public int k;
    public long l;
    public long m;
    public long n;
    public long o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-170284293, "Lc/a/r0/j1/c/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-170284293, "Lc/a/r0/j1/c/i;");
                return;
            }
        }
        p = BdUniqueId.gen();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void b(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null) {
            return;
        }
        this.f19474e = pkModule.module_name;
        this.f19475f = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f19476g = pkView.pk_desc;
        this.f19477h = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f19478i = pkView2.pk_desc;
        this.f19479j = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.k = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.l = pkModule.pk_id.longValue();
        this.m = pkModule.user_pk_id.longValue();
        int i2 = this.k;
        long j2 = this.f19477h;
        if (i2 == 1) {
            j2--;
        }
        this.n = j2;
        this.o = this.k == 2 ? this.f19479j - 1 : this.f19479j;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? p : (BdUniqueId) invokeV.objValue;
    }
}
