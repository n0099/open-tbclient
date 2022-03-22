package c.a.p0.s2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.c1.q;
import c.a.p0.s2.c.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements InterestedForumModel.d, c.a.p0.s2.f.c, View.OnClickListener, InterestedForumModel.c, c.a.p0.s2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s2.a.h.a a;

    /* renamed from: b  reason: collision with root package name */
    public final BaseInterestedForumFragment f18216b;

    /* renamed from: c  reason: collision with root package name */
    public final InterestedForumModel f18217c;

    /* renamed from: d  reason: collision with root package name */
    public final BdTypeRecyclerView f18218d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f18219e;

    /* renamed from: f  reason: collision with root package name */
    public final TBSpecificationBtn f18220f;

    /* renamed from: g  reason: collision with root package name */
    public final TBSpecificationBtn f18221g;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f18222h;
    public boolean i;
    public c.a.p0.s2.c.c j;
    public int k;
    public final boolean l;
    public BdListView.p m;
    public View.OnClickListener n;

    /* loaded from: classes2.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* renamed from: c.a.p0.s2.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1377b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1377b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.j();
            }
        }
    }

    public b(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, InterestedForumModel interestedForumModel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, interestedForumModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.m = new a(this);
        this.n = new View$OnClickListenerC1377b(this);
        this.f18216b = baseInterestedForumFragment;
        this.f18218d = bdTypeRecyclerView;
        this.f18217c = interestedForumModel;
        this.f18222h = tbPageContext;
        this.f18221g = tBSpecificationBtn;
        this.f18220f = tBSpecificationBtn2;
        this.k = i;
        this.l = z;
        this.a = new c.a.p0.s2.a.h.a(tbPageContext.getPageActivity(), this.f18218d);
        h();
        i();
    }

    @Override // c.a.p0.s2.f.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.e()) {
                this.f18221g.setEnabled(true);
                this.f18221g.setText(this.f18218d.getResources().getString(R.string.obfuscated_res_0x7f0f11c5));
            } else {
                this.f18221g.setEnabled(false);
                this.f18221g.setText(this.f18218d.getResources().getString(R.string.obfuscated_res_0x7f0f0919));
            }
            c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
            this.f18220f.setTextSize(R.dimen.T_X06);
            if (!this.a.f()) {
                this.f18220f.setText(this.f18222h.getString(R.string.obfuscated_res_0x7f0f091f));
                cVar.p(R.color.CAM_X0304);
                this.f18220f.setConfig(cVar);
                return;
            }
            this.f18220f.setText(this.f18222h.getString(R.string.obfuscated_res_0x7f0f0921));
            cVar.r(R.color.CAM_X0105);
            this.f18220f.setConfig(cVar);
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
                this.f18216b.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.f18216b.getActivity().setResult(-1);
                this.f18216b.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f18222h.getPageActivity()).createNormalCfg(0)));
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
                if (this.f18218d.getVisibility() == 8) {
                    this.f18218d.setVisibility(0);
                }
                this.a.j(cVar.a);
                this.f18216b.D0();
            }
            if (this.f18217c.p()) {
                return;
            }
            n();
        }
    }

    @Override // c.a.p0.s2.f.b
    public void d(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            c.a.p0.s2.e.a.b(str);
            this.a.a(i, this.j, i2);
        }
    }

    public String f(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                n nVar = list.get(i);
                if (nVar instanceof d) {
                    d dVar = (d) nVar;
                    if (dVar.k()) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(dVar.e());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void g(List<c.a.p0.s2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f18217c.t(list);
            this.f18217c.o();
            if (this.i || this.l) {
                return;
            }
            this.f18217c.g();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.f18218d.getContext());
            this.f18219e = pbListView;
            pbListView.a();
            this.f18219e.p(R.color.CAM_X0601);
            this.f18219e.y();
            this.f18219e.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f18219e.H(R.dimen.tbfontsize33);
            this.f18219e.B(R.color.CAM_X0110);
            this.f18219e.C(this.n);
            this.f18218d.setNextPage(this.f18219e);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f18218d.setOnSrollToBottomListener(this.m);
            this.f18217c.v(this);
            this.f18217c.u(this);
            this.a.k(this);
            this.a.i(this);
            this.f18221g.setOnClickListener(this);
            this.f18220f.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f18217c.p()) {
            InterestedForumModel interestedForumModel = this.f18217c;
            if (interestedForumModel.f34783f) {
                return;
            }
            interestedForumModel.o();
            m();
        }
    }

    public void k(int i) {
        c.a.p0.s2.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.g(i);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f18219e.K();
            this.f18219e.R();
            this.f18219e.D(this.f18218d.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.f18219e.M(c.a.d.f.p.n.f(this.f18218d.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f18219e.E(this.f18218d.getContext().getString(R.string.obfuscated_res_0x7f0f091b), c.a.d.f.p.n.f(this.f18218d.getContext(), R.dimen.tbds178));
            this.f18219e.H(R.dimen.tbds36);
            this.f18219e.B(R.color.CAM_X0109);
            this.f18219e.f();
            this.f18219e.C(null);
            this.f18219e.M(c.a.d.f.p.n.f(this.f18218d.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.f18221g) {
                List<n> c2 = this.a.c();
                try {
                    this.f18217c.j(c2);
                    c.a.p0.s2.e.a.a(2, 1, this.f18216b.C0(), "", f(c2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else if (view != this.f18220f || q.a()) {
            } else {
                if (this.f18222h.getString(R.string.obfuscated_res_0x7f0f091f).equals(this.f18220f.getText())) {
                    l(true);
                } else if (this.f18222h.getString(R.string.obfuscated_res_0x7f0f0921).equals(this.f18220f.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            c.a.p0.s2.c.c cVar = this.j;
            if (cVar != null && !ListUtils.isEmpty(cVar.a)) {
                PbListView pbListView = this.f18219e;
                if (pbListView != null) {
                    pbListView.D(this.f18218d.getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                    this.f18219e.f();
                    return;
                }
                return;
            }
            this.f18216b.E0(str);
        }
    }
}
