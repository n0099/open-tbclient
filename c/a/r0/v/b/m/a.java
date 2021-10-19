package c.a.r0.v.b.m;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.a2.e;
import c.a.p0.a.c1.d.g;
import c.a.p0.a.g1.f;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.p0.a.c1.d.g
    public boolean a(Context context, String str, c.a.p0.a.q2.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, aVar)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", c.a.r0.v.b.b.a.l().p() == null ? "" : c.a.r0.v.b.b.a.l().p());
            statisticItem.param("obj_param1", aVar.g());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, aVar.d());
            TiebaStatic.log(statisticItem);
            if (aVar.i() == 10 && aVar.g() == 1013) {
                b(context, aVar);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, c.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            e Q = e.Q();
            if (context == null || Q == null) {
                return;
            }
            String i2 = c.a.p0.a.m2.b.i(f.V().N(), Q.N().G());
            long g2 = aVar.g();
            String q = aVar.q();
            if (!(1020 == g2 && !TextUtils.isEmpty(q))) {
                q = c.a.p0.n.j.i.f.b().a(g2);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(Q.L(), q, context.getString(R.string.aiapps_open_failed_detail_format, q0.D(), i2, String.valueOf(aVar.a())));
            forbiddenInfo.enableSlidingFlag = -1;
            c.a.p0.a.f1.d.a.k(context, SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK, Q.N().C(), forbiddenInfo);
        }
    }
}
