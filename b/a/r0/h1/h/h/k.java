package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.l.l0;
import b.a.l.v0.a;
import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k extends b.a.e.l.e.a<b.a.r0.b0.e0.k, ThreadCardViewHolder<b.a.r0.b0.e0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.e.l.e.s o;

    /* loaded from: classes4.dex */
    public class a implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.l.s f17399e;

        public a(k kVar, b.a.l.s sVar) {
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
            this.f17399e = sVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b.a.r0.b0.e0.k kVar;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                boolean z = nVar instanceof b.a.r0.b0.e0.k;
                if (z && (kVar = (b.a.r0.b0.e0.k) nVar) != null && kVar.y && (d2Var = kVar.f14748e) != null && d2Var.s0() != null) {
                    int a2 = b.a.q0.s.g0.p.c.a(kVar.f14748e.s0().button_link_type.intValue(), kVar.f14748e.s0().apk_detail != null ? kVar.f14748e.s0().apk_detail.pkg_source.intValue() : 0);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(kVar.f14748e.s0());
                    ItemCardHelper.q(this.f17399e.t(), kVar.f14748e.s0().item_id.longValue(), this.f17399e.s(itemData), kVar.f14748e.s1(), a2, "", 2);
                    ItemClickJumpUtil.itemClickJump(kVar.f14748e.s0().forum_name, String.valueOf(kVar.f14748e.s0().item_id), 1, 1);
                } else if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    b.a.r0.b0.e0.k kVar2 = (b.a.r0.b0.e0.k) nVar;
                    kVar2.k = 1;
                    ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) kVar2, view.getContext(), 4, false);
                    ((ThreadCardViewHolder) view.getTag()).getCardView().n(new a.C0090a(1));
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
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder<b.a.r0.b0.e0.k> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            b.a.l.s sVar = new b.a.l.s(this.n.getPageActivity());
            sVar.v(true);
            sVar.y(1);
            sVar.r();
            bVar.h(sVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.o);
            k.q(2);
            ThreadCardViewHolder<b.a.r0.b0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            c0(new a(this, sVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.k kVar, ThreadCardViewHolder<b.a.r0.b0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f14748e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f14748e.T1 = kVar.q();
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
