package c.a.p0.u2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public ViewStub p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f0923f0);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((n.i(tbPageContext.getPageActivity()) / 2) + n.f(tbPageContext.getPageActivity(), R.dimen.tbds239)) - n.f(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922c2);
        ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f0923ed);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092006);
        this.s = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09160d);
        this.t = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092007);
        this.u = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090167);
        this.v = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092008);
        this.w = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918f7);
    }

    @Override // c.a.p0.u2.b.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.q);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.r);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.tbds29);
            d3.A(R.string.F_X01);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.t);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.tbds29);
            d4.A(R.string.F_X01);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.v);
            d5.v(R.color.CAM_X0108);
            d5.z(R.dimen.tbds29);
            d5.A(R.string.F_X01);
            c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.s);
            d6.v(R.color.CAM_X0302);
            d6.z(R.dimen.tbds29);
            d6.A(R.string.F_X01);
            c.a.o0.r.v.c d7 = c.a.o0.r.v.c.d(this.u);
            d7.v(R.color.CAM_X0302);
            d7.z(R.dimen.tbds29);
            d7.A(R.string.F_X01);
            c.a.o0.r.v.c d8 = c.a.o0.r.v.c.d(this.w);
            d8.v(R.color.CAM_X0302);
            d8.z(R.dimen.tbds29);
            d8.A(R.string.F_X01);
        }
    }

    @Override // c.a.p0.u2.b.b
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        this.q.setText(cVar.a);
        f(cVar.a());
    }

    @Override // c.a.p0.u2.b.b
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            super.d(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cb8);
            } else if (i == 2) {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cb9);
            } else if (i != 3) {
            } else {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cba);
            }
        }
    }
}
