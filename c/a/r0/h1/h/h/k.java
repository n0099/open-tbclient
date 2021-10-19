package c.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k extends c.a.e.l.e.a<c.a.r0.b0.e0.k, ThreadCardViewHolder<c.a.r0.b0.e0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.e.l.e.s o;

    /* loaded from: classes3.dex */
    public class a implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.l.s f18465e;

        public a(k kVar, c.a.l.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18465e = sVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            c.a.r0.b0.e0.k kVar;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                boolean z = nVar instanceof c.a.r0.b0.e0.k;
                if (z && (kVar = (c.a.r0.b0.e0.k) nVar) != null && kVar.y && (d2Var = kVar.f15721e) != null && d2Var.s0() != null) {
                    ItemCardHelper.q(this.f18465e.t(), kVar.f15721e.s0().item_id.longValue(), this.f18465e.s(), kVar.f15721e.s1(), c.a.q0.s.f0.p.c.a(kVar.f15721e.s0().button_link_type.intValue(), kVar.f15721e.s0().apk_detail != null ? kVar.f15721e.s0().apk_detail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(kVar.f15721e.s0().forum_name, String.valueOf(kVar.f15721e.s0().item_id), 1, 1);
                } else if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    c.a.r0.b0.e0.k kVar2 = (c.a.r0.b0.e0.k) nVar;
                    kVar2.k = 1;
                    ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) kVar2, view.getContext(), 4, false);
                    ((ThreadCardViewHolder) view.getTag()).getCardView().o(new a.C0095a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<c.a.r0.b0.e0.k> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.s sVar = new c.a.l.s(this.n.getPageActivity());
            sVar.v(true);
            sVar.y(1);
            sVar.r();
            bVar.h(sVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
            k.r(2);
            ThreadCardViewHolder<c.a.r0.b0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            d0(new a(this, sVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.k kVar, ThreadCardViewHolder<c.a.r0.b0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f15721e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f15721e.T1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
