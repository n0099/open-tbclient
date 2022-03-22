package c.a.p0.s1.b;

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
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18164b;

    /* renamed from: c  reason: collision with root package name */
    public long f18165c;

    /* renamed from: d  reason: collision with root package name */
    public String f18166d;

    /* renamed from: e  reason: collision with root package name */
    public long f18167e;

    /* renamed from: f  reason: collision with root package name */
    public int f18168f;

    /* renamed from: g  reason: collision with root package name */
    public long f18169g;

    /* renamed from: h  reason: collision with root package name */
    public long f18170h;
    public long i;
    public long j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-379688537, "Lc/a/p0/s1/b/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-379688537, "Lc/a/p0/s1/b/i;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = pkModule.ques_desc;
        PkView pkView = pkModule.pk_1;
        this.f18164b = pkView.pk_desc;
        this.f18165c = pkView.pk_num.longValue();
        pkModule.pk_1.pk_index.intValue();
        PkView pkView2 = pkModule.pk_2;
        this.f18166d = pkView2.pk_desc;
        this.f18167e = pkView2.pk_num.longValue();
        pkModule.pk_2.pk_index.intValue();
        this.f18168f = pkModule.pk_1.has_clicked.intValue() == 1 ? 1 : pkModule.pk_2.has_clicked.intValue() == 1 ? 2 : 0;
        pkModule.pk_type.intValue();
        pkModule.user_pk_index.intValue();
        this.f18169g = pkModule.pk_id.longValue();
        this.f18170h = pkModule.user_pk_id.longValue();
        int i = this.f18168f;
        long j = this.f18165c;
        if (i == 1) {
            j--;
        }
        this.i = j;
        this.j = this.f18168f == 2 ? this.f18167e - 1 : this.f18167e;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }
}
