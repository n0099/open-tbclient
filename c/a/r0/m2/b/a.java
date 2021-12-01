package c.a.r0.m2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.q0.b.d;
import c.a.r0.m2.c.g;
import c.a.r0.m2.g.b;
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
/* loaded from: classes6.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f19987e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.m2.g.b f19988f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f19989g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f19990h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f19991i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f19992j;

    /* renamed from: k  reason: collision with root package name */
    public final TBSpecificationBtn f19993k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.m2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* renamed from: c.a.r0.m2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1189a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19994e;

        public C1189a(a aVar) {
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
            this.f19994e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19994e.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19995e;

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
            this.f19995e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19995e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.m2.g.b bVar, int i2) {
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
        this.p = new C1189a(this);
        this.q = new b(this);
        this.f19987e = interestedForumFragment;
        this.f19989g = bdRecyclerView;
        this.f19988f = bVar;
        this.l = tbPageContext;
        this.f19993k = tBSpecificationBtn;
        this.f19992j = tBSpecificationBtn2;
        this.o = i2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.f19993k.isEnabled()) {
                this.f19993k.setEnabled(true);
                this.f19993k.setText(this.f19989g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.f19993k.setEnabled(false);
                this.f19993k.setText(this.f19989g.getResources().getString(R.string.try_to_select));
            }
            c.a.q0.s.g0.n.b bVar = new c.a.q0.s.g0.n.b();
            if (!z) {
                this.f19992j.setText(this.l.getString(R.string.select_all));
                this.f19992j.setConfig(bVar);
                return;
            }
            this.f19992j.setText(this.l.getString(R.string.unselect_all));
            bVar.s(R.color.CAM_X0109);
            this.f19992j.setConfig(bVar);
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
                this.f19987e.getActivity().finish();
            } else if (d.p()) {
                this.f19987e.getActivity().setResult(-1);
                this.f19987e.getActivity().finish();
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
                if (this.f19989g.getVisibility() == 8) {
                    this.f19989g.setVisibility(0);
                }
                this.f19990h.addData(cVar.a);
                this.f19987e.onDataRes();
            }
            if (this.f19988f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.r0.m2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.r0.m2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.a)) {
                    for (g gVar : aVar.a) {
                        if (gVar != null && gVar.f20031b && gVar.a != null) {
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

    public void f(List<c.a.r0.m2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f19988f.q(list);
            this.f19988f.l();
            if (this.m) {
                return;
            }
            this.f19988f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19990h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f19989g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f19989g.setAdapter(this.f19990h);
            PbListView pbListView = new PbListView(this.f19989g.getContext());
            this.f19991i = pbListView;
            pbListView.a();
            this.f19991i.p(R.color.CAM_X0205);
            this.f19991i.x();
            this.f19991i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f19991i.G(R.dimen.tbfontsize33);
            this.f19991i.A(R.color.CAM_X0110);
            this.f19991i.B(this.q);
            this.f19989g.setNextPage(this.f19991i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19989g.setOnSrollToBottomListener(this.p);
            this.f19988f.s(this);
            this.f19988f.r(this);
            this.f19990h.setSelectChangedListener(this);
            this.f19993k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f19988f.m()) {
            c.a.r0.m2.g.b bVar = this.f19988f;
            if (bVar.f20038g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f19990h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f19991i.J();
            this.f19991i.Q();
            this.f19991i.C(this.f19989g.getContext().getString(R.string.list_loading));
            this.f19991i.L(l.f(this.f19989g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f19991i.D(this.f19989g.getContext().getString(R.string.interested_forum_list_no_more), l.f(this.f19989g.getContext(), R.dimen.tbds178));
            this.f19991i.G(R.dimen.tbds36);
            this.f19991i.A(R.color.CAM_X0109);
            this.f19991i.f();
            this.f19991i.B(null);
            this.f19991i.L(l.f(this.f19989g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.f19993k) {
            List<c.a.r0.m2.c.a> interestedForumData = this.f19990h.getInterestedForumData();
            try {
                this.f19988f.f(interestedForumData);
                c.a.r0.m2.e.a.a(2, 1, this.f19987e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.r0.m2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.r0.m2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f19991i;
                if (pbListView != null) {
                    pbListView.C(this.f19989g.getContext().getString(R.string.pb_load_more));
                    this.f19991i.f();
                    return;
                }
                return;
            }
            this.f19987e.onError(str);
        }
    }
}
