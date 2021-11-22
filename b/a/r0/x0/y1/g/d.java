package b.a.r0.x0.y1.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.q0.s.k;
import b.a.q0.s.q.b2;
import b.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
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

    @Override // b.a.r0.x0.y1.g.c, b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            if (i2 != this.y) {
                SkinManager.setViewTextColor(this.O, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.R, R.color.CAM_X0101);
            }
            super.k(tbPageContext, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.y1.g.c, b.a.r0.b0.b
    /* renamed from: x */
    public void j(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null || this.P == null || this.Q == null || this.F == null) {
            return;
        }
        if (d2Var.E0() != null) {
            d2Var.E0().clear();
        }
        d2Var.F3(null);
        b2 k1 = d2Var.k1();
        if (k1 == null) {
            return;
        }
        d2Var.T();
        k1.f();
        super.j(d2Var);
        if (k.c().g() && k1 != null && !StringUtils.isNull(k1.i())) {
            this.S.clear();
            this.S.add(k1.i());
            this.P.setVisibility(0);
            this.Q.setSupportNoImage(true);
            this.Q.setScaleType(ImageView.ScaleType.MATRIX);
            this.Q.setOnDrawListener(this.T);
            this.Q.startLoad(k1.i(), this.E ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.P.getLayoutParams();
            int k = l.k(getContext()) - l.g(getContext(), R.dimen.ds68);
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
