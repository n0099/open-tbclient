package c.a.p0.h0;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends b<c.a.p0.o0.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018d : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.j || view == this.k || view == this.l || view == this.m) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 8).param("fid", this.p));
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f15304b.getPageActivity()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0904ff);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090500);
            this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090501);
            this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090502);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090503);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n = view.findViewById(R.id.obfuscated_res_0x7f0907f5);
            this.o = view.findViewById(R.id.obfuscated_res_0x7f0907f6);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: s */
    public void l(c.a.p0.o0.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null || eVar.e() == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.e().title)) {
            this.i.setText(eVar.e().title);
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        if (eVar.e().sub_nodes.size() >= 1) {
            this.j.setVisibility(0);
            this.j.setTag(eVar.e().sub_nodes.get(0).url);
            this.j.setText(eVar.e().sub_nodes.get(0).title);
        }
        if (eVar.e().sub_nodes.size() >= 2) {
            this.k.setVisibility(0);
            this.k.setTag(eVar.e().sub_nodes.get(1).url);
            this.k.setText(eVar.e().sub_nodes.get(1).title);
        }
        if (eVar.e().sub_nodes.size() >= 3) {
            this.l.setVisibility(0);
            this.l.setTag(eVar.e().sub_nodes.get(2).url);
            this.l.setText(eVar.e().sub_nodes.get(2).title);
        }
        if (eVar.e().sub_nodes.size() >= 4) {
            this.m.setVisibility(0);
            this.m.setTag(eVar.e().sub_nodes.get(3).url);
            this.m.setText(eVar.e().sub_nodes.get(3).title);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }
}
