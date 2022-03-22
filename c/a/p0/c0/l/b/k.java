package c.a.p0.c0.l.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.c0.l.d.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k extends c.a.d.o.e.a<n, CardViewHolder<c.a.p0.c0.l.h.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), n.f13303b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.i = tbPageContext;
    }

    public final void Z(n nVar, c.a.p0.c0.l.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nVar, cVar) == null) {
            c.a.p0.c0.l.d.c e2 = nVar.e();
            if (e2 != null && e2.a() != null && !TextUtils.isEmpty(e2.a().a())) {
                cVar.t(e2.a().a());
                cVar.m(this.i, TbadkCoreApplication.getInst().getSkinType());
                H();
                return;
            }
            cVar.p(8);
            H();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public CardViewHolder<c.a.p0.c0.l.h.c> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new CardViewHolder<>(new c.a.p0.c0.l.h.c(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i, View view, ViewGroup viewGroup, n nVar, CardViewHolder<c.a.p0.c0.l.h.c> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, nVar, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            Z(nVar, cardViewHolder.c());
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }
}
