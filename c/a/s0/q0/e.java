package c.a.s0.q0;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static e f13106d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f13107b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13108c;

    /* loaded from: classes6.dex */
    public class a extends c.a.s0.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.s0.q0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // c.a.s0.q0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.s0.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.s0.q0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.f13107b : invokeV.intValue;
        }

        @Override // c.a.s0.q0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-758191718, "Lc/a/s0/q0/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-758191718, "Lc/a/s0/q0/e;");
        }
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
        this.a = false;
        this.f13108c = false;
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f13106d == null) {
                synchronized (e.class) {
                    if (f13106d == null) {
                        f13106d = new e();
                    }
                }
            }
            return f13106d;
        }
        return (e) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return c.a.s0.s.i0.b.k().l("page_stay_max_cost", 0);
            }
            return this.f13107b;
        }
        return invokeV.intValue;
    }

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            return "a026".equals(list.get(list.size() - 1)) || e(list);
        }
        return invokeL.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) ? !ListUtils.isEmpty(list) && (size = list.size()) >= 2 && "a026".equals(list.get(size - 2)) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13108c : invokeV.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f13107b = i2;
            c.a.s0.s.i0.b.k().w("page_stay_max_cost", this.f13107b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f13108c = z;
        }
    }

    public void k(Context context, d dVar, c.a.s0.q0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, dVar, bVar) == null) || dVar == null || StringUtils.isNull(dVar.c())) {
            return;
        }
        if (dVar.a) {
            if (bVar == null) {
                bVar = new a(this);
            }
            if (bVar.canStat(dVar)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", c.a(dVar.h()));
                statisticItem.param("obj_locate", dVar.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(dVar.f13104i)) {
                    statisticItem.param("obj_id", dVar.f13104i);
                }
                if (dVar.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, dVar.b());
                }
                c.a.s0.o0.e.b(context, statisticItem, dVar);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (bVar == null) {
            bVar = new b(this);
        }
        if (bVar.isSwitchOpen() && bVar.canStat(dVar)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", c.a(dVar.h()));
            statisticItem2.param("obj_type", dVar.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(dVar.i()));
            if (!StringUtils.isNull(dVar.n())) {
                statisticItem2.param("topic_id", dVar.n());
            }
            if (!StringUtils.isNull(dVar.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, dVar.o());
            }
            if (dVar.d() > 0) {
                statisticItem2.param("fid", String.valueOf(dVar.d()));
            }
            if (dVar.m() > 0) {
                statisticItem2.param("tid", String.valueOf(dVar.m()));
            }
            if (dVar.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(dVar.l()));
            }
            if (!StringUtils.isNull(dVar.e())) {
                statisticItem2.param("nid", dVar.e());
            }
            if (dVar.g() > 0) {
                statisticItem2.param("pid", String.valueOf(dVar.g()));
            }
            if (!StringUtils.isNull(dVar.k)) {
                statisticItem2.param("obj_param1", dVar.k);
            }
            if (!StringUtils.isNull(dVar.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, dVar.l);
            }
            if (!StringUtils.isNull(dVar.r)) {
                statisticItem2.param("is_dynamic", dVar.r);
            }
            if (!StringUtils.isNull(dVar.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, dVar.s);
            }
            if (!StringUtils.isNull(dVar.t)) {
                statisticItem2.param("resource_type", dVar.t);
            }
            if (!m.isEmpty(dVar.j())) {
                statisticItem2.param("task_id", String.valueOf(dVar.j()));
            }
            if (!m.isEmpty(dVar.a())) {
                statisticItem2.param("ab_tag", dVar.a());
            }
            if (g()) {
                if (!StringUtils.isNull(dVar.f13104i)) {
                    statisticItem2.param("obj_id", dVar.f13104i);
                }
                if (!StringUtils.isNull(dVar.f13105j)) {
                    statisticItem2.param("obj_name", dVar.f13105j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(dVar.f())) {
                statisticItem2.param("obj_location", dVar.f());
            }
            if (dVar.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, dVar.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && dVar.h() != null && d(dVar.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(dVar.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            c.a.s0.o0.e.b(context, statisticItem2, dVar);
            TiebaStatic.log(statisticItem2);
        }
    }
}
