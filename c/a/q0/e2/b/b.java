package c.a.q0.e2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.b.d;
import c.a.q0.e2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements b.d, c.a.q0.e2.f.c, View.OnClickListener, b.c, c.a.q0.e2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.e2.a.h.a f16999e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f17000f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.q0.e2.g.b f17001g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f17002h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f17003i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f17004j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.q0.e2.c.c n;
    public BdListView.p o;
    public View.OnClickListener p;

    /* loaded from: classes3.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17005e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17005e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17005e.j();
            }
        }
    }

    /* renamed from: c.a.q0.e2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0824b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17006e;

        public View$OnClickListenerC0824b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17006e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17006e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.q0.e2.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.o = new a(this);
        this.p = new View$OnClickListenerC0824b(this);
        this.f17000f = baseInterestedForumFragment;
        this.f17002h = bdTypeRecyclerView;
        this.f17001g = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f17004j = tBSpecificationBtn2;
        this.f16999e = new c.a.q0.e2.a.h.a(tbPageContext.getPageActivity(), this.f17002h);
        h();
        i();
    }

    @Override // c.a.q0.e2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f16999e.e()) {
                this.k.setEnabled(true);
                this.k.setText(this.f17002h.getResources().getString(R.string.start_the_trip));
            } else {
                this.k.setEnabled(false);
                this.k.setText(this.f17002h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            c.a.p0.s.f0.n.c cVar = new c.a.p0.s.f0.n.c();
            this.f17004j.setTextSize(R.dimen.T_X06);
            if (!this.f16999e.f()) {
                this.f17004j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.o(R.color.CAM_X0304);
                this.f17004j.setConfig(cVar);
                return;
            }
            this.f17004j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.q(R.color.CAM_X0105);
            this.f17004j.setConfig(cVar);
        }
    }

    @Override // c.a.q0.e2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.x()) {
                this.f17000f.getActivity().setResult(-1);
                this.f17000f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.q0.e2.g.b.d
    public void c(c.a.q0.e2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.q0.e2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17022a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17022a.addAll(cVar.f17022a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17022a)) {
                if (this.f17002h.getVisibility() == 8) {
                    this.f17002h.setVisibility(0);
                }
                this.f16999e.j(cVar.f17022a);
                this.f17000f.onDataRes();
            }
            if (this.f17001g.m()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.q0.e2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.q0.e2.e.a.b(str);
            this.f16999e.a(i2, this.n, i3);
        }
    }

    public String f(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = list.get(i2);
                if (nVar instanceof c.a.q0.e2.c.d) {
                    c.a.q0.e2.c.d dVar = (c.a.q0.e2.c.d) nVar;
                    if (dVar.l()) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(dVar.d());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void g(List<c.a.q0.e2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17001g.q(list);
            this.f17001g.l();
            if (this.m) {
                return;
            }
            this.f17001g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f17002h.getContext());
            this.f17003i = pbListView;
            pbListView.a();
            this.f17003i.o(R.color.CAM_X0601);
            this.f17003i.v();
            this.f17003i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17003i.E(R.dimen.tbfontsize33);
            this.f17003i.y(R.color.CAM_X0110);
            this.f17003i.z(this.p);
            this.f17002h.setNextPage(this.f17003i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17002h.setOnSrollToBottomListener(this.o);
            this.f17001g.s(this);
            this.f17001g.r(this);
            this.f16999e.k(this);
            this.f16999e.i(this);
            this.k.setOnClickListener(this);
            this.f17004j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f17001g.m()) {
            c.a.q0.e2.g.b bVar = this.f17001g;
            if (bVar.f17048g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        c.a.q0.e2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f16999e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f16999e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17003i.H();
            this.f17003i.O();
            this.f17003i.A(this.f17002h.getContext().getString(R.string.list_loading));
            this.f17003i.J(l.g(this.f17002h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f17003i.B(this.f17002h.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f17002h.getContext(), R.dimen.tbds178));
            this.f17003i.E(R.dimen.tbds36);
            this.f17003i.y(R.color.CAM_X0109);
            this.f17003i.f();
            this.f17003i.z(null);
            this.f17003i.J(l.g(this.f17002h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                List<n> c2 = this.f16999e.c();
                try {
                    this.f17001g.g(c2);
                    c.a.q0.e2.e.a.a(2, 1, this.f17000f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f17004j || c.a.p0.b1.l.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.f17004j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.f17004j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // c.a.q0.e2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.q0.e2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f17022a)) {
                PbListView pbListView = this.f17003i;
                if (pbListView != null) {
                    pbListView.A(this.f17002h.getContext().getString(R.string.pb_load_more));
                    this.f17003i.f();
                    return;
                }
                return;
            }
            this.f17000f.onError(str);
        }
    }
}
