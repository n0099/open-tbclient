package c.a.k;

import android.content.Context;
import android.view.View;
import c.a.k.w0.a;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends c.a.k.a<c.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public BjhArticleLayout f3491j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.s.q.a f3492k;
    public View.OnClickListener l;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3493e;

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
            this.f3493e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f3493e;
                bVar.q(bVar.f3486e.j(), this.f3493e.f3492k);
            }
        }
    }

    /* renamed from: c.a.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0130b(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.k.w0.a.b
        public boolean a(a.C0131a c0131a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0131a)) == null) {
                if (this.a.f3492k != null && this.a.f3492k.getThreadData() != null) {
                    c.a.r0.g0.m.a(this.a.f3492k.getThreadData().g0());
                    c.a.r0.g0.m.l(this.a.f3491j.getTitle(), this.a.f3492k.getThreadData().g0(), R.color.CAM_X0101, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.f3491j = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.l);
    }

    @Override // c.a.k.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3491j : (View) invokeV.objValue;
    }

    @Override // c.a.k.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            h(1, new C0130b(this));
        }
    }

    @Override // c.a.k.a
    public void k(c.a.r0.g0.d0<c.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d0Var) == null) {
            super.k(d0Var);
            this.f3491j.setSubClickListener(d0Var);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            this.f3491j.onChangeSkinType(tbPageContext, i2);
        }
    }

    public final void q(View view, c.a.d.m.e.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, nVar) == null) {
            c.a.q0.s.q.a aVar = this.f3492k;
            if (((aVar instanceof c.a.r0.g0.f0.e) || (aVar instanceof d2)) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                if (nVar instanceof c.a.r0.g0.f0.e) {
                    c.a.r0.g0.f0.e eVar = (c.a.r0.g0.f0.e) this.f3492k;
                    eVar.f17251k = 1;
                    ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) eVar, view.getContext(), eVar.f17245e.b2 ? 2 : 1, false);
                    threadCardViewHolder.getCardView().o(new a.C0131a(1));
                } else if (nVar instanceof d2) {
                    d2 d2Var = (d2) this.f3492k;
                    d2Var.objType = 1;
                    ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), 3, false);
                    threadCardViewHolder.getCardView().o(new a.C0131a(1));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    /* renamed from: r */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f3492k = aVar;
            this.f3491j.onBindDataToView(aVar);
        }
    }
}
