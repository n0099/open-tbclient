package b.a.r0.m2.i;

import android.view.View;
import b.a.e.l.e.n;
import b.a.r0.b0.c0;
import b.a.r0.n2.e.h;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f21204a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21205b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f21206c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.m2.i.a f21207d;

    /* renamed from: e  reason: collision with root package name */
    public c0<h> f21208e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21209e;

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
            this.f21209e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21209e.f21204a.getPageActivity().finish();
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
        this.f21204a = tbPageContext;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21205b.setCenterTextTitle(this.f21204a.getString(R.string.person_center_more));
            this.f21205b.showBottomLine();
            this.f21205b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f21205b.onChangeSkinType(this.f21204a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f21205b = (NavigationBar) view.findViewById(R.id.person_more_navigation_bar);
            BdTypeListView bdTypeListView = (BdTypeListView) view.findViewById(R.id.person_more_listview);
            this.f21206c = bdTypeListView;
            this.f21207d = new b.a.r0.m2.i.a(this.f21204a, bdTypeListView, this.f21208e);
            b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21207d.a();
            SkinManager.setBackgroundColor(this.f21206c, R.color.CAM_X0201);
            this.f21205b.onChangeSkinType(this.f21204a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f21206c.setData(list);
        }
    }

    public void f(c0<h> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c0Var) == null) {
            this.f21208e = c0Var;
        }
    }
}
