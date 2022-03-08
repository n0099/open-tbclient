package c.a.r0.q2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.q0.c1.q;
import c.a.r0.q2.c.d;
import c.a.r0.q2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes2.dex */
public class b implements b.d, c.a.r0.q2.f.c, View.OnClickListener, b.c, c.a.r0.q2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.q2.a.h.a f21055e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f21056f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.q2.g.b f21057g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f21058h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21059i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f21060j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.q2.c.c n;
    public int o;
    public final boolean p;
    public BdListView.p q;
    public View.OnClickListener r;

    /* loaded from: classes2.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21061e;

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
            this.f21061e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21061e.j();
            }
        }
    }

    /* renamed from: c.a.r0.q2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1323b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21062e;

        public View$OnClickListenerC1323b(b bVar) {
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
            this.f21062e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21062e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.q2.g.b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar, Integer.valueOf(i2), Boolean.valueOf(z)};
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
        this.q = new a(this);
        this.r = new View$OnClickListenerC1323b(this);
        this.f21056f = baseInterestedForumFragment;
        this.f21058h = bdTypeRecyclerView;
        this.f21057g = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f21060j = tBSpecificationBtn2;
        this.o = i2;
        this.p = z;
        this.f21055e = new c.a.r0.q2.a.h.a(tbPageContext.getPageActivity(), this.f21058h);
        h();
        i();
    }

    @Override // c.a.r0.q2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f21055e.e()) {
                this.k.setEnabled(true);
                this.k.setText(this.f21058h.getResources().getString(R.string.start_the_trip));
            } else {
                this.k.setEnabled(false);
                this.k.setText(this.f21058h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            c.a.q0.r.l0.n.c cVar = new c.a.q0.r.l0.n.c();
            this.f21060j.setTextSize(R.dimen.T_X06);
            if (!this.f21055e.f()) {
                this.f21060j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.p(R.color.CAM_X0304);
                this.f21060j.setConfig(cVar);
                return;
            }
            this.f21060j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.r(R.color.CAM_X0105);
            this.f21060j.setConfig(cVar);
        }
    }

    @Override // c.a.r0.q2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f21056f.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.f21056f.getActivity().setResult(-1);
                this.f21056f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.r0.q2.g.b.d
    public void c(c.a.r0.q2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.r0.q2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.a.addAll(cVar.a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                if (this.f21058h.getVisibility() == 8) {
                    this.f21058h.setVisibility(0);
                }
                this.f21055e.j(cVar.a);
                this.f21056f.onDataRes();
            }
            if (this.f21057g.m()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.r0.q2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.r0.q2.e.a.b(str);
            this.f21055e.a(i2, this.n, i3);
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
                if (nVar instanceof d) {
                    d dVar = (d) nVar;
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

    public void g(List<c.a.r0.q2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f21057g.q(list);
            this.f21057g.l();
            if (this.m || this.p) {
                return;
            }
            this.f21057g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f21058h.getContext());
            this.f21059i = pbListView;
            pbListView.a();
            this.f21059i.p(R.color.CAM_X0601);
            this.f21059i.y();
            this.f21059i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f21059i.H(R.dimen.tbfontsize33);
            this.f21059i.B(R.color.CAM_X0110);
            this.f21059i.C(this.r);
            this.f21058h.setNextPage(this.f21059i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21058h.setOnSrollToBottomListener(this.q);
            this.f21057g.s(this);
            this.f21057g.r(this);
            this.f21055e.k(this);
            this.f21055e.i(this);
            this.k.setOnClickListener(this);
            this.f21060j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f21057g.m()) {
            c.a.r0.q2.g.b bVar = this.f21057g;
            if (bVar.f21095g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        c.a.r0.q2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f21055e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f21055e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f21059i.K();
            this.f21059i.R();
            this.f21059i.D(this.f21058h.getContext().getString(R.string.list_loading));
            this.f21059i.M(c.a.d.f.p.n.f(this.f21058h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f21059i.E(this.f21058h.getContext().getString(R.string.interested_forum_list_no_more), c.a.d.f.p.n.f(this.f21058h.getContext(), R.dimen.tbds178));
            this.f21059i.H(R.dimen.tbds36);
            this.f21059i.B(R.color.CAM_X0109);
            this.f21059i.f();
            this.f21059i.C(null);
            this.f21059i.M(c.a.d.f.p.n.f(this.f21058h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                List<n> c2 = this.f21055e.c();
                try {
                    this.f21057g.g(c2);
                    c.a.r0.q2.e.a.a(2, 1, this.f21056f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f21060j || q.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.f21060j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.f21060j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // c.a.r0.q2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.r0.q2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f21059i;
                if (pbListView != null) {
                    pbListView.D(this.f21058h.getContext().getString(R.string.pb_load_more));
                    this.f21059i.f();
                    return;
                }
                return;
            }
            this.f21056f.onError(str);
        }
    }
}
