package c.a.q0.v0.t1.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.a0.b0;
import c.a.q0.a0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends c.a.e.l.e.a<c.a.q0.g0.a, CardViewHolder<c.a.q0.a0.d>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c.a.q0.a0.d n;
    public String o;
    public String p;
    public b0 q;

    /* loaded from: classes4.dex */
    public class a extends b0<c.a.q0.g0.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f27168b;

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
            this.f27168b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c.a.q0.g0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", this.f27168b.o));
                this.f27168b.j0(view, aVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), c.a.q0.g0.a.f18305f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
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
        this.o = str;
        this.p = str2;
        this.m = tbPageContext;
    }

    public final void j0(View view, c.a.q0.g0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(aVar.getThreadData(), null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aVar.getThreadData().T()));
            createFromThreadCfg.setForumName(aVar.getThreadData().Z());
            createFromThreadCfg.setStartFrom(0);
            m.a(aVar.getThreadData().q1());
            this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            b0 b0Var = this.q;
            if (b0Var != null) {
                b0Var.a(view, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public CardViewHolder<c.a.q0.a0.d> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.n = new c.a.q0.a0.d(this.m, this.o, this.p);
            return new CardViewHolder<>(this.n);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.g0.a aVar, CardViewHolder<c.a.q0.a0.d> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().k(aVar);
            cardViewHolder.getCardView().l(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.getCardView().m(new a(this));
            return cardViewHolder.getCardView().j();
        }
        return (View) invokeCommon.objValue;
    }

    public void m0(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b0Var) == null) {
            this.q = b0Var;
        }
    }
}
