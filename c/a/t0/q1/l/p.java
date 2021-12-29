package c.a.t0.q1.l;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.TabList;
/* loaded from: classes8.dex */
public class p implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final BdUniqueId f22188k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f22189e;

    /* renamed from: f  reason: collision with root package name */
    public String f22190f;

    /* renamed from: g  reason: collision with root package name */
    public String f22191g;

    /* renamed from: h  reason: collision with root package name */
    public String f22192h;

    /* renamed from: i  reason: collision with root package name */
    public String f22193i;

    /* renamed from: j  reason: collision with root package name */
    public String f22194j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1354515504, "Lc/a/t0/q1/l/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1354515504, "Lc/a/t0/q1/l/p;");
                return;
            }
        }
        f22188k = BdUniqueId.gen();
    }

    public p() {
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

    public void a(TabList tabList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tabList) == null) || tabList == null) {
            return;
        }
        this.f22189e = tabList.tab_name;
        this.f22190f = tabList.tab_type;
        this.f22191g = tabList.share_pic;
        this.f22192h = tabList.share_title;
        this.f22193i = tabList.share_desc;
        this.f22194j = tabList.share_url;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f22188k : (BdUniqueId) invokeV.objValue;
    }
}
