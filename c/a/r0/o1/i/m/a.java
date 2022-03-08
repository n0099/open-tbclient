package c.a.r0.o1.i.m;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.e1.n.e;
import c.a.q0.r.r.e2;
import c.a.r0.o1.i.g;
import c.a.r0.x3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.o1.i.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1257a implements ThirdStatisticHelper.TiePlusStatisCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1257a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || a.a == null) {
                return;
            }
            a.a.put(str, "3");
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || a.a == null) {
                return;
            }
            a.a.put(str, "2");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-709900444, "Lc/a/r0/o1/i/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-709900444, "Lc/a/r0/o1/i/m/a;");
                return;
            }
        }
        a = new ArrayMap<>();
    }

    @Deprecated
    public static void b(e2 e2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, e2Var, str, i2) == null) {
            c(e2Var, str, i2, 1);
        }
    }

    public static void c(e2 e2Var, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, e2Var, str, i2, i3) == null) || e2Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(e2Var.a3)) {
            ThirdStatisticHelper.sendTiePlusReq(e2Var.a3, e2Var.E, 2, null);
        }
        if (e2Var.U2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (e2Var.J2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (e2Var.I2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i3);
            statisticItem.addParam("tid", e2Var.w1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, e2Var.U());
            statisticItem.addParam("order_id", e2Var.V2);
            TiebaStatic.log(statisticItem);
            c.a.q0.c.a.a(c.a.q0.c.a.f12097e, c.a.q0.c.a.a, e2Var.V2, e2Var.W2, e2Var.X2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.q0.c.a.a(c.a.q0.c.a.l, c.a.q0.c.a.a, str, e2Var.W2, e2Var.X2, i2);
    }

    public static void d(e2 e2Var, BdUniqueId bdUniqueId, int i2, int i3) {
        String str;
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, e2Var, bdUniqueId, i2, i3) == null) || e2Var == null) {
            return;
        }
        if (e2Var.s2) {
            str = e2Var.t2;
            z = true;
            i4 = 20;
        } else {
            str = null;
            z = false;
            i4 = 0;
        }
        StatisticItem e2 = c.a.r0.x3.a.e(e2Var, "a002", "common_click", i3, i2, z, str, null, i4);
        if (e2 == null) {
            return;
        }
        if (e2Var.e2()) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (e2Var.u0() != null) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = e2.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i5 = indexOf + 1;
                e2.getParams().remove(i5);
                e2.getParams().add(i5, 16);
            } else {
                e2.param("obj_locate", 16);
            }
        } else if (e.t(e2Var)) {
            e2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            e2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (e2Var.s2) {
            e2.delete("thread_type");
            e2.param("thread_type", e2Var.s1());
        }
        c.g().c(bdUniqueId, e2);
        e(e2Var, i3);
    }

    public static void e(e2 e2Var, int i2) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, e2Var, i2) == null) {
            if (i2 != 2) {
                n = i2 != 9 ? null : c.a.r0.x3.a.n("c13693", e2Var, 1);
            } else {
                n = c.a.r0.x3.a.n("c13692", e2Var, 1);
            }
            TiebaStatic.log(n);
        }
    }

    public static void f(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, e2Var) == null) || e2Var == null || TextUtils.isEmpty(e2Var.Z2)) {
            return;
        }
        if (a == null) {
            a = new ArrayMap<>();
        }
        String str = a.get(e2Var.Z2);
        if ("1".equals(str) || "2".equals(str)) {
            return;
        }
        ThirdStatisticHelper.sendTiePlusReq(e2Var.Z2, e2Var.E, 1, new C1257a());
        a.put(e2Var.Z2, "1");
    }

    public static void g(e2 e2Var, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, e2Var, str, i2) == null) || e2Var == null) {
            return;
        }
        f(e2Var);
        if (e2Var.U2) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (e2Var.J2()) {
                statisticItem.addParam("obj_type", 3);
            } else if (e2Var.I2()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", e2Var.w1());
            statisticItem.addParam(TiebaStatic.Params.FID_1, e2Var.U());
            statisticItem.addParam("order_id", e2Var.V2);
            TiebaStatic.log(statisticItem);
            c.a.q0.c.a.a(c.a.q0.c.a.f12096d, c.a.q0.c.a.a, e2Var.V2, e2Var.W2, e2Var.X2, i2);
        }
        if (str == null || !str.startsWith("manual")) {
            return;
        }
        c.a.q0.c.a.a(c.a.q0.c.a.k, c.a.q0.c.a.a, str, e2Var.W2, e2Var.X2, i2);
    }

    public static void h(e2 e2Var, BdUniqueId bdUniqueId, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65544, null, e2Var, bdUniqueId, i2) == null) || e2Var == null) {
            return;
        }
        if (e2Var.s2) {
            str = e2Var.t2;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        String c2 = c.a.r0.x3.a.c(e2Var.w1(), str, "", e2Var.L());
        StatisticItem g2 = c.a.r0.x3.a.g(e2Var, "a002", "common_exp", i2, z, str, null, i3);
        if (g2 == null) {
            return;
        }
        if (e2Var.s2) {
            g2.delete("thread_type");
            g2.param("thread_type", e2Var.s1());
        }
        if (e2Var.e2()) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (e2Var.u0() != null) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (e.t(e2Var)) {
            g2.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            g2.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        c.g().d(bdUniqueId, c2, g2);
        if (g.d()) {
            g.c(c2);
            if (g.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                g.e(false);
            }
        }
    }
}
