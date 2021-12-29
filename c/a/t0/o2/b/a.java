package c.a.t0.o2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.s0.b.d;
import c.a.t0.o2.c.g;
import c.a.t0.o2.g.b;
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
/* loaded from: classes7.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f21379e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.t0.o2.g.b f21380f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f21381g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f21382h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21383i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f21384j;

    /* renamed from: k  reason: collision with root package name */
    public final TBSpecificationBtn f21385k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.t0.o2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* renamed from: c.a.t0.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1288a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21386e;

        public C1288a(a aVar) {
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
            this.f21386e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21386e.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21387e;

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
            this.f21387e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21387e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.t0.o2.g.b bVar, int i2) {
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
        this.p = new C1288a(this);
        this.q = new b(this);
        this.f21379e = interestedForumFragment;
        this.f21381g = bdRecyclerView;
        this.f21380f = bVar;
        this.l = tbPageContext;
        this.f21385k = tBSpecificationBtn;
        this.f21384j = tBSpecificationBtn2;
        this.o = i2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.f21385k.isEnabled()) {
                this.f21385k.setEnabled(true);
                this.f21385k.setText(this.f21381g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.f21385k.setEnabled(false);
                this.f21385k.setText(this.f21381g.getResources().getString(R.string.try_to_select));
            }
            c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
            if (!z) {
                this.f21384j.setText(this.l.getString(R.string.select_all));
                this.f21384j.setConfig(bVar);
                return;
            }
            this.f21384j.setText(this.l.getString(R.string.unselect_all));
            bVar.s(R.color.CAM_X0109);
            this.f21384j.setConfig(bVar);
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
                this.f21379e.getActivity().finish();
            } else if (d.q()) {
                this.f21379e.getActivity().setResult(-1);
                this.f21379e.getActivity().finish();
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
                if (this.f21381g.getVisibility() == 8) {
                    this.f21381g.setVisibility(0);
                }
                this.f21382h.addData(cVar.a);
                this.f21379e.onDataRes();
            }
            if (this.f21380f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.t0.o2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.t0.o2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.a)) {
                    for (g gVar : aVar.a) {
                        if (gVar != null && gVar.f21423b && gVar.a != null) {
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

    public void f(List<c.a.t0.o2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f21380f.q(list);
            this.f21380f.l();
            if (this.m) {
                return;
            }
            this.f21380f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21382h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f21381g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f21381g.setAdapter(this.f21382h);
            PbListView pbListView = new PbListView(this.f21381g.getContext());
            this.f21383i = pbListView;
            pbListView.a();
            this.f21383i.p(R.color.CAM_X0205);
            this.f21383i.y();
            this.f21383i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f21383i.H(R.dimen.tbfontsize33);
            this.f21383i.B(R.color.CAM_X0110);
            this.f21383i.C(this.q);
            this.f21381g.setNextPage(this.f21383i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21381g.setOnSrollToBottomListener(this.p);
            this.f21380f.s(this);
            this.f21380f.r(this);
            this.f21382h.setSelectChangedListener(this);
            this.f21385k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f21380f.m()) {
            c.a.t0.o2.g.b bVar = this.f21380f;
            if (bVar.f21430g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21382h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21383i.K();
            this.f21383i.R();
            this.f21383i.D(this.f21381g.getContext().getString(R.string.list_loading));
            this.f21383i.M(n.f(this.f21381g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21383i.E(this.f21381g.getContext().getString(R.string.interested_forum_list_no_more), n.f(this.f21381g.getContext(), R.dimen.tbds178));
            this.f21383i.H(R.dimen.tbds36);
            this.f21383i.B(R.color.CAM_X0109);
            this.f21383i.f();
            this.f21383i.C(null);
            this.f21383i.M(n.f(this.f21381g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.f21385k) {
            List<c.a.t0.o2.c.a> interestedForumData = this.f21382h.getInterestedForumData();
            try {
                this.f21380f.f(interestedForumData);
                c.a.t0.o2.e.a.a(2, 1, this.f21379e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.t0.o2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.t0.o2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f21383i;
                if (pbListView != null) {
                    pbListView.D(this.f21381g.getContext().getString(R.string.pb_load_more));
                    this.f21383i.f();
                    return;
                }
                return;
            }
            this.f21379e.onError(str);
        }
    }
}
