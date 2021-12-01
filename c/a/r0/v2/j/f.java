package c.a.r0.v2.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f extends c.a.r0.g0.b<c.a.r0.v2.e.h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public View n;
    public View o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View j2 = j();
        this.n = j2;
        this.m = (TbImageView) j2.findViewById(c.a.r0.w2.d.center_image);
        this.o = this.n.findViewById(c.a.r0.w2.d.more_view_container);
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.w2.e.card_more_item : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f17232e == i2) {
            return;
        }
        this.f17232e = i2;
        SkinManager.setImageResource(this.m, c.a.r0.w2.c.icon_mine_more);
        SkinManager.setBackgroundResource(this.n, c.a.r0.w2.c.btn_look_more_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: p */
    public void k(c.a.r0.v2.e.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            if (hVar == null) {
                this.n.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width > 0) {
                    layoutParams.width = hVar.f24801e;
                }
                if (layoutParams.height > 0) {
                    layoutParams.height = hVar.f24802f;
                }
            }
            this.o.setLayoutParams(layoutParams);
            this.n.setVisibility(0);
            l(this.f17233f, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
