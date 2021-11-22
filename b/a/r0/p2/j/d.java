package b.a.r0.p2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends b.a.r0.b0.b<b.a.r0.p2.e.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public b.a.r0.p2.e.e q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
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
        View i4 = i();
        this.m = i4;
        this.n = (TbImageView) i4.findViewById(R.id.card_person_auth_icon);
        this.o = (TextView) this.m.findViewById(R.id.card_person_auth_bar_name);
        this.p = (TextView) this.m.findViewById(R.id.card_person_auth_des);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_person_auth_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f16223e == i2) {
            return;
        }
        this.f16223e = i2;
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
        if (this.q.f23767e == null) {
            SkinManager.setImageResource(this.n, R.drawable.icon_shen_mine);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(b.a.r0.p2.e.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        this.q = eVar;
        String str = eVar.f23767e;
        if (str != null) {
            this.n.startLoad(str, 10, false);
        }
        this.o.setText(eVar.f23768f);
        this.p.setText(eVar.f23769g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }
}
