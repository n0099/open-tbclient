package c.a.q0.v.d.a;

import c.a.p0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f24988e;

    /* renamed from: f  reason: collision with root package name */
    public String f24989f;

    /* renamed from: g  reason: collision with root package name */
    public String f24990g;

    /* renamed from: h  reason: collision with root package name */
    public c2 f24991h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24992i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24993j;
    public boolean k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-52257228, "Lc/a/q0/v/d/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-52257228, "Lc/a/q0/v/d/a/c;");
                return;
            }
        }
        m = BdUniqueId.gen();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24993j = false;
        this.k = false;
        this.l = false;
    }

    @Deprecated
    public void g(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadInfo) == null) {
            if (this.f24991h == null) {
                this.f24991h = new c2();
            }
            this.f24991h.S2(threadInfo);
        }
    }

    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24991h : (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }
}
