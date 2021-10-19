package c.a.r0.p2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.r0.p2.c.n;
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
    public TbPageContext f23500a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23501b;

    /* renamed from: c  reason: collision with root package name */
    public View f23502c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f23503d;

    /* renamed from: e  reason: collision with root package name */
    public n f23504e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f23505f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f23506g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.q0.b f23507h;

    /* renamed from: i  reason: collision with root package name */
    public int f23508i;

    /* renamed from: c.a.r0.p2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1092a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1092a(a aVar, Context context) {
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
        public final /* synthetic */ a f23509a;

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
            this.f23509a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f23509a.f23507h == null) {
                    this.f23509a.f23507h = new c.a.q0.q0.b();
                    this.f23509a.f23507h.a(this.f23509a.f23508i);
                }
                if (i2 == 0) {
                    this.f23509a.f23507h.e();
                } else {
                    this.f23509a.f23507h.d();
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
        this.f23507h = null;
        this.f23508i = 1010;
        this.f23500a = tbPageContext;
        this.f23502c = view;
        this.f23505f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f23501b.addHeaderView(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23504e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23502c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23501b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f23502c.findViewById(R.id.new_person_center_common_lv);
            this.f23501b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1092a(this, bdTypeRecyclerView.getContext()));
            this.f23501b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f23500a.getPageActivity());
            this.f23503d = pbListView;
            pbListView.a();
            this.f23503d.o(R.color.CAM_X0205);
            this.f23503d.r(l.g(this.f23500a.getPageActivity(), R.dimen.tbds182));
            this.f23503d.v();
            this.f23503d.E(R.dimen.tbfontsize33);
            this.f23503d.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f23503d.y(R.color.CAM_X0110);
            n nVar = new n(this.f23500a, this.f23501b, this.f23505f.getUniqueId());
            this.f23504e = nVar;
            nVar.d(this.f23505f.isHost());
            this.f23504e.h(32);
            if (this.f23505f.isHost()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23505f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f23504e.f(i2);
                this.f23504e.g(this.f23505f.getTabType());
            }
            i2 = 0;
            this.f23504e.f(i2);
            this.f23504e.g(this.f23505f.getTabType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f23502c, R.color.CAM_X0201);
            n nVar = this.f23504e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f23506g;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f23500a, i2);
            }
            PbListView pbListView = this.f23503d;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f23503d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.q0.q0.b bVar = this.f23507h;
            if (bVar != null) {
                bVar.c();
            }
            this.f23501b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23501b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f23501b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f23508i = i2;
        }
    }

    public void n(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f23501b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f23506g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f23501b.removeHeaderView(this.f23506g);
                }
            }
            this.f23501b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f23505f.getTabType())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23501b.setNextPage(this.f23503d);
            this.f23503d.J(0);
            this.f23503d.O();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f23505f.getTabType() == 1) {
                string = this.f23505f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f23505f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f23506g == null) {
                this.f23506g = NoDataViewFactory.a(this.f23500a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f23506g.onChangeSkinType(this.f23500a, TbadkApplication.getInst().getSkinType());
            this.f23506g.setVisibility(0);
            this.f23501b.removeHeaderView(this.f23506g);
            this.f23506g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f23501b.addHeaderView(this.f23506g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f23501b.setNextPage(this.f23503d);
            this.f23503d.J(0);
            this.f23503d.f();
            this.f23503d.A(this.f23500a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f23501b.setNextPage(this.f23503d);
            this.f23503d.J(0);
            this.f23503d.f();
            this.f23503d.A(this.f23500a.getString(i2));
        }
    }
}
