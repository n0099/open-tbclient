package c.a.p0.h0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class f extends b<c.a.p0.o0.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public d l;
    public e m;
    public e n;
    public c.a.p0.o0.a o;
    public c.a.p0.o0.b p;
    public c.a.p0.o0.b q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = str;
        s(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018c : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            d dVar = this.l;
            if (dVar != null) {
                dVar.m(tbPageContext, i);
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.m(tbPageContext, i);
            }
            e eVar2 = this.n;
            if (eVar2 != null) {
                eVar2.m(tbPageContext, i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.o0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view == this.l.k()) {
                c.a.p0.o0.a aVar = this.o;
                if (aVar == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view, aVar);
                }
                q(this.o.getThreadData());
            } else if (view == this.m.k()) {
                c.a.p0.o0.b bVar2 = this.p;
                if (bVar2 == null) {
                    return;
                }
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view, bVar2);
                }
                q(this.p.getThreadData());
            } else if (view != this.n.k() || (bVar = this.q) == null) {
            } else {
                a aVar4 = this.t;
                if (aVar4 != null) {
                    aVar4.a(view, bVar);
                }
                q(this.q.getThreadData());
            }
        }
    }

    public final void q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(j().getPageActivity()).createFromThreadCfg(threadData, null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            m.a(threadData.getTid());
            j().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0904fe);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090af8);
            this.k = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090af7);
            this.r = view.findViewById(R.id.obfuscated_res_0x7f0907f5);
            this.s = view.findViewById(R.id.obfuscated_res_0x7f0907f6);
            int dimensionPixelSize = this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new d(this.f15304b, null, null);
            }
            this.l.u(0, 0, 0, 0);
            this.l.v(8);
            this.l.w(8);
            if (this.l.k().getParent() != null) {
                ((ViewGroup) this.l.k().getParent()).removeView(this.l.k());
            }
            this.l.k().setOnClickListener(this);
            this.l.k().setVisibility(8);
            this.k.addView(this.l.k());
            if (this.m == null) {
                this.m = new e(this.f15304b);
            }
            this.m.u(8);
            this.m.v(0, dimensionPixelSize, 0, 0);
            if (this.m.k().getParent() != null) {
                ((ViewGroup) this.m.k().getParent()).removeView(this.m.k());
            }
            this.m.k().setOnClickListener(this);
            this.m.k().setVisibility(8);
            this.k.addView(this.m.k());
            if (this.n == null) {
                this.n = new e(this.f15304b);
            }
            this.n.u(8);
            this.n.v(0, dimensionPixelSize, 0, 0);
            if (this.n.k().getParent() != null) {
                ((ViewGroup) this.n.k().getParent()).removeView(this.n.k());
            }
            this.n.k().setOnClickListener(this);
            this.n.k().setVisibility(8);
            this.k.addView(this.n.k());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: t */
    public void l(c.a.p0.o0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || dVar.e() == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar.e().f14817b)) {
            this.j.setText(dVar.e().f14817b);
        }
        List<ThreadData> list = dVar.e().a;
        if (ListUtils.getCount(list) >= 1) {
            c.a.p0.o0.a aVar = new c.a.p0.o0.a();
            this.o = aVar;
            aVar.e(list.get(0));
            this.l.k().setVisibility(0);
            this.l.l(this.o);
        }
        if (ListUtils.getCount(list) >= 2) {
            c.a.p0.o0.b bVar = new c.a.p0.o0.b();
            this.p = bVar;
            bVar.e(list.get(1));
            this.m.k().setVisibility(0);
            this.m.l(this.p);
            this.m.w(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            c.a.p0.o0.b bVar2 = new c.a.p0.o0.b();
            this.q = bVar2;
            bVar2.e(list.get(2));
            this.n.k().setVisibility(0);
            this.n.l(this.q);
            this.n.w(8);
        }
    }

    public void u(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }
}
