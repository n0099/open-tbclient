package c.a.r0.f2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import c.a.q0.b.d;
import c.a.r0.f2.c.g;
import c.a.r0.f2.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    public final InterestedForumFragment f17605e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.f2.g.b f17606f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f17607g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f17608h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f17609i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f17610j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.f2.c.c n;
    public BdListView.p o;
    public View.OnClickListener p;

    /* renamed from: c.a.r0.f2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0863a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17611e;

        public C0863a(a aVar) {
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
            this.f17611e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17611e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17612e;

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
            this.f17612e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17612e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.r0.f2.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.o = new C0863a(this);
        this.p = new b(this);
        this.f17605e = interestedForumFragment;
        this.f17607g = bdRecyclerView;
        this.f17606f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f17610j = tBSpecificationBtn2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f17607g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f17607g.getResources().getString(R.string.try_to_select));
            }
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            if (!z) {
                this.f17610j.setText(this.l.getString(R.string.select_all));
                this.f17610j.setConfig(bVar);
                return;
            }
            this.f17610j.setText(this.l.getString(R.string.unselect_all));
            bVar.r(R.color.CAM_X0109);
            this.f17610j.setConfig(bVar);
        }
    }

    @Override // c.a.r0.f2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.o()) {
                this.f17605e.getActivity().setResult(-1);
                this.f17605e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.r0.f2.g.b.d
    public void c(c.a.r0.f2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.r0.f2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17636a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17636a.addAll(cVar.f17636a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17636a)) {
                if (this.f17607g.getVisibility() == 8) {
                    this.f17607g.setVisibility(0);
                }
                this.f17608h.addData(cVar.f17636a);
                this.f17605e.onDataRes();
            }
            if (this.f17606f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.r0.f2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.r0.f2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f17624a)) {
                    for (g gVar : aVar.f17624a) {
                        if (gVar != null && gVar.f17651b && gVar.f17650a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f17650a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<c.a.r0.f2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f17606f.q(list);
            this.f17606f.l();
            if (this.m) {
                return;
            }
            this.f17606f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17608h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f17607g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f17607g.setAdapter(this.f17608h);
            PbListView pbListView = new PbListView(this.f17607g.getContext());
            this.f17609i = pbListView;
            pbListView.a();
            this.f17609i.o(R.color.CAM_X0205);
            this.f17609i.v();
            this.f17609i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17609i.E(R.dimen.tbfontsize33);
            this.f17609i.y(R.color.CAM_X0110);
            this.f17609i.z(this.p);
            this.f17607g.setNextPage(this.f17609i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17607g.setOnSrollToBottomListener(this.o);
            this.f17606f.s(this);
            this.f17606f.r(this);
            this.f17608h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f17606f.m()) {
            c.a.r0.f2.g.b bVar = this.f17606f;
            if (bVar.f17662g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17608h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17609i.H();
            this.f17609i.O();
            this.f17609i.A(this.f17607g.getContext().getString(R.string.list_loading));
            this.f17609i.J(l.g(this.f17607g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17609i.B(this.f17607g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f17607g.getContext(), R.dimen.tbds178));
            this.f17609i.E(R.dimen.tbds36);
            this.f17609i.y(R.color.CAM_X0109);
            this.f17609i.f();
            this.f17609i.z(null);
            this.f17609i.J(l.g(this.f17607g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.r0.f2.c.a> interestedForumData = this.f17608h.getInterestedForumData();
            try {
                this.f17606f.f(interestedForumData);
                c.a.r0.f2.e.a.a(2, 1, this.f17605e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.r0.f2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.r0.f2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f17636a)) {
                PbListView pbListView = this.f17609i;
                if (pbListView != null) {
                    pbListView.A(this.f17607g.getContext().getString(R.string.pb_load_more));
                    this.f17609i.f();
                    return;
                }
                return;
            }
            this.f17605e.onError(str);
        }
    }
}
