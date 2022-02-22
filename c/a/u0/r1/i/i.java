package c.a.u0.r1.i;

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
/* loaded from: classes8.dex */
public class i implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f21760e;

    /* renamed from: f  reason: collision with root package name */
    public String f21761f;

    /* renamed from: g  reason: collision with root package name */
    public long f21762g;

    /* renamed from: h  reason: collision with root package name */
    public String f21763h;

    /* renamed from: i  reason: collision with root package name */
    public long f21764i;

    /* renamed from: j  reason: collision with root package name */
    public int f21765j;
    public long k;
    public long l;
    public long m;
    public long n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2045416090, "Lc/a/u0/r1/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2045416090, "Lc/a/u0/r1/i/i;");
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
        this.f21760e = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f21761f = pkView.pk_desc;
        this.f21762g = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f21763h = pkView2.pk_desc;
        this.f21764i = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.f21765j = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.k = pkModule.pk_id.longValue();
        this.l = pkModule.user_pk_id.longValue();
        int i2 = this.f21765j;
        long j2 = this.f21762g;
        if (i2 == 1) {
            j2--;
        }
        this.m = j2;
        this.n = this.f21765j == 2 ? this.f21764i - 1 : this.f21764i;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? o : (BdUniqueId) invokeV.objValue;
    }
}
