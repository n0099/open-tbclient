package b.a.r0.x0.o2;

import b.a.q0.s.q.d2;
import b.a.r0.b0.b0;
import b.a.r0.b0.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements CustomMessageTask.CustomRunnable<d2>, b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.x0.v2.b f27613e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f27614f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f27615g;

    /* renamed from: h  reason: collision with root package name */
    public int f27616h;

    public b(b.a.r0.x0.v2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, tbPageTag, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27613e = null;
        this.f27614f = null;
        this.f27613e = bVar;
        this.f27614f = tbPageTag;
        this.f27615g = bdUniqueId;
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(d2 d2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) || d2Var == null || d2Var.J() == null || d2Var.m1() == null) {
            return;
        }
        long j = d2Var.m1().user_info != null ? d2Var.m1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", d2Var.J().getUserId());
        statisticItem.param("fid", d2Var.T());
        statisticItem.param("ab_tag", d2Var.Z0);
        statisticItem.param("obj_type", d2Var.m1().isChushou ? 2 : 1);
        statisticItem.param("tid", d2Var.t1());
        statisticItem.param("liveid", d2Var.m1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", d2Var.a1);
        statisticItem.param("source_from", d2Var.X0);
        int i2 = this.f27616h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (d2Var.J() != null && d2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(d2Var.J().getAlaInfo()));
            if (d2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, d2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(d2 d2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null || d2Var.J() == null || d2Var.m1() == null) {
            return;
        }
        long j = d2Var.m1().user_info != null ? d2Var.m1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", d2Var.J().getUserId());
        statisticItem.param("fid", d2Var.T());
        statisticItem.param("ab_tag", d2Var.Z0);
        statisticItem.param("obj_type", d2Var.m1().isChushou ? 2 : 1);
        statisticItem.param("tid", d2Var.t1());
        statisticItem.param("liveid", d2Var.m1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", d2Var.a1);
        statisticItem.param("source_from", d2Var.X0);
        int i2 = this.f27616h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (d2Var.J() != null && d2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(d2Var.J().getAlaInfo()));
            if (d2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, d2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        v.b().a(statisticItem);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27616h = i2;
        }
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<d2> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof d2)) {
                d2 data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    b.a.r0.x0.v2.c.j().g(this.f27613e, data, 1);
                    b.a.r0.x0.v2.a.e(data, 1, this.f27615g, this.f27613e, this.f27614f);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    b.a.r0.x0.v2.c.j().g(this.f27613e, data, 2);
                    b.a.r0.x0.v2.a.e(data, 2, this.f27615g, this.f27613e, this.f27614f);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    b.a.r0.x0.v2.c.j().g(this.f27613e, data, 4);
                    b.a.r0.x0.v2.a.e(data, 1, this.f27615g, this.f27613e, this.f27614f);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    b.a.r0.x0.v2.c.j().c(this.f27613e, data);
                    b.a.r0.x0.v2.a.m(data, this.f27615g, this.f27613e, this.f27614f);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
