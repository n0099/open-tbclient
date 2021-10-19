package c.a.r0.h3.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.b0.c0;
import c.a.r0.h3.k.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.e.l.e.a<c.a.r0.h3.f.b, CardViewHolder<c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c0<c.a.r0.h3.f.b> n;

    /* loaded from: classes3.dex */
    public class a extends c0<c.a.r0.h3.f.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18844b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18844b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.h3.f.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) && bVar != null && (this.f18844b.m.getPageActivity() instanceof ForumSquareActivity)) {
                String h2 = ((ForumSquareActivity) this.f18844b.m.getPageActivity()).getDelegate().h();
                if (!"推荐".equals(h2)) {
                    StatisticItem statisticItem = new StatisticItem("c13652");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", bVar.f18847e);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, h2);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", bVar.f18847e);
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.r0.h3.f.b.l);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.n = new a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public CardViewHolder<c> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c cVar = new c(this.m);
            cVar.n(this.f2962i);
            return new CardViewHolder<>(cVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.h3.f.b bVar, CardViewHolder<c> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, cardViewHolder})) == null) {
            if (bVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().k(bVar);
            cardViewHolder.getCardView().m(this.n);
            if (this.m.getPageActivity() instanceof ForumSquareActivity) {
                String h2 = ((ForumSquareActivity) this.m.getPageActivity()).getDelegate().h();
                if (!"推荐".equals(h2)) {
                    StatisticItem statisticItem = new StatisticItem("c13651");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", bVar.f18847e);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, h2);
                    TiebaStatic.log(statisticItem);
                } else {
                    StatisticItem statisticItem2 = new StatisticItem("c13642");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", bVar.i());
                    statisticItem2.param("obj_locate", 3);
                    TiebaStatic.log(statisticItem2);
                }
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
