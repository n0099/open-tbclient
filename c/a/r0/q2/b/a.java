package c.a.r0.q2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.r0.q2.c.g;
import c.a.r0.q2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f21047e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.q2.g.b f21048f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f21049g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f21050h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21051i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f21052j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.q2.c.c n;
    public int o;
    public final boolean p;
    public BdListView.p q;
    public View.OnClickListener r;

    /* renamed from: c.a.r0.q2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1322a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21053e;

        public C1322a(a aVar) {
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
            this.f21053e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21053e.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21054e;

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
            this.f21054e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21054e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.q2.g.b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar, Integer.valueOf(i2), Boolean.valueOf(z)};
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
        this.q = new C1322a(this);
        this.r = new b(this);
        this.f21047e = interestedForumFragment;
        this.f21049g = bdRecyclerView;
        this.f21048f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f21052j = tBSpecificationBtn2;
        this.o = i2;
        this.p = z;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f21049g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f21049g.getResources().getString(R.string.try_to_select));
            }
            c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
            if (!z) {
                this.f21052j.setText(this.l.getString(R.string.select_all));
                this.f21052j.setConfig(bVar);
                return;
            }
            this.f21052j.setText(this.l.getString(R.string.unselect_all));
            bVar.t(R.color.CAM_X0109);
            this.f21052j.setConfig(bVar);
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
                this.f21047e.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.f21047e.getActivity().setResult(-1);
                this.f21047e.getActivity().finish();
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
                if (this.f21049g.getVisibility() == 8) {
                    this.f21049g.setVisibility(0);
                }
                this.f21050h.addData(cVar.a);
                this.f21047e.onDataRes();
            }
            if (this.f21048f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.r0.q2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.r0.q2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.a)) {
                    for (g gVar : aVar.a) {
                        if (gVar != null && gVar.f21088b && gVar.a != null) {
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

    public void f(List<c.a.r0.q2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f21048f.q(list);
            this.f21048f.l();
            if (this.m || this.p) {
                return;
            }
            this.f21048f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21050h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f21049g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f21049g.setAdapter(this.f21050h);
            PbListView pbListView = new PbListView(this.f21049g.getContext());
            this.f21051i = pbListView;
            pbListView.a();
            this.f21051i.p(R.color.CAM_X0205);
            this.f21051i.y();
            this.f21051i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f21051i.H(R.dimen.tbfontsize33);
            this.f21051i.B(R.color.CAM_X0110);
            this.f21051i.C(this.r);
            this.f21049g.setNextPage(this.f21051i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21049g.setOnSrollToBottomListener(this.q);
            this.f21048f.s(this);
            this.f21048f.r(this);
            this.f21050h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f21048f.m()) {
            c.a.r0.q2.g.b bVar = this.f21048f;
            if (bVar.f21095g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21050h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21051i.K();
            this.f21051i.R();
            this.f21051i.D(this.f21049g.getContext().getString(R.string.list_loading));
            this.f21051i.M(n.f(this.f21049g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21051i.E(this.f21049g.getContext().getString(R.string.interested_forum_list_no_more), n.f(this.f21049g.getContext(), R.dimen.tbds178));
            this.f21051i.H(R.dimen.tbds36);
            this.f21051i.B(R.color.CAM_X0109);
            this.f21051i.f();
            this.f21051i.C(null);
            this.f21051i.M(n.f(this.f21049g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.r0.q2.c.a> interestedForumData = this.f21050h.getInterestedForumData();
            try {
                this.f21048f.f(interestedForumData);
                c.a.r0.q2.e.a.a(2, 1, this.f21047e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.r0.q2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.r0.q2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f21051i;
                if (pbListView != null) {
                    pbListView.D(this.f21049g.getContext().getString(R.string.pb_load_more));
                    this.f21051i.f();
                    return;
                }
                return;
            }
            this.f21047e.onError(str);
        }
    }
}
