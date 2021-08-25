package c.a.q0.h1.c;

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
/* loaded from: classes3.dex */
public class p implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f18665e;

    /* renamed from: f  reason: collision with root package name */
    public String f18666f;

    /* renamed from: g  reason: collision with root package name */
    public String f18667g;

    /* renamed from: h  reason: collision with root package name */
    public String f18668h;

    /* renamed from: i  reason: collision with root package name */
    public String f18669i;

    /* renamed from: j  reason: collision with root package name */
    public String f18670j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1748777933, "Lc/a/q0/h1/c/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1748777933, "Lc/a/q0/h1/c/p;");
                return;
            }
        }
        k = BdUniqueId.gen();
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

    public void b(TabList tabList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tabList) == null) || tabList == null) {
            return;
        }
        this.f18665e = tabList.tab_name;
        this.f18666f = tabList.tab_type;
        this.f18667g = tabList.share_pic;
        this.f18668h = tabList.share_title;
        this.f18669i = tabList.share_desc;
        this.f18670j = tabList.share_url;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }
}
