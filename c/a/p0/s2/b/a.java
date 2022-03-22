package c.a.p0.s2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.p0.s2.c.g;
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
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements InterestedForumModel.d, InterestedForumAdapter.c, View.OnClickListener, InterestedForumModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InterestedForumFragment a;

    /* renamed from: b  reason: collision with root package name */
    public final InterestedForumModel f18209b;

    /* renamed from: c  reason: collision with root package name */
    public final BdRecyclerView f18210c;

    /* renamed from: d  reason: collision with root package name */
    public InterestedForumAdapter f18211d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f18212e;

    /* renamed from: f  reason: collision with root package name */
    public final TBSpecificationBtn f18213f;

    /* renamed from: g  reason: collision with root package name */
    public final TBSpecificationBtn f18214g;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f18215h;
    public boolean i;
    public c.a.p0.s2.c.c j;
    public int k;
    public final boolean l;
    public BdListView.p m;
    public View.OnClickListener n;

    /* renamed from: c.a.p0.s2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1376a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1376a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, InterestedForumModel interestedForumModel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, interestedForumModel, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = 0;
        this.m = new C1376a(this);
        this.n = new b(this);
        this.a = interestedForumFragment;
        this.f18210c = bdRecyclerView;
        this.f18209b = interestedForumModel;
        this.f18215h = tbPageContext;
        this.f18214g = tBSpecificationBtn;
        this.f18213f = tBSpecificationBtn2;
        this.k = i;
        this.l = z;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i > 0 && !this.f18214g.isEnabled()) {
                this.f18214g.setEnabled(true);
                this.f18214g.setText(this.f18210c.getResources().getString(R.string.obfuscated_res_0x7f0f11c5));
            } else if (i == 0) {
                this.f18214g.setEnabled(false);
                this.f18214g.setText(this.f18210c.getResources().getString(R.string.obfuscated_res_0x7f0f1425));
            }
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            if (!z) {
                this.f18213f.setText(this.f18215h.getString(R.string.obfuscated_res_0x7f0f10ba));
                this.f18213f.setConfig(bVar);
                return;
            }
            this.f18213f.setText(this.f18215h.getString(R.string.obfuscated_res_0x7f0f1483));
            bVar.t(R.color.CAM_X0109);
            this.f18213f.setConfig(bVar);
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.i) {
                this.i = true;
            } else if (this.k == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.a.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.a.getActivity().setResult(-1);
                this.a.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f18215h.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void c(c.a.p0.s2.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            c.a.p0.s2.c.c cVar2 = this.j;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.a)) {
                this.j = cVar;
            } else if (cVar != null) {
                this.j.a.addAll(cVar.a);
            }
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                if (this.f18210c.getVisibility() == 8) {
                    this.f18210c.setVisibility(0);
                }
                this.f18211d.n(cVar.a);
                this.a.D0();
            }
            if (this.f18209b.p()) {
                return;
            }
            l();
        }
    }

    public String e(List<c.a.p0.s2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c.a.p0.s2.c.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.a)) {
                    for (g gVar : aVar.a) {
                        if (gVar != null && gVar.f18247b && gVar.a != null) {
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

    public void f(List<c.a.p0.s2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f18209b.t(list);
            this.f18209b.o();
            if (this.i || this.l) {
                return;
            }
            this.f18209b.g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18211d = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f18210c;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f18210c.setAdapter(this.f18211d);
            PbListView pbListView = new PbListView(this.f18210c.getContext());
            this.f18212e = pbListView;
            pbListView.a();
            this.f18212e.p(R.color.CAM_X0205);
            this.f18212e.y();
            this.f18212e.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f18212e.H(R.dimen.tbfontsize33);
            this.f18212e.B(R.color.CAM_X0110);
            this.f18212e.C(this.n);
            this.f18210c.setNextPage(this.f18212e);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18210c.setOnSrollToBottomListener(this.m);
            this.f18209b.v(this);
            this.f18209b.u(this);
            this.f18211d.w(this);
            this.f18214g.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f18209b.p()) {
            InterestedForumModel interestedForumModel = this.f18209b;
            if (interestedForumModel.f34783f) {
                return;
            }
            interestedForumModel.o();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f18211d.t();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f18212e.K();
            this.f18212e.R();
            this.f18212e.D(this.f18210c.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.f18212e.M(n.f(this.f18210c.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18212e.E(this.f18210c.getContext().getString(R.string.obfuscated_res_0x7f0f091b), n.f(this.f18210c.getContext(), R.dimen.tbds178));
            this.f18212e.H(R.dimen.tbds36);
            this.f18212e.B(R.color.CAM_X0109);
            this.f18212e.f();
            this.f18212e.C(null);
            this.f18212e.M(n.f(this.f18210c.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view == this.f18214g) {
            List<c.a.p0.s2.c.a> o = this.f18211d.o();
            try {
                this.f18209b.i(o);
                c.a.p0.s2.e.a.a(2, 1, this.a.C0(), "", e(o));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            c.a.p0.s2.c.c cVar = this.j;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f18212e;
                if (pbListView != null) {
                    pbListView.D(this.f18210c.getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                    this.f18212e.f();
                    return;
                }
                return;
            }
            this.a.E0(str);
        }
    }
}
