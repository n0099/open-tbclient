package c.a.r0.s2.i;

import android.view.View;
import c.a.d.m.e.n;
import c.a.r0.g0.d0;
import c.a.r0.t2.e.h;
import c.a.r0.w2.d;
import c.a.r0.w2.g;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f23503b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f23504c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s2.i.a f23505d;

    /* renamed from: e  reason: collision with root package name */
    public d0<h> f23506e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23507e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23507e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23507e.a.getPageActivity().finish();
            }
        }
    }

    public c(TbPageContext tbPageContext) {
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
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23503b.setCenterTextTitle(this.a.getString(g.person_center_more));
            this.f23503b.showBottomLine();
            this.f23503b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f23503b.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f23503b = (NavigationBar) view.findViewById(d.person_more_navigation_bar);
            BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(d.person_more_listview);
            this.f23504c = bdTypeListView;
            this.f23505d = new c.a.r0.s2.i.a(this.a, bdTypeListView, this.f23506e);
            b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23505d.a();
            SkinManager.setBackgroundColor(this.f23504c, c.a.r0.w2.a.CAM_X0201);
            this.f23503b.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f23504c.setData(list);
        }
    }

    public void f(d0<h> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) {
            this.f23506e = d0Var;
        }
    }
}
