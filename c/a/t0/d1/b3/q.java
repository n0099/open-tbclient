package c.a.t0.d1.b3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.s0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
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
/* loaded from: classes7.dex */
public final class q extends c.a.d.n.e.a<c.a.t0.d1.s1.g, CardViewHolder<r>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> m;
    public final VideoMiddlePageViewModel n;
    public final List<r> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbPageContext<?> pageContext, BdUniqueId mType, VideoMiddlePageViewModel viewModel) {
        super(pageContext.getPageActivity(), mType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, mType, viewModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.m = pageContext;
        this.n = viewModel;
        this.o = new ArrayList();
    }

    public final void Z(c.a.t0.d1.s1.g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar == null ? null : gVar.f16864f);
            statisticItem.param("nid", gVar == null ? null : gVar.f16865g);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            Intrinsics.checkNotNull(gVar);
            statisticItem.param("fid", gVar.f16863e);
            statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(gVar.r) ? "0" : gVar.r);
            statisticItem.param("extra", c.a.d.f.p.m.isEmpty(gVar.s) ? "0" : gVar.s);
            statisticItem.param("obj_id", this.n.getFromTid());
            statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(gVar.t) ? "0" : gVar.t);
            statisticItem.param("obj_type", this.n.getFrom());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
            statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(gVar.q) ? "0" : gVar.q);
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, gVar.p() ? 1 : 0);
            BaijiahaoData baijiahaoData = gVar.A;
            if (baijiahaoData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData == null ? null : baijiahaoData.oriUgcNid);
                BaijiahaoData baijiahaoData2 = gVar.A;
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void a0(c.a.t0.d1.s1.g gVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, gVar, d2Var, i2) == null) {
            Intrinsics.checkNotNull(gVar);
            c.a.t0.v3.c.g().d(this.m.getUniqueId(), c.a.t0.v3.a.c(gVar.f16864f, "", "", gVar.A), c.a.t0.v3.a.f(d2Var, "a023", "common_exp", i2 + 1, false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public CardViewHolder<r> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            r rVar = new r(this.m, this.n);
            this.o.add(rVar);
            return new CardViewHolder<>(rVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: c0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.d1.s1.g gVar, CardViewHolder<r> cardViewHolder) {
        InterceptResult invokeCommon;
        r cardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            d2 g2 = c.a.t0.d1.s1.g.g(gVar);
            AgreeData i3 = gVar == null ? null : gVar.i();
            if (i3 != null) {
                i3.keyFromHomePage = this.n.getFrom();
            }
            if (cardViewHolder != null && (cardView = cardViewHolder.getCardView()) != null) {
                cardView.V(gVar, i2);
            }
            a0(gVar, g2, i2);
            Z(gVar, i2);
            if (cardViewHolder == null) {
                return null;
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (r rVar : this.o) {
                if (rVar != null) {
                    rVar.onDestroy();
                }
            }
        }
    }
}
