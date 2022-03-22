package c.a.p0.a1;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.f;
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
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<FacePurchaseRecordsActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final View f11981b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f11982c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f11983d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f11984e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.o0.r.l0.g f11985f;

    /* renamed from: g  reason: collision with root package name */
    public View f11986g;

    /* renamed from: h  reason: collision with root package name */
    public k f11987h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d028e);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f09197b);
        this.f11981b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f11982c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0f03));
        this.f11982c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f11983d = (NoNetworkView) this.f11981b.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f11984e = (BdListView) this.f11981b.findViewById(R.id.obfuscated_res_0x7f09197c);
        c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(tbPageContext);
        this.f11985f = gVar;
        this.f11984e.setPullRefresh(gVar);
        this.f11986g = BdListViewHelper.d(this.a.getPageActivity(), this.f11984e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f11983d.a(bVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f11986g, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11984e.A(0L);
        }
    }

    public k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11987h : (k) invokeV.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            c.a.o0.r.c layoutMode = this.a.getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(this.f11981b);
            this.f11982c.onChangeSkinType(this.a, i);
            this.f11983d.c(this.a, i);
            this.f11985f.H(i);
        }
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, facePurchaseRecordsData) == null) {
            if (this.f11987h == null) {
                k kVar = new k(this.a.getOrignalPage());
                this.f11987h = kVar;
                this.f11984e.setAdapter((ListAdapter) kVar);
            }
            this.f11987h.e(facePurchaseRecordsData);
            c();
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f11983d.d(bVar);
        }
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
            this.f11984e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f11985f.f(gVar);
        }
    }
}
