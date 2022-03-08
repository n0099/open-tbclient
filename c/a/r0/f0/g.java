package c.a.r0.f0;

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
public class g extends b<c.a.r0.m0.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public String t;

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

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_hot_topic_view_item : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(j(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.n || view == this.o || view == this.p || view == this.q) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 8).param("fid", this.t));
                UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f17261f.getPageActivity()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
            this.n = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
            this.o = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
            this.p = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
            this.q = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r = view.findViewById(R.id.divider_line_1);
            this.s = view.findViewById(R.id.divider_line_2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(c.a.r0.m0.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null || eVar.g() == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.g().title)) {
            this.m.setText(eVar.g().title);
        }
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        if (eVar.g().sub_nodes.size() >= 1) {
            this.n.setVisibility(0);
            this.n.setTag(eVar.g().sub_nodes.get(0).url);
            this.n.setText(eVar.g().sub_nodes.get(0).title);
        }
        if (eVar.g().sub_nodes.size() >= 2) {
            this.o.setVisibility(0);
            this.o.setTag(eVar.g().sub_nodes.get(1).url);
            this.o.setText(eVar.g().sub_nodes.get(1).title);
        }
        if (eVar.g().sub_nodes.size() >= 3) {
            this.p.setVisibility(0);
            this.p.setTag(eVar.g().sub_nodes.get(2).url);
            this.p.setText(eVar.g().sub_nodes.get(2).title);
        }
        if (eVar.g().sub_nodes.size() >= 4) {
            this.q.setVisibility(0);
            this.q.setTag(eVar.g().sub_nodes.get(3).url);
            this.q.setText(eVar.g().sub_nodes.get(3).title);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.t = str;
        }
    }
}
