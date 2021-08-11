package c.a.p0.v.d.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.k.e.n;
import c.a.o0.s.f0.f;
import c.a.o0.s.f0.g;
import c.a.o0.s.q.c2;
import c.a.p0.v.d.b.a.b;
import c.a.p0.v.d.h.b.c;
import c.a.p0.v.d.h.d.f;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24721a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24722b;

    /* renamed from: c  reason: collision with root package name */
    public g f24723c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24724d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f24725e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f24726f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f24727g;

    /* renamed from: h  reason: collision with root package name */
    public b f24728h;

    /* renamed from: i  reason: collision with root package name */
    public int f24729i;

    /* renamed from: j  reason: collision with root package name */
    public f f24730j;

    /* renamed from: c.a.p0.v.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1158a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24731a;

        public C1158a(a aVar) {
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
            this.f24731a = aVar;
        }

        @Override // c.a.p0.v.d.h.d.f
        public void a(int i2, String str, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, c2Var) == null) {
                TiebaStatic.log(c.a.p0.v.d.e.a.c().e(this.f24731a.f24729i, "c12118", i2, str, c2Var));
                a aVar = this.f24731a;
                aVar.h(aVar.f24721a, c2Var, str);
            }
        }

        @Override // c.a.p0.v.d.h.d.f
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
        this.f24730j = new C1158a(this);
        this.f24721a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f24725e = linearLayout;
        linearLayout.setOrientation(1);
        this.f24726f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f24726f.setVisibility(8);
        }
        this.f24725e.addView(this.f24726f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f24724d = frameLayout;
        this.f24725e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f24725e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f24721a.getPageActivity());
        this.f24722b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f24724d.addView(this.f24722b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f24721a);
        this.f24723c = gVar;
        gVar.V(bdUniqueId);
        this.f24722b.setPullRefresh(this.f24723c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f24727g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f24722b);
        this.f24728h = bVar;
        bVar.c(this.f24730j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24722b.completePullRefresh();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24724d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24722b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24725e : (View) invokeV.objValue;
    }

    public final void h(TbPageContext<?> tbPageContext, c2 c2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, c2Var, str) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = c2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
        alaLiveInfoCoreData.userName = c2Var.J().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f24727g.o(R.color.CAM_X0204);
            this.f24727g.d(i2);
            this.f24723c.D(i2);
            this.f24728h.b();
            SkinManager.setBackgroundColor(this.f24725e, R.color.CAM_X0201);
            this.f24726f.onChangeSkinType(this.f24721a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f24729i = i2;
            this.f24728h.d(list);
            this.f24728h.e(i2);
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
            this.f24723c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f24722b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f24722b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f24722b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f24728h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f24727g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24722b.setNextPage(this.f24727g);
        }
        this.f24727g.M();
        this.f24727g.O();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f24727g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24722b.setNextPage(this.f24727g);
        }
        this.f24727g.A(this.f24721a.getResources().getString(R.string.list_no_more));
        this.f24727g.f();
    }
}
