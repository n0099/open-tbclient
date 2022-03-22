package c.a.p0.c0.l.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.p0.c0.l.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public ProgressBar j;
    public FrameLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0106 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090202);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09123a);
            this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09123b);
            this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090219);
            this.j = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f090203);
            this.k = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f09123e);
            k().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: s */
    public void l(f fVar) {
        c.a.p0.c0.l.d.c e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || (e2 = fVar.e()) == null || e2.b() == null) {
            return;
        }
        String str = "LV." + e2.b().yy_level_id;
        if (!TextUtils.isEmpty(e2.b().yy_level_name)) {
            str = e2.b().yy_level_name + str;
            this.m.setText(e2.b().yy_level_name);
        }
        this.i.setText(str);
        if (e2.b().yy_levelup_exp <= e2.b().yy_level_exp) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(e2.b().yy_level_next_name)) {
            this.n.setText(e2.b().yy_level_next_name);
        }
        long j = e2.b().yy_levelup_exp;
        long j2 = e2.b().yy_level_exp;
        this.j.setMax((int) j);
        this.j.setProgress((int) j2);
        if (TextUtils.isEmpty(e2.b().yy_level_next_name) || e2.b().yy_levelup_exp <= e2.b().yy_level_exp) {
            return;
        }
        String string = this.f15304b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0219);
        int i = (int) ((((float) (e2.b().yy_levelup_exp - e2.b().yy_level_exp)) * 100.0f) / ((float) e2.b().yy_levelup_exp));
        if (i <= 0) {
            i = 1;
        }
        this.l.setText(String.format(string, e2.b().yy_level_next_name, i + "%"));
    }
}
