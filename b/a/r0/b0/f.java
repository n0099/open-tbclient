package b.a.r0.b0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.q0.s.q.d2;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends b<b.a.r0.h0.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public TextView n;
    public LinearLayout o;
    public d p;
    public e q;
    public e r;
    public b.a.r0.h0.a s;
    public b.a.r0.h0.b t;
    public b.a.r0.h0.b u;
    public View v;
    public View w;
    public a x;
    public String y;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, BaseCardInfo baseCardInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.y = str;
        p(i());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_head_line_view_item : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0205);
            d dVar = this.p;
            if (dVar != null) {
                dVar.k(tbPageContext, i2);
            }
            e eVar = this.q;
            if (eVar != null) {
                eVar.k(tbPageContext, i2);
            }
            e eVar2 = this.r;
            if (eVar2 != null) {
                eVar2.k(tbPageContext, i2);
            }
        }
    }

    public final void o(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(h().getPageActivity()).createFromThreadCfg(d2Var, null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(d2Var.T()));
            createFromThreadCfg.setForumName(d2Var.Z());
            createFromThreadCfg.setStartFrom(0);
            m.a(d2Var.t1());
            h().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a.r0.h0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.y));
            if (view == this.p.i()) {
                b.a.r0.h0.a aVar = this.s;
                if (aVar == null) {
                    return;
                }
                a aVar2 = this.x;
                if (aVar2 != null) {
                    aVar2.a(view, aVar);
                }
                o(this.s.getThreadData());
            } else if (view == this.q.i()) {
                b.a.r0.h0.b bVar2 = this.t;
                if (bVar2 == null) {
                    return;
                }
                a aVar3 = this.x;
                if (aVar3 != null) {
                    aVar3.a(view, bVar2);
                }
                o(this.t.getThreadData());
            } else if (view != this.r.i() || (bVar = this.u) == null) {
            } else {
                a aVar4 = this.x;
                if (aVar4 != null) {
                    aVar4.a(view, bVar);
                }
                o(this.u.getThreadData());
            }
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
            this.n = (TextView) view.findViewById(R.id.frs_game_head_line_title);
            this.o = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
            this.v = view.findViewById(R.id.divider_line_1);
            this.w = view.findViewById(R.id.divider_line_2);
            int dimensionPixelSize = this.f16225g.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.p == null) {
                this.p = new d(this.f16224f, null, null);
            }
            this.p.s(0, 0, 0, 0);
            this.p.t(8);
            this.p.u(8);
            if (this.p.i().getParent() != null) {
                ((ViewGroup) this.p.i().getParent()).removeView(this.p.i());
            }
            this.p.i().setOnClickListener(this);
            this.p.i().setVisibility(8);
            this.o.addView(this.p.i());
            if (this.q == null) {
                this.q = new e(this.f16224f);
            }
            this.q.s(8);
            this.q.t(0, dimensionPixelSize, 0, 0);
            if (this.q.i().getParent() != null) {
                ((ViewGroup) this.q.i().getParent()).removeView(this.q.i());
            }
            this.q.i().setOnClickListener(this);
            this.q.i().setVisibility(8);
            this.o.addView(this.q.i());
            if (this.r == null) {
                this.r = new e(this.f16224f);
            }
            this.r.s(8);
            this.r.t(0, dimensionPixelSize, 0, 0);
            if (this.r.i().getParent() != null) {
                ((ViewGroup) this.r.i().getParent()).removeView(this.r.i());
            }
            this.r.i().setOnClickListener(this);
            this.r.i().setVisibility(8);
            this.o.addView(this.r.i());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: q */
    public void j(b.a.r0.h0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || dVar.g() == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar.g().f27306b)) {
            this.n.setText(dVar.g().f27306b);
        }
        List<d2> list = dVar.g().f27305a;
        if (ListUtils.getCount(list) >= 1) {
            b.a.r0.h0.a aVar = new b.a.r0.h0.a();
            this.s = aVar;
            aVar.g(list.get(0));
            this.p.i().setVisibility(0);
            this.p.j(this.s);
        }
        if (ListUtils.getCount(list) >= 2) {
            b.a.r0.h0.b bVar = new b.a.r0.h0.b();
            this.t = bVar;
            bVar.g(list.get(1));
            this.q.i().setVisibility(0);
            this.q.j(this.t);
            this.q.u(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            b.a.r0.h0.b bVar2 = new b.a.r0.h0.b();
            this.u = bVar2;
            bVar2.g(list.get(2));
            this.r.i().setVisibility(0);
            this.r.j(this.u);
            this.r.u(8);
        }
    }

    public void s(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.x = aVar;
        }
    }
}
