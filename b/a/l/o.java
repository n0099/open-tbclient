package b.a.l;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import b.a.l.a;
import b.a.l.v0.a;
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
    public b.a.q0.s.q.a m;
    public int n;
    public String o;
    public int p;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f3272e;

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
            this.f3272e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o oVar;
            a.InterfaceC0088a interfaceC0088a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0088a = (oVar = this.f3272e).f3219i) == null) {
                return;
            }
            interfaceC0088a.a(oVar.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f3273a;

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
            this.f3273a = oVar;
        }

        @Override // b.a.l.v0.a.b
        public boolean a(a.C0090a c0090a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0090a)) == null) {
                if (this.f3273a.m != null && this.f3273a.m.getThreadData() != null && !this.f3273a.e().booleanValue()) {
                    b.a.r0.b0.m.a(this.f3273a.m.getThreadData().f0());
                    b.a.r0.b0.m.l(this.f3273a.l.mTitle, this.f3273a.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    b.a.r0.b0.m.l(this.f3273a.l.mAbstract, this.f3273a.m.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
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

    public void B(b.a.e.e.k.b<ImageView> bVar, b.a.e.e.k.b<GifView> bVar2) {
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

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h(1, new b(this));
        }
    }

    @Override // b.a.l.a
    public void k(b.a.r0.b0.c0<b.a.q0.s.q.a> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c0Var) == null) {
            this.l.setSubClickListener(c0Var);
        }
    }

    @Override // b.a.l.q
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
    @Override // b.a.l.p
    /* renamed from: t */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
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

    public void z(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, interfaceC0088a) == null) {
            this.f3219i = interfaceC0088a;
        }
    }
}
