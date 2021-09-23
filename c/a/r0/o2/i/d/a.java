package c.a.r0.o2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.r0.o2.c.n;
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
    public TbPageContext f23316a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23317b;

    /* renamed from: c  reason: collision with root package name */
    public View f23318c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f23319d;

    /* renamed from: e  reason: collision with root package name */
    public n f23320e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f23321f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f23322g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.q0.b f23323h;

    /* renamed from: i  reason: collision with root package name */
    public int f23324i;

    /* renamed from: c.a.r0.o2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1082a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1082a(a aVar, Context context) {
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
        public final /* synthetic */ a f23325a;

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
            this.f23325a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f23325a.f23323h == null) {
                    this.f23325a.f23323h = new c.a.q0.q0.b();
                    this.f23325a.f23323h.a(this.f23325a.f23324i);
                }
                if (i2 == 0) {
                    this.f23325a.f23323h.e();
                } else {
                    this.f23325a.f23323h.d();
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
        this.f23323h = null;
        this.f23324i = 1010;
        this.f23316a = tbPageContext;
        this.f23318c = view;
        this.f23321f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f23317b.addHeaderView(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23320e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23318c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23317b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f23318c.findViewById(R.id.new_person_center_common_lv);
            this.f23317b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1082a(this, bdTypeRecyclerView.getContext()));
            this.f23317b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f23316a.getPageActivity());
            this.f23319d = pbListView;
            pbListView.a();
            this.f23319d.o(R.color.CAM_X0205);
            this.f23319d.r(l.g(this.f23316a.getPageActivity(), R.dimen.tbds182));
            this.f23319d.v();
            this.f23319d.E(R.dimen.tbfontsize33);
            this.f23319d.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f23319d.y(R.color.CAM_X0110);
            n nVar = new n(this.f23316a, this.f23317b, this.f23321f.getUniqueId());
            this.f23320e = nVar;
            nVar.d(this.f23321f.isHost());
            this.f23320e.h(32);
            if (this.f23321f.isHost()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23321f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f23320e.f(i2);
                this.f23320e.g(this.f23321f.getTabType());
            }
            i2 = 0;
            this.f23320e.f(i2);
            this.f23320e.g(this.f23321f.getTabType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f23318c, R.color.CAM_X0201);
            n nVar = this.f23320e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f23322g;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f23316a, i2);
            }
            PbListView pbListView = this.f23319d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f23319d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.q0.q0.b bVar = this.f23323h;
            if (bVar != null) {
                bVar.c();
            }
            this.f23317b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23317b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f23317b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f23324i = i2;
        }
    }

    public void n(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f23317b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f23322g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f23317b.removeHeaderView(this.f23322g);
                }
            }
            this.f23317b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f23321f.getTabType())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23317b.setNextPage(this.f23319d);
            this.f23319d.J(0);
            this.f23319d.O();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f23321f.getTabType() == 1) {
                string = this.f23321f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f23321f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f23322g == null) {
                this.f23322g = NoDataViewFactory.a(this.f23316a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f23322g.onChangeSkinType(this.f23316a, TbadkApplication.getInst().getSkinType());
            this.f23322g.setVisibility(0);
            this.f23317b.removeHeaderView(this.f23322g);
            this.f23322g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f23317b.addHeaderView(this.f23322g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f23317b.setNextPage(this.f23319d);
            this.f23319d.J(0);
            this.f23319d.f();
            this.f23319d.A(this.f23316a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f23317b.setNextPage(this.f23319d);
            this.f23319d.J(0);
            this.f23319d.f();
            this.f23319d.A(this.f23316a.getString(i2));
        }
    }
}
