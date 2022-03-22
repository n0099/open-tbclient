package c.a.p0.c0.l.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.c0.l.d.o;
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
/* loaded from: classes2.dex */
public class l extends c.a.d.o.e.a<o, CardViewHolder<c.a.p0.c0.l.h.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public c.a.p0.c0.l.e.a j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f13279b;

        public a(l lVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13279b = lVar;
            this.a = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13279b.b0(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext tbPageContext, c.a.p0.c0.l.e.a aVar) {
        super(tbPageContext.getPageActivity(), o.f13304b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
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
        this.j = aVar;
    }

    public final void a0(o oVar, c.a.p0.c0.l.h.a aVar) {
        c.a.p0.c0.l.d.c e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, oVar, aVar) == null) || (e2 = oVar.e()) == null || e2.b() == null) {
            return;
        }
        aVar.w(0);
        aVar.x(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0238));
        int i = e2.b().certify_status;
        if (i == 0) {
            aVar.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023c));
            aVar.v(0);
        } else if (1 == i) {
            aVar.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023b));
            aVar.v(4);
        } else if (2 == i) {
            aVar.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0239));
            aVar.v(4);
        } else if (3 == i) {
            aVar.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023a));
            aVar.v(0);
        }
        aVar.m(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0(o oVar) {
        AlaUserInfoData b2;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null || oVar.e() == null || oVar.e().b() == null || 1 == (i = (b2 = oVar.e().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.a;
        String str = b2.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b2.certify_status + "")));
        c.a.p0.c0.l.e.a aVar = this.j;
        if (aVar != null) {
            aVar.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public CardViewHolder<c.a.p0.c0.l.h.a> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new c.a.p0.c0.l.h.a(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public View S(int i, View view, ViewGroup viewGroup, o oVar, CardViewHolder<c.a.p0.c0.l.h.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, oVar, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            a0(oVar, cardViewHolder.c());
            cardViewHolder.c().k().setOnClickListener(new a(this, oVar));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }
}
