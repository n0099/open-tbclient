package c.a.r0.m2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.b.d;
import c.a.q0.d1.o;
import c.a.r0.m2.g.b;
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
/* loaded from: classes6.dex */
public class b implements b.d, c.a.r0.m2.f.c, View.OnClickListener, b.c, c.a.r0.m2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.m2.a.h.a f19996e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f19997f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.m2.g.b f19998g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f19999h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20000i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f20001j;

    /* renamed from: k  reason: collision with root package name */
    public final TBSpecificationBtn f20002k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.m2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20003e;

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
            this.f20003e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20003e.j();
            }
        }
    }

    /* renamed from: c.a.r0.m2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1190b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20004e;

        public View$OnClickListenerC1190b(b bVar) {
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
            this.f20004e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20004e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.m2.g.b bVar, int i2) {
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
        this.q = new View$OnClickListenerC1190b(this);
        this.f19997f = baseInterestedForumFragment;
        this.f19999h = bdTypeRecyclerView;
        this.f19998g = bVar;
        this.l = tbPageContext;
        this.f20002k = tBSpecificationBtn;
        this.f20001j = tBSpecificationBtn2;
        this.o = i2;
        this.f19996e = new c.a.r0.m2.a.h.a(tbPageContext.getPageActivity(), this.f19999h);
        h();
        i();
    }

    @Override // c.a.r0.m2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f19996e.e()) {
                this.f20002k.setEnabled(true);
                this.f20002k.setText(this.f19999h.getResources().getString(R.string.start_the_trip));
            } else {
                this.f20002k.setEnabled(false);
                this.f20002k.setText(this.f19999h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            c.a.q0.s.g0.n.c cVar = new c.a.q0.s.g0.n.c();
            this.f20001j.setTextSize(R.dimen.T_X06);
            if (!this.f19996e.f()) {
                this.f20001j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.p(R.color.CAM_X0304);
                this.f20001j.setConfig(cVar);
                return;
            }
            this.f20001j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.r(R.color.CAM_X0105);
            this.f20001j.setConfig(cVar);
        }
    }

    @Override // c.a.r0.m2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f19997f.getActivity().finish();
            } else if (d.p()) {
                this.f19997f.getActivity().setResult(-1);
                this.f19997f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.r0.m2.g.b.d
    public void c(c.a.r0.m2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.r0.m2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.a.addAll(cVar.a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                if (this.f19999h.getVisibility() == 8) {
                    this.f19999h.setVisibility(0);
                }
                this.f19996e.j(cVar.a);
                this.f19997f.onDataRes();
            }
            if (this.f19998g.m()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.r0.m2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.r0.m2.e.a.b(str);
            this.f19996e.a(i2, this.n, i3);
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
                if (nVar instanceof c.a.r0.m2.c.d) {
                    c.a.r0.m2.c.d dVar = (c.a.r0.m2.c.d) nVar;
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

    public void g(List<c.a.r0.m2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f19998g.q(list);
            this.f19998g.l();
            if (this.m) {
                return;
            }
            this.f19998g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f19999h.getContext());
            this.f20000i = pbListView;
            pbListView.a();
            this.f20000i.p(R.color.CAM_X0601);
            this.f20000i.x();
            this.f20000i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f20000i.G(R.dimen.tbfontsize33);
            this.f20000i.A(R.color.CAM_X0110);
            this.f20000i.B(this.q);
            this.f19999h.setNextPage(this.f20000i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f19999h.setOnSrollToBottomListener(this.p);
            this.f19998g.s(this);
            this.f19998g.r(this);
            this.f19996e.k(this);
            this.f19996e.i(this);
            this.f20002k.setOnClickListener(this);
            this.f20001j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f19998g.m()) {
            c.a.r0.m2.g.b bVar = this.f19998g;
            if (bVar.f20038g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        c.a.r0.m2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f19996e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f19996e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f20000i.J();
            this.f20000i.Q();
            this.f20000i.C(this.f19999h.getContext().getString(R.string.list_loading));
            this.f20000i.L(l.f(this.f19999h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f20000i.D(this.f19999h.getContext().getString(R.string.interested_forum_list_no_more), l.f(this.f19999h.getContext(), R.dimen.tbds178));
            this.f20000i.G(R.dimen.tbds36);
            this.f20000i.A(R.color.CAM_X0109);
            this.f20000i.f();
            this.f20000i.B(null);
            this.f20000i.L(l.f(this.f19999h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.f20002k) {
                List<n> c2 = this.f19996e.c();
                try {
                    this.f19998g.g(c2);
                    c.a.r0.m2.e.a.a(2, 1, this.f19997f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f20001j || o.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.f20001j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.f20001j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // c.a.r0.m2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            c.a.r0.m2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f20000i;
                if (pbListView != null) {
                    pbListView.C(this.f19999h.getContext().getString(R.string.pb_load_more));
                    this.f20000i.f();
                    return;
                }
                return;
            }
            this.f19997f.onError(str);
        }
    }
}
