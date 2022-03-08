package c.a.r0.a0.f.c.f.d;

import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes2.dex */
public class h extends c.a.r0.f0.b<c.a.r0.a0.f.c.f.b.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g m;
    public g n;
    public g o;
    public ViewGroup p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.m = new g(tbPageContext);
        this.n = new g(tbPageContext);
        this.o = new g(tbPageContext);
        this.p = (ViewGroup) j();
        new View(getContext());
        this.p.setPadding(i().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, i().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.p.addView(this.m.e());
        this.p.addView(this.n.e());
        this.p.addView(this.o.e());
        l(this.f17261f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_recommend_list_live_row : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            this.m.g(tbPageContext, i2);
            this.n.g(tbPageContext, i2);
            this.o.g(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: p */
    public void k(c.a.r0.a0.f.c.f.b.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null) {
            return;
        }
        this.m.f(cVar.f14288e);
        this.n.f(cVar.f14289f);
        this.o.f(cVar.f14290g);
    }

    public void q(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.m.h(iVar);
            this.n.h(iVar);
            this.o.h(iVar);
        }
    }
}
