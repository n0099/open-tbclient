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
    public final InterestedForumFragment f17615e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.f2.g.b f17616f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f17617g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f17618h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f17619i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f17620j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public c.a.r0.f2.c.c n;
    public BdListView.p o;
    public View.OnClickListener p;

    /* renamed from: c.a.r0.f2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0861a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17621e;

        public C0861a(a aVar) {
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
            this.f17621e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17621e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17622e;

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
            this.f17622e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17622e.i();
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
        this.o = new C0861a(this);
        this.p = new b(this);
        this.f17615e = interestedForumFragment;
        this.f17617g = bdRecyclerView;
        this.f17616f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f17620j = tBSpecificationBtn2;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f17617g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f17617g.getResources().getString(R.string.try_to_select));
            }
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            if (!z) {
                this.f17620j.setText(this.l.getString(R.string.select_all));
                this.f17620j.setConfig(bVar);
                return;
            }
            this.f17620j.setText(this.l.getString(R.string.unselect_all));
            bVar.r(R.color.CAM_X0109);
            this.f17620j.setConfig(bVar);
        }
    }

    @Override // c.a.r0.f2.g.b.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.o()) {
                this.f17615e.getActivity().setResult(-1);
                this.f17615e.getActivity().finish();
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
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f17646a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f17646a.addAll(cVar.f17646a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f17646a)) {
                if (this.f17617g.getVisibility() == 8) {
                    this.f17617g.setVisibility(0);
                }
                this.f17618h.addData(cVar.f17646a);
                this.f17615e.onDataRes();
            }
            if (this.f17616f.m()) {
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
                if (aVar != null && !ListUtils.isEmpty(aVar.f17634a)) {
                    for (g gVar : aVar.f17634a) {
                        if (gVar != null && gVar.f17661b && gVar.f17660a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f17660a.forum_id);
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
            this.f17616f.q(list);
            this.f17616f.l();
            if (this.m) {
                return;
            }
            this.f17616f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17618h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f17617g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f17617g.setAdapter(this.f17618h);
            PbListView pbListView = new PbListView(this.f17617g.getContext());
            this.f17619i = pbListView;
            pbListView.a();
            this.f17619i.o(R.color.CAM_X0205);
            this.f17619i.v();
            this.f17619i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17619i.E(R.dimen.tbfontsize33);
            this.f17619i.y(R.color.CAM_X0110);
            this.f17619i.z(this.p);
            this.f17617g.setNextPage(this.f17619i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17617g.setOnSrollToBottomListener(this.o);
            this.f17616f.s(this);
            this.f17616f.r(this);
            this.f17618h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f17616f.m()) {
            c.a.r0.f2.g.b bVar = this.f17616f;
            if (bVar.f17672g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17618h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17619i.H();
            this.f17619i.O();
            this.f17619i.A(this.f17617g.getContext().getString(R.string.list_loading));
            this.f17619i.J(l.g(this.f17617g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f17619i.B(this.f17617g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f17617g.getContext(), R.dimen.tbds178));
            this.f17619i.E(R.dimen.tbds36);
            this.f17619i.y(R.color.CAM_X0109);
            this.f17619i.f();
            this.f17619i.z(null);
            this.f17619i.J(l.g(this.f17617g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<c.a.r0.f2.c.a> interestedForumData = this.f17618h.getInterestedForumData();
            try {
                this.f17616f.f(interestedForumData);
                c.a.r0.f2.e.a.a(2, 1, this.f17615e.getScene(), "", e(interestedForumData));
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
            if (cVar != null && !ListUtils.isEmpty(cVar.f17646a)) {
                PbListView pbListView = this.f17619i;
                if (pbListView != null) {
                    pbListView.A(this.f17617g.getContext().getString(R.string.pb_load_more));
                    this.f17619i.f();
                    return;
                }
                return;
            }
            this.f17615e.onError(str);
        }
    }
}
