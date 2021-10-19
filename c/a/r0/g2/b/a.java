package c.a.r0.g2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import c.a.q0.b.d;
import c.a.r0.g2.c.g;
import c.a.r0.g2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f17782e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.g2.g.b f17783f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f17784g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f17785h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f17786i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f17787j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.g2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* renamed from: c.a.r0.g2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0870a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17788e;

        public C0870a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17788e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17788e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17789e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17789e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17789e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.g2.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar, Integer.valueOf(i2)};
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
        this.p = new C0870a(this);
        this.q = new b(this);
        this.f17782e = interestedForumFragment;
        this.f17784g = bdRecyclerView;
        this.f17783f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f17787j = tBSpecificationBtn2;
        this.o = i2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f17784g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f17784g.getResources().getString(R.string.try_to_select));
            }
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            if (!z) {
                this.f17787j.setText(this.l.getString(R.string.select_all));
                this.f17787j.setConfig(bVar);
                return;
            }
            this.f17787j.setText(this.l.getString(R.string.unselect_all));
            bVar.s(R.color.CAM_X0109);
            this.f17787j.setConfig(bVar);
        }
    }

    @Override // c.a.r0.g2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f17782e.getActivity().finish();
            } else if (d.o()) {
                this.f17782e.getActivity().setResult(-1);
                this.f17782e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.r0.g2.g.b.d
    public void c(c.a.r0.g2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.r0.g2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17813a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17813a.addAll(cVar.f17813a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17813a)) {
                if (this.f17784g.getVisibility() == 8) {
                    this.f17784g.setVisibility(0);
                }
                this.f17785h.addData(cVar.f17813a);
                this.f17782e.onDataRes();
            }
            if (this.f17783f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.r0.g2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.r0.g2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f17801a)) {
                    for (g gVar : aVar.f17801a) {
                        if (gVar != null && gVar.f17828b && gVar.f17827a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f17827a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<c.a.r0.g2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f17783f.q(list);
            this.f17783f.l();
            if (this.m) {
                return;
            }
            this.f17783f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17785h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f17784g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f17784g.setAdapter(this.f17785h);
            PbListView pbListView = new PbListView(this.f17784g.getContext());
            this.f17786i = pbListView;
            pbListView.a();
            this.f17786i.o(R.color.CAM_X0205);
            this.f17786i.v();
            this.f17786i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17786i.E(R.dimen.tbfontsize33);
            this.f17786i.y(R.color.CAM_X0110);
            this.f17786i.z(this.q);
            this.f17784g.setNextPage(this.f17786i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17784g.setOnSrollToBottomListener(this.p);
            this.f17783f.s(this);
            this.f17783f.r(this);
            this.f17785h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f17783f.m()) {
            c.a.r0.g2.g.b bVar = this.f17783f;
            if (bVar.f17839g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17785h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17786i.H();
            this.f17786i.O();
            this.f17786i.A(this.f17784g.getContext().getString(R.string.list_loading));
            this.f17786i.J(l.g(this.f17784g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17786i.B(this.f17784g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f17784g.getContext(), R.dimen.tbds178));
            this.f17786i.E(R.dimen.tbds36);
            this.f17786i.y(R.color.CAM_X0109);
            this.f17786i.f();
            this.f17786i.z(null);
            this.f17786i.J(l.g(this.f17784g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.r0.g2.c.a> interestedForumData = this.f17785h.getInterestedForumData();
            try {
                this.f17783f.f(interestedForumData);
                c.a.r0.g2.e.a.a(2, 1, this.f17782e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.r0.g2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.r0.g2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f17813a)) {
                PbListView pbListView = this.f17786i;
                if (pbListView != null) {
                    pbListView.A(this.f17784g.getContext().getString(R.string.pb_load_more));
                    this.f17786i.f();
                    return;
                }
                return;
            }
            this.f17782e.onError(str);
        }
    }
}
