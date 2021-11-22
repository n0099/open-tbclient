package b.a.r0.g2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.q0.b.d;
import b.a.q0.c1.o;
import b.a.r0.g2.g.b;
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
/* loaded from: classes4.dex */
public class b implements b.d, b.a.r0.g2.f.c, View.OnClickListener, b.c, b.a.r0.g2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.g2.a.h.a f18266e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseInterestedForumFragment f18267f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a.r0.g2.g.b f18268g;

    /* renamed from: h  reason: collision with root package name */
    public final BdTypeRecyclerView f18269h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f18270i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public b.a.r0.g2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18271e;

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
            this.f18271e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18271e.j();
            }
        }
    }

    /* renamed from: b.a.r0.g2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0933b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18272e;

        public View$OnClickListenerC0933b(b bVar) {
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
            this.f18272e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18272e.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b.a.r0.g2.g.b bVar, int i2) {
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
        this.q = new View$OnClickListenerC0933b(this);
        this.f18267f = baseInterestedForumFragment;
        this.f18269h = bdTypeRecyclerView;
        this.f18268g = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        this.o = i2;
        this.f18266e = new b.a.r0.g2.a.h.a(tbPageContext.getPageActivity(), this.f18269h);
        h();
        i();
    }

    @Override // b.a.r0.g2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f18266e.e()) {
                this.k.setEnabled(true);
                this.k.setText(this.f18269h.getResources().getString(R.string.start_the_trip));
            } else {
                this.k.setEnabled(false);
                this.k.setText(this.f18269h.getResources().getString(R.string.interested_forum_attention_hint));
            }
            b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
            this.j.setTextSize(R.dimen.T_X06);
            if (!this.f18266e.f()) {
                this.j.setText(this.l.getString(R.string.interested_forum_select_all));
                cVar.p(R.color.CAM_X0304);
                this.j.setConfig(cVar);
                return;
            }
            this.j.setText(this.l.getString(R.string.interested_forum_unselect_all));
            cVar.r(R.color.CAM_X0105);
            this.j.setConfig(cVar);
        }
    }

    @Override // b.a.r0.g2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f18267f.getActivity().finish();
            } else if (d.o()) {
                this.f18267f.getActivity().setResult(-1);
                this.f18267f.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // b.a.r0.g2.g.b.d
    public void c(b.a.r0.g2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            b.a.r0.g2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f18288a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f18288a.addAll(cVar.f18288a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f18288a)) {
                if (this.f18269h.getVisibility() == 8) {
                    this.f18269h.setVisibility(0);
                }
                this.f18266e.j(cVar.f18288a);
                this.f18267f.onDataRes();
            }
            if (this.f18268g.m()) {
                return;
            }
            n();
        }
    }

    @Override // b.a.r0.g2.f.b
    public void d(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            b.a.r0.g2.e.a.b(str);
            this.f18266e.a(i2, this.n, i3);
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
                if (nVar instanceof b.a.r0.g2.c.d) {
                    b.a.r0.g2.c.d dVar = (b.a.r0.g2.c.d) nVar;
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

    public void g(List<b.a.r0.g2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f18268g.q(list);
            this.f18268g.l();
            if (this.m) {
                return;
            }
            this.f18268g.e();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f18269h.getContext());
            this.f18270i = pbListView;
            pbListView.a();
            this.f18270i.p(R.color.CAM_X0601);
            this.f18270i.x();
            this.f18270i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f18270i.G(R.dimen.tbfontsize33);
            this.f18270i.A(R.color.CAM_X0110);
            this.f18270i.B(this.q);
            this.f18269h.setNextPage(this.f18270i);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f18269h.setOnSrollToBottomListener(this.p);
            this.f18268g.s(this);
            this.f18268g.r(this);
            this.f18266e.k(this);
            this.f18266e.i(this);
            this.k.setOnClickListener(this);
            this.j.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18268g.m()) {
            b.a.r0.g2.g.b bVar = this.f18268g;
            if (bVar.f18313g) {
                return;
            }
            bVar.l();
            m();
        }
    }

    public void k(int i2) {
        b.a.r0.g2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (aVar = this.f18266e) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f18266e.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f18270i.J();
            this.f18270i.Q();
            this.f18270i.C(this.f18269h.getContext().getString(R.string.list_loading));
            this.f18270i.L(l.g(this.f18269h.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f18270i.D(this.f18269h.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f18269h.getContext(), R.dimen.tbds178));
            this.f18270i.G(R.dimen.tbds36);
            this.f18270i.A(R.color.CAM_X0109);
            this.f18270i.f();
            this.f18270i.B(null);
            this.f18270i.L(l.g(this.f18269h.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.k) {
                List<n> c2 = this.f18266e.c();
                try {
                    this.f18268g.g(c2);
                    b.a.r0.g2.e.a.a(2, 1, this.f18267f.getScene(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.j || o.a()) {
            } else {
                if (this.l.getString(R.string.interested_forum_select_all).equals(this.j.getText())) {
                    l(true);
                } else if (this.l.getString(R.string.interested_forum_unselect_all).equals(this.j.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // b.a.r0.g2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            b.a.r0.g2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f18288a)) {
                PbListView pbListView = this.f18270i;
                if (pbListView != null) {
                    pbListView.C(this.f18269h.getContext().getString(R.string.pb_load_more));
                    this.f18270i.f();
                    return;
                }
                return;
            }
            this.f18267f.onError(str);
        }
    }
}
