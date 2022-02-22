package c.a.u0.z2.j.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.u0.a3.d;
import c.a.u0.a3.g;
import c.a.u0.z2.c.n;
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
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f26089b;

    /* renamed from: c  reason: collision with root package name */
    public View f26090c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f26091d;

    /* renamed from: e  reason: collision with root package name */
    public n f26092e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f26093f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f26094g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.s0.b f26095h;

    /* renamed from: i  reason: collision with root package name */
    public int f26096i;

    /* renamed from: c.a.u0.z2.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1579a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1579a(a aVar, Context context) {
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

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.a.f26095h == null) {
                    this.a.f26095h = new c.a.t0.s0.b();
                    this.a.f26095h.a(this.a.f26096i);
                }
                if (i2 == 0) {
                    this.a.f26095h.e();
                } else {
                    this.a.f26095h.d();
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
        this.f26095h = null;
        this.f26096i = 1010;
        this.a = tbPageContext;
        this.f26090c = view;
        this.f26093f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f26089b.addHeaderView(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26092e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26090c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26089b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f26090c.findViewById(d.new_person_center_common_lv);
            this.f26089b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1579a(this, bdTypeRecyclerView.getContext()));
            this.f26089b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f26091d = pbListView;
            pbListView.a();
            this.f26091d.p(c.a.u0.a3.a.CAM_X0205);
            this.f26091d.t(c.a.d.f.p.n.f(this.a.getPageActivity(), c.a.u0.a3.b.tbds182));
            this.f26091d.y();
            this.f26091d.H(c.a.u0.a3.b.tbfontsize33);
            this.f26091d.F(SkinManager.getColor(c.a.u0.a3.a.CAM_X0107));
            this.f26091d.B(c.a.u0.a3.a.CAM_X0110);
            n nVar = new n(this.a, this.f26089b, this.f26093f.getUniqueId());
            this.f26092e = nVar;
            nVar.d(this.f26093f.isHost());
            this.f26092e.h(32);
            if (this.f26093f.isHost()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f26093f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f26092e.f(i2);
                this.f26092e.g(this.f26093f.getTabType());
            }
            i2 = 0;
            this.f26092e.f(i2);
            this.f26092e.g(this.f26093f.getTabType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f26090c, c.a.u0.a3.a.CAM_X0201);
            n nVar = this.f26092e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f26094g;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a, i2);
            }
            PbListView pbListView = this.f26091d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c.a.u0.a3.a.CAM_X0107));
                this.f26091d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.t0.s0.b bVar = this.f26095h;
            if (bVar != null) {
                bVar.c();
            }
            this.f26089b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26089b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f26089b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f26096i = i2;
        }
    }

    public void n(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f26089b.getHeaderViewsCount() == 0) {
                    p(g.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f26094g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f26089b.removeHeaderView(this.f26094g);
                }
            }
            this.f26089b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f26093f.getTabType())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f26089b.setNextPage(this.f26091d);
            this.f26091d.M(0);
            this.f26091d.R();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f26093f.getTabType() == 1) {
                string = this.f26093f.getResources().getString(g.person_center_listempty_dynamic_txt);
            } else {
                string = this.f26093f.getResources().getString(g.person_center_listempty_thread_txt);
            }
            if (this.f26094g == null) {
                this.f26094g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.a3.b.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f26094g.onChangeSkinType(this.a, TbadkApplication.getInst().getSkinType());
            this.f26094g.setVisibility(0);
            this.f26089b.removeHeaderView(this.f26094g);
            this.f26094g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f26089b.addHeaderView(this.f26094g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26089b.setNextPage(this.f26091d);
            this.f26091d.M(0);
            this.f26091d.f();
            this.f26091d.D(this.a.getString(g.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f26089b.setNextPage(this.f26091d);
            this.f26091d.M(0);
            this.f26091d.f();
            this.f26091d.D(this.a.getString(i2));
        }
    }
}
