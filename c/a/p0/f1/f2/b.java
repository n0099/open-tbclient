package c.a.p0.f1.f2;

import c.a.p0.h0.u;
import c.a.p0.h0.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
public class b implements CustomMessageTask.CustomRunnable<ThreadData>, z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.f1.o2.b a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f13949b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f13950c;

    /* renamed from: d  reason: collision with root package name */
    public int f13951d;

    public b(c.a.p0.f1.o2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, tbPageTag, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f13949b = null;
        this.a = bVar;
        this.f13949b = tbPageTag;
        this.f13950c = bdUniqueId;
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        long j = threadData.getThreadAlaInfo().user_info != null ? threadData.getThreadAlaInfo().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", threadData.getAuthor().getUserId());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("ab_tag", threadData.mRecomAbTag);
        statisticItem.param("obj_type", threadData.getThreadAlaInfo().isChushou ? 2 : 1);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("liveid", threadData.getThreadAlaInfo().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", threadData.mRecomExtra);
        statisticItem.param("source_from", threadData.mRecomSource);
        int i = this.f13951d;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        long j = threadData.getThreadAlaInfo().user_info != null ? threadData.getThreadAlaInfo().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", threadData.getAuthor().getUserId());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("ab_tag", threadData.mRecomAbTag);
        statisticItem.param("obj_type", threadData.getThreadAlaInfo().isChushou ? 2 : 1);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("liveid", threadData.getThreadAlaInfo().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", threadData.mRecomExtra);
        statisticItem.param("source_from", threadData.mRecomSource);
        int i = this.f13951d;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        u.b().a(statisticItem);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f13951d = i;
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ThreadData> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof ThreadData)) {
                ThreadData data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    c.a.p0.f1.o2.c.k().h(this.a, data, 1);
                    c.a.p0.f1.o2.a.e(data, 1, this.f13950c, this.a, this.f13949b);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    c.a.p0.f1.o2.c.k().h(this.a, data, 2);
                    c.a.p0.f1.o2.a.e(data, 2, this.f13950c, this.a, this.f13949b);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    c.a.p0.f1.o2.c.k().h(this.a, data, 4);
                    c.a.p0.f1.o2.a.e(data, 1, this.f13950c, this.a, this.f13949b);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    c.a.p0.f1.o2.c.k().c(this.a, data);
                    c.a.p0.f1.o2.a.n(data, this.f13950c, this.a, this.f13949b);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
