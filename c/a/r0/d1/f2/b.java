package c.a.r0.d1.f2;

import c.a.q0.r.r.e2;
import c.a.r0.f0.u;
import c.a.r0.f0.z;
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
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<e2>, z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.d1.o2.b f15483e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f15484f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15485g;

    /* renamed from: h  reason: collision with root package name */
    public int f15486h;

    public b(c.a.r0.d1.o2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
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
        this.f15483e = null;
        this.f15484f = null;
        this.f15483e = bVar;
        this.f15484f = tbPageTag;
        this.f15485g = bdUniqueId;
    }

    @Override // c.a.r0.f0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(e2 e2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        long j2 = e2Var.p1().user_info != null ? e2Var.p1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", e2Var.J().getUserId());
        statisticItem.param("fid", e2Var.U());
        statisticItem.param("ab_tag", e2Var.b1);
        statisticItem.param("obj_type", e2Var.p1().isChushou ? 2 : 1);
        statisticItem.param("tid", e2Var.w1());
        statisticItem.param("liveid", e2Var.p1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
        statisticItem.param("extra", e2Var.c1);
        statisticItem.param("source_from", e2Var.Z0);
        int i2 = this.f15486h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (e2Var.J() != null && e2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(e2Var.J().getAlaInfo()));
            if (e2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, e2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(e2 e2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        long j2 = e2Var.p1().user_info != null ? e2Var.p1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", e2Var.J().getUserId());
        statisticItem.param("fid", e2Var.U());
        statisticItem.param("ab_tag", e2Var.b1);
        statisticItem.param("obj_type", e2Var.p1().isChushou ? 2 : 1);
        statisticItem.param("tid", e2Var.w1());
        statisticItem.param("liveid", e2Var.p1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
        statisticItem.param("extra", e2Var.c1);
        statisticItem.param("source_from", e2Var.Z0);
        int i2 = this.f15486h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (e2Var.J() != null && e2Var.J().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(e2Var.J().getAlaInfo()));
            if (e2Var.J().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, e2Var.J().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        u.b().a(statisticItem);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15486h = i2;
        }
    }

    @Override // c.a.r0.f0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<e2> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof e2)) {
                e2 data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    c.a.r0.d1.o2.c.k().h(this.f15483e, data, 1);
                    c.a.r0.d1.o2.a.e(data, 1, this.f15485g, this.f15483e, this.f15484f);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    c.a.r0.d1.o2.c.k().h(this.f15483e, data, 2);
                    c.a.r0.d1.o2.a.e(data, 2, this.f15485g, this.f15483e, this.f15484f);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    c.a.r0.d1.o2.c.k().h(this.f15483e, data, 4);
                    c.a.r0.d1.o2.a.e(data, 1, this.f15485g, this.f15483e, this.f15484f);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    c.a.r0.d1.o2.c.k().c(this.f15483e, data);
                    c.a.r0.d1.o2.a.n(data, this.f15485g, this.f15483e, this.f15484f);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
