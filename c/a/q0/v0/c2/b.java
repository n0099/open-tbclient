package c.a.q0.v0.c2;

import c.a.p0.s.q.c2;
import c.a.q0.a0.t;
import c.a.q0.a0.z;
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
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<c2>, z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v0.j2.b f25902e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f25903f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f25904g;

    /* renamed from: h  reason: collision with root package name */
    public int f25905h;

    public b(c.a.q0.v0.j2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
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
        this.f25902e = null;
        this.f25903f = null;
        this.f25902e = bVar;
        this.f25903f = tbPageTag;
        this.f25904g = bdUniqueId;
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(c2 c2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        long j2 = c2Var.j1().user_info != null ? c2Var.j1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", c2Var.J().getUserId());
        statisticItem.param("fid", c2Var.T());
        statisticItem.param("ab_tag", c2Var.W0);
        statisticItem.param("obj_type", c2Var.j1().isChushou ? 2 : 1);
        statisticItem.param("tid", c2Var.q1());
        statisticItem.param("liveid", c2Var.j1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
        statisticItem.param("extra", c2Var.X0);
        statisticItem.param("source_from", c2Var.U0);
        int i2 = this.f25905h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (c2Var.J() != null && c2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(c2Var.J().getAlaInfo()));
            if (c2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, c2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(c2 c2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        long j2 = c2Var.j1().user_info != null ? c2Var.j1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", c2Var.J().getUserId());
        statisticItem.param("fid", c2Var.T());
        statisticItem.param("ab_tag", c2Var.W0);
        statisticItem.param("obj_type", c2Var.j1().isChushou ? 2 : 1);
        statisticItem.param("tid", c2Var.q1());
        statisticItem.param("liveid", c2Var.j1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
        statisticItem.param("extra", c2Var.X0);
        statisticItem.param("source_from", c2Var.U0);
        int i2 = this.f25905h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (c2Var.J() != null && c2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(c2Var.J().getAlaInfo()));
            if (c2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, c2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        t.b().a(statisticItem);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f25905h = i2;
        }
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<c2> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof c2)) {
                c2 data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    c.a.q0.v0.j2.c.j().g(this.f25902e, data, 1);
                    c.a.q0.v0.j2.a.e(data, 1, this.f25904g, this.f25902e, this.f25903f);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    c.a.q0.v0.j2.c.j().g(this.f25902e, data, 2);
                    c.a.q0.v0.j2.a.e(data, 2, this.f25904g, this.f25902e, this.f25903f);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    c.a.q0.v0.j2.c.j().g(this.f25902e, data, 4);
                    c.a.q0.v0.j2.a.e(data, 1, this.f25904g, this.f25902e, this.f25903f);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    c.a.q0.v0.j2.c.j().c(this.f25902e, data);
                    c.a.q0.v0.j2.a.m(data, this.f25904g, this.f25902e, this.f25903f);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
