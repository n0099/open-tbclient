package c.a.t0.y2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g extends c.a.t0.g0.b<c.a.t0.y2.e.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public ImageView n;
    public TextView o;
    public String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext) {
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

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.t0.z2.e.card_null_polymeric_view : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17588e != i2) {
                SkinManager.setBackgroundResource(this.m, c.a.t0.z2.a.CAM_X0201);
                SkinManager.setImageResource(this.n, c.a.t0.z2.c.new_pic_emotion_07);
                SkinManager.setViewTextColor(this.o, c.a.t0.z2.a.CAM_X0108, 1);
            }
            this.f17588e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(c.a.t0.z2.d.card_null_polymeric_rootview);
            this.n = (ImageView) view.findViewById(c.a.t0.z2.d.card_null_polymeric_icon);
            this.o = (TextView) view.findViewById(c.a.t0.z2.d.card_null_polymeric_txt);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: q */
    public void k(c.a.t0.y2.e.i iVar) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            if (iVar == null) {
                this.m.setVisibility(8);
                return;
            }
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            if (StringUtils.isNull(this.p)) {
                TextView textView = this.o;
                String string2 = this.f17590g.getString(c.a.t0.z2.g.person_polymeric_null_data);
                Object[] objArr = new Object[1];
                if (iVar.f25717e) {
                    string = this.f17590g.getString(c.a.t0.z2.g.you);
                } else if (iVar.f25718f == 2) {
                    string = this.f17590g.getString(c.a.t0.z2.g.she);
                } else {
                    string = this.f17590g.getString(c.a.t0.z2.g.he);
                }
                objArr[0] = string;
                textView.setText(String.format(string2, objArr));
                return;
            }
            this.o.setText(this.p);
        }
    }
}
