package c.a.p0.b3.j.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.b3.c.n;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f12793b;

    /* renamed from: c  reason: collision with root package name */
    public View f12794c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f12795d;

    /* renamed from: e  reason: collision with root package name */
    public n f12796e;

    /* renamed from: f  reason: collision with root package name */
    public PersonCenterTabBaseFragment f12797f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f12798g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r0.b f12799h;
    public int i;

    /* renamed from: c.a.p0.b3.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0963a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0963a(a aVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.f12799h == null) {
                    this.a.f12799h = new c.a.o0.r0.b();
                    this.a.f12799h.a(this.a.i);
                }
                if (i == 0) {
                    this.a.f12799h.e();
                } else {
                    this.a.f12799h.d();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12799h = null;
        this.i = 1010;
        this.a = tbPageContext;
        this.f12794c = view;
        this.f12797f = personCenterTabBaseFragment;
        h();
    }

    public void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f12793b.s(view);
        }
    }

    public n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12796e : (n) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12794c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12793b.setNextPage(null);
        }
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f12794c.findViewById(R.id.obfuscated_res_0x7f091554);
            this.f12793b = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new C0963a(this, bdTypeRecyclerView.getContext()));
            this.f12793b.addOnScrollListener(new b(this));
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f12795d = pbListView;
            pbListView.a();
            this.f12795d.p(R.color.CAM_X0205);
            this.f12795d.t(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds182));
            this.f12795d.y();
            this.f12795d.H(R.dimen.tbfontsize33);
            this.f12795d.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f12795d.B(R.color.CAM_X0110);
            n nVar = new n(this.a, this.f12793b, this.f12797f.getUniqueId());
            this.f12796e = nVar;
            nVar.d(this.f12797f.E0());
            this.f12796e.h(32);
            if (this.f12797f.E0()) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f12797f;
                if (personCenterTabBaseFragment instanceof PersonCenterDynamicTabFragment) {
                    i = 4;
                } else if (personCenterTabBaseFragment instanceof PersonCenterThreadTabFragment) {
                    i = 6;
                }
                this.f12796e.f(i);
                this.f12796e.g(this.f12797f.D0());
            }
            i = 0;
            this.f12796e.f(i);
            this.f12796e.g(this.f12797f.D0());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setBackgroundResource(this.f12794c, R.color.CAM_X0201);
            n nVar = this.f12796e;
            if (nVar != null) {
                nVar.b();
            }
            NoDataView noDataView = this.f12798g;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
            PbListView pbListView = this.f12795d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f12795d.d(i);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.o0.r0.b bVar = this.f12799h;
            if (bVar != null) {
                bVar.c();
            }
            this.f12793b.setOnSrollToBottomListener(null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f12793b.smoothScrollToPosition(0);
        }
    }

    public void l(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f12793b.setOnSrollToBottomListener(pVar);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.i = i;
        }
    }

    public void n(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                g();
                if (this.f12793b.getHeaderViewsCount() == 0) {
                    p(R.string.obfuscated_res_0x7f0f0deb);
                }
            } else {
                NoDataView noDataView = this.f12798g;
                if (noDataView != null && noDataView.getParent() != null) {
                    this.f12793b.removeHeaderView(this.f12798g);
                }
            }
            this.f12793b.setData(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.f12797f.D0())));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f12793b.setNextPage(this.f12795d);
            this.f12795d.M(0);
            this.f12795d.R();
        }
    }

    public final void p(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.f12797f.D0() == 1) {
                string = this.f12797f.getResources().getString(R.string.obfuscated_res_0x7f0f0de9);
            } else {
                string = this.f12797f.getResources().getString(R.string.obfuscated_res_0x7f0f0dea);
            }
            if (this.f12798g == null) {
                this.f12798g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070259)), NoDataViewFactory.e.d(null, string), null);
            }
            this.f12798g.f(this.a, TbadkApplication.getInst().getSkinType());
            this.f12798g.setVisibility(0);
            this.f12793b.removeHeaderView(this.f12798g);
            this.f12798g.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f12793b.s(this.f12798g);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f12793b.setNextPage(this.f12795d);
            this.f12795d.M(0);
            this.f12795d.f();
            this.f12795d.D(this.a.getString(R.string.obfuscated_res_0x7f0f09e8));
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f12793b.setNextPage(this.f12795d);
            this.f12795d.M(0);
            this.f12795d.f();
            this.f12795d.D(this.a.getString(i));
        }
    }
}
