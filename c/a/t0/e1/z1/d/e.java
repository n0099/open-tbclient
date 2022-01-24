package c.a.t0.e1.z1.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import c.a.l.w0.a;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.e1.e1;
import c.a.t0.e1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends c.a.d.n.e.a<d2, ThreadCardViewHolder<e2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public BdTypeRecyclerView o;

    /* loaded from: classes7.dex */
    public class a implements c.a.d.n.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.l.s f17264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17265f;

        public a(e eVar, c.a.l.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17265f = eVar;
            this.f17264e = sVar;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                boolean z = nVar instanceof d2;
                if (z) {
                    d2 d2Var = (d2) nVar;
                    if (d2Var.w.getType() == e2.Z3) {
                        BdToast.i(this.f17265f.n.getContext(), this.f17265f.n.getString(i1.video_is_checking), e1.icon_pure_toast_mistake40_svg, true).q();
                        return;
                    }
                    e2 e2Var = d2Var.w;
                    if (e2Var != null && d2Var.r && e2Var.u0() != null) {
                        int a = c.a.s0.s.k0.p.c.a(d2Var.w.u0().button_link_type.intValue(), d2Var.w.u0().apk_detail != null ? d2Var.w.u0().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(d2Var.w.u0());
                        ItemCardHelper.q(this.f17264e.t(), d2Var.w.u0().item_id.longValue(), this.f17264e.s(itemData), d2Var.w.w1(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(d2Var.w.u0().forum_name, String.valueOf(d2Var.w.u0().item_id), 10, 10);
                        return;
                    }
                }
                if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    e2 e2Var2 = ((d2) nVar).w;
                    e2Var2.objType = 1;
                    ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) e2Var2, view.getContext(), 2, false);
                    ((ThreadCardViewHolder) view.getTag()).getCardView().o(new a.C0204a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.m = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.s sVar = new c.a.l.s(this.n.getPageActivity());
            sVar.v(true);
            sVar.y(6);
            sVar.r();
            bVar.h(sVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
            k.r(2);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            V(new a(this, sVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<e2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || (e2Var = d2Var.w) == null) {
                return null;
            }
            e2Var.T1 = C(i2) + 1;
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.onBindDataToView(d2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) {
            this.o = bdTypeRecyclerView;
        }
    }
}
