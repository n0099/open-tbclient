package c.a.p0.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.f;
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
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<FaceShopActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f12006b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f12007c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12008d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f12009e;

    /* renamed from: f  reason: collision with root package name */
    public final m f12010f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f12011g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.o0.r.l0.g f12012h;
    public final a i;
    public final h j;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.o.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final TbPageContext<?> f12013b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f12014c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f12015d;

        /* renamed from: e  reason: collision with root package name */
        public View f12016e;

        /* renamed from: f  reason: collision with root package name */
        public View f12017f;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12014c = null;
            this.f12015d = null;
            this.f12016e = null;
            this.f12013b = tbPageContext;
        }

        @Override // c.a.d.o.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f12013b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                this.f12016e = inflate;
                inflate.setPadding(0, this.f12013b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, this.f12013b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
                this.f12014c = (TextView) this.f12016e.findViewById(R.id.obfuscated_res_0x7f0916ed);
                View findViewById = this.f12016e.findViewById(R.id.obfuscated_res_0x7f0916f0);
                this.f12017f = findViewById;
                findViewById.setVisibility(8);
                this.f12015d = (ProgressBar) this.f12016e.findViewById(R.id.obfuscated_res_0x7f091929);
                h(TbadkApplication.getInst().getSkinType());
                this.f12017f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f12016e;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.d.o.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f12016e.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f12016e.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f12015d.setVisibility(8);
                this.f12014c.setText(R.string.obfuscated_res_0x7f0f0a2b);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f12015d.setVisibility(0);
                this.f12014c.setText(this.f12013b.getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a2e));
                this.f12017f.setVisibility(0);
            }
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (tbPageContext = this.f12013b) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i == 1);
            this.f12013b.getLayoutMode().j(this.f12017f);
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
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
        tbPageContext.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d028f);
        this.f12006b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090958);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f12007c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f05df));
        this.f12007c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f12007c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0a75));
        this.f12008d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f12011g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f12009e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090959);
        this.f12012h = new c.a.o0.r.l0.g(tbPageContext);
        this.f12010f = new m(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.f12009e.setAdapter((ListAdapter) this.f12010f);
        this.f12009e.setPullRefresh(this.f12012h);
        this.f12009e.setNextPage(this.i);
        try {
            this.f12008d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.obfuscated_res_0x7f10039e);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f12011g.a(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i.f();
            this.f12009e.A(0L);
        }
    }

    public m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12010f : (m) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12008d : (TextView) invokeV.objValue;
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.j) == null) {
            return;
        }
        c.a.d.f.m.g.b(hVar, this.a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            c.a.o0.r.c layoutMode = this.a.getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(this.f12006b);
            NavigationBar navigationBar = this.f12007c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            c.a.o0.r.l0.g gVar = this.f12012h;
            if (gVar != null) {
                gVar.H(i);
            }
            a aVar = this.i;
            if (aVar != null) {
                aVar.h(i);
            }
            NoNetworkView noNetworkView = this.f12011g;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.f12011g) != null && noNetworkView.getVisibility() == 0 && c.a.d.f.p.l.z()) {
            this.f12011g.update(false);
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
            this.f12011g.d(bVar);
        }
    }

    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.c();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.f12009e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i.g();
        }
    }

    public void o(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f12012h.f(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.f12009e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.d();
        c.a.d.f.m.g.j(this.j, this.a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f12009e.F();
        }
    }
}
