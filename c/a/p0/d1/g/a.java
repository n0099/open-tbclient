package c.a.p0.d1.g;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.d.o.e.v;
import c.a.o0.f0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f13649b;

    /* renamed from: c  reason: collision with root package name */
    public g f13650c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f13651d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f13652e;

    /* renamed from: f  reason: collision with root package name */
    public LeftAdapter f13653f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f13654g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f13655h;
    public PbListView i;
    public c.a.p0.d1.e.a j;
    public BdListView.p k;
    public BdListView.p l;
    public final View m;

    /* renamed from: c.a.p0.d1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1029a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1029a(a aVar) {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f13654g != null) {
                    this.a.f13654g.stopScroll();
                }
                if (this.a.k != null) {
                    this.a.k.onScrollToBottom();
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new C1029a(this);
        this.a = tbPageContext;
        this.m = view;
        h();
        g();
    }

    public Pair<Integer, Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.f13654g.getFirstVisiblePosition();
            View childAt = this.f13654g.getChildAt(0);
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
        }
        return (Pair) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13653f.g() : (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13654g.setNextPage(null);
        }
    }

    public void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f13650c) == null) {
            return;
        }
        gVar.dettachView(this.f13649b);
        this.f13650c = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getPageActivity());
            this.f13652e = linearLayoutManager;
            this.f13651d.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.a.getPageActivity());
            this.f13653f = leftAdapter;
            this.f13651d.setAdapter(leftAdapter);
            this.j = new c.a.p0.d1.e.a(this.a, this.f13654g);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.a.getPageActivity());
            this.f13655h = linearLayoutManager2;
            this.f13654g.setLayoutManager(linearLayoutManager2);
            this.f13654g.setFadingEdgeLength(0);
            this.f13654g.setOverScrollMode(2);
            this.f13654g.setOnSrollToBottomListener(this.l);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.i = pbListView;
            pbListView.b();
            this.i.p(R.color.CAM_X0205);
            this.i.t(n.f(this.a.getPageActivity(), R.dimen.tbds182));
            this.i.y();
            this.i.H(R.dimen.tbfontsize33);
            this.i.F(SkinManager.getColor(R.color.CAM_X0107));
            this.i.B(R.color.CAM_X0110);
            this.i.s();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13649b = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f091aac);
            this.f13651d = (RecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091b08);
            this.f13654g = (BdTypeRecyclerView) this.m.findViewById(R.id.obfuscated_res_0x7f091b0b);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.f13650c;
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
            this.f13654g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, n.f(this.a.getPageActivity(), R.dimen.tbds62), 0, n.f(this.a.getPageActivity(), R.dimen.tbds362));
            this.i.D(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06a2));
            this.i.f();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f13654g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, 0, 0, 0);
            this.i.O();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f13654g.setNextPage(this.i);
            this.i.j();
            this.i.b().setPadding(0, 0, 0, 0);
            this.i.D(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0da7));
            this.i.f();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            c.a.p0.d1.e.a aVar = this.j;
            if (aVar != null) {
                aVar.b();
            }
            LeftAdapter leftAdapter = this.f13653f;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.i.d(i);
            }
            g gVar = this.f13650c;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
        }
    }

    public void n(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) || (bdTypeRecyclerView = this.f13654g) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.f13654g.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.f13654g.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void o(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.f13653f.j(position, list);
            if (z) {
                z(position);
            }
        }
    }

    public void p(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            q(list, 0);
        }
    }

    public void q(List<c.a.d.o.e.n> list, int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                r();
                return;
            }
            if (i > 0) {
                Pair<Integer, Integer> c2 = c();
                int intValue = ((Integer) c2.first).intValue();
                int intValue2 = ((Integer) c2.second).intValue();
                int i2 = intValue - i;
                if (this.f13655h != null && (bdTypeRecyclerView = this.f13654g) != null) {
                    bdTypeRecyclerView.A();
                    this.f13655h.scrollToPositionWithOffset(i2, intValue2);
                    this.f13654g.B();
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
            vVar.a = this.a.getString(R.string.obfuscated_res_0x7f0f06a3);
            vVar.f2642b = R.drawable.new_pic_emotion_06;
            arrayList.add(vVar);
            this.j.c(arrayList);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f13651d.setVisibility(i);
            this.f13654g.setVisibility(i);
        }
    }

    public void t(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (leftAdapter = this.f13653f) == null) {
            return;
        }
        leftAdapter.k(bVar);
    }

    public void u(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) || (bdTypeRecyclerView = this.f13654g) == null) {
            return;
        }
        bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
        this.f13654g.addOnScrollListener(onScrollListener);
    }

    public void v(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.k = pVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.f13654g.setVisibility(i);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        int f2 = this.f13653f.f(str);
        this.f13653f.l(f2);
        z(f2);
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || i()) {
            return;
        }
        if (this.f13650c == null) {
            g gVar = new g(this.a.getPageActivity());
            this.f13650c = gVar;
            gVar.s(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070287));
        }
        this.f13650c.onChangeSkinType();
        this.f13650c.attachView(this.f13649b, z);
    }

    public final void z(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && (recyclerView = this.f13651d) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f13651d.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.f13653f.getItemCount() - 1) {
                i = this.f13653f.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }
}
