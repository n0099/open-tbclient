package c.a.s0.d1.y1.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.r0.s.l;
import c.a.r0.s.r.b2;
import c.a.r0.s.r.d2;
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

    @Override // c.a.s0.d1.y1.g.c, c.a.s0.g0.b
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
    @Override // c.a.s0.d1.y1.g.c, c.a.s0.g0.b
    /* renamed from: y */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null || this.P == null || this.Q == null || this.F == null) {
            return;
        }
        if (d2Var.F0() != null) {
            d2Var.F0().clear();
        }
        d2Var.H3(null);
        b2 m1 = d2Var.m1();
        if (m1 == null) {
            return;
        }
        d2Var.U();
        m1.f();
        super.k(d2Var);
        if (l.c().g() && m1 != null && !StringUtils.isNull(m1.i())) {
            this.S.clear();
            this.S.add(m1.i());
            this.P.setVisibility(0);
            this.Q.setSupportNoImage(true);
            this.Q.setScaleType(ImageView.ScaleType.MATRIX);
            this.Q.setOnDrawListener(this.T);
            this.Q.startLoad(m1.i(), this.E ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.P.getLayoutParams();
            int k2 = m.k(getContext()) - m.f(getContext(), R.dimen.ds68);
            layoutParams.width = k2;
            layoutParams.height = (int) ((k2 * 428.0f) / 760.0f);
            this.P.setLayoutParams(layoutParams);
        } else {
            this.P.setVisibility(8);
        }
        this.Q.setOnClickListener(this.U);
        this.F.setVisibility(8);
    }
}
