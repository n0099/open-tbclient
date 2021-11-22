package b.a.r0.g2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.a.e.f.p.l;
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
    public final InterestedForumFragment f18259e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.r0.g2.g.b f18260f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f18261g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f18262h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f18263i;
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
    public class C0932a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18264e;

        public C0932a(a aVar) {
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
            this.f18264e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18264e.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18265e;

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
            this.f18265e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18265e.i();
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
        this.p = new C0932a(this);
        this.q = new b(this);
        this.f18259e = interestedForumFragment;
        this.f18261g = bdRecyclerView;
        this.f18260f = bVar;
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
                this.k.setText(this.f18261g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f18261g.getResources().getString(R.string.try_to_select));
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
                this.f18259e.getActivity().finish();
            } else if (d.o()) {
                this.f18259e.getActivity().setResult(-1);
                this.f18259e.getActivity().finish();
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
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f18288a)) {
                this.n = cVar;
            } else if (cVar != null) {
                this.n.f18288a.addAll(cVar.f18288a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.f18288a)) {
                if (this.f18261g.getVisibility() == 8) {
                    this.f18261g.setVisibility(0);
                }
                this.f18262h.addData(cVar.f18288a);
                this.f18259e.onDataRes();
            }
            if (this.f18260f.m()) {
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
                if (aVar != null && !ListUtils.isEmpty(aVar.f18276a)) {
                    for (g gVar : aVar.f18276a) {
                        if (gVar != null && gVar.f18302b && gVar.f18301a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(gVar.f18301a.forum_id);
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
            this.f18260f.q(list);
            this.f18260f.l();
            if (this.m) {
                return;
            }
            this.f18260f.e();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18262h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f18261g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f18261g.setAdapter(this.f18262h);
            PbListView pbListView = new PbListView(this.f18261g.getContext());
            this.f18263i = pbListView;
            pbListView.a();
            this.f18263i.p(R.color.CAM_X0205);
            this.f18263i.x();
            this.f18263i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f18263i.G(R.dimen.tbfontsize33);
            this.f18263i.A(R.color.CAM_X0110);
            this.f18263i.B(this.q);
            this.f18261g.setNextPage(this.f18263i);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18261g.setOnSrollToBottomListener(this.p);
            this.f18260f.s(this);
            this.f18260f.r(this);
            this.f18262h.setSelectChangedListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f18260f.m()) {
            b.a.r0.g2.g.b bVar = this.f18260f;
            if (bVar.f18313g) {
                return;
            }
            bVar.l();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f18262h.selectAll();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f18263i.J();
            this.f18263i.Q();
            this.f18263i.C(this.f18261g.getContext().getString(R.string.list_loading));
            this.f18263i.L(l.g(this.f18261g.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18263i.D(this.f18261g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f18261g.getContext(), R.dimen.tbds178));
            this.f18263i.G(R.dimen.tbds36);
            this.f18263i.A(R.color.CAM_X0109);
            this.f18263i.f();
            this.f18263i.B(null);
            this.f18263i.L(l.g(this.f18261g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.k) {
            List<b.a.r0.g2.c.a> interestedForumData = this.f18262h.getInterestedForumData();
            try {
                this.f18260f.f(interestedForumData);
                b.a.r0.g2.e.a.a(2, 1, this.f18259e.getScene(), "", e(interestedForumData));
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
            if (cVar != null && !ListUtils.isEmpty(cVar.f18288a)) {
                PbListView pbListView = this.f18263i;
                if (pbListView != null) {
                    pbListView.C(this.f18261g.getContext().getString(R.string.pb_load_more));
                    this.f18263i.f();
                    return;
                }
                return;
            }
            this.f18259e.onError(str);
        }
    }
}
