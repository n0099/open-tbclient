package c.a.p0.b0.b.o;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s0.d.h;
import c.a.n0.a.t1.e;
import c.a.n0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.s0.d.h
    public boolean a(Context context, String str, c.a.n0.a.k2.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, aVar)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", c.a.p0.b0.b.c.a.l().p() == null ? "" : c.a.p0.b0.b.c.a.l().p());
            statisticItem.param("obj_param1", aVar.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, aVar.e());
            TiebaStatic.log(statisticItem);
            if (aVar.j() == 10 && aVar.h() == 1013) {
                b(context, aVar);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            e a0 = e.a0();
            if (context == null || a0 == null) {
                return;
            }
            String i = c.a.n0.a.g2.b.i(f.U().M(), a0.X().G());
            long h2 = aVar.h();
            String r = aVar.r();
            if (!(1020 == h2 && !TextUtils.isEmpty(r))) {
                r = c.a.n0.q.j.i.f.b().a(h2);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(a0.V(), r, "v" + q0.D() + "/" + i + "/" + aVar.a());
            forbiddenInfo.enableSlidingFlag = -1;
            c.a.n0.a.v0.d.a.l(context, SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK, aVar, forbiddenInfo, a0.X().D());
        }
    }
}
