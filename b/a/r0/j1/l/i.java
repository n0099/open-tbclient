package b.a.r0.j1.l;

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
/* loaded from: classes4.dex */
public class i implements b.a.e.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f19789e;

    /* renamed from: f  reason: collision with root package name */
    public String f19790f;

    /* renamed from: g  reason: collision with root package name */
    public String f19791g;

    /* renamed from: h  reason: collision with root package name */
    public long f19792h;

    /* renamed from: i  reason: collision with root package name */
    public String f19793i;
    public long j;
    public int k;
    public long l;
    public long m;
    public long n;
    public long o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335542451, "Lb/a/r0/j1/l/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335542451, "Lb/a/r0/j1/l/i;");
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

    public void a(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pkModule) == null) || pkModule == null) {
            return;
        }
        this.f19789e = pkModule.module_name;
        this.f19790f = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f19791g = pkView.pk_desc;
        this.f19792h = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f19793i = pkView2.pk_desc;
        this.j = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.k = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.l = pkModule.pk_id.longValue();
        this.m = pkModule.user_pk_id.longValue();
        int i2 = this.k;
        long j = this.f19792h;
        if (i2 == 1) {
            j--;
        }
        this.n = j;
        this.o = this.k == 2 ? this.j - 1 : this.j;
    }

    @Override // b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? p : (BdUniqueId) invokeV.objValue;
    }
}
