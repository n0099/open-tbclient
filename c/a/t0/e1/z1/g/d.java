package c.a.t0.e1.z1.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.s0.s.k;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.e2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView O;
    public View P;
    public TbImageView Q;
    public TextView R;
    public ArrayList<String> S;
    public TbImageView.h T;
    public View.OnClickListener U;

    @Override // c.a.t0.e1.z1.g.c, c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            if (i2 != this.y) {
                SkinManager.setViewTextColor(this.O, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.R, R.color.CAM_X0101);
            }
            super.l(tbPageContext, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.e1.z1.g.c, c.a.t0.g0.b
    /* renamed from: y */
    public void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) || e2Var == null || this.P == null || this.Q == null || this.F == null) {
            return;
        }
        if (e2Var.G0() != null) {
            e2Var.G0().clear();
        }
        e2Var.I3(null);
        c2 n1 = e2Var.n1();
        if (n1 == null) {
            return;
        }
        e2Var.U();
        n1.f();
        super.k(e2Var);
        if (k.c().g() && n1 != null && !StringUtils.isNull(n1.i())) {
            this.S.clear();
            this.S.add(n1.i());
            this.P.setVisibility(0);
            this.Q.setSupportNoImage(true);
            this.Q.setScaleType(ImageView.ScaleType.MATRIX);
            this.Q.setOnDrawListener(this.T);
            this.Q.startLoad(n1.i(), this.E ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.P.getLayoutParams();
            int k = n.k(getContext()) - n.f(getContext(), R.dimen.ds68);
            layoutParams.width = k;
            layoutParams.height = (int) ((k * 428.0f) / 760.0f);
            this.P.setLayoutParams(layoutParams);
        } else {
            this.P.setVisibility(8);
        }
        this.Q.setOnClickListener(this.U);
        this.F.setVisibility(8);
    }
}
