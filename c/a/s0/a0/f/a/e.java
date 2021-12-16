package c.a.s0.a0.f.a;

import c.a.r0.s.r.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class e extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14190e;

    /* renamed from: f  reason: collision with root package name */
    public String f14191f;

    /* renamed from: g  reason: collision with root package name */
    public String f14192g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f14193h;

    /* renamed from: i  reason: collision with root package name */
    public int f14194i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14195j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f14196k;
    public boolean l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1419653121, "Lc/a/s0/a0/f/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1419653121, "Lc/a/s0/a0/f/a/e;");
                return;
            }
        }
        n = BdUniqueId.gen();
    }

    public e() {
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
        this.f14196k = false;
        this.l = false;
        this.m = false;
    }

    public final long g(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null || d2Var.o1() == null) {
                return -1L;
            }
            return d2Var.o1().live_id;
        }
        return invokeL.longValue;
    }

    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14193h : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? n : (BdUniqueId) invokeV.objValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public StatisticItem k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            d2 threadData = getThreadData();
            if (threadData == null) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("obj_id", g(threadData)).param("obj_type", i()).param("obj_param1", threadData.a1).param("obj_source", threadData.Z0).param("obj_locate", this.f14194i).param("ab_tag", threadData.b1).param(TiebaStatic.Params.OBJ_PARAM3, (threadData.o1() == null || StringUtils.isNull(threadData.o1().appId)) ? "" : threadData.o1().appId);
            if (z) {
                param.param(TiebaStatic.Params.OBJ_PARAM2, threadData.o0() > 0 ? "0" : "1");
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    @Deprecated
    public void o(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadInfo) == null) {
            if (this.f14193h == null) {
                this.f14193h = new d2();
            }
            this.f14193h.c3(threadInfo);
        }
    }
}
