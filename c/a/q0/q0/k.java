package c.a.q0.q0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.f0.f;
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
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f23692a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23693b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f23694c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f23695d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f23696e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.p0.s.f0.g f23697f;

    /* renamed from: g  reason: collision with root package name */
    public View f23698g;

    /* renamed from: h  reason: collision with root package name */
    public j f23699h;

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
        this.f23692a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f23693b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f23694c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f23694c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23695d = (NoNetworkView) this.f23693b.findViewById(R.id.view_no_network);
        this.f23696e = (BdListView) this.f23693b.findViewById(R.id.purchase_record_list);
        c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(tbPageContext);
        this.f23697f = gVar;
        this.f23696e.setPullRefresh(gVar);
        this.f23698g = BdListViewHelper.d(this.f23692a.getPageActivity(), this.f23696e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23695d.addNetworkChangeListener(bVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f23698g, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23696e.completePullRefreshPostDelayed(0L);
        }
    }

    public j d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23699h : (j) invokeV.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c.a.p0.s.c layoutMode = this.f23692a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f23693b);
            this.f23694c.onChangeSkinType(this.f23692a, i2);
            this.f23695d.onChangeSkinType(this.f23692a, i2);
            this.f23697f.D(i2);
        }
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, facePurchaseRecordsData) == null) {
            if (this.f23699h == null) {
                j jVar = new j(this.f23692a.getOrignalPage());
                this.f23699h = jVar;
                this.f23696e.setAdapter((ListAdapter) jVar);
            }
            this.f23699h.e(facePurchaseRecordsData);
            c();
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f23695d.removeNetworkChangeListener(bVar);
        }
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
            this.f23696e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f23697f.a(gVar);
        }
    }
}
