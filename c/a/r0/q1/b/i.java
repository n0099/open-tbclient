package c.a.r0.q1.b;

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
/* loaded from: classes2.dex */
public class i implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20994e;

    /* renamed from: f  reason: collision with root package name */
    public String f20995f;

    /* renamed from: g  reason: collision with root package name */
    public long f20996g;

    /* renamed from: h  reason: collision with root package name */
    public String f20997h;

    /* renamed from: i  reason: collision with root package name */
    public long f20998i;

    /* renamed from: j  reason: collision with root package name */
    public int f20999j;
    public long k;
    public long l;
    public long m;
    public long n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1747244387, "Lc/a/r0/q1/b/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1747244387, "Lc/a/r0/q1/b/i;");
                return;
            }
        }
        o = BdUniqueId.gen();
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

    public void a(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null) {
            return;
        }
        String str = pkModule.module_name;
        this.f20994e = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f20995f = pkView.pk_desc;
        this.f20996g = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f20997h = pkView2.pk_desc;
        this.f20998i = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.f20999j = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.k = pkModule.pk_id.longValue();
        this.l = pkModule.user_pk_id.longValue();
        int i2 = this.f20999j;
        long j2 = this.f20996g;
        if (i2 == 1) {
            j2--;
        }
        this.m = j2;
        this.n = this.f20999j == 2 ? this.f20998i - 1 : this.f20998i;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? o : (BdUniqueId) invokeV.objValue;
    }
}
