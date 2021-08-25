package c.a.q0.v.j.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.v.j.d.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l extends c.a.e.l.e.a<o, CardViewHolder<c.a.q0.v.j.h.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public c.a.q0.v.j.e.a n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f25645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f25646f;

        public a(l lVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25646f = lVar;
            this.f25645e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25646f.j0(this.f25645e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext tbPageContext, c.a.q0.v.j.e.a aVar) {
        super(tbPageContext.getPageActivity(), o.f25681f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
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
        this.n = aVar;
    }

    public final void i0(o oVar, c.a.q0.v.j.h.a aVar) {
        c.a.q0.v.j.d.c g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, oVar, aVar) == null) || (g2 = oVar.g()) == null || g2.b() == null) {
            return;
        }
        aVar.v(0);
        aVar.w(this.f2966e.getResources().getString(R.string.ala_person_live_real_authen));
        int i2 = g2.b().certify_status;
        if (i2 == 0) {
            aVar.t(this.f2966e.getResources().getString(R.string.ala_person_live_real_authen_unauthorized));
            aVar.u(0);
        } else if (1 == i2) {
            aVar.t(this.f2966e.getResources().getString(R.string.ala_person_live_real_authen_in_review));
            aVar.u(4);
        } else if (2 == i2) {
            aVar.t(this.f2966e.getResources().getString(R.string.ala_person_live_real_authen_authenticated));
            aVar.u(4);
        } else if (3 == i2) {
            aVar.t(this.f2966e.getResources().getString(R.string.ala_person_live_real_authen_denied));
            aVar.u(0);
        }
        aVar.l(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(o oVar) {
        AlaUserInfoData b2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null || oVar.g() == null || oVar.g().b() == null || 1 == (i2 = (b2 = oVar.g().b()).certify_status) || 2 == i2) {
            return;
        }
        Context context = this.f2966e;
        String str = b2.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b2.certify_status + "")));
        c.a.q0.v.j.e.a aVar = this.n;
        if (aVar != null) {
            aVar.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public CardViewHolder<c.a.q0.v.j.h.a> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new c.a.q0.v.j.h.a(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public View a0(int i2, View view, ViewGroup viewGroup, o oVar, CardViewHolder<c.a.q0.v.j.h.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            i0(oVar, cardViewHolder.getCardView());
            cardViewHolder.getCardView().j().setOnClickListener(new a(this, oVar));
            return cardViewHolder.getCardView().j();
        }
        return (View) invokeCommon.objValue;
    }
}
