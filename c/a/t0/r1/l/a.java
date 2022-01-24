package c.a.t0.r1.l;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes8.dex */
public class a implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final BdUniqueId f21830j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f21831e;

    /* renamed from: f  reason: collision with root package name */
    public int f21832f;

    /* renamed from: g  reason: collision with root package name */
    public long f21833g;

    /* renamed from: h  reason: collision with root package name */
    public long f21834h;

    /* renamed from: i  reason: collision with root package name */
    public int f21835i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2052948576, "Lc/a/t0/r1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2052948576, "Lc/a/t0/r1/l/a;");
                return;
            }
        }
        f21830j = BdUniqueId.gen();
    }

    public a() {
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

    public void a(CommonInteraction commonInteraction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, commonInteraction) == null) || commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f21831e = commonInteraction.total_num.longValue();
        this.f21832f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f21833g = commonInteraction.pk_id.longValue();
        this.f21834h = commonInteraction.user_pk_id.longValue();
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f21830j : (BdUniqueId) invokeV.objValue;
    }
}
