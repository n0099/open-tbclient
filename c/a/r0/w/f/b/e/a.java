package c.a.r0.w.f.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.q0.s.q.d2;
import c.a.r0.w.f.b.a.b;
import c.a.r0.w.f.h.b.c;
import c.a.r0.w.f.h.d.f;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25730a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25731b;

    /* renamed from: c  reason: collision with root package name */
    public g f25732c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f25733d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f25734e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f25735f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f25736g;

    /* renamed from: h  reason: collision with root package name */
    public b f25737h;

    /* renamed from: i  reason: collision with root package name */
    public int f25738i;

    /* renamed from: j  reason: collision with root package name */
    public f f25739j;

    /* renamed from: c.a.r0.w.f.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1200a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25740a;

        public C1200a(a aVar) {
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
            this.f25740a = aVar;
        }

        @Override // c.a.r0.w.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                TiebaStatic.log(c.a.r0.w.f.e.a.c().e(this.f25740a.f25738i, "c12118", i2, str, d2Var));
                a aVar = this.f25740a;
                aVar.h(aVar.f25730a, d2Var, str);
            }
        }

        @Override // c.a.r0.w.f.h.d.f
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
        this.f25739j = new C1200a(this);
        this.f25730a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f25734e = linearLayout;
        linearLayout.setOrientation(1);
        this.f25735f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f25735f.setVisibility(8);
        }
        this.f25734e.addView(this.f25735f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f25733d = frameLayout;
        this.f25734e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f25734e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f25730a.getPageActivity());
        this.f25731b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f25733d.addView(this.f25731b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f25730a);
        this.f25732c = gVar;
        gVar.V(bdUniqueId);
        this.f25731b.setPullRefresh(this.f25732c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f25736g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f25731b);
        this.f25737h = bVar;
        bVar.c(this.f25739j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25731b.completePullRefresh();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25733d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25731b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25734e : (View) invokeV.objValue;
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
            this.f25736g.o(R.color.CAM_X0204);
            this.f25736g.d(i2);
            this.f25732c.D(i2);
            this.f25737h.b();
            SkinManager.setBackgroundColor(this.f25734e, R.color.CAM_X0201);
            this.f25735f.onChangeSkinType(this.f25730a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f25738i = i2;
            this.f25737h.d(list);
            this.f25737h.e(i2);
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
            this.f25732c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f25731b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f25731b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f25731b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f25737h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f25736g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25731b.setNextPage(this.f25736g);
        }
        this.f25736g.M();
        this.f25736g.O();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f25736g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25731b.setNextPage(this.f25736g);
        }
        this.f25736g.A(this.f25730a.getResources().getString(R.string.list_no_more));
        this.f25736g.f();
    }
}
