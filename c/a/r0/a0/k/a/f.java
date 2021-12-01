package c.a.r0.a0.k.a;

import android.view.View;
import android.view.ViewGroup;
import c.a.d.m.e.s;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.k;
import c.a.r0.g0.b0;
import c.a.r0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f extends k<c2, FrsPageAlaVideoHolder> implements b0, c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d0<d2> A;
    public c.a.r0.a0.k.e.e x;
    public String y;
    public String z;

    /* loaded from: classes5.dex */
    public class a extends d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f14395b;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14395b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(2921018);
                } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header && view.getId() != R.id.user_avatar) {
                    customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.f14395b.o == null) {
                    return;
                }
                customMessage.setData(d2Var);
                this.f14395b.o.sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = new a(this);
    }

    @Override // c.a.r0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.z = str;
        }
    }

    @Override // c.a.r0.d1.k
    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bdUniqueId) == null) {
            super.o(tbPageContext, bdUniqueId);
        }
    }

    @Override // c.a.r0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: v0 */
    public FrsPageAlaVideoHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            c.a.r0.a0.k.e.e eVar = new c.a.r0.a0.k.e.e(tbPageContext, this.f2911i);
            this.x = eVar;
            eVar.a0(this.f2911i);
            this.x.a(this.y);
            this.x.m(this.A);
            return new FrsPageAlaVideoHolder(this.x);
        }
        return (FrsPageAlaVideoHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.k, c.a.d.m.e.a
    /* renamed from: w0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, frsPageAlaVideoHolder})) == null) {
            TiebaStatic.log("c11842");
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            d2 d2Var = c2Var.w;
            d2Var.U1 = (i2 + 1) - topThreadSize;
            customMessage.setData(d2Var);
            this.o.sendMessage(customMessage);
            if (c2Var != null) {
                c.a.r0.a0.k.e.e eVar = frsPageAlaVideoHolder.mView;
                if (eVar instanceof c.a.r0.t.e) {
                    eVar.d(this.z);
                }
                frsPageAlaVideoHolder.mView.a(this.y);
                frsPageAlaVideoHolder.mView.b0(i0());
                frsPageAlaVideoHolder.mView.k(c2Var.w);
                c2Var.w.S4();
            }
            this.q = (s) viewGroup;
            return frsPageAlaVideoHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
