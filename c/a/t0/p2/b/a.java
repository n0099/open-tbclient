package c.a.t0.p2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.s0.b.d;
import c.a.t0.p2.c.g;
import c.a.t0.p2.g.b;
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
/* loaded from: classes8.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f21136e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.t0.p2.g.b f21137f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f21138g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f21139h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21140i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f21141j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.t0.p2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* renamed from: c.a.t0.p2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1316a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21142e;

        public C1316a(a aVar) {
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
            this.f21142e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21142e.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21143e;

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
            this.f21143e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21143e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.t0.p2.g.b bVar, int i2) {
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
        this.p = new C1316a(this);
        this.q = new b(this);
        this.f21136e = interestedForumFragment;
        this.f21138g = bdRecyclerView;
        this.f21137f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f21141j = tBSpecificationBtn2;
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
                this.k.setText(this.f21138g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f21138g.getResources().getString(R.string.try_to_select));
            }
            c.a.s0.s.k0.n.b bVar = new c.a.s0.s.k0.n.b();
            if (!z) {
                this.f21141j.setText(this.l.getString(R.string.select_all));
                this.f21141j.setConfig(bVar);
                return;
            }
            this.f21141j.setText(this.l.getString(R.string.unselect_all));
            bVar.s(R.color.CAM_X0109);
            this.f21141j.setConfig(bVar);
        }
    }

    @Override // c.a.t0.p2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (this.o == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.f21136e.getActivity().finish();
            } else if (d.o()) {
                this.f21136e.getActivity().setResult(-1);
                this.f21136e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.t0.p2.g.b.d
    public void c(c.a.t0.p2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.t0.p2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.a.addAll(cVar.a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                if (this.f21138g.getVisibility() == 8) {
                    this.f21138g.setVisibility(0);
                }
                this.f21139h.addData(cVar.a);
                this.f21136e.onDataRes();
            }
            if (this.f21137f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.t0.p2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.t0.p2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.a)) {
                    for (g gVar : aVar.a) {
                        if (gVar != null && gVar.f21177b && gVar.a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<c.a.t0.p2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f21137f.q(list);
            this.f21137f.l();
            if (this.m) {
                return;
            }
            this.f21137f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21139h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f21138g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f21138g.setAdapter(this.f21139h);
            PbListView pbListView = new PbListView(this.f21138g.getContext());
            this.f21140i = pbListView;
            pbListView.a();
            this.f21140i.p(R.color.CAM_X0205);
            this.f21140i.y();
            this.f21140i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f21140i.H(R.dimen.tbfontsize33);
            this.f21140i.B(R.color.CAM_X0110);
            this.f21140i.C(this.q);
            this.f21138g.setNextPage(this.f21140i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21138g.setOnSrollToBottomListener(this.p);
            this.f21137f.s(this);
            this.f21137f.r(this);
            this.f21139h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f21137f.m()) {
            c.a.t0.p2.g.b bVar = this.f21137f;
            if (bVar.f21184g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21139h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21140i.K();
            this.f21140i.R();
            this.f21140i.D(this.f21138g.getContext().getString(R.string.list_loading));
            this.f21140i.M(n.f(this.f21138g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21140i.E(this.f21138g.getContext().getString(R.string.interested_forum_list_no_more), n.f(this.f21138g.getContext(), R.dimen.tbds178));
            this.f21140i.H(R.dimen.tbds36);
            this.f21140i.B(R.color.CAM_X0109);
            this.f21140i.f();
            this.f21140i.C(null);
            this.f21140i.M(n.f(this.f21138g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.t0.p2.c.a> interestedForumData = this.f21139h.getInterestedForumData();
            try {
                this.f21137f.f(interestedForumData);
                c.a.t0.p2.e.a.a(2, 1, this.f21136e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.t0.p2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.t0.p2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f21140i;
                if (pbListView != null) {
                    pbListView.D(this.f21138g.getContext().getString(R.string.pb_load_more));
                    this.f21140i.f();
                    return;
                }
                return;
            }
            this.f21136e.onError(str);
        }
    }
}
