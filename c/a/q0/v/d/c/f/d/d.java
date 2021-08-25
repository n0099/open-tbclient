package c.a.q0.v.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.q0.v.d.c.e.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends c.a.q0.a0.b<k> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c m;
    public c n;
    public LinearLayout o;
    public ViewGroup p;
    public View q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new c(tbPageContext);
        this.n = new c(tbPageContext);
        ViewGroup viewGroup2 = (ViewGroup) j();
        this.p = viewGroup2;
        this.o = (LinearLayout) viewGroup2.findViewById(R.id.id_tab_live_sub_row);
        this.q = this.p.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(d());
        this.o.setPadding(i().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, i().getResources().getDimensionPixelSize(R.dimen.tbds44), i().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.o.addView(this.m.h());
        this.o.addView(view, new LinearLayout.LayoutParams(i().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.o.addView(this.n.h());
        l(this.f15232f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_list_live_row : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            this.m.k(tbPageContext, i2);
            this.n.k(tbPageContext, i2);
            SkinManager.setBackgroundResource(this.q, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: p */
    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) || kVar == null) {
            return;
        }
        this.m.i(kVar.f25098e);
        this.n.i(kVar.f25099f);
        if (kVar.f25100g) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    public void q(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.m.l(iVar);
            this.n.l(iVar);
        }
    }
}
