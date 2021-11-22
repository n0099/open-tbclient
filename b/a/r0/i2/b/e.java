package b.a.r0.i2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_number);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - l.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view.findViewById(R.id.user_number);
        ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.viewstub_login_tip);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view.findViewById(R.id.tip_1);
        this.s = (TextView) view.findViewById(R.id.operator_text);
        this.t = (TextView) view.findViewById(R.id.tip_2);
        this.u = (TextView) view.findViewById(R.id.agreement_text);
        this.v = (TextView) view.findViewById(R.id.tip_3);
        this.w = (TextView) view.findViewById(R.id.privacy_text);
    }

    @Override // b.a.r0.i2.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.a(i2);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.q);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.r);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.tbds29);
            d3.A(R.string.F_X01);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.t);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.tbds29);
            d4.A(R.string.F_X01);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.v);
            d5.v(R.color.CAM_X0108);
            d5.z(R.dimen.tbds29);
            d5.A(R.string.F_X01);
            b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.s);
            d6.v(R.color.CAM_X0302);
            d6.z(R.dimen.tbds29);
            d6.A(R.string.F_X01);
            b.a.q0.s.u.c d7 = b.a.q0.s.u.c.d(this.u);
            d7.v(R.color.CAM_X0302);
            d7.z(R.dimen.tbds29);
            d7.A(R.string.F_X01);
            b.a.q0.s.u.c d8 = b.a.q0.s.u.c.d(this.w);
            d8.v(R.color.CAM_X0302);
            d8.z(R.dimen.tbds29);
            d8.A(R.string.F_X01);
        }
    }

    @Override // b.a.r0.i2.b.b
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        this.q.setText(cVar.f19398a);
        f(cVar.a());
    }

    @Override // b.a.r0.i2.b.b
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            super.d(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 1) {
                this.s.setText(R.string.onekey_login_dialog_activity_operator_1);
            } else if (i2 == 2) {
                this.s.setText(R.string.onekey_login_dialog_activity_operator_2);
            } else if (i2 != 3) {
            } else {
                this.s.setText(R.string.onekey_login_dialog_activity_operator_3);
            }
        }
    }
}
