package b.a.r0.b0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class p extends b<b.a.r0.b0.f0.o> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public b.a.r0.b0.f0.o C;
    public String D;
    public View m;
    public TextView n;
    public TextView o;
    public LinearLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f16324e;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16324e = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || b.a.q0.s0.b.b(this.f16324e.h())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(this.f16324e.h().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext) {
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
        o(i());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.home_card_hot_topic_item : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f16223e != i2) {
                SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.A, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.B, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.p, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.q, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.r, R.drawable.card_topic_click_selector);
                SkinManager.setBackgroundResource(this.s, R.drawable.card_topic_click_selector);
                p(this.t, 0);
                p(this.u, 1);
                p(this.v, 2);
                p(this.w, 3);
            }
            this.f16223e = i2;
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.m = view.findViewById(R.id.home_card_hot_topic_root_view);
            this.n = (TextView) view.findViewById(R.id.home_card_topic_title);
            this.o = (TextView) view.findViewById(R.id.home_card_topic_more);
            this.p = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
            this.q = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
            this.r = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
            this.s = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
            this.t = (TextView) view.findViewById(R.id.home_card_topic_one);
            this.u = (TextView) view.findViewById(R.id.home_card_topic_two);
            this.v = (TextView) view.findViewById(R.id.home_card_topic_three);
            this.w = (TextView) view.findViewById(R.id.home_card_topic_four);
            this.x = view.findViewById(R.id.home_top_div);
            this.y = view.findViewById(R.id.home_top_topic_div_one);
            this.z = view.findViewById(R.id.home_top_topic_div_two);
            this.A = view.findViewById(R.id.home_card_top_divider_line);
            this.B = view.findViewById(R.id.home_card_bottom_divider_line);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.o.setOnClickListener(new a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            int e2 = b.a.e.f.m.b.e((String) view.getTag(), -1);
            b.a.r0.b0.f0.o oVar = this.C;
            if (oVar == null || ListUtils.getItem(oVar.f16264h, e2) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(this.D).param("obj_locate", String.valueOf(this.C.j)).param("obj_name", this.C.f16264h.get(e2).f16259b));
            if (e2 >= 0 && !b.a.q0.s0.b.b(h())) {
                h().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(h().getPageActivity()).createNormalConfig(String.valueOf(this.C.f16264h.get(e2).f16258a), this.C.f16264h.get(e2).f16259b, "")));
            }
        }
    }

    public final void p(TextView textView, int i2) {
        b.a.r0.b0.f0.o oVar;
        b.a.r0.b0.f0.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i2) == null) || (oVar = this.C) == null || ListUtils.getCount(oVar.f16264h) < 4 || (nVar = (b.a.r0.b0.f0.n) ListUtils.getItem(this.C.f16264h, i2)) == null) {
            return;
        }
        int i3 = nVar.f16260c;
        if (i3 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
        } else if (i3 == 2) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
        } else if (i3 != 3) {
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: q */
    public void j(b.a.r0.b0.f0.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oVar) == null) {
            if (oVar != null && !StringUtils.isNull(oVar.f16263g) && ListUtils.getCount(oVar.f16264h) >= 4) {
                if (this.m.getVisibility() != 0) {
                    this.m.setVisibility(0);
                }
                this.C = oVar;
                this.A.setVisibility(oVar.f16261e ? 0 : 8);
                v(this.C.f16262f);
                this.n.setText(this.C.f16263g.trim());
                u(this.t, 0);
                u(this.u, 1);
                u(this.v, 2);
                u(this.w, 3);
                p(this.t, 0);
                p(this.u, 1);
                p(this.v, 2);
                p(this.w, 3);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.D = str2;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
            layoutParams.height = i2;
            this.A.setLayoutParams(layoutParams);
        }
    }

    public final void u(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, textView, i2) == null) {
            b.a.r0.b0.f0.n nVar = this.C.f16264h.get(i2);
            if (StringUtils.isNull(nVar.f16259b)) {
                return;
            }
            textView.setText(nVar.f16259b.trim());
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
        }
    }
}
