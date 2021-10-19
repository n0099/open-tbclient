package c.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class t extends c.a.e.l.e.a<c.a.r0.h1.k.b.c.a, ThreadCardViewHolder<c.a.r0.h1.k.b.c.a>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public NEGFeedBackView.b p;

    /* loaded from: classes3.dex */
    public class a implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f18489e;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18489e = tVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.h1.k.b.c.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                c.a.r0.h1.k.b.c.a aVar = (c.a.r0.h1.k.b.c.a) nVar;
                if (aVar != null && aVar.c0 != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", aVar.V).param("obj_locate", aVar.U));
                }
                if (aVar != null && aVar.c0 == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", aVar.V));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(this.f18489e.f2958e, aVar.V)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<c.a.r0.h1.k.b.c.a> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.r0.h1.h.o.d dVar = new c.a.r0.h1.h.o.d(this.f2958e, this.n);
            dVar.o(this.f2962i);
            bVar.n(dVar);
            bVar.l().c(0);
            bVar.l().e(0);
            bVar.l().f(0);
            bVar.l().h(0);
            bVar.l().g(0);
            l0 j2 = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j2.r(2);
            ThreadCardViewHolder<c.a.r0.h1.k.b.c.a> threadCardViewHolder = new ThreadCardViewHolder<>(j2);
            threadCardViewHolder.setPageId(this.m);
            d0(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.h1.k.b.c.a aVar, ThreadCardViewHolder<c.a.r0.h1.k.b.c.a> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, threadCardViewHolder})) == null) {
            if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            TiebaStatic.log(new StatisticItem("c13448").param("topic_id", aVar.V));
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().setPage(this.o);
            threadCardViewHolder.showNEGFeedBackView(false).t(this.p);
            threadCardViewHolder.onBindDataToView(aVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.p = bVar;
        }
    }
}
