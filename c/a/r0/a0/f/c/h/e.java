package c.a.r0.a0.f.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends c.a.r0.g0.b<c.a.r0.a0.f.c.e.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a0.f.c.b m;
    public c.a.r0.a0.f.c.b n;
    public ViewGroup o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i2, boolean z) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.m = new g(tbPageContext, i2);
            this.n = new g(tbPageContext, i2);
            q();
            return;
        }
        this.m = new f(tbPageContext, i2);
        this.n = new f(tbPageContext, i2);
        p();
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_recommend_list_live_row : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.m.onChangeSkinType(tbPageContext, i2);
            this.n.onChangeSkinType(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = (ViewGroup) j();
            View view = new View(getContext());
            this.o.setPadding(i().getResources().getDimensionPixelSize(R.dimen.tbds44), i().getResources().getDimensionPixelSize(R.dimen.tbds12), i().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
            this.o.addView(this.m.getView());
            this.o.addView(view, new LinearLayout.LayoutParams(i().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
            this.o.addView(this.n.getView());
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = (ViewGroup) j();
            View view = new View(getContext());
            this.o.setPadding(i().getResources().getDimensionPixelSize(R.dimen.tbds34), i().getResources().getDimensionPixelSize(R.dimen.tbds21), i().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
            this.o.addView(this.m.getView());
            this.o.addView(view, new LinearLayout.LayoutParams(i().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
            this.o.addView(this.n.getView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: s */
    public void k(c.a.r0.a0.f.c.e.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null) {
            return;
        }
        this.m.a(eVar.f13943e);
        this.n.a(eVar.f13944f);
    }
}
