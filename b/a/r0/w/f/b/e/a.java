package b.a.r0.w.f.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.b.a.b;
import b.a.r0.w.f.h.b.c;
import b.a.r0.w.f.h.d.f;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24576a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24577b;

    /* renamed from: c  reason: collision with root package name */
    public g f24578c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24579d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f24580e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f24581f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f24582g;

    /* renamed from: h  reason: collision with root package name */
    public b f24583h;

    /* renamed from: i  reason: collision with root package name */
    public int f24584i;
    public f j;

    /* renamed from: b.a.r0.w.f.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1201a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24585a;

        public C1201a(a aVar) {
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
            this.f24585a = aVar;
        }

        @Override // b.a.r0.w.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                TiebaStatic.log(b.a.r0.w.f.e.a.c().e(this.f24585a.f24584i, "c12118", i2, str, d2Var));
                a aVar = this.f24585a;
                aVar.h(aVar.f24576a, d2Var, str);
            }
        }

        @Override // b.a.r0.w.f.h.d.f
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
        this.j = new C1201a(this);
        this.f24576a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f24580e = linearLayout;
        linearLayout.setOrientation(1);
        this.f24581f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f24581f.setVisibility(8);
        }
        this.f24580e.addView(this.f24581f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f24579d = frameLayout;
        this.f24580e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f24580e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f24576a.getPageActivity());
        this.f24577b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f24579d.addView(this.f24577b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f24576a);
        this.f24578c = gVar;
        gVar.U(bdUniqueId);
        this.f24577b.setPullRefresh(this.f24578c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f24582g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f24577b);
        this.f24583h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24577b.completePullRefresh();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24579d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24577b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24580e : (View) invokeV.objValue;
    }

    public final void h(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.l1());
        alaLiveInfoCoreData.userName = d2Var.J().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f24582g.p(R.color.CAM_X0204);
            this.f24582g.d(i2);
            this.f24578c.C(i2);
            this.f24583h.b();
            SkinManager.setBackgroundColor(this.f24580e, R.color.CAM_X0201);
            this.f24581f.onChangeSkinType(this.f24576a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f24584i = i2;
            this.f24583h.d(list);
            this.f24583h.e(i2);
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
            this.f24578c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f24577b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f24577b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f24577b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f24583h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f24582g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24577b.setNextPage(this.f24582g);
        }
        this.f24582g.O();
        this.f24582g.Q();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f24582g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f24577b.setNextPage(this.f24582g);
        }
        this.f24582g.C(this.f24576a.getResources().getString(R.string.list_no_more));
        this.f24582g.f();
    }
}
