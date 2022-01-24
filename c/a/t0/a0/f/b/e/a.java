package c.a.t0.a0.f.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.s0.s.q.e2;
import c.a.t0.a0.f.b.a.b;
import c.a.t0.a0.f.h.b.c;
import c.a.t0.a0.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14546b;

    /* renamed from: c  reason: collision with root package name */
    public g f14547c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f14548d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14549e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f14550f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f14551g;

    /* renamed from: h  reason: collision with root package name */
    public b f14552h;

    /* renamed from: i  reason: collision with root package name */
    public int f14553i;

    /* renamed from: j  reason: collision with root package name */
    public f f14554j;

    /* renamed from: c.a.t0.a0.f.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0929a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0929a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.t0.a0.f.h.d.f
        public void a(int i2, String str, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, e2Var) == null) {
                TiebaStatic.log(c.a.t0.a0.f.e.a.c().e(this.a.f14553i, "c12118", i2, str, e2Var));
                a aVar = this.a;
                aVar.h(aVar.a, e2Var, str);
            }
        }

        @Override // c.a.t0.a0.f.h.d.f
        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            }
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14554j = new C0929a(this);
        this.a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f14549e = linearLayout;
        linearLayout.setOrientation(1);
        this.f14550f = new NoNetworkView(tbPageContext.getPageActivity());
        if (l.z()) {
            this.f14550f.setVisibility(8);
        }
        this.f14549e.addView(this.f14550f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f14548d = frameLayout;
        this.f14549e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f14549e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.a.getPageActivity());
        this.f14546b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f14548d.addView(this.f14546b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.a);
        this.f14547c = gVar;
        gVar.V(bdUniqueId);
        this.f14546b.setPullRefresh(this.f14547c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f14551g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f14546b);
        this.f14552h = bVar;
        bVar.c(this.f14554j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14546b.completePullRefresh();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14548d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14546b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14549e : (View) invokeV.objValue;
    }

    public final void h(TbPageContext<?> tbPageContext, e2 e2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, e2Var, str) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
        alaLiveInfoCoreData.userName = e2Var.J().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f14551g.p(R.color.CAM_X0204);
            this.f14551g.d(i2);
            this.f14547c.C(i2);
            this.f14552h.b();
            SkinManager.setBackgroundColor(this.f14549e, R.color.CAM_X0201);
            this.f14550f.onChangeSkinType(this.a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f14553i = i2;
            this.f14552h.d(list);
            this.f14552h.e(i2);
            if (z) {
                p();
            } else {
                q();
            }
        }
    }

    public void k(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f14547c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f14546b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f14546b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f14546b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f14552h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f14551g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f14546b.setNextPage(this.f14551g);
        }
        this.f14551g.P();
        this.f14551g.R();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f14551g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f14546b.setNextPage(this.f14551g);
        }
        this.f14551g.D(this.a.getResources().getString(R.string.list_no_more));
        this.f14551g.f();
    }
}
