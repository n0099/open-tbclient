package c.a.l;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import c.a.l.a;
import c.a.l.v0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class o extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewGridImageLayout l;
    public c.a.q0.s.q.a m;
    public int n;
    public String o;
    public int p;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f3852e;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3852e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o oVar;
            a.InterfaceC0093a interfaceC0093a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0093a = (oVar = this.f3852e).f3785i) == null) {
                return;
            }
            interfaceC0093a.a(oVar.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f3853a;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3853a = oVar;
        }

        @Override // c.a.l.v0.a.b
        public boolean a(a.C0095a c0095a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0095a)) == null) {
                if (this.f3853a.m != null && this.f3853a.m.getThreadData() != null && !this.f3853a.e().booleanValue()) {
                    c.a.r0.a0.m.a(this.f3853a.m.getThreadData().f0());
                    c.a.r0.a0.m.l(this.f3853a.l.mTitle, this.f3853a.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    c.a.r0.a0.m.l(this.f3853a.l.mAbstract, this.f3853a.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
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
        this.n = 3;
        this.l = new NewGridImageLayout(context);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.l.setNeedFrsTabName(z);
        }
    }

    public void B(c.a.e.e.k.b<ImageView> bVar, c.a.e.e.k.b<GifView> bVar2) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) || (newGridImageLayout = this.l) == null) {
            return;
        }
        newGridImageLayout.setObjectPool(bVar, bVar2);
    }

    public void C(boolean z) {
        NewGridImageLayout newGridImageLayout;
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (newGridImageLayout = this.l) == null || (gridImageLayout = newGridImageLayout.mGridImageLayout) == null) {
            return;
        }
        gridImageLayout.setIsTransform(z);
    }

    public void D(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) && e().booleanValue()) {
            this.l.setPadding(i2, i3, i4, i5);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l.isUseInCard = z;
        }
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h(1, new b(this));
        }
    }

    @Override // c.a.l.a
    public void k(c.a.r0.a0.b0<c.a.q0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.l.setSubClickListener(b0Var);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i2) == null) {
            if (this.n != i2 && e().booleanValue()) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
            }
            NewGridImageLayout newGridImageLayout = this.l;
            if (newGridImageLayout != null) {
                newGridImageLayout.onChangeSkinType(i2);
            }
            this.n = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: t */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.m = aVar;
            this.l.setFrom(this.o);
            this.l.setFromForPb(this.p);
            this.l.setTransmit(e().booleanValue());
            this.l.onBindDataToView(aVar);
            this.l.setJumpToPbListener(new a(this));
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l.setBackgroundColor(i2);
        }
    }

    public void v(int i2) {
        NewGridImageLayout newGridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (newGridImageLayout = this.l) == null) {
            return;
        }
        newGridImageLayout.setCornerStyle(i2);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.o = str;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.l.setFromCDN(z);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.p = i2;
        }
    }

    public void z(a.InterfaceC0093a interfaceC0093a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, interfaceC0093a) == null) {
            this.f3785i = interfaceC0093a;
        }
    }
}
