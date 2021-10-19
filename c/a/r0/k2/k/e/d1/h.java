package c.a.r0.k2.k.e.d1;

import android.view.View;
import c.a.l.a;
import c.a.l.o;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.b0.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h extends c.a.r0.k2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public d2 f20215f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.q.a f20216g;

    /* renamed from: h  reason: collision with root package name */
    public o f20217h;

    /* renamed from: i  reason: collision with root package name */
    public View f20218i;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.s.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20219e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20219e = hVar;
        }

        @Override // c.a.q0.s.q.a
        public x0 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (x0) invokeV.objValue;
        }

        @Override // c.a.q0.s.q.a
        public d2 getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20219e.f20215f : (d2) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20220e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20220e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (hVar = this.f20220e).f20177c) == null) {
                return;
            }
            interfaceC0093a.a(hVar.f20216g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20217h == null) {
                o oVar = new o(this.f20175a.getPageActivity());
                this.f20217h = oVar;
                oVar.m(Boolean.TRUE);
                this.f20217h.w("pb");
                this.f20217h.y(0);
                this.f20217h.D(this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f20175a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f20175a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
                this.f20217h.E(false);
                this.f20217h.C(true);
            }
            View f2 = this.f20217h.f();
            this.f20218i = f2;
            return f2;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20179e == i2) {
            return;
        }
        this.f20179e = i2;
        SkinManager.setBackgroundColor(this.f20218i, R.color.CAM_X0204);
        o oVar = this.f20217h;
        if (oVar != null) {
            oVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20178d = originalThreadInfo;
            this.f20215f = originalThreadInfo == null ? null : originalThreadInfo.a();
            a aVar = new a(this);
            this.f20216g = aVar;
            o oVar = this.f20217h;
            if (oVar != null) {
                oVar.onBindDataToView(aVar);
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void d(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0093a) == null) {
            super.d(interfaceC0093a);
            o oVar = this.f20217h;
            if (oVar != null) {
                oVar.z(interfaceC0093a);
            }
            View view = this.f20218i;
            if (view != null) {
                view.setOnClickListener(new b(this));
            }
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void e(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            super.e(c0Var);
            o oVar = this.f20217h;
            if (oVar != null) {
                oVar.k(this.f20176b);
            }
        }
    }
}
