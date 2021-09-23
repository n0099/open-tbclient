package c.a.r0.f2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.b.d;
import c.a.q0.d1.p;
import c.a.r0.f2.g.b;
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
public class b implements b.d, c.a.r0.f2.f.c, View.OnClickListener, b.c, c.a.r0.f2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.f2.a.h.a f17623e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f17624f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.f2.g.b f17625g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f17626h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f17627i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f17628j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.f2.c.c n;
    public BdListView.p o;
    public View.OnClickListener p;

    /* loaded from: classes3.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17629e;

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
            this.f17629e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17629e.j();
            }
        }
    }

    /* renamed from: c.a.r0.f2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0862b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17630e;

        public View$OnClickListenerC0862b(b bVar) {
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
            this.f17630e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17630e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.f2.g.b bVar) {
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
        this.p = new View$OnClickListenerC0862b(this);
        this.f17624f = baseInterestedForumFragment;
        this.f17626h = bdTypeRecyclerView;
        this.f17625g = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f17628j = tBSpecificationBtn2;
        this.f17623e = new c.a.r0.f2.a.h.a(tbPageContext.getPageActivity(), this.f17626h);
        h();
        i();
    }

    @Override // c.a.r0.f2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f17623e.e()) {
                this.k.setEnabled(true);
                this.k.setText(this.f17626h.getResources().getString(R.string.start_the_trip));
            } else {
                this.k.setEnabled(false);
                this.k.setText(this.f17626h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
            this.f17628j.setTextSize(R.dimen.T_X06);
            if (!this.f17623e.f()) {
                this.f17628j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.o(R.color.CAM_X0304);
                this.f17628j.setConfig(cVar);
                return;
            }
            this.f17628j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.q(R.color.CAM_X0105);
            this.f17628j.setConfig(cVar);
        }
    }

    @Override // c.a.r0.f2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.o()) {
                this.f17624f.getActivity().setResult(-1);
                this.f17624f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.r0.f2.g.b.d
    public void c(c.a.r0.f2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.r0.f2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17646a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17646a.addAll(cVar.f17646a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17646a)) {
                if (this.f17626h.getVisibility() == 8) {
                    this.f17626h.setVisibility(0);
                }
                this.f17623e.j(cVar.f17646a);
                this.f17624f.onDataRes();
            }
            if (this.f17625g.m()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.r0.f2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.r0.f2.e.a.b(str);
            this.f17623e.a(i2, this.n, i3);
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
                if (nVar instanceof c.a.r0.f2.c.d) {
                    c.a.r0.f2.c.d dVar = (c.a.r0.f2.c.d) nVar;
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

    public void g(List<c.a.r0.f2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f17625g.q(list);
            this.f17625g.l();
            if (this.m) {
                return;
            }
            this.f17625g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f17626h.getContext());
            this.f17627i = pbListView;
            pbListView.a();
            this.f17627i.o(R.color.CAM_X0601);
            this.f17627i.v();
            this.f17627i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17627i.E(R.dimen.tbfontsize33);
            this.f17627i.y(R.color.CAM_X0110);
            this.f17627i.z(this.p);
            this.f17626h.setNextPage(this.f17627i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17626h.setOnSrollToBottomListener(this.o);
            this.f17625g.s(this);
            this.f17625g.r(this);
            this.f17623e.k(this);
            this.f17623e.i(this);
            this.k.setOnClickListener(this);
            this.f17628j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f17625g.m()) {
            c.a.r0.f2.g.b bVar = this.f17625g;
            if (bVar.f17672g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        c.a.r0.f2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f17623e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f17623e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17627i.H();
            this.f17627i.O();
            this.f17627i.A(this.f17626h.getContext().getString(R.string.list_loading));
            this.f17627i.J(l.g(this.f17626h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f17627i.B(this.f17626h.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f17626h.getContext(), R.dimen.tbds178));
            this.f17627i.E(R.dimen.tbds36);
            this.f17627i.y(R.color.CAM_X0109);
            this.f17627i.f();
            this.f17627i.z(null);
            this.f17627i.J(l.g(this.f17626h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                List<n> c2 = this.f17623e.c();
                try {
                    this.f17625g.g(c2);
                    c.a.r0.f2.e.a.a(2, 1, this.f17624f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f17628j || p.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.f17628j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.f17628j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // c.a.r0.f2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.r0.f2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f17646a)) {
                PbListView pbListView = this.f17627i;
                if (pbListView != null) {
                    pbListView.A(this.f17626h.getContext().getString(R.string.pb_load_more));
                    this.f17627i.f();
                    return;
                }
                return;
            }
            this.f17624f.onError(str);
        }
    }
}
