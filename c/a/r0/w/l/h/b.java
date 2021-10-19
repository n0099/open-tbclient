package c.a.r0.w.l.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.r0.w.l.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends c.a.r0.b0.b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public ProgressBar n;
    public FrameLayout o;
    public TextView p;
    public TextView q;
    public TextView r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_person_center_list_head_item : invokeV.intValue;
    }

    @Override // c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
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
            this.m = (TextView) view.findViewById(R.id.ala_person_center_level);
            this.q = (TextView) view.findViewById(R.id.level_name_curr);
            this.r = (TextView) view.findViewById(R.id.level_name_next);
            this.p = (TextView) view.findViewById(R.id.ala_person_center_tips);
            this.n = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
            this.o = (FrameLayout) view.findViewById(R.id.level_privilege_layout);
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: q */
    public void k(f fVar) {
        c.a.r0.w.l.d.c g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || (g2 = fVar.g()) == null || g2.b() == null) {
            return;
        }
        String str = "LV." + g2.b().yy_level_id;
        if (!TextUtils.isEmpty(g2.b().yy_level_name)) {
            str = g2.b().yy_level_name + str;
            this.q.setText(g2.b().yy_level_name);
        }
        this.m.setText(str);
        if (g2.b().yy_levelup_exp <= g2.b().yy_level_exp) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(g2.b().yy_level_next_name)) {
            this.r.setText(g2.b().yy_level_next_name);
        }
        long j2 = g2.b().yy_levelup_exp;
        long j3 = g2.b().yy_level_exp;
        this.n.setMax((int) j2);
        this.n.setProgress((int) j3);
        if (TextUtils.isEmpty(g2.b().yy_level_next_name) || g2.b().yy_levelup_exp <= g2.b().yy_level_exp) {
            return;
        }
        String string = this.f15708f.getPageActivity().getResources().getString(R.string.ala_level_next_tips);
        int i2 = (int) ((((float) (g2.b().yy_levelup_exp - g2.b().yy_level_exp)) * 100.0f) / ((float) g2.b().yy_levelup_exp));
        if (i2 <= 0) {
            i2 = 1;
        }
        this.p.setText(String.format(string, g2.b().yy_level_next_name, i2 + "%"));
    }
}
