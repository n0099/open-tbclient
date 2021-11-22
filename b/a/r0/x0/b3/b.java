package b.a.r0.x0.b3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.f.p.k;
import b.a.q0.s.q.d2;
import b.a.r0.l3.c;
import b.a.r0.x0.s1.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightCardView;
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
/* loaded from: classes5.dex */
public final class b extends b.a.e.m.e.a<g, CardViewHolder<VideoMiddlePageLightCardView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<VideoMiddlePageLightCardView> m;
    public final TbPageContext<?> n;
    public final VideoMiddlePageViewModel o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, videoMiddlePageViewModel};
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
        this.n = tbPageContext;
        this.o = videoMiddlePageViewModel;
        this.m = new ArrayList();
    }

    public final void g0(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar != null ? gVar.f27853f : null);
            statisticItem.param("nid", gVar != null ? gVar.f27854g : null);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            statisticItem.param("fid", gVar.f27852e);
            statisticItem.param("obj_param1", k.isEmpty(gVar.r) ? "0" : gVar.r);
            statisticItem.param("extra", k.isEmpty(gVar.s) ? "0" : gVar.s);
            statisticItem.param("obj_id", this.o.getFromTid());
            statisticItem.param("ab_tag", k.isEmpty(gVar.t) ? "0" : gVar.t);
            statisticItem.param("obj_type", this.o.getFrom());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
            statisticItem.param("obj_source", k.isEmpty(gVar.q) ? "0" : gVar.q);
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, gVar.p() ? 1 : 0);
            BaijiahaoData baijiahaoData = gVar.A;
            if (baijiahaoData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData != null ? baijiahaoData.oriUgcNid : null);
                BaijiahaoData baijiahaoData2 = gVar.A;
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h0(g gVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, gVar, d2Var, i2) == null) {
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            c.g().d(this.n.getUniqueId(), b.a.r0.l3.a.c(gVar.f27853f, "", "", gVar.A), b.a.r0.l3.a.f(d2Var, "a023", "common_exp", i2 + 1, false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public CardViewHolder<VideoMiddlePageLightCardView> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            VideoMiddlePageLightCardView videoMiddlePageLightCardView = new VideoMiddlePageLightCardView(this.n, this.o);
            this.m.add(videoMiddlePageLightCardView);
            return new CardViewHolder<>(videoMiddlePageLightCardView);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: j0 */
    public View Z(int i2, View view, ViewGroup viewGroup, g gVar, CardViewHolder<VideoMiddlePageLightCardView> cardViewHolder) {
        InterceptResult invokeCommon;
        VideoMiddlePageLightCardView cardView;
        AgreeData i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            d2 g2 = g.g(gVar);
            if (gVar != null && (i3 = gVar.i()) != null) {
                i3.keyFromHomePage = this.o.getFrom();
            }
            if (cardViewHolder != null && (cardView = cardViewHolder.getCardView()) != null) {
                cardView.X(gVar, i2);
            }
            h0(gVar, g2, i2);
            g0(gVar, i2);
            if (cardViewHolder != null) {
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (VideoMiddlePageLightCardView videoMiddlePageLightCardView : this.m) {
                if (videoMiddlePageLightCardView != null) {
                    videoMiddlePageLightCardView.onDestroy();
                }
            }
        }
    }
}
