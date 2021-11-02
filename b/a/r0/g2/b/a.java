package b.a.r0.g2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.a.e.e.p.l;
import b.a.q0.b.d;
import b.a.r0.g2.c.g;
import b.a.r0.g2.g.b;
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
/* loaded from: classes4.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f16745e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.r0.g2.g.b f16746f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f16747g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f16748h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f16749i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public b.a.r0.g2.c.c n;
    public int o;
    public BdListView.p p;
    public View.OnClickListener q;

    /* renamed from: b.a.r0.g2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0865a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16750e;

        public C0865a(a aVar) {
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
            this.f16750e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16750e.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16751e;

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
            this.f16751e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16751e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b.a.r0.g2.g.b bVar, int i2) {
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
        this.p = new C0865a(this);
        this.q = new b(this);
        this.f16745e = interestedForumFragment;
        this.f16747g = bdRecyclerView;
        this.f16746f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
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
                this.k.setText(this.f16747g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f16747g.getResources().getString(R.string.try_to_select));
            }
            b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
            if (!z) {
                this.j.setText(this.l.getString(R.string.select_all));
                this.j.setConfig(bVar);
                return;
            }
            this.j.setText(this.l.getString(R.string.unselect_all));
            bVar.s(R.color.CAM_X0109);
            this.j.setConfig(bVar);
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
                this.f16745e.getActivity().finish();
            } else if (d.o()) {
                this.f16745e.getActivity().setResult(-1);
                this.f16745e.getActivity().finish();
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
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f16774a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f16774a.addAll(cVar.f16774a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f16774a)) {
                if (this.f16747g.getVisibility() == 8) {
                    this.f16747g.setVisibility(0);
                }
                this.f16748h.addData(cVar.f16774a);
                this.f16745e.onDataRes();
            }
            if (this.f16746f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<b.a.r0.g2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.a.r0.g2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f16762a)) {
                    for (g gVar : aVar.f16762a) {
                        if (gVar != null && gVar.f16788b && gVar.f16787a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f16787a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<b.a.r0.g2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f16746f.q(list);
            this.f16746f.l();
            if (this.m) {
                return;
            }
            this.f16746f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16748h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f16747g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f16747g.setAdapter(this.f16748h);
            PbListView pbListView = new PbListView(this.f16747g.getContext());
            this.f16749i = pbListView;
            pbListView.a();
            this.f16749i.p(R.color.CAM_X0205);
            this.f16749i.x();
            this.f16749i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f16749i.G(R.dimen.tbfontsize33);
            this.f16749i.A(R.color.CAM_X0110);
            this.f16749i.B(this.q);
            this.f16747g.setNextPage(this.f16749i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16747g.setOnSrollToBottomListener(this.p);
            this.f16746f.s(this);
            this.f16746f.r(this);
            this.f16748h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f16746f.m()) {
            b.a.r0.g2.g.b bVar = this.f16746f;
            if (bVar.f16799g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16748h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16749i.J();
            this.f16749i.Q();
            this.f16749i.C(this.f16747g.getContext().getString(R.string.list_loading));
            this.f16749i.L(l.g(this.f16747g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16749i.D(this.f16747g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f16747g.getContext(), R.dimen.tbds178));
            this.f16749i.G(R.dimen.tbds36);
            this.f16749i.A(R.color.CAM_X0109);
            this.f16749i.f();
            this.f16749i.B(null);
            this.f16749i.L(l.g(this.f16747g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<b.a.r0.g2.c.a> interestedForumData = this.f16748h.getInterestedForumData();
            try {
                this.f16746f.f(interestedForumData);
                b.a.r0.g2.e.a.a(2, 1, this.f16745e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.a.r0.g2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            b.a.r0.g2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f16774a)) {
                PbListView pbListView = this.f16749i;
                if (pbListView != null) {
                    pbListView.C(this.f16747g.getContext().getString(R.string.pb_load_more));
                    this.f16749i.f();
                    return;
                }
                return;
            }
            this.f16745e.onError(str);
        }
    }
}
