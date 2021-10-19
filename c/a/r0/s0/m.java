package c.a.r0.s0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.f0.f;
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
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f24489a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f24490b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f24491c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24492d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f24493e;

    /* renamed from: f  reason: collision with root package name */
    public final l f24494f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f24495g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.q0.s.f0.g f24496h;

    /* renamed from: i  reason: collision with root package name */
    public final a f24497i;

    /* renamed from: j  reason: collision with root package name */
    public final FaceBuyDialog f24498j;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.l.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f24499f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24500g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f24501h;

        /* renamed from: i  reason: collision with root package name */
        public View f24502i;

        /* renamed from: j  reason: collision with root package name */
        public View f24503j;

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
            this.f24500g = null;
            this.f24501h = null;
            this.f24502i = null;
            this.f24499f = tbPageContext;
        }

        @Override // c.a.e.l.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f24499f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.f24502i = inflate;
                inflate.setPadding(0, this.f24499f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f24499f.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f24500g = (TextView) this.f24502i.findViewById(R.id.pb_more_text);
                View findViewById = this.f24502i.findViewById(R.id.pb_more_view);
                this.f24503j = findViewById;
                findViewById.setVisibility(8);
                this.f24501h = (ProgressBar) this.f24502i.findViewById(R.id.progress);
                h(TbadkApplication.getInst().getSkinType());
                this.f24503j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f24502i;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.e.l.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f24502i.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f24502i.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f24501h.setVisibility(8);
                this.f24500g.setText(R.string.load_more);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f24501h.setVisibility(0);
                this.f24500g.setText(this.f24499f.getPageActivity().getText(R.string.loading));
                this.f24503j.setVisibility(0);
            }
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tbPageContext = this.f24499f) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i2 == 1);
            this.f24499f.getLayoutMode().j(this.f24503j);
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
        this.f24489a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f24490b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f24491c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f24491c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f24491c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f24492d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f24495g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f24493e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f24496h = new c.a.q0.s.f0.g(tbPageContext);
        this.f24494f = new l(tbPageContext.getOrignalPage());
        this.f24497i = new a(this, tbPageContext);
        this.f24493e.setAdapter((ListAdapter) this.f24494f);
        this.f24493e.setPullRefresh(this.f24496h);
        this.f24493e.setNextPage(this.f24497i);
        try {
            this.f24492d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f24498j = new FaceBuyDialog(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f24495g.addNetworkChangeListener(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24497i.f();
            this.f24493e.completePullRefreshPostDelayed(0L);
        }
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24494f : (l) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24492d : (TextView) invokeV.objValue;
    }

    public void e() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (faceBuyDialog = this.f24498j) == null) {
            return;
        }
        c.a.e.e.m.g.b(faceBuyDialog, this.f24489a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f24497i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            c.a.q0.s.c layoutMode = this.f24489a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f24490b);
            NavigationBar navigationBar = this.f24491c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24489a, i2);
            }
            c.a.q0.s.f0.g gVar = this.f24496h;
            if (gVar != null) {
                gVar.D(i2);
            }
            a aVar = this.f24497i;
            if (aVar != null) {
                aVar.h(i2);
            }
            NoNetworkView noNetworkView = this.f24495g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f24489a, i2);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.f24495g) != null && noNetworkView.getVisibility() == 0 && c.a.e.e.p.j.z()) {
            this.f24495g.update(false);
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
            this.f24495g.removeNetworkChangeListener(bVar);
        }
    }

    public void l() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (faceBuyDialog = this.f24498j) == null) {
            return;
        }
        faceBuyDialog.setFailDialogInfo();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.f24493e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f24497i.g();
        }
    }

    public void o(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f24496h.a(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.f24493e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (faceBuyDialog = this.f24498j) == null) {
            return;
        }
        faceBuyDialog.setLoadingDialogInfo();
        c.a.e.e.m.g.j(this.f24498j, this.f24489a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f24497i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f24493e.startPullRefresh();
        }
    }
}
