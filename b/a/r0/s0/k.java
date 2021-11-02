package b.a.r0.s0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.f;
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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f23315a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23316b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f23317c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f23318d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f23319e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.q0.s.g0.g f23320f;

    /* renamed from: g  reason: collision with root package name */
    public View f23321g;

    /* renamed from: h  reason: collision with root package name */
    public j f23322h;

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
        this.f23315a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f23316b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f23317c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f23317c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23318d = (NoNetworkView) this.f23316b.findViewById(R.id.view_no_network);
        this.f23319e = (BdListView) this.f23316b.findViewById(R.id.purchase_record_list);
        b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(tbPageContext);
        this.f23320f = gVar;
        this.f23319e.setPullRefresh(gVar);
        this.f23321g = BdListViewHelper.d(this.f23315a.getPageActivity(), this.f23319e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23318d.addNetworkChangeListener(bVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f23321g, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23319e.completePullRefreshPostDelayed(0L);
        }
    }

    public j d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23322h : (j) invokeV.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            b.a.q0.s.c layoutMode = this.f23315a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f23316b);
            this.f23317c.onChangeSkinType(this.f23315a, i2);
            this.f23318d.onChangeSkinType(this.f23315a, i2);
            this.f23320f.C(i2);
        }
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, facePurchaseRecordsData) == null) {
            if (this.f23322h == null) {
                j jVar = new j(this.f23315a.getOrignalPage());
                this.f23322h = jVar;
                this.f23319e.setAdapter((ListAdapter) jVar);
            }
            this.f23322h.e(facePurchaseRecordsData);
            c();
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f23318d.removeNetworkChangeListener(bVar);
        }
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
            this.f23319e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f23320f.a(gVar);
        }
    }
}
