package c.a.t0.p1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a0 extends c.a.d.n.e.a<c.a.t0.p1.c.f.c, ThreadCardViewHolder<c.a.t0.p1.c.f.c>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public BdUniqueId n;
    public c.a.d.n.e.s o;
    public String p;
    public byte q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, byte b2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Byte.valueOf(b2)};
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
        this.m = tbPageContext;
        this.q = b2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public ThreadCardViewHolder<c.a.t0.p1.c.f.c> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            bVar.n(new c.a.t0.p1.c.h.b(this.m, this.n, this.q));
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().g(0);
            ThreadCardViewHolder<c.a.t0.p1.c.f.c> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.o));
            threadCardViewHolder.setPageId(this.n);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.p1.c.f.c cVar, ThreadCardViewHolder<c.a.t0.p1.c.f.c> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, threadCardViewHolder})) == null) {
            threadCardViewHolder.onBindDataToView(cVar);
            if (threadCardViewHolder.getCardView() != null) {
                threadCardViewHolder.getCardView().q(i2);
                threadCardViewHolder.getCardView().d(this.p);
                threadCardViewHolder.getCardView().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
            this.o = sVar;
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.p = str;
        }
    }
}
