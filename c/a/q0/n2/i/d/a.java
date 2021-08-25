package c.a.q0.n2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.q0.n2.c.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22719a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f22720b;

    /* renamed from: c  reason: collision with root package name */
    public View f22721c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f22722d;

    /* renamed from: e  reason: collision with root package name */
    public n f22723e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f22724f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f22725g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.o0.b f22726h;

    /* renamed from: i  reason: collision with root package name */
    public int f22727i;

    /* renamed from: c.a.q0.n2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1051a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1051a(a aVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22728a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22728a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f22728a.f22726h == null) {
                    this.f22728a.f22726h = new c.a.p0.o0.b();
                    this.f22728a.f22726h.a(this.f22728a.f22727i);
                }
                if (i2 == 0) {
                    this.f22728a.f22726h.e();
                } else {
                    this.f22728a.f22726h.d();
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, personCenterTabBaseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22726h = null;
        this.f22727i = 1010;
        this.f22719a = tbPageContext;
        this.f22721c = view;
        this.f22724f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f22720b.addHeaderView(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22723e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22721c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22720b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f22721c.findViewById(R.id.new_person_center_common_lv);
            this.f22720b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1051a(this, bdTypeRecyclerView.getContext()));
            this.f22720b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f22719a.getPageActivity());
            this.f22722d = pbListView;
            pbListView.a();
            this.f22722d.o(R.color.CAM_X0205);
            this.f22722d.r(l.g(this.f22719a.getPageActivity(), R.dimen.tbds182));
            this.f22722d.v();
            this.f22722d.E(R.dimen.tbfontsize33);
            this.f22722d.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f22722d.y(R.color.CAM_X0110);
            n nVar = new n(this.f22719a, this.f22720b, this.f22724f.getUniqueId());
            this.f22723e = nVar;
            nVar.d(this.f22724f.isHost());
            this.f22723e.h(32);
            if (this.f22724f.isHost()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f22724f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f22723e.f(i2);
                this.f22723e.g(this.f22724f.getTabType());
            }
            i2 = 0;
            this.f22723e.f(i2);
            this.f22723e.g(this.f22724f.getTabType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f22721c, R.color.CAM_X0201);
            n nVar = this.f22723e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f22725g;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f22719a, i2);
            }
            PbListView pbListView = this.f22722d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f22722d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.o0.b bVar = this.f22726h;
            if (bVar != null) {
                bVar.c();
            }
            this.f22720b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22720b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f22720b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f22727i = i2;
        }
    }

    public void n(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f22720b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f22725g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f22720b.removeHeaderView(this.f22725g);
                }
            }
            this.f22720b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f22724f.getTabType())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22720b.setNextPage(this.f22722d);
            this.f22722d.J(0);
            this.f22722d.O();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f22724f.getTabType() == 1) {
                string = this.f22724f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f22724f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f22725g == null) {
                this.f22725g = NoDataViewFactory.a(this.f22719a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f22725g.onChangeSkinType(this.f22719a, TbadkApplication.getInst().getSkinType());
            this.f22725g.setVisibility(0);
            this.f22720b.removeHeaderView(this.f22725g);
            this.f22725g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f22720b.addHeaderView(this.f22725g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f22720b.setNextPage(this.f22722d);
            this.f22722d.J(0);
            this.f22722d.f();
            this.f22722d.A(this.f22719a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f22720b.setNextPage(this.f22722d);
            this.f22722d.J(0);
            this.f22722d.f();
            this.f22722d.A(this.f22719a.getString(i2));
        }
    }
}
