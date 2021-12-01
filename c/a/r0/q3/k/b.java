package c.a.r0.q3.k;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.d.m.e.v;
import c.a.q0.g0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f22761b;

    /* renamed from: c  reason: collision with root package name */
    public g f22762c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f22763d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f22764e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f22765f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f22766g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f22767h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22768i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.q3.e.a f22769j;

    /* renamed from: k  reason: collision with root package name */
    public BdListView.p f22770k;
    public BdListView.p l;
    public final View m;

    /* loaded from: classes6.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22771e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22771e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f22771e.f22766g != null) {
                    this.f22771e.f22766g.stopScroll();
                }
                if (this.f22771e.f22770k != null) {
                    this.f22771e.f22770k.onScrollToBottom();
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.f22766g.getFirstVisiblePosition();
            View childAt = this.f22766g.getChildAt(0);
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
        }
        return (Pair) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22765f.getSelected() : (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22766g.setNextPage(null);
        }
    }

    public void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f22762c) == null) {
            return;
        }
        gVar.dettachView(this.f22761b);
        this.f22762c = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getPageActivity());
            this.f22764e = linearLayoutManager;
            this.f22763d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.a.getPageActivity());
            this.f22765f = leftAdapter;
            this.f22763d.setAdapter(leftAdapter);
            this.f22769j = new c.a.r0.q3.e.a(this.a, this.f22766g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.a.getPageActivity());
            this.f22767h = linearLayoutManager2;
            this.f22766g.setLayoutManager(linearLayoutManager2);
            this.f22766g.setFadingEdgeLength(0);
            this.f22766g.setOverScrollMode(2);
            this.f22766g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f22768i = pbListView;
            pbListView.b();
            this.f22768i.p(R.color.CAM_X0205);
            this.f22768i.s(l.f(this.a.getPageActivity(), R.dimen.tbds182));
            this.f22768i.x();
            this.f22768i.G(R.dimen.tbfontsize33);
            this.f22768i.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f22768i.A(R.color.CAM_X0110);
            this.f22768i.r();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f22761b = (RelativeLayout) this.m.findViewById(R.id.right_container);
            this.f22763d = (RecyclerView) this.m.findViewById(R.id.rv_left);
            this.f22766g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.f22762c;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f22766g.setNextPage(this.f22768i);
            this.f22768i.j();
            this.f22768i.b().setPadding(0, l.f(this.a.getPageActivity(), R.dimen.tbds62), 0, l.f(this.a.getPageActivity(), R.dimen.tbds362));
            this.f22768i.C(this.a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
            this.f22768i.f();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22766g.setNextPage(this.f22768i);
            this.f22768i.j();
            this.f22768i.b().setPadding(0, 0, 0, 0);
            this.f22768i.N();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f22766g.setNextPage(this.f22768i);
            this.f22768i.j();
            this.f22768i.b().setPadding(0, 0, 0, 0);
            this.f22768i.C(this.a.getPageActivity().getString(R.string.pb_load_more));
            this.f22768i.f();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            c.a.r0.q3.e.a aVar = this.f22769j;
            if (aVar != null) {
                aVar.b();
            }
            LeftAdapter leftAdapter = this.f22765f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.f22768i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f22768i.d(i2);
            }
            g gVar = this.f22762c;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (bdTypeRecyclerView = this.f22766g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f22766g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f22766g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f22765f.setData(position, list);
            if (z) {
                z(position);
            }
        }
    }

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            q(list, 0);
        }
    }

    public void q(List<n> list, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                r();
                return;
            }
            if (i2 > 0) {
                Pair<Integer, Integer> c2 = c();
                int intValue = ((Integer) c2.first).intValue();
                int intValue2 = ((Integer) c2.second).intValue();
                int i3 = intValue - i2;
                if (this.f22767h != null && (bdTypeRecyclerView = this.f22766g) != null) {
                    bdTypeRecyclerView.startInterceptLayout();
                    this.f22767h.scrollToPositionWithOffset(i3, intValue2);
                    this.f22766g.stopIntercerceptLayout();
                }
            }
            this.f22769j.c(list);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f3004e = this.a.getString(R.string.forum_square_list_no_data);
            vVar.f3005f = R.drawable.new_pic_emotion_06;
            arrayList.add(vVar);
            this.f22769j.c(arrayList);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f22763d.setVisibility(i2);
            this.f22766g.setVisibility(i2);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (leftAdapter = this.f22765f) == null) {
            return;
        }
        leftAdapter.setOnItemClickListener(bVar);
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) || (bdTypeRecyclerView = this.f22766g) == null) {
            return;
        }
        bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
        this.f22766g.addOnScrollListener(onScrollListener);
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.f22770k = pVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f22766g.setVisibility(i2);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        int positionByItem = this.f22765f.getPositionByItem(str);
        this.f22765f.setSelectPosition(positionByItem);
        z(positionByItem);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || i()) {
            return;
        }
        if (this.f22762c == null) {
            g gVar = new g(this.a.getPageActivity());
            this.f22762c = gVar;
            gVar.q(this.a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f22762c.onChangeSkinType();
        this.f22762c.attachView(this.f22761b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && (recyclerView = this.f22763d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f22763d.getLayoutManager();
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > this.f22765f.getItemCount() - 1) {
                i2 = this.f22765f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i2, 0);
        }
    }
}
