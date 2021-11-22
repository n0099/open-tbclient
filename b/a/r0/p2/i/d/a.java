package b.a.r0.p2.i.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.r0.p2.c.n;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23865a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23866b;

    /* renamed from: c  reason: collision with root package name */
    public View f23867c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f23868d;

    /* renamed from: e  reason: collision with root package name */
    public n f23869e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f23870f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f23871g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.q0.b f23872h;

    /* renamed from: i  reason: collision with root package name */
    public int f23873i;

    /* renamed from: b.a.r0.p2.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1156a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1156a(a aVar, Context context) {
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

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23874a;

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
            this.f23874a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f23874a.f23872h == null) {
                    this.f23874a.f23872h = new b.a.q0.q0.b();
                    this.f23874a.f23872h.a(this.f23874a.f23873i);
                }
                if (i2 == 0) {
                    this.f23874a.f23872h.e();
                } else {
                    this.f23874a.f23872h.d();
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
        this.f23872h = null;
        this.f23873i = 1010;
        this.f23865a = tbPageContext;
        this.f23867c = view;
        this.f23870f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f23866b.addHeaderView(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23869e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23867c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23866b.setNextPage(null);
        }
    }

    public final void h() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f23867c.findViewById(R.id.new_person_center_common_lv);
            this.f23866b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C1156a(this, bdTypeRecyclerView.getContext()));
            this.f23866b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.f23865a.getPageActivity());
            this.f23868d = pbListView;
            pbListView.a();
            this.f23868d.p(R.color.CAM_X0205);
            this.f23868d.s(l.g(this.f23865a.getPageActivity(), R.dimen.tbds182));
            this.f23868d.x();
            this.f23868d.G(R.dimen.tbfontsize33);
            this.f23868d.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f23868d.A(R.color.CAM_X0110);
            n nVar = new n(this.f23865a, this.f23866b, this.f23870f.getUniqueId());
            this.f23869e = nVar;
            nVar.d(this.f23870f.isHost());
            this.f23869e.h(32);
            if (this.f23870f.isHost()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23870f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i2 = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i2 = 6;
                }
                this.f23869e.f(i2);
                this.f23869e.g(this.f23870f.getTabType());
            }
            i2 = 0;
            this.f23869e.f(i2);
            this.f23869e.g(this.f23870f.getTabType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundResource(this.f23867c, R.color.CAM_X0201);
            n nVar = this.f23869e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f23871g;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f23865a, i2);
            }
            PbListView pbListView = this.f23868d;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f23868d.d(i2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.q0.q0.b bVar = this.f23872h;
            if (bVar != null) {
                bVar.c();
            }
            this.f23866b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23866b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f23866b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f23873i = i2;
        }
    }

    public void n(List<b.a.e.m.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f23866b.getHeaderViewsCount() == 0) {
                    p(R.string.person_center_listempty_txt);
                }
            } else {
                NoDataView noDataView = this.f23871g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f23866b.removeHeaderView(this.f23871g);
                }
            }
            this.f23866b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f23870f.getTabType())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23866b.setNextPage(this.f23868d);
            this.f23868d.L(0);
            this.f23868d.Q();
        }
    }

    public final void p(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.f23870f.getTabType() == 1) {
                string = this.f23870f.getResources().getString(R.string.person_center_listempty_dynamic_txt);
            } else {
                string = this.f23870f.getResources().getString(R.string.person_center_listempty_thread_txt);
            }
            if (this.f23871g == null) {
                this.f23871g = NoDataViewFactory.a(this.f23865a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f23871g.onChangeSkinType(this.f23865a, TbadkApplication.getInst().getSkinType());
            this.f23871g.setVisibility(0);
            this.f23866b.removeHeaderView(this.f23871g);
            this.f23871g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f23866b.addHeaderView(this.f23871g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f23866b.setNextPage(this.f23868d);
            this.f23868d.L(0);
            this.f23868d.f();
            this.f23868d.C(this.f23865a.getString(R.string.list_no_more));
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f23866b.setNextPage(this.f23868d);
            this.f23868d.L(0);
            this.f23868d.f();
            this.f23868d.C(this.f23865a.getString(i2));
        }
    }
}
