package c.a.p0.e2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import c.a.o0.b.d;
import c.a.p0.e2.c.c;
import c.a.p0.e2.e.b;
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
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f16679e;

    /* renamed from: f  reason: collision with root package name */
    public final b f16680f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f16681g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f16682h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f16683i;

    /* renamed from: j  reason: collision with root package name */
    public final TBSpecificationBtn f16684j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public BdListView.p n;

    /* renamed from: c.a.p0.e2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0812a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16685e;

        public C0812a(a aVar) {
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
            this.f16685e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16685e.f16680f.k()) {
                this.f16685e.f16680f.j();
                this.f16685e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
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
        this.n = new C0812a(this);
        this.f16679e = interestedForumFragment;
        this.f16681g = bdRecyclerView;
        this.f16680f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.f16684j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // c.a.p0.e2.e.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.x()) {
                this.f16679e.getActivity().setResult(-1);
                this.f16679e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // c.a.p0.e2.e.b.d
    public void b(c cVar) {
        List<c.a.p0.e2.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (list = cVar.f16694a) != null && !ListUtils.isEmpty(list)) {
                if (this.f16681g.getVisibility() == 8) {
                    this.f16681g.setVisibility(0);
                }
                this.f16682h.addData(cVar.f16694a);
                this.f16679e.onDataRes();
            }
            if (this.f16680f.k()) {
                return;
            }
            j();
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f16681g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f16681g.getResources().getString(R.string.try_to_select));
            }
            c.a.o0.s.f0.n.b bVar = new c.a.o0.s.f0.n.b();
            if (!z) {
                this.f16684j.setText(this.l.getString(R.string.select_all));
                this.f16684j.setConfig(bVar);
                return;
            }
            this.f16684j.setText(this.l.getString(R.string.unselect_all));
            bVar.r(R.color.CAM_X0109);
            this.f16684j.setConfig(bVar);
        }
    }

    public void e(List<c.a.p0.e2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f16680f.o(list);
            this.f16680f.j();
            this.f16680f.e();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16682h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f16681g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f16681g.setAdapter(this.f16682h);
            PbListView pbListView = new PbListView(this.f16681g.getContext());
            this.f16683i = pbListView;
            pbListView.a();
            this.f16683i.o(R.color.CAM_X0205);
            this.f16683i.v();
            this.f16683i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f16683i.E(R.dimen.tbfontsize33);
            this.f16683i.y(R.color.CAM_X0110);
            this.f16681g.setNextPage(this.f16683i);
            i();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16681g.setOnSrollToBottomListener(this.n);
            this.f16680f.q(this);
            this.f16680f.p(this);
            this.f16682h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16682h.selectAll();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16683i.H();
            this.f16683i.O();
            this.f16683i.A(this.f16681g.getContext().getString(R.string.list_loading));
            this.f16683i.J(l.g(this.f16681g.getContext(), R.dimen.tbds217));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16683i.B(this.f16681g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f16681g.getContext(), R.dimen.tbds178));
            this.f16683i.E(R.dimen.tbds36);
            this.f16683i.y(R.color.CAM_X0109);
            this.f16683i.f();
            this.f16683i.J(l.g(this.f16681g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.k) {
            try {
                this.f16680f.f(this.f16682h.getInterestedForumData());
                c.a.p0.e2.d.a.a(2, 1, this.f16679e.getScene());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.p0.e2.e.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f16679e.onError(str);
        }
    }
}
