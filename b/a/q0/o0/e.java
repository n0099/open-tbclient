package b.a.q0.o0;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static e f12788d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12789a;

    /* renamed from: b  reason: collision with root package name */
    public int f12790b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12791c;

    /* loaded from: classes4.dex */
    public class a extends b.a.q0.o0.b {
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

        @Override // b.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // b.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends b.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12792a;

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
            this.f12792a = eVar;
        }

        @Override // b.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12792a.f12790b : invokeV.intValue;
        }

        @Override // b.a.q0.o0.b
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-79774853, "Lb/a/q0/o0/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-79774853, "Lb/a/q0/o0/e;");
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
        this.f12789a = false;
        this.f12791c = false;
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f12788d == null) {
                synchronized (e.class) {
                    if (f12788d == null) {
                        f12788d = new e();
                    }
                }
            }
            return f12788d;
        }
        return (e) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return b.a.q0.s.e0.b.j().k("page_stay_max_cost", 0);
            }
            return this.f12790b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12789a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12791c : invokeV.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12790b = i2;
            b.a.q0.s.e0.b.j().v("page_stay_max_cost", this.f12790b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f12789a = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f12791c = z;
        }
    }

    public void k(Context context, d dVar, b.a.q0.o0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, dVar, bVar) == null) || dVar == null || StringUtils.isNull(dVar.c())) {
            return;
        }
        if (dVar.f12779a) {
            if (bVar == null) {
                bVar = new a(this);
            }
            if (bVar.canStat(dVar)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", c.a(dVar.h()));
                statisticItem.param("obj_locate", dVar.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(dVar.f12787i)) {
                    statisticItem.param("obj_id", dVar.f12787i);
                }
                if (dVar.b() != 0) {
                    statisticItem.param("ad_source", dVar.b());
                }
                b.a.q0.m0.e.b(context, statisticItem, dVar);
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
            if (!k.isEmpty(dVar.j())) {
                statisticItem2.param("task_id", String.valueOf(dVar.j()));
            }
            if (!k.isEmpty(dVar.a())) {
                statisticItem2.param("ab_tag", dVar.a());
            }
            if (g()) {
                if (!StringUtils.isNull(dVar.f12787i)) {
                    statisticItem2.param("obj_id", dVar.f12787i);
                }
                if (!StringUtils.isNull(dVar.j)) {
                    statisticItem2.param("obj_name", dVar.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(dVar.f())) {
                statisticItem2.param("obj_location", dVar.f());
            }
            if (dVar.b() != 0) {
                statisticItem2.param("ad_source", dVar.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && dVar.h() != null && d(dVar.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(dVar.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            b.a.q0.m0.e.b(context, statisticItem2, dVar);
            TiebaStatic.log(statisticItem2);
        }
    }
}
