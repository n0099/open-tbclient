package c.a.t0.o2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.b.d;
import c.a.s0.e1.q;
import c.a.t0.o2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes8.dex */
public class b implements b.d, c.a.t0.o2.f.c, View.OnClickListener, b.c, c.a.t0.o2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.o2.a.h.a f20823e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f20824f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.t0.o2.g.b f20825g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f20826h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20827i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f20828j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.t0.o2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* loaded from: classes8.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20829e;

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
            this.f20829e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20829e.j();
            }
        }
    }

    /* renamed from: c.a.t0.o2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1303b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20830e;

        public View$OnClickListenerC1303b(b bVar) {
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
            this.f20830e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20830e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.t0.o2.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.o = 0;
        this.p = new a(this);
        this.q = new View$OnClickListenerC1303b(this);
        this.f20824f = baseInterestedForumFragment;
        this.f20826h = bdTypeRecyclerView;
        this.f20825g = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f20828j = tBSpecificationBtn2;
        this.o = i2;
        this.f20823e = new c.a.t0.o2.a.h.a(tbPageContext.getPageActivity(), this.f20826h);
        h();
        i();
    }

    @Override // c.a.t0.o2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f20823e.e()) {
                this.k.setEnabled(true);
                this.k.setText(this.f20826h.getResources().getString(R.string.start_the_trip));
            } else {
                this.k.setEnabled(false);
                this.k.setText(this.f20826h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            c.a.s0.s.j0.n.c cVar = new c.a.s0.s.j0.n.c();
            this.f20828j.setTextSize(R.dimen.T_X06);
            if (!this.f20823e.f()) {
                this.f20828j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.p(R.color.CAM_X0304);
                this.f20828j.setConfig(cVar);
                return;
            }
            this.f20828j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.r(R.color.CAM_X0105);
            this.f20828j.setConfig(cVar);
        }
    }

    @Override // c.a.t0.o2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f20824f.getActivity().finish();
            } else if (d.n()) {
                this.f20824f.getActivity().setResult(-1);
                this.f20824f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.t0.o2.g.b.d
    public void c(c.a.t0.o2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.t0.o2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.a.addAll(cVar.a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                if (this.f20826h.getVisibility() == 8) {
                    this.f20826h.setVisibility(0);
                }
                this.f20823e.j(cVar.a);
                this.f20824f.onDataRes();
            }
            if (this.f20825g.m()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.t0.o2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.t0.o2.e.a.b(str);
            this.f20823e.a(i2, this.n, i3);
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
                if (nVar instanceof c.a.t0.o2.c.d) {
                    c.a.t0.o2.c.d dVar = (c.a.t0.o2.c.d) nVar;
                    if (dVar.l()) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(dVar.e());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void g(List<c.a.t0.o2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f20825g.q(list);
            this.f20825g.l();
            if (this.m) {
                return;
            }
            this.f20825g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f20826h.getContext());
            this.f20827i = pbListView;
            pbListView.a();
            this.f20827i.p(R.color.CAM_X0601);
            this.f20827i.y();
            this.f20827i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f20827i.H(R.dimen.tbfontsize33);
            this.f20827i.B(R.color.CAM_X0110);
            this.f20827i.C(this.q);
            this.f20826h.setNextPage(this.f20827i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f20826h.setOnSrollToBottomListener(this.p);
            this.f20825g.s(this);
            this.f20825g.r(this);
            this.f20823e.k(this);
            this.f20823e.i(this);
            this.k.setOnClickListener(this);
            this.f20828j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f20825g.m()) {
            c.a.t0.o2.g.b bVar = this.f20825g;
            if (bVar.f20863g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        c.a.t0.o2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f20823e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f20823e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f20827i.K();
            this.f20827i.R();
            this.f20827i.D(this.f20826h.getContext().getString(R.string.list_loading));
            this.f20827i.M(c.a.d.f.p.n.f(this.f20826h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f20827i.E(this.f20826h.getContext().getString(R.string.interested_forum_list_no_more), c.a.d.f.p.n.f(this.f20826h.getContext(), R.dimen.tbds178));
            this.f20827i.H(R.dimen.tbds36);
            this.f20827i.B(R.color.CAM_X0109);
            this.f20827i.f();
            this.f20827i.C(null);
            this.f20827i.M(c.a.d.f.p.n.f(this.f20826h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                List<n> c2 = this.f20823e.c();
                try {
                    this.f20825g.g(c2);
                    c.a.t0.o2.e.a.a(2, 1, this.f20824f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f20828j || q.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.f20828j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.f20828j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // c.a.t0.o2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.t0.o2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f20827i;
                if (pbListView != null) {
                    pbListView.D(this.f20826h.getContext().getString(R.string.pb_load_more));
                    this.f20827i.f();
                    return;
                }
                return;
            }
            this.f20824f.onError(str);
        }
    }
}
