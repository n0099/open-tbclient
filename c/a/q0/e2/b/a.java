package c.a.q0.e2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import c.a.p0.b.d;
import c.a.q0.e2.c.g;
import c.a.q0.e2.g.b;
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
    public final InterestedForumFragment f16991e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.q0.e2.g.b f16992f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f16993g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f16994h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f16995i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f16996j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.q0.e2.c.c n;
    public BdListView.p o;
    public View.OnClickListener p;

    /* renamed from: c.a.q0.e2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0823a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16997e;

        public C0823a(a aVar) {
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
            this.f16997e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16997e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16998e;

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
            this.f16998e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16998e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, c.a.q0.e2.g.b bVar) {
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
        this.o = new C0823a(this);
        this.p = new b(this);
        this.f16991e = interestedForumFragment;
        this.f16993g = bdRecyclerView;
        this.f16992f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f16996j = tBSpecificationBtn2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f16993g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f16993g.getResources().getString(R.string.try_to_select));
            }
            c.a.p0.s.f0.n.b bVar = new c.a.p0.s.f0.n.b();
            if (!z) {
                this.f16996j.setText(this.l.getString(R.string.select_all));
                this.f16996j.setConfig(bVar);
                return;
            }
            this.f16996j.setText(this.l.getString(R.string.unselect_all));
            bVar.r(R.color.CAM_X0109);
            this.f16996j.setConfig(bVar);
        }
    }

    @Override // c.a.q0.e2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.x()) {
                this.f16991e.getActivity().setResult(-1);
                this.f16991e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.q0.e2.g.b.d
    public void c(c.a.q0.e2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.q0.e2.c.c cVar2 = this.n;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17022a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17022a.addAll(cVar.f17022a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17022a)) {
                if (this.f16993g.getVisibility() == 8) {
                    this.f16993g.setVisibility(0);
                }
                this.f16994h.addData(cVar.f17022a);
                this.f16991e.onDataRes();
            }
            if (this.f16992f.m()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.q0.e2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.q0.e2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f17010a)) {
                    for (g gVar : aVar.f17010a) {
                        if (gVar != null && gVar.f17037b && gVar.f17036a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f17036a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<c.a.q0.e2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f16992f.q(list);
            this.f16992f.l();
            if (this.m) {
                return;
            }
            this.f16992f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16994h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f16993g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f16993g.setAdapter(this.f16994h);
            PbListView pbListView = new PbListView(this.f16993g.getContext());
            this.f16995i = pbListView;
            pbListView.a();
            this.f16995i.o(R.color.CAM_X0205);
            this.f16995i.v();
            this.f16995i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f16995i.E(R.dimen.tbfontsize33);
            this.f16995i.y(R.color.CAM_X0110);
            this.f16995i.z(this.p);
            this.f16993g.setNextPage(this.f16995i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16993g.setOnSrollToBottomListener(this.o);
            this.f16992f.s(this);
            this.f16992f.r(this);
            this.f16994h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f16992f.m()) {
            c.a.q0.e2.g.b bVar = this.f16992f;
            if (bVar.f17048g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16994h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16995i.H();
            this.f16995i.O();
            this.f16995i.A(this.f16993g.getContext().getString(R.string.list_loading));
            this.f16995i.J(l.g(this.f16993g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16995i.B(this.f16993g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f16993g.getContext(), R.dimen.tbds178));
            this.f16995i.E(R.dimen.tbds36);
            this.f16995i.y(R.color.CAM_X0109);
            this.f16995i.f();
            this.f16995i.z(null);
            this.f16995i.J(l.g(this.f16993g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.q0.e2.c.a> interestedForumData = this.f16994h.getInterestedForumData();
            try {
                this.f16992f.f(interestedForumData);
                c.a.q0.e2.e.a.a(2, 1, this.f16991e.getScene(), "", e(interestedForumData));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.q0.e2.g.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c.a.q0.e2.c.c cVar = this.n;
            if (cVar != null && !ListUtils.isEmpty(cVar.f17022a)) {
                PbListView pbListView = this.f16995i;
                if (pbListView != null) {
                    pbListView.A(this.f16993g.getContext().getString(R.string.pb_load_more));
                    this.f16995i.f();
                    return;
                }
                return;
            }
            this.f16991e.onError(str);
        }
    }
}
