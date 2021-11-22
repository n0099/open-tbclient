package b.a.r0.j3.k;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.v;
import b.a.q0.g0.g;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f20120a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f20121b;

    /* renamed from: c  reason: collision with root package name */
    public g f20122c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f20123d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f20124e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f20125f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f20126g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f20127h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f20128i;
    public b.a.r0.j3.e.a j;
    public BdListView.p k;
    public BdListView.p l;
    public final View m;

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20129e;

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
            this.f20129e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20129e.f20126g != null) {
                    this.f20129e.f20126g.stopScroll();
                }
                if (this.f20129e.k != null) {
                    this.f20129e.k.onScrollToBottom();
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
        this.f20120a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.f20126g.getFirstVisiblePosition();
            View childAt = this.f20126g.getChildAt(0);
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
        }
        return (Pair) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20125f.getSelected() : (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20126g.setNextPage(null);
        }
    }

    public void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f20122c) == null) {
            return;
        }
        gVar.dettachView(this.f20121b);
        this.f20122c = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f20120a.getPageActivity());
            this.f20124e = linearLayoutManager;
            this.f20123d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.f20120a.getPageActivity());
            this.f20125f = leftAdapter;
            this.f20123d.setAdapter(leftAdapter);
            this.j = new b.a.r0.j3.e.a(this.f20120a, this.f20126g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f20120a.getPageActivity());
            this.f20127h = linearLayoutManager2;
            this.f20126g.setLayoutManager(linearLayoutManager2);
            this.f20126g.setFadingEdgeLength(0);
            this.f20126g.setOverScrollMode(2);
            this.f20126g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.f20120a.getPageActivity());
            this.f20128i = pbListView;
            pbListView.b();
            this.f20128i.p(R.color.CAM_X0205);
            this.f20128i.s(l.g(this.f20120a.getPageActivity(), R.dimen.tbds182));
            this.f20128i.x();
            this.f20128i.G(R.dimen.tbfontsize33);
            this.f20128i.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f20128i.A(R.color.CAM_X0110);
            this.f20128i.r();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f20121b = (RelativeLayout) this.m.findViewById(R.id.right_container);
            this.f20123d = (RecyclerView) this.m.findViewById(R.id.rv_left);
            this.f20126g = (BdTypeRecyclerView) this.m.findViewById(R.id.rv_right);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.f20122c;
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
            this.f20126g.setNextPage(this.f20128i);
            this.f20128i.j();
            this.f20128i.b().setPadding(0, l.g(this.f20120a.getPageActivity(), R.dimen.tbds62), 0, l.g(this.f20120a.getPageActivity(), R.dimen.tbds362));
            this.f20128i.C(this.f20120a.getPageActivity().getString(R.string.forum_square_list_has_no_more));
            this.f20128i.f();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20126g.setNextPage(this.f20128i);
            this.f20128i.j();
            this.f20128i.b().setPadding(0, 0, 0, 0);
            this.f20128i.N();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f20126g.setNextPage(this.f20128i);
            this.f20128i.j();
            this.f20128i.b().setPadding(0, 0, 0, 0);
            this.f20128i.C(this.f20120a.getPageActivity().getString(R.string.pb_load_more));
            this.f20128i.f();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            b.a.r0.j3.e.a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            LeftAdapter leftAdapter = this.f20125f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.f20128i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f20128i.d(i2);
            }
            g gVar = this.f20122c;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
        }
    }

    public void n(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (bdTypeRecyclerView = this.f20126g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i2 > this.f20126g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f20126g.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f20125f.setData(position, list);
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
                if (this.f20127h != null && (bdTypeRecyclerView = this.f20126g) != null) {
                    bdTypeRecyclerView.startInterceptLayout();
                    this.f20127h.scrollToPositionWithOffset(i3, intValue2);
                    this.f20126g.stopIntercerceptLayout();
                }
            }
            this.j.c(list);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f2518e = this.f20120a.getString(R.string.forum_square_list_no_data);
            vVar.f2519f = R.drawable.new_pic_emotion_06;
            arrayList.add(vVar);
            this.j.c(arrayList);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f20123d.setVisibility(i2);
            this.f20126g.setVisibility(i2);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (leftAdapter = this.f20125f) == null) {
            return;
        }
        leftAdapter.setOnItemClickListener(bVar);
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) || (bdTypeRecyclerView = this.f20126g) == null) {
            return;
        }
        bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
        this.f20126g.addOnScrollListener(onScrollListener);
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f20126g.setVisibility(i2);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        int positionByItem = this.f20125f.getPositionByItem(str);
        this.f20125f.setSelectPosition(positionByItem);
        z(positionByItem);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || i()) {
            return;
        }
        if (this.f20122c == null) {
            g gVar = new g(this.f20120a.getPageActivity());
            this.f20122c = gVar;
            gVar.q(this.f20120a.getResources().getDimensionPixelSize(R.dimen.ds270));
        }
        this.f20122c.onChangeSkinType();
        this.f20122c.attachView(this.f20121b, z);
    }

    public final void z(int i2) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && (recyclerView = this.f20123d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f20123d.getLayoutManager();
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > this.f20125f.getItemCount() - 1) {
                i2 = this.f20125f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i2, 0);
        }
    }
}
