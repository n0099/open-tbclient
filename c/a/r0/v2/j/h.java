package c.a.r0.v2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h extends c.a.r0.g0.b<c.a.r0.v2.e.j> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public c.a.r0.v2.d.c n;
    public View o;
    public TextView p;
    public TextView q;
    public ImageView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
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
        p(j());
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.w2.e.card_privacy_setting_view : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17232e != i2) {
                SkinManager.setBackgroundResource(this.m, c.a.r0.w2.a.CAM_X0201);
                SkinManager.setBackgroundResource(this.o, c.a.r0.w2.a.CAM_X0205);
                SkinManager.setViewTextColor(this.q, c.a.r0.w2.a.CAM_X0109, 1);
                SkinManager.setImageResource(this.r, c.a.r0.w2.c.pic_pop_key);
                SkinManager.setViewTextColor(this.p, c.a.r0.w2.a.CAM_X0304, 1);
            }
            this.f17232e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.v2.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null || (cVar = this.n) == null || view != this.p) {
            return;
        }
        cVar.a();
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(c.a.r0.w2.d.card_privacy_setting_rootview);
            this.o = view.findViewById(c.a.r0.w2.d.top_divider_line);
            this.r = (ImageView) view.findViewById(c.a.r0.w2.d.lock_img);
            this.p = (TextView) view.findViewById(c.a.r0.w2.d.one_public_tv);
            this.q = (TextView) view.findViewById(c.a.r0.w2.d.card_hint_txt);
            this.p.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: q */
    public void k(c.a.r0.v2.e.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            if (jVar == null) {
                this.m.setVisibility(8);
                return;
            }
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            View view = this.o;
            if (view != null) {
                if (jVar.f24807e) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
            }
        }
    }

    public void s(c.a.r0.v2.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.n = cVar;
        }
    }
}
