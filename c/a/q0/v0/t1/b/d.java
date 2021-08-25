package c.a.q0.v0.t1.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.a0.b0;
import c.a.q0.a0.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d extends c.a.e.l.e.a<c.a.q0.g0.d, CardViewHolder<c.a.q0.a0.f>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c.a.q0.a0.f n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27170a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27170a = dVar;
        }

        @Override // c.a.q0.a0.f.a
        public void a(View view, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) || this.f27170a.o == null) {
                return;
            }
            this.f27170a.o.a(view, baseCardInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), c.a.q0.g0.d.f18311f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public CardViewHolder<c.a.q0.a0.f> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.n = new c.a.q0.a0.f(this.m, this.p);
            return new CardViewHolder<>(this.n);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.g0.d dVar, CardViewHolder<c.a.q0.a0.f> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().k(dVar);
            cardViewHolder.getCardView().l(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.getCardView().t(new a(this));
            return cardViewHolder.getCardView().j();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b0Var) == null) {
            this.o = b0Var;
        }
    }
}
