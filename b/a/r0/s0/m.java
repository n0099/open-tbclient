package b.a.r0.s0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyDialog;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f24676a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f24677b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f24678c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24679d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f24680e;

    /* renamed from: f  reason: collision with root package name */
    public final l f24681f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f24682g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.q0.s.g0.g f24683h;

    /* renamed from: i  reason: collision with root package name */
    public final a f24684i;
    public final FaceBuyDialog j;

    /* loaded from: classes5.dex */
    public class a extends b.a.e.m.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f24685f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24686g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f24687h;

        /* renamed from: i  reason: collision with root package name */
        public View f24688i;
        public View j;

        public a(m mVar, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24686g = null;
            this.f24687h = null;
            this.f24688i = null;
            this.f24685f = tbPageContext;
        }

        @Override // b.a.e.m.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f24685f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.f24688i = inflate;
                inflate.setPadding(0, this.f24685f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f24685f.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f24686g = (TextView) this.f24688i.findViewById(R.id.pb_more_text);
                View findViewById = this.f24688i.findViewById(R.id.pb_more_view);
                this.j = findViewById;
                findViewById.setVisibility(8);
                this.f24687h = (ProgressBar) this.f24688i.findViewById(R.id.progress);
                h(TbadkApplication.getInst().getSkinType());
                this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f24688i;
            }
            return (View) invokeV.objValue;
        }

        @Override // b.a.e.m.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f24688i.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f24688i.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f24687h.setVisibility(8);
                this.f24686g.setText(R.string.load_more);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f24687h.setVisibility(0);
                this.f24686g.setText(this.f24685f.getPageActivity().getText(R.string.loading));
                this.j.setVisibility(0);
            }
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tbPageContext = this.f24685f) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i2 == 1);
            this.f24685f.getLayoutMode().j(this.j);
        }
    }

    public m(TbPageContext<FaceShopActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24676a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f24677b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f24678c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f24678c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f24678c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f24679d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f24682g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f24680e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f24683h = new b.a.q0.s.g0.g(tbPageContext);
        this.f24681f = new l(tbPageContext.getOrignalPage());
        this.f24684i = new a(this, tbPageContext);
        this.f24680e.setAdapter((ListAdapter) this.f24681f);
        this.f24680e.setPullRefresh(this.f24683h);
        this.f24680e.setNextPage(this.f24684i);
        try {
            this.f24679d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new FaceBuyDialog(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f24682g.addNetworkChangeListener(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24684i.f();
            this.f24680e.completePullRefreshPostDelayed(0L);
        }
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24681f : (l) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24679d : (TextView) invokeV.objValue;
    }

    public void e() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (faceBuyDialog = this.j) == null) {
            return;
        }
        b.a.e.f.m.g.b(faceBuyDialog, this.f24676a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f24684i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            b.a.q0.s.c layoutMode = this.f24676a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f24677b);
            NavigationBar navigationBar = this.f24678c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24676a, i2);
            }
            b.a.q0.s.g0.g gVar = this.f24683h;
            if (gVar != null) {
                gVar.C(i2);
            }
            a aVar = this.f24684i;
            if (aVar != null) {
                aVar.h(i2);
            }
            NoNetworkView noNetworkView = this.f24682g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f24676a, i2);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.f24682g) != null && noNetworkView.getVisibility() == 0 && b.a.e.f.p.j.z()) {
            this.f24682g.update(false);
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
    }

    public void j(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, faceShopData) == null) {
            b();
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(it.next().pid));
            }
            i(arrayList2);
        }
    }

    public void k(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f24682g.removeNetworkChangeListener(bVar);
        }
    }

    public void l() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (faceBuyDialog = this.j) == null) {
            return;
        }
        faceBuyDialog.setFailDialogInfo();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.f24680e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f24684i.g();
        }
    }

    public void o(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f24683h.a(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.f24680e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (faceBuyDialog = this.j) == null) {
            return;
        }
        faceBuyDialog.setLoadingDialogInfo();
        b.a.e.f.m.g.j(this.j, this.f24676a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f24684i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f24680e.startPullRefresh();
        }
    }
}
