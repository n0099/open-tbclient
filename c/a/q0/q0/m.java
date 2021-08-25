package c.a.q0.q0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.f0.f;
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
    public final TbPageContext<FaceShopActivity> f23724a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f23725b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f23726c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23727d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f23728e;

    /* renamed from: f  reason: collision with root package name */
    public final l f23729f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f23730g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.s.f0.g f23731h;

    /* renamed from: i  reason: collision with root package name */
    public final a f23732i;

    /* renamed from: j  reason: collision with root package name */
    public final FaceBuyDialog f23733j;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.l.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f23734f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f23735g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f23736h;

        /* renamed from: i  reason: collision with root package name */
        public View f23737i;

        /* renamed from: j  reason: collision with root package name */
        public View f23738j;

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
            this.f23735g = null;
            this.f23736h = null;
            this.f23737i = null;
            this.f23734f = tbPageContext;
        }

        @Override // c.a.e.l.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f23734f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.f23737i = inflate;
                inflate.setPadding(0, this.f23734f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f23734f.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f23735g = (TextView) this.f23737i.findViewById(R.id.pb_more_text);
                View findViewById = this.f23737i.findViewById(R.id.pb_more_view);
                this.f23738j = findViewById;
                findViewById.setVisibility(8);
                this.f23736h = (ProgressBar) this.f23737i.findViewById(R.id.progress);
                h(TbadkApplication.getInst().getSkinType());
                this.f23738j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f23737i;
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
                this.f23737i.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f23737i.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f23736h.setVisibility(8);
                this.f23735g.setText(R.string.load_more);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f23736h.setVisibility(0);
                this.f23735g.setText(this.f23734f.getPageActivity().getText(R.string.loading));
                this.f23738j.setVisibility(0);
            }
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tbPageContext = this.f23734f) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i2 == 1);
            this.f23734f.getLayoutMode().j(this.f23738j);
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
        this.f23724a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f23725b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f23726c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f23726c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f23726c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f23727d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f23730g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f23728e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f23731h = new c.a.p0.s.f0.g(tbPageContext);
        this.f23729f = new l(tbPageContext.getOrignalPage());
        this.f23732i = new a(this, tbPageContext);
        this.f23728e.setAdapter((ListAdapter) this.f23729f);
        this.f23728e.setPullRefresh(this.f23731h);
        this.f23728e.setNextPage(this.f23732i);
        try {
            this.f23727d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f23733j = new FaceBuyDialog(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23730g.addNetworkChangeListener(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23732i.f();
            this.f23728e.completePullRefreshPostDelayed(0L);
        }
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23729f : (l) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23727d : (TextView) invokeV.objValue;
    }

    public void e() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (faceBuyDialog = this.f23733j) == null) {
            return;
        }
        c.a.e.e.m.g.b(faceBuyDialog, this.f23724a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f23732i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            c.a.p0.s.c layoutMode = this.f23724a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f23725b);
            NavigationBar navigationBar = this.f23726c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23724a, i2);
            }
            c.a.p0.s.f0.g gVar = this.f23731h;
            if (gVar != null) {
                gVar.D(i2);
            }
            a aVar = this.f23732i;
            if (aVar != null) {
                aVar.h(i2);
            }
            NoNetworkView noNetworkView = this.f23730g;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f23724a, i2);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.f23730g) != null && noNetworkView.getVisibility() == 0 && c.a.e.e.p.j.z()) {
            this.f23730g.update(false);
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
            this.f23730g.removeNetworkChangeListener(bVar);
        }
    }

    public void l() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (faceBuyDialog = this.f23733j) == null) {
            return;
        }
        faceBuyDialog.setFailDialogInfo();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.f23728e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f23732i.g();
        }
    }

    public void o(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f23731h.a(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.f23728e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        FaceBuyDialog faceBuyDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (faceBuyDialog = this.f23733j) == null) {
            return;
        }
        faceBuyDialog.setLoadingDialogInfo();
        c.a.e.e.m.g.j(this.f23733j, this.f23724a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f23732i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f23728e.startPullRefresh();
        }
    }
}
