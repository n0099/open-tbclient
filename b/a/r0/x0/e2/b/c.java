package b.a.r0.x0.e2.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.b0.c0;
import b.a.r0.b0.m;
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
/* loaded from: classes5.dex */
public class c extends b.a.e.l.e.a<b.a.r0.h0.b, CardViewHolder<b.a.r0.b0.e>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public b.a.r0.b0.e n;
    public c0 o;
    public String p;

    /* loaded from: classes5.dex */
    public class a extends c0<b.a.r0.h0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f25698b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25698b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, b.a.r0.h0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 3).param("fid", this.f25698b.p));
                this.f25698b.i0(view, bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), b.a.r0.h0.b.f16878f);
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

    public final void i0(View view, b.a.r0.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bVar) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(bVar.getThreadData(), null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bVar.getThreadData().T()));
            createFromThreadCfg.setForumName(bVar.getThreadData().Z());
            createFromThreadCfg.setStartFrom(0);
            m.a(bVar.getThreadData().s1());
            this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            c0 c0Var = this.o;
            if (c0Var != null) {
                c0Var.a(view, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public CardViewHolder<b.a.r0.b0.e> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.n = new b.a.r0.b0.e(this.m);
            return new CardViewHolder<>(this.n);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.h0.b bVar, CardViewHolder<b.a.r0.b0.e> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().j(bVar);
            cardViewHolder.getCardView().k(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.getCardView().l(new a(this));
            return cardViewHolder.getCardView().i();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c0Var) == null) {
            this.o = c0Var;
        }
    }
}
