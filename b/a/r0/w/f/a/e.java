package b.a.r0.w.f.a;

import b.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class e extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f24507e;

    /* renamed from: f  reason: collision with root package name */
    public String f24508f;

    /* renamed from: g  reason: collision with root package name */
    public String f24509g;

    /* renamed from: h  reason: collision with root package name */
    public d2 f24510h;

    /* renamed from: i  reason: collision with root package name */
    public int f24511i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1556691697, "Lb/a/r0/w/f/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1556691697, "Lb/a/r0/w/f/a/e;");
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
        this.k = false;
        this.l = false;
        this.m = false;
    }

    public final long g(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null || d2Var.l1() == null) {
                return -1L;
            }
            return d2Var.l1().live_id;
        }
        return invokeL.longValue;
    }

    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24510h : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
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
            StatisticItem param = new StatisticItem(str).param("obj_id", g(threadData)).param("obj_type", i()).param("obj_param1", threadData.Y0).param("obj_source", threadData.X0).param("obj_locate", this.f24511i).param("ab_tag", threadData.Z0).param(TiebaStatic.Params.OBJ_PARAM3, (threadData.l1() == null || StringUtils.isNull(threadData.l1().appId)) ? "" : threadData.l1().appId);
            if (z) {
                param.param(TiebaStatic.Params.OBJ_PARAM2, threadData.n0() > 0 ? "0" : "1");
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    @Deprecated
    public void o(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadInfo) == null) {
            if (this.f24510h == null) {
                this.f24510h = new d2();
            }
            this.f24510h.Y2(threadInfo);
        }
    }
}
