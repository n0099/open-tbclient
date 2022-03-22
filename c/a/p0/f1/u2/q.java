package c.a.p0.f1.u2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class q extends c.a.d.o.e.a<c.a.p0.f1.j1.g, CardViewHolder<r>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> i;
    public final VideoMiddlePageViewModel j;
    public final List<r> k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbPageContext<?> pageContext, BdUniqueId mType, VideoMiddlePageViewModel viewModel) {
        super(pageContext.getPageActivity(), mType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, mType, viewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(mType, "mType");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.i = pageContext;
        this.j = viewModel;
        this.k = new ArrayList();
    }

    public final void Z(c.a.p0.f1.j1.g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar == null ? null : gVar.f14123b);
            statisticItem.param("nid", gVar == null ? null : gVar.f14124c);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            Intrinsics.checkNotNull(gVar);
            statisticItem.param("fid", gVar.a);
            statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(gVar.n) ? "0" : gVar.n);
            statisticItem.param("extra", c.a.d.f.p.m.isEmpty(gVar.o) ? "0" : gVar.o);
            statisticItem.param("obj_id", this.j.e());
            statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(gVar.p) ? "0" : gVar.p);
            statisticItem.param("obj_type", this.j.d());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.i());
            statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(gVar.m) ? "0" : gVar.m);
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, gVar.k() ? 1 : 0);
            BaijiahaoData baijiahaoData = gVar.w;
            if (baijiahaoData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData == null ? null : baijiahaoData.oriUgcNid);
                BaijiahaoData baijiahaoData2 = gVar.w;
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void a0(c.a.p0.f1.j1.g gVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, gVar, threadData, i) == null) {
            Intrinsics.checkNotNull(gVar);
            c.a.p0.z3.c.g().d(this.i.getUniqueId(), c.a.p0.z3.a.c(gVar.f14123b, "", "", gVar.w), c.a.p0.z3.a.f(threadData, "a023", "common_exp", i + 1, false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public CardViewHolder<r> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            r rVar = new r(this.i, this.j);
            this.k.add(rVar);
            return new CardViewHolder<>(rVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.f1.j1.g gVar, CardViewHolder<r> cardViewHolder) {
        InterceptResult invokeCommon;
        r c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, gVar, cardViewHolder})) == null) {
            ThreadData e2 = c.a.p0.f1.j1.g.e(gVar);
            AgreeData agreeData = gVar == null ? null : gVar.getAgreeData();
            if (agreeData != null) {
                agreeData.keyFromHomePage = this.j.d();
            }
            if (cardViewHolder != null && (c2 = cardViewHolder.c()) != null) {
                c2.W(gVar, i);
            }
            a0(gVar, e2, i);
            Z(gVar, i);
            if (cardViewHolder == null) {
                return null;
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (r rVar : this.k) {
                if (rVar != null) {
                    rVar.onDestroy();
                }
            }
        }
    }
}
