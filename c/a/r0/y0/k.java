package c.a.r0.y0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.g0.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<FacePurchaseRecordsActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final View f25581b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f25582c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f25583d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f25584e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.q0.s.g0.g f25585f;

    /* renamed from: g  reason: collision with root package name */
    public View f25586g;

    /* renamed from: h  reason: collision with root package name */
    public j f25587h;

    public k(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
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
        this.a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f25581b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f25582c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f25582c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25583d = (NoNetworkView) this.f25581b.findViewById(R.id.view_no_network);
        this.f25584e = (BdListView) this.f25581b.findViewById(R.id.purchase_record_list);
        c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(tbPageContext);
        this.f25585f = gVar;
        this.f25584e.setPullRefresh(gVar);
        this.f25586g = BdListViewHelper.d(this.a.getPageActivity(), this.f25584e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f25583d.addNetworkChangeListener(bVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f25586g, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25584e.completePullRefreshPostDelayed(0L);
        }
    }

    public j d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25587h : (j) invokeV.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c.a.q0.s.c layoutMode = this.a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f25581b);
            this.f25582c.onChangeSkinType(this.a, i2);
            this.f25583d.onChangeSkinType(this.a, i2);
            this.f25585f.C(i2);
        }
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, facePurchaseRecordsData) == null) {
            if (this.f25587h == null) {
                j jVar = new j(this.a.getOrignalPage());
                this.f25587h = jVar;
                this.f25584e.setAdapter((ListAdapter) jVar);
            }
            this.f25587h.e(facePurchaseRecordsData);
            c();
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f25583d.removeNetworkChangeListener(bVar);
        }
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
            this.f25584e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f25585f.a(gVar);
        }
    }
}
