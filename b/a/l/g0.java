package b.a.l;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.l.a;
import b.a.l.v0.a;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RichTextLayout l;
    public b.a.q0.s.q.a m;
    public int n;
    public String o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g0 f3231e;

        public a(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3231e = g0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g0 g0Var;
            a.InterfaceC0088a interfaceC0088a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0088a = (g0Var = this.f3231e).f3219i) == null) {
                return;
            }
            interfaceC0088a.a(g0Var.m);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f3232a;

        public b(g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3232a = g0Var;
        }

        @Override // b.a.l.v0.a.b
        public boolean a(a.C0090a c0090a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0090a)) == null) {
                if (this.f3232a.m != null && this.f3232a.m.getThreadData() != null && !this.f3232a.e().booleanValue()) {
                    d2 threadData = this.f3232a.m.getThreadData();
                    b.a.r0.b0.m.a(threadData.f0());
                    b.a.r0.b0.m.l(this.f3232a.l.mTitle, threadData.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    b.a.r0.b0.m.l(this.f3232a.l.mAbstract, threadData.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.l = new RichTextLayout(tbPageContext.getPageActivity());
        this.l.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, new b(this));
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            if (this.n != i2 && e().booleanValue()) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
            }
            this.n = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: t */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.m = aVar;
            this.l.setTransmit(e().booleanValue());
            this.l.onBindDataToView(aVar);
            this.l.setJumpToPbListener(new a(this));
            this.l.setFrom(this.o);
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.o = str;
        }
    }

    public void v(a.InterfaceC0088a interfaceC0088a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0088a) == null) {
            this.f3219i = interfaceC0088a;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l.setNeedFrsTabName(z);
        }
    }

    public void x(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            this.l.setPadding(i2, i3, i4, i5);
        }
    }
}
